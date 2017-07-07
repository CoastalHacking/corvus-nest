package corvus.domain.e4.workspace.d2m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.parsley.config.Configurator;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.junit.Test;

import com.google.inject.Injector;

import corvus.common.test.CorvusAbstractEmfParsleyTest;
import corvus.common.test.TestConfigurator;
import corvus.domain.e4.workspace.MarkerController;
import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IMarker;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.TextMarker;
import corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch;
import corvus.transactional.TransactionalEmfParsleyGuiceModule;

public class MarkerControllerImplTest extends CorvusAbstractEmfParsleyTest {

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

	// Hack: below copied from ResourceProviderTest
	// just changed the super to D2mEmfParsleyGuiceModule
	public static class TestCaseModule extends D2mEmfParsleyGuiceModule {

		private String id;

		public TestCaseModule(AbstractUIPlugin plugin, String id) {
			super(plugin);
			this.id = id;
		}
		
		public Class<? extends Configurator> bindConfigurator() {
			return TestConfigurator.class;
		}

		public String valueTransactionalEditingDomainId() {
			return id;
		}
	}

	@Override
	protected TransactionalEmfParsleyGuiceModule getTestModule(AbstractUIPlugin plugin, String id) {
		return new TestCaseModule(plugin, id);
	}

}
