/**
 */
package corvus.domain.org.eclipse.core.resources.impl;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IMarker;
import corvus.domain.org.eclipse.core.resources.IResource;
import corvus.domain.org.eclipse.core.resources.ResourcesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IResource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.IResourceImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.IResourceImpl#getMarkers <em>Markers</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.IResourceImpl#getRelativePath <em>Relative Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IResourceImpl extends MinimalEObjectImpl.Container implements IResource {
	/**
	 * The cached value of the '{@link #getMarkers() <em>Markers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarkers()
	 * @generated
	 * @ordered
	 */
	protected EList<IMarker> markers;

	/**
	 * The default value of the '{@link #getRelativePath() <em>Relative Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativePath()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATIVE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelativePath() <em>Relative Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativePath()
	 * @generated
	 * @ordered
	 */
	protected String relativePath = RELATIVE_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcesPackage.Literals.IRESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IContainer getParent() {
		if (eContainerFeatureID() != ResourcesPackage.IRESOURCE__PARENT) return null;
		return (IContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IContainer basicGetParent() {
		if (eContainerFeatureID() != ResourcesPackage.IRESOURCE__PARENT) return null;
		return (IContainer)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(IContainer newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, ResourcesPackage.IRESOURCE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(IContainer newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != ResourcesPackage.IRESOURCE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, ResourcesPackage.ICONTAINER__MEMBERS, IContainer.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.IRESOURCE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IMarker> getMarkers() {
		if (markers == null) {
			markers = new EObjectContainmentWithInverseEList<IMarker>(IMarker.class, this, ResourcesPackage.IRESOURCE__MARKERS, ResourcesPackage.IMARKER__RESOURCE);
		}
		return markers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelativePath() {
		return relativePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelativePath(String newRelativePath) {
		String oldRelativePath = relativePath;
		relativePath = newRelativePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.IRESOURCE__RELATIVE_PATH, oldRelativePath, relativePath));
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
			case ResourcesPackage.IRESOURCE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((IContainer)otherEnd, msgs);
			case ResourcesPackage.IRESOURCE__MARKERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMarkers()).basicAdd(otherEnd, msgs);
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
			case ResourcesPackage.IRESOURCE__PARENT:
				return basicSetParent(null, msgs);
			case ResourcesPackage.IRESOURCE__MARKERS:
				return ((InternalEList<?>)getMarkers()).basicRemove(otherEnd, msgs);
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
			case ResourcesPackage.IRESOURCE__PARENT:
				return eInternalContainer().eInverseRemove(this, ResourcesPackage.ICONTAINER__MEMBERS, IContainer.class, msgs);
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
			case ResourcesPackage.IRESOURCE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ResourcesPackage.IRESOURCE__MARKERS:
				return getMarkers();
			case ResourcesPackage.IRESOURCE__RELATIVE_PATH:
				return getRelativePath();
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
			case ResourcesPackage.IRESOURCE__PARENT:
				setParent((IContainer)newValue);
				return;
			case ResourcesPackage.IRESOURCE__MARKERS:
				getMarkers().clear();
				getMarkers().addAll((Collection<? extends IMarker>)newValue);
				return;
			case ResourcesPackage.IRESOURCE__RELATIVE_PATH:
				setRelativePath((String)newValue);
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
			case ResourcesPackage.IRESOURCE__PARENT:
				setParent((IContainer)null);
				return;
			case ResourcesPackage.IRESOURCE__MARKERS:
				getMarkers().clear();
				return;
			case ResourcesPackage.IRESOURCE__RELATIVE_PATH:
				setRelativePath(RELATIVE_PATH_EDEFAULT);
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
			case ResourcesPackage.IRESOURCE__PARENT:
				return basicGetParent() != null;
			case ResourcesPackage.IRESOURCE__MARKERS:
				return markers != null && !markers.isEmpty();
			case ResourcesPackage.IRESOURCE__RELATIVE_PATH:
				return RELATIVE_PATH_EDEFAULT == null ? relativePath != null : !RELATIVE_PATH_EDEFAULT.equals(relativePath);
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
		result.append(" (relativePath: ");
		result.append(relativePath);
		result.append(')');
		return result.toString();
	}

} //IResourceImpl
