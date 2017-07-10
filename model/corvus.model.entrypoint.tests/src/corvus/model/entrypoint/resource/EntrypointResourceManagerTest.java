package corvus.model.entrypoint.resource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.junit.Test;

import com.google.inject.Injector;

import corvus.common.test.CorvusAbstractEmfParsleyTest;
import corvus.common.test.TestConfigurator;
import corvus.model.entrypoint.EntryPointFramework;
import corvus.model.entrypoint.EntrypointEmfParsleyGuiceModule;
import corvus.transactional.TransactionalEmfParsleyGuiceModule;

public class EntrypointResourceManagerTest extends CorvusAbstractEmfParsleyTest {

	@Test
	public void shouldHaveGenericFrameworkAsRoot() {
		Injector injector = getOrCreateInjector();
		Resource resource = injector.getInstance(Resource.class);
		assertFalse(resource.getContents().isEmpty());
		Object root = resource.getContents().get(0);
		assertNotNull(root);
		assertTrue(root instanceof EntryPointFramework);
	}

	public static class TestCaseModule extends EntrypointEmfParsleyGuiceModule {

		private String id;

		public TestCaseModule(AbstractUIPlugin plugin, String id) {
			super(plugin);
			this.id = id;
		}
		
		public Class<? extends Configurator> bindConfigurator() {
			return TestConfigurator.class;
		}

		public String valueTransactionalEditingDomainId() {
			return id;
		}
	}

	@Override
	protected TransactionalEmfParsleyGuiceModule getTestModule(AbstractUIPlugin plugin, String id) {
		return new TestCaseModule(plugin, id);
	}

}
