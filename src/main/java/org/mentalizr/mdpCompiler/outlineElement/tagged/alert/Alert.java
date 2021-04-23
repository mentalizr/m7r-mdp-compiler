package org.mentalizr.mdpCompiler.outlineElement.tagged.alert;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public class Alert extends OutlineElementTagged {

    public static final String TAG = "@alert";

    public Alert() {
        super(TAG);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new AlertExtractor();
    }

    @Override
    protected OutlineElementTaggedModelBuilder getOutlineElementModelBuilder() {
        return new AlertModelBuilder(this);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new AlertRenderer();
    }

    @Override
    public OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new AlertAttributesFactory();
    }
}
