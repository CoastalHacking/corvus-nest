package corvus.domain.e4.workspace.m2v.entrypoint;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

import corvus.model.entrypoint.EntryPoint;
import corvus.resource.NotificationsConsumer;

public class EntryPointM2VNotificationsConsumer extends NotificationsConsumer {

	@Inject
	protected MembersInjector<InjectableCompositeProviderAdapter> membersInjector;

	/* (non-Javadoc)
	 * @see corvus.resource.NotificationsConsumer#consume(java.util.List)
	 */
	@Override
	public void consume(List<Notification> notifications) {
		for (Notification notification : notifications) {
			// TODO: consider moving two lines below to a provider?
			InjectableCompositeProviderAdapter adapter = new InjectableCompositeProviderAdapter();
			membersInjector.injectMembers(adapter);
			final Object notifier = notification.getNewValue();
			if (notifier instanceof EntryPoint) {
				EntryPoint entryPoint = (EntryPoint)notifier;
				// Add our view adapter
				entryPoint.eAdapters().add(adapter);
			}
		}
	}


}
