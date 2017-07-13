package corvus.resource;

import org.eclipse.emf.transaction.NotificationFilter;

public class ResourceSetListenerFactory {

	/**
	 * Utility factory to create on-demand resource set listeners
	 * 
	 * @param filter
	 * @param transactionProvider
	 * @return
	 */
	public InjectableResourceSetListener create(
			NotificationFilter filter, NotificationsConsumer consumer) {

		return new InjectableResourceSetListener(filter, consumer);
	}
}
