package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class ParagraphFactory extends OutlineElementFactory {

    public ParagraphFactory() {
        super("");
    }

    @Override
    public OutlineElement getInstance() {
        return new Paragraph();
    }

    @Override
    public boolean isResponsible(Line line) {
        return true;
    }
}
