package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.transaction.NotificationFilter;
import org.junit.Test;

public class M2vEmfParsleyGuiceModuleTest extends AbstractM2VTest {

	@Test
	public void testShouldInjectM2VNotificationsConsumer() {
		shouldInjectInstance(M2VNotificationsConsumer.class);
	}

	@Test
	public void testShouldInjectNotificationFilter() {
		shouldInjectInstance(NotificationFilter.class);
	}

	@Test
	public void testShouldInjectLinkStructuredItemProviderFactory() {
		shouldInjectInstance(LinkStructuredItemProviderFactory.class);
	}
}
