package corvus.domain.e4.workspace;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public interface ICompositeProvider {

	public default Composite getFormComposite(Composite parent) {
		return getFormComposite(parent, SWT.NONE);
	}

	public Composite getFormComposite(Composite parent, int style);

	public default Composite getEditableFormComposite(Composite parent) {
		return getEditableFormComposite(parent, SWT.NONE);
	}

	public Composite getEditableFormComposite(Composite parent, int style);
}
