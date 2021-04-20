package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class HeadingRenderer extends OutlineElementRenderer {

    private final HeadingModel headingModel;
    private final int headingLevel;

    public HeadingRenderer(HeadingModel headingModel, int headingLevel) {
        super();
        this.headingModel = headingModel;
        this.headingLevel = headingLevel;
    }

    @Override
    public void render(CompilerContext compilerContext, Result result) throws MDPSyntaxError {
        int indentLevel = compilerContext.getIndentLevel();
        result.addLn(indentLevel, "<p class=\"h" + this.headingLevel + " mt-4 mb-4\">" + this.headingModel.getHeading() + "</p>");
    }
}
