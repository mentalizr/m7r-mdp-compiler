package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

public class HR extends OutlineElement {

    public static final String PREFIX = "---";

    public HR() {
        super(PREFIX);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new HRExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new HRModelBuilder();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new HRRenderer();
    }

}
