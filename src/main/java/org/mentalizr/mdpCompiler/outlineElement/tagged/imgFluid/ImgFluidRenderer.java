package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class ImgFluidRenderer extends OutlineElementRenderer {

    private final ImgFluidAttributes imgFluidAttributes;
    private final ImgFluidModel imgFluidModel;
    private final String mdpTagLink;

    public ImgFluidRenderer(Result result, ImgFluidAttributes imgFluidAttributes, ImgFluidModel imgFluidModel, String mdpTagLink) {
        super(result);
        this.imgFluidAttributes = imgFluidAttributes;
        this.imgFluidModel = imgFluidModel;
        this.mdpTagLink = mdpTagLink;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {

        String contextUrl = compilerContext.getServiceContextURL() + "mediaImg/";

        String classString = "img-fluid mb-" + this.imgFluidAttributes.getNameMarginBottom() + " mt-" + this.imgFluidAttributes.getMarginTop();

        String result = "<img src=\"" + contextUrl + this.mdpTagLink + "\" class=\"" + classString + "\" style=\"width: 100%\""
            + " alt=\"" + this.imgFluidAttributes.getAlt() + "\">";

        this.result.addLn(compilerContext.getIndentLevel(), result);
    }
}
