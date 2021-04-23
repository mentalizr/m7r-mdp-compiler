package org.mentalizr.mdpCompiler.outlineElement.tagged.html;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.result.Result;

import java.util.List;

public class HtmlRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        TextBlockModel textBlockModel = (TextBlockModel) outlineElementModel;
        HtmlAttributes htmlAttributes = (HtmlAttributes) textBlockModel.getOutlineElementTaggedAttributes();

        int indent = compilerContext.getIndentLevel();

        StringBuilder divTagBuilder = new StringBuilder();
        divTagBuilder.append("<div");

        if (htmlAttributes.hasId()) {
            divTagBuilder.append(" id=\"").append(htmlAttributes.getId()).append("\"");
        }

        divTagBuilder.append(" class=\"");
        divTagBuilder.append("mt-").append(htmlAttributes.getMarginTop());
        divTagBuilder.append(" mb-").append(htmlAttributes.getMarginBottom());
        divTagBuilder.append("\">");

        result.addLn(indent, divTagBuilder.toString());

        List<Line> htmlLines = textBlockModel.asDocument().getLines();
        for (Line line : htmlLines) {
            result.addLn(indent + 1, line.asString());
        }

        result.addLn(indent, "</div>");
    }

}
