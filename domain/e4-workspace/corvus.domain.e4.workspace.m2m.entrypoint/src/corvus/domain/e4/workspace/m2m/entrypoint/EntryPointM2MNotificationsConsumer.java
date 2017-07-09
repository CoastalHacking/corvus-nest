package corvus.domain.e4.workspace.m2m.entrypoint;

import java.util.List;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;

import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.TextMarker;
import corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch;
import corvus.model.entrypoint.EntryPoint;
import corvus.model.entrypoint.EntryPointFramework;
import corvus.model.entrypoint.EntrypointFactory;
import corvus.resource.NotificationsConsumer;

public class EntryPointM2MNotificationsConsumer extends NotificationsConsumer {

	@Inject
	Resource resource;

	/* (non-Javadoc)
	 * @see corvus.resource.NotificationsConsumer#consume(java.util.List)
	 */
	@Override
	public void consume(List<Notification> notifications) {
		for (final Notification notification: notifications) {
			Object notifier = notification.getNotifier();

			if (notifier instanceof EObject) {
				ResourcesSwitch<Boolean> resourcesSwitch = new ResourcesSwitch<Boolean>() {

					@Override
					public Boolean defaultCase(EObject object) {
						return Boolean.FALSE;
					}

					@Override
					public Boolean caseTextMarker(TextMarker object) {
						// The add filter matches in practice a notification with a SET
						// TODO: test!
						switch (notification.getEventType()) {
						case Notification.SET:
							markerAdded(object);
							break;
						case Notification.REMOVE:
						case Notification.REMOVE_MANY:
							break;
						default:
							break;
						}
						return Boolean.TRUE;
					}

					@Override
					public Boolean caseIResource(IResource object) {
						if (notification.getEventType() == Notification.REMOVE) {
							markerDeleted(object);
						}

						return super.caseIResource(object);
					}

					
				};
				resourcesSwitch.doSwitch((EObject)notifier);
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
	}

	protected void markerDeleted(IResource resource) {
	}
}
