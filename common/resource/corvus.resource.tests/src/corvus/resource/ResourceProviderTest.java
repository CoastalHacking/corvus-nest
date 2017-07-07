package corvus.resource;

import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.junit.Test;

import com.google.inject.Injector;

import corvus.common.test.CorvusAbstractEmfParsleyTest;
import corvus.common.test.TestConfigurator;
import corvus.transactional.TransactionalEmfParsleyGuiceModule;

public class ResourceProviderTest extends CorvusAbstractEmfParsleyTest {

	@Test
	public void shouldInjectResource() {

		Injector injector = getOrCreateInjector();
		Resource resource = injector.getInstance(Resource.class);
		assertNotNull(resource);

	}

	// Not glorious... but it blends
	public static class TestCaseModule extends ResourceEmfParsleyGuiceModule {

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
