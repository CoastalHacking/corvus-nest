package corvus.domain.e4.workspace.link.m2m;

import org.eclipse.emf.ecore.util.EcoreUtil;

import corvus.domain.e4.workspace.AbstractTextMarker2MNotificationsConsumer;
import corvus.domain.org.eclipse.core.resources.TextMarker;
import corvus.model.link.Link;
import corvus.model.link.LinkContainer;
import corvus.model.link.LinkFactory;

// TODO: test
public class LinkM2MNotificationsConsumer extends AbstractTextMarker2MNotificationsConsumer {

	protected void markerAdded(TextMarker marker) {
		Link link = LinkFactory.eINSTANCE.createLink();

		// Hack: the below obtains the link container at index 0
		// Chaos occurs if the framework list is re-ordered
		// TODO: re-factor post named URI fragments
		LinkContainer container = (LinkContainer)resource.getContents().get(0);
		Link lastAdded = container.getLastAdded();
		if (lastAdded != null) {
			link.getFrom().add(link);
			lastAdded.getTo().add(link);
		}
		container.setLastAdded(link);
		marker.setDomain(link);
	}

	protected void markerDeleted(TextMarker marker) {
		// Trust our notification filter
		Link link = (Link)marker.getDomain();
		EcoreUtil.delete(link, /*recursive*/true);
	}
}
