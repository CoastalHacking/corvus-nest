package corvus.domain.e4.workspace.osgi.d2m;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.google.inject.Injector;

import corvus.domain.e4.workspace.AbstractOsgiInjectedDelegateComponent;
import corvus.domain.e4.workspace.d2m.D2mInjectorProvider;

@Component(immediate=true)
public class OsgiMarkerResourceChangeListener
	extends AbstractOsgiInjectedDelegateComponent<IResourceChangeListener>
	implements IResourceChangeListener {

	@Activate
	void activate() {
		delegate = getDelegate(IResourceChangeListener.class);
		IWorkspace workspace = injector.getInstance(IWorkspace.class);
		workspace.addResourceChangeListener(delegate);
	}

	@Deactivate
	void deactivate() {
		IWorkspace workspace = injector.getInstance(IWorkspace.class);
		workspace.removeResourceChangeListener(delegate);
	}

	@Override
	protected Injector getInjector() {
		return D2mInjectorProvider.getInjector();
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		// TODO: warning log, shouldn't be called. don't call the delegate
	}

}
