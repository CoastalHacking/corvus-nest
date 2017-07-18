package corvus.domain.e4.workspace;

import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.google.inject.Module;

import corvus.common.test.CorvusAbstractEmfParsleyTest;

public abstract class AbstractWorkspaceTest extends CorvusAbstractEmfParsleyTest {

	@Override
	protected Module getModule(AbstractUIPlugin plugin) {
		return new WorkspaceEmfParsleyGuiceModule(plugin);
	}

}
