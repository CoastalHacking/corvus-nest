package corvus.resource;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;

public class ReadWriteTransactionProvider implements Provider<ReadWriteTransaction> {

	@Inject
	protected MembersInjector<InjectableReadWriteTransactionJob> jobMembersInjector;

	// TODO: inject
	private String name = "Corvus injected read write job transaction";

	@Override
	public ReadWriteTransaction get() {
		InjectableReadWriteTransactionJob job = new InjectableReadWriteTransactionJob(name);
		jobMembersInjector.injectMembers(job);
		return job;
	}

}
