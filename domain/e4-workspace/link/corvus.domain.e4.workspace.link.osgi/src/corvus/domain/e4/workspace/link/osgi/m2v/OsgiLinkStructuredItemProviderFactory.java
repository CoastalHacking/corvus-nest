package corvus.domain.e4.workspace.link.osgi.m2v;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.google.inject.Injector;

import corvus.domain.e4.workspace.link.m2v.LinkStructuredItemProviderFactory;
import corvus.domain.e4.workspace.link.m2v.M2vInjectorProvider;

@Component(immediate=true, service=OsgiLinkStructuredItemProviderFactory.class)
public class OsgiLinkStructuredItemProviderFactory {

	/*
	 * Dispose of the adapter factory on exit
	 */
	@Deactivate
	void deactivate() {
		Injector injector = M2vInjectorProvider.getInjector();
		LinkStructuredItemProviderFactory delegate = injector.getInstance(LinkStructuredItemProviderFactory.class);
		delegate.dispose();
	}
}
