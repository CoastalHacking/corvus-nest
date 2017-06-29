package corvus.transactional;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Singleton;


/**
 * Inspired by @link{SingletonAdapterFactoryEditingDomainProvider}
 */
@Singleton
// TODO: Test me!
public class SingletonTransactionalEditingDomainProvider extends TransactionalEditingDomainProvider {

	private TransactionalEditingDomain singleton;
	
	@Override
	public TransactionalEditingDomain get() {
		if (singleton == null) {
			singleton = super.get();
		}
		return singleton;
	}

}
