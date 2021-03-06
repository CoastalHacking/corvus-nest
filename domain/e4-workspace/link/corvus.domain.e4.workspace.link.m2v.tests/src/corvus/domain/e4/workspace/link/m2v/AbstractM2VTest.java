package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.google.inject.Module;

import corvus.common.test.CorvusAbstractEmfParsleyTest;

public abstract class AbstractM2VTest extends CorvusAbstractEmfParsleyTest {

	@Override
	protected Module getModule(AbstractUIPlugin plugin) {
		return new M2vEmfParsleyGuiceModule(plugin);
	}
}
