package corvus.domain.e4.workspace;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import corvus.domain.org.eclipse.core.resources.TextMarker;
import corvus.resource.NotificationsConsumer;

public abstract class AbstractTextMarker2MNotificationsConsumer extends NotificationsConsumer {

	/* (non-Javadoc)
	 * @see corvus.resource.NotificationsConsumer#consume(java.util.List)
	 */
	@Override
	public void consume(List<Notification> notifications) {

		// the notification filter verified the types below already
		for (Notification notification: notifications) {
			switch (notification.getEventType()) {
			case Notification.ADD:
				markerAdded((TextMarker)notification.getNewValue());
				save();
				break;
			case Notification.REMOVE:
				markerDeleted((TextMarker)notification.getOldValue());
				save();
				break;
			}
		}
	}

	protected void markerAdded(TextMarker marker) {

	}

	protected void markerDeleted(TextMarker marker) {
		
	}

}
