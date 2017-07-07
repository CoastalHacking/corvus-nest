/**
 */
package corvus.model.entrypoint.impl;

import corvus.model.entrypoint.EntryPoint;
import corvus.model.entrypoint.EntryPointFramework;
import corvus.model.entrypoint.EntrypointPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link corvus.model.entrypoint.impl.EntryPointImpl#getFramework <em>Framework</em>}</li>
 *   <li>{@link corvus.model.entrypoint.impl.EntryPointImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntryPointImpl extends MinimalEObjectImpl.Container implements EntryPoint {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "Generic Entry Point";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntrypointPackage.Literals.ENTRY_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryPointFramework getFramework() {
		if (eContainerFeatureID() != EntrypointPackage.ENTRY_POINT__FRAMEWORK) return null;
		return (EntryPointFramework)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryPointFramework basicGetFramework() {
		if (eContainerFeatureID() != EntrypointPackage.ENTRY_POINT__FRAMEWORK) return null;
		return (EntryPointFramework)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFramework(EntryPointFramework newFramework, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFramework, EntrypointPackage.ENTRY_POINT__FRAMEWORK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFramework(EntryPointFramework newFramework) {
		if (newFramework != eInternalContainer() || (eContainerFeatureID() != EntrypointPackage.ENTRY_POINT__FRAMEWORK && newFramework != null)) {
			if (EcoreUtil.isAncestor(this, newFramework))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFramework != null)
				msgs = ((InternalEObject)newFramework).eInverseAdd(this, EntrypointPackage.ENTRY_POINT_FRAMEWORK__ENTRY_POINTS, EntryPointFramework.class, msgs);
			msgs = basicSetFramework(newFramework, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntrypointPackage.ENTRY_POINT__FRAMEWORK, newFramework, newFramework));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntrypointPackage.ENTRY_POINT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EntrypointPackage.ENTRY_POINT__FRAMEWORK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFramework((EntryPointFramework)otherEnd, msgs);
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
			case EntrypointPackage.ENTRY_POINT__FRAMEWORK:
				return basicSetFramework(null, msgs);
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
			case EntrypointPackage.ENTRY_POINT__FRAMEWORK:
				return eInternalContainer().eInverseRemove(this, EntrypointPackage.ENTRY_POINT_FRAMEWORK__ENTRY_POINTS, EntryPointFramework.class, msgs);
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
			case EntrypointPackage.ENTRY_POINT__FRAMEWORK:
				if (resolve) return getFramework();
				return basicGetFramework();
			case EntrypointPackage.ENTRY_POINT__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EntrypointPackage.ENTRY_POINT__FRAMEWORK:
				setFramework((EntryPointFramework)newValue);
				return;
			case EntrypointPackage.ENTRY_POINT__NAME:
				setName((String)newValue);
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
			case EntrypointPackage.ENTRY_POINT__FRAMEWORK:
				setFramework((EntryPointFramework)null);
				return;
			case EntrypointPackage.ENTRY_POINT__NAME:
				setName(NAME_EDEFAULT);
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
			case EntrypointPackage.ENTRY_POINT__FRAMEWORK:
				return basicGetFramework() != null;
			case EntrypointPackage.ENTRY_POINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EntryPointImpl
