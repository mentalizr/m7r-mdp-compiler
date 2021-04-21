package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;

import java.util.List;

public class ImgCenterModelBuilder implements OutlineElementModelBuilder {

    public ImgCenterModelBuilder(ImgCenterAttributes imgCenterAttributes) {
    }

    @Override
    public ImgCenterModel getModel(Extraction extraction) throws MDPSyntaxError {
        return new ImgCenterModel();
    }

}
