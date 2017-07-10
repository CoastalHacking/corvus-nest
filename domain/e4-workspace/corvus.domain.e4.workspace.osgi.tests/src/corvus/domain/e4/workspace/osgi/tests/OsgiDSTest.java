package corvus.domain.e4.workspace.osgi.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.resources.IResourceChangeListener;
import org.junit.Test;

import corvus.common.osgi.test.OsgiTestUtil;
import corvus.domain.e4.workspace.MarkerUtil;
import corvus.domain.e4.workspace.ViewController;
import corvus.domain.e4.workspace.osgi.OsgiMarkerUtilImpl;
import corvus.domain.e4.workspace.osgi.OsgiViewControllerImpl;
import corvus.domain.e4.workspace.osgi.d2m.OsgiMarkerResourceChangeListener;

public class OsgiDSTest {

	@Test
	public void shouldLoadOsgiMarkerUtilImpl() throws InterruptedException {
		MarkerUtil markerUtil = OsgiTestUtil.getService(OsgiDSTest.class, MarkerUtil.class, OsgiMarkerUtilImpl.class.getName());
		assertNotNull(markerUtil);
		assertTrue(markerUtil instanceof OsgiMarkerUtilImpl);
	}

	@Test
	public void shouldLoadOsgiViewControllerImpl() throws InterruptedException {
		ViewController viewController = OsgiTestUtil.getService(OsgiDSTest.class, ViewController.class, OsgiViewControllerImpl.class.getName());
		assertNotNull(viewController);
		assertTrue(viewController instanceof OsgiViewControllerImpl);
	}

	@Test
	public void shouldLoadOsgiMarkerResourceChangeListener() throws InterruptedException {
		IResourceChangeListener service = OsgiTestUtil.getService(OsgiDSTest.class, IResourceChangeListener.class, OsgiMarkerResourceChangeListener.class.getName());
		assertNotNull(service);
		assertTrue(service instanceof OsgiMarkerResourceChangeListener);
	}	
}
