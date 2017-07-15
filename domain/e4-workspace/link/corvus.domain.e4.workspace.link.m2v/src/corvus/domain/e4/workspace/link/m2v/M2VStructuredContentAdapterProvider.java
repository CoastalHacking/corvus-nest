package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;

public class M2VStructuredContentAdapterProvider implements Provider<StructuredItemContentAdapter> {

	@Inject
	protected AdapterFactory adapterFactory;

	@Inject
	protected MembersInjector<InjectableM2VLinkItemProvider> itemProviderInjector;

	@Override
	public StructuredItemContentAdapter get() {
		InjectableM2VLinkItemProvider itemProvider = new InjectableM2VLinkItemProvider(adapterFactory);
		itemProviderInjector.injectMembers(itemProvider);
		return itemProvider;
	}

}
