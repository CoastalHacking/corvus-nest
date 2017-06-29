package corvus.domain.org.eclipse.core.resources;

import corvus.domain.org.eclipse.core.resources.config.ResourcesConfigurator;
import corvus.resource.ResourceEmfParsleyGuiceModule;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * corvus.domain.org.eclipse.core.resources EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class ResourcesEmfParsleyGuiceModule extends ResourceEmfParsleyGuiceModule {
  public ResourcesEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  @Override
  public Class<? extends Configurator> bindConfigurator() {
    return ResourcesConfigurator.class;
  }
}
