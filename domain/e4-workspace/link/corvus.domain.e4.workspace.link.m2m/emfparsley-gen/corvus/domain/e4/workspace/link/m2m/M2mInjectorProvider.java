package corvus.domain.e4.workspace.link.m2m;

import com.google.inject.Guice;
import com.google.inject.Injector;
import corvus.domain.e4.workspace.link.m2m.M2mEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;

@SuppressWarnings("all")
public class M2mInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new M2mEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(M2mInjectorProvider.class))));
    }
    return injector;
  }
}
