package corvus.domain.e4.workspace.d2m;

import org.eclipse.emf.ecore.EObject;

import corvus.domain.org.eclipse.core.resources.util.ResourcesSwitch;

public class D2MSwitch extends ResourcesSwitch<Boolean>{

	protected EObject lastExistingObject;
	
	protected D2MSwitch(EObject lastExistingObject) {
		super();
		this.lastExistingObject = lastExistingObject;
	}

	public EObject getLastExistingObject() {
		return this.lastExistingObject;
	}

}
