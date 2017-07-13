package corvus.domain.e4.workspace;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;

import corvus.resource.NotificationsConsumer;

public class DefaultM2VNotificationsConsumer extends NotificationsConsumer {

	@Inject
	protected CompositeProviderAdapterFactory compositeProviderAdapterFactory;

	/* (non-Javadoc)
	 * @see corvus.resource.NotificationsConsumer#consume(java.util.List)
	 */
	@Override
	public void consume(List<Notification> notifications) {

		for (Notification notification : notifications) {
	
			switch (notification.getEventType()) {
			case Notification.ADD:
				// The notification filter is the guard
				// We assume EObject here
				// TODO: test
				addNewValue((EObject)notification.getNewValue());
				break;
			case Notification.REMOVE:
				// Currently nothing to implement? Unsure if adapter needs to be removed from
				// object when object is deleted
				// TODO: verify
				break;
			default:
				break;
			}
		}
	}

	protected void addNewValue(EObject newValue) {
		compositeProviderAdapterFactory.adapt(newValue, ICompositeProvider.class);
	}
}
