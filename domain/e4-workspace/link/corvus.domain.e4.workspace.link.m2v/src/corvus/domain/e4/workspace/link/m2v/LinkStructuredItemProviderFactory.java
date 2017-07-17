package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.Singleton;

import corvus.model.link.LinkPackage;

/**
 * 
 * Singleton is used since this factory is expected to be used only for this project
 *
 */
@Singleton
public class LinkStructuredItemProviderFactory
	extends AbstractScopedLinkItemProviderAdapterFactory {

	@Inject
	private MembersInjector<InjectableM2VLinkItemProvider> itemProviderInjector;

	public LinkStructuredItemProviderFactory() {
		super(IStructuredItemContentProvider.class, LinkPackage.eINSTANCE.getLink());
	}

	/* (non-Javadoc)
	 * @see corvus.model.link.provider.LinkItemProviderAdapterFactory#createLinkAdapter()
	 */
	@Override
	public Adapter createLinkAdapter() {
		if (linkItemProvider == null) {
			InjectableM2VLinkItemProvider itemProvider = new InjectableM2VLinkItemProvider(this);
			itemProviderInjector.injectMembers(itemProvider);
			linkItemProvider = itemProvider;
		}
		return linkItemProvider;
	}

}
