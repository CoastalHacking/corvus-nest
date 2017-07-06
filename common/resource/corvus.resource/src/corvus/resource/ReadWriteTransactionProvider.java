package corvus.resource;

import com.google.inject.Provider;

public class ReadWriteTransactionProvider implements Provider<ReadWriteTransaction> {

	// TODO: inject
	private String name = "Corvus injected read write job transaction";

	@Override
	public ReadWriteTransaction get() {
		return new InjectableReadWriteTransactionJob(name);
	}

}
