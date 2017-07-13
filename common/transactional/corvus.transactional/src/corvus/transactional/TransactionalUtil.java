package corvus.transactional;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

public class TransactionalUtil {

	@Inject
	private TransactionalEditingDomain ted;

	@Inject
	private TransactionOptions options;

	public void performTransaction(Command command) throws InterruptedException, RollbackException {
		TransactionalCommandStack stack = (TransactionalCommandStack)ted.getCommandStack();
		stack.execute(command, options.get());
	}
}
