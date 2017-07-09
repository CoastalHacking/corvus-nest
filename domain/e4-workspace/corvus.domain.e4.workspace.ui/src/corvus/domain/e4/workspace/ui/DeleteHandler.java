package corvus.domain.e4.workspace.ui;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorPart;

import corvus.domain.e4.workspace.MarkerUtil;;

public class DeleteHandler {

	@Inject
	private MarkerUtil markerUtil;

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) ITextSelection textSelection,
			IEditorPart editorPart,
			@Named(UIConstants.COMMAND_PARAM) String markerType) {

		IMarker marker = UIUtil.getMarker(markerUtil, markerType, editorPart, textSelection);

		if (marker != null) {
			WorkspaceJob job = new WorkspaceJob("Delete existing marker: " + marker) {

				@Override
				public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
					marker.delete();
					return Status.OK_STATUS;
				}
				
			};
			job.setRule(marker.getResource());
			job.schedule();

		}
	}

}
