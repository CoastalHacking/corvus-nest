package corvus.resource;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public abstract class ModelToModelListener extends PostCommitEClassResourceSetListener {

	public abstract ModelToModelCommandFragment getFragment();
	
	/* (non-Javadoc)
	 * @see org.example.resourcesetlistener.PostCommitEClassResourceSetListener#resourceSetChanged(org.eclipse.emf.transaction.ResourceSetChangeEvent)
	 */
	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {

		TransactionalEditingDomain ted = getTarget();
		if (event != null &&
				ted != null &&
				event.getEditingDomain().equals(ted)) {

			ReadWriteTransactionJob job = new ReadWriteTransactionJob(
					"Read/write transaction via " + getClass().getName(),
					ted,
					getFragment(),
					event.getNotifications() // need to be copied

					);
			job.schedule();

		}
		return;
	}

	public static class ReadWriteTransactionJob extends Job {

		private TransactionalEditingDomain ted;
		
		private ModelToModelCommandFragment  fragment;

		private List<Notification> notifications;

		public ReadWriteTransactionJob(String name,
				TransactionalEditingDomain ted,
				ModelToModelCommandFragment  fragment,
				List<Notification> notifications) {
			super(name);
			this.ted = ted;
			this.fragment = fragment;
			this.notifications = notifications;
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			IStatus result;
			TransactionalCommandStack stack = (TransactionalCommandStack)ted.getCommandStack();

			try {
				stack.execute(new RecordingCommand(ted) {

					@Override
					protected void doExecute() {
						fragment.doExecute(notifications);
					}

				}, fragment.getOptions());
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
		
	}
}
