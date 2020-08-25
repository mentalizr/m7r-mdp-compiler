package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class ImgCenterRenderer extends OutlineElementRenderer {

    private final ImgCenterAttributes imgCenterAttributes;
    private final ImgCenterModel imgCenterModel;
    private final String mdpTagLink;

    public ImgCenterRenderer(Result result, ImgCenterAttributes imgCenterAttributes, ImgCenterModel imgCenterModel, String mdpTagLink) {
        super(result);
        this.imgCenterAttributes = imgCenterAttributes;
        this.imgCenterModel = imgCenterModel;
        this.mdpTagLink = mdpTagLink;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {

        String contextUrl = compilerContext.getServiceContextURL() + "mediaImg/";

        String classString = "mx-auto d-block mb-" + this.imgCenterAttributes.getNameMarginBottom() + " mt-" + this.imgCenterAttributes.getMarginTop();

        String result = "<img src=\"" + contextUrl + this.mdpTagLink + "\" class=\"" + classString + "\""
            + " alt=\"" + this.imgCenterAttributes.getAlt() + "\">";

        this.result.addLn(compilerContext.getIndentLevel(), result);
    }
}
