package corvus.model.entrypoint.resource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.parsley.resource.ResourceManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.junit.Test;

import com.google.inject.Injector;
import com.google.inject.Module;

import corvus.common.test.CorvusAbstractEmfParsleyTest;
import corvus.model.entrypoint.EntryPointFramework;
import corvus.model.entrypoint.EntrypointEmfParsleyGuiceModule;

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

	@Override
	protected Module getModule(AbstractUIPlugin plugin) {
		return new EntrypointEmfParsleyGuiceModule(plugin);
	}

	@Test
	public void testShouldInjectResourceManager() {
		ResourceManager instance = shouldInjectInstance(ResourceManager.class);
		assertTrue(instance instanceof EntrypointResourceManager);
	}
}
