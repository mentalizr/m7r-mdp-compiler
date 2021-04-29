package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroupRendererHelper;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroupAttributes;
import org.mentalizr.mdpCompiler.result.Result;

public class TextareaGroupRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, Result result) {

        TextareaGroupModel textareaGroupModel = (TextareaGroupModel) outlineElementModel;
        TextareaGroupAttributes textareaGroupAttributes = textareaGroupModel.getTextareaGroupAttributes();

        String cssPseudoClass = "ns_input";
        int indent = compilerContext.getIndentLevel();

        result.addLn(indent, "<div class=\"form-group\">");

        FormGroupRendererHelper.renderHeaderLines(textareaGroupModel, textareaGroupAttributes.getId(), result, compilerContext);

        StringBuilder stringBuilder = new StringBuilder("<textarea ");
        stringBuilder.append("class=\"form-control ").append(cssPseudoClass).append("\" ");
        stringBuilder.append("id=\"").append(textareaGroupAttributes.getId()).append("\" ");

        if (textareaGroupAttributes.hasRefId()) {
            stringBuilder.append("data-m7r-ref-id=\"").append(textareaGroupAttributes.getRefId()).append("\" ");
        }

        if (textareaGroupAttributes.getScope().equals(InputGroupAttributes.VALUE_PROGRAM)) {
            stringBuilder.append("data-m7r-program-scope-id=\"").append(textareaGroupAttributes.getScopeId()).append("\" ");
        }

        stringBuilder.append("rows=\"").append(textareaGroupAttributes.getRows()).append("\"");

        if (textareaGroupAttributes.isReadonly()) {
            stringBuilder.append(" disabled");
        }

        stringBuilder.append("></textarea>");

        result.addLn(indent + 1, stringBuilder.toString());

        result.addLn("</div>");
    }

}
