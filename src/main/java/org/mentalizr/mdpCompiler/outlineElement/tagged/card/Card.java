package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModelBuilder;

public class Card extends OutlineElementTagged {

    public static final String TAG = "@card";

    public Card(Line tagLine) throws MDPSyntaxError {
        super(TAG, tagLine);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new CardExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        return new TextBlockModelBuilder();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        CardAttributes cardAttributes = (CardAttributes) this.outlineElementTaggedAttributes;
        TextBlockModel textBlockModel = (TextBlockModel) this.outlineElementModel;
        return new CardRenderer(cardAttributes, textBlockModel);
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new CardAttributesFactory();
    }
}
