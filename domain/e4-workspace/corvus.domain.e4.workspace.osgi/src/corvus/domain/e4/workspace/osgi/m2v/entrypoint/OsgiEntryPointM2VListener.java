package corvus.domain.e4.workspace.osgi.m2v.entrypoint;

import org.eclipse.emf.transaction.ResourceSetListener;
import org.osgi.service.component.annotations.Component;

import com.google.inject.Injector;

import corvus.domain.e4.workspace.m2v.entrypoint.EntrypointInjectorProvider;
import corvus.domain.e4.workspace.osgi.AbstractOsgiDelegatedResourceSetListener;

// TODO: auto-generate from DSL
@Component(immediate=true, service=ResourceSetListener.class)
public class OsgiEntryPointM2VListener
	extends AbstractOsgiDelegatedResourceSetListener {

	@Override
	protected Injector getInjector() {
		return EntrypointInjectorProvider.getInjector();
	}

}
