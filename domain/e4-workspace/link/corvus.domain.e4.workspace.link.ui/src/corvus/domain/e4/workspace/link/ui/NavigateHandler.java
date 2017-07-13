 
package corvus.domain.e4.workspace.link.ui;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Execute;

import corvus.domain.e4.workspace.link.LinkController;
import corvus.domain.e4.workspace.ui.UIConstants;

@SuppressWarnings("restriction") // ECommandService, EHandlerService
public class NavigateHandler {

	@Inject
	private LinkController linkController;

	@Execute
	public void execute(ECommandService commandService,
			EHandlerService handlerService,
			@Named(UIConstants.COMMAND_PARAM) String markerType,
			@Named(LinkConstants.NAVIGATION_PARAM) String navigation) {

		// First, prep link controller
		if (LinkConstants.NAVIGATE_INCOMING.equals(navigation)) {
			linkController.prepareIncoming();
		} else if (LinkConstants.NAVIGATE_OUTGOING.equals(navigation)) {
			linkController.prepareOutgoing();
		} else {
			// TODO: log warning
			return;
		}

		// Then execute the standard view tree handler
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(UIConstants.COMMAND_PARAM, markerType);
		final ParameterizedCommand viewCommand = commandService.createCommand(UIConstants.VIEW_TREE_COMMAND_ID, parameters);
		// command service impl can return null && handler service impl doesn't check
		if (viewCommand != null) {
			handlerService.executeHandler(viewCommand);
		}
	}

}