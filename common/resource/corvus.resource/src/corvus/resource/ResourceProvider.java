package corvus.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ResourceProvider implements Provider<Resource> {

	@Inject
	Configurator configurator;
	
	@Inject
	TransactionalEditingDomain ted;
	
	@Override
	public Resource get() {
//		ted.getResourceSet().getResource(uri, loadOnDemand)
		return null;
	}

}
