package corvus.resource;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * 
 * Assumes resources within the resource set have been demand loaded
 * 
 *
 */
public abstract class ModelToModelCommandFragmentImpl implements ModelToModelCommandFragment {

	protected Map<?, ?> options;
	protected URI uri;

	public ModelToModelCommandFragmentImpl(URI uri) {
		this.uri = uri;
		this.options = Collections.EMPTY_MAP;
	}
	
	public ModelToModelCommandFragmentImpl(URI uri, Map<?, ?> options) {
		this.uri = uri;
		this.options = options;
	}

	/* (non-Javadoc)
	 * @see corvus.resource.ModelToModelCommandFragment#doExecute(java.util.List)
	 */
	@Override
	public void doExecute(List<Notification> notifications) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.example.resourcesetlistener.ModelToModelCommandFragment#getOptions()
	 */
	@Override
	public Map<?, ?> getOptions() {
		return options;
	}

	/**
	 * Helper method to obtain a resource given an event
	 * 
	 * @param event Non-nullable resource set change event
	 * @return a previously demand-loaded resource or null
	 */
	protected Resource getResource(ResourceSetChangeEvent event) {
		Resource result = null;
		TransactionalEditingDomain ted = event.getEditingDomain();
		ResourceSet rset = ted.getResourceSet();
		if (rset != null) {
			result = rset.getResource(uri, false);
		}
		return result;
	}


}
