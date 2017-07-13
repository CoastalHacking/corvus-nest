/*******************************************************************************
 * Copyright (c) 2013 RCP Vision (http://www.rcp-vision.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Lorenzo Bettini - initial API and implementation
 * Jon Passki - Used TreeFormFactory as a basis for this class
 *******************************************************************************/
package corvus.domain.e4.workspace;

import java.util.List;

import org.eclipse.emf.parsley.EmfParsleyConstants;
import org.eclipse.emf.parsley.util.EmfParsleyUtil;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.name.Named;


public class TreeColumnFactory {
	
	@Inject
	protected MembersInjector<TreeColumnComposite> treeColumnInjector;

	// TODO update?
	@Inject
	@Named(EmfParsleyConstants.TREE_FORM_SASH_STYLE)
	private int sashStyle;

	// TODO update
	@Inject
	@Named(EmfParsleyConstants.TREE_FORM_SASH_WEIGHTS)
	private List<Integer> weights;

	public TreeColumnComposite createTreeColumnComposite(Composite parent, int style) {
		TreeColumnComposite treeColumnComposite = createComposite(parent, style);
		treeColumnInjector.injectMembers(treeColumnComposite);
		return treeColumnComposite;
	}

	protected TreeColumnComposite createComposite(Composite parent, int style) {
		return new TreeColumnComposite(parent, style, sashStyle, EmfParsleyUtil.toIntArray(weights));
	}

}
