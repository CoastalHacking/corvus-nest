package corvus.domain.e4.workspace.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorPart;

import corvus.domain.e4.workspace.MarkerUtil;

public class UIUtil {

	public static IMarker getMarker(MarkerUtil markerUtil, String markerType, IEditorPart editorPart, ITextSelection textSelection) {
		IMarker result = null;
		final IResource resource = Adapters.adapt(editorPart.getEditorInput(), IResource.class);
		if (resource != null && resource.exists()) {
			final int charStart = textSelection.getOffset();
			final int charEnd = textSelection.getOffset() + textSelection.getLength();
			result = markerUtil.getMarkerAtSelection(resource, markerType, charStart, charEnd);
		}
		return result;
	}
}
