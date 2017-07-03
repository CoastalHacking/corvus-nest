package corvus.domain.e4.workspace.m2m.entrypoint;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.google.inject.Injector;

import corvus.domain.e4.workspace.AbstractOsgiInjectedDelegateComponent;

@Component(immediate=true)
public class OsgiEntryPointM2MListener
	extends AbstractOsgiInjectedDelegateComponent<ResourceSetListener>
	implements ResourceSetListener {

	private TransactionalEditingDomain ted;

	@Activate
	void activate() {
		delegate = getDelegate(ResourceSetListener.class);
		ted = injector.getInstance(TransactionalEditingDomain.class);
		ted.addResourceSetListener(delegate);
	}

	@Deactivate
	void deactivate() {
		ted.removeResourceSetListener(delegate);
		delegate = null;
	}

	@Override
	protected Injector getInjector() {
		return EntrypointInjectorProvider.getInjector();
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
		delegate.resourceSetChanged(event);;
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
