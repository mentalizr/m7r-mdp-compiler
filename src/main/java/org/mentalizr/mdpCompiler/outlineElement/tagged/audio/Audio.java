package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public class Audio extends OutlineElementTagged {

    public static final String TAG = "@audio";

    public Audio() {
        super(TAG);
    }

    @Override
    public boolean withLink() {
        return true;
    }

    @Override
    public OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new AudioAttributesFactory();
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new AudioExtractor();
    }

    @Override
    protected OutlineElementTaggedModelBuilder getOutlineElementModelBuilder() {
        return new AudioModelBuilder();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new AudioRenderer();
    }
}
