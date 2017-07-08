package corvus.domain.e4.workspace;

import org.eclipse.core.resources.IMarker;

public interface ViewController {

	ICompositeProvider getCompositeProvider(IMarker marker);
}
