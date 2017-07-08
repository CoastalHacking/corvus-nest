package corvus.domain.e4.workspace;

import org.eclipse.emf.common.notify.AdapterFactory;

public interface CompositeProviderAdapterFactory extends AdapterFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.AdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	default boolean isFactoryForType(Object type) {
		return type == ICompositeProvider.class;
	}


}
