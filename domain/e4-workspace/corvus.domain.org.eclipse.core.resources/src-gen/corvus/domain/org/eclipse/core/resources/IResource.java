/**
 */
package corvus.domain.org.eclipse.core.resources;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IResource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.IResource#getParent <em>Parent</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.IResource#getMarkers <em>Markers</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.IResource#getRelativePath <em>Relative Path</em>}</li>
 * </ul>
 *
 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIResource()
 * @model
 * @generated
 */
public interface IResource extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link corvus.domain.org.eclipse.core.resources.IContainer#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(IContainer)
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIResource_Parent()
	 * @see corvus.domain.org.eclipse.core.resources.IContainer#getMembers
	 * @model opposite="members" transient="false"
	 * @generated
	 */
	IContainer getParent();

	/**
	 * Sets the value of the '{@link corvus.domain.org.eclipse.core.resources.IResource#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(IContainer value);

	/**
	 * Returns the value of the '<em><b>Markers</b></em>' containment reference list.
	 * The list contents are of type {@link corvus.domain.org.eclipse.core.resources.IMarker}.
	 * It is bidirectional and its opposite is '{@link corvus.domain.org.eclipse.core.resources.IMarker#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Markers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Markers</em>' containment reference list.
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIResource_Markers()
	 * @see corvus.domain.org.eclipse.core.resources.IMarker#getResource
	 * @model opposite="resource" containment="true"
	 * @generated
	 */
	EList<IMarker> getMarkers();

	/**
	 * Returns the value of the '<em><b>Relative Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relative Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relative Path</em>' attribute.
	 * @see #setRelativePath(String)
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIResource_RelativePath()
	 * @model unique="false"
	 * @generated
	 */
	String getRelativePath();

	/**
	 * Sets the value of the '{@link corvus.domain.org.eclipse.core.resources.IResource#getRelativePath <em>Relative Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relative Path</em>' attribute.
	 * @see #getRelativePath()
	 * @generated
	 */
	void setRelativePath(String value);

} // IResource
