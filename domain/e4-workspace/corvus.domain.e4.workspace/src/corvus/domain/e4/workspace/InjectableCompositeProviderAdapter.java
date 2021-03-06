package corvus.domain.e4.workspace;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.parsley.composite.FormDetailReadOnlyComposite;
import org.eclipse.emf.parsley.composite.FormFactory;
import org.eclipse.emf.parsley.composite.TreeFormComposite;
import org.eclipse.emf.parsley.composite.TreeFormFactory;
import org.eclipse.emf.parsley.dialogs.DialogFactory;
import org.eclipse.emf.parsley.viewers.ViewerFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.google.inject.Inject;

public class InjectableCompositeProviderAdapter
	extends AdapterImpl
	implements ICompositeProviderAdapter {

	@Inject
	protected FormFactory formFactory;

	@Inject
	protected DialogFactory dialogFactory;

	@Inject
	protected EditingDomain editingDomain;

	@Inject
	protected ViewerFactory viewerFactory;

	@Inject
	protected TreeColumnFactory treeColumnFactory;

	@Inject
	protected TreeFormFactory treeFormFactory;

	public InjectableCompositeProviderAdapter() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == ICompositeProvider.class;
	}

	@Override
	public Composite getFormComposite(Composite parent, int style) {
		final FormDetailReadOnlyComposite result = formFactory.createFormDetailReadOnlyComposite(parent, style);
		result.init((EObject)getTarget());
		return result;
	}

	@Override
	public Dialog getEditableDialog(Shell shell, String title) {
		Dialog dialog = dialogFactory.createDetailDialog(shell, title, (EObject)getTarget(), editingDomain);
		return dialog;
	}

	// inject TableFeaturesProvider to specialize which features are returned
	// todo: delete me
	@Override
	public TreeViewer createTreeViewerWithColumns(Composite parent) {
		final EObject target = (EObject)getTarget();
		final TreeViewer treeViewer = viewerFactory.createTreeViewerWithColumns(parent, target.eClass(), target);
		return treeViewer;
	}

	@Override
	public TreeColumnComposite createTreeColumnComposite(Composite parent, int style) {
		TreeColumnComposite composite = treeColumnFactory.createTreeColumnComposite(parent, style);
		composite.update(getTarget());
		return composite;
	}

	@Override
	public TreeFormComposite createTreeFormComposite(Composite parent, int style) {
		TreeFormComposite composite = treeFormFactory.createTreeFormComposite(parent, style);
		composite.update(getTarget());
		return composite;
	}
}
