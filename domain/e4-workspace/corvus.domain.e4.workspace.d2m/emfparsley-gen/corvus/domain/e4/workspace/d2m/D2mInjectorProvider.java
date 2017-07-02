package corvus.domain.e4.workspace.d2m;

import com.google.inject.Guice;
import com.google.inject.Injector;
import corvus.domain.e4.workspace.d2m.D2mEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;

@SuppressWarnings("all")
public class D2mInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    if (injector == null) {
      injector = Guice.createInjector(
        new D2mEmfParsleyGuiceModule(PluginUtil.getPlugin(
          PluginUtil.getBundle(D2mInjectorProvider.class))));
    }
    return injector;
  }
}
