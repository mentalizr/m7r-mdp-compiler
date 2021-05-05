package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;

import java.util.List;

public class CardExtractor extends TextBlockExtractor {

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new CardExtraction(lines);
    }

}
