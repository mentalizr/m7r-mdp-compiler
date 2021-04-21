package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;

public class CardExtractor extends TextBlockExtractor {

    public CardExtractor() {
        super(new CardExtractionFactory());
    }

}
