/**
 */
package corvus.model.link.impl;

import corvus.model.link.Link;
import corvus.model.link.LinkContainer;
import corvus.model.link.LinkPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link corvus.model.link.impl.LinkContainerImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link corvus.model.link.impl.LinkContainerImpl#getLastAdded <em>Last Added</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinkContainerImpl extends MinimalEObjectImpl.Container implements LinkContainer {
	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> links;

	/**
	 * The cached value of the '{@link #getLastAdded() <em>Last Added</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastAdded()
	 * @generated
	 * @ordered
	 */
	protected Link lastAdded;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LinkPackage.Literals.LINK_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLinks() {
		if (links == null) {
			links = new EObjectContainmentWithInverseEList<Link>(Link.class, this, LinkPackage.LINK_CONTAINER__LINKS, LinkPackage.LINK__LINK_CONTAINER);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link getLastAdded() {
		if (lastAdded != null && lastAdded.eIsProxy()) {
			InternalEObject oldLastAdded = (InternalEObject)lastAdded;
			lastAdded = (Link)eResolveProxy(oldLastAdded);
			if (lastAdded != oldLastAdded) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LinkPackage.LINK_CONTAINER__LAST_ADDED, oldLastAdded, lastAdded));
			}
		}
		return lastAdded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link basicGetLastAdded() {
		return lastAdded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastAdded(Link newLastAdded) {
		Link oldLastAdded = lastAdded;
		lastAdded = newLastAdded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinkPackage.LINK_CONTAINER__LAST_ADDED, oldLastAdded, lastAdded));
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
			case LinkPackage.LINK_CONTAINER__LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLinks()).basicAdd(otherEnd, msgs);
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
			case LinkPackage.LINK_CONTAINER__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
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
			case LinkPackage.LINK_CONTAINER__LINKS:
				return getLinks();
			case LinkPackage.LINK_CONTAINER__LAST_ADDED:
				if (resolve) return getLastAdded();
				return basicGetLastAdded();
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
			case LinkPackage.LINK_CONTAINER__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case LinkPackage.LINK_CONTAINER__LAST_ADDED:
				setLastAdded((Link)newValue);
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
			case LinkPackage.LINK_CONTAINER__LINKS:
				getLinks().clear();
				return;
			case LinkPackage.LINK_CONTAINER__LAST_ADDED:
				setLastAdded((Link)null);
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
			case LinkPackage.LINK_CONTAINER__LINKS:
				return links != null && !links.isEmpty();
			case LinkPackage.LINK_CONTAINER__LAST_ADDED:
				return lastAdded != null;
		}
		return super.eIsSet(featureID);
	}

} //LinkContainerImpl
