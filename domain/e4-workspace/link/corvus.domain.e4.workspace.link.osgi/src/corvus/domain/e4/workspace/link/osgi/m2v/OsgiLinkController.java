package corvus.domain.e4.workspace.link.osgi.m2v;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.google.inject.Injector;

import corvus.domain.e4.workspace.AbstractOsgiInjectedDelegateComponent;
import corvus.domain.e4.workspace.link.LinkController;
import corvus.domain.e4.workspace.link.m2v.M2vInjectorProvider;

@Component(immediate=true)
public class OsgiLinkController
	extends AbstractOsgiInjectedDelegateComponent<LinkController>
	implements LinkController {

	@Override
	protected Injector getInjector() {
		return M2vInjectorProvider.getInjector();
	}

	@Activate
	protected void activate() {
		delegate = getDelegate(LinkController.class);
	}

	@Deactivate
	protected void deactivate() {
		delegate = null;
	}

	@Override
	public void endLink() {
		delegate.endLink();
	}

	@Override
	public void prepareIncoming() {
		delegate.prepareIncoming();
	}

	@Override
	public void prepareOutgoing() {
		delegate.prepareOutgoing();
	}

}
