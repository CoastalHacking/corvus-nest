package corvus.domain.e4.workspace.link.m2v;

import com.google.inject.Provider;
import corvus.domain.e4.workspace.DefaultM2VNotificationsConsumer;
import corvus.domain.e4.workspace.link.LinkEmfParsleyGuiceModule;
import corvus.domain.e4.workspace.link.m2v.ExtendedLinkTableFeaturesProvider;
import corvus.domain.e4.workspace.link.m2v.LinkM2VNotificationFilterProvider;
import corvus.resource.NotificationsConsumer;
import org.eclipse.emf.parsley.ui.provider.TableFeaturesProvider;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings("all")
public class M2vEmfParsleyGuiceModule extends LinkEmfParsleyGuiceModule {
  public M2vEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  @Override
  public Class<? extends TableFeaturesProvider> bindTableFeaturesProvider() {
    return ExtendedLinkTableFeaturesProvider.class;
  }
  
  @Override
  public Class<? extends NotificationsConsumer> bindNotificationsConsumer() {
    return DefaultM2VNotificationsConsumer.class;
  }
  
  @Override
  public Class<? extends Provider<NotificationFilter>> provideNotificationFilter() {
    return LinkM2VNotificationFilterProvider.class;
  }
}
