package corvus.domain.e4.workspace.emf;

import corvus.domain.e4.workspace.WorkspaceEmfParsleyGuiceModule;
import corvus.domain.e4.workspace.emf.EmfMarkerUtil;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings("all")
public class EmfEmfParsleyGuiceModule extends WorkspaceEmfParsleyGuiceModule {
  public EmfEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  public Class<? extends EmfMarkerUtil> bindEmfMarkerUtil() {
    return EmfMarkerUtil.class;
  }
}
