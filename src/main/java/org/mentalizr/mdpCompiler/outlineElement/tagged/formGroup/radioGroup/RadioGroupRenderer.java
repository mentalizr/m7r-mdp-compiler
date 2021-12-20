package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.CompilerContext;
import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroupAttributes;
import org.mentalizr.mdpCompiler.result.HtmlBuilder;

public class RadioGroupRenderer extends OutlineElementRenderer {

    @Override
    public void render(OutlineElementModel outlineElementModel, CompilerContext compilerContext, HtmlBuilder htmlBuilder) {

        RadioGroupModel radioGroupModel = (RadioGroupModel) outlineElementModel;
        RadioGroupAttributes radioGroupAttributes = radioGroupModel.getRadioGroupAttributes();

        int indent = compilerContext.getIndentLevel();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<div id=\"").append(radioGroupAttributes.getId()).append("\" class=\"mb-2 ns_radiogroup\"");

        if (radioGroupAttributes.hasRefId()) {
            stringBuilder.append(" data-m7r-ref-id=\"").append(radioGroupAttributes.getRefId()).append("\" ");
        }

        if (radioGroupAttributes.getScope().equals(InputGroupAttributes.VALUE_PROGRAM)) {
            stringBuilder.append(" data-m7r-program-scope-id=\"").append(radioGroupAttributes.getScopeId()).append("\"");
        }
        stringBuilder.append(">");
        htmlBuilder.addLn(indent, stringBuilder.toString());

        if (radioGroupModel.hasSingleLine()) {
            String label = radioGroupModel.getSingleLine();
            String labelPreprocessed = this.inlineParserMDP.parse(label);
            htmlBuilder.addLn(indent + 1, "<div>" + labelPreprocessed + "</div>");
        } else {
            MDPCompiler.renderSubdocument(
                    radioGroupModel.getChildModels(),
                    htmlBuilder,
                    compilerContext
            );

//            MDPCompiler.compileSubdocument(
//                    radioGroupModel.asDocument(),
//                    result,
//                    compilerContext);

            // TODO div-Container um header notwendig?
            // TODO stimmt mb-2 bei Subdocument?
        }

        int itemCounter = 1;
        for (String buttonText : radioGroupAttributes.getOpenSimpleAttributes()) {
            String buttonTextPreprocessed = this.inlineParserMDP.parse(buttonText);
            htmlBuilder.addLn(indent + 1, "<div class=\"form-check form-check-inline\">");

            stringBuilder = new StringBuilder()
                    .append("<input class=\"form-check-input\" type=\"radio\"")
                    .append(" name=\"").append(radioGroupAttributes.getName()).append("\"")
                    .append(" id=\"").append(radioGroupAttributes.getId()).append("_").append(itemCounter).append("\"");

//            if (this.radioGroupAttributes.getScope().equals(InputGroupAttributes.VALUE_PROGRAM)) {
//                stringBuilder.append(" data-m7r-program-scope-id=\"").append(this.radioGroupAttributes.getScopeId()).append("\"");
//            }

            stringBuilder.append(" value=\"").append(itemCounter).append("\"");

            if (radioGroupAttributes.isReadonly()) {
                stringBuilder.append(" disabled");
            }

            stringBuilder.append(">");

            htmlBuilder.addLn(indent + 2, stringBuilder.toString());

            htmlBuilder.addLn(indent + 2, "<label class=\"form-check-label\" for=\"" + radioGroupAttributes.getId() + "_" + itemCounter + "\">" + buttonTextPreprocessed + "</label>");
            htmlBuilder.addLn(indent + 1, "</div>");
            itemCounter++;
        }

        htmlBuilder.addLn(indent, "</div>");
    }

}
