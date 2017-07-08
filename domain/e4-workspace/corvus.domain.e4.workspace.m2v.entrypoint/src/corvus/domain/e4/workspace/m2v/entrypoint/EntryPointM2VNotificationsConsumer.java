package corvus.domain.e4.workspace.m2v.entrypoint;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import com.google.inject.Inject;

import corvus.domain.e4.workspace.CompositeProviderAdapterFactory;
import corvus.domain.e4.workspace.ICompositeProvider;
import corvus.model.entrypoint.EntryPoint;
import corvus.resource.NotificationsConsumer;

public class EntryPointM2VNotificationsConsumer extends NotificationsConsumer {

	@Inject
	protected CompositeProviderAdapterFactory compositeProviderAdapterFactory;

	/* (non-Javadoc)
	 * @see corvus.resource.NotificationsConsumer#consume(java.util.List)
	 */
	@Override
	public void consume(List<Notification> notifications) {

		for (Notification notification : notifications) {
			final Object notifier = notification.getNewValue();
			if (notifier instanceof EntryPoint) {

				// Adapt it for our view
				compositeProviderAdapterFactory.adapt((EntryPoint)notifier, ICompositeProvider.class);
			}
		}
	}


}
