package corvus.resource;

import corvus.resource.ResourceAdapterEcoreUtil;
import corvus.transactional.TransactionalEmfParsleyGuiceModule;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * corvus.resource EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class ResourceEmfParsleyGuiceModule extends TransactionalEmfParsleyGuiceModule {
  public ResourceEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  public Class<? extends EcoreUtil> bindEcoreUtil() {
    return ResourceAdapterEcoreUtil.class;
  }
}
