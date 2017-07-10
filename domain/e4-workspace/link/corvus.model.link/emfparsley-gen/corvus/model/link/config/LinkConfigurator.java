package corvus.model.link.config;

import corvus.model.link.LinkActivator;
import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;
import org.osgi.framework.BundleContext;

@SuppressWarnings("all")
public class LinkConfigurator extends Configurator {
  public URI resourceURI(final Object it) {
    URI _xblockexpression = null;
    {
      final BundleContext bc = PluginUtil.getBundle(LinkActivator.class).getBundleContext();
      final File file = bc.getBundle().getDataFile("corvus.model.link");
      _xblockexpression = URI.createFileURI(file.getAbsolutePath());
    }
    return _xblockexpression;
  }
}
