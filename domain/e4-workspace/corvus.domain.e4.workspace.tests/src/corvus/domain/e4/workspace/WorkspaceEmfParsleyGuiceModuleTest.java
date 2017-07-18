package corvus.domain.e4.workspace;

import org.junit.Test;

import com.google.inject.Injector;

public class WorkspaceEmfParsleyGuiceModuleTest extends AbstractWorkspaceTest {

	@Test
	public void shouldInjectWorkspaceProvider() {
		Injector injector = getOrCreateInjector();
		injector.getProvider(WorkspaceProvider.class);
	}

}
