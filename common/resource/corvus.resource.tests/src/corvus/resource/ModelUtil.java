package corvus.resource;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ModelUtil {

	public static EObject createObject(String className) {
		EcoreFactory eCoreFactory = EcoreFactory.eINSTANCE;

		EClass eClass = eCoreFactory.createEClass();
		eClass.setName(className);

		EPackage ePackage = eCoreFactory.createEPackage();
		ePackage.getEClassifiers().add(eClass);

		return EcoreUtil.create(eClass);

	}

}
