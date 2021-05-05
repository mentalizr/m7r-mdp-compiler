package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public abstract class Heading extends OutlineElement {

    public Heading(String prefix) {
        super(prefix);
    }

    public int getHeadingLevel() {
        return this.prefix.length() - 1;
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new HeadingExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new HeadingModelBuilder(this);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new HeadingRenderer();
    }

}
