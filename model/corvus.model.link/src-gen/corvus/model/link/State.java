/**
 */
package corvus.model.link;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link corvus.model.link.State#getLastAdded <em>Last Added</em>}</li>
 *   <li>{@link corvus.model.link.State#getDirection <em>Direction</em>}</li>
 * </ul>
 *
 * @see corvus.model.link.LinkPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Last Added</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Added</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Added</em>' reference.
	 * @see #setLastAdded(Link)
	 * @see corvus.model.link.LinkPackage#getState_LastAdded()
	 * @model
	 * @generated
	 */
	Link getLastAdded();

	/**
	 * Sets the value of the '{@link corvus.model.link.State#getLastAdded <em>Last Added</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Added</em>' reference.
	 * @see #getLastAdded()
	 * @generated
	 */
	void setLastAdded(Link value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link corvus.model.link.Direction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see corvus.model.link.Direction
	 * @see #setDirection(Direction)
	 * @see corvus.model.link.LinkPackage#getState_Direction()
	 * @model unique="false"
	 * @generated
	 */
	Direction getDirection();

	/**
	 * Sets the value of the '{@link corvus.model.link.State#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see corvus.model.link.Direction
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(Direction value);

} // State
