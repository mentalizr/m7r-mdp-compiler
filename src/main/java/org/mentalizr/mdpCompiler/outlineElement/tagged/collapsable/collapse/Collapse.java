package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementRenderer;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableAttributesFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableExtractor;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.CollapsableModelBuilder;

public class Collapse extends OutlineElementTagged {

    public static final String TAG = "@collapse";

    public Collapse() {
        super(TAG);
    }

    @Override
    protected OutlineElementExtractor getOutlineElementLinesExtractor() {
        return new CollapsableExtractor();
    }

    @Override
    protected OutlineElementTaggedModelBuilder getOutlineElementModelBuilder() {
        return new CollapsableModelBuilder(this);
    }

    @Override
    protected OutlineElementRenderer getOutlineElementRenderer() {
        return new CollapseRenderer();
    }

    @Override
    public OutlineElementTaggedAttributesFactory getOutlineElementTaggedAttributesFactory() {
        return new CollapsableAttributesFactory();
    }

}
