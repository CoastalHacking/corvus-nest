package corvus.transactional;

import com.google.inject.Provider;
import corvus.transactional.DefaultTransactionalEditingDomainFactory;
import corvus.transactional.TransactionalBackedEditingDomainProvider;
import corvus.transactional.TransactionalEditingDomainFinder;
import corvus.transactional.TransactionalEditingDomainProvider;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.parsley.EmfParsleyJavaGuiceModule;
import org.eclipse.emf.parsley.edit.EditingDomainFinder;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * corvus.transactional EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class TransactionalEmfParsleyGuiceModule extends EmfParsleyJavaGuiceModule {
  public TransactionalEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    // not used
  }
  
  public Class<? extends Provider<TransactionalEditingDomain.Factory>> provideFactory() {
    return DefaultTransactionalEditingDomainFactory.class;
  }
  
  public String valueTransactionalEditingDomainId() {
    return "org.example.parsley.transactional.id";
  }
  
  public Class<? extends Provider<TransactionalEditingDomain>> provideTransactionalEditingDomain() {
    return TransactionalEditingDomainProvider.class;
  }
  
  @Override
  public Class<? extends Provider<EditingDomain>> provideEditingDomain() {
    return TransactionalBackedEditingDomainProvider.class;
  }
  
  @Override
  public Class<? extends EditingDomainFinder> bindEditingDomainFinder() {
    return TransactionalEditingDomainFinder.class;
  }
}
