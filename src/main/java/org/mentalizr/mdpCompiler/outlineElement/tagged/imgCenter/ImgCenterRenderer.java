package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class ImgCenterRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        ImgCenterModel imgCenterModel = (ImgCenterModel) outlineElementModel;
        ImgCenterAttributes imgCenterAttributes = imgCenterModel.getImgCenterAttributes();
        String mdpTagLink = imgCenterModel.getMdpTag().getLinkString();

        String contextUrl = compilerContext.getMediaContextUrl();

        String classString = "mx-auto d-block mb-" + imgCenterAttributes.getNameMarginBottom() + " mt-" + imgCenterAttributes.getMarginTop();

        String resultString = "<img src=\"" + contextUrl + mdpTagLink + "\" class=\"" + classString + "\""
            + " alt=\"" + imgCenterAttributes.getAlt() + "\">";

        htmlBuilder.addLn(compilerContext.getIndentLevel(), resultString);
    }

}
