package corvus.domain.e4.workspace.d2m;

import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.google.inject.Module;

import corvus.common.test.CorvusAbstractEmfParsleyTest;

public abstract class AbstractD2MTest extends CorvusAbstractEmfParsleyTest {

	@Override
	protected Module getModule(AbstractUIPlugin plugin) {
		return new D2mEmfParsleyGuiceModule(plugin);
	}

}
