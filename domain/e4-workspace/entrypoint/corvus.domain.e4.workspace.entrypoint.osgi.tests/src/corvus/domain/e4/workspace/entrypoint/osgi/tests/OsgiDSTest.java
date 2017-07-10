package corvus.domain.e4.workspace.entrypoint.osgi.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.transaction.ResourceSetListener;
import org.junit.Test;

import corvus.domain.e4.workspace.entrypoint.osgi.OsgiEntryPointM2MListener;
import corvus.domain.e4.workspace.entrypoint.osgi.OsgiEntryPointM2VListener;
import corvus.domain.e4.workspace.osgi.testutils.OsgiTestUtil;

public class OsgiDSTest {

	@Test
	public void shouldLoadOsgiEntryPointM2MListener() {
		ResourceSetListener rsl = OsgiTestUtil.getService(OsgiDSTest.class, ResourceSetListener.class, OsgiEntryPointM2MListener.class.getName());
		assertNotNull(rsl);
		assertTrue(rsl instanceof OsgiEntryPointM2MListener);
	}

	@Test
	public void shouldLoadOsgiEntryPointM2VListener() {
		ResourceSetListener rsl = OsgiTestUtil.getService(OsgiDSTest.class, ResourceSetListener.class, OsgiEntryPointM2VListener.class.getName());
		assertNotNull(rsl);
		assertTrue(rsl instanceof OsgiEntryPointM2VListener);
	}

}
