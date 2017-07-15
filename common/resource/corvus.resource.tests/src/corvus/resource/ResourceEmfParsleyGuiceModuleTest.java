package corvus.resource;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;

public class ResourceEmfParsleyGuiceModuleTest extends AbstractResourceTest {

	@Test
	public void shouldInjectTransactionalEditingDomain() {
		TransactionalEditingDomain instance = shouldInjectInstance(TransactionalEditingDomain.class);
		assertTrue(instance instanceof TransactionalEditingDomain);
	}
	
	@Test
	public void shouldInjectReadWriteTransaction() {
		ReadWriteTransaction instance = shouldInjectInstance(ReadWriteTransaction.class);
		assertTrue(instance instanceof InjectableReadWriteTransactionJob);
	}

	@Test
	public void shouldInjectResource() {
		shouldInjectInstance(Resource.class);
	}

}
