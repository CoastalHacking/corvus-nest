package corvus.domain.e4.workspace;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;

import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class WorkspaceProvider implements Provider<IWorkspace> {

	private IWorkspace workspace;

	@Override
	public IWorkspace get() {
		if (workspace == null) {
			workspace = ResourcesPlugin.getWorkspace();
		}
		return workspace;
	}

}
