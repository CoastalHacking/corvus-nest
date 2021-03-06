package corvus.resource;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

public class InjectableResourceSetListener extends ResourceSetListenerImpl {

	@Inject
	private ReadWriteTransactionFactory transactionFactory;

	protected NotificationFilter filter;
	protected NotificationsConsumer consumer;

	@Inject
	protected InjectableResourceSetListener(
			NotificationFilter filter, NotificationsConsumer consumer) {
		super();
		this.filter = filter;
		this.consumer = consumer;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl#getFilter()
	 */
	@Override
	public NotificationFilter getFilter() {
		return filter;
	}

	// TODO: inject
	@Override
	public boolean isPostcommitOnly() {
		return true;
	}

	// TODO: inject
	@Override
	public boolean isPrecommitOnly() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.example.resourcesetlistener.PostCommitEClassResourceSetListener#resourceSetChanged(org.eclipse.emf.transaction.ResourceSetChangeEvent)
	 */
	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {

		TransactionalEditingDomain ted = getTarget();
		if (event != null &&
				ted != null &&
				event.getEditingDomain().equals(ted)) {

			// Create a new transaction for each call
			final ReadWriteTransaction transaction = transactionFactory.create(consumer);

			// Per ResourceSetChangeEvent Javadoc, need to copy the notifiers
			final List<Notification> notifications = new ArrayList<>(event.getNotifications());
			transaction.setNotifications(notifications);
			transaction.commit();
		}
		return;
	}

}
