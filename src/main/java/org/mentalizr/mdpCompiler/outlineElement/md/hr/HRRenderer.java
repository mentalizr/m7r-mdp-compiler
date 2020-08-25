package org.mentalizr.mdpCompiler.outlineElement.md.hr;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class HRRenderer extends OutlineElementRenderer {

    public HRRenderer(Result result) {
        super(result);
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {
        int indentLevel = compilerContext.getIndentLevel();
        this.result.addLn(indentLevel, "<hr/>");
    }
}
