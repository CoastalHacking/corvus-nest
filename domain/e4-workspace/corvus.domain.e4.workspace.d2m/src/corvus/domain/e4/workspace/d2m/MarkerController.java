package corvus.domain.e4.workspace.d2m;

import org.eclipse.core.resources.IMarker;

public interface MarkerController {

	public void markerAdded(IMarker marker);

	public void markerRemoved(IMarker marker);

	public void markerChanged(IMarker marker);
}
