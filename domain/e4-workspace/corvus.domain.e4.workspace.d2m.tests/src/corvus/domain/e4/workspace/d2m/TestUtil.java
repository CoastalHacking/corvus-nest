package corvus.domain.e4.workspace.d2m;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

public class TestUtil {

	public static org.eclipse.core.resources.IMarker generateMockMarker(
			long id,
			int charStart,
			int charEnd,
			int lineNumber,
			String resourceName,
			List<String> containerNames,
			String rootRawLocation) {
		org.eclipse.core.resources.IMarker result = mock(org.eclipse.core.resources.IMarker.class);
		/*
		final org.eclipse.core.resources.IResource iResource = marker.getResource();
		org.eclipse.core.resources.IContainer container = iResource.getParent();

		 */
		when(result.getId()).thenReturn(id);
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
}
