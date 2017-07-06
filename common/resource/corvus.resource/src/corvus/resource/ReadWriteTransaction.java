package corvus.resource;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

/**
 * A read/write EMF transaction cannot occur in a read-only transaction.
 * Implementations need to commit the transaction outside of the current
 * read-only thread
 *
 */
public interface ReadWriteTransaction {

	public void commit();

	public void setNotifications(List<Notification> notifications);
}
