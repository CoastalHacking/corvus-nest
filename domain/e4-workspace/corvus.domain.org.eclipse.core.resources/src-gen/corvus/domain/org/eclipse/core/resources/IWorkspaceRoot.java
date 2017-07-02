/**
 */
package corvus.domain.org.eclipse.core.resources;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IWorkspace Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getContainers <em>Containers</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getRawLocation <em>Raw Location</em>}</li>
 * </ul>
 *
 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIWorkspaceRoot()
 * @model
 * @generated
 */
public interface IWorkspaceRoot extends IContainer {
	/**
	 * Returns the value of the '<em><b>Containers</b></em>' containment reference list.
	 * The list contents are of type {@link corvus.domain.org.eclipse.core.resources.IContainer}.
	 * It is bidirectional and its opposite is '{@link corvus.domain.org.eclipse.core.resources.IContainer#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containers</em>' containment reference list.
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIWorkspaceRoot_Containers()
	 * @see corvus.domain.org.eclipse.core.resources.IContainer#getRoot
	 * @model opposite="root" containment="true"
	 * @generated
	 */
	EList<IContainer> getContainers();

	/**
	 * Returns the value of the '<em><b>Raw Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Location</em>' attribute.
	 * @see #setRawLocation(String)
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIWorkspaceRoot_RawLocation()
	 * @model unique="false"
	 * @generated
	 */
	String getRawLocation();

	/**
	 * Sets the value of the '{@link corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getRawLocation <em>Raw Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Location</em>' attribute.
	 * @see #getRawLocation()
	 * @generated
	 */
	void setRawLocation(String value);

} // IWorkspaceRoot
