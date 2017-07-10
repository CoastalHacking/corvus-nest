/**
 */
package corvus.model.entrypoint;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Point Framework</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link corvus.model.entrypoint.EntryPointFramework#getEntryPoints <em>Entry Points</em>}</li>
 *   <li>{@link corvus.model.entrypoint.EntryPointFramework#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see corvus.model.entrypoint.EntrypointPackage#getEntryPointFramework()
 * @model
 * @generated
 */
public interface EntryPointFramework extends EObject {
	/**
	 * Returns the value of the '<em><b>Entry Points</b></em>' containment reference list.
	 * The list contents are of type {@link corvus.model.entrypoint.EntryPoint}.
	 * It is bidirectional and its opposite is '{@link corvus.model.entrypoint.EntryPoint#getFramework <em>Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Points</em>' containment reference list.
	 * @see corvus.model.entrypoint.EntrypointPackage#getEntryPointFramework_EntryPoints()
	 * @see corvus.model.entrypoint.EntryPoint#getFramework
	 * @model opposite="framework" containment="true"
	 * @generated
	 */
	EList<EntryPoint> getEntryPoints();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"Generic Entry Point Framework"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see corvus.model.entrypoint.EntrypointPackage#getEntryPointFramework_Name()
	 * @model default="Generic Entry Point Framework" unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link corvus.model.entrypoint.EntryPointFramework#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // EntryPointFramework
