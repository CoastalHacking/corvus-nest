package corvus.domain.e4.workspace.m2m.entrypoint;

import com.google.inject.Provider;
import corvus.domain.e4.workspace.m2m.entrypoint.EntryPointM2MNotificationFilterProvider;
import corvus.domain.e4.workspace.m2m.entrypoint.EntryPointM2MNotificationsConsumer;
import corvus.resource.NotificationsConsumer;
import org.eclipse.emf.transaction.NotificationFilter;
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
  public Class<? extends Provider<NotificationFilter>> provideNotificationFilter() {
    return EntryPointM2MNotificationFilterProvider.class;
  }
  
  @Override
  public Class<? extends NotificationsConsumer> bindNotificationsConsumer() {
    return EntryPointM2MNotificationsConsumer.class;
  }
}
