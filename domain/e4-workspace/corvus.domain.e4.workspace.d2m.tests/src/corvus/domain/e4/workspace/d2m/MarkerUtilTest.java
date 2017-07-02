package corvus.domain.e4.workspace.d2m;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest;
import org.junit.Test;

import com.google.inject.Injector;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.TextMarker;

public class MarkerUtilTest extends AbstractEmfParsleyTest {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.parsley.junit4.AbstractEmfParsleyTest#createInjector()
	 */
	@Override
	protected Injector createInjector() {
		return D2mInjectorProvider.getInjector();
	}
	
	@Test
	public void shouldCreateBranchFromMarker() {
		long expectedId = 1234L;
		int expectedCharStart = 5;
		int expectedCharEnd = 10;
		int lineNumber = 3;
		String expectedResourceName = "Foo.java";
		List<String> expectedContainerNames = new ArrayList<>();
		String expectedContainerNameOne = "project";
		String expectedContainerNameTwo = "dir_a";
		String expectedContainerNameThree = "dir_b";
		expectedContainerNames.add(expectedContainerNameOne);
		expectedContainerNames.add(expectedContainerNameTwo);
		expectedContainerNames.add(expectedContainerNameThree);
		String expectedRawLocation = "/foo/bar"; // workspace root raw path
		
		org.eclipse.core.resources.IMarker mockMarker = TestUtil.generateMockMarker(
				expectedId, expectedCharStart, expectedCharEnd, lineNumber,
				expectedResourceName, expectedContainerNames, expectedRawLocation);
		
		Injector injector = getOrCreateInjector();
		MarkerUtil markerUtil = injector.getInstance(MarkerUtil.class);

		IWorkspaceRoot workspaceRoot = markerUtil.createBranchFromMarker(mockMarker);
		assertEquals(expectedRawLocation, workspaceRoot.getRawLocation());
		
		IContainer containerOne = workspaceRoot.getContainers().get(0);
		assertEquals(expectedContainerNameOne, containerOne.getName());
		
		IContainer containerTwo = (IContainer)containerOne.getMembers().get(0);
		assertEquals(expectedContainerNameTwo, containerTwo.getName());
		
		IContainer containerThree = (IContainer)containerTwo.getMembers().get(0);
		assertEquals(expectedContainerNameThree, containerThree.getName());
		
		IResource actualResource = containerThree.getMembers().get(0);
		assertEquals(expectedResourceName, actualResource.getName());

		TextMarker actualMarker = (TextMarker)actualResource.getMarkers().get(0);
		assertEquals(expectedId, actualMarker.getId());
		assertEquals(expectedCharStart, actualMarker.getCharStart());
		assertEquals(expectedCharEnd, actualMarker.getCharEnd());
		assertEquals(lineNumber, actualMarker.getLineNumber());
	}

}
