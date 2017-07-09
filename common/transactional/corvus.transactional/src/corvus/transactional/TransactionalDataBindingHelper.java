/*******************************************************************************
 * Copyright (c) 2016 RCP Vision (http://www.rcp-vision.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Francesco Guidieri - initial API and implementation
 * Jon Passki - transactional support
 *******************************************************************************/
package corvus.transactional;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.parsley.internal.databinding.DataBindingHelper;
import org.eclipse.emf.parsley.internal.databinding.DatabindingValidationUtil;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.swt.SWT;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

@SuppressWarnings("restriction")
public class TransactionalDataBindingHelper extends DataBindingHelper {

	@Inject
	// needs to be passed into the ctor of the strategy
	private DatabindingValidationUtil databindingValidationUtil;

	@Inject
	private MembersInjector<TransactionalEmfValidationTargetToModelUpdateValueStrategy> strategyInjector;
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.parsley.internal.databinding.DataBindingHelper#bindValue(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.core.databinding.observable.value.IObservableValue, org.eclipse.core.databinding.observable.value.IObservableValue, org.eclipse.emf.ecore.EObject, org.eclipse.core.databinding.DataBindingContext)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Binding bindValue(EStructuralFeature feature, IObservableValue target, IObservableValue source,
			EObject owner, DataBindingContext dataBindingContext) {

		TransactionalEmfValidationTargetToModelUpdateValueStrategy strategy =
				new TransactionalEmfValidationTargetToModelUpdateValueStrategy(
						owner, feature, databindingValidationUtil);

		strategyInjector.injectMembers(strategy);

		Binding bindValue = dataBindingContext.bindValue(target, source, strategy, null);
		ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.LEFT);
		return bindValue;
	}



}
