package corvus.domain.e4.workspace.link.osgi.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.transaction.ResourceSetListener;
import org.junit.Test;

import corvus.common.osgi.test.OsgiTestUtil;
import corvus.domain.e4.workspace.link.osgi.OsgiLinkM2MListener;
import corvus.domain.e4.workspace.link.osgi.OsgiLinkM2VListener;

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

}
