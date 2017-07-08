package corvus.resource;

import static org.junit.Assert.assertTrue;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.junit.Test;

import com.google.inject.Injector;
import com.google.inject.Provider;

import corvus.common.test.CorvusAbstractEmfParsleyTest;
import corvus.transactional.TransactionalEmfParsleyGuiceModule;

public class ReadWriteTransactionProviderTest extends CorvusAbstractEmfParsleyTest {

	@Test
	public void shouldProvidedInjectedReadWriteTransactionJob() {
		Injector injector = getOrCreateInjector();
		Provider<ReadWriteTransaction> provider = injector.getProvider(ReadWriteTransaction.class);
		ReadWriteTransaction transaction = provider.get();
		assertTrue(transaction instanceof InjectableReadWriteTransactionJob);
		InjectableReadWriteTransactionJob job = (InjectableReadWriteTransactionJob)transaction;
		job.toString();
	}

	@Override
	protected TransactionalEmfParsleyGuiceModule getTestModule(AbstractUIPlugin plugin, String id) {
		return new TestCaseModule(plugin, id);
	}

}
