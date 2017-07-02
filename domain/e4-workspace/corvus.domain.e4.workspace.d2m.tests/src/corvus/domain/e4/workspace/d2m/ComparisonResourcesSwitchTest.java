package corvus.domain.e4.workspace.d2m;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.junit.Test;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.ResourcesFactory;
import corvus.domain.org.eclipse.core.resources.TextMarker;

public class ComparisonResourcesSwitchTest {

	private final String expectedRawLocation = "/var/foo/bar";
	private final String expectedContainerOneName = "project_a";
	private final String expectedContainerTwoName = "some_dir";
	private final String expectedResourceName = "Some.resource";
	private final String expectedMarkerType = "some.marker.type";
	private final long expectedMarkerId = 42L;
	private final int expectedMarkerCharStart = 5;
	private final int expectedMarkerCharEnd = 10;
	private final int expectedMarkerLineNumber = 2;

	private ResourcesFactory factory = ResourcesFactory.eINSTANCE;

	@Test
	public void shouldExpectWorkspaceRootNullExisting() {
		
		Resource resource = new ResourceImpl();
		IWorkspaceRoot expectedObject = createExpectedBranch(expectedRawLocation);
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
		IWorkspaceRoot existingRoot = factory.createIWorkspaceRoot();
		existingRoot.setRawLocation(expectedRawLocation);
		resource.getContents().add(existingRoot);

		IWorkspaceRoot branchRoot = createExpectedBranch(expectedRawLocation);
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
		IWorkspaceRoot existingRoot = factory.createIWorkspaceRoot();
		existingRoot.setRawLocation(expectedRawLocation);
		IContainer existingContainerOne = createContainer(expectedContainerOneName);
		existingRoot.getMembers().add(existingContainerOne);
		resource.getContents().add(existingRoot);

		IWorkspaceRoot branchRoot = createExpectedBranch(expectedRawLocation);
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
		IWorkspaceRoot existingRoot = factory.createIWorkspaceRoot();
		existingRoot.setRawLocation(expectedRawLocation);
		IContainer existingContainerOne = createContainer(expectedContainerOneName);
		IContainer existingContainerTwo = createContainer(expectedContainerTwoName);
		existingContainerOne.getMembers().add(existingContainerTwo);
		existingRoot.getMembers().add(existingContainerOne);
		resource.getContents().add(existingRoot);

		IWorkspaceRoot branchRoot = createExpectedBranch(expectedRawLocation);
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
		IWorkspaceRoot existingRoot = factory.createIWorkspaceRoot();
		existingRoot.setRawLocation(expectedRawLocation);
		IContainer existingContainerOne = createContainer(expectedContainerOneName);
		IContainer existingContainerTwo = createContainer(expectedContainerTwoName);
		IResource existingResource = createResource(expectedResourceName);
		existingContainerTwo.getMembers().add(existingResource);
		existingContainerOne.getMembers().add(existingContainerTwo);
		existingRoot.getMembers().add(existingContainerOne);
		resource.getContents().add(existingRoot);

		IWorkspaceRoot branchRoot = createExpectedBranch(expectedRawLocation);
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
		IWorkspaceRoot existingRoot = factory.createIWorkspaceRoot();
		existingRoot.setRawLocation(expectedRawLocation);
		IContainer existingContainerOne = createContainer(expectedContainerOneName);
		IContainer existingContainerTwo = createContainer(expectedContainerTwoName);
		IResource existingResource = createResource(expectedResourceName);
		TextMarker existingTextMarker = createTextMarker(expectedMarkerType, expectedMarkerId,
				expectedMarkerCharStart, expectedMarkerCharEnd, expectedMarkerLineNumber);

		existingResource.getMarkers().add(existingTextMarker);
		existingContainerTwo.getMembers().add(existingResource);
		existingContainerOne.getMembers().add(existingContainerTwo);
		existingRoot.getMembers().add(existingContainerOne);
		resource.getContents().add(existingRoot);

		IWorkspaceRoot branchRoot = createExpectedBranch(expectedRawLocation);

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
	
	private IWorkspaceRoot createExpectedBranch(String rawLocation) {
		
		IWorkspaceRoot result = factory.createIWorkspaceRoot();
		result.setRawLocation(rawLocation);

		IContainer containerOne = createContainer(expectedContainerOneName);
		IContainer containerTwo = createContainer(expectedContainerTwoName);
		IResource resource = createResource(expectedResourceName);
		TextMarker textMarker = createTextMarker(expectedMarkerType, expectedMarkerId,
				expectedMarkerCharStart, expectedMarkerCharEnd, expectedMarkerLineNumber);

		result.getMembers().add(containerOne);
		containerOne.getMembers().add(containerTwo);
		containerTwo.getMembers().add(resource);
		resource.getMarkers().add(textMarker);
		return result;
	}
	
	private IContainer createContainer(String containerName) {
		IContainer result = factory.createIContainer();
		result.setName(containerName);
		return result;
	}
	
	private IResource createResource(String resourceName) {
		IResource result = factory.createIResource();
		result.setName(resourceName);
		return result;
	}

	private TextMarker createTextMarker(
			String markerType, long markerId,
			int markerCharStart, int markerCharEnd, int expectedMarkerLineNumber) {
		TextMarker result = factory.createTextMarker();
		result.setType(markerType);
		result.setId(markerId);
		result.setCharStart(markerCharStart);
		result.setCharEnd(markerCharEnd);
		result.setLineNumber(expectedMarkerLineNumber);
		return result;
	}
}
