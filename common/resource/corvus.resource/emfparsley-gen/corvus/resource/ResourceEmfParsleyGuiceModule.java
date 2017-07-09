package corvus.resource;

import com.google.inject.Provider;
import corvus.resource.DefaultNotificationFilterProvider;
import corvus.resource.InjectableResourceSetListener;
import corvus.resource.NotificationsConsumer;
import corvus.resource.ReadWriteTransaction;
import corvus.resource.ReadWriteTransactionProvider;
import corvus.resource.ResourceProvider;
import corvus.transactional.GlobalTransactionalEditingDomainProvider;
import corvus.transactional.TransactionalEmfParsleyGuiceModule;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetListener;
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
    return GlobalTransactionalEditingDomainProvider.class;
  }
  
  public Class<? extends Provider<Resource>> provideResource() {
    return ResourceProvider.class;
  }
  
  public Class<? extends Provider<NotificationFilter>> provideNotificationFilter() {
    return DefaultNotificationFilterProvider.class;
  }
  
  public Class<? extends Provider<ReadWriteTransaction>> provideReadWriteTransaction() {
    return ReadWriteTransactionProvider.class;
  }
  
  public Class<? extends ResourceSetListener> bindResourceSetListener() {
    return InjectableResourceSetListener.class;
  }
  
  public Class<? extends NotificationsConsumer> bindNotificationsConsumer() {
    return NotificationsConsumer.class;
  }
}
