package corvus.domain.e4.workspace;

import com.google.inject.Injector;

public abstract class AbstractOsgiInjectedDelegateComponent<T> {

	protected Injector injector;

	protected T delegate;

	public AbstractOsgiInjectedDelegateComponent() {
		injector = getInjector();
	}

	protected T getDelegate(Class<T> cls) {
		return injector.getInstance(cls);
	}
	
	protected abstract Injector getInjector();
}
