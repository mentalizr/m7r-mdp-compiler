package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class ImgCenterModelBuilder implements OutlineElementModelBuilder {

    public ImgCenterModelBuilder(ImgCenterAttributes imgCenterAttributes, List<Line> lines) {
    }

    @Override
    public ImgCenterModel getModel() throws MDPSyntaxError {
        return new ImgCenterModel();
    }

}
