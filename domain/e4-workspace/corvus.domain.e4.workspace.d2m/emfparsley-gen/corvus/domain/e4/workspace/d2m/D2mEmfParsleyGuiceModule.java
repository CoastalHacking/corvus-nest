package corvus.domain.e4.workspace.d2m;

import corvus.domain.e4.workspace.MarkerController;
import corvus.domain.e4.workspace.MarkerUtil;
import corvus.domain.e4.workspace.ViewController;
import corvus.domain.e4.workspace.WorkspaceEmfParsleyGuiceModule;
import corvus.domain.e4.workspace.d2m.MarkerControllerImpl;
import corvus.domain.e4.workspace.d2m.MarkerResourceChangeListener;
import corvus.domain.e4.workspace.d2m.MarkerUtilImpl;
import corvus.domain.e4.workspace.d2m.ViewControllerImpl;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings("all")
public class D2mEmfParsleyGuiceModule extends WorkspaceEmfParsleyGuiceModule {
  public D2mEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  public Class<? extends MarkerUtil> bindMarkerUtil() {
    return MarkerUtilImpl.class;
  }
  
  public Class<? extends MarkerController> bindMarkerController() {
    return MarkerControllerImpl.class;
  }
  
  public Class<? extends ViewController> bindViewController() {
    return ViewControllerImpl.class;
  }
  
  public Class<? extends IResourceChangeListener> bindIResourceChangeListener() {
    return MarkerResourceChangeListener.class;
  }
}
