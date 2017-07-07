package corvus.domain.e4.workspace.osgi;

import static org.junit.Assert.*;

import org.eclipse.emf.transaction.ResourceSetListener;
import org.junit.Test;

import corvus.domain.e4.workspace.MarkerUtil;
import corvus.domain.e4.workspace.osgi.d2m.OsgiMarkerUtilImpl;
import corvus.domain.e4.workspace.osgi.m2m.entrypoint.OsgiEntryPointM2MListener;
import corvus.domain.e4.workspace.osgi.m2v.entrypoint.OsgiEntryPointM2VListener;

public class OsgiResourceSetListenerTest {

	@Test
	public void shouldLoadOsgiEntryPointM2MListener() {
		ResourceSetListener rsl = OsgiTestUtil.getService(OsgiResourceSetListenerTest.class, ResourceSetListener.class, OsgiEntryPointM2MListener.class.getName());
		assertNotNull(rsl);
		assertTrue(rsl instanceof OsgiEntryPointM2MListener);
	}

	@Test
	public void shouldLoadOsgiEntryPointM2VListener() {
		ResourceSetListener rsl = OsgiTestUtil.getService(OsgiResourceSetListenerTest.class, ResourceSetListener.class, OsgiEntryPointM2VListener.class.getName());
		assertNotNull(rsl);
		assertTrue(rsl instanceof OsgiEntryPointM2VListener);
	}

	@Test
	public void shouldLoadOsgiMarkerUtilImpl() {
		MarkerUtil markerUtil = OsgiTestUtil.getService(OsgiResourceSetListenerTest.class, MarkerUtil.class, OsgiMarkerUtilImpl.class.getName());
		assertNotNull(markerUtil);
		assertTrue(markerUtil instanceof OsgiMarkerUtilImpl);
	}

}
