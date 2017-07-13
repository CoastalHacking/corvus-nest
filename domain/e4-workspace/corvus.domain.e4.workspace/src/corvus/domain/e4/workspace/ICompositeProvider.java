package corvus.domain.e4.workspace;

import org.eclipse.emf.parsley.composite.TreeFormComposite;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public interface ICompositeProvider {

	public default Composite getFormComposite(Composite parent) {
		return getFormComposite(parent, SWT.NONE);
	}

	public Composite getFormComposite(Composite parent, int style);

	public Dialog getEditableDialog(Shell shell, String title);

	public TreeViewer createTreeViewerWithColumns(Composite parent);

	/*
	 * test tree form 
	 */
	public TreeFormComposite createTreeFormComposite(Composite parent, int style);

	/*
	 * Consider moving these tidbits and ones maybe above to parsley
	 */
	public TreeColumnComposite createTreeColumnComposite(Composite parent, int style);
}
