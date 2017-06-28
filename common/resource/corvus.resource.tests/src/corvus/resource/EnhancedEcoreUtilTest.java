package corvus.resource;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.junit.Test;

public class EnhancedEcoreUtilTest {

	@Test
	public void shouldHaveAdapter() {
		EObject eObject = ModelUtil.createObject("Test");
		Adapter expected = new AdapterImpl() {
			@Override public boolean isAdapterForType(Object type) { return true; }
		};

		Resource resource = new ResourceImpl();
		resource.eAdapters().add(expected);
		resource.getContents().add(eObject);

		Adapter actual = EnhancedEcoreUtil.getRegisteredAdapter(eObject, getClass());
		assertEquals(expected, actual);
	}

}
