package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class DirectiveFactory extends OutlineElementFactory {

    public DirectiveFactory() {
        super(Directive.PREFIX);
    }

    @Override
    public OutlineElement getInstance() {
        return new Directive();
    }

    @Override
    public boolean isResponsible(Line line) {
        return super.isResponsible(line) && line.getLineIndex()==0;
    }

}
