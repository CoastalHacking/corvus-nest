package corvus.domain.e4.workspace.link.controller;

import corvus.domain.e4.workspace.link.LinkEmfParsleyGuiceModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings("all")
public class ControllerEmfParsleyGuiceModule extends LinkEmfParsleyGuiceModule {
  public ControllerEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
