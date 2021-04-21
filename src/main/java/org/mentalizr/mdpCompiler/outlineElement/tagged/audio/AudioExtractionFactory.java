package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.ExtractionFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertExtraction;

import java.util.List;

public class AudioExtractionFactory extends ExtractionFactory {

    @Override
    public Extraction createInstance(List<Line> lines) {
        return new AudioExtraction(lines);
    }

}
