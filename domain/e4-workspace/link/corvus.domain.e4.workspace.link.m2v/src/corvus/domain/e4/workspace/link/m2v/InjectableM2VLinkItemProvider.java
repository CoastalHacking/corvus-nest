package corvus.domain.e4.workspace.link.m2v;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ViewerNotification;

import corvus.model.link.Direction;
import corvus.model.link.Link;
import corvus.model.link.LinkPackage;
import corvus.model.link.provider.LinkItemProvider;

public class InjectableM2VLinkItemProvider extends LinkItemProvider
	implements StructuredItemContentAdapter {

	// TODO: test
	/* (non-Javadoc)
	 * @see corvus.model.link.provider.LinkItemProvider#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		// default to super first
		super.notifyChanged(notification);

		if (getTarget() instanceof Link) {
			final Direction direction = ((Link)getTarget()).getLinkContainer().getState().getDirection();
			switch (notification.getFeatureID(Link.class)) {
			case LinkPackage.LINK__TO:
				if (direction.equals(Direction.TO)) {
					fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
					return;
				}
			case LinkPackage.LINK__FROM:
				if (direction.equals(Direction.FROM)) {
					fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
					return;
				}
			}

		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getChildrenFeatures(java.lang.Object)
	 */
	@Override
	// made public accessor for testing
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		// rebuild childrenFeatures each time
		childrenFeatures = new ArrayList<EStructuralFeature>();
		if (object instanceof Link) {
			Link link = (Link)object;

			switch (link.getLinkContainer().getState().getDirection()) {
			case FROM:
				childrenFeatures.add(LinkPackage.Literals.LINK__FROM);
				break;
			case TO:
				childrenFeatures.add(LinkPackage.Literals.LINK__TO);
				break;
			}
		}
		return childrenFeatures;

	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#isWrappingNeeded(java.lang.Object)
	 */
	@Override
	protected boolean isWrappingNeeded(Object object) {
		return true;
	}

	public InjectableM2VLinkItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);

	}

}
