package corvus.domain.org.eclipse.core.resources;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.NotificationFilter;

public class NotificationFilterUtil {

	public static NotificationFilter createMarkerTypeFilter(String markerType) {
		return new NotificationFilter.Custom() {
			@Override
			public boolean matches(Notification notification) {
				return (notification.getFeature() == ResourcesPackage.eINSTANCE.getIMarker_Type()
						&& notification.getNewStringValue().equals(markerType));
				}};
	}

}
