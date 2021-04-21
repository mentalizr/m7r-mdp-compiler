package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.ExtractionFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter.ImgCenterExtraction;

import java.util.List;

public class ImgFluidExtractionFactory extends ExtractionFactory {

    @Override
    public Extraction createInstance(List<Line> lines) {
        return new ImgFluidExtraction(lines);
    }

}
