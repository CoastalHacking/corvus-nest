package corvus.resource;

import com.google.inject.Provider;
import corvus.transactional.SingletonTransactionalEditingDomainProvider;
import corvus.transactional.TransactionalEmfParsleyGuiceModule;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * corvus.resource EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class ResourceEmfParsleyGuiceModule extends TransactionalEmfParsleyGuiceModule {
  public ResourceEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  @Override
  public Class<? extends Provider<TransactionalEditingDomain>> provideTransactionalEditingDomain() {
    return SingletonTransactionalEditingDomainProvider.class;
  }
}
