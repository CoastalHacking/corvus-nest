package corvus.domain.e4.workspace;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.parsley.composite.TreeFormComposite;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class TreeColumnComposite extends TreeFormComposite {
	

	public TreeColumnComposite(Composite parent, int style, int sashStyle, int[] weights) {
		super(parent, style, sashStyle, weights);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.parsley.composite.TreeFormComposite#createViewer(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected StructuredViewer createViewer(Composite parent) {
		// Simulates viewerFactory.createTreeViewerWithColumns
		Composite viewerContainer = new Composite(parent, SWT.NONE);
		TreeColumnLayout layout = new TreeColumnLayout();
		viewerContainer.setLayout(layout);
		TreeViewer treeViewer = new TreeViewer(viewerContainer,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		return treeViewer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.parsley.composite.TreeFormComposite#update(java.lang.Object)
	 */
	@Override
	public void update(Object element) {
		if (element != null && element instanceof EObject) {
			final EObject eObject = (EObject)element;
			getViewerFactory().initialize(getViewer(), eObject);
			getViewerFactory().buildColumns((TreeViewer)getViewer(), eObject.eClass());
		}

	}


}
