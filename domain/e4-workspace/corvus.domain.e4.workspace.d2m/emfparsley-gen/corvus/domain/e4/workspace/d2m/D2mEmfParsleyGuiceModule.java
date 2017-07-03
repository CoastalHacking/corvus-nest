package corvus.domain.e4.workspace.d2m;

import corvus.domain.e4.workspace.d2m.MarkerController;
import corvus.domain.e4.workspace.d2m.MarkerControllerImpl;
import corvus.domain.e4.workspace.d2m.MarkerUtil;
import corvus.domain.org.eclipse.core.resources.ResourcesEmfParsleyGuiceModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings("all")
public class D2mEmfParsleyGuiceModule extends ResourcesEmfParsleyGuiceModule {
  public D2mEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  public Class<? extends MarkerUtil> bindMarkerUtil() {
    return MarkerUtil.class;
  }
  
  public Class<? extends MarkerController> bindMarkerController() {
    return MarkerControllerImpl.class;
  }
}
