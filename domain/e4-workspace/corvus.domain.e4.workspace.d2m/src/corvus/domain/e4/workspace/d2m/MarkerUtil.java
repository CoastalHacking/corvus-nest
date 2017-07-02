package corvus.domain.e4.workspace.d2m;

import org.eclipse.core.runtime.CoreException;

import com.google.inject.Singleton;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.ResourcesFactory;
import corvus.domain.org.eclipse.core.resources.TextMarker;

@Singleton
public class MarkerUtil {

	public IWorkspaceRoot createBranchFromMarker(org.eclipse.core.resources.IMarker marker) {
		return createTextMarker(marker);
	}

	private IWorkspaceRoot createTextMarker(org.eclipse.core.resources.IMarker marker) {
		final TextMarker otherMarker = ResourcesFactory.eINSTANCE.createTextMarker();
		otherMarker.setId(marker.getId());
		try {
			otherMarker.setType(marker.getType());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		otherMarker.setCharStart(marker.getAttribute(org.eclipse.core.resources.IMarker.CHAR_START, -1));
		otherMarker.setCharEnd(marker.getAttribute(org.eclipse.core.resources.IMarker.CHAR_END, -1));
		otherMarker.setLineNumber(marker.getAttribute(org.eclipse.core.resources.IMarker.LINE_NUMBER, -1));

		return createResource(marker.getResource(), otherMarker);
	}

	private IWorkspaceRoot createResource(org.eclipse.core.resources.IResource resource, TextMarker textMarker) {
		final IResource otherResource = ResourcesFactory.eINSTANCE.createIResource();
		textMarker.setResource(otherResource);
		otherResource.setName(resource.getName());
		// We assume the resource is a leaf and not a container
		// If a text marker can be created like so: iworkspaceroot -> icontainer -> textmarker
		// then this assumption is incorrect and resource.getParent() returns a null, which should
		// cause an NPE immediately in createContainerHierarchy
		return createContainerHierarchy(resource.getParent(), otherResource);

	}

	private IWorkspaceRoot createContainerHierarchy(org.eclipse.core.resources.IContainer container, IResource resource) {
		final org.eclipse.core.resources.IContainer parent = container.getParent();
		if (parent == null && container instanceof org.eclipse.core.resources.IWorkspaceRoot) {
			// The resource is assumed to be a container
			return createWorkspaceRoot((org.eclipse.core.resources.IWorkspaceRoot)container, (IContainer)resource);
		} else {
			IContainer otherContainer = ResourcesFactory.eINSTANCE.createIContainer();
			resource.setParent(otherContainer);
			otherContainer.setName(container.getName());
			return createContainerHierarchy(parent, otherContainer);
		}
	}

	/*
	 * Via testing, a real workspace root does not have a name and its full path is /
	 */
	private IWorkspaceRoot createWorkspaceRoot(org.eclipse.core.resources.IWorkspaceRoot root, IContainer container) {
		final IWorkspaceRoot otherRoot = ResourcesFactory.eINSTANCE.createIWorkspaceRoot();
		container.setRoot(otherRoot);
		otherRoot.setRawLocation(root.getRawLocation().toPortableString());
		return otherRoot;
	}

}
