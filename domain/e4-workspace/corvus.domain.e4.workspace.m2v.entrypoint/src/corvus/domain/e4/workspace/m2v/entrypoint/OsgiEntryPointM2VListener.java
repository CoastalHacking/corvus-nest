package corvus.domain.e4.workspace.m2v.entrypoint;

import org.osgi.service.component.annotations.Component;

import com.google.inject.Injector;

import corvus.domain.e4.workspace.AbstractOsgiDelegatedResourceSetListener;

// TODO: auto-generate from DSL
@Component(immediate=true)
public class OsgiEntryPointM2VListener
	extends AbstractOsgiDelegatedResourceSetListener{

	@Override
	protected Injector getInjector() {
		return EntrypointInjectorProvider.getInjector();
	}

}
