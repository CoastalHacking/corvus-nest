package corvus.domain.e4.workspace.m2m.entrypoint;

import org.eclipse.emf.transaction.NotificationFilter;

import com.google.inject.Singleton;

import corvus.domain.org.eclipse.core.resources.NotificationFilterUtil;
import corvus.domain.org.eclipse.core.resources.ResourcesPackage;
import corvus.resource.DefaultNotificationFilterProvider;

@Singleton
public class EntryPointM2MNotificationFilterProvider extends DefaultNotificationFilterProvider {

	private NotificationFilter filter;

	/* (non-Javadoc)
	 * @see corvus.resource.DefaultNotificationFilterProvider#get()
	 */
	@Override
	public NotificationFilter get() {
		// Filter on notifications pertaining to the list of entry points on the framework
		// Need to create a composite filter that matches
		// either the creation, change, or deletion of a marker
		if (filter == null) {
			NotificationFilter addFilter = NotificationFilterUtil.createMarkerTypeFilter("corvus.domain.e4.workspace.view.entrypoint.entryPointMarker");
			NotificationFilter deleteFilter = NotificationFilter.createFeatureFilter(ResourcesPackage.eINSTANCE.getIResource_Markers());
			deleteFilter.or(addFilter);
//			NotificationFilter anyFilter = NotificationFilter.ANY;
//			addFilter.or(anyFilter);
//			filter = addFilter;
			filter = deleteFilter;
		}
		return filter;
	}

}
