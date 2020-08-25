package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockLinesExtractor;
import org.mentalizr.mdpCompiler.result.Result;

public abstract class FormGroup extends OutlineElementTagged {

    public FormGroup(String tagName, Result result, DocumentIterator documentIterator) throws MDPSyntaxError {
        super(tagName, result, documentIterator);
    }

    @Override
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new TextBlockLinesExtractor(this.documentIterator);
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new TextBlockModelBuilder(this.outlineElementLines);
    }

}
