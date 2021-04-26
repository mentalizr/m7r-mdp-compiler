package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModelBuilder;

import java.util.ArrayList;
import java.util.List;

public class CardModelBuilder extends TextBlockModelBuilder {

    private List<OutlineElementModel> outlineElementModelList;

    public CardModelBuilder(OutlineElementTagged outlineElementTagged) {
        //TODO: super(new Card()), Constructor parameter löschen
        super(outlineElementTagged);
        this.outlineElementModelList = new ArrayList<>();
    }

    @Override
    public CardModel getModel(Extraction extraction) throws MDPSyntaxError {
        TextBlockModel textBlockModel = (TextBlockModel) super.getModel(extraction);
        if (textBlockModel.getNrOfTextBlockLines() == 1) {
            return new CardModel(textBlockModel.getMdpTag(), textBlockModel.getSingleLineAsString());
        } else {
            Document document = textBlockModel.asDocument();
            this.outlineElementModelList = MDPCompiler.getModelsForSubdocument(document);
            return new CardModel(textBlockModel.getMdpTag(), this.outlineElementModelList);
        }
    }

}
