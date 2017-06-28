package corvus.resource;

import corvus.transactional.TransactionalEmfParsleyGuiceModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * corvus.resource EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class ResourceEmfParsleyGuiceModule extends TransactionalEmfParsleyGuiceModule {
  public ResourceEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
