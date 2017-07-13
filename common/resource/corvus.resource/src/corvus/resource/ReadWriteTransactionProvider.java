package corvus.resource;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ReadWriteTransactionProvider implements Provider<ReadWriteTransaction> {

	@Inject
	private ReadWriteTransactionFactory transactionFactory;

	/**
	 *  Use the consumer specified by the module, usually in the DSL
	 */
	@Inject
	private NotificationsConsumer consumer;

	@Override
	public ReadWriteTransaction get() {
		return transactionFactory.create(consumer);
	}

}
