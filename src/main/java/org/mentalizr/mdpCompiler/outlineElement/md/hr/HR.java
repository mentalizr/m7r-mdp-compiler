package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.result.Result;

public class HR extends OutlineElement {

    public static final String PREFIX = "---";

    public HR(DocumentIterator documentIterator, Result result) {
        super(PREFIX, documentIterator, result);
    }

    @Override
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new HRLinesExtractor(this.documentIterator);
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new HRModelBuilder(this.outlineElementLines);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new HRRenderer(this.result);
    }

}
