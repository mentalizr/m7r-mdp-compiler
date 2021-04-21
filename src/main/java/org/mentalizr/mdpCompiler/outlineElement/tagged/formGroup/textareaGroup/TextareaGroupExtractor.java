package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup.RadioGroupExtractionFactory;

public class TextareaGroupExtractor extends TextBlockExtractor {

    public TextareaGroupExtractor() {
        super(new TextareaGroupExtractionFactory());
    }

}
