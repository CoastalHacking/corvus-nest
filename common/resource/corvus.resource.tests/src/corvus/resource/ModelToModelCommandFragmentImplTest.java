package corvus.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;

public class ModelToModelCommandFragmentImplTest {

	@Test
	public void shouldGetResource() {
		ResourceSetChangeEvent event = mock(ResourceSetChangeEvent.class);
		TransactionalEditingDomain ted = mock(TransactionalEditingDomain.class);
		when(event.getEditingDomain()).thenReturn(ted);

		ResourceSet set = mock(ResourceSet.class);
		when(ted.getResourceSet()).thenReturn(set);

		URI uri = mock(URI.class);

		Resource expected = mock(Resource.class);
		when(set.getResource(uri, false)).thenReturn(expected);

		ModelToModelCommandFragmentImpl impl = new ModelToModelCommandFragmentImpl(uri) {
			@Override public void doExecute(List<Notification> notifications) {}
		};

		Resource actual = impl.getResource(event);
		assertEquals(expected, actual);
	}

}
