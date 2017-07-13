package corvus.domain.e4.workspace.ui;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.widgets.Shell;

import corvus.domain.e4.workspace.ICompositeProvider;

public abstract class AbstractPopupDialog extends PopupDialog {

	protected ICompositeProvider compositeProvider;

	protected AbstractPopupDialog(Shell parent, String titleText, String infoText, ICompositeProvider compositeProvider) {
		super(parent,
				PopupDialog.INFOPOPUPRESIZE_SHELLSTYLE,
				/*takeFocusOnOpen*/ true,
				/*persistSize*/ false,
				/*persistLocation*/ false,
				/*showDialogMenu*/ false,
				/*showPersistActions*/ true,
				titleText,
				infoText);
		this.compositeProvider = compositeProvider;
	}

}
