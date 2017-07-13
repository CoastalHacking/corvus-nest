package corvus.domain.e4.workspace.link.controller;

import com.google.inject.Guice;
import com.google.inject.Injector;
import corvus.domain.e4.workspace.link.controller.ControllerEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;

@SuppressWarnings("all")
public class ControllerInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new ControllerEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(ControllerInjectorProvider.class))));
    }
    return injector;
  }
}
