package corvus.domain.e4.workspace.osgi;

import static org.junit.Assert.*;

import org.eclipse.emf.transaction.ResourceSetListener;
import org.junit.Test;

import corvus.domain.e4.workspace.MarkerUtil;
import corvus.domain.e4.workspace.ViewController;
import corvus.domain.e4.workspace.osgi.d2m.OsgiMarkerUtilImpl;
import corvus.domain.e4.workspace.osgi.d2m.OsgiViewControllerImpl;
import corvus.domain.e4.workspace.osgi.m2m.entrypoint.OsgiEntryPointM2MListener;
import corvus.domain.e4.workspace.osgi.m2v.entrypoint.OsgiEntryPointM2VListener;

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

	@Test
	public void shouldLoadOsgiMarkerUtilImpl() {
		MarkerUtil markerUtil = OsgiTestUtil.getService(OsgiDSTest.class, MarkerUtil.class, OsgiMarkerUtilImpl.class.getName());
		assertNotNull(markerUtil);
		assertTrue(markerUtil instanceof OsgiMarkerUtilImpl);
	}

	@Test
	public void shouldLoadOsgiViewControllerImpl() {
		ViewController viewController = OsgiTestUtil.getService(OsgiDSTest.class, ViewController.class, OsgiViewControllerImpl.class.getName());
		assertNotNull(viewController);
		assertTrue(viewController instanceof OsgiViewControllerImpl);
	}	

}
