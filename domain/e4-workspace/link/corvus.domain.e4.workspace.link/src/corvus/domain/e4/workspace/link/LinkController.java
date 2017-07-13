package corvus.domain.e4.workspace.link;

public interface LinkController {

	public void endLink();

	/**
	 * Prepare the generated view for incoming (from) links.
	 * 
	 * Clients need to call this prior to generating a tree view
	 */
	public void prepareIncoming();

	/**
	 * Prepare the generated view for outgoing (to) links.
	 * 
	 * Clients need to call this prior to generating a tree view
	 */
	public void prepareOutgoing();
}
