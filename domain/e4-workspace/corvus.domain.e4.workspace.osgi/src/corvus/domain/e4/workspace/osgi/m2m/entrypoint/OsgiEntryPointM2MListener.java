package corvus.domain.e4.workspace.osgi.m2m.entrypoint;

import org.eclipse.emf.transaction.ResourceSetListener;
import org.osgi.service.component.annotations.Component;

import com.google.inject.Injector;

import corvus.domain.e4.workspace.m2m.entrypoint.EntrypointInjectorProvider;
import corvus.domain.e4.workspace.osgi.AbstractOsgiDelegatedResourceSetListener;

@Component(immediate=true, service=ResourceSetListener.class)
public class OsgiEntryPointM2MListener
	extends AbstractOsgiDelegatedResourceSetListener {

	@Override
	protected Injector getInjector() {
		return EntrypointInjectorProvider.getInjector();
	}

}
