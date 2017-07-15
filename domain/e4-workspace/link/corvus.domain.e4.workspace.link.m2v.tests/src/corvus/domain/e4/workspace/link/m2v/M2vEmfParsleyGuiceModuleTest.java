package corvus.domain.e4.workspace.link.m2v;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.transaction.NotificationFilter;
import org.junit.Test;

public class M2vEmfParsleyGuiceModuleTest extends AbstractM2VTest {

	@Test
	public void testShouldInjectIStructuredItemContentProvider() {
		IStructuredItemContentProvider instance = shouldInjectInstance(IStructuredItemContentProvider.class);
		assertTrue(instance instanceof InjectableM2VLinkItemProvider);
	}

	@Test
	public void testShouldInjectM2VNotificationsConsumer() {
		shouldInjectInstance(M2VNotificationsConsumer.class);
	}

	@Test
	public void testShouldInjectNotificationFilter() {
		shouldInjectInstance(NotificationFilter.class);
	}


}
