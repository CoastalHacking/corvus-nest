package corvus.resource;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

import corvus.transactional.TransactionOptions;

public class InjectableReadWriteTransactionJob extends Job implements ReadWriteTransaction {

	@Inject
	private TransactionalEditingDomain ted;

	@Inject
	private TransactionOptions options;

	private NotificationsConsumer consumer;

	protected List<Notification> notifications;

	public InjectableReadWriteTransactionJob(NotificationsConsumer consumer) {
		super("Corvus injected read write job transaction");  // TODO: inject
		this.consumer = consumer;
	}

	/**
	 * @param notifications the notifications to set
	 */
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		IStatus result;
		TransactionalCommandStack stack = (TransactionalCommandStack)ted.getCommandStack();

		try {
			stack.execute(
					new RecordingCommand(ted) {
						@Override
						protected void doExecute() {
							consumer.consume(notifications);
						}},
					options.get());

			result = Status.OK_STATUS;

		} catch (InterruptedException ie) {
			result = new Status(IStatus.ERROR,
					ResourceActivator.PLUGIN_ID,
					"Interrupted before transaction could start", ie);
		} catch (RollbackException re) {
			result = new Status(IStatus.ERROR,
					ResourceActivator.PLUGIN_ID,
					"Transaction was rolled back", re);
		}
		return result;
	}

	@Override
	public void commit() {
		this.schedule();
	}

}
