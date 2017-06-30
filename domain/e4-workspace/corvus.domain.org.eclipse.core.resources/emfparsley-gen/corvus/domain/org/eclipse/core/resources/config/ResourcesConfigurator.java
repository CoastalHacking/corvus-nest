package corvus.domain.org.eclipse.core.resources.config;

import corvus.domain.org.eclipse.core.resources.ResourcesActivator;
import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;
import org.osgi.framework.BundleContext;

@SuppressWarnings("all")
public class ResourcesConfigurator extends Configurator {
  public URI resourceURI(final Object it) {
    URI _xblockexpression = null;
    {
      final BundleContext bc = PluginUtil.getBundle(ResourcesActivator.class).getBundleContext();
      final File file = bc.getBundle().getDataFile("corvus.domain.org.eclipse.core.resources");
      _xblockexpression = URI.createFileURI(file.getAbsolutePath());
    }
    return _xblockexpression;
  }
}
