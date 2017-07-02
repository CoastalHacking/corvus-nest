/**
 */
package corvus.domain.org.eclipse.core.resources.impl;

import corvus.domain.org.eclipse.core.resources.IContainer;
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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IWorkspace Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.IWorkspaceRootImpl#getContainers <em>Containers</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.IWorkspaceRootImpl#getRawLocation <em>Raw Location</em>}</li>
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
	 * The default value of the '{@link #getRawLocation() <em>Raw Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String RAW_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRawLocation() <em>Raw Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawLocation()
	 * @generated
	 * @ordered
	 */
	protected String rawLocation = RAW_LOCATION_EDEFAULT;

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
	public String getRawLocation() {
		return rawLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawLocation(String newRawLocation) {
		String oldRawLocation = rawLocation;
		rawLocation = newRawLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.IWORKSPACE_ROOT__RAW_LOCATION, oldRawLocation, rawLocation));
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS:
				return getContainers();
			case ResourcesPackage.IWORKSPACE_ROOT__RAW_LOCATION:
				return getRawLocation();
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
			case ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS:
				getContainers().clear();
				getContainers().addAll((Collection<? extends IContainer>)newValue);
				return;
			case ResourcesPackage.IWORKSPACE_ROOT__RAW_LOCATION:
				setRawLocation((String)newValue);
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
			case ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS:
				getContainers().clear();
				return;
			case ResourcesPackage.IWORKSPACE_ROOT__RAW_LOCATION:
				setRawLocation(RAW_LOCATION_EDEFAULT);
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
			case ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS:
				return containers != null && !containers.isEmpty();
			case ResourcesPackage.IWORKSPACE_ROOT__RAW_LOCATION:
				return RAW_LOCATION_EDEFAULT == null ? rawLocation != null : !RAW_LOCATION_EDEFAULT.equals(rawLocation);
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
		result.append(" (rawLocation: ");
		result.append(rawLocation);
		result.append(')');
		return result.toString();
	}

} //IWorkspaceRootImpl
