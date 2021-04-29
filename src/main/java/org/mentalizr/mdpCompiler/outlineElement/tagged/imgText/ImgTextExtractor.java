package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;

import java.util.List;

public class ImgTextExtractor extends TextBlockExtractor {

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new ImgTextExtraction(lines);
    }

}
