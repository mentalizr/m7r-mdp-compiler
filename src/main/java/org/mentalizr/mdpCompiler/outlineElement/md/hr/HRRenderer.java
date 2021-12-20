package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class HRRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {
        int indentLevel = compilerContext.getIndentLevel();
        htmlBuilder.addLn(indentLevel, "<hr/>");
    }

}
