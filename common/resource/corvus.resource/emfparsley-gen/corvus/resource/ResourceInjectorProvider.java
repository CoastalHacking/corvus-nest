package corvus.resource;

import com.google.inject.Guice;
import com.google.inject.Injector;
import corvus.resource.ResourceEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;

@SuppressWarnings("all")
public class ResourceInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new ResourceEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(ResourceInjectorProvider.class))));
    }
    return injector;
  }
}
