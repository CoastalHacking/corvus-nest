package corvus.domain.e4.workspace.d2m;

import com.google.inject.Injector;

public abstract class AbstractOsgiInjectedDelegateComponent<T> {

	protected Injector injector;

	protected T delegate;

	public AbstractOsgiInjectedDelegateComponent() {
		injector = D2mInjectorProvider.getInjector();
	}

	protected T getDelegate(Class<T> cls) {
		return injector.getInstance(cls);
	}
}
