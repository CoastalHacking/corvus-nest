package corvus.domain.e4.workspace.ui;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.widgets.Shell;

import corvus.domain.e4.workspace.ICompositeProvider;

public class ViewTreeHandler extends ViewHandler {

	protected PopupDialog createPopup(Shell parent, String titleText, String infoText, ICompositeProvider compositeProvider) {
		return new ViewTreePopupDialog(parent, titleText, infoText, compositeProvider);
	}

}
