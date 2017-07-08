package corvus.domain.e4.workspace.m2m.entrypoint;

import org.eclipse.emf.transaction.NotificationFilter;

import com.google.inject.Singleton;

import corvus.domain.org.eclipse.core.resources.NotificationFilterUtil;
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
		if (filter == null) {
			filter = NotificationFilterUtil.createMarkerTypeFilter("corvus.domain.e4.workspace.view.entrypoint.entryPointMarker");
		}
		return filter;
	}

}
