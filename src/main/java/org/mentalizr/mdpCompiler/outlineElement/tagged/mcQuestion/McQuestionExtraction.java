package org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;

import java.util.List;

public class McQuestionExtraction extends Extraction {

    public McQuestionExtraction(List<Line> lines) {
        super(lines);
    }

    public McQuestionExtraction(Document document) {
        super(document);
    }
}
