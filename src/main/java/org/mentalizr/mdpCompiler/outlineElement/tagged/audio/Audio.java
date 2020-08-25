package org.mentalizr.mdpCompiler.outlineElement.tagged.audio;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyLinesExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class Audio extends OutlineElementTagged {

    public static final String TAG = "@audio";

    public Audio(DocumentIterator documentIterator, Result result) throws MDPSyntaxError {
        super(TAG, result, documentIterator);
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
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new MDPTagOnlyLinesExtractor(this.documentIterator);
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        AudioAttributes audioAttributes = (AudioAttributes) this.outlineElementTaggedAttributes;
        return new AudioModelBuilder(audioAttributes, this.outlineElementLines);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        AudioAttributes audioAttributes = (AudioAttributes) this.outlineElementTaggedAttributes;
        AudioModel audioModel = (AudioModel) this.outlineElementModel;
        String mdpLinkString = this.mdpTag.getLinkString();
        return new AudioRenderer(this.result, audioAttributes, audioModel, mdpLinkString);
    }
}
