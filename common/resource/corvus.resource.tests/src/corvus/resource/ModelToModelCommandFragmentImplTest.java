package corvus.resource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Ignore;
import org.junit.Test;

public class ModelToModelCommandFragmentImplTest {

	@Ignore(value="Only was testing the getting of a resource")
	@Test
	public void shouldGetResource() {
		ResourceSetChangeEvent event = mock(ResourceSetChangeEvent.class);
		TransactionalEditingDomain ted = mock(TransactionalEditingDomain.class);
		when(event.getEditingDomain()).thenReturn(ted);

		ResourceSet set = mock(ResourceSet.class);
		when(ted.getResourceSet()).thenReturn(set);

		Resource expected = mock(Resource.class);

		ModelToModelCommandFragmentImpl impl = new ModelToModelCommandFragmentImpl() {
			@Override public void doExecute(List<Notification> notifications) {}
		};

//		Resource actual = impl.getResource(event);
//		assertEquals(expected, actual);
	}

}
