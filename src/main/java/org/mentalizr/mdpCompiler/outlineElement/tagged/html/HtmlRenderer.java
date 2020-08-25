package org.mentalizr.mdpCompiler.outlineElement.tagged.html;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.result.Result;

import java.util.List;

public class HtmlRenderer extends OutlineElementRenderer {

    private final HtmlAttributes htmlAttributes;
    private final TextBlockModel htmlModel;

    // TODO Attributes

    public HtmlRenderer(Result result, HtmlAttributes htmlAttributes, TextBlockModel htmlModel) {
        super(result);
        this.htmlAttributes = htmlAttributes;
        this.htmlModel = htmlModel;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {

        int indent = compilerContext.getIndentLevel();

        StringBuilder divTagBuilder = new StringBuilder();
        divTagBuilder.append("<div");

        if (this.htmlAttributes.hasId()) {
            divTagBuilder.append(" id=\"").append(this.htmlAttributes.getId()).append("\"");
        }

        divTagBuilder.append(" class=\"");
        divTagBuilder.append("mt-").append(this.htmlAttributes.getMarginTop());
        divTagBuilder.append(" mb-").append(this.htmlAttributes.getMarginBottom());
        divTagBuilder.append("\">");

        this.result.addLn(indent, divTagBuilder.toString());

        List<Line> htmlLines = this.htmlModel.asDocument().getLines();
        for (Line line : htmlLines) {
            this.result.addLn(indent + 1, line.asString());
        }

        this.result.addLn(indent, "</div>");

    }

}
