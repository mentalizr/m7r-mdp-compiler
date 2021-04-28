package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.card.Card;
import org.mentalizr.mdpCompiler.outlineElement.tagged.card.CardModel;

import java.util.ArrayList;
import java.util.List;

public class InputGroupModelBuilder extends TextBlockModelBuilder {

    private List<OutlineElementModel> outlineElementModelList;

    public InputGroupModelBuilder() {
        super(new InputGroup());
        this.outlineElementModelList = new ArrayList<>();
    }

    @Override
    public InputGroupModel getModel(Extraction extraction) throws MDPSyntaxError {
        TextBlockModel textBlockModel = (TextBlockModel) super.getModel(extraction);
        if (textBlockModel.getNrOfTextBlockLines() == 1) {
            return new InputGroupModel(textBlockModel.getMdpTag(), textBlockModel.getSingleLineAsString());
        } else {
            Document document = textBlockModel.asDocument();
            this.outlineElementModelList = MDPCompiler.getModelsForSubdocument(document);
            return new InputGroupModel(textBlockModel.getMdpTag(), this.outlineElementModelList);
        }
    }

}
