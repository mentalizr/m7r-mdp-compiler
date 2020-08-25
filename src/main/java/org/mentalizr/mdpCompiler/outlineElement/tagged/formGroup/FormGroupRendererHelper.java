package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.inlineElement.inlineParser.InlineParserMDP;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.result.Result;

public class FormGroupRendererHelper {

    public static void renderHeaderLines(TextBlockModel textBlockModel, String id, Result result, CompilerContext compilerContext) throws MDPSyntaxError {

        int indent = compilerContext.getIndentLevel();

        if (textBlockModel.getNrOfTextBlockLines() == 1) {
            String label = textBlockModel.getSingleLineAsString();
            InlineParserMDP inlineParserMDP = new InlineParserMDP();
            String labelPreprocessed = inlineParserMDP.parse(label);
            result.addLn(indent + 1, "<label for=\"" + id + "\">" + labelPreprocessed + "</label>");
        } else {
            MDPCompiler.compileSubdocument(
                    textBlockModel.asDocument(),
                    result,
                    compilerContext);
        }
    }

}
