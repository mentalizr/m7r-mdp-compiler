package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.card.CardExtractionFactory;

public class InputGroupExtractor extends TextBlockExtractor {

    public InputGroupExtractor() {
        super(new InputGroupExtractionFactory());
    }

}
