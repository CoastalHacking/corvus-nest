package corvus.resource;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

/**
 * 
 * Assumes resources within the resource set have been demand loaded
 * 
 *
 */
public abstract class ModelToModelCommandFragmentImpl implements ModelToModelCommandFragment {

	protected Map<?, ?> options;

	public ModelToModelCommandFragmentImpl() {
		this.options = Collections.EMPTY_MAP;
	}
	
	public ModelToModelCommandFragmentImpl(Map<?, ?> options) {
		this.options = options;
	}

	/* (non-Javadoc)
	 * @see corvus.resource.ModelToModelCommandFragment#doExecute(java.util.List)
	 */
	@Override
	public void doExecute(List<Notification> notifications) {
		for (Notification notification: notifications) {
			switch (notification.getEventType()) {
			case Notification.ADD:
				added(notification);
				break;
			default:
				break;
			}
		}
		
	}

	/**
	 * Called when an ADD notification is sent
	 * 
	 * @param notification A notification
	 */
	protected void added(Notification notification) {
	}

	/* (non-Javadoc)
	 * @see org.example.resourcesetlistener.ModelToModelCommandFragment#getOptions()
	 */
	@Override
	public Map<?, ?> getOptions() {
		return options;
	}

}
