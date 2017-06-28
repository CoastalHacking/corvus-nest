package corvus.resource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.junit.Test;

public class PostCommitEClassResourceSetListenerTest {

	@Test
	public void shouldNotifyFeatureFilter() {
		EObject expected = ModelUtil.createObject(getClass().getName());

		Notification notification = mock(Notification.class);
		when(notification.getNotifier()).thenReturn(expected);

		PostCommitEClassResourceSetListener listener = new PostCommitEClassResourceSetListener() {
			@Override public void resourceSetChanged(ResourceSetChangeEvent event) {}

			@Override public EClass getEClass() { return expected.eClass(); }
		};

		NotificationFilter filter = listener.getFilter();
		assertTrue(filter.matches(notification));
	}

	@Test
	public void shouldNotNotifyFeatureFilter() {
		EObject notExpected = ModelUtil.createObject("NotExpected");
		EObject expected = ModelUtil.createObject("Expected");

		Notification notification = mock(Notification.class);
		when(notification.getNotifier()).thenReturn(notExpected);

		PostCommitEClassResourceSetListener listener = new PostCommitEClassResourceSetListener() {
			@Override public void resourceSetChanged(ResourceSetChangeEvent event) {}

			@Override public EClass getEClass() { return expected.eClass(); }
		};

		NotificationFilter filter = listener.getFilter();
		assertFalse(filter.matches(notification));
	}

}
