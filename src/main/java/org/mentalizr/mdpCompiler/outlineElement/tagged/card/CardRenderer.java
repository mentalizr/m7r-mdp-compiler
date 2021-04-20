package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.result.Result;

public class CardRenderer extends OutlineElementRenderer {

    private final CardAttributes cardAttributes;
    private final TextBlockModel cardModel;

    public CardRenderer(CardAttributes cardAttributes, TextBlockModel cardModel) {
        super();
        this.cardAttributes = cardAttributes;
        this.cardModel = cardModel;
    }

    @Override
    public void render(CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        int indent = compilerContext.getIndentLevel();

        result.addLn(indent, "<div class=\"" + getCardClassValue() + "\">");

        renderHeader(indent, result);

        renderBody(indent, result);

        result.addLn(indent, "</div>");

    }

    private String getCardClassValue() {

        StringBuilder classValueBuilder = new StringBuilder();
        classValueBuilder.append("card");

        if (this.cardAttributes.hasTextColor()) {
            classValueBuilder.append(" text-").append(this.cardAttributes.getTextColor());
        }

        if (this.cardAttributes.hasBgColor()) {
            classValueBuilder.append(" bg-").append(this.cardAttributes.getBgColor());
        }

        classValueBuilder.append(" mt-").append(this.cardAttributes.getMarginTop());
        classValueBuilder.append(" mb-").append(this.cardAttributes.getMarginBottom());

        return classValueBuilder.toString();
    }

    private void renderHeader(int indent, Result result) {
        if (this.cardAttributes.hasHeader()) {
            result.addLn(indent + 1, "<div class=\"card-header\">" + this.cardAttributes.getHeader() + "</div>");
        }
    }

    private void renderBody(int indent, Result result) throws MDPSyntaxError {
        if (this.cardModel.getNrOfTextBlockLines() == 1) {
            renderSingleLineBody(indent, result);
        } else if (this.cardModel.getNrOfTextBlockLines() > 1) {
            renderMultiLineBody(indent, result);
        }
    }

    private void renderSingleLineBody(int indent, Result result) {
        String cardText = this.cardModel.getSingleLineAsString();
        result.addLn(indent + 1, "<div class=\"card-body\">");
        result.addLn(indent + 2, "<div class=\"card-text\">" + cardText + "</div>");
        result.addLn(indent + 1, "</div>");
    }

    private void renderMultiLineBody(int indent, Result result) throws MDPSyntaxError {

        result.addLn(indent + 1, "<div class=\"card-body\">");

        MDPCompiler.compileSubdocument(
                cardModel.asDocument(),
                result,
                new CompilerContext(false, indent + 1));

        result.addLn(indent + 1, "</div>");
    }
}
