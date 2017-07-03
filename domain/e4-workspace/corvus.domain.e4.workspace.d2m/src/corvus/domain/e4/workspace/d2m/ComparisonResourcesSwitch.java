package corvus.domain.e4.workspace.d2m;

import java.util.Iterator;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.TextMarker;
import corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch;

public class ComparisonResourcesSwitch extends ResourcesSwitch<Boolean> {

	private static EObject EMTPY_OBJECT;

	static {
		EcoreFactory factory = EcoreFactory.eINSTANCE;
		EClass eClass = factory.createEClass();
		eClass.setName(ComparisonResourcesSwitch.class.getName());
		EPackage ePackage = factory.createEPackage();
		ePackage.getEClassifiers().add(eClass);
		EMTPY_OBJECT = EcoreUtil.create(eClass);
	}

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

	protected static class RootTreeIterator extends AbstractTreeIterator<EObject> {

		private static final long serialVersionUID = -2983077965481399462L;

		public RootTreeIterator(Object object) {
			super(object, /*includeRoot*/true);
		}

		@Override
		protected Iterator<? extends EObject> getChildren(Object object) {
			if (object == null) {
				return ECollections.<EObject>emptyEList().iterator();
			} else {
				EObject eObject = (EObject)object;
				return eObject.eContents().iterator();
			}
		}

	}

	/**
	 * 
	 * @return a non-nullable tree iterator over the objects to add
	 */
	public TreeIterator<EObject> getObjectsToAdd() {
		return (getExpectedObject() == null) ?
				EMTPY_OBJECT.eAllContents() :
					new RootTreeIterator(getExpectedObject());
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
			expectedObject = ((IWorkspaceRoot)expectedObject).getContainers().get(0);
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
