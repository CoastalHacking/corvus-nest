package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;

import corvus.model.link.Direction;
import corvus.model.link.LinkContainer;
import corvus.transactional.IRecordingCommand;

public class DirectionCommand implements IRecordingCommand {

	@Inject
	private Resource resource;

	private boolean incoming;

	public DirectionCommand(boolean incoming) {
		this.incoming = incoming;
	}

	@Override
	public void doExecute() {
		LinkContainer container = (LinkContainer)resource.getContents().get(0);
		if (incoming) {
			container.getState().setDirection(Direction.FROM);
		} else {
			container.getState().setDirection(Direction.TO);
		}

	}

}
