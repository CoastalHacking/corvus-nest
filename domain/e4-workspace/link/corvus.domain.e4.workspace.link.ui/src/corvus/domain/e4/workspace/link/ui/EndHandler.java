package corvus.domain.e4.workspace.link.ui;
 

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;

import corvus.domain.e4.workspace.ui.UIConstants;

public class EndHandler {

	@Execute
	public void execute(@Named(UIConstants.COMMAND_PARAM) String markerType) {

	}

}