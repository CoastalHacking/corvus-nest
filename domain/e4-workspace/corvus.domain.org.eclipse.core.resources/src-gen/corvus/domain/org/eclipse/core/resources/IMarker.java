/**
 */
package corvus.domain.org.eclipse.core.resources;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IMarker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.IMarker#getResource <em>Resource</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.IMarker#getId <em>Id</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.IMarker#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIMarker()
 * @model
 * @generated
 */
public interface IMarker extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link corvus.domain.org.eclipse.core.resources.IResource#getMarkers <em>Markers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' container reference.
	 * @see #setResource(IResource)
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIMarker_Resource()
	 * @see corvus.domain.org.eclipse.core.resources.IResource#getMarkers
	 * @model opposite="markers" transient="false"
	 * @generated
	 */
	IResource getResource();

	/**
	 * Sets the value of the '{@link corvus.domain.org.eclipse.core.resources.IMarker#getResource <em>Resource</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' container reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(IResource value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIMarker_Id()
	 * @model unique="false"
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link corvus.domain.org.eclipse.core.resources.IMarker#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIMarker_Type()
	 * @model unique="false"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link corvus.domain.org.eclipse.core.resources.IMarker#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // IMarker
