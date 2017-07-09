package corvus.domain.e4.workspace.d2m;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.parsley.resource.ResourceManager;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

import corvus.domain.e4.workspace.MarkerController;
import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.TextMarker;
import corvus.transactional.TransactionOptions;


// TODO: Consider replacing this code with a different strategy, maybe EMF Diff/Merge
// or Or URL Fragments...
public class MarkerControllerImpl implements MarkerController {
	
	// TODO: verify the resource is part of the editing domain
	@Inject
	Resource resource;
	
	@Inject
	ResourceManager resourceManager;
	
	@Inject
	TransactionalEditingDomain ted;

	@Inject
	MarkerUtilImpl markerUtil;
	
	@Inject
	TransactionOptions options;

	/* 
	 * This code is clunky
	 * 
	 * (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.d2m.MarkerController#markerAdded(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public void markerAdded(org.eclipse.core.resources.IMarker marker) {

		// Expected to return non-null value
		IWorkspaceRoot workspaceRoot = markerUtil.createBranchFromMarker(marker);

		// Find out which sub-branch need to be added from the branch
		ComparisonResourcesSwitch comparisonSwitch = new ComparisonResourcesSwitch(workspaceRoot);

		// TODO: perform the below in the read-write transaction
		// at a minimum it needs to be in a read-only transaction, however, it
		// could suffer a TOCTOU issue if the underlying value was concurrently changed
		for (TreeIterator<EObject> iter = resource.getAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();
			if (comparisonSwitch.doSwitch(eObject) == Boolean.FALSE) {
				iter.prune();
			}
		}

		// This object should have the contents above added to it
		EObject lastExistingObject = comparisonSwitch.getLastExistingObject();

		// Get items to add inclusively, testing first to avoid creating an empty transaction
		final TreeIterator<EObject> treeIterator = comparisonSwitch.getObjectsToAdd();
		if (treeIterator.hasNext()) {
			TransactionalCommandStack stack = (TransactionalCommandStack)ted.getCommandStack();

			// Construct an add switch
			AddResourcesSwitch addSwitch = new AddResourcesSwitch(lastExistingObject, resource);

			try {
				// Otherwise, add the elements via the switch, within a transaction
				stack.execute(new RecordingCommand(ted) {
					protected void doExecute() {
						while (treeIterator.hasNext()) {
							EObject eObject = treeIterator.next();

							// If at any time an add is not successful, prune to avoid
							// weird state
							if (!addSwitch.doSwitch(eObject)) {
								// TODO log at warning
								treeIterator.prune();
							}

							save();
						}
					}
				}, Collections.EMPTY_MAP);
			} catch (InterruptedException | RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.d2m.MarkerController#markerRemoved(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public void markerRemoved(org.eclipse.core.resources.IMarker marker) {
		// Expected to return non-null value
		IWorkspaceRoot workspaceRoot = markerUtil.createBranchFromMarker(marker);
		
		ComparisonResourcesSwitch comparisonSwitch = new ComparisonResourcesSwitch(workspaceRoot);

		final TextMarker existingTextMarker;
		try {
			existingTextMarker = (TextMarker) ted.runExclusive(new RunnableWithResult.Impl<TextMarker>() {
				@Override
				public void run() {
					final TreeIterator<EObject> iter = resource.getAllContents();
					while (iter.hasNext()) {
						EObject eObject = iter.next();
						if (comparisonSwitch.doSwitch(eObject) == Boolean.FALSE) {
							iter.prune();
						}
					}
					final EObject lastObject = comparisonSwitch.getLastExistingObject();
					if (lastObject != null && lastObject instanceof TextMarker) {
						setResult((TextMarker)lastObject);
					}
				}
			});

			if (existingTextMarker != null) {
				TransactionalCommandStack stack = (TransactionalCommandStack)ted.getCommandStack();
				try {
					// Otherwise, remove the elements, within a transaction
					stack.execute(new RecordingCommand(ted) {
						protected void doExecute() {

							// Ignore deleting the reference. It is up to the consumer to do this

							// Delete the marker 
							final IResource iResource = existingTextMarker.getResource();
							EcoreUtil.delete(existingTextMarker, /*recursive*/ true);

							// Delete the resource if applicable
							if (iResource.getMarkers().isEmpty()) {

								// Prepare to remove container if applicable
								IContainer iContainer;
								if (iResource instanceof IContainer) {
									// Pass to below loop so its members are checked
									iContainer = (IContainer)iResource;
								} else {
									// Otherwise set container from parent and delete resource
									iContainer = iResource.getParent();
									EcoreUtil.delete(iResource, /*recursive*/ true);
								}

								// Recursively delete containers if applicable
								while (!(iContainer instanceof IWorkspaceRoot) && iContainer.getMembers().isEmpty()) {
									IContainer child = iContainer;
									iContainer = child.getParent();
									EcoreUtil.delete(child, /*recursive*/ true);
								}
							}

							save();
						}
					}, options.get());
				} catch (InterruptedException | RollbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.d2m.MarkerController#markerChanged(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public void markerChanged(org.eclipse.core.resources.IMarker marker) {
		// TODO Auto-generated method stub
		
	}

	protected void save() {
		try {
			resourceManager.save(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
