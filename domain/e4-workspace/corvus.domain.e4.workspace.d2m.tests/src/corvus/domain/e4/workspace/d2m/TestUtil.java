package corvus.domain.e4.workspace.d2m;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.ResourcesFactory;
import corvus.domain.org.eclipse.core.resources.TextMarker;

public class TestUtil {
	
	private static ResourcesFactory factory = ResourcesFactory.eINSTANCE;

	public static final String expectedRawLocation = "/var/foo/bar";
	public static final String expectedContainerOneName = "project_a";
	public static final String expectedContainerTwoName = "some_dir";
	public static final String expectedResourceName = "Some.resource";
	public static final String expectedMarkerType = "some.marker.type";
	public static final long expectedMarkerId = 42L;
	public static final int expectedMarkerCharStart = 5;
	public static final int expectedMarkerCharEnd = 10;
	public static final int expectedMarkerLineNumber = 2;

	public static org.eclipse.core.resources.IMarker generateExpectedMockMarker() throws CoreException {
		List<String> expectedContainers = new ArrayList<>();
		expectedContainers.add(expectedContainerOneName);
		expectedContainers.add(expectedContainerTwoName);
		return generateMockMarker(expectedMarkerId,
				expectedMarkerType, expectedMarkerCharStart,
				expectedMarkerCharEnd, expectedMarkerLineNumber,
				expectedResourceName, expectedContainers, expectedRawLocation);
	}
	
	public static org.eclipse.core.resources.IMarker generateMockMarker(
			long id,
			String type,
			int charStart,
			int charEnd,
			int lineNumber,
			String resourceName,
			List<String> containerNames,
			String rootRawLocation) throws CoreException {
		org.eclipse.core.resources.IMarker result = mock(org.eclipse.core.resources.IMarker.class);
		/*
		final org.eclipse.core.resources.IResource iResource = marker.getResource();
		org.eclipse.core.resources.IContainer container = iResource.getParent();

		 */
		when(result.getId()).thenReturn(id);
		when(result.getType()).thenReturn(type);
		when(result.getAttribute(eq(org.eclipse.core.resources.IMarker.CHAR_START), anyInt())).thenReturn(charStart);
		when(result.getAttribute(eq(org.eclipse.core.resources.IMarker.CHAR_END), anyInt())).thenReturn(charEnd);
		when(result.getAttribute(eq(org.eclipse.core.resources.IMarker.LINE_NUMBER), anyInt())).thenReturn(lineNumber);

		org.eclipse.core.resources.IResource mockResource = mock(org.eclipse.core.resources.IResource.class);
		when(mockResource.getName()).thenReturn(resourceName);
		when(result.getResource()).thenReturn(mockResource);

		org.eclipse.core.resources.IContainer mockRootContainer = generateMockContainersAndRoot(containerNames, rootRawLocation);
		when(mockResource.getParent()).thenReturn(mockRootContainer);

		return result;
	}

	// Creates top-down
	public static org.eclipse.core.resources.IContainer generateMockContainersAndRoot(List<String> containerNames, String rootRawLocation) {

		org.eclipse.core.resources.IWorkspaceRoot workspaceRoot = mock(org.eclipse.core.resources.IWorkspaceRoot.class);
		org.eclipse.core.runtime.IPath rootPath = mock(org.eclipse.core.runtime.IPath.class);
		when(rootPath.toPortableString()).thenReturn(rootRawLocation);
		when(workspaceRoot.getRawLocation()).thenReturn(rootPath);

		org.eclipse.core.resources.IContainer previousContainer = null;
		for (String name : containerNames) {
			org.eclipse.core.resources.IContainer container = mock(org.eclipse.core.resources.IContainer.class);
			when(container.getName()).thenReturn(name);
			if (previousContainer == null) {
				when(container.getParent()).thenReturn(workspaceRoot);
			} else {
				when(container.getParent()).thenReturn(previousContainer);
			}
			previousContainer = container;
		}
		return previousContainer;
	}
	
	
	public static IWorkspaceRoot createExpectedBranch() {
		
		IWorkspaceRoot result = createWorkspaceRoot(expectedRawLocation);
		IContainer containerOne = createExpectedContainerOne();
		IContainer containerTwo = createExpectedContainerTwo();
		IResource resource = createExpectedResource();
		TextMarker textMarker = createExpectedTextMarker();
		result.getMembers().add(containerOne);
		containerOne.getMembers().add(containerTwo);
		containerTwo.getMembers().add(resource);
		resource.getMarkers().add(textMarker);
		return result;
	}

	public static IWorkspaceRoot createExpectedWorkspaceRoot() {
		return createWorkspaceRoot(expectedRawLocation);
	}
	
	public static IContainer createExpectedContainerOne() {
		return createContainer(TestUtil.expectedContainerOneName);
	}

	public static IContainer createExpectedContainerTwo() {
		return createContainer(TestUtil.expectedContainerTwoName);
	}

	public static IResource createExpectedResource() {
		return createResource(expectedResourceName);
	}

	public static TextMarker createExpectedTextMarker() {
		return createTextMarker(expectedMarkerType,
				expectedMarkerId, expectedMarkerCharStart,
				expectedMarkerCharEnd, expectedMarkerLineNumber);
	}

	public static IWorkspaceRoot createWorkspaceRoot(String rawLocation) {
		IWorkspaceRoot result = factory.createIWorkspaceRoot();
		result.setRawLocation(rawLocation);
		return result;
	}

	public static IContainer createContainer(String containerName) {
		IContainer result = factory.createIContainer();
		result.setName(containerName);
		return result;
	}
	
	public static IResource createResource(String resourceName) {
		IResource result = factory.createIResource();
		result.setName(resourceName);
		return result;
	}

	public static TextMarker createTextMarker(
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
