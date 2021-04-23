package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.TextBlockModelBuilder;

public class Card extends OutlineElementTagged {

    public static final String TAG = "@card";

    public Card() {
        super(TAG);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new CardExtractor();
    }

    @Override
    protected OutlineElementTaggedModelBuilder getOutlineElementModelBuilder() {
        return new TextBlockModelBuilder(this);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new CardRenderer();
    }

    @Override
    public OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new CardAttributesFactory();
    }
}
