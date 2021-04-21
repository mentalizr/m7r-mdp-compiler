package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends OutlineElement {

//    private final List<String> lines;

    public Paragraph() {
        super("");
//        this.lines = new ArrayList<>();
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new ParagraphExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new ParagraphModelBuilder();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        ParagraphModel paragraphModel = (ParagraphModel) this.outlineElementModel;
        return new ParagraphRenderer(paragraphModel);
    }

}
