package corvus.domain.e4.workspace;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;

public class CompositeProviderAdapterProvider implements Provider<ICompositeProviderAdapter> {

	@Inject
	private MembersInjector<InjectableCompositeProviderAdapter> membersInjector;

	@Override
	public ICompositeProviderAdapter get() {
		InjectableCompositeProviderAdapter adapter = new InjectableCompositeProviderAdapter();
		membersInjector.injectMembers(adapter);
		return adapter;
	}

}
