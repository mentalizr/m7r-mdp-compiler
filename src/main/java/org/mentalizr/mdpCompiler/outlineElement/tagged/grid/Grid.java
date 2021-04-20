package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementLinesExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.result.Result;

public class Grid extends OutlineElementTagged {

    public static final String TAG = "@grid";

    public Grid(Line tagLine) throws MDPSyntaxError {
        super(TAG, tagLine);
    }

    @Override
    protected OutlineElementLinesExtractor getOutlineElementLinesExtractor() {
        return new GridLinesExtractor();
    }

    @Override
    protected OutlineElementModelBuilder getOutlineElementModelBuilder() {
        GridAttributes gridAttributes = (GridAttributes) this.outlineElementTaggedAttributes;
        return new GridModelBuilder(gridAttributes, this.outlineElementLines);
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
