package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModelBuilder;

import java.util.List;

public class ImgTextModelBuilder extends TextBlockModelBuilder {

    public ImgTextModelBuilder() {
        super(new ImgText());
    }

    @Override
    public ImgTextModel getModel(Extraction extraction) throws MDPSyntaxError {
        TextBlockModel textBlockModel = (TextBlockModel) super.getModel(extraction);
        Document document = textBlockModel.asDocument();
        List<OutlineElementModel> childElements = MDPCompiler.getModelsForSubdocument(document);
        return new ImgTextModel(textBlockModel.getMdpTag(), childElements);
    }

}
