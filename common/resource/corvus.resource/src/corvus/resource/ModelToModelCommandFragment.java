package corvus.resource;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.Transaction;

public interface ModelToModelCommandFragment {
	
	/**
	 * A method used to create the destination model, executed within a
	 * recording command on a transactional editing domain stack
	 * 
	 * @param event  the resource set change event, filtered by the source
	 * model of interest
	 */
	public void doExecute(List<Notification> notifications);

	/**
	 * A map of options, based on {@link Transaction} OPTION_* fields
	 * 
	 * @return a map of options used for the transaction
	 */
	public Map<?, ?> getOptions();
}
