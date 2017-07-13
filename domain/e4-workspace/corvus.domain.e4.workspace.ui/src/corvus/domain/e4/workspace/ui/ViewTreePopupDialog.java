package corvus.domain.e4.workspace.ui;

import org.eclipse.emf.parsley.composite.TreeFormComposite;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import corvus.domain.e4.workspace.ICompositeProvider;
import corvus.domain.e4.workspace.TreeColumnComposite;

public class ViewTreePopupDialog extends AbstractPopupDialog {

	
	public ViewTreePopupDialog(Shell parent, String titleText, String infoText, ICompositeProvider compositeProvider) {
		super(parent, titleText, infoText, compositeProvider);
	}

	/* (non-Javadoc)
	 * @see corvus.domain.e4.workspace.ui.ViewPopupDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(dialogArea, SWT.NONE);
		container.setLayout(new GridLayout(1, false));

		// don't need the extra columns, disabling for now
		// TODO: delete the classes when done with experimenting
//		TreeColumnComposite treeColumnComposite = compositeProvider.createTreeColumnComposite(container, SWT.NONE);

		// Need to filter out the children somehow
		TreeFormComposite treeComposite = compositeProvider.createTreeFormComposite(container, SWT.NONE);

//		TreeViewer viewer = compositeProvider.createTreeViewerWithColumns(dialogArea);
		// http://www.vogella.com/tutorials/EclipseJFaceTree/article.html#adjusting-tree-columns-treecolumns-on-expand
//		viewer.getTree().addListener(SWT.Expand, new Listener() {
//
//			@Override
//			public void handleEvent(Event event) {
//				TreeItem treeItem = (TreeItem)event.item;
//				final TreeColumn[] treeColumns = treeItem.getParent().getColumns();
//				viewer.getTree().getDisplay().asyncExec(new Runnable() {
//
//					 @Override
//					 public void run() {
//					    for (TreeColumn treeColumn : treeColumns)
//					         treeColumn.pack();
//					 }
//				});
//			}
//		});

		treeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));

		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);

		return dialogArea;

	}

}
