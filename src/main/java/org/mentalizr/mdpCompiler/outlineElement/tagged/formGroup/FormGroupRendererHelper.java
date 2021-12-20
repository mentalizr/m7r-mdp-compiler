package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.inlineElement.inlineParser.InlineParserMDP;
import org.mentalizr.mdpCompiler.outlineElement.tagged.SubModelsWithSingleLine;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class FormGroupRendererHelper {

    public static void renderHeaderLines(SubModelsWithSingleLine subModelsWithSingleLine, String id, HtmlBuilder htmlBuilder, CompilerContext compilerContext) {

        int indent = compilerContext.getIndentLevel();

        if (subModelsWithSingleLine.hasSingleLine()) {
            String label = subModelsWithSingleLine.getSingleLine();
            InlineParserMDP inlineParserMDP = new InlineParserMDP();
            String labelPreprocessed = inlineParserMDP.parse(label);
            htmlBuilder.addLn(indent + 1, "<label for=\"" + id + "\">" + labelPreprocessed + "</label>");
        } else {
            MDPCompiler.renderSubdocument(
                    subModelsWithSingleLine.getChildModels(),
                    htmlBuilder,
                    compilerContext
            );
        }
    }

}
