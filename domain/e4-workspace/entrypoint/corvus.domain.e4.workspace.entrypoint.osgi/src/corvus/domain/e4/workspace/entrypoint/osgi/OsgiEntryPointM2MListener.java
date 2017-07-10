package corvus.domain.e4.workspace.entrypoint.osgi;

import org.eclipse.emf.transaction.ResourceSetListener;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.google.inject.Injector;

import corvus.domain.e4.workspace.m2m.entrypoint.EntrypointInjectorProvider;
import corvus.domain.e4.workspace.AbstractOsgiDelegatedResourceSetListener;

@Component(immediate=true, service=ResourceSetListener.class)
public class OsgiEntryPointM2MListener
	extends AbstractOsgiDelegatedResourceSetListener {

	@Override
	protected Injector getInjector() {
		return EntrypointInjectorProvider.getInjector();
	}

	// TODO: need to do the below so the DS annotation processor generates correct XML
	@Activate
	protected void activate() {
		super.activate();
	}

	@Deactivate
	protected void deactivate() {
		super.deactivate();
	}
}
