package corvus.domain.e4.workspace;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.parsley.composite.FormDetailComposite;
import org.eclipse.emf.parsley.composite.FormDetailReadOnlyComposite;
import org.eclipse.emf.parsley.composite.FormFactory;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Inject;

public class InjectableCompositeProviderAdapter
	extends AdapterImpl
	implements ICompositeProviderAdapter {

	@Inject
	FormFactory formFactory;

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
	public Composite getEditableFormComposite(Composite parent, int style) {
		final FormDetailComposite result = formFactory.createFormDetailComposite(parent, style);
		result.init((EObject)getTarget());
		return result;
	}

}
