package corvus.domain.e4.workspace.link.m2v;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;

import com.google.inject.Injector;
import com.google.inject.MembersInjector;

import corvus.model.link.Direction;
import corvus.model.link.Link;
import corvus.model.link.LinkContainer;
import corvus.model.link.LinkFactory;
import corvus.model.link.LinkPackage;
import corvus.transactional.TransactionOptions;

public class InjectableM2VLinkItemProviderIntegrationTest extends AbstractM2VTest {

	@Test
	public void shouldReturnCorrectReferenceOnDirection() throws Exception {
		Injector injector = getOrCreateInjector();
		AdapterFactory adapterFactory = injector.getInstance(AdapterFactory.class);

		InjectableM2VLinkItemProvider linkItemProvider = new InjectableM2VLinkItemProvider(adapterFactory);
		MembersInjector<InjectableM2VLinkItemProvider> membersInjector = 
				injector.getMembersInjector(InjectableM2VLinkItemProvider.class);
		membersInjector.injectMembers(linkItemProvider);

		final TransactionalEditingDomain ted = injector.getInstance(TransactionalEditingDomain.class);
		final Resource resource = injector.getInstance(Resource.class);
		final LinkContainer container = (LinkContainer)resource.getContents().get(0);

		TransactionalCommandStack stack = (TransactionalCommandStack)ted.getCommandStack();
		TransactionOptions options = injector.getInstance(TransactionOptions.class);

		// add our m2v listener (usually done via osgi)
		ResourceSetListener rsl = injector.getInstance(ResourceSetListener.class);
		ted.addResourceSetListener(rsl);
		
		final String intermediateName = "intermediate";

		// Setup the test by simulating M2M code
		stack.execute(new RecordingCommand(ted) {

			@Override
			protected void doExecute() {
				// set Direction.TO case
				container.getState().setDirection(Direction.TO);
				Link rootLink = createLink(container);
				Link intermediateLink = createLink(container);
				intermediateLink.setName(intermediateName);
				rootLink.getTo().add(intermediateLink);
				intermediateLink.getFrom().add(rootLink);

				// set Direction.FROM case
				container.getState().setDirection(Direction.FROM);
				Link leafLink = createLink(container);
				intermediateLink.getTo().add(leafLink);
				leafLink.getFrom().add(intermediateLink);

				// reset last added
				container.getState().setLastAdded(rootLink);
				assertEquals(1, intermediateLink.getTo().size());
				assertEquals(1, intermediateLink.getFrom().size());
			}
		}, options.get());

		Link intermediate = container.getLinks().get(1);
		assertEquals(intermediateName, intermediate.getName());

		Adapter adapted = adapterFactory.adapt(intermediate, IStructuredItemContentProvider.class);
		assertTrue(adapted instanceof InjectableM2VLinkItemProvider);
		InjectableM2VLinkItemProvider adapter = (InjectableM2VLinkItemProvider)adapted;

		// Test above
		Iterator<? extends EStructuralFeature> iter =  adapter.getChildrenFeatures(intermediate).iterator();
		assertTrue(iter.hasNext());
		EStructuralFeature feature = iter.next();
		assertEquals(LinkPackage.eINSTANCE.getLink_From(), feature);
		assertFalse(iter.hasNext()); // should only have 1

		// Now switch state
		stack.execute(new RecordingCommand(ted) {

			@Override
			protected void doExecute() {
				// set Direction.TO case
				container.getState().setDirection(Direction.TO);
			}
		}, options.get());

		// Test above
		iter = adapter.getChildrenFeatures(intermediate).iterator();
		assertTrue(iter.hasNext());
		feature = iter.next();
		assertEquals(LinkPackage.eINSTANCE.getLink_To(), feature);
		assertFalse(iter.hasNext()); // should only have 1
	}

	protected Link createLink(LinkContainer container) {
		final Link result = LinkFactory.eINSTANCE.createLink();
		container.getLinks().add(result);
		return result;
	}
	
}
