package corvus.resource;

import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;

public abstract class PostCommitEClassResourceSetListener extends ResourceSetListenerImpl {

	public PostCommitEClassResourceSetListener() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl#getFilter()
	 */
	@Override
	public NotificationFilter getFilter() {
		return NotificationFilter.ANY;
	}

	@Override
	public boolean isPostcommitOnly() {
		return true;
	}

	@Override
	public boolean isPrecommitOnly() {
		return false;
	}

	@Override
	public abstract void resourceSetChanged(ResourceSetChangeEvent event);

}
