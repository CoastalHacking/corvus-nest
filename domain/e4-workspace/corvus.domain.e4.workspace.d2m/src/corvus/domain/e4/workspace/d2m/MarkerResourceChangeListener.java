/**
 * 
 */
package corvus.domain.e4.workspace.d2m;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import corvus.domain.org.eclipse.core.resources.ResourcesConstants;

/**
 * 
 * Make this instance injectable and obtain it from the injector
 * From the activator start, obtain this instance and obtain the workspace
 * from stop, remove obtained instance from workspace 
 *
 */
@Singleton
public class MarkerResourceChangeListener implements IResourceChangeListener {

	@Inject
	MarkerController markerController;
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		switch (event.getType()) {
		case IResourceChangeEvent.POST_CHANGE:
			final IMarkerDelta[] deltas = event.findMarkerDeltas(ResourcesConstants.MARKER_TYPE, false);
			if (deltas != null && deltas.length != 0) {
				for (IMarkerDelta delta : deltas) {
					final IMarker marker = delta.getMarker();
					switch (delta.getKind()) {
					case (IResourceDelta.ADDED):
						handleMarkerAdd(marker);
						break;
					case (IResourceDelta.CHANGED):
						handleMarkerChange(marker);
						break;
					case (IResourceDelta.REMOVED):
						handleMarkerDelete(marker);
						break;
					default:
						// should be dead code
						throw new IllegalArgumentException("Unsupported delta kind: " + delta.getKind());
					}
				}
			}

			break;
		default:
			break;
		}
	}

	protected void handleMarkerDelete(IMarker marker) {
		markerController.markerRemoved(marker);
	}

	protected void handleMarkerAdd(IMarker marker) {
		markerController.markerAdded(marker);
	}

	protected void handleMarkerChange(IMarker marker) {
		markerController.markerChanged(marker);
	}
}
