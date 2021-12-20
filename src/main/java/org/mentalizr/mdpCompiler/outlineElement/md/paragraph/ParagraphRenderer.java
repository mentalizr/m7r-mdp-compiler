package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class ParagraphRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        ParagraphModel paragraphModel = (ParagraphModel) outlineElementModel;

        int indentLevel = compilerContext.getIndentLevel();

        String[] mdpLines = paragraphModel.getLinesAsStringArray();

        for (int i=0; i<mdpLines.length; i++) {

            String lineWork = "";

            if (i == 0) {
                lineWork = "<p>";
            }

            String mdpLine = mdpLines[i];
            mdpLine = this.inlineParserMDP.parse(mdpLine);
            lineWork += mdpLine;

            if (i == mdpLines.length - 1) {
                lineWork += "</p>";
            }

            htmlBuilder.addLn(indentLevel, lineWork);
        }
    }

}
