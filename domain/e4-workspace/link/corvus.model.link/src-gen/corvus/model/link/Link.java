/**
 */
package corvus.model.link;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link corvus.model.link.Link#getLinkContainer <em>Link Container</em>}</li>
 *   <li>{@link corvus.model.link.Link#getTo <em>To</em>}</li>
 *   <li>{@link corvus.model.link.Link#getFrom <em>From</em>}</li>
 * </ul>
 *
 * @see corvus.model.link.LinkPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends EObject {
	/**
	 * Returns the value of the '<em><b>Link Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link corvus.model.link.LinkContainer#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Container</em>' container reference.
	 * @see #setLinkContainer(LinkContainer)
	 * @see corvus.model.link.LinkPackage#getLink_LinkContainer()
	 * @see corvus.model.link.LinkContainer#getLinks
	 * @model opposite="links" transient="false"
	 * @generated
	 */
	LinkContainer getLinkContainer();

	/**
	 * Sets the value of the '{@link corvus.model.link.Link#getLinkContainer <em>Link Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Container</em>' container reference.
	 * @see #getLinkContainer()
	 * @generated
	 */
	void setLinkContainer(LinkContainer value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference list.
	 * The list contents are of type {@link corvus.model.link.Link}.
	 * It is bidirectional and its opposite is '{@link corvus.model.link.Link#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference list.
	 * @see corvus.model.link.LinkPackage#getLink_To()
	 * @see corvus.model.link.Link#getFrom
	 * @model opposite="from"
	 * @generated
	 */
	EList<Link> getTo();

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference list.
	 * The list contents are of type {@link corvus.model.link.Link}.
	 * It is bidirectional and its opposite is '{@link corvus.model.link.Link#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference list.
	 * @see corvus.model.link.LinkPackage#getLink_From()
	 * @see corvus.model.link.Link#getTo
	 * @model opposite="to"
	 * @generated
	 */
	EList<Link> getFrom();

} // Link
