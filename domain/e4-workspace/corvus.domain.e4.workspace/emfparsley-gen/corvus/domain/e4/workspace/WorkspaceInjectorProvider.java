package corvus.domain.e4.workspace;

import com.google.inject.Guice;
import com.google.inject.Injector;
import corvus.domain.e4.workspace.WorkspaceEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;

@SuppressWarnings("all")
public class WorkspaceInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new WorkspaceEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(WorkspaceInjectorProvider.class))));
    }
    return injector;
  }
}
