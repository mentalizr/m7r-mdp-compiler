package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class HeadingRenderer extends OutlineElementRenderer {

    private final HeadingModel headingModel;
    private final int headingLevel;

    public HeadingRenderer(Result result, HeadingModel headingModel, int headingLevel) {
        super(result);
        this.headingModel = headingModel;
        this.headingLevel = headingLevel;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {
        int indentLevel = compilerContext.getIndentLevel();
        this.result.addLn(indentLevel, "<p class=\"h" + this.headingLevel + " mt-4 mb-4\">" + this.headingModel.getHeading() + "</p>");
    }
}
