package corvus.resource;

import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.google.inject.Module;

import corvus.common.test.CorvusAbstractEmfParsleyTest;

public abstract class AbstractResourceTest extends CorvusAbstractEmfParsleyTest {

	@Override
	protected Module getModule(AbstractUIPlugin plugin) {
		return new ResourceEmfParsleyGuiceModule(plugin);
	}

}
