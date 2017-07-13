package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;

import corvus.model.link.LinkContainer;
import corvus.transactional.IRecordingCommand;

public class EndLinkCommand implements IRecordingCommand {

	@Inject
	private Resource resource;

	public void doExecute() {
		// Hack: assumes 0 index root object
		LinkContainer container = (LinkContainer)resource.getContents().get(0);
		container.getState().setLastAdded(null);
	}

}
