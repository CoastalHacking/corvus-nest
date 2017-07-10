package corvus.domain.e4.workspace.osgi.testutils;

import java.util.Dictionary;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

public class OsgiTestUtil {

	// http://blog.vogella.com/2016/07/04/osgi-component-testing/
	// This leaks ServiceTrackers
	public static <B, T> T getService(Class<B> bundleClass, Class<T> serviceClass, String filteredClassName) {
		Bundle bundle = FrameworkUtil.getBundle(bundleClass);
		T results = null;
		if (bundle != null) {
			// Ensure a call to get the context returns something non-null

			try {
				bundle.start();
				// https://eclipsesource.com/blogs/2012/11/30/finding-the-right-osgi-services-using-the-objectclass-property/
				String stringFilter = String.format("(&(%s=%s)(component.name=%s))", Constants.OBJECTCLASS, serviceClass.getName(), filteredClassName);
				Filter filter = bundle.getBundleContext().createFilter(stringFilter);
				ServiceTracker<T, T> st = new ServiceTracker<T, T>(bundle.getBundleContext(), filter, null);
				st.open();
				if (st != null) {
					try {
						results = st.waitForService(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			} catch (BundleException | InvalidSyntaxException e1) {
				e1.printStackTrace();
			}
		}
		return results;
	}

	public static <B, T> ServiceRegistration<T> registerService(Class<B> bundleClass, Class<T> serviceClass,
			T service, Dictionary<String, ?> properties) {
		Bundle bundle = FrameworkUtil.getBundle(bundleClass);
		if (bundle != null) {
			// Ensure a call to get the context returns something non-null
			try {
				bundle.start();
				return bundle.getBundleContext().registerService(serviceClass, service, properties);
			} catch (BundleException e1) {
			}
		}
		return null;
	}

	public static <B, T> ServiceRegistration<T> setService(Class<B> bundleClass, Class<T> serviceClass, T service) {
		Bundle bundle = FrameworkUtil.getBundle(bundleClass);
		if (bundle != null) {
			return bundle.getBundleContext().registerService(serviceClass, service, null);
		}
		return null;
	}

}
