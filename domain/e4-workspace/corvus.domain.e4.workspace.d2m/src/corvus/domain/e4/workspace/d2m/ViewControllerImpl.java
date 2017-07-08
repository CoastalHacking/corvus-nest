package corvus.domain.e4.workspace.d2m;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

import corvus.domain.e4.workspace.ICompositeProvider;
import corvus.domain.e4.workspace.MarkerUtil;
import corvus.domain.e4.workspace.ViewController;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.TextMarker;

public class ViewControllerImpl implements ViewController {

	@Inject
	protected MarkerUtil markerUtil;

	@Inject
	Resource resource;

	@Inject
	TransactionalEditingDomain ted;

	@Override
	public ICompositeProvider getCompositeProvider(IMarker marker) {
		ICompositeProvider result = null;

		// Expected to return non-null value
		final IWorkspaceRoot workspaceRoot = markerUtil.createBranchFromMarker(marker);
		ComparisonResourcesSwitch comparisonSwitch = new ComparisonResourcesSwitch(workspaceRoot);
		TextMarker textMarker = null;

		try {
			textMarker = (TextMarker)ted.runExclusive(new RunnableWithResult.Impl<TextMarker>() {

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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (textMarker != null) {
			EObject domain = textMarker.getDomain();
			Adapter adapter = EcoreUtil.getExistingAdapter(domain, ICompositeProvider.class);
			if (adapter != null && adapter instanceof ICompositeProvider)
				result = (ICompositeProvider)adapter;
		}
		return result;
	}
	


}
