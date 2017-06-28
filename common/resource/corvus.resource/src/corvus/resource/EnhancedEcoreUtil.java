/**
 * Copyright (c) 2002-2012 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Jon Passki - Override getRegisteredAdapter to also check the resource
 */
package corvus.resource;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class EnhancedEcoreUtil extends EcoreUtil {

	public EnhancedEcoreUtil() {
		super();
	}

	public static Adapter getRegisteredAdapter(EObject eObject, Object type) {
		Adapter result = getExistingAdapter(eObject, type);

		if (result == null) {
			Resource resource = eObject.eResource();

			if (resource != null) {
				result = getExistingAdapter(resource, type);

				if (result == null) {
					ResourceSet resourceSet = resource.getResourceSet();
	
					if (resourceSet != null) {
						AdapterFactory factory = getAdapterFactory(resourceSet.getAdapterFactories(), type);
	
						if (factory != null) {
							result = factory.adaptNew(eObject, type);
						}
					}
				}
			}
		}
		return result;
	}
}
