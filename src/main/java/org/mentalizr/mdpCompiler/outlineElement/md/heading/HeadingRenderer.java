package org.mentalizr.mdpCompiler.outlineElement.md.heading;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class HeadingRenderer extends OutlineElementRenderer {

    public HeadingRenderer() {
        super();
    }

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) {
        HeadingModel headingModel = (HeadingModel) outlineElementModel;
        int headingLevel = headingModel.getHeadingLevel();
        int indentLevel = compilerContext.getIndentLevel();
        result.addLn(indentLevel, "<p class=\"h" + headingLevel + " mt-4 mb-4\">" + headingModel.getHeading() + "</p>");
    }

}
