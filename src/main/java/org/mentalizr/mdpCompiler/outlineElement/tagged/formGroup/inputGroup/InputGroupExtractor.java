package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;

import java.util.List;

public class InputGroupExtractor extends TextBlockExtractor {

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new InputGroupExtraction(lines);
    }

}
