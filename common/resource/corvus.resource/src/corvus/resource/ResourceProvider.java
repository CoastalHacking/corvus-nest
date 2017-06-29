package corvus.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.parsley.resource.ResourceLoader;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ResourceProvider implements Provider<Resource> {

	@Inject
	Configurator configurator;
	
	@Inject
	ResourceLoader resourceLoader;
	
	@Inject
	TransactionalEditingDomain ted;
	
	@Override
	public Resource get() {
		URI uri = configurator.resourceURI(this);
		return resourceLoader.getResource(ted, uri).getResource();
	}

}
