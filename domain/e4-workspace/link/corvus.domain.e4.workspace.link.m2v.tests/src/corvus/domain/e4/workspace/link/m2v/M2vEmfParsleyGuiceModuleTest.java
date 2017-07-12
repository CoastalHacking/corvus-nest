package corvus.domain.e4.workspace.link.m2v;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.junit.Test;

import corvus.model.link.provider.LinkItemProvider;
import corvus.model.link.provider.LinkItemProviderAdapterFactory;
import corvus.resource.InjectableResourceSetListener;

public class M2vEmfParsleyGuiceModuleTest extends AbstractM2VTest {

	@Test
	public void testShouldInjectLinkItemProviderProvider() {
		shouldInjectInstance(LinkItemProvider.class);
	}

	@Test
	public void testShouldInjectM2VLinkItemProviderAdapterFactory() {
		LinkItemProviderAdapterFactory adapterFactory = shouldInjectInstance(LinkItemProviderAdapterFactory.class);
		assertTrue(adapterFactory instanceof M2VLinkItemProviderAdapterFactory);
	}

	@Test
	public void testShouldInjectM2VNotificationsConsumer() {
		shouldInjectInstance(M2VNotificationsConsumer.class);
	}

	@Test
	public void testShouldInjectResourceSetListener() {
		ResourceSetListener rsl = shouldInjectInstance(ResourceSetListener.class);
		assertTrue(rsl instanceof InjectableResourceSetListener);
	}

	@Test
	public void testShouldInjectAdapterFactory() {
		AdapterFactory instance = shouldInjectInstance(AdapterFactory.class);
		assertTrue(instance instanceof M2VInjectableAdapterFactory);
	}

}
