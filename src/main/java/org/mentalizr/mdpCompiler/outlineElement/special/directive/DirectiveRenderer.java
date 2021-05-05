package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class DirectiveRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) {

        DirectiveModel directiveModel = (DirectiveModel) outlineElementModel;

        result.addLn("<!--");
        for (String line : directiveModel.getDirectives()) {
            result.addLn(line);
        }
        result.addLn("-->");
        result.addLn("");
    }

}
