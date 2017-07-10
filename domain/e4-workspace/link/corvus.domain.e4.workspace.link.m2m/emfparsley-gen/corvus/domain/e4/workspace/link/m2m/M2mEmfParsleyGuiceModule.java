package corvus.domain.e4.workspace.link.m2m;

import com.google.inject.Provider;
import corvus.domain.e4.workspace.DefaultM2MNotificationFilterProvider;
import corvus.domain.e4.workspace.link.LinkEmfParsleyGuiceModule;
import corvus.domain.e4.workspace.link.m2m.LinkM2MNotificationsConsumer;
import corvus.resource.NotificationsConsumer;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings("all")
public class M2mEmfParsleyGuiceModule extends LinkEmfParsleyGuiceModule {
  public M2mEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  @Override
  public Class<? extends Provider<NotificationFilter>> provideNotificationFilter() {
    return DefaultM2MNotificationFilterProvider.class;
  }
  
  @Override
  public Class<? extends NotificationsConsumer> bindNotificationsConsumer() {
    return LinkM2MNotificationsConsumer.class;
  }
}
