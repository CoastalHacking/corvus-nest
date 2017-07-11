package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.transaction.NotificationFilter;

import com.google.inject.Provider;
import com.google.inject.Singleton;

import corvus.model.link.LinkPackage;

@Singleton
public class LinkM2VNotificationFilterProvider implements Provider<NotificationFilter> {

	private NotificationFilter filter;

	/*
	 * (non-Javadoc)
	 * @see com.google.inject.Provider#get()
	 */
	public NotificationFilter get() {
		// Filter on notifications pertaining to the list of entry points on the framework
		if (filter == null) {
			filter = NotificationFilter.createFeatureFilter(LinkPackage.eINSTANCE.getLinkContainer_Links());
		}
		return filter;
	}

}
