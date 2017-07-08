package corvus.domain.e4.workspace;

import com.google.inject.Provider;
import corvus.domain.e4.workspace.CompositeProviderAdapterFactory;
import corvus.domain.e4.workspace.CompositeProviderAdapterProvider;
import corvus.domain.e4.workspace.ICompositeProviderAdapter;
import corvus.domain.e4.workspace.InjectableCompositeProviderAdapterFactory;
import corvus.domain.org.eclipse.core.resources.ResourcesEmfParsleyGuiceModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings("all")
public class WorkspaceEmfParsleyGuiceModule extends ResourcesEmfParsleyGuiceModule {
  public WorkspaceEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  public Class<? extends CompositeProviderAdapterFactory> bindCompositeProviderAdapterFactory() {
    return InjectableCompositeProviderAdapterFactory.class;
  }
  
  public Class<? extends Provider<ICompositeProviderAdapter>> provideICompositeProviderAdapter() {
    return CompositeProviderAdapterProvider.class;
  }
}
