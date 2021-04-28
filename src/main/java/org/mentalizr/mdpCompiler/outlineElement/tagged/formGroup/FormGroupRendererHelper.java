package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.inlineElement.inlineParser.InlineParserMDP;
import org.mentalizr.mdpCompiler.outlineElement.tagged.SubModelsWithSingleLine;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.result.Result;

public class FormGroupRendererHelper {

    public static void renderHeaderLines(SubModelsWithSingleLine subModelsWithSingleLine, String id, Result result, CompilerContext compilerContext) throws MDPSyntaxError {

        int indent = compilerContext.getIndentLevel();

        if (subModelsWithSingleLine.hasSingleLine()) {
            String label = subModelsWithSingleLine.getSingleLine();
            InlineParserMDP inlineParserMDP = new InlineParserMDP();
            String labelPreprocessed = inlineParserMDP.parse(label);
            result.addLn(indent + 1, "<label for=\"" + id + "\">" + labelPreprocessed + "</label>");
        } else {
            MDPCompiler.renderSubdocument(
                    subModelsWithSingleLine.getChildModels(),
                    result,
                    compilerContext
            );

//            MDPCompiler.compileSubdocument(
//                    subModelsWithSingleLine.asDocument(),
//                    result,
//                    compilerContext);
        }
    }

}
