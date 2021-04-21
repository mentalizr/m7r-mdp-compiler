package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroupExtractionFactory;

public class RadioGroupExtractor extends TextBlockExtractor {

    public RadioGroupExtractor() {
        super(new RadioGroupExtractionFactory());
    }

}
