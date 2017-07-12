package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.common.notify.Adapter;

import com.google.inject.Inject;
import com.google.inject.Provider;

import corvus.model.link.provider.LinkItemProvider;
import corvus.model.link.provider.LinkItemProviderAdapterFactory;

public class M2VLinkItemProviderAdapterFactory extends LinkItemProviderAdapterFactory {

	@Inject
	protected Provider<LinkItemProvider> linkItemProviderProvider;

	/* (non-Javadoc)
	 * @see corvus.model.link.provider.LinkItemProviderAdapterFactory#createLinkAdapter()
	 */
	@Override
	public Adapter createLinkAdapter() {
		if (linkItemProvider == null) {
			linkItemProvider = linkItemProviderProvider.get();
		}
		return linkItemProvider;
	}
}
