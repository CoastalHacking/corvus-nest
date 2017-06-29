/**
 */
package corvus.domain.org.eclipse.core.resources;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IContainer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.IContainer#getRoot <em>Root</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.IContainer#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIContainer()
 * @model
 * @generated
 */
public interface IContainer extends IResource {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' container reference.
	 * @see #setRoot(IWorkspaceRoot)
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIContainer_Root()
	 * @see corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getContainers
	 * @model opposite="containers" transient="false"
	 * @generated
	 */
	IWorkspaceRoot getRoot();

	/**
	 * Sets the value of the '{@link corvus.domain.org.eclipse.core.resources.IContainer#getRoot <em>Root</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' container reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(IWorkspaceRoot value);

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link corvus.domain.org.eclipse.core.resources.IResource}.
	 * It is bidirectional and its opposite is '{@link corvus.domain.org.eclipse.core.resources.IResource#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getIContainer_Members()
	 * @see corvus.domain.org.eclipse.core.resources.IResource#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<IResource> getMembers();

} // IContainer
