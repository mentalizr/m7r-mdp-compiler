package org.mentalizr.mdpCompiler.outlineElement.tagged.html;

import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.card.CardExtractionFactory;

public class HtmlExtractor extends TextBlockExtractor {

    public HtmlExtractor() {
        super(new HtmlExtractionFactory());
    }

}
