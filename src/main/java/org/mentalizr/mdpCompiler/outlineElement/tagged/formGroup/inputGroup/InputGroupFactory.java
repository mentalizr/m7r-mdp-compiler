package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class InputGroupFactory extends OutlineElementFactory {

    public InputGroupFactory() {
        super(InputGroup.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new InputGroup();
    }
}
