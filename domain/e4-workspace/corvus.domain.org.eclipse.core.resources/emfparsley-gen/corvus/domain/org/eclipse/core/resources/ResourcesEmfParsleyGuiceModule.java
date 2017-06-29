package corvus.domain.org.eclipse.core.resources;

import corvus.resource.ResourceEmfParsleyGuiceModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * corvus.domain.org.eclipse.core.resources EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class ResourcesEmfParsleyGuiceModule extends ResourceEmfParsleyGuiceModule {
  public ResourcesEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
