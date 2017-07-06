package corvus.resource;

import org.eclipse.emf.transaction.NotificationFilter;

import com.google.inject.Provider;

public class DefaultNotificationFilterProvider implements Provider<NotificationFilter> {

	@Override
	public NotificationFilter get() {
		return NotificationFilter.ANY;
	}

}
