package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class DirectiveRenderer extends OutlineElementRenderer {

    private final DirectiveModel directiveModel;

    public DirectiveRenderer(DirectiveModel directiveModel) {
        super();
        this.directiveModel = directiveModel;
    }

    @Override
    public void render(CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        result.addLn("<!--");
        for (String line : this.directiveModel.getDirectives()) {
            result.addLn(line);
        }
        result.addLn("-->");
        result.addLn("");


    }
}
