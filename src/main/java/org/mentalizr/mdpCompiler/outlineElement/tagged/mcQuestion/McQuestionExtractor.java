package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;

public class McQuestionExtractor extends TextBlockExtractor {

    public McQuestionExtractor() {
        super(new McQuestionExtractionFactory());
    }

}
