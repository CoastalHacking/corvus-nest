package corvus.resource;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

public class ReadWriteTransactionFactory {

	@Inject
	protected MembersInjector<InjectableReadWriteTransactionJob> jobMembersInjector;

	/**
	 * Create a read-write transaction utilizing the provided notifications consumer
	 * 
	 * @param consumer a notifications consumer
	 * @return a read-write transaction
	 */
	public ReadWriteTransaction create(NotificationsConsumer consumer) {
		InjectableReadWriteTransactionJob job = new InjectableReadWriteTransactionJob(consumer);
		jobMembersInjector.injectMembers(job);
		return job;
	}

}
