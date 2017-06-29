/**
 */
package corvus.domain.org.eclipse.core.resources;

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
 * @see corvus.domain.org.eclipse.core.resources.ResourcesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='corvus.domain.org.eclipse.core'"
 * @generated
 */
public interface ResourcesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resources";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "corvus.domain.org.eclipse.core.resources";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "resources";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourcesPackage eINSTANCE = corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl.init();

	/**
	 * The meta object id for the '{@link corvus.domain.org.eclipse.core.resources.impl.IWorkspaceImpl <em>IWorkspace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see corvus.domain.org.eclipse.core.resources.impl.IWorkspaceImpl
	 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getIWorkspace()
	 * @generated
	 */
	int IWORKSPACE = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE__ROOT = 0;

	/**
	 * The number of structural features of the '<em>IWorkspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>IWorkspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link corvus.domain.org.eclipse.core.resources.impl.IResourceImpl <em>IResource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see corvus.domain.org.eclipse.core.resources.impl.IResourceImpl
	 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getIResource()
	 * @generated
	 */
	int IRESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE__MARKERS = 1;

	/**
	 * The feature id for the '<em><b>Relative Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE__RELATIVE_PATH = 2;

	/**
	 * The number of structural features of the '<em>IResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>IResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link corvus.domain.org.eclipse.core.resources.impl.IContainerImpl <em>IContainer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see corvus.domain.org.eclipse.core.resources.impl.IContainerImpl
	 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getIContainer()
	 * @generated
	 */
	int ICONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTAINER__PARENT = IRESOURCE__PARENT;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTAINER__MARKERS = IRESOURCE__MARKERS;

	/**
	 * The feature id for the '<em><b>Relative Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTAINER__RELATIVE_PATH = IRESOURCE__RELATIVE_PATH;

	/**
	 * The feature id for the '<em><b>Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTAINER__ROOT = IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTAINER__MEMBERS = IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IContainer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTAINER_FEATURE_COUNT = IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>IContainer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTAINER_OPERATION_COUNT = IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link corvus.domain.org.eclipse.core.resources.impl.IWorkspaceRootImpl <em>IWorkspace Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see corvus.domain.org.eclipse.core.resources.impl.IWorkspaceRootImpl
	 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getIWorkspaceRoot()
	 * @generated
	 */
	int IWORKSPACE_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_ROOT__PARENT = ICONTAINER__PARENT;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_ROOT__MARKERS = ICONTAINER__MARKERS;

	/**
	 * The feature id for the '<em><b>Relative Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_ROOT__RELATIVE_PATH = ICONTAINER__RELATIVE_PATH;

	/**
	 * The feature id for the '<em><b>Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_ROOT__ROOT = ICONTAINER__ROOT;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_ROOT__MEMBERS = ICONTAINER__MEMBERS;

	/**
	 * The feature id for the '<em><b>Workspace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_ROOT__WORKSPACE = ICONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_ROOT__CONTAINERS = ICONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Full Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_ROOT__FULL_PATH = ICONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>IWorkspace Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_ROOT_FEATURE_COUNT = ICONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>IWorkspace Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IWORKSPACE_ROOT_OPERATION_COUNT = ICONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link corvus.domain.org.eclipse.core.resources.impl.IMarkerImpl <em>IMarker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see corvus.domain.org.eclipse.core.resources.impl.IMarkerImpl
	 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getIMarker()
	 * @generated
	 */
	int IMARKER = 4;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMARKER__RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMARKER__ID = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMARKER__TYPE = 2;

	/**
	 * The number of structural features of the '<em>IMarker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMARKER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>IMarker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMARKER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link corvus.domain.org.eclipse.core.resources.impl.TextMarkerImpl <em>Text Marker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see corvus.domain.org.eclipse.core.resources.impl.TextMarkerImpl
	 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getTextMarker()
	 * @generated
	 */
	int TEXT_MARKER = 5;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_MARKER__RESOURCE = IMARKER__RESOURCE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_MARKER__ID = IMARKER__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_MARKER__TYPE = IMARKER__TYPE;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_MARKER__LINE_NUMBER = IMARKER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Char Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_MARKER__CHAR_START = IMARKER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Char End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_MARKER__CHAR_END = IMARKER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Text Marker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_MARKER_FEATURE_COUNT = IMARKER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Text Marker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_MARKER_OPERATION_COUNT = IMARKER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link corvus.domain.org.eclipse.core.resources.IWorkspace <em>IWorkspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IWorkspace</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IWorkspace
	 * @generated
	 */
	EClass getIWorkspace();

	/**
	 * Returns the meta object for the containment reference '{@link corvus.domain.org.eclipse.core.resources.IWorkspace#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IWorkspace#getRoot()
	 * @see #getIWorkspace()
	 * @generated
	 */
	EReference getIWorkspace_Root();

	/**
	 * Returns the meta object for class '{@link corvus.domain.org.eclipse.core.resources.IWorkspaceRoot <em>IWorkspace Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IWorkspace Root</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IWorkspaceRoot
	 * @generated
	 */
	EClass getIWorkspaceRoot();

	/**
	 * Returns the meta object for the container reference '{@link corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getWorkspace <em>Workspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Workspace</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getWorkspace()
	 * @see #getIWorkspaceRoot()
	 * @generated
	 */
	EReference getIWorkspaceRoot_Workspace();

	/**
	 * Returns the meta object for the containment reference list '{@link corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Containers</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getContainers()
	 * @see #getIWorkspaceRoot()
	 * @generated
	 */
	EReference getIWorkspaceRoot_Containers();

	/**
	 * Returns the meta object for the attribute '{@link corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getFullPath <em>Full Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Path</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IWorkspaceRoot#getFullPath()
	 * @see #getIWorkspaceRoot()
	 * @generated
	 */
	EAttribute getIWorkspaceRoot_FullPath();

	/**
	 * Returns the meta object for class '{@link corvus.domain.org.eclipse.core.resources.IContainer <em>IContainer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IContainer</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IContainer
	 * @generated
	 */
	EClass getIContainer();

	/**
	 * Returns the meta object for the container reference '{@link corvus.domain.org.eclipse.core.resources.IContainer#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Root</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IContainer#getRoot()
	 * @see #getIContainer()
	 * @generated
	 */
	EReference getIContainer_Root();

	/**
	 * Returns the meta object for the containment reference list '{@link corvus.domain.org.eclipse.core.resources.IContainer#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IContainer#getMembers()
	 * @see #getIContainer()
	 * @generated
	 */
	EReference getIContainer_Members();

	/**
	 * Returns the meta object for class '{@link corvus.domain.org.eclipse.core.resources.IResource <em>IResource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IResource</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IResource
	 * @generated
	 */
	EClass getIResource();

	/**
	 * Returns the meta object for the container reference '{@link corvus.domain.org.eclipse.core.resources.IResource#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IResource#getParent()
	 * @see #getIResource()
	 * @generated
	 */
	EReference getIResource_Parent();

	/**
	 * Returns the meta object for the containment reference list '{@link corvus.domain.org.eclipse.core.resources.IResource#getMarkers <em>Markers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Markers</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IResource#getMarkers()
	 * @see #getIResource()
	 * @generated
	 */
	EReference getIResource_Markers();

	/**
	 * Returns the meta object for the attribute '{@link corvus.domain.org.eclipse.core.resources.IResource#getRelativePath <em>Relative Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relative Path</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IResource#getRelativePath()
	 * @see #getIResource()
	 * @generated
	 */
	EAttribute getIResource_RelativePath();

	/**
	 * Returns the meta object for class '{@link corvus.domain.org.eclipse.core.resources.IMarker <em>IMarker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IMarker</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IMarker
	 * @generated
	 */
	EClass getIMarker();

	/**
	 * Returns the meta object for the container reference '{@link corvus.domain.org.eclipse.core.resources.IMarker#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IMarker#getResource()
	 * @see #getIMarker()
	 * @generated
	 */
	EReference getIMarker_Resource();

	/**
	 * Returns the meta object for the attribute '{@link corvus.domain.org.eclipse.core.resources.IMarker#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IMarker#getId()
	 * @see #getIMarker()
	 * @generated
	 */
	EAttribute getIMarker_Id();

	/**
	 * Returns the meta object for the attribute '{@link corvus.domain.org.eclipse.core.resources.IMarker#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.IMarker#getType()
	 * @see #getIMarker()
	 * @generated
	 */
	EAttribute getIMarker_Type();

	/**
	 * Returns the meta object for class '{@link corvus.domain.org.eclipse.core.resources.TextMarker <em>Text Marker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Marker</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.TextMarker
	 * @generated
	 */
	EClass getTextMarker();

	/**
	 * Returns the meta object for the attribute '{@link corvus.domain.org.eclipse.core.resources.TextMarker#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.TextMarker#getLineNumber()
	 * @see #getTextMarker()
	 * @generated
	 */
	EAttribute getTextMarker_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link corvus.domain.org.eclipse.core.resources.TextMarker#getCharStart <em>Char Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Char Start</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.TextMarker#getCharStart()
	 * @see #getTextMarker()
	 * @generated
	 */
	EAttribute getTextMarker_CharStart();

	/**
	 * Returns the meta object for the attribute '{@link corvus.domain.org.eclipse.core.resources.TextMarker#getCharEnd <em>Char End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Char End</em>'.
	 * @see corvus.domain.org.eclipse.core.resources.TextMarker#getCharEnd()
	 * @see #getTextMarker()
	 * @generated
	 */
	EAttribute getTextMarker_CharEnd();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourcesFactory getResourcesFactory();

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
		 * The meta object literal for the '{@link corvus.domain.org.eclipse.core.resources.impl.IWorkspaceImpl <em>IWorkspace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see corvus.domain.org.eclipse.core.resources.impl.IWorkspaceImpl
		 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getIWorkspace()
		 * @generated
		 */
		EClass IWORKSPACE = eINSTANCE.getIWorkspace();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IWORKSPACE__ROOT = eINSTANCE.getIWorkspace_Root();

		/**
		 * The meta object literal for the '{@link corvus.domain.org.eclipse.core.resources.impl.IWorkspaceRootImpl <em>IWorkspace Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see corvus.domain.org.eclipse.core.resources.impl.IWorkspaceRootImpl
		 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getIWorkspaceRoot()
		 * @generated
		 */
		EClass IWORKSPACE_ROOT = eINSTANCE.getIWorkspaceRoot();

		/**
		 * The meta object literal for the '<em><b>Workspace</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IWORKSPACE_ROOT__WORKSPACE = eINSTANCE.getIWorkspaceRoot_Workspace();

		/**
		 * The meta object literal for the '<em><b>Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IWORKSPACE_ROOT__CONTAINERS = eINSTANCE.getIWorkspaceRoot_Containers();

		/**
		 * The meta object literal for the '<em><b>Full Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IWORKSPACE_ROOT__FULL_PATH = eINSTANCE.getIWorkspaceRoot_FullPath();

		/**
		 * The meta object literal for the '{@link corvus.domain.org.eclipse.core.resources.impl.IContainerImpl <em>IContainer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see corvus.domain.org.eclipse.core.resources.impl.IContainerImpl
		 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getIContainer()
		 * @generated
		 */
		EClass ICONTAINER = eINSTANCE.getIContainer();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ICONTAINER__ROOT = eINSTANCE.getIContainer_Root();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ICONTAINER__MEMBERS = eINSTANCE.getIContainer_Members();

		/**
		 * The meta object literal for the '{@link corvus.domain.org.eclipse.core.resources.impl.IResourceImpl <em>IResource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see corvus.domain.org.eclipse.core.resources.impl.IResourceImpl
		 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getIResource()
		 * @generated
		 */
		EClass IRESOURCE = eINSTANCE.getIResource();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IRESOURCE__PARENT = eINSTANCE.getIResource_Parent();

		/**
		 * The meta object literal for the '<em><b>Markers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IRESOURCE__MARKERS = eINSTANCE.getIResource_Markers();

		/**
		 * The meta object literal for the '<em><b>Relative Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IRESOURCE__RELATIVE_PATH = eINSTANCE.getIResource_RelativePath();

		/**
		 * The meta object literal for the '{@link corvus.domain.org.eclipse.core.resources.impl.IMarkerImpl <em>IMarker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see corvus.domain.org.eclipse.core.resources.impl.IMarkerImpl
		 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getIMarker()
		 * @generated
		 */
		EClass IMARKER = eINSTANCE.getIMarker();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMARKER__RESOURCE = eINSTANCE.getIMarker_Resource();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMARKER__ID = eINSTANCE.getIMarker_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMARKER__TYPE = eINSTANCE.getIMarker_Type();

		/**
		 * The meta object literal for the '{@link corvus.domain.org.eclipse.core.resources.impl.TextMarkerImpl <em>Text Marker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see corvus.domain.org.eclipse.core.resources.impl.TextMarkerImpl
		 * @see corvus.domain.org.eclipse.core.resources.impl.ResourcesPackageImpl#getTextMarker()
		 * @generated
		 */
		EClass TEXT_MARKER = eINSTANCE.getTextMarker();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_MARKER__LINE_NUMBER = eINSTANCE.getTextMarker_LineNumber();

		/**
		 * The meta object literal for the '<em><b>Char Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_MARKER__CHAR_START = eINSTANCE.getTextMarker_CharStart();

		/**
		 * The meta object literal for the '<em><b>Char End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_MARKER__CHAR_END = eINSTANCE.getTextMarker_CharEnd();

	}

} //ResourcesPackage
