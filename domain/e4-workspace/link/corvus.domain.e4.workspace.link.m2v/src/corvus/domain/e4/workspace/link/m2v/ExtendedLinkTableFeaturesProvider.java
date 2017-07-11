package corvus.domain.e4.workspace.link.m2v;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.parsley.ui.provider.EClassToEStructuralFeatureAsStringsMap;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.inject.Inject;

import corvus.domain.e4.workspace.link.ui.provider.LinkTableFeaturesProvider;
import corvus.model.link.Link;
import corvus.model.link.LinkContainer;
import corvus.model.link.LinkPackage;
import corvus.model.link.State;

/*
 * Shenanigans afoot
 * 
 * We peak at the resource to figure out the state and then return a map
 * Because of this, we create the map each time
 *
 */
public class ExtendedLinkTableFeaturesProvider extends LinkTableFeaturesProvider {

	@Inject
	protected Resource resource;

	@Inject
	protected TransactionalEditingDomain domain;

	/* (non-Javadoc)
	 * @see corvus.domain.e4.workspace.link.ui.provider.LinkTableFeaturesProvider#buildStringMap(org.eclipse.emf.parsley.ui.provider.EClassToEStructuralFeatureAsStringsMap)
	 */
	@Override
	public void buildStringMap(EClassToEStructuralFeatureAsStringsMap stringMap) {
		super.buildStringMap(stringMap);

		final String key = Link.class.getName();

		List<String> values = stringMap.get(key);

		final State state = getState();

		final String toOrFrom = getToOrFrom(state);

		if (values == null) {
			values = new ArrayList<>();
			values.add(LinkPackage.eINSTANCE.getLink_Name().getName());
			stringMap.put(key, values);
		}

		values.add(toOrFrom);
	}

	protected String getToOrFrom(State state) {
		final String result;
		switch (state.getDirection()) {
		case FROM:
			result = LinkPackage.eINSTANCE.getLink_From().getName();
			break;
		case TO:
			result = LinkPackage.eINSTANCE.getLink_To().getName();
			break;
		default:
			throw new RuntimeException("Invalid direction: " + state.getDirection());
		}
		return result;
	}

	protected State getState() {
		try {
			return (State)domain.runExclusive(new RunnableWithResult.Impl<State>() {

				@Override
				public void run() {
					
					// Hack: explicitly grabbing root object
					LinkContainer container = (LinkContainer)resource.getContents().get(0);
					setResult(container.getState());
				}
			});

		} catch (InterruptedException e) {

			throw new RuntimeException(e);
		}
	}

}
