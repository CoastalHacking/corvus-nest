package corvus.domain.e4.workspace.m2v.entrypoint;

import com.google.inject.Provider;
import corvus.domain.e4.workspace.WorkspaceEmfParsleyGuiceModule;
import corvus.domain.e4.workspace.m2v.entrypoint.EntryPointM2VNotificationFilterProvider;
import corvus.domain.e4.workspace.m2v.entrypoint.EntryPointM2VNotificationsConsumer;
import corvus.model.entrypoint.config.EntrypointConfigurator;
import corvus.model.entrypoint.resource.EntrypointResourceManager;
import corvus.resource.NotificationsConsumer;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.parsley.resource.ResourceManager;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * corvus.domain.e4.workspace.m2v.entrypoint EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class EntrypointEmfParsleyGuiceModule extends WorkspaceEmfParsleyGuiceModule {
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
  
  @Override
  public Class<? extends Configurator> bindConfigurator() {
    return EntrypointConfigurator.class;
  }
  
  @Override
  public Class<? extends ResourceManager> bindResourceManager() {
    return EntrypointResourceManager.class;
  }
}
