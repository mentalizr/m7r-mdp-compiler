package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;

public abstract class FormGroup extends OutlineElementTagged {

    public FormGroup(String tagName, Line tagLine) throws MDPSyntaxError {
        super(tagName, tagLine);
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new TextBlockModelBuilder();
    }

}
