package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroupAttributes;
import org.mentalizr.mdpCompiler.result.Result;

public class RadioGroupRenderer extends OutlineElementRenderer {

    private final RadioGroupAttributes radioGroupAttributes;
    private final TextBlockModel textBlockModel;

    public RadioGroupRenderer(Result result, RadioGroupAttributes radioGroupAttributes, TextBlockModel textBlockModel) {
        super(result);
        this.radioGroupAttributes = radioGroupAttributes;
        this.textBlockModel = textBlockModel;
    }

    @Override
    public void render(CompilerContext compilerContext) throws MDPSyntaxError {

        int indent = compilerContext.getIndentLevel();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<div id=\"").append(this.radioGroupAttributes.getId()).append("\" class=\"mb-2 ns_radiogroup\"");

        if (this.radioGroupAttributes.hasRefId()) {
            stringBuilder.append(" data-m7r-ref-id=\"").append(this.radioGroupAttributes.getRefId()).append("\" ");
        }

        if (this.radioGroupAttributes.getScope().equals(InputGroupAttributes.VALUE_PROGRAM)) {
            stringBuilder.append(" data-m7r-program-scope-id=\"").append(this.radioGroupAttributes.getScopeId()).append("\"");
        }
        stringBuilder.append(">");
        this.result.addLn(indent, stringBuilder.toString());

//        this.result.addLn(indent, "<div id=\"" + this.radioGroupAttributes.getId() + "\" class=\"mb-2 ns_radiogroup\">");

        if (this.textBlockModel.getNrOfTextBlockLines() == 1) {
            String label = this.textBlockModel.getSingleLineAsString();
            String labelPreprocessed = this.inlineParserMDP.parse(label);
            this.result.addLn(indent + 1, "<div>" + labelPreprocessed + "</div>");
        } else {
            MDPCompiler.compileSubdocument(
                    textBlockModel.asDocument(),
                    result,
                    compilerContext);

            // TODO div-Container um header notwendig?
            // TODO stimmt mb-2 bei Subdocument?
        }

        int itemCounter = 1;
        for (String buttonText : this.radioGroupAttributes.getOpenSimpleAttributes()) {
            String buttonTextPreprocessed = this.inlineParserMDP.parse(buttonText);
            this.result.addLn(indent + 1, "<div class=\"form-check form-check-inline\">");

            stringBuilder = new StringBuilder()
                    .append("<input class=\"form-check-input\" type=\"radio\"")
                    .append(" name=\"").append(this.radioGroupAttributes.getName()).append("\"")
                    .append(" id=\"").append(this.radioGroupAttributes.getId()).append("_").append(itemCounter).append("\"");

//            if (this.radioGroupAttributes.getScope().equals(InputGroupAttributes.VALUE_PROGRAM)) {
//                stringBuilder.append(" data-m7r-program-scope-id=\"").append(this.radioGroupAttributes.getScopeId()).append("\"");
//            }

            stringBuilder.append(" value=\"").append(itemCounter).append("\"");

            if (this.radioGroupAttributes.isReadonly()) {
                stringBuilder.append(" disabled");
            }

            stringBuilder.append(">");

            this.result.addLn(indent + 2, stringBuilder.toString());

            this.result.addLn(indent + 2, "<label class=\"form-check-label\" for=\"" + this.radioGroupAttributes.getId() + "_" + itemCounter + "\">" + buttonTextPreprocessed + "</label>");
            this.result.addLn(indent + 1, "</div>");
            itemCounter++;
        }

        this.result.addLn(indent, "</div>");

    }
}
