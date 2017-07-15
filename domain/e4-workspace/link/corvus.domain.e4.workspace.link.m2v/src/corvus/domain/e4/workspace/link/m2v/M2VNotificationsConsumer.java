package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

import corvus.domain.e4.workspace.DefaultM2VNotificationsConsumer;
import corvus.resource.AdapterFactoryUtil;

public class M2VNotificationsConsumer extends DefaultM2VNotificationsConsumer {

	@Inject
	private AdapterFactoryUtil factoryUtil;
	
	@Inject
	private Provider<StructuredItemContentAdapter> adapterProvider;

	/* (non-Javadoc)
	 * @see corvus.domain.e4.workspace.DefaultM2VNotificationsConsumer#addNewValue(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	// make public accessor for testing
	public void addNewValue(EObject newValue) {
		// Call the super to add the component adapter
		super.addNewValue(newValue);

		// TODO: delete this adapter in the future when this module is removed
		StructuredItemContentAdapter adapter = adapterProvider.get();
		factoryUtil.overrideAdapter(newValue, IStructuredItemContentProvider.class, adapter);
	}

	public M2VNotificationsConsumer() {
		// TODO Auto-generated constructor stub
	}

}
