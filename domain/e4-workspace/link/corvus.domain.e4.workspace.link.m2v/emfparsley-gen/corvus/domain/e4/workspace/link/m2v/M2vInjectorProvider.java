package corvus.domain.e4.workspace.link.m2v;

import com.google.inject.Guice;
import com.google.inject.Injector;
import corvus.domain.e4.workspace.link.m2v.M2vEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;

@SuppressWarnings("all")
public class M2vInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new M2vEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(M2vInjectorProvider.class))));
    }
    return injector;
  }
}
