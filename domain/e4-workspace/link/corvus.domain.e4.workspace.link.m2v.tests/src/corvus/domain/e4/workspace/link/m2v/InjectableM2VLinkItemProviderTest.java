package corvus.domain.e4.workspace.link.m2v;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.junit.Test;

import com.google.inject.Injector;

import corvus.model.link.Direction;
import corvus.model.link.Link;
import corvus.model.link.LinkContainer;
import corvus.model.link.LinkFactory;
import corvus.model.link.State;
import corvus.resource.NotificationsConsumer;

public class InjectableM2VLinkItemProviderTest extends AbstractM2VTest {

	@Test
	public void shouldReturnCorrectReferenceOnDirection() throws Exception {
		Injector injector = getOrCreateInjector();
		final M2VNotificationsConsumer consumer = (M2VNotificationsConsumer)injector.getInstance(NotificationsConsumer.class);

		// Mock-ish
		final String rootName = "root";
		final String intermediateName = "intermediate";
		final String leafName = "leaf";

		// Create and set state & container
		final LinkContainer container = LinkFactory.eINSTANCE.createLinkContainer();
		final State state = LinkFactory.eINSTANCE.createState();
		state.setDirection(Direction.TO);
		container.setState(state);

		// Create and prep links
		final Link expectedRoot = createLink(container, rootName, consumer);
		final Link expectedIntermediate = createLink(container, intermediateName, consumer);
		final Link expectedLeaf = createLink(container, leafName, consumer);
		setToFrom(expectedRoot, expectedIntermediate);
		setToFrom(expectedIntermediate, expectedLeaf);

		IStructuredItemContentProvider adapter = (IStructuredItemContentProvider)
				EcoreUtil.getExistingAdapter(expectedRoot, IStructuredItemContentProvider.class);
		assertNotNull(adapter);

		// Test "TO" case, starting at root
		Iterator<?> iter =  adapter.getElements(expectedRoot).iterator();
		assertTrue(iter.hasNext());
		Object actualIntermediate = getFromDelegate(iter);
		assertEquals(expectedIntermediate, actualIntermediate);
		assertFalse(iter.hasNext());

		// then at intermediate
		iter =  adapter.getElements(expectedIntermediate).iterator();
		assertTrue(iter.hasNext());
		Object actualLeaf = getFromDelegate(iter);
		assertEquals(expectedLeaf, actualLeaf);
		assertFalse(iter.hasNext());

		// Test "FROM" case, starting at leaf
		container.getState().setDirection(Direction.FROM);
		iter = adapter.getElements(expectedLeaf).iterator();
		assertTrue(iter.hasNext());
		actualIntermediate = getFromDelegate(iter);
		assertEquals(expectedIntermediate, actualIntermediate);

		// then at intermediate
		// also, this indirectly tests that the child store is not created
		iter =  adapter.getElements(expectedIntermediate).iterator();
		assertTrue(iter.hasNext());
		Object actualRoot = getFromDelegate(iter);
		assertEquals(expectedRoot, actualRoot);
		assertFalse(iter.hasNext()); // should only have 1

	}

	private Link createLink(LinkContainer container, String name, M2VNotificationsConsumer consumer) {
		final Link result = LinkFactory.eINSTANCE.createLink();
		container.getLinks().add(result);
		result.setName(name);
		// calls the adapter factory
		consumer.addNewValue(result);
		return result;
	}
	
	private Object getFromDelegate(Iterator<?> iterator) {
		Object object = iterator.next();
		assertTrue(object instanceof DelegatingWrapperItemProvider);
		DelegatingWrapperItemProvider actualProvider = (DelegatingWrapperItemProvider)object;
		return actualProvider.getValue();
	}
	
	private void setToFrom(Link to, Link from) {
		to.getTo().add(from);
		from.getFrom().add(to);
	}
}
