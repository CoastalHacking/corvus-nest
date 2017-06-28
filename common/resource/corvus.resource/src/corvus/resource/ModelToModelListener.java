package corvus.resource;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public abstract class ModelToModelListener extends PostCommitEClassResourceSetListener {

	/* (non-Javadoc)
	 * @see org.example.resourcesetlistener.PostCommitEClassResourceSetListener#getEClass()
	 */
	@Override
	public EClass getEClass() {
		return getFragment().getSourceModel();
	}

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

			TransactionalCommandStack stack = (TransactionalCommandStack)ted.getCommandStack();

			try {
				stack.execute(new RecordingCommand(ted) {

					@Override
					protected void doExecute() {
						getFragment().doExecute(event);
					}

				}, getFragment().getOptions());

			} catch (InterruptedException ie) {
				// TODO log
			} catch (RollbackException re) {
				// TODO log
			}
		}
		return;
	}

}
