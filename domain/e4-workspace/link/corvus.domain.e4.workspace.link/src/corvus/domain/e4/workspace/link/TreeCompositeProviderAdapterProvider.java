package corvus.domain.e4.workspace.link;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;

import corvus.domain.e4.workspace.ICompositeProviderAdapter;

public class TreeCompositeProviderAdapterProvider implements Provider<ICompositeProviderAdapter> {

	@Inject
	private MembersInjector<InjectableTableCompositeProviderAdapter> membersInjector;

	@Override
	public ICompositeProviderAdapter get() {
		InjectableTableCompositeProviderAdapter adapter = new InjectableTableCompositeProviderAdapter();
		membersInjector.injectMembers(adapter);
		return adapter;
	}


}
