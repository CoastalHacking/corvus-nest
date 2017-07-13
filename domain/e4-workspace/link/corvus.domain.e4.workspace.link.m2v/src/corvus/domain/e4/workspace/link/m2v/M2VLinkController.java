package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

import corvus.domain.e4.workspace.link.LinkController;
import corvus.model.link.Direction;
import corvus.model.link.LinkContainer;
import corvus.transactional.TransactionalUtil;

public class M2VLinkController implements LinkController {

	@Inject
	private TransactionalUtil utils;

	@Inject
	private TransactionalEditingDomain ted;

	@Inject
	private Resource resource;


	@Override
	public void endLink() {
		// TODO Auto-generated method stub
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
		try {
			utils.performTransaction(new RecordingCommand(ted) {

				@Override
				protected void doExecute() {

					// Hack: assumes 0 index root object
					LinkContainer container = (LinkContainer)resource.getContents().get(0);
					if (incoming) {
						container.getState().setDirection(Direction.FROM);
					} else {
						container.getState().setDirection(Direction.TO);
					}
				}
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
