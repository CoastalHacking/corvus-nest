package corvus.transactional;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.parsley.edit.EditingDomainFinder;
import org.eclipse.emf.parsley.resource.ResourceLoader;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

// TODO: Test me!
public class TransactionalResourceLoader extends ResourceLoader {

	@Inject
	EditingDomainFinder finder;

	@Override
	protected void initializeEmptyResource(Resource resource) {

		if (resource != null && resource.getContents().isEmpty()) {

			// Obtain the editing domain from the resource instead of injecting it,
			// just in case the resource isn't using this injector's editing domain
			EditingDomain editingDomain = finder.getEditingDomainFor(resource);

			if (editingDomain != null) {

				if (editingDomain instanceof TransactionalEditingDomain) {
					TransactionalEditingDomain ted = (TransactionalEditingDomain)editingDomain;
					ted.getCommandStack().execute(new RecordingCommand(ted) {
						@Override
						protected void doExecute() {
							getResourceManager().initialize(resource);
						}
					});

				} else {
					getResourceManager().initialize(resource);
				}
			}
		}
	}

}
