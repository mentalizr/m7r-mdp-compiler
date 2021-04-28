package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroup;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroupModel;

import java.util.ArrayList;
import java.util.List;

public class RadioGroupModelBuilder extends TextBlockModelBuilder {

    public RadioGroupModelBuilder() {
        super(new RadioGroup());
    }

    @Override
    public RadioGroupModel getModel(Extraction extraction) throws MDPSyntaxError {
        TextBlockModel textBlockModel = (TextBlockModel) super.getModel(extraction);
        if (textBlockModel.getNrOfTextBlockLines() == 1) {
            return new RadioGroupModel(textBlockModel.getMdpTag(), textBlockModel.getSingleLineAsString());
        } else {
            Document document = textBlockModel.asDocument();
            List<OutlineElementModel> childElements = MDPCompiler.getModelsForSubdocument(document);
            return new RadioGroupModel(textBlockModel.getMdpTag(), childElements);
        }
    }

}
