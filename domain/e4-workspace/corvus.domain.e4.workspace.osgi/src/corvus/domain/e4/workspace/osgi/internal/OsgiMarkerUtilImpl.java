/**
 * 
 */
package corvus.domain.e4.workspace.osgi.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.osgi.service.component.annotations.Component;

import com.google.inject.Injector;

import corvus.domain.e4.workspace.AbstractOsgiInjectedDelegateComponent;
import corvus.domain.e4.workspace.MarkerUtil;
import corvus.domain.e4.workspace.d2m.D2mInjectorProvider;
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
	public IMarker getMarkerAtSelection(IResource resource, String markerType, int charStart, int charEnd) {
		return delegate.getMarkerAtSelection(resource, markerType, charStart, charEnd);
	}

	@Override
	protected Injector getInjector() {
		return D2mInjectorProvider.getInjector();
	}

}
