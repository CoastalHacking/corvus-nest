package corvus.domain.org.eclipse.core.resources;

import com.google.inject.Guice;
import com.google.inject.Injector;
import corvus.domain.org.eclipse.core.resources.ResourcesEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;

@SuppressWarnings("all")
public class ResourcesInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new ResourcesEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(ResourcesInjectorProvider.class))));
    }
    return injector;
  }
}
