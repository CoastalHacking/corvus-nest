package corvus.domain.e4.workspace.osgi.internal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import corvus.domain.e4.workspace.MarkerUtil;
import corvus.domain.e4.workspace.ViewController;
import corvus.domain.e4.workspace.osgi.internal.OsgiMarkerUtilImpl;
import corvus.domain.e4.workspace.osgi.internal.OsgiViewControllerImpl;
import corvus.domain.e4.workspace.osgi.testutils.OsgiTestUtil;

public class OsgiDSTest {

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
