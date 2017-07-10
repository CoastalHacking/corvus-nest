package corvus.domain.e4.workspace.m2v.entrypoint;

import org.eclipse.emf.transaction.NotificationFilter;

import com.google.inject.Singleton;

import corvus.model.entrypoint.EntrypointPackage;
import corvus.resource.DefaultNotificationFilterProvider;

@Singleton
public class EntryPointM2VNotificationFilterProvider extends DefaultNotificationFilterProvider {

	private NotificationFilter filter;

	/* (non-Javadoc)
	 * @see corvus.resource.DefaultNotificationFilterProvider#get()
	 */
	@Override
	public NotificationFilter get() {
		// Filter on notifications pertaining to the list of entry points on the framework
		if (filter == null) {
			filter = NotificationFilter.createFeatureFilter(EntrypointPackage.eINSTANCE.getEntryPointFramework_EntryPoints());
		}
		return filter;
	}

}
