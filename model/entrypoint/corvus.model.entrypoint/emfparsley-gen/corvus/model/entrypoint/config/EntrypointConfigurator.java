package corvus.model.entrypoint.config;

import corvus.model.entrypoint.EntrypointActivator;
import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;
import org.osgi.framework.BundleContext;

@SuppressWarnings("all")
public class EntrypointConfigurator extends Configurator {
  public URI resourceURI(final Object it) {
    URI _xblockexpression = null;
    {
      final BundleContext bc = PluginUtil.getBundle(EntrypointActivator.class).getBundleContext();
      final File file = bc.getBundle().getDataFile("corvus.model.entrypoint");
      _xblockexpression = URI.createFileURI(file.getAbsolutePath());
    }
    return _xblockexpression;
  }
}
