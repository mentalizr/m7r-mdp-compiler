package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public class Audio extends OutlineElementTagged {

    public static final String TAG = "@audio";

    public Audio(Line currentLine) throws MDPSyntaxError {
        super(TAG, currentLine);
    }

    @Override
    protected boolean withLink() {
        return true;
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new AudioAttributesFactory();
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new AudioExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        AudioAttributes audioAttributes = (AudioAttributes) this.outlineElementTaggedAttributes;
        return new AudioModelBuilder(audioAttributes);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        AudioAttributes audioAttributes = (AudioAttributes) this.outlineElementTaggedAttributes;
        AudioModel audioModel = (AudioModel) this.outlineElementModel;
        String mdpLinkString = this.mdpTag.getLinkString();
        return new AudioRenderer(audioAttributes, audioModel, mdpLinkString);
    }
}
