 package corvus.domain.e4.workspace.ui;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorPart;

import corvus.domain.e4.workspace.MarkerUtil;

public class AddHandler {

	@Inject
	MarkerUtil markerUtil;

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) ITextSelection textSelection,
			IEditorPart editorPart,
			@Named(UIConstants.COMMAND_PARAM) String markerType) {

		final IResource resource = Adapters.adapt(editorPart.getEditorInput(), IResource.class);
		if (resource == null || !resource.exists()) {
			// TODO: debug log?
			return;
		}
		final int charStart = textSelection.getOffset();
		final int charEnd = textSelection.getOffset() + textSelection.getLength();
		IMarker marker = markerUtil.getMarkerAtSelection(resource, markerType, charStart, charEnd);

		if (marker == null) {
			final int lineNumber = textSelection.getStartLine();
			WorkspaceJob job = new WorkspaceJob("Add new marker") {

				@Override
				public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
					IMarker marker = resource.createMarker(markerType);
					marker.setAttribute(IMarker.CHAR_START, charStart);
					marker.setAttribute(IMarker.CHAR_END, charEnd);
					marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);

					return Status.OK_STATUS;
				}
				
			};
			job.setRule(resource);
			job.schedule();
		} else {
			// TODO: debug log? or maybe extend the marker?
		}
		

	}

}