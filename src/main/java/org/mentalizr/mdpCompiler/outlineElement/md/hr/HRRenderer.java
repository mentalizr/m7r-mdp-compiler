package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class HRRenderer extends OutlineElementRenderer {

    public HRRenderer() {
        super();
    }

    @Override
    public void render(CompilerContext compilerContext, Result result) throws MDPSyntaxError {
        int indentLevel = compilerContext.getIndentLevel();
        result.addLn(indentLevel, "<hr/>");
    }
}
