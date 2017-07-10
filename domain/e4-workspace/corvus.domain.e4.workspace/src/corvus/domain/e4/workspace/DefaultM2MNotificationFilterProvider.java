package corvus.domain.e4.workspace;

import org.eclipse.emf.transaction.NotificationFilter;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.Singleton;

import corvus.resource.DefaultNotificationFilterProvider;

// Should only need one m2m filter per guice injector
@Singleton
public class DefaultM2MNotificationFilterProvider extends DefaultNotificationFilterProvider {

	private M2MNotificationFilter filter;

	@Inject
	private MembersInjector<M2MNotificationFilter> filterInjector;

	/* (non-Javadoc)
	 * @see corvus.resource.DefaultNotificationFilterProvider#get()
	 */
	@Override
	public NotificationFilter get() {
		if (filter == null) {
			M2MNotificationFilter m2mFilter = new M2MNotificationFilter();
			filterInjector.injectMembers(m2mFilter);
			filter = m2mFilter;
		}
		return filter;
	}
}
