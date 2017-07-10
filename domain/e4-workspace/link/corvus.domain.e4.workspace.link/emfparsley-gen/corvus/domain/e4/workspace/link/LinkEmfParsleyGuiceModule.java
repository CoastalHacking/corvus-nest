package corvus.domain.e4.workspace.link;

import com.google.inject.Provider;
import corvus.domain.e4.workspace.CompositeProviderAdapterFactory;
import corvus.domain.e4.workspace.CompositeProviderAdapterProvider;
import corvus.domain.e4.workspace.ICompositeProviderAdapter;
import corvus.domain.e4.workspace.InjectableCompositeProviderAdapterFactory;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings("all")
public class LinkEmfParsleyGuiceModule extends corvus.model.link.LinkEmfParsleyGuiceModule {
  public LinkEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  public Class<? extends CompositeProviderAdapterFactory> bindCompositeProviderAdapterFactory() {
    return InjectableCompositeProviderAdapterFactory.class;
  }
  
  public Class<? extends Provider<ICompositeProviderAdapter>> provideICompositeProviderAdapter() {
    return CompositeProviderAdapterProvider.class;
  }
  
  public String valueCorvusDomainMarker() {
    return "corvus.domain.e4.workspace.link.linkMarker";
  }
}
