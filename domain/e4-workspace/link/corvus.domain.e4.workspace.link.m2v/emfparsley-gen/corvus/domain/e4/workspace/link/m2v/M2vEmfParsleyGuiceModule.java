package corvus.domain.e4.workspace.link.m2v;

import com.google.inject.Provider;
import corvus.domain.e4.workspace.link.LinkController;
import corvus.domain.e4.workspace.link.LinkEmfParsleyGuiceModule;
import corvus.domain.e4.workspace.link.m2v.LinkM2VNotificationFilterProvider;
import corvus.domain.e4.workspace.link.m2v.M2VLinkController;
import corvus.domain.e4.workspace.link.m2v.M2VNotificationsConsumer;
import corvus.domain.e4.workspace.link.m2v.M2VStructuredContentAdapterProvider;
import corvus.domain.e4.workspace.link.m2v.StructuredItemContentAdapter;
import corvus.resource.NotificationsConsumer;
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
  
  public Class<? extends Provider<StructuredItemContentAdapter>> provideStructuredItemContentAdapter() {
    return M2VStructuredContentAdapterProvider.class;
  }
  
  @Override
  public Class<? extends NotificationsConsumer> bindNotificationsConsumer() {
    return M2VNotificationsConsumer.class;
  }
  
  public Class<? extends LinkController> bindLinkController() {
    return M2VLinkController.class;
  }
}
