package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public class ImgCenter extends OutlineElementTagged {

    public static final String TAG = "@img-center";

    public ImgCenter(Line tagLine) throws MDPSyntaxError {
        super(TAG, tagLine);
    }

    @Override
    protected boolean withLink() {
        return true;
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new ImgCenterAttributesFactory();
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new ImgCenterExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        ImgCenterAttributes imgCenterAttributes = (ImgCenterAttributes) this.outlineElementTaggedAttributes;
        return new ImgCenterModelBuilder(imgCenterAttributes);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        ImgCenterAttributes imgCenterAttributes = (ImgCenterAttributes) this.outlineElementTaggedAttributes;
        ImgCenterModel imgCenterModel = (ImgCenterModel) this.outlineElementModel;
        String mdpLinkString = this.mdpTag.getLinkString();
        return new ImgCenterRenderer(imgCenterAttributes, imgCenterModel, mdpLinkString);
    }
}
