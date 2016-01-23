/**
 * Copyright (c) 2015 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.ui.render;

import org.mini2Dx.ui.element.Column;
import org.mini2Dx.ui.element.Visibility;
import org.mini2Dx.ui.layout.LayoutState;
import org.mini2Dx.ui.style.StyleRule;

/**
 *
 */
public abstract class AbstractColumnRenderNode<S extends StyleRule> extends ParentRenderNode<Column, S> {

	public AbstractColumnRenderNode(ParentRenderNode<?, ?> parent, Column column) {
		super(parent, column);
	}

	@Override
	protected float determinePreferredHeight(LayoutState layoutState) {
		if(preferredWidth <= 0f) {
			return 0f;
		}
		float maxHeight = 0f;

		for (int i = 0; i < children.size(); i++) {
			float height = children.get(i).getRelativeY() + children.get(i).getPreferredHeight()
					+ children.get(i).getYOffset();
			if (height > maxHeight) {
				maxHeight = height;
			}
		}
		return maxHeight + style.getMarginTop() + style.getMarginBottom() + style.getPaddingTop()
				+ style.getPaddingBottom();
	}

	@Override
	protected float determinePreferredWidth(LayoutState layoutState) {
		float layoutRuleResult = element.getLayout().getPreferredWidth(layoutState);
		if(layoutRuleResult <= 0f) {
			element.setVisibility(Visibility.HIDDEN);
			return 0f;
		} else if(layoutState.isScreenSizeChanged() && element.getVisibility() == Visibility.HIDDEN) {
			element.setVisibility(Visibility.VISIBLE);
		}
		return style.getMarginLeft() + layoutRuleResult + style.getMarginRight();
	}

	@Override
	protected float determineXOffset(LayoutState layoutState) {
		return element.getLayout().getXOffset(layoutState);
	}

	@Override
	protected float determineYOffset(LayoutState layoutState) {
		return 0f;
	}
}