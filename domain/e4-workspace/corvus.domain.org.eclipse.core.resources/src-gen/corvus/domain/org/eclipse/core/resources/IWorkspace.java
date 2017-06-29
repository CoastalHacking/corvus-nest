/**
 */
package corvus.domain.org.eclipse.core.resources;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IWorkspace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.IWorkspace#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIWorkspace()
 * @model
 * @generated
 */
public interface IWorkspace extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getWorkspace <em>Workspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(IWorkspaceRoot)
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIWorkspace_Root()
	 * @see corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getWorkspace
	 * @model opposite="workspace" containment="true"
	 * @generated
	 */
	IWorkspaceRoot getRoot();

	/**
	 * Sets the value of the '{@link corvus.domain.org.eclipse.core.resources.IWorkspace#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(IWorkspaceRoot value);

} // IWorkspace
