package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;

import com.google.inject.Inject;

import corvus.domain.e4.workspace.DefaultM2VNotificationsConsumer;
import corvus.resource.AdapterFactoryUtil;

public class M2VNotificationsConsumer extends DefaultM2VNotificationsConsumer {

	@Inject
	private LinkStructuredItemProviderFactory structuredFactory;

	@Inject
	private AdapterFactoryUtil factoryUtil;

	/* (non-Javadoc)
	 * @see corvus.domain.e4.workspace.DefaultM2VNotificationsConsumer#addNewValue(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	// make public accessor for testing
	public void addNewValue(EObject newValue) {
		// Call the super to add the component adapter
		super.addNewValue(newValue);

		factoryUtil.addOverrideAdapter(newValue, structuredFactory, IStructuredItemContentProvider.class);
	}

	public M2VNotificationsConsumer() {
		// TODO Auto-generated constructor stub
	}

}
