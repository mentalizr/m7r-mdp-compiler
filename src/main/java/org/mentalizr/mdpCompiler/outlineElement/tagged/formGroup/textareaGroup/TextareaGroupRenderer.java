package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.FormGroupRendererHelper;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroupAttributes;
import org.mentalizr.mdpCompiler.result.Result;

public class TextareaGroupRenderer extends OutlineElementRenderer {

    private final TextareaGroupAttributes textareaGroupAttributes;
    private final TextBlockModel textBlockModel;

    public TextareaGroupRenderer(TextareaGroupAttributes textareaGroupAttributes, TextBlockModel textBlockModel) {
        super();
        this.textareaGroupAttributes = textareaGroupAttributes;
        this.textBlockModel = textBlockModel;
    }

    @Override
    public void render(CompilerContext compilerContext, Result result) throws MDPSyntaxError {

        String cssPseudoClass = "ns_input";
        int indent = compilerContext.getIndentLevel();

        result.addLn(indent, "<div class=\"form-group\">");

        FormGroupRendererHelper.renderHeaderLines(this.textBlockModel, this.textareaGroupAttributes.getId(), result, compilerContext);

        StringBuilder stringBuilder = new StringBuilder("<textarea ");
        stringBuilder.append("class=\"form-control ").append(cssPseudoClass).append("\" ");
        stringBuilder.append("id=\"").append(this.textareaGroupAttributes.getId()).append("\" ");

        if (this.textareaGroupAttributes.hasRefId()) {
            stringBuilder.append("data-m7r-ref-id=\"").append(this.textareaGroupAttributes.getRefId()).append("\" ");
        }

        if (this.textareaGroupAttributes.getScope().equals(InputGroupAttributes.VALUE_PROGRAM)) {
            stringBuilder.append("data-m7r-program-scope-id=\"").append(this.textareaGroupAttributes.getScopeId()).append("\" ");
        }

        stringBuilder.append("rows=\"").append(this.textareaGroupAttributes.getRows()).append("\"");

        if (this.textareaGroupAttributes.isReadonly()) {
            stringBuilder.append(" disabled");
        }

        stringBuilder.append("></textarea>");

        result.addLn(indent + 1, stringBuilder.toString());

        result.addLn("</div>");
    }

}
