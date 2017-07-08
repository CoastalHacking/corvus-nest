package corvus.resource;

import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import corvus.common.test.TestConfigurator;

public class TestCaseModule extends ResourceEmfParsleyGuiceModule {

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