package corvus.domain.e4.workspace.m2m.entrypoint;

import java.util.List;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import corvus.domain.e4.workspace.entrypoint.WorkspaceEntryPointsConstants;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.TextMarker;
import corvus.model.entrypoint.EntryPoint;
import corvus.model.entrypoint.EntryPointFramework;
import corvus.model.entrypoint.EntrypointFactory;
import corvus.resource.NotificationsConsumer;

public class EntryPointM2MNotificationsConsumer extends NotificationsConsumer {

	@Inject
	@Named(WorkspaceEntryPointsConstants.ENTRY_POINT_MARKER)
	protected String entryPointMarker;
	
	/* (non-Javadoc)
	 * @see corvus.resource.NotificationsConsumer#consume(java.util.List)
	 */
	@Override
	public void consume(List<Notification> notifications) {
		for (final Notification notification: notifications) {

			// Guard against out notifier filter
			if (notification.getNotifier() instanceof IResource) {

				TextMarker textMarker;
				switch (notification.getEventType()) {
				case Notification.ADD:
					textMarker = (TextMarker)notification.getNewValue();
					// Guard against only our markers
					if (entryPointMarker.equals(textMarker.getType())) {
						markerAdded(textMarker);
					}
					break;

				case Notification.REMOVE:
					textMarker = (TextMarker)notification.getOldValue();
					if (entryPointMarker.equals(textMarker.getType())) {
						markerDeleted(textMarker);
					}
					break;

				default:
					break;
				}

			}
		}
	}

	protected void markerAdded(TextMarker addedMarker) {
		EntryPoint entryPoint = EntrypointFactory.eINSTANCE.createEntryPoint();
		entryPoint.setName("EntryPoint: " + UUID.randomUUID().toString());

		// Hack: the below obtains the root framework at index 0
		// Chaos occurs if the framework list is re-ordered
		// TODO: re-factor post named URI fragments
		EntryPointFramework genericFramework = (EntryPointFramework)resource.getContents().get(0);
		genericFramework.getEntryPoints().add(entryPoint);

		// Then connect to marker
		addedMarker.setDomain(entryPoint);

		// TODO: obtain a resource adapter that saves on the addedMarker

		save();
	}

	protected void markerDeleted(TextMarker deletedMarker) {
		
		// Guard against an unusual case if somehow we're not the reference
		if (deletedMarker.getDomain() instanceof EntryPoint) {
			final EntryPoint entryPoint = (EntryPoint) deletedMarker.getDomain();
			EcoreUtil.delete(entryPoint, /*recursive*/ true);
		}
		save();
	}


}
