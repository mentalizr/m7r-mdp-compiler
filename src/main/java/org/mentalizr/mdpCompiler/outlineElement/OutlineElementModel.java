package org.mentalizr.mdpCompiler.outlineElement;

import java.util.ArrayList;
import java.util.List;

public abstract class OutlineElementModel {

    protected OutlineElement outlineElement;

    public OutlineElementModel(OutlineElement outlineElement) {
        this.outlineElement = outlineElement;
    }

    public OutlineElement getOutlineElement() {
        return this.outlineElement;
    }


//    protected List<OutlineElementModel> childModels;
//
//    public OutlineElementModel() {
//        this.childModels = new ArrayList<>();
//    }
//
//    public OutlineElementModel(List<OutlineElementModel> childModels) {
//        this.childModels = childModels;
//    }
//
//    protected boolean hasChildModels() {
//        return !this.childModels.isEmpty();
//    }
//
//    protected List<OutlineElementModel> getChildModels() {
//        return this.childModels;
//    }

}
