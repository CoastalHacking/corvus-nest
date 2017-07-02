/**
 */
package corvus.domain.org.eclipse.core.resources.impl;

import corvus.domain.org.eclipse.core.resources.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourcesFactoryImpl extends EFactoryImpl implements ResourcesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourcesFactory init() {
		try {
			ResourcesFactory theResourcesFactory = (ResourcesFactory)EPackage.Registry.INSTANCE.getEFactory(ResourcesPackage.eNS_URI);
			if (theResourcesFactory != null) {
				return theResourcesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResourcesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ResourcesPackage.IWORKSPACE_ROOT: return createIWorkspaceRoot();
			case ResourcesPackage.ICONTAINER: return createIContainer();
			case ResourcesPackage.IRESOURCE: return createIResource();
			case ResourcesPackage.IMARKER: return createIMarker();
			case ResourcesPackage.TEXT_MARKER: return createTextMarker();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IWorkspaceRoot createIWorkspaceRoot() {
		IWorkspaceRootImpl iWorkspaceRoot = new IWorkspaceRootImpl();
		return iWorkspaceRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IContainer createIContainer() {
		IContainerImpl iContainer = new IContainerImpl();
		return iContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IResource createIResource() {
		IResourceImpl iResource = new IResourceImpl();
		return iResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMarker createIMarker() {
		IMarkerImpl iMarker = new IMarkerImpl();
		return iMarker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextMarker createTextMarker() {
		TextMarkerImpl textMarker = new TextMarkerImpl();
		return textMarker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcesPackage getResourcesPackage() {
		return (ResourcesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResourcesPackage getPackage() {
		return ResourcesPackage.eINSTANCE;
	}

} //ResourcesFactoryImpl
