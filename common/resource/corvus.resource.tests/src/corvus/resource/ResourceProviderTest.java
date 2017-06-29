package corvus.resource;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.google.inject.Injector;

public class ResourceProviderTest extends AbstractEmfParsleyTest {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest#createInjector()
	 */
	@Override
	protected Injector createInjector() {
		String id = UUID.randomUUID().toString();
		return createInjector(new TestModule(
				PluginUtil.getPlugin(
						PluginUtil.getBundle(ResourceActivator.class)),
				id));
	}

	@Test
	public void shouldInjectResource() {

		// TODO: make injectable?
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		Injector injector = getOrCreateInjector();
		Resource resource = injector.getInstance(Resource.class);
		assertNotNull(resource);

	}

	public static class TestConfigurator extends Configurator {

		@Rule
		public TemporaryFolder tempFolder = new TemporaryFolder();

		public URI resourceURI(Object object) {
			URI result = null;
			try {
				tempFolder.create();
				result = URI.createFileURI(tempFolder.newFile().getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
	}

	private static class TestModule extends ResourceEmfParsleyGuiceModule {

		private String id;

		public TestModule(AbstractUIPlugin plugin, String id) {
			super(plugin);
			this.id = id;
		}

		@Override
		public Class<? extends Configurator> bindConfigurator() {
			return TestConfigurator.class;
		}
		
		@Override
		public String valueTransactionalEditingDomainId() {
			return id;
		}
		
	}
}
