package corvus.domain.e4.workspace.link.m2v;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

import corvus.domain.e4.workspace.link.LinkController;
import corvus.transactional.TransactionalUtil;

public class M2VLinkController implements LinkController {

	@Inject
	private TransactionalUtil utils;

	@Inject
	private MembersInjector<EndLinkCommand> endLinkInjector;

	@Inject
	private MembersInjector<DirectionCommand> directionInjector;

	@Override
	public void endLink() {
		final EndLinkCommand command = new EndLinkCommand();
		endLinkInjector.injectMembers(command);
		utils.executeRecordingCommand(command);
	}

	@Override
	public void prepareIncoming() {
		prepare(true);
	}

	@Override
	public void prepareOutgoing() {
		prepare(false);
	}

	/*
	 * Update the link container direction state
	 */
	protected void prepare(boolean incoming) {
		
		DirectionCommand command = new DirectionCommand(incoming);
		directionInjector.injectMembers(command);
		utils.executeRecordingCommand(command);
	}

}
