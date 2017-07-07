/**
 */
package corvus.model.entrypoint;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link corvus.model.entrypoint.EntryPoint#getFramework <em>Framework</em>}</li>
 *   <li>{@link corvus.model.entrypoint.EntryPoint#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see corvus.model.entrypoint.EntrypointPackage#getEntryPoint()
 * @model
 * @generated
 */
public interface EntryPoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Framework</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link corvus.model.entrypoint.EntryPointFramework#getEntryPoints <em>Entry Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Framework</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Framework</em>' container reference.
	 * @see #setFramework(EntryPointFramework)
	 * @see corvus.model.entrypoint.EntrypointPackage#getEntryPoint_Framework()
	 * @see corvus.model.entrypoint.EntryPointFramework#getEntryPoints
	 * @model opposite="entryPoints" transient="false"
	 * @generated
	 */
	EntryPointFramework getFramework();

	/**
	 * Sets the value of the '{@link corvus.model.entrypoint.EntryPoint#getFramework <em>Framework</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Framework</em>' container reference.
	 * @see #getFramework()
	 * @generated
	 */
	void setFramework(EntryPointFramework value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"Generic Entry Point"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see corvus.model.entrypoint.EntrypointPackage#getEntryPoint_Name()
	 * @model default="Generic Entry Point" unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link corvus.model.entrypoint.EntryPoint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // EntryPoint
