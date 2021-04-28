package org.mentalizr.mdpCompiler.outlineElement.tagged;

import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.List;

public class SubModels extends OutlineElementTaggedModel {

    private final List<OutlineElementModel> childModels;

    public SubModels(OutlineElement outlineElement, MDPTag mdpTag, List<OutlineElementModel> childModels) {
        super(outlineElement);
        setMdpTag(mdpTag);
        this.childModels = childModels;
    }

    public List<OutlineElementModel> getChildModels() {
        if (this.childModels == null)
            throw new IllegalStateException("No child models existing. Check before calling.");
        return this.childModels;
    }

}
