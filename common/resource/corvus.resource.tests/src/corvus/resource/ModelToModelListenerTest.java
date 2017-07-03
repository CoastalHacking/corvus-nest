package corvus.resource;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;

public class ModelToModelListenerTest {

	@Test
	public void shouldExecuteStack() throws InterruptedException, RollbackException {
		// Mocks
		ModelToModelCommandFragment mockFragment = mock(ModelToModelCommandFragment.class);

		TransactionalEditingDomain mockTed = mock(TransactionalEditingDomain.class);

		TransactionalCommandStack mockStack = mock(TransactionalCommandStack.class);
		when(mockTed.getCommandStack()).thenReturn(mockStack);

		ResourceSetChangeEvent mockEvent = mock(ResourceSetChangeEvent.class);
		when(mockEvent.getEditingDomain()).thenReturn(mockTed);

		// Test
		ModelToModelListener listener = new ModelToModelListener() {
			@Override public ModelToModelCommandFragment getFragment() { return mockFragment; }
		};
		listener.setTarget(mockTed);
		listener.resourceSetChanged(mockEvent);

		// Verify
		verify(mockStack, atLeastOnce()).execute(any(RecordingCommand.class), anyMap());
		
	}

}
