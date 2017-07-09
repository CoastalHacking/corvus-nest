package corvus.domain.e4.workspace.m2m.entrypoint;

import org.eclipse.emf.transaction.NotificationFilter;

import com.google.inject.Singleton;

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
		// Filter on the marker container on the resource, which notifies on additions and removals
		if (filter == null) {
			filter = NotificationFilter.createFeatureFilter(ResourcesPackage.eINSTANCE.getIResource_Markers());
		}
		return filter;
	}

}
