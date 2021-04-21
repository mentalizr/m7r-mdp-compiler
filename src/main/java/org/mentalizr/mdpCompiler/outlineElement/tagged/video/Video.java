package org.mentalizr.mdpCompiler.outlineElement.tagged.video;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public class Video extends OutlineElementTagged {

    public static final String TAG = "@video";

    public Video(Line tagLine) throws MDPSyntaxError {
        super(TAG, tagLine);
    }

    @Override
    protected boolean withLink() {
        return true;
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new VideoAttributesFactory();
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new VideoExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        VideoAttributes videoAttributes = (VideoAttributes) this.outlineElementTaggedAttributes;
        return new VideoModelBuilder(videoAttributes);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        VideoAttributes videoAttributes = (VideoAttributes) this.outlineElementTaggedAttributes;
        VideoModel videoModel = (VideoModel) this.outlineElementModel;
        String mdpLinkString = this.mdpTag.getLinkString();
        return new VideoRenderer(videoAttributes, videoModel, mdpLinkString);
    }
}
