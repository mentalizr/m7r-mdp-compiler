package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class DirectiveFactory extends OutlineElementFactory {

    public DirectiveFactory() {
        super(Directive.PREFIX);
    }

    @Override
    public OutlineElement getInstance(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        return new Directive(documentIterator, result);
    }

    @Override
    public boolean isResponsible(Line line) {
        return super.isResponsible(line) && line.getLineIndex()==0;
    }

}
