package corvus.domain.e4.workspace.link.m2v;

import static org.junit.Assert.*;

import org.eclipse.emf.common.notify.Adapter;
import org.junit.Test;

import com.google.inject.Injector;

import corvus.model.link.Link;
import corvus.model.link.LinkFactory;
import corvus.resource.NotificationsConsumer;

public class M2VNotificationsConsumerTest extends AbstractM2VTest {

	@Test
	public void shouldAddInjectedAdapterOnNewAdd() {
		Injector injector = getOrCreateInjector();
		M2VNotificationsConsumer consumer = (M2VNotificationsConsumer)injector.getInstance(NotificationsConsumer.class);

		Link link = LinkFactory.eINSTANCE.createLink();
		consumer.addNewValue(link);

		boolean containsLinkItemProviderAdapter = false;

		for (Adapter adapter : link.eAdapters()) {
			if (adapter instanceof InjectableM2VLinkItemProvider) {
				containsLinkItemProviderAdapter = true;
				break;
			}
		}
		assertTrue(containsLinkItemProviderAdapter);
	}

}
