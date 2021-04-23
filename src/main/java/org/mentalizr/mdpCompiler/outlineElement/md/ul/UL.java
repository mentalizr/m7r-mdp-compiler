package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class UL extends OutlineElement {

    public static final String PREFIX = "* ";

    public UL() {
        super(PREFIX);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new ULExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new ULModelBuilder();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new ULRenderer();
    }
}
