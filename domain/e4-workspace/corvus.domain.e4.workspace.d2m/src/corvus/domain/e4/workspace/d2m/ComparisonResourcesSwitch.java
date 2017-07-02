package corvus.domain.e4.workspace.d2m;

import org.eclipse.emf.ecore.EObject;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.TextMarker;
import corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch;

public class ComparisonResourcesSwitch extends ResourcesSwitch<Boolean> {

	private EObject lastExistingObject;

	private EObject expectedObject;

	public ComparisonResourcesSwitch(IWorkspaceRoot target) {
		super();
		this.expectedObject = target;
	}

	/**
	 * @return the lastExistingObject
	 */
	public EObject getLastExistingObject() {
		return lastExistingObject;
	}

	/**
	 * @return the expectedObject
	 */
	public EObject getExpectedObject() {
		return expectedObject;
	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#caseIWorkspaceRoot(corvus.domain.org.eclipse.core.resources.IWorkspaceRoot)
	 */
	@Override
	public Boolean caseIWorkspaceRoot(IWorkspaceRoot object) {
		Boolean result = Boolean.FALSE;

		if (expectedObject != null && 
				expectedObject instanceof IWorkspaceRoot && 
				((IWorkspaceRoot)expectedObject).getRawLocation().equals(object.getRawLocation())) {

			result = Boolean.TRUE;
			lastExistingObject = object;
			// current implementation assumes only one member
			expectedObject = ((IWorkspaceRoot)expectedObject).getMembers().get(0);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#caseIContainer(corvus.domain.org.eclipse.core.resources.IContainer)
	 */
	@Override
	public Boolean caseIContainer(IContainer object) {
		Boolean result = Boolean.FALSE;

		if (expectedObject != null && 
				expectedObject instanceof IContainer && 
				((IContainer)expectedObject).getName().equals(object.getName())) {

			result = Boolean.TRUE;
			lastExistingObject = object;
			// current implementation assumes only one member
			expectedObject = ((IContainer)expectedObject).getMembers().get(0);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#caseIResource(corvus.domain.org.eclipse.core.resources.IResource)
	 */
	@Override
	public Boolean caseIResource(IResource object) {
		Boolean result = Boolean.FALSE;

		if (expectedObject != null &&
				expectedObject instanceof IResource &&
				((IResource)expectedObject).getName().equals(object.getName())) {

			result = Boolean.TRUE;
			lastExistingObject = object;
			// current implementation assumes only one member
			expectedObject = ((IResource)expectedObject).getMarkers().get(0);
		}
		return result;

	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#caseTextMarker(corvus.domain.org.eclipse.core.resources.TextMarker)
	 */
	@Override
	public Boolean caseTextMarker(TextMarker object) {
		Boolean result = Boolean.FALSE;

		if (expectedObject != null &&
				expectedObject instanceof TextMarker &&
				((TextMarker)expectedObject).getId() == object.getId()) {

			result = Boolean.TRUE;
			lastExistingObject = object;
			// Do not expect any more objects
			expectedObject = null;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public Boolean defaultCase(EObject object) {
		return Boolean.FALSE;
	}

}
