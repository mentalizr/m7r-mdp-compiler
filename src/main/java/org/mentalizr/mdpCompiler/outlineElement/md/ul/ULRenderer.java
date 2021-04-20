package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class ULRenderer extends OutlineElementRenderer {

    private final ULModel ulModel;

    public ULRenderer(ULModel ulModel) {
        super();
        this.ulModel = ulModel;
    }

    @Override
    public void render(CompilerContext compilerContext, Result result) {

        String marginClass = compilerContext.isOuterElement() ? "mb-4" : "mb-2";
        int indentLevel = compilerContext.getIndentLevel();

        result.addLn(indentLevel,"<ul class=\"" + marginClass + "\">");
        for (String item : this.ulModel.getItemList()) {
            String preprocessedItem = this.inlineParserMDP.parse(item);
            result.addLn(indentLevel, "    <li>" + preprocessedItem + "</li>");
        }
        result.addLn(indentLevel, "</ul>");
    }

}
