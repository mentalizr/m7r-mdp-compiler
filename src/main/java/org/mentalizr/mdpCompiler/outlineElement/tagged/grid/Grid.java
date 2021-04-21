package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;

public class Grid extends OutlineElementTagged {

    public static final String TAG = "@grid";

    public Grid(Line tagLine) throws MDPSyntaxError {
        super(TAG, tagLine);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new GridExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        GridAttributes gridAttributes = (GridAttributes) this.outlineElementTaggedAttributes;
        return new GridModelBuilder(gridAttributes);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        GridAttributes gridAttributes = (GridAttributes) this.outlineElementTaggedAttributes;
        GridModel gridModel = (GridModel) this.outlineElementModel;
        return new GridRenderer(gridAttributes, gridModel);
    }

    @Override
    protected OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new GridAttributesFactory();
    }

}
