package corvus.domain.e4.workspace.link.m2v;

import com.google.inject.Provider;
import corvus.domain.e4.workspace.link.LinkEmfParsleyGuiceModule;
import corvus.domain.e4.workspace.link.m2v.LinkM2VNotificationFilterProvider;
import corvus.domain.e4.workspace.link.m2v.M2VInjectableAdapterFactory;
import corvus.domain.e4.workspace.link.m2v.M2VLinkItemProviderAdapterFactory;
import corvus.domain.e4.workspace.link.m2v.M2VLinkItemProviderProvider;
import corvus.domain.e4.workspace.link.m2v.M2VNotificationsConsumer;
import corvus.model.link.provider.LinkItemProvider;
import corvus.model.link.provider.LinkItemProviderAdapterFactory;
import corvus.resource.NotificationsConsumer;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings("all")
public class M2vEmfParsleyGuiceModule extends LinkEmfParsleyGuiceModule {
  public M2vEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  @Override
  public Class<? extends Provider<NotificationFilter>> provideNotificationFilter() {
    return LinkM2VNotificationFilterProvider.class;
  }
  
  public Class<? extends Provider<LinkItemProvider>> provideLinkItemProvider() {
    return M2VLinkItemProviderProvider.class;
  }
  
  public Class<? extends LinkItemProviderAdapterFactory> bindLinkItemProviderAdapterFactory() {
    return M2VLinkItemProviderAdapterFactory.class;
  }
  
  @Override
  public Class<? extends NotificationsConsumer> bindNotificationsConsumer() {
    return M2VNotificationsConsumer.class;
  }
  
  @Override
  public Class<? extends AdapterFactory> bindAdapterFactory() {
    return M2VInjectableAdapterFactory.class;
  }
}
