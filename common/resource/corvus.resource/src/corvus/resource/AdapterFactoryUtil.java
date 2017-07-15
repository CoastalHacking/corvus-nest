package corvus.resource;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;

import com.google.inject.Inject;

public class AdapterFactoryUtil {

	@Inject
	private AdapterFactory factory;

	/**
	 * Obtain an adapter for a given type and insert a provided adapter earlier
	 * 
	 * @param notifier
	 * @param clazz
	 * @param instance
	 */
	public void overrideAdapter(Notifier notifier, Class<?> clazz, Adapter instance) {

		// Call the injected adapter factory to ensure its providers are added first
		final Adapter adapter = factory.adapt(notifier, clazz);
		int index = -1;
		if (adapter != null) {
			index = notifier.eAdapters().indexOf(adapter);
		}
		// If we found an adapter
		if (index > -1
				// and its exact class is not the same as our instance
				&& !instance.getClass().equals(adapter.getClass())) {

			if (notifier.eAdapters().contains(instance)) {
				// move our instance to the current location
				notifier.eAdapters().move(index, instance);
			} else {
				// insert our instance at the current location
				notifier.eAdapters().add(index, instance);
				// and set its target to this notifier
				instance.setTarget(notifier);
			}
		}
	}

}
