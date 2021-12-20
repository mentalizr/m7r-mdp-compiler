package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class DirectiveRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        DirectiveModel directiveModel = (DirectiveModel) outlineElementModel;

        htmlBuilder.addLn("<!--");
        for (String line : directiveModel.getDirectives()) {
            htmlBuilder.addLn(line);
        }
        htmlBuilder.addLn("-->");
        htmlBuilder.addLn("");
    }

}
