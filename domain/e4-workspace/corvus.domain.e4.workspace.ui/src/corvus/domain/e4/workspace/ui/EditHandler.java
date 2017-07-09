package corvus.domain.e4.workspace.ui;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IMarker;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;

import corvus.domain.e4.workspace.ICompositeProvider;
import corvus.domain.e4.workspace.MarkerUtil;
import corvus.domain.e4.workspace.ViewController;

public class EditHandler {

	@Inject
	private MarkerUtil markerUtil;

	@Inject
	private ViewController viewController;

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Named(IServiceConstants.ACTIVE_SELECTION) ITextSelection textSelection,
			IEditorPart editorPart,
			@Named(UIConstants.COMMAND_PARAM) String markerType) {

		IMarker marker = UIUtil.getMarker(markerUtil, markerType, editorPart, textSelection);

		if (marker != null) {
			ICompositeProvider compositeProvider = viewController.getCompositeProvider(marker);
			if (compositeProvider != null) {
				Dialog dialog = compositeProvider.getEditableDialog(shell, markerType);
				dialog.open();
			}
		}
	}


}
