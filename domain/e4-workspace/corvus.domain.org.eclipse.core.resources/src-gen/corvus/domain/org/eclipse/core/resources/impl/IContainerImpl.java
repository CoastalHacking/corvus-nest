/**
 */
package corvus.domain.org.eclipse.core.resources.impl;

import corvus.domain.org.eclipse.core.resources.IContainer;
import corvus.domain.org.eclipse.core.resources.IResource;
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
 * An implementation of the model object '<em><b>IContainer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.IContainerImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.IContainerImpl#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IContainerImpl extends IResourceImpl implements IContainer {
	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<IResource> members;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcesPackage.Literals.ICONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IWorkspaceRoot getRoot() {
		if (eContainerFeatureID() != ResourcesPackage.ICONTAINER__ROOT) return null;
		return (IWorkspaceRoot)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IWorkspaceRoot basicGetRoot() {
		if (eContainerFeatureID() != ResourcesPackage.ICONTAINER__ROOT) return null;
		return (IWorkspaceRoot)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoot(IWorkspaceRoot newRoot, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRoot, ResourcesPackage.ICONTAINER__ROOT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(IWorkspaceRoot newRoot) {
		if (newRoot != eInternalContainer() || (eContainerFeatureID() != ResourcesPackage.ICONTAINER__ROOT && newRoot != null)) {
			if (EcoreUtil.isAncestor(this, newRoot))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRoot != null)
				msgs = ((InternalEObject)newRoot).eInverseAdd(this, ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS, IWorkspaceRoot.class, msgs);
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.ICONTAINER__ROOT, newRoot, newRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IResource> getMembers() {
		if (members == null) {
			members = new EObjectContainmentWithInverseEList<IResource>(IResource.class, this, ResourcesPackage.ICONTAINER__MEMBERS, ResourcesPackage.IRESOURCE__PARENT);
		}
		return members;
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
			case ResourcesPackage.ICONTAINER__ROOT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRoot((IWorkspaceRoot)otherEnd, msgs);
			case ResourcesPackage.ICONTAINER__MEMBERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMembers()).basicAdd(otherEnd, msgs);
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
			case ResourcesPackage.ICONTAINER__ROOT:
				return basicSetRoot(null, msgs);
			case ResourcesPackage.ICONTAINER__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
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
			case ResourcesPackage.ICONTAINER__ROOT:
				return eInternalContainer().eInverseRemove(this, ResourcesPackage.IWORKSPACE_ROOT__CONTAINERS, IWorkspaceRoot.class, msgs);
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
			case ResourcesPackage.ICONTAINER__ROOT:
				if (resolve) return getRoot();
				return basicGetRoot();
			case ResourcesPackage.ICONTAINER__MEMBERS:
				return getMembers();
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
			case ResourcesPackage.ICONTAINER__ROOT:
				setRoot((IWorkspaceRoot)newValue);
				return;
			case ResourcesPackage.ICONTAINER__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends IResource>)newValue);
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
			case ResourcesPackage.ICONTAINER__ROOT:
				setRoot((IWorkspaceRoot)null);
				return;
			case ResourcesPackage.ICONTAINER__MEMBERS:
				getMembers().clear();
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
			case ResourcesPackage.ICONTAINER__ROOT:
				return basicGetRoot() != null;
			case ResourcesPackage.ICONTAINER__MEMBERS:
				return members != null && !members.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IContainerImpl
