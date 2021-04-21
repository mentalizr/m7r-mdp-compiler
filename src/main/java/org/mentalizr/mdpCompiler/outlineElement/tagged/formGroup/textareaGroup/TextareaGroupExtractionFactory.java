package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.ExtractionFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup.RadioGroupExtraction;

import java.util.List;

public class TextareaGroupExtractionFactory extends ExtractionFactory {

    @Override
    public Extraction createInstance(List<Line> lines) {
        return new TextareaGroupExtraction(lines);
    }

}
