/**
 * 
 */
package corvus.domain.e4.workspace.m2m.entrypoint;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.transaction.NotificationFilter;

import com.google.inject.Inject;

import corvus.domain.org.eclipse.core.resources.ResourcesPackage;
import corvus.resource.ModelToModelCommandFragment;
import corvus.resource.ModelToModelCommandFragmentImpl;
import corvus.resource.ModelToModelListener;

/**
 *
 *
 */
public class EntryPointModelToModelListener extends ModelToModelListener {

	@Inject
	private Configurator configurator;

	private URI entryPointUri;
	
	private NotificationFilter filter;

	/**
	 * 
	 */
	public EntryPointModelToModelListener() {
	}

	/* (non-Javadoc)
	 * @see corvus.resource.PostCommitEClassResourceSetListener#getFilter()
	 */
	@Override
	public NotificationFilter getFilter() {
		// Filter on notifications pertaining to the resource markers list
		if (filter == null) {
			filter = NotificationFilter.createFeatureFilter(ResourcesPackage.eINSTANCE.getIResource_Markers());
		}
		return filter;
	}

	/* (non-Javadoc)
	 * @see corvus.resource.ModelToModelListener#getFragment()
	 */
	@Override
	public ModelToModelCommandFragment getFragment() {
		// Cannot add below in constructor since it requires the injected values
		// which have not been injected when the constructor is called
		if (entryPointUri == null) {
			entryPointUri = configurator.resourceURI(this);
		}
		ModelToModelCommandFragment fragment = new ModelToModelCommandFragmentImpl(entryPointUri) {

			@Override
			public void doExecute(List<Notification> notifications) {
				notifications.toString();
			}

		};
		return fragment;
	}

}
