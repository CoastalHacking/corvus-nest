package corvus.domain.e4.workspace.osgi.d2m;

import org.eclipse.core.resources.IMarker;
import org.osgi.service.component.annotations.Component;

import com.google.inject.Injector;

import corvus.domain.e4.workspace.ICompositeProvider;
import corvus.domain.e4.workspace.ViewController;
import corvus.domain.e4.workspace.d2m.D2mInjectorProvider;
import corvus.domain.e4.workspace.osgi.AbstractOsgiInjectedDelegateComponent;

@Component(immediate=true)
public class OsgiViewControllerImpl
	extends AbstractOsgiInjectedDelegateComponent<ViewController> 
	implements ViewController {

	public OsgiViewControllerImpl() {
		super();
		delegate = getDelegate(ViewController.class);
	}

	/* (non-Javadoc)
	 * @see corvus.domain.e4.workspace.osgi.AbstractOsgiInjectedDelegateComponent#getInjector()
	 */
	@Override
	protected Injector getInjector() {
		return D2mInjectorProvider.getInjector();
	}

	@Override
	public ICompositeProvider getCompositeProvider(IMarker marker) {
		return delegate.getCompositeProvider(marker);
	}

}
