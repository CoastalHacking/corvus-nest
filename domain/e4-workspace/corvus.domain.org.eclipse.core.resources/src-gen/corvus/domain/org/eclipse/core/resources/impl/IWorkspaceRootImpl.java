/**
 */
package corvus.domain.org.eclipse.core.resources.impl;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IWorkspace;
import corvus.domain.org.eclipse.core.resources.IWorkspaceRoot;
import corvus.domain.org.eclipse.core.resources.ResourcesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IWorkspace Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.IWorkspaceRootImpl#getWorkspace <em>Workspace</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.IWorkspaceRootImpl#getContainers <em>Containers</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.IWorkspaceRootImpl#getFullPath <em>Full Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IWorkspaceRootImpl extends IContainerImpl implements IWorkspaceRoot {
	/**
	 * The cached value of the '{@link #getContainers() <em>Containers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainers()
	 * @generated
	 * @ordered
	 */
	protected EList<IContainer> containers;

	/**
	 * The default value of the '{@link #getFullPath() <em>Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullPath()
	 * @generated
	 * @ordered
	 */
	protected static final String FULL_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFullPath() <em>Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullPath()
	 * @generated
	 * @ordered
	 */
	protected String fullPath = FULL_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IWorkspaceRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcesPackage.Literals.IWORKSPACE_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IWorkspace getWorkspace() {
		if (eContainerFeatureID() != ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE) return null;
		return (IWorkspace)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IWorkspace basicGetWorkspace() {
		if (eContainerFeatureID() != ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE) return null;
		return (IWorkspace)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWorkspace(IWorkspace newWorkspace, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newWorkspace, ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkspace(IWorkspace newWorkspace) {
		if (newWorkspace != eInternalContainer() || (eContainerFeatureID() != ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE && newWorkspace != null)) {
			if (EcoreUtil.isAncestor(this, newWorkspace))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newWorkspace != null)
				msgs = ((InternalEObject)newWorkspace).eInverseAdd(this, ResourcesPackage.IWORKSPACE__ROOT, IWorkspace.class, msgs);
			msgs = basicSetWorkspace(newWorkspace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE, newWorkspace, newWorkspace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IContainer> getContainers() {
		if (containers == null) {
			containers = new EObjectContainmentWithInverseEList<IContainer>(IContainer.class, this, ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS, ResourcesPackage.ICONTAINER__ROOT);
		}
		return containers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFullPath() {
		return fullPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullPath(String newFullPath) {
		String oldFullPath = fullPath;
		fullPath = newFullPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.IWORKSPACE_ROOT__FULL_PATH, oldFullPath, fullPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetWorkspace((IWorkspace)otherEnd, msgs);
			case ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContainers()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE:
				return basicSetWorkspace(null, msgs);
			case ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS:
				return ((InternalEList<?>)getContainers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE:
				return eInternalContainer().eInverseRemove(this, ResourcesPackage.IWORKSPACE__ROOT, IWorkspace.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE:
				if (resolve) return getWorkspace();
				return basicGetWorkspace();
			case ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS:
				return getContainers();
			case ResourcesPackage.IWORKSPACE_ROOT__FULL_PATH:
				return getFullPath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE:
				setWorkspace((IWorkspace)newValue);
				return;
			case ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS:
				getContainers().clear();
				getContainers().addAll((Collection<? extends IContainer>)newValue);
				return;
			case ResourcesPackage.IWORKSPACE_ROOT__FULL_PATH:
				setFullPath((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE:
				setWorkspace((IWorkspace)null);
				return;
			case ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS:
				getContainers().clear();
				return;
			case ResourcesPackage.IWORKSPACE_ROOT__FULL_PATH:
				setFullPath(FULL_PATH_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ResourcesPackage.IWORKSPACE_ROOT__WORKSPACE:
				return basicGetWorkspace() != null;
			case ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS:
				return containers != null && !containers.isEmpty();
			case ResourcesPackage.IWORKSPACE_ROOT__FULL_PATH:
				return FULL_PATH_EDEFAULT == null ? fullPath != null : !FULL_PATH_EDEFAULT.equals(fullPath);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fullPath: ");
		result.append(fullPath);
		result.append(')');
		return result.toString();
	}

} //IWorkspaceRootImpl
