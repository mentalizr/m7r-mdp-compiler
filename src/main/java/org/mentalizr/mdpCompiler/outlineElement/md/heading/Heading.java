package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;

public abstract class Heading extends OutlineElement {

    public Heading(String prefix) {
        super(prefix);
    }

    private int getHeadingLevel() {
        return this.prefix.length() - 1;
    }

    @Override
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new HeadingLinesExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new HeadingModelBuilder(this.outlineElementLines, getHeadingLevel());
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        HeadingModel headingModel = (HeadingModel) this.outlineElementModel;
        return new HeadingRenderer(headingModel, getHeadingLevel());
    }

}
