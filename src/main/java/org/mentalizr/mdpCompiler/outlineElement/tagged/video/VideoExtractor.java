package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyExtractor;

import java.util.List;

public class VideoExtractor extends MDPTagOnlyExtractor {

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new VideoExtraction(lines);
    }

}
