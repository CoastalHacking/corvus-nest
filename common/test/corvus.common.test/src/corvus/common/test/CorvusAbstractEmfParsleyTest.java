package corvus.common.test;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest;
import org.eclipse.emf.parsley.runtime.service.AbstractGenericModule;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.util.Modules;

import corvus.transactional.SingletonTransactionalEditingDomainProvider;

public abstract class CorvusAbstractEmfParsleyTest extends AbstractEmfParsleyTest {

	public CorvusAbstractEmfParsleyTest() {
		super();

		// TODO: make injectable?
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	}

	/* By default create an injector that uses overrides from a test case module
	 *
	 * @see org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest#createInjector()
	 */
	@Override
	protected Injector createInjector() {

		final AbstractUIPlugin plugin = PluginUtil.getPlugin(
				PluginUtil.getBundle(getClass()));

		final Module module = getModule(plugin);

		return createInjector(
				Modules.override(module).with(getTestCaseModule()));
	}

	/**
	 * Return a project-specific Guice module
	 * 
	 * @param plugin an abstract UI plug-in
	 * @return module a Guice module
	 */
	protected abstract Module getModule(AbstractUIPlugin plugin);

	/**
	 * Return a default test case module with transactional overrides
	 * 
	 * @return a test case module
	 */
	protected TestCaseModule getTestCaseModule() {
		final String id = UUID.randomUUID().toString();
		return new TestCaseModule(id);
	}

	public <T> T shouldInjectInstance(Class<T> clazz) {
		Injector injector = getOrCreateInjector();
		T result = injector.getInstance(clazz);
		assertNotNull(result);
		return result;
	}

	/**
	 * 
	 * Note: do not extend any actual modules, else those bindings override
	 * whatever "production" module that's being tested.
	 * 
	 *
	 */
	public static class TestCaseModule extends AbstractGenericModule {

		private String id;

		public TestCaseModule(String id) {
			this.id = id;
		}

		public Class<? extends Configurator> bindConfigurator() {
			return TestConfigurator.class;
		}

		public String valueTransactionalEditingDomainId() {
			return id;
		}

		public Class<? extends Provider<TransactionalEditingDomain>> provideTransactionalEditingDomain() {
			// create an editing domain per caller
			return SingletonTransactionalEditingDomainProvider.class;
		}

	}

}
