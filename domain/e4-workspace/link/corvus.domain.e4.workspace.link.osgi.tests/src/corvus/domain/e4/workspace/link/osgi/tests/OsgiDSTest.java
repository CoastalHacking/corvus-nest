package corvus.domain.e4.workspace.link.osgi.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.transaction.ResourceSetListener;
import org.junit.Ignore;
import org.junit.Test;

import corvus.common.osgi.test.OsgiTestUtil;
import corvus.domain.e4.workspace.link.osgi.OsgiLinkM2MListener;

public class OsgiDSTest {

	@Test
	public void shouldLoadOsgiEntryPointM2MListener() throws InterruptedException {
		ResourceSetListener rsl = OsgiTestUtil.getService(OsgiDSTest.class, ResourceSetListener.class, OsgiLinkM2MListener.class.getName());
		assertNotNull(rsl);
		assertTrue(rsl instanceof OsgiLinkM2MListener);
	}

	@Ignore
	@Test
	public void shouldLoadOsgiEntryPointM2VListener() {
//		ResourceSetListener rsl = OsgiTestUtil.getService(OsgiDSTest.class, ResourceSetListener.class, OsgiEntryPointM2VListener.class.getName());
//		assertNotNull(rsl);
//		assertTrue(rsl instanceof OsgiEntryPointM2VListener);
	}

}
