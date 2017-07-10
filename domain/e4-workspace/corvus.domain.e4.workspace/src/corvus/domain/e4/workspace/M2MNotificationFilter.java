package corvus.domain.e4.workspace;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.NotificationFilter;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import corvus.domain.org.eclipse.core.resources.ResourcesPackage;
import corvus.domain.org.eclipse.core.resources.TextMarker;

// TODO: test me!
public class M2MNotificationFilter extends NotificationFilter.Custom {

	public M2MNotificationFilter() {
		super();
	}

	@Inject
	@Named(Constants.CORVUS_DOMAIN_MARKER)
	protected String domainMarker;

	@Override
	public boolean matches(Notification notification) {
		boolean result = false;
		// Check to see if this is the correct feature
		if (notification.getFeature() == ResourcesPackage.eINSTANCE.getIResource_Markers()) {
			switch (notification.getEventType()) {
			case Notification.ADD:
				result = isValidMarker(notification.getNewValue());
				break;
			case Notification.REMOVE:
				result = isValidMarker(notification.getOldValue());
				break;
			}
		}
		return result;
	}

	private boolean isValidMarker(Object object) {
		boolean result = false;
		if (object instanceof TextMarker) {
			String type = ((TextMarker)object).getType();
			result = domainMarker.equals(type);
		}
		return result;
	}

}
