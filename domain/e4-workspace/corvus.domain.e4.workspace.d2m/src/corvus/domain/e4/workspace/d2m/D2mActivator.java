package corvus.domain.e4.workspace.d2m;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class D2mActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "corvus.domain.e4.workspace.d2m"; //$NON-NLS-1$

	// The shared instance
	private static D2mActivator plugin;

	public D2mActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static D2mActivator getDefault() {
		return plugin;
	}

}
