package corvus.domain.e4.workspace.link;

import com.google.inject.Guice;
import com.google.inject.Injector;
import corvus.domain.e4.workspace.link.LinkEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;

@SuppressWarnings("all")
public class LinkInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new LinkEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(LinkInjectorProvider.class))));
    }
    return injector;
  }
}
