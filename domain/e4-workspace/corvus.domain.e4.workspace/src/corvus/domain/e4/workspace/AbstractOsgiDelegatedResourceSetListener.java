package corvus.domain.e4.workspace.osgi;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Injector;

public abstract class AbstractOsgiDelegatedResourceSetListener
	extends AbstractOsgiInjectedDelegateComponent<ResourceSetListener>
	implements ResourceSetListener {

	protected TransactionalEditingDomain ted;

	@Override
	protected abstract Injector getInjector();

	protected void activate() {
		delegate = getDelegate(ResourceSetListener.class);
		ted = injector.getInstance(TransactionalEditingDomain.class);
		// Hack: demand load the resource and initialize it, which avoids initializing it
		// potentially w/ a read-write transaction during a read-only transaction
		// TODO: move this code to the activators?
		@SuppressWarnings("unused")
		final Resource resource = injector.getInstance(Resource.class);
		// Then add listeners
		ted.addResourceSetListener(delegate);
	}

	protected void deactivate() {
		ted.removeResourceSetListener(delegate);
		delegate = null;
	}

	@Override
	public NotificationFilter getFilter() {
		return delegate.getFilter();
	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		return delegate.transactionAboutToCommit(event);
	}

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		delegate.resourceSetChanged(event);
	}

	@Override
	public boolean isAggregatePrecommitListener() {
		return delegate.isAggregatePrecommitListener();
	}

	@Override
	public boolean isPrecommitOnly() {
		return delegate.isPrecommitOnly();
	}

	@Override
	public boolean isPostcommitOnly() {
		return delegate.isPostcommitOnly();
	}

}
