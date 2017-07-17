/**
 * Copyright (c) 2002-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   Jon Passki - Using code from AdapterFactoryImpl.adapt in this class's adapt
 */
package corvus.domain.e4.workspace.link.m2v;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import corvus.model.link.provider.LinkItemProviderAdapterFactory;

public abstract class AbstractScopedLinkItemProviderAdapterFactory
	extends LinkItemProviderAdapterFactory {

	protected Class<?> clazz;
	protected EClass eClass;

	public AbstractScopedLinkItemProviderAdapterFactory(Class<?> clazz, EClass eClass) {
		super();
		this.clazz = clazz;
		this.eClass = eClass;
	}

	/* (non-Javadoc)
	 * @see corvus.model.link.provider.LinkItemProviderAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		boolean result = false;
		if (type != null) {
			// is this a class or interface type?
			result = clazz.equals(type);
			if (!result && type instanceof EObject) {
				result = ((EObject)type).eClass().equals(eClass);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see corvus.model.link.provider.LinkItemProviderAdapterFactory#adapt(org.eclipse.emf.common.notify.Notifier, java.lang.Object)
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		// copyrighted code below
		for (Adapter adapter : notifier.eAdapters())
		{
			if (adapter.isAdapterForType(type))
			{
				return adapter;
			}
		}
		return adaptNew(notifier, type);
	}

}
