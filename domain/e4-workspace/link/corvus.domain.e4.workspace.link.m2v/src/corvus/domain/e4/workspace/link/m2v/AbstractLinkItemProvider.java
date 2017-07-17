package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.common.notify.AdapterFactory;

import corvus.model.link.provider.LinkItemProvider;

public abstract class AbstractLinkItemProvider extends LinkItemProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		// delegate to our adapter factory
		return getAdapterFactory().isFactoryForType(type);
	}

	public AbstractLinkItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	
}
