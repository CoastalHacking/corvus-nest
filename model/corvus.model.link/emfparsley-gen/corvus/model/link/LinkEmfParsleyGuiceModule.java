package corvus.model.link;

import corvus.model.link.InjectedLinkAdapterFactory;
import corvus.model.link.config.LinkConfigurator;
import corvus.model.link.resource.LinkResourceManager;
import corvus.resource.ResourceEmfParsleyGuiceModule;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.parsley.resource.ResourceManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings("all")
public class LinkEmfParsleyGuiceModule extends ResourceEmfParsleyGuiceModule {
  public LinkEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  @Override
  public Class<? extends AdapterFactory> bindAdapterFactory() {
    return InjectedLinkAdapterFactory.class;
  }
  
  @Override
  public Class<? extends Configurator> bindConfigurator() {
    return LinkConfigurator.class;
  }
  
  @Override
  public Class<? extends ResourceManager> bindResourceManager() {
    return LinkResourceManager.class;
  }
}
