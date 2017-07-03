package corvus.domain.e4.workspace.d2m;

import java.util.Collections;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;

/**
 * 
 * TODO: Consider replacing this code with a different strategy, maybe EMF Diff/Merge
 *
 */
public class MarkerControllerImpl implements MarkerController {

	// TODO: verify the resource is part of the editing domain
	@Inject
	Resource resource;
	
	@Inject
	TransactionalEditingDomain ted;

	@Inject
	MarkerUtil markerUtil;

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
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.d2m.MarkerController#markerChanged(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public void markerChanged(org.eclipse.core.resources.IMarker marker) {
		// TODO Auto-generated method stub
		
	}

	
}
