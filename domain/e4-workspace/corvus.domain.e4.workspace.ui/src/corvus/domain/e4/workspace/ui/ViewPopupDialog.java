package corvus.domain.e4.workspace.ui;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import corvus.domain.e4.workspace.ICompositeProvider;

public class ViewPopupDialog extends PopupDialog {

	private ICompositeProvider compositeProvider;
	
	public ViewPopupDialog(Shell parent, String titleText, String infoText, ICompositeProvider compositeProvider) {
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

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.PopupDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// TODO Auto-generated method stub
		Composite result = (Composite) super.createDialogArea(parent);
		Composite composite = compositeProvider.getFormComposite(result);
		return result;
	}

}
