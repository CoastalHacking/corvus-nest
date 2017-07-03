package corvus.domain.e4.workspace.ui;

import com.google.inject.Injector;

import corvus.domain.e4.workspace.MarkerController;
import corvus.domain.e4.workspace.d2m.D2mInjectorProvider;

public abstract class AbstractHandler {

	protected Injector injector;

	protected MarkerController markerController;

	public AbstractHandler() {
		super();
		injector = D2mInjectorProvider.getInjector();
		markerController = injector.getInstance(MarkerController.class);
	}


}
