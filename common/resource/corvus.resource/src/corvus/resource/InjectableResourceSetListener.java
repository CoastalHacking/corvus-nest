package corvus.resource;

import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

public class InjectableResourceSetListener extends ResourceSetListenerImpl {

	@Inject
	protected NotificationFilter filter;

	@Inject
	protected ReadWriteTransaction transaction;

	public InjectableResourceSetListener() {
		super();
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

			transaction.setNotifications(event.getNotifications()); // need to be copied
			transaction.commit();
		}
		return;
	}

}
