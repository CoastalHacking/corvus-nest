package corvus.domain.e4.workspace.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;

import corvus.domain.org.eclipse.core.resources.ResourcesInjectorProvider;
import corvus.domain.org.eclipse.core.resources.ResourcesPackage;
import corvus.domain.org.eclipse.core.resources.TextMarker;

public class EmfMarkerUtil {

	@Inject
	protected IWorkspace workspace;

	
	/**
	 * Given a model reference return its domain marker
	 * @param model a model reference
	 * @return the domain marker or null
	 */
	public IMarker getMarker(EObject model) {
		final Injector injector = ResourcesInjectorProvider.getInjector();

		final Resource resource = injector.getInstance(Resource.class);

		final Collection<Setting> settings = getSettings(resource, model);

		return getMarker(settings);
	}

	// TODO: test
	protected Collection<Setting> getSettings(Resource resource, EObject model) {
		return new EcoreUtil.UsageCrossReferencer(resource) {

			private static final long serialVersionUID = -6424907493871293248L;

			/* (non-Javadoc)
			 * @see org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer#crossReference(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EObject)
			 */
			@Override
			protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {

				return eReference == ResourcesPackage.Literals.TEXT_MARKER__DOMAIN 
						&& super.crossReference(eObject, eReference, crossReferencedEObject);
			}

			// Make public
			@Override
			public Collection<Setting> findUsage(EObject eObject) { return super.findUsage(eObject); }

		}.findUsage(model);
	}

	protected IMarker getMarker(Collection<Setting> settings) {
		IMarker marker = null;

		final Iterator<Setting> iter = settings.iterator();

		// Only grab the first one
		if (iter.hasNext()) {
			TextMarker textMarker = (TextMarker)iter.next().getEObject();
			marker = getMarker(textMarker);
		}

		// TODO: warn if there are additional markers
		// with the same domain reference as this model
		// domain references should be 1:1
		if (iter.hasNext()) {}

		return marker;
	}

	/*
	 * Given a marker, obtain the resource
	 */
	protected IMarker getMarker(TextMarker textMarker) {
		final IPath containerPath = constructContainerPath(textMarker);

		final IContainer container = getContainer(containerPath);

		return getMarker(container, textMarker);
	}
	
	protected IPath constructContainerPath(TextMarker textMarker) {
		// First get the workspace
		List<String> segments = getPathSegments(textMarker);

		// then return the generated IPath
		return buildFromSegments(segments);
	}

	/**
	 * 
	 * @param textMarker
	 * @return a list of segments that can construct an absolute path
	 */
	protected List<String> getPathSegments(TextMarker textMarker) {
		final List<String> results = new ArrayList<>();

		corvus.domain.org.eclipse.core.resources.IContainer container = textMarker.getResource().getParent();
		// The workspace root does not have a parent, stop there
		while (container != null) {
			results.add(0, container.getName());
			container = container.getParent();
		}
		return results;
	}

	protected IPath buildFromSegments(List<String> segments) {
		IPath result = null;
		// Then build up the path using IPath's
		for (String segment: segments) {
			if (result == null) {
				// First segment should be the path
				result = Path.fromPortableString(segment);
			} else {
				result.append(segment);
			}
		}
		return result;
	}

	protected IContainer getContainer(IPath path) {
		IContainer container = null;
		if (path != null) {
			container = workspace.getRoot().getContainerForLocation(path);
		}
		return container;
	}

	protected IMarker getMarker(IContainer container, TextMarker textMarker) {
		IMarker marker = null;
		IResource resource = container.findMember(textMarker.getResource().getName());
		try {
			marker = resource.findMarker(textMarker.getId());
		} catch (CoreException e) {
			// TODO log warning?
			e.printStackTrace();
		}
		return marker;
	}
}
