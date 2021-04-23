package org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public class ImgCenter extends OutlineElementTagged {

    public static final String TAG = "@img-center";

    public ImgCenter() {
        super(TAG);
    }

    @Override
    public boolean withLink() {
        return true;
    }

    @Override
    public OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new ImgCenterAttributesFactory();
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new ImgCenterExtractor();
    }

    @Override
    protected OutlineElementTaggedModelBuilder getOutlineElementModelBuilder() {
        return new ImgCenterModelBuilder();
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new ImgCenterRenderer();
    }
}
