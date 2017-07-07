package corvus.domain.e4.workspace.m2m.entrypoint;

import corvus.domain.e4.workspace.m2m.entrypoint.EntryPointModelToModelListener;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * corvus.domain.e4.workspace.m2m.entrypoint EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class EntrypointEmfParsleyGuiceModule extends corvus.model.entrypoint.EntrypointEmfParsleyGuiceModule {
  public EntrypointEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  @Override
  public Class<? extends ResourceSetListener> bindResourceSetListener() {
    return EntryPointModelToModelListener.class;
  }
}
