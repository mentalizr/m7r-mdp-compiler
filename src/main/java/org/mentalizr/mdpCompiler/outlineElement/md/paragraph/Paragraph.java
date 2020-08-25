package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.result.Result;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends OutlineElement {

    private final List<String> lines;

    public Paragraph(DocumentIterator documentIterator, Result result) {
        super("", documentIterator, result);
        this.lines = new ArrayList<>();
    }

    @Override
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new ParagraphLinesExtractor(this.documentIterator);
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new ParagraphModelBuilder(this.outlineElementLines);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        ParagraphModel paragraphModel = (ParagraphModel) this.outlineElementModel;
        return new ParagraphRenderer(this.result, paragraphModel);
    }

}
