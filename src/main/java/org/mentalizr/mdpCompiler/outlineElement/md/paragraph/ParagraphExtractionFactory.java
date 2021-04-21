package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.ExtractionFactory;

import java.util.List;

public class ParagraphExtractionFactory extends ExtractionFactory {

    @Override
    public Extraction createInstance(List<Line> lines) {
        return new ParagraphExtraction(lines);
    }

}
