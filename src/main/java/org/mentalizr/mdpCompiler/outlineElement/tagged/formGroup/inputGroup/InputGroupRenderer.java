package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroupRendererHelper;
import org.mentalizr.mdpCompiler.result.Result;

public class InputGroupRenderer extends OutlineElementRenderer {

    private final InputGroupAttributes inputGroupAttributes;
    private final TextBlockModel textBlockModel;

    public InputGroupRenderer(InputGroupAttributes inputGroupAttributes, TextBlockModel textBlockModel) {
        super();
        this.inputGroupAttributes = inputGroupAttributes;
        this.textBlockModel = textBlockModel;
    }

    @Override
    public void render(CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        String cssPseudoClass = "ns_input";

        int indent = compilerContext.getIndentLevel();

        result.addLn("<div class=\"form-group\">");

        FormGroupRendererHelper.renderHeaderLines(this.textBlockModel, this.inputGroupAttributes.getId(), result, compilerContext);

        StringBuilder stringBuilder = new StringBuilder("<input ");
        stringBuilder.append("type=\"").append(this.inputGroupAttributes.getInputtype()).append("\" ");
        stringBuilder.append("class=\"form-control ").append(cssPseudoClass).append("\" ");
        stringBuilder.append("id=\"").append(this.inputGroupAttributes.getId()).append("\" ");

        if (this.inputGroupAttributes.getScope().equals(InputGroupAttributes.VALUE_PROGRAM)) {
            stringBuilder.append("data-m7r-program-scope-id=\"").append(this.inputGroupAttributes.getScopeId()).append("\" ");
        }

        stringBuilder.append("placeholder=\"").append(this.inputGroupAttributes.getPlaceholder()).append("\">");

        result.addLn(indent + 1, stringBuilder.toString());

//        result.addLn(indent + 1, "<input " +
//                "type=\"" + this.inputGroupAttributes.getInputtype() + "\" " +
//                "class=\"form-control " + cssPseudoClass + "\" " +
//                "id=\"" + this.inputGroupAttributes.getId() + "\" " +
//                "placeholder=\"" + this.inputGroupAttributes.getPlaceholder() + "\">");

        result.addLn("</div>");

    }

}
