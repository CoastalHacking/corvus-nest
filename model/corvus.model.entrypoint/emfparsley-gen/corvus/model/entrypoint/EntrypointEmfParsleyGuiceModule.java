package corvus.model.entrypoint;

import corvus.model.entrypoint.config.EntrypointConfigurator;
import corvus.model.entrypoint.resource.EntrypointResourceManager;
import corvus.resource.ResourceEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.parsley.resource.ResourceManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * corvus.model.entrypoint EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class EntrypointEmfParsleyGuiceModule extends ResourceEmfParsleyGuiceModule {
  public EntrypointEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
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
