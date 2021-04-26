package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class CardRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        CardModel cardModel = (CardModel) outlineElementModel;
        CardAttributes cardAttributes = cardModel.getOutlineElementTaggedAttributes();

        int indent = compilerContext.getIndentLevel();

        result.addLn(indent, "<div class=\"" + getCardClassValue(cardAttributes) + "\">");

        renderHeader(indent, cardAttributes, result);

        renderBody(indent, cardModel, result);

        result.addLn(indent, "</div>");
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

    private void renderHeader(int indent, CardAttributes cardAttributes, Result result) {
        if (cardAttributes.hasHeader()) {
            result.addLn(indent + 1, "<div class=\"card-header\">" + cardAttributes.getHeader() + "</div>");
        }
    }

    private void renderBody(int indent, CardModel cardModel, Result result) throws MDPSyntaxError {
        if (cardModel.hasSingleLine()) {
            renderSingleLineBody(indent, cardModel, result);
        } else if (cardModel.hasChildModels()) {
            renderMultiLineBody(indent, cardModel, result);
        }
    }

    private void renderSingleLineBody(int indent, CardModel cardModel, Result result) {
        String cardText = cardModel.getSingleLine();
        result.addLn(indent + 1, "<div class=\"card-body\">");
        result.addLn(indent + 2, "<div class=\"card-text\">" + cardText + "</div>");
        result.addLn(indent + 1, "</div>");
    }

    private void renderMultiLineBody(int indent, CardModel cardModel, Result result) throws MDPSyntaxError {

        result.addLn(indent + 1, "<div class=\"card-body\">");

        MDPCompiler.renderSubdocument(cardModel.getChildModels(), result, new CompilerContext(false, indent + 1));

        result.addLn(indent + 1, "</div>");
    }
}
