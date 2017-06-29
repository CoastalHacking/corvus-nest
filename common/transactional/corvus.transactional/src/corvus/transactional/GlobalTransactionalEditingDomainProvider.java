package corvus.transactional;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Singleton;


/**
 * Inspired by @link{GlobalAdapterFactoryEditingDomainProvider}
 */
public class GlobalTransactionalEditingDomainProvider extends TransactionalEditingDomainProvider {

	private static TransactionalEditingDomain singleton;
	
	@Override
	public TransactionalEditingDomain get() {
		if (singleton == null) {
			singleton = super.get();
		}
		return singleton;
	}

}
