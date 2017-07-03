package corvus.domain.e4.workspace.d2m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.UUID;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest;
import org.eclipse.emf.parsley.runtime.ui.PluginUtil;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.google.inject.Injector;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IMarker;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.TextMarker;
import corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch;

public class MarkerControllerImplTest  extends AbstractEmfParsleyTest {


	@Test
	public void shouldAddMarker() throws CoreException, InterruptedException {

		// TODO: make injectable?
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		Injector injector = getOrCreateInjector();
		MarkerController controller = injector.getInstance(MarkerController.class);
		assertNotNull(controller);
		controller.markerAdded(TestUtil.generateExpectedMockMarker());

		TransactionalEditingDomain ted = injector.getInstance(TransactionalEditingDomain.class);
		Resource resource = injector.getInstance(Resource.class);
		assertFalse(resource.getContents().isEmpty());

		// we're the only code editing this domain, so no worries
		TestSwitch testSwitch = new TestSwitch();

		IMarker actual = (IMarker) ted.runExclusive(new RunnableWithResult.Impl<TextMarker>() {

			@Override
			public void run() {
				TreeIterator<EObject> treeIter = resource.getAllContents();
				while (treeIter.hasNext()) {
					EObject next = treeIter.next();
					assertTrue(testSwitch.doSwitch(next));
					if (next instanceof TextMarker) {
						setResult((TextMarker)next);
					}
				}
			}

		});
		assertNotNull(actual);
		assertEquals(TestUtil.expectedMarkerId, actual.getId());
	}

	public static class TestSwitch extends ResourcesSwitch<Boolean> {

		@Override
		public Boolean caseIWorkspaceRoot(IWorkspaceRoot object) {
			return object.getRawLocation().equals(TestUtil.expectedRawLocation);
		}

		/* (non-Javadoc)
		 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#caseIContainer(corvus.domain.org.eclipse.core.resources.IContainer)
		 */
		@Override
		public Boolean caseIContainer(IContainer object) {
			return (object.getName().equals(TestUtil.expectedContainerOneName) ||
					object.getName().equals(TestUtil.expectedContainerTwoName));
		}

		/* (non-Javadoc)
		 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#caseIResource(corvus.domain.org.eclipse.core.resources.IResource)
		 */
		@Override
		public Boolean caseIResource(IResource object) {
			return (object.getName().equals(TestUtil.expectedResourceName));
		}

		/* (non-Javadoc)
		 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#caseTextMarker(corvus.domain.org.eclipse.core.resources.TextMarker)
		 */
		@Override
		public Boolean caseTextMarker(TextMarker object) {
			return (object.getId() == TestUtil.expectedMarkerId &&
					object.getType() == TestUtil.expectedMarkerType &&
					object.getCharStart() == TestUtil.expectedMarkerCharStart &&
					object.getCharEnd() == TestUtil.expectedMarkerCharEnd &&
					object.getLineNumber() == TestUtil.expectedMarkerLineNumber);
		}

		/* (non-Javadoc)
		 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Boolean defaultCase(EObject object) {
			return Boolean.FALSE;
		}
	
	}

	// Method and two classes below copied from ResourceProviderTest

	/* (non-Javadoc)
	 * @see org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest#createInjector()
	 */
	@Override
	protected Injector createInjector() {
		String id = UUID.randomUUID().toString();
		return createInjector(new TestModule(
				PluginUtil.getPlugin(
						PluginUtil.getBundle(D2mActivator.class)),
				id));
	}

	public static class TestConfigurator extends Configurator {

		private URI result;

		@Rule
		public TemporaryFolder tempFolder = new TemporaryFolder();

		public URI resourceURI(Object object) {
			if (result == null) {
				try {
					tempFolder.create();
					result = URI.createFileURI(tempFolder.newFile().getAbsolutePath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	}

	public static class TestModule extends D2mEmfParsleyGuiceModule {

		private String id;

		public TestModule(AbstractUIPlugin plugin, String id) {
			super(plugin);
			this.id = id;
		}

		@Override
		public Class<? extends Configurator> bindConfigurator() {
			return TestConfigurator.class;
		}
		
		@Override
		public String valueTransactionalEditingDomainId() {
			return id;
		}
		
	}
}
