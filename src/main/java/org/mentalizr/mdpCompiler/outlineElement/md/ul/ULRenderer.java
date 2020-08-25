package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class ULRenderer extends OutlineElementRenderer {

    private final ULModel ulModel;

    public ULRenderer(Result result, ULModel ulModel) {
        super(result);
        this.ulModel = ulModel;
    }

    @Override
    public void render(CompilerContext compilerContext) {

        String marginClass = compilerContext.isOuterElement() ? "mb-4" : "mb-2";
        int indentLevel = compilerContext.getIndentLevel();

        this.result.addLn(indentLevel,"<ul class=\"" + marginClass + "\">");
        for (String item : this.ulModel.getItemList()) {
            String preprocessedItem = this.inlineParserMDP.parse(item);
            this.result.addLn(indentLevel, "    <li>" + preprocessedItem + "</li>");
        }
        this.result.addLn(indentLevel, "</ul>");
    }

}
