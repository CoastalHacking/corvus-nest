package corvus.domain.e4.workspace;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class InjectableCompositeProviderAdapterFactory
	extends AdapterFactoryImpl
	implements CompositeProviderAdapterFactory {

	@Inject
	protected Provider<ICompositeProviderAdapter> adapterProvider;

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#createAdapter(org.eclipse.emf.common.notify.Notifier, java.lang.Object)
	 */
	@Override
	protected Adapter createAdapter(Notifier target, Object type) {
		return adapterProvider.get();
	}


}
