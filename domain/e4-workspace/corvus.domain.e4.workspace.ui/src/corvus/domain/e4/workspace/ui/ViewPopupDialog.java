package corvus.domain.e4.workspace.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import corvus.domain.e4.workspace.ICompositeProvider;

public class ViewPopupDialog extends AbstractPopupDialog {

	protected ViewPopupDialog(Shell parent, String titleText, String infoText, ICompositeProvider compositeProvider) {
		super(parent, titleText, infoText, compositeProvider);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.PopupDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// TODO Auto-generated method stub
		Composite result = (Composite) super.createDialogArea(parent);
		compositeProvider.getFormComposite(result);
		return result;
	}

}
