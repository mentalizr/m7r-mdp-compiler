package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.result.Result;

public class ImgTextRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        TextBlockModel textBlockModel = (TextBlockModel) outlineElementModel;
        ImgTextAttributes imgTextAttributes = (ImgTextAttributes) textBlockModel.getOutlineElementTaggedAttributes();
        String mdpTagLink = textBlockModel.getMdpTag().getLinkString();

        String contextUrl = compilerContext.getServiceContextURL() + "mediaImg/";
        int indent = compilerContext.getIndentLevel();

        // TODO margion-top und margin-bottom müssen angepasst werden: Abschneiden von anhängenden Nullen? 3.00 zu 3? Prüfen! S. alter Code

        result.addLn(indent,"<div class=\"row\" "
                + "style=\"margin-bottom: " + imgTextAttributes.getMarginBootom()
                + "em; margin-top: " + imgTextAttributes.getMarginTop() + "em\">");

        int imgColWidth = imgTextAttributes.getImgColWidth();
        int textColWidth = 12 - imgColWidth;

        result.addLn(indent + 1,"<div class=\"col-xs-12 col-sm-" + imgColWidth
                + " col-md-" + imgColWidth
                + " col-lg-" + imgColWidth
                + "\">");

        String imgTag = "<img src=\"" + contextUrl + mdpTagLink + "\" " +
                "class=\"img-fluid\" ";

        if (imgTextAttributes.isImgExpand()) {
            imgTag += "style=\"width: 100%\" ";
        }

        imgTag += "alt=\"" + imgTextAttributes.getAlt() + "\"";

        imgTag += ">";

        result.addLn(indent + 2, imgTag);

        result.addLn(indent + 1, "</div>");
        result.addLn(indent + 1, "<div class=\"col-xs-12 col-sm-" + textColWidth + " col-md-" + textColWidth + " col-lg-" + textColWidth + "\">");

        MDPCompiler.compileSubdocument(
                textBlockModel.asDocument(),
                result,
                new CompilerContext(false, compilerContext.getIndentLevel() + 1));

        result.addLn(indent + 1, "</div>");
        result.addLn(indent, "</div>");

    }
}
