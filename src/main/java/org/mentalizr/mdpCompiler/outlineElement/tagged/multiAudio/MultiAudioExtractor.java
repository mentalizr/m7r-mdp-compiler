package org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;

import java.util.List;

public class MultiAudioExtractor extends TextBlockExtractor {

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new MultiAudioExtraction(lines);
    }

}
