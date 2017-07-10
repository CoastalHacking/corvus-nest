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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link corvus.model.link.impl.LinkImpl#getLinkContainer <em>Link Container</em>}</li>
 *   <li>{@link corvus.model.link.impl.LinkImpl#getTo <em>To</em>}</li>
 *   <li>{@link corvus.model.link.impl.LinkImpl#getFrom <em>From</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinkImpl extends MinimalEObjectImpl.Container implements Link {
	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> to;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> from;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LinkPackage.Literals.LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkContainer getLinkContainer() {
		if (eContainerFeatureID() != LinkPackage.LINK__LINK_CONTAINER) return null;
		return (LinkContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkContainer basicGetLinkContainer() {
		if (eContainerFeatureID() != LinkPackage.LINK__LINK_CONTAINER) return null;
		return (LinkContainer)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinkContainer(LinkContainer newLinkContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLinkContainer, LinkPackage.LINK__LINK_CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkContainer(LinkContainer newLinkContainer) {
		if (newLinkContainer != eInternalContainer() || (eContainerFeatureID() != LinkPackage.LINK__LINK_CONTAINER && newLinkContainer != null)) {
			if (EcoreUtil.isAncestor(this, newLinkContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLinkContainer != null)
				msgs = ((InternalEObject)newLinkContainer).eInverseAdd(this, LinkPackage.LINK_CONTAINER__LINKS, LinkContainer.class, msgs);
			msgs = basicSetLinkContainer(newLinkContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LinkPackage.LINK__LINK_CONTAINER, newLinkContainer, newLinkContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getTo() {
		if (to == null) {
			to = new EObjectWithInverseResolvingEList.ManyInverse<Link>(Link.class, this, LinkPackage.LINK__TO, LinkPackage.LINK__FROM);
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getFrom() {
		if (from == null) {
			from = new EObjectWithInverseResolvingEList.ManyInverse<Link>(Link.class, this, LinkPackage.LINK__FROM, LinkPackage.LINK__TO);
		}
		return from;
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
			case LinkPackage.LINK__LINK_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLinkContainer((LinkContainer)otherEnd, msgs);
			case LinkPackage.LINK__TO:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTo()).basicAdd(otherEnd, msgs);
			case LinkPackage.LINK__FROM:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFrom()).basicAdd(otherEnd, msgs);
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
			case LinkPackage.LINK__LINK_CONTAINER:
				return basicSetLinkContainer(null, msgs);
			case LinkPackage.LINK__TO:
				return ((InternalEList<?>)getTo()).basicRemove(otherEnd, msgs);
			case LinkPackage.LINK__FROM:
				return ((InternalEList<?>)getFrom()).basicRemove(otherEnd, msgs);
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
			case LinkPackage.LINK__LINK_CONTAINER:
				return eInternalContainer().eInverseRemove(this, LinkPackage.LINK_CONTAINER__LINKS, LinkContainer.class, msgs);
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
			case LinkPackage.LINK__LINK_CONTAINER:
				if (resolve) return getLinkContainer();
				return basicGetLinkContainer();
			case LinkPackage.LINK__TO:
				return getTo();
			case LinkPackage.LINK__FROM:
				return getFrom();
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
			case LinkPackage.LINK__LINK_CONTAINER:
				setLinkContainer((LinkContainer)newValue);
				return;
			case LinkPackage.LINK__TO:
				getTo().clear();
				getTo().addAll((Collection<? extends Link>)newValue);
				return;
			case LinkPackage.LINK__FROM:
				getFrom().clear();
				getFrom().addAll((Collection<? extends Link>)newValue);
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
			case LinkPackage.LINK__LINK_CONTAINER:
				setLinkContainer((LinkContainer)null);
				return;
			case LinkPackage.LINK__TO:
				getTo().clear();
				return;
			case LinkPackage.LINK__FROM:
				getFrom().clear();
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
			case LinkPackage.LINK__LINK_CONTAINER:
				return basicGetLinkContainer() != null;
			case LinkPackage.LINK__TO:
				return to != null && !to.isEmpty();
			case LinkPackage.LINK__FROM:
				return from != null && !from.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LinkImpl
