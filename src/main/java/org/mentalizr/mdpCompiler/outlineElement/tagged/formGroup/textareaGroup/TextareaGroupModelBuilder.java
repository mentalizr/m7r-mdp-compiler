package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup.RadioGroup;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup.RadioGroupModel;

import java.util.ArrayList;
import java.util.List;

public class TextareaGroupModelBuilder extends TextBlockModelBuilder {

    private List<OutlineElementModel> outlineElementModelList;

    public TextareaGroupModelBuilder() {
        super(new TextareaGroup());
        this.outlineElementModelList = new ArrayList<>();
    }

    @Override
    public TextareaGroupModel getModel(Extraction extraction) throws MDPSyntaxError {
        TextBlockModel textBlockModel = (TextBlockModel) super.getModel(extraction);
        if (textBlockModel.getNrOfTextBlockLines() == 1) {
            return new TextareaGroupModel(textBlockModel.getMdpTag(), textBlockModel.getSingleLineAsString());
        } else {
            Document document = textBlockModel.asDocument();
            this.outlineElementModelList = MDPCompiler.getModelsForSubdocument(document);
            return new TextareaGroupModel(textBlockModel.getMdpTag(), this.outlineElementModelList);
        }
    }

}
