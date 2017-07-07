package corvus.common.test;

import java.util.UUID;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import corvus.transactional.TransactionalEmfParsleyGuiceModule;

public abstract class CorvusAbstractEmfParsleyTest extends AbstractEmfParsleyTest {

	public CorvusAbstractEmfParsleyTest() {
		super();

		// TODO: make injectable?
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	}

	protected abstract TransactionalEmfParsleyGuiceModule getTestModule(AbstractUIPlugin plugin, String id);

	/* (non-Javadoc)
	 * @see org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest#createInjector()
	 */
	@Override
	protected Injector createInjector() {
		final String id = UUID.randomUUID().toString();
		final Bundle bundle = PluginUtil.getBundle(getClass());
		final AbstractUIPlugin plugin = PluginUtil.getPlugin(bundle);
		final TransactionalEmfParsleyGuiceModule module = getTestModule(plugin, id);
		return createInjector(module);
	}
}
