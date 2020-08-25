package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.inlineElement.inlineParser.InlineParserMDP;
import org.mentalizr.mdpCompiler.result.Result;

public abstract class OutlineElementRenderer {

    protected Result result;
    protected InlineParserMDP inlineParserMDP;

    public OutlineElementRenderer(Result result) {
        this.result = result;
        this.inlineParserMDP = new InlineParserMDP();
    }

    abstract public void render(CompilerContext compilerContext) throws MDPSyntaxError;
}
