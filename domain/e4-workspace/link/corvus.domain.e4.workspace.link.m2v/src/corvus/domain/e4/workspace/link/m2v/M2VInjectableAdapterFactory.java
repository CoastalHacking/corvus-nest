package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry;
import org.eclipse.emf.parsley.edit.provider.InjectableAdapterFactory;

import com.google.inject.Inject;

public class M2VInjectableAdapterFactory extends InjectableAdapterFactory {

	@Inject
	public M2VInjectableAdapterFactory(Registry adapterFactoryDescriptorRegistry,
			M2VLinkItemProviderAdapterFactory linkItemProviderAdapterFactory) {
		super(adapterFactoryDescriptorRegistry);

		addAdapterFactory(linkItemProviderAdapterFactory);
	}

}
