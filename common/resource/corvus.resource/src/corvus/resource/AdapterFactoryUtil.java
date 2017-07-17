package corvus.resource;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
	@Deprecated
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
	
	/**
	 * Utility method to add or move a preferred adapter created by a preferred adapter factory
	 * 
	 * @param eObject an EObject to be adapter
	 * @param factory an adapter factory whose adapter should be preferred by the EObject
	 * @param type the type to adapt
	 */
	public void addOverrideAdapter(EObject eObject, AdapterFactory factory, Object type) {
		final Adapter possiblyExisting = EcoreUtil.getAdapter(eObject.eAdapters(), type);

		if (possiblyExisting == null) {
			// use our adapter factory to adapt the object
			factory.adapt(eObject, type);
		} else {
			// use our adapter factory to forcefully adapt the object
			final Adapter adapter = factory.adaptNew(eObject, type);
			int existing = eObject.eAdapters().indexOf(possiblyExisting);
			// and move it to be called before this one
			// index shouldn't need to be checked since the newly added adapter
			// should be at the end... should.
			eObject.eAdapters().move(existing, adapter);
		}

	}

}
