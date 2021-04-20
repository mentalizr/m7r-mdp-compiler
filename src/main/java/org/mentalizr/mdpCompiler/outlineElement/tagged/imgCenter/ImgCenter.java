package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.MDPTagOnlyLinesExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.result.Result;

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
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new MDPTagOnlyLinesExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        ImgCenterAttributes imgCenterAttributes = (ImgCenterAttributes) this.outlineElementTaggedAttributes;
        return new ImgCenterModelBuilder(imgCenterAttributes, this.outlineElementLines);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        ImgCenterAttributes imgCenterAttributes = (ImgCenterAttributes) this.outlineElementTaggedAttributes;
        ImgCenterModel imgCenterModel = (ImgCenterModel) this.outlineElementModel;
        String mdpLinkString = this.mdpTag.getLinkString();
        return new ImgCenterRenderer(imgCenterAttributes, imgCenterModel, mdpLinkString);
    }
}
