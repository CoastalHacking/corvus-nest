package corvus.domain.e4.workspace.m2v.entrypoint;

import com.google.inject.Provider;
import corvus.domain.e4.workspace.m2v.entrypoint.EntryPointM2VNotificationFilterProvider;
import corvus.domain.e4.workspace.m2v.entrypoint.EntryPointM2VNotificationsConsumer;
import corvus.domain.e4.workspace.m2v.entrypoint.InjectableCompositeProviderAdapter;
import corvus.resource.NotificationsConsumer;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * corvus.domain.e4.workspace.m2v.entrypoint EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class EntrypointEmfParsleyGuiceModule extends corvus.model.entrypoint.EntrypointEmfParsleyGuiceModule {
  public EntrypointEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  @Override
  public Class<? extends Provider<NotificationFilter>> provideNotificationFilter() {
    return EntryPointM2VNotificationFilterProvider.class;
  }
  
  @Override
  public Class<? extends NotificationsConsumer> bindNotificationsConsumer() {
    return EntryPointM2VNotificationsConsumer.class;
  }
  
  public Class<? extends InjectableCompositeProviderAdapter> bindInjectableCompositeProviderAdapter() {
    return InjectableCompositeProviderAdapter.class;
  }
}
