package corvus.domain.e4.workspace.d2m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.junit.Test;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.TextMarker;

public class AddResourcesSwitchTest {

	private static final IWorkspaceRoot EXPECTED_BRANCH = TestUtil.createExpectedBranch();
	
	@Test
	public void shouldAddWorkspaceRootToMarker() {

		Resource resource = new ResourceImpl();
		AddResourcesSwitch addSwitch = new AddResourcesSwitch(null, resource);

		IWorkspaceRoot expectedBranch = TestUtil.createExpectedBranch();

		// re-use logic to get root object inclusively
		ComparisonResourcesSwitch comparisonSwitch = new ComparisonResourcesSwitch(expectedBranch);

		for (TreeIterator<EObject> iter = comparisonSwitch.getObjectsToAdd(); iter.hasNext();) {
			EObject eObject = iter.next();
			Boolean result = addSwitch.doSwitch(eObject);
			assertTrue(result);
		}
	}

	@Test
	public void shouldAddContainerOne() {

		Resource resource = new ResourceImpl();
		IWorkspaceRoot expectedRoot = TestUtil.createExpectedWorkspaceRoot();
		resource.getContents().add(expectedRoot);

		// Get all contents from the workspace root, which starts with container one
		TreeIterator<EObject> expectedRootIterator = EXPECTED_BRANCH.eAllContents();
		IContainer containerOne = (IContainer)expectedRootIterator.next();
		assertEquals(TestUtil.expectedContainerOneName, containerOne.getName());

		AddResourcesSwitch addSwitch = new AddResourcesSwitch(expectedRoot, resource);
		assertTrue(addSwitch.doSwitch(containerOne));

	}

	@Test
	public void shouldAddContainerTwo() {

		Resource resource = new ResourceImpl();
		IWorkspaceRoot expectedRoot = TestUtil.createExpectedWorkspaceRoot();
		IContainer expectedContainerOne = TestUtil.createExpectedContainerOne();
		expectedRoot.getMembers().add(expectedContainerOne);
		resource.getContents().add(expectedRoot);

		// Get all contents from the workspace root, which starts with container one
		TreeIterator<EObject> expectedRootIterator = EXPECTED_BRANCH.eAllContents();
		expectedRootIterator.next(); // container one
		IContainer containerTwo = (IContainer)expectedRootIterator.next();
		assertEquals(TestUtil.expectedContainerTwoName, containerTwo.getName());

		AddResourcesSwitch addSwitch = new AddResourcesSwitch(expectedContainerOne, resource);
		assertTrue(addSwitch.doSwitch(containerTwo));

	}

	@Test
	public void shouldAddResource() {

		Resource resource = new ResourceImpl();
		IWorkspaceRoot expectedRoot = TestUtil.createExpectedWorkspaceRoot();
		IContainer expectedContainerOne = TestUtil.createExpectedContainerOne();
		IContainer expectedContainerTwo = TestUtil.createExpectedContainerTwo();
		expectedContainerOne.getMembers().add(expectedContainerTwo);
		expectedRoot.getMembers().add(expectedContainerOne);
		resource.getContents().add(expectedRoot);

		// Get all contents from the workspace root, which starts with container one
		TreeIterator<EObject> expectedRootIterator = EXPECTED_BRANCH.eAllContents();
		expectedRootIterator.next(); // container one
		expectedRootIterator.next(); // container two
		IResource iResource = (IResource)expectedRootIterator.next();
		assertEquals(TestUtil.expectedResourceName, iResource.getName());

		AddResourcesSwitch addSwitch = new AddResourcesSwitch(expectedContainerTwo, resource);
		assertTrue(addSwitch.doSwitch(iResource));

	}

	@Test
	public void shouldAddTextMarker() {

		Resource resource = new ResourceImpl();
		IWorkspaceRoot expectedRoot = TestUtil.createExpectedWorkspaceRoot();
		IContainer expectedContainerOne = TestUtil.createExpectedContainerOne();
		IContainer expectedContainerTwo = TestUtil.createExpectedContainerTwo();
		IResource expectedResource = TestUtil.createExpectedResource();
		expectedContainerTwo.getMembers().add(expectedResource);
		expectedContainerOne.getMembers().add(expectedContainerTwo);
		expectedRoot.getMembers().add(expectedContainerOne);
		resource.getContents().add(expectedRoot);

		// Get all contents from the workspace root, which starts with container one
		TreeIterator<EObject> expectedRootIterator = EXPECTED_BRANCH.eAllContents();
		expectedRootIterator.next(); // container one
		expectedRootIterator.next(); // container two
		expectedRootIterator.next(); // resource
		TextMarker textMarker = (TextMarker)expectedRootIterator.next();
		assertEquals(TestUtil.expectedMarkerId, textMarker.getId());

		AddResourcesSwitch addSwitch = new AddResourcesSwitch(expectedResource, resource);
		assertTrue(addSwitch.doSwitch(textMarker));

	}

	@Test
	public void shouldNotAddTextMarkerToWorkspaceRoot() {

		Resource resource = new ResourceImpl();
		IWorkspaceRoot expectedRoot = TestUtil.createExpectedWorkspaceRoot();
		resource.getContents().add(expectedRoot);

		// Get all contents from the workspace root, which starts with container one
		TreeIterator<EObject> expectedRootIterator = EXPECTED_BRANCH.eAllContents();
		expectedRootIterator.next(); // container one
		expectedRootIterator.next(); // container two
		expectedRootIterator.next(); // resource
		TextMarker textMarker = (TextMarker)expectedRootIterator.next();
		assertEquals(TestUtil.expectedMarkerId, textMarker.getId());

		AddResourcesSwitch addSwitch = new AddResourcesSwitch(expectedRoot, resource);
		assertFalse(addSwitch.doSwitch(textMarker));

	}

}
