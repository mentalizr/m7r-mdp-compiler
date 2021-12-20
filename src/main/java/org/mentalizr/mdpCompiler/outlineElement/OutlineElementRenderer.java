package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.inlineElement.inlineParser.InlineParserMDP;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public abstract class OutlineElementRenderer {

    protected InlineParserMDP inlineParserMDP;

    public OutlineElementRenderer() {
        this.inlineParserMDP = new InlineParserMDP();
    }

    abstract public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder);
}
