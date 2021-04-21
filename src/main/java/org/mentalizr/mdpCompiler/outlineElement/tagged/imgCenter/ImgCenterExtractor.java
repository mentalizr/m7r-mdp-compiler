package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyExtractor;

public class ImgCenterExtractor extends MDPTagOnlyExtractor {

    public ImgCenterExtractor() {
        super(new ImgCenterExtractionFactory());
    }

}
