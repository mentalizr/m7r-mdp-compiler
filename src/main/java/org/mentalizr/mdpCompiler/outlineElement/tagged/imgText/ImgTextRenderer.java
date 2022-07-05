package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class ImgTextRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        ImgTextModel imgTextModel = (ImgTextModel) outlineElementModel;
        ImgTextAttributes imgTextAttributes = imgTextModel.getImgTextAttributes();
        String mdpTagLink = imgTextModel.getMdpTag().getLinkString();

        String contextUrl = compilerContext.getMediaContextUrl();
        int indent = compilerContext.getIndentLevel();

        // TODO margion-top und margin-bottom müssen angepasst werden: Abschneiden von anhängenden Nullen? 3.00 zu 3? Prüfen! S. alter Code

        htmlBuilder.addLn(indent,"<div class=\"row\" "
                + "style=\"margin-bottom: " + imgTextAttributes.getMarginBootom()
                + "em; margin-top: " + imgTextAttributes.getMarginTop() + "em\">");

        int imgColWidth = imgTextAttributes.getImgColWidth();
        int textColWidth = 12 - imgColWidth;

        htmlBuilder.addLn(indent + 1,"<div class=\"col-xs-12 col-sm-" + imgColWidth
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

        htmlBuilder.addLn(indent + 2, imgTag);

        htmlBuilder.addLn(indent + 1, "</div>");
        htmlBuilder.addLn(indent + 1, "<div class=\"col-xs-12 col-sm-" + textColWidth + " col-md-" + textColWidth + " col-lg-" + textColWidth + "\">");

        MDPCompiler.renderSubdocument(
                imgTextModel.getChildModels(),
                htmlBuilder,
                new CompilerContext(false, compilerContext.getIndentLevel() + 1)
        );

        htmlBuilder.addLn(indent + 1, "</div>");
        htmlBuilder.addLn(indent, "</div>");

    }
}
