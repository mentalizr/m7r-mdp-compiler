package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroupRendererHelper;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class InputGroupRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        InputGroupModel inputGroupModel = (InputGroupModel) outlineElementModel;
        InputGroupAttributes inputGroupAttributes = inputGroupModel.getInputGroupAttributes();

        String cssPseudoClass = "ns_input";

        int indent = compilerContext.getIndentLevel();

        htmlBuilder.addLn("<div class=\"form-group\">");

        FormGroupRendererHelper.renderHeaderLines(inputGroupModel, inputGroupAttributes.getId(), htmlBuilder, compilerContext);

        StringBuilder stringBuilder = new StringBuilder("<input ");
        stringBuilder.append("type=\"").append(inputGroupAttributes.getInputtype()).append("\" ");
        stringBuilder.append("class=\"form-control ").append(cssPseudoClass).append("\" ");
        stringBuilder.append("id=\"").append(inputGroupAttributes.getId()).append("\" ");

        if (inputGroupAttributes.getScope().equals(InputGroupAttributes.VALUE_PROGRAM)) {
            stringBuilder.append("data-m7r-program-scope-id=\"").append(inputGroupAttributes.getScopeId()).append("\" ");
        }

        stringBuilder.append("placeholder=\"").append(inputGroupAttributes.getPlaceholder()).append("\">");

        htmlBuilder.addLn(indent + 1, stringBuilder.toString());

        htmlBuilder.addLn("</div>");
    }

}
