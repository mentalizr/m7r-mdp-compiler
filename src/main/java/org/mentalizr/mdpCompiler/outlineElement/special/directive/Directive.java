package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.result.Result;

public class Directive extends OutlineElement {

    public static final String PREFIX = "@@";

    public Directive(DocumentIterator documentIterator, Result result) {
        super(PREFIX, documentIterator, result);
    }

    @Override
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new DirectiveLinesExtractor(this.documentIterator);
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new DirectiveModelBuilder(this.outlineElementLines);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        DirectiveModel directiveModel = (DirectiveModel) this.outlineElementModel;
        return new DirectiveRenderer(this.result, directiveModel);
    }
}
