package corvus.domain.e4.workspace.entrypoint;

import corvus.domain.e4.workspace.WorkspaceEmfParsleyGuiceModule;
import corvus.model.entrypoint.config.EntrypointConfigurator;
import corvus.model.entrypoint.resource.EntrypointResourceManager;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.parsley.resource.ResourceManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings("all")
public class EntrypointEmfParsleyGuiceModule extends WorkspaceEmfParsleyGuiceModule {
  public EntrypointEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  public String valueEntryPointMarker() {
    return "corvus.domain.e4.workspace.entrypoint.entryPointMarker";
  }
  
  @Override
  public Class<? extends Configurator> bindConfigurator() {
    return EntrypointConfigurator.class;
  }
  
  @Override
  public Class<? extends ResourceManager> bindResourceManager() {
    return EntrypointResourceManager.class;
  }
}
