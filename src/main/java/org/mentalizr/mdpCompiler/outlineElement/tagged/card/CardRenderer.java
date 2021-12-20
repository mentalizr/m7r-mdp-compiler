package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class CardRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        CardModel cardModel = (CardModel) outlineElementModel;
        CardAttributes cardAttributes = cardModel.getCardAttributes();

        int indent = compilerContext.getIndentLevel();

        htmlBuilder.addLn(indent, "<div class=\"" + getCardClassValue(cardAttributes) + "\">");

        renderHeader(indent, cardAttributes, htmlBuilder);

        renderBody(indent, cardModel, htmlBuilder);

        htmlBuilder.addLn(indent, "</div>");
    }

    private String getCardClassValue(CardAttributes cardAttributes) {

        StringBuilder classValueBuilder = new StringBuilder();
        classValueBuilder.append("card");

        if (cardAttributes.hasTextColor()) {
            classValueBuilder.append(" text-").append(cardAttributes.getTextColor());
        }

        if (cardAttributes.hasBgColor()) {
            classValueBuilder.append(" bg-").append(cardAttributes.getBgColor());
        }

        classValueBuilder.append(" mt-").append(cardAttributes.getMarginTop());
        classValueBuilder.append(" mb-").append(cardAttributes.getMarginBottom());

        return classValueBuilder.toString();
    }

    private void renderHeader(int indent, CardAttributes cardAttributes, HtmlBuilder htmlBuilder) {
        if (cardAttributes.hasHeader()) {
            htmlBuilder.addLn(indent + 1, "<div class=\"card-header\">" + cardAttributes.getHeader() + "</div>");
        }
    }

    private void renderBody(int indent, CardModel cardModel, HtmlBuilder htmlBuilder) {
        if (cardModel.hasSingleLine()) {
            renderSingleLineBody(indent, cardModel, htmlBuilder);
        } else if (cardModel.hasChildModels()) {
            renderMultiLineBody(indent, cardModel, htmlBuilder);
        }
    }

    private void renderSingleLineBody(int indent, CardModel cardModel, HtmlBuilder htmlBuilder) {
        String cardText = cardModel.getSingleLine();
        htmlBuilder.addLn(indent + 1, "<div class=\"card-body\">");
        htmlBuilder.addLn(indent + 2, "<div class=\"card-text\">" + cardText + "</div>");
        htmlBuilder.addLn(indent + 1, "</div>");
    }

    private void renderMultiLineBody(int indent, CardModel cardModel, HtmlBuilder htmlBuilder) {

        htmlBuilder.addLn(indent + 1, "<div class=\"card-body\">");

        MDPCompiler.renderSubdocument(cardModel.getChildModels(), htmlBuilder, new CompilerContext(false, indent + 1));

        htmlBuilder.addLn(indent + 1, "</div>");
    }
}
