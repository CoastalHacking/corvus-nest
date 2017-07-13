package corvus.domain.e4.workspace.link.ui;
 

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;

import corvus.domain.e4.workspace.link.LinkController;

public class EndHandler {

	@Inject
	private LinkController linkController;

	@Execute
	public void execute() {
		linkController.endLink();
	}

}