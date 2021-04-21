package org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public class ImgFluid extends OutlineElementTagged {

    public static final String TAG = "@img-fluid";

    public ImgFluid(Line tagLine) throws MDPSyntaxError {
        super(TAG, tagLine);
    }

    @Override
    protected boolean withLink() {
        return true;
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new ImgFluidAttributesFactory();
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new ImgFluidExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        ImgFluidAttributes imgFluidAttributes = (ImgFluidAttributes) this.outlineElementTaggedAttributes;
        return new ImgFluidModelBuilder(imgFluidAttributes);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        ImgFluidAttributes imgFluidAttributes = (ImgFluidAttributes) this.outlineElementTaggedAttributes;
        ImgFluidModel imgFluidModel = (ImgFluidModel) this.outlineElementModel;
        String mdpLinkString = this.mdpTag.getLinkString();
        return new ImgFluidRenderer(imgFluidAttributes, imgFluidModel, mdpLinkString);
    }
}
