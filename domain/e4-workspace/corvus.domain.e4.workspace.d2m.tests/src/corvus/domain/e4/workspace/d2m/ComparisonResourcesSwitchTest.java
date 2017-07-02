package corvus.domain.e4.workspace.d2m;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.junit.Test;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.TextMarker;

public class ComparisonResourcesSwitchTest {

	@Test
	public void shouldExpectWorkspaceRootNullExisting() {
		
		Resource resource = new ResourceImpl();
		IWorkspaceRoot expectedObject = TestUtil.createExpectedWorkspaceRoot();
		ComparisonResourcesSwitch comparisonSwitch = new ComparisonResourcesSwitch(expectedObject);

		for (TreeIterator<EObject> iter = resource.getAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();
			if (comparisonSwitch.doSwitch(eObject) == Boolean.FALSE) {
				iter.prune();
			}
		}
		
		assertEquals(expectedObject, comparisonSwitch.getExpectedObject());
		assertEquals(null, comparisonSwitch.getLastExistingObject());

	}

	@Test
	public void shouldExpectContainerOneExistingRoot() {
		
		Resource resource = new ResourceImpl();
		IWorkspaceRoot existingRoot = TestUtil.createExpectedWorkspaceRoot();
		resource.getContents().add(existingRoot);

		IWorkspaceRoot branchRoot = TestUtil.createExpectedBranch();
		EObject expectedContainerOne = branchRoot.getMembers().get(0);

		ComparisonResourcesSwitch comparisonSwitch = new ComparisonResourcesSwitch(branchRoot);

		for (TreeIterator<EObject> iter = resource.getAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();
			if (comparisonSwitch.doSwitch(eObject) == Boolean.FALSE) {
				iter.prune();
			}
		}

		assertEquals(expectedContainerOne, comparisonSwitch.getExpectedObject());
		assertEquals(existingRoot, comparisonSwitch.getLastExistingObject());

	}
	
	@Test
	public void shouldExpectContainerTwoExistingContainerOne() {

		Resource resource = new ResourceImpl();
		IWorkspaceRoot existingRoot = TestUtil.createExpectedWorkspaceRoot();
		IContainer existingContainerOne = TestUtil.createExpectedContainerOne();
		existingRoot.getMembers().add(existingContainerOne);
		resource.getContents().add(existingRoot);

		IWorkspaceRoot branchRoot = TestUtil.createExpectedBranch();
		IContainer containerOne = (IContainer)branchRoot.getMembers().get(0);
		IContainer expectedContainerTwo = (IContainer)containerOne.getMembers().get(0);

		ComparisonResourcesSwitch comparisonSwitch = new ComparisonResourcesSwitch(branchRoot);

		for (TreeIterator<EObject> iter = resource.getAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();
			if (comparisonSwitch.doSwitch(eObject) == Boolean.FALSE) {
				iter.prune();
			}
		}

		assertEquals(existingContainerOne, comparisonSwitch.getLastExistingObject());
		assertEquals(expectedContainerTwo, comparisonSwitch.getExpectedObject());
	}

	@Test
	public void shouldExpectResourceExistingContainerTwo() {

		Resource resource = new ResourceImpl();
		IWorkspaceRoot existingRoot = TestUtil.createExpectedWorkspaceRoot();
		IContainer existingContainerOne = TestUtil.createExpectedContainerOne();
		IContainer existingContainerTwo = TestUtil.createExpectedContainerTwo();
		existingContainerOne.getMembers().add(existingContainerTwo);
		existingRoot.getMembers().add(existingContainerOne);
		resource.getContents().add(existingRoot);

		IWorkspaceRoot branchRoot = TestUtil.createExpectedBranch();
		IContainer containerOne = (IContainer)branchRoot.getMembers().get(0);
		IContainer containerTwo = (IContainer)containerOne.getMembers().get(0);
		IResource expectedResource = containerTwo.getMembers().get(0);

		ComparisonResourcesSwitch comparisonSwitch = new ComparisonResourcesSwitch(branchRoot);

		for (TreeIterator<EObject> iter = resource.getAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();
			if (comparisonSwitch.doSwitch(eObject) == Boolean.FALSE) {
				iter.prune();
			}
		}

		assertEquals(existingContainerTwo, comparisonSwitch.getLastExistingObject());
		assertEquals(expectedResource, comparisonSwitch.getExpectedObject());
	}
	
	@Test
	public void shouldExpecMarkerExistingResource() {

		Resource resource = new ResourceImpl();
		IWorkspaceRoot existingRoot = TestUtil.createExpectedWorkspaceRoot();
		IContainer existingContainerOne = TestUtil.createExpectedContainerOne();
		IContainer existingContainerTwo = TestUtil.createExpectedContainerTwo();
		IResource existingResource = TestUtil.createExpectedResource();
		existingContainerTwo.getMembers().add(existingResource);
		existingContainerOne.getMembers().add(existingContainerTwo);
		existingRoot.getMembers().add(existingContainerOne);
		resource.getContents().add(existingRoot);

		IWorkspaceRoot branchRoot = TestUtil.createExpectedBranch();
		IContainer containerOne = (IContainer)branchRoot.getMembers().get(0);
		IContainer containerTwo = (IContainer)containerOne.getMembers().get(0);
		IResource expectedResource = containerTwo.getMembers().get(0);
		TextMarker expectedMarker = (TextMarker)expectedResource.getMarkers().get(0);

		ComparisonResourcesSwitch comparisonSwitch = new ComparisonResourcesSwitch(branchRoot);

		for (TreeIterator<EObject> iter = resource.getAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();
			if (comparisonSwitch.doSwitch(eObject) == Boolean.FALSE) {
				iter.prune();
			}
		}

		assertEquals(existingResource, comparisonSwitch.getLastExistingObject());
		assertEquals(expectedMarker, comparisonSwitch.getExpectedObject());
	}
	
	@Test
	public void shouldExpectNullExistingMarker() {

		Resource resource = new ResourceImpl();
		IWorkspaceRoot existingRoot = TestUtil.createExpectedWorkspaceRoot();
		IContainer existingContainerOne = TestUtil.createExpectedContainerOne();
		IContainer existingContainerTwo = TestUtil.createExpectedContainerTwo();
		IResource existingResource = TestUtil.createExpectedResource();
		TextMarker existingTextMarker = TestUtil.createExpectedTextMarker();

		existingResource.getMarkers().add(existingTextMarker);
		existingContainerTwo.getMembers().add(existingResource);
		existingContainerOne.getMembers().add(existingContainerTwo);
		existingRoot.getMembers().add(existingContainerOne);
		resource.getContents().add(existingRoot);

		IWorkspaceRoot branchRoot = TestUtil.createExpectedBranch();

		ComparisonResourcesSwitch comparisonSwitch = new ComparisonResourcesSwitch(branchRoot);

		for (TreeIterator<EObject> iter = resource.getAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();
			if (comparisonSwitch.doSwitch(eObject) == Boolean.FALSE) {
				iter.prune();
			}
		}

		assertEquals(existingTextMarker, comparisonSwitch.getLastExistingObject());
		assertEquals(null, comparisonSwitch.getExpectedObject());
	}

}
