package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyExtractor;

import java.util.List;

public class ImgFluidExtractor extends MDPTagOnlyExtractor {

    @Override
    protected Extraction createExtraction(List<Line> lines) {
        return new ImgFluidExtraction(lines);
    }

}
