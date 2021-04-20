package org.mentalizr.mdpCompiler.outlineElement.md.paragraph;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class ParagraphRenderer extends OutlineElementRenderer {

    private final ParagraphModel paragraphModel;

    public ParagraphRenderer(ParagraphModel paragraphModel) {
        super();
        this.paragraphModel = paragraphModel;
    }

    @Override
    public void render(CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        int indentLevel = compilerContext.getIndentLevel();

        String[] mdpLines = this.paragraphModel.getLinesAsStringArray();

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

            result.addLn(indentLevel, lineWork);
        }
    }

}
