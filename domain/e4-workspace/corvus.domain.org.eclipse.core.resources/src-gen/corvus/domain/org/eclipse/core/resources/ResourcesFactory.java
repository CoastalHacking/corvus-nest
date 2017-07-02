/**
 */
package corvus.domain.org.eclipse.core.resources;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage
 * @generated
 */
public interface ResourcesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourcesFactory eINSTANCE = corvus.domain.org.eclipse.core.resources.impl.ResourcesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>IWorkspace Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IWorkspace Root</em>'.
	 * @generated
	 */
	IWorkspaceRoot createIWorkspaceRoot();

	/**
	 * Returns a new object of class '<em>IContainer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IContainer</em>'.
	 * @generated
	 */
	IContainer createIContainer();

	/**
	 * Returns a new object of class '<em>IResource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IResource</em>'.
	 * @generated
	 */
	IResource createIResource();

	/**
	 * Returns a new object of class '<em>IMarker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IMarker</em>'.
	 * @generated
	 */
	IMarker createIMarker();

	/**
	 * Returns a new object of class '<em>Text Marker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Marker</em>'.
	 * @generated
	 */
	TextMarker createTextMarker();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResourcesPackage getResourcesPackage();

} //ResourcesFactory
