package corvus.model.entrypoint;

import com.google.inject.Guice;
import com.google.inject.Injector;
import corvus.model.entrypoint.EntrypointEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;

@SuppressWarnings("all")
public class EntrypointInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new EntrypointEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(EntrypointInjectorProvider.class))));
    }
    return injector;
  }
}
