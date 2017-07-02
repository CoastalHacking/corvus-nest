package corvus.domain.e4.workspace.d2m;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.ResourcesFactory;
import corvus.domain.org.eclipse.core.resources.TextMarker;
import corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch;

/**
 * 
 * From RecordingCommand javadoc:
 *     the concrete command must not make any changes that cannot be recorded by EMF
 * Because of this, we want to add each element and then set values
 * Therefore, avoid copying objects, which may not adequately notify
 *
 */
public class AddResourcesSwitch extends ResourcesSwitch<Boolean> {

	private Resource resource;

	private EObject lastExistingObject;
	
	private ResourcesFactory factory = ResourcesFactory.eINSTANCE;

	public AddResourcesSwitch(EObject lastExistingObject, Resource resource) {
		super();
		this.lastExistingObject = lastExistingObject;
		this.resource = resource;
	}

	/**
	 * @return the lastExistingObject
	 */
	public EObject getLastExistingObject() {
		return lastExistingObject;
	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#caseIWorkspaceRoot(corvus.domain.org.eclipse.core.resources.IWorkspaceRoot)
	 */
	@Override
	public Boolean caseIWorkspaceRoot(IWorkspaceRoot object) {
		Boolean result = Boolean.FALSE;
		// When adding a root object, an existing root object shouldn't already exist
		if (lastExistingObject == null) {
			result = Boolean.TRUE;
			IWorkspaceRoot newObject = factory.createIWorkspaceRoot();
			resource.getContents().add(newObject);
			newObject.setRawLocation(object.getRawLocation());
			lastExistingObject = newObject;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#caseIContainer(corvus.domain.org.eclipse.core.resources.IContainer)
	 */
	@Override
	public Boolean caseIContainer(IContainer object) {
		Boolean result = Boolean.FALSE;
		// A container can only be added to a container
		if (lastExistingObject instanceof IContainer) {
			result = Boolean.TRUE;
			IContainer newObject = factory.createIContainer();
			((IContainer)lastExistingObject).getMembers().add(newObject);
			newObject.setName(object.getName());
			lastExistingObject = newObject;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#caseIResource(corvus.domain.org.eclipse.core.resources.IResource)
	 */
	@Override
	public Boolean caseIResource(IResource object) {
		Boolean result = Boolean.FALSE;
		// A resource can only be added to a container
		if (lastExistingObject instanceof IContainer) {
			result = Boolean.TRUE;
			IResource newObject = factory.createIResource();
			((IContainer)lastExistingObject).getMembers().add(newObject);
			newObject.setName(object.getName());
			lastExistingObject = newObject;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#caseTextMarker(corvus.domain.org.eclipse.core.resources.TextMarker)
	 */
	@Override
	public Boolean caseTextMarker(TextMarker object) {
		Boolean result = Boolean.FALSE;
		// A marker can only be added to a resource and not a container
		if (lastExistingObject instanceof IResource &&
				!(lastExistingObject instanceof IContainer)) {
			result = Boolean.TRUE;
			TextMarker newObject = factory.createTextMarker();
			((IResource)lastExistingObject).getMarkers().add(newObject);
			newObject.setId(object.getId());
			newObject.setType(object.getType());
			newObject.setCharStart(object.getCharStart());
			newObject.setCharEnd(object.getCharEnd());
			newObject.setLineNumber(object.getLineNumber());
			lastExistingObject = newObject;
		}
		return result;
	}

}
