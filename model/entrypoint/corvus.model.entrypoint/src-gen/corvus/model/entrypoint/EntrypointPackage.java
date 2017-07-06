/**
 */
package corvus.model.entrypoint;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see corvus.model.entrypoint.EntrypointFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel editDirectory='/corvus.model.entrypoint/src-gen' basePackage='corvus.model'"
 * @generated
 */
public interface EntrypointPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "entrypoint";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "corvus.model.entrypoint";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "entrypoint";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EntrypointPackage eINSTANCE = corvus.model.entrypoint.impl.EntrypointPackageImpl.init();

	/**
	 * The meta object id for the '{@link corvus.model.entrypoint.impl.EntryPointFrameworkImpl <em>Entry Point Framework</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see corvus.model.entrypoint.impl.EntryPointFrameworkImpl
	 * @see corvus.model.entrypoint.impl.EntrypointPackageImpl#getEntryPointFramework()
	 * @generated
	 */
	int ENTRY_POINT_FRAMEWORK = 0;

	/**
	 * The feature id for the '<em><b>Entry Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT_FRAMEWORK__ENTRY_POINTS = 0;

	/**
	 * The number of structural features of the '<em>Entry Point Framework</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT_FRAMEWORK_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Entry Point Framework</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT_FRAMEWORK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link corvus.model.entrypoint.impl.EntryPointImpl <em>Entry Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see corvus.model.entrypoint.impl.EntryPointImpl
	 * @see corvus.model.entrypoint.impl.EntrypointPackageImpl#getEntryPoint()
	 * @generated
	 */
	int ENTRY_POINT = 1;

	/**
	 * The feature id for the '<em><b>Framework</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__FRAMEWORK = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__NAME = 1;

	/**
	 * The number of structural features of the '<em>Entry Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Entry Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link corvus.model.entrypoint.EntryPointFramework <em>Entry Point Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Point Framework</em>'.
	 * @see corvus.model.entrypoint.EntryPointFramework
	 * @generated
	 */
	EClass getEntryPointFramework();

	/**
	 * Returns the meta object for the containment reference list '{@link corvus.model.entrypoint.EntryPointFramework#getEntryPoints <em>Entry Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entry Points</em>'.
	 * @see corvus.model.entrypoint.EntryPointFramework#getEntryPoints()
	 * @see #getEntryPointFramework()
	 * @generated
	 */
	EReference getEntryPointFramework_EntryPoints();

	/**
	 * Returns the meta object for class '{@link corvus.model.entrypoint.EntryPoint <em>Entry Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Point</em>'.
	 * @see corvus.model.entrypoint.EntryPoint
	 * @generated
	 */
	EClass getEntryPoint();

	/**
	 * Returns the meta object for the container reference '{@link corvus.model.entrypoint.EntryPoint#getFramework <em>Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Framework</em>'.
	 * @see corvus.model.entrypoint.EntryPoint#getFramework()
	 * @see #getEntryPoint()
	 * @generated
	 */
	EReference getEntryPoint_Framework();

	/**
	 * Returns the meta object for the attribute '{@link corvus.model.entrypoint.EntryPoint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see corvus.model.entrypoint.EntryPoint#getName()
	 * @see #getEntryPoint()
	 * @generated
	 */
	EAttribute getEntryPoint_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EntrypointFactory getEntrypointFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link corvus.model.entrypoint.impl.EntryPointFrameworkImpl <em>Entry Point Framework</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see corvus.model.entrypoint.impl.EntryPointFrameworkImpl
		 * @see corvus.model.entrypoint.impl.EntrypointPackageImpl#getEntryPointFramework()
		 * @generated
		 */
		EClass ENTRY_POINT_FRAMEWORK = eINSTANCE.getEntryPointFramework();

		/**
		 * The meta object literal for the '<em><b>Entry Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY_POINT_FRAMEWORK__ENTRY_POINTS = eINSTANCE.getEntryPointFramework_EntryPoints();

		/**
		 * The meta object literal for the '{@link corvus.model.entrypoint.impl.EntryPointImpl <em>Entry Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see corvus.model.entrypoint.impl.EntryPointImpl
		 * @see corvus.model.entrypoint.impl.EntrypointPackageImpl#getEntryPoint()
		 * @generated
		 */
		EClass ENTRY_POINT = eINSTANCE.getEntryPoint();

		/**
		 * The meta object literal for the '<em><b>Framework</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY_POINT__FRAMEWORK = eINSTANCE.getEntryPoint_Framework();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY_POINT__NAME = eINSTANCE.getEntryPoint_Name();

	}

} //EntrypointPackage
