package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class ImgFluidRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        ImgFluidModel imgFluidModel = (ImgFluidModel) outlineElementModel;
        ImgFluidAttributes imgFluidAttributes = imgFluidModel.getImgFluidAttributes();
        String mdpTagLink = imgFluidModel.getMdpTag().getLinkString();

        String contextUrl = compilerContext.getMediaContextUrl();

        String classString = "img-fluid mb-" + imgFluidAttributes.getNameMarginBottom()
                + " mt-" + imgFluidAttributes.getMarginTop();

        String resultString = "<img src=\"" + contextUrl + mdpTagLink + "\" class=\"" + classString
                + "\" style=\"width: 100%\""
                + " alt=\"" + imgFluidAttributes.getAlt() + "\">";

        htmlBuilder.addLn(compilerContext.getIndentLevel(), resultString);
    }

}
