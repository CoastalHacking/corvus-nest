package corvus.domain.e4.workspace.emf;

import com.google.inject.Guice;
import com.google.inject.Injector;
import corvus.domain.e4.workspace.emf.EmfEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;

@SuppressWarnings("all")
public class EmfInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new EmfEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(EmfInjectorProvider.class))));
    }
    return injector;
  }
}
