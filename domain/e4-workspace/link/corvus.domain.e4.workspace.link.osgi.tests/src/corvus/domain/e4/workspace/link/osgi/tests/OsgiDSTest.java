package corvus.domain.e4.workspace.link.osgi.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.transaction.ResourceSetListener;
import org.junit.Test;

import corvus.common.osgi.test.OsgiTestUtil;
import corvus.domain.e4.workspace.link.LinkController;
import corvus.domain.e4.workspace.link.osgi.m2m.OsgiLinkM2MListener;
import corvus.domain.e4.workspace.link.osgi.m2v.OsgiLinkController;
import corvus.domain.e4.workspace.link.osgi.m2v.OsgiLinkM2VListener;
import corvus.domain.e4.workspace.link.osgi.m2v.OsgiLinkStructuredItemProviderFactory;

public class OsgiDSTest {

	@Test
	public void shouldLoadOsgiLinkM2MListener() throws InterruptedException {
		ResourceSetListener rsl = OsgiTestUtil.getService(OsgiDSTest.class, ResourceSetListener.class, OsgiLinkM2MListener.class.getName());
		assertNotNull(rsl);
		assertTrue(rsl instanceof OsgiLinkM2MListener);
	}

	@Test
	public void shouldLoadOsgiLinkM2VListener() throws InterruptedException {
		ResourceSetListener rsl = OsgiTestUtil.getService(OsgiDSTest.class, ResourceSetListener.class, OsgiLinkM2VListener.class.getName());
		assertNotNull(rsl);
		assertTrue(rsl instanceof OsgiLinkM2VListener);
	}

	@Test
	public void shouldLoadOsgiM2VLinkController() throws InterruptedException {
		LinkController instance = OsgiTestUtil.getService(OsgiDSTest.class, LinkController.class, OsgiLinkController.class.getName());
		assertNotNull(instance);
		assertTrue(instance instanceof OsgiLinkController);
	}

	@Test
	public void shouldLoadOsgiLinkStructuredItemProviderFactory() throws InterruptedException {
		OsgiLinkStructuredItemProviderFactory instance = OsgiTestUtil.getService(OsgiDSTest.class, OsgiLinkStructuredItemProviderFactory.class, OsgiLinkStructuredItemProviderFactory.class.getName());
		assertNotNull(instance);
		assertTrue(instance instanceof OsgiLinkStructuredItemProviderFactory);
	}
}
