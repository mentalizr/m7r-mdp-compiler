package org.mentalizr.mdpCompiler.outlineElement.tagged.html;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class HtmlFactory extends OutlineElementFactory {

    public HtmlFactory() {
        super(Html.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new Html();
    }
}
