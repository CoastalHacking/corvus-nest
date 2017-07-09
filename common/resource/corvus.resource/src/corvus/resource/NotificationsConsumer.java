package corvus.resource;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.parsley.resource.ResourceManager;

import com.google.inject.Inject;

public class NotificationsConsumer {

	@Inject
	protected Resource resource;

	@Inject
	protected ResourceManager resourceManager;

	public void consume(List<Notification> notifications) {

	}
	
	protected void save() {
		try {
			resourceManager.save(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
