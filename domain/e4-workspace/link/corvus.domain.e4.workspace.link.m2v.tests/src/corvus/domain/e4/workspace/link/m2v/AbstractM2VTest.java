package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.google.inject.Provider;

import corvus.common.test.CorvusAbstractEmfParsleyTest;
import corvus.common.test.TestConfigurator;
import corvus.transactional.SingletonTransactionalEditingDomainProvider;
import corvus.transactional.TransactionalEmfParsleyGuiceModule;

public abstract class AbstractM2VTest extends CorvusAbstractEmfParsleyTest {

	@Override
	protected TransactionalEmfParsleyGuiceModule getTestModule(AbstractUIPlugin plugin, String id) {
		return new TestCaseModule(plugin, id);
	}

	// Hack: below copied from ResourceProviderTest
	// just changed the super to D2mEmfParsleyGuiceModule
	public static class TestCaseModule extends M2vEmfParsleyGuiceModule {

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

		public Class<? extends Provider<TransactionalEditingDomain>> provideTransactionalEditingDomain() {
			// create an editing domain per caller
			return SingletonTransactionalEditingDomainProvider.class;
		}
	}	
}
