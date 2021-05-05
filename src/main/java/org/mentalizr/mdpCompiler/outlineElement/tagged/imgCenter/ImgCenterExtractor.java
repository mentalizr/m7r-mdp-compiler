package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyExtractor;

import java.util.List;

public class ImgCenterExtractor extends MDPTagOnlyExtractor {

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new ImgCenterExtraction(lines);
    }

}
