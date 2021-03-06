package corvus.transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.parsley.edit.EditingDomainFinder;
import org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.google.inject.Injector;
import com.google.inject.Provider;

public class InjectableTransactionalEditingDomainFactoryTest extends AbstractEmfParsleyTest {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	/* (non-Javadoc)
	 * @see org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest#createInjector()
	 */
	@Override
	protected Injector createInjector() {
		return TransactionalInjectorProvider.getInjector();
	}

	@Test
	public void shouldInjectFactoryAndCreateEditingDomain() {
		Injector injector = getOrCreateInjector();
		DefaultTransactionalEditingDomainFactory factory =
				injector.getInstance(DefaultTransactionalEditingDomainFactory.class);
		assertNotNull(factory);

		TransactionalEditingDomain transactionalEditingDomain = factory.createEditingDomain();
		assertNotNull(transactionalEditingDomain);
	}

	@Test
	public void shouldInjectTransactionalEditingDomain() {
		Injector injector = getOrCreateInjector();
		Provider<EditingDomain> editingDomainProvider = injector.getProvider(EditingDomain.class);
		EditingDomain editingDomain = editingDomainProvider.get();
		assertTrue(editingDomain instanceof TransactionalEditingDomain);
	}

	@Test
	public void shouldFindTransactionalEditingDomain() throws Exception {
		Injector injector = getOrCreateInjector();
		EditingDomainFinder finder = injector.getInstance(EditingDomainFinder.class);
		TransactionalEditingDomain expectedDomain = injector.getInstance(TransactionalEditingDomain.class);
		ResourceSet rset = expectedDomain.getResourceSet();

		// register a resource factory impl
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		File tempFile = tempFolder.newFile("resource.xmi");
		String path = tempFile.getCanonicalPath();
		Resource resource = expectedDomain.createResource(path);

		assertNotNull(resource);

		EObject eObject = createTestObject();

		expectedDomain.getCommandStack().execute(new RecordingCommand(expectedDomain) {
			@Override protected void doExecute() {
				resource.getContents().add(eObject);
			}});

		EditingDomain actualDomain = finder.getEditingDomainFor(eObject);

		assertEquals(expectedDomain, actualDomain);
	}

	private EObject createTestObject() {
		EcoreFactory eCoreFactory = EcoreFactory.eINSTANCE;

		EClass eClass = eCoreFactory.createEClass();
		eClass.setName("Test");

		EPackage ePackage = eCoreFactory.createEPackage();
		ePackage.getEClassifiers().add(eClass);

		return EcoreUtil.create(eClass);
	}
}
