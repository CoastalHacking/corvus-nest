/**
 * 
 */
package corvus.domain.e4.workspace.d2m;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.osgi.service.component.annotations.Component;

import corvus.domain.e4.workspace.MarkerUtil;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;

/**
 * 
 *
 */
@Component
public class OsgiMarkerUtilImpl
	extends AbstractOsgiInjectedDelegateComponent<MarkerUtil>
	implements MarkerUtil {

	public OsgiMarkerUtilImpl() {
		super();
		delegate = getDelegate(MarkerUtil.class);
	}

	/* (non-Javadoc)
	 * @see corvus.domain.e4.workspace.MarkerUtil#createBranchFromMarker(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public IWorkspaceRoot createBranchFromMarker(IMarker marker) {
		return delegate.createBranchFromMarker(marker);
	}

	/* (non-Javadoc)
	 * @see corvus.domain.e4.workspace.MarkerUtil#getMarkerAtSelection(org.eclipse.core.resources.IResource, int, int)
	 */
	@Override
	public IMarker getMarkerAtSelection(IResource resource, int charStart, int charEnd) {
		return delegate.getMarkerAtSelection(resource, charStart, charEnd);
	}

}
