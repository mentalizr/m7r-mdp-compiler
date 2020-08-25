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

    public CardRenderer(Result result, CardAttributes cardAttributes, TextBlockModel cardModel) {
        super(result);
        this.cardAttributes = cardAttributes;
        this.cardModel = cardModel;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {

        int indent = compilerContext.getIndentLevel();

        this.result.addLn(indent, "<div class=\"" + getCardClassValue() + "\">");

        renderHeader(indent);

        renderBody(indent);

        this.result.addLn(indent, "</div>");

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

    private void renderHeader(int indent) {
        if (this.cardAttributes.hasHeader()) {
            this.result.addLn(indent + 1, "<div class=\"card-header\">" + this.cardAttributes.getHeader() + "</div>");
        }
    }

    private void renderBody(int indent) throws MDPSyntaxError {
        if (this.cardModel.getNrOfTextBlockLines() == 1) {
            renderSingleLineBody(indent);
        } else if (this.cardModel.getNrOfTextBlockLines() > 1) {
            renderMultiLineBody(indent);
        }
    }

    private void renderSingleLineBody(int indent) {
        String cardText = this.cardModel.getSingleLineAsString();
        this.result.addLn(indent + 1, "<div class=\"card-body\">");
        this.result.addLn(indent + 2, "<div class=\"card-text\">" + cardText + "</div>");
        this.result.addLn(indent + 1, "</div>");
    }

    private void renderMultiLineBody(int indent) throws MDPSyntaxError {

        this.result.addLn(indent + 1, "<div class=\"card-body\">");

        MDPCompiler.compileSubdocument(
                cardModel.asDocument(),
                this.result,
                new CompilerContext(false, indent + 1));

        this.result.addLn(indent + 1, "</div>");
    }
}
