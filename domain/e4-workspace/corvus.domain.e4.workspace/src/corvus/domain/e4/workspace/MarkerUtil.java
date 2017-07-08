package corvus.domain.e4.workspace;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;

import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;

public interface MarkerUtil {

	/**
	 * 
	 * @param marker
	 * @return
	 */
	public IWorkspaceRoot createBranchFromMarker(IMarker marker);

	/**
	 * 
	 * @param resource
	 * @param charStart
	 * @param charEnd
	 * @return
	 */
	public IMarker getMarkerAtSelection(IResource resource, String markerType, int charStart, int charEnd);
}
