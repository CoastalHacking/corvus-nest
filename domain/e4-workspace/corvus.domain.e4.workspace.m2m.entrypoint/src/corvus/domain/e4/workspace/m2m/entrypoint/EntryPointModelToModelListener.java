/**
 * 
 */
package corvus.domain.e4.workspace.m2m.entrypoint;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;

import com.google.inject.Inject;

import corvus.domain.org.eclipse.core.resources.ResourcesPackage;
import corvus.domain.org.eclipse.core.resources.TextMarker;
import corvus.model.entrypoint.EntryPoint;
import corvus.model.entrypoint.EntrypointFactory;
import corvus.resource.ModelToModelCommandFragment;
import corvus.resource.ModelToModelCommandFragmentImpl;
import corvus.resource.ModelToModelListener;

/**
 *
 *
 */
public class EntryPointModelToModelListener extends ModelToModelListener {

	@Inject
	private Resource resource;

	// inject?
	private NotificationFilter filter;

	// inject?
	private ModelToModelCommandFragment fragment;

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

		if (fragment == null) {
			fragment = new EntryPointFragment();
		}
		return fragment;
	}

	public class EntryPointFragment extends ModelToModelCommandFragmentImpl {

		/*
		 * (non-Javadoc)
		 * @see corvus.resource.ModelToModelCommandFragmentImpl#added(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		protected void added(Notification notification) {
			Object newValue = notification.getNewValue();
			if (newValue instanceof TextMarker) {
				TextMarker addedMarker = (TextMarker)newValue;
				EntryPoint entryPoint = EntrypointFactory.eINSTANCE.createEntryPoint();
				entryPoint.setName("EntryPoint: " + UUID.randomUUID().toString());

				// Add entry point to resource first
				resource.getContents().add(entryPoint);

				// Then connect to marker
				addedMarker.setDomain(entryPoint);
			}
		}

		protected void removed(Notification notification) {

		}
		
	}

}
