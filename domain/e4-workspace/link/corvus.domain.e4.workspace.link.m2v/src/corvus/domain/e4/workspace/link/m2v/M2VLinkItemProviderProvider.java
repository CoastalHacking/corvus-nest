package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;

import corvus.model.link.provider.LinkItemProvider;

public class M2VLinkItemProviderProvider implements Provider<LinkItemProvider> {

	@Inject
	protected AdapterFactory adapterFactory;

	@Inject
	protected MembersInjector<InjectableM2VLinkItemProvider> itemProviderInjector;

	public M2VLinkItemProviderProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LinkItemProvider get() {
		InjectableM2VLinkItemProvider itemProvider = new InjectableM2VLinkItemProvider(adapterFactory);
		itemProviderInjector.injectMembers(itemProvider);
		return itemProvider;
	}

}
