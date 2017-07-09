package corvus.transactional;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.parsley.internal.databinding.DatabindingValidationUtil;
import org.eclipse.emf.parsley.internal.databinding.EmfValidationTargetToModelUpdateValueStrategy;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class TransactionalEmfValidationTargetToModelUpdateValueStrategy
		extends EmfValidationTargetToModelUpdateValueStrategy {

	@Inject
	private TransactionalEditingDomain ted;

	@Inject
	private TransactionOptions options;

	public TransactionalEmfValidationTargetToModelUpdateValueStrategy(
			EObject owner, EStructuralFeature feature,
			DatabindingValidationUtil databindingValidationUtil) {
		super(owner, feature, databindingValidationUtil);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.emf.parsley.internal.databinding.EmfValidationTargetToModelUpdateValueStrategy#doSet(org.eclipse.core.databinding.observable.value.IObservableValue, java.lang.Object)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected IStatus doSet(IObservableValue observableValue, Object value) {

		final StatusResult statusResult = new StatusResult();

		TransactionalCommandStack stack = (TransactionalCommandStack)ted.getCommandStack();
		try {
			// blocks until transaction can be executed
			stack.execute(new RecordingCommand(ted) {
	
				@Override
				protected void doExecute() {
					statusResult.status = TransactionalEmfValidationTargetToModelUpdateValueStrategy.super.doSet(
							observableValue, value);
				}
			}, options.get());
		} catch (InterruptedException | RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statusResult.status;
	}

	protected static class StatusResult {
		// TODO: warning, error, or maybe log?
		public IStatus status = Status.CANCEL_STATUS;
	}

}
