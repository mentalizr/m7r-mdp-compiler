package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class Directive extends OutlineElement {

    public static final String PREFIX = "@@";

    public Directive() {
        super(PREFIX);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new DirectiveExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new DirectiveModelBuilder();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
//        DirectiveModel directiveModel = (DirectiveModel) this.outlineElementModel;
        return new DirectiveRenderer();
    }
}
