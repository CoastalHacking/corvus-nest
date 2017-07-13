package corvus.transactional;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

public class TransactionalUtil {

	@Inject
	private TransactionalEditingDomain ted;

	@Inject
	private TransactionOptions options;

	public void executeRecordingCommand(IRecordingCommand command) {
		TransactionalCommandStack stack = (TransactionalCommandStack)ted.getCommandStack();
		try {
			stack.execute(new RecordingCommand(ted) {
				@Override
				protected void doExecute() {
					command.doExecute();
				}
			}, options.get());
		} catch (InterruptedException | RollbackException e) {
			// TODO: log warning?
			throw new RuntimeException(e);
		}
	}
}
