package corvus.domain.e4.workspace.d2m;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;

import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;

public class MarkerControllerImpl implements MarkerController {

	@Inject
	Resource resource;

	@Inject
	MarkerUtil markerUtil;
	
	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.d2m.MarkerController#markerAdded(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public void markerAdded(org.eclipse.core.resources.IMarker marker) {

		IWorkspaceRoot workspaceRoot = markerUtil.createBranchFromMarker(marker);

		ComparisonResourcesSwitch visitor = new ComparisonResourcesSwitch(workspaceRoot);

		for (TreeIterator<EObject> iter = resource.getAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();
			if (visitor.doSwitch(eObject) == Boolean.FALSE) {

				// TODO HERE
				iter.prune();
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
