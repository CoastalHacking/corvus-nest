/**
 */
package corvus.model.link;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link corvus.model.link.LinkContainer#getLinks <em>Links</em>}</li>
 *   <li>{@link corvus.model.link.LinkContainer#getState <em>State</em>}</li>
 * </ul>
 *
 * @see corvus.model.link.LinkPackage#getLinkContainer()
 * @model
 * @generated
 */
public interface LinkContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link corvus.model.link.Link}.
	 * It is bidirectional and its opposite is '{@link corvus.model.link.Link#getLinkContainer <em>Link Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see corvus.model.link.LinkPackage#getLinkContainer_Links()
	 * @see corvus.model.link.Link#getLinkContainer
	 * @model opposite="linkContainer" containment="true"
	 * @generated
	 */
	EList<Link> getLinks();

	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference.
	 * @see #setState(State)
	 * @see corvus.model.link.LinkPackage#getLinkContainer_State()
	 * @model containment="true"
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link corvus.model.link.LinkContainer#getState <em>State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' containment reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

} // LinkContainer
