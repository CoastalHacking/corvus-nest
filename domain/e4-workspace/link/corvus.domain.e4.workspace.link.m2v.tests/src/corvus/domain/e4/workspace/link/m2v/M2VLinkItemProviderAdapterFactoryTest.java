package corvus.domain.e4.workspace.link.m2v;

import static org.junit.Assert.*;

import org.eclipse.emf.common.notify.Adapter;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Injector;

import corvus.model.link.provider.LinkItemProviderAdapterFactory;

public class M2VLinkItemProviderAdapterFactoryTest extends AbstractM2VTest {

	@Ignore("Disabling due to it going away")
	@Test
	public void shouldCreateInjectableLinkAdapter() {
		Injector injector = getOrCreateInjector();
		LinkItemProviderAdapterFactory adapterFactory = injector.getInstance(LinkItemProviderAdapterFactory.class);
		Adapter adapter = adapterFactory.createLinkAdapter();
		assertNotNull(adapter);
		assertTrue(adapter instanceof InjectableM2VLinkItemProvider);
	}

}
