package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.result.Result;

public class DirectiveRenderer extends OutlineElementRenderer {

    private final DirectiveModel directiveModel;

    public DirectiveRenderer(Result result, DirectiveModel directiveModel) {
        super(result);
        this.directiveModel = directiveModel;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {

        this.result.addLn("<!--");
        for (String line : this.directiveModel.getDirectives()) {
            this.result.addLn(line);
        }
        this.result.addLn("-->");
        this.result.addLn("");


    }
}
