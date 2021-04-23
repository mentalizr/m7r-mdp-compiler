package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModelBuilder;

public abstract class FormGroup extends OutlineElementTagged {

    public FormGroup(String tagName) {
        super(tagName);
    }

    @Override
    protected OutlineElementTaggedModelBuilder getOutlineElementModelBuilder() {
        return new TextBlockModelBuilder(this);
    }

}
