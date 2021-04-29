package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.ArrayList;
import java.util.List;

public class Dom {

    private final List<OutlineElementModel> outlineElementModels;

    public Dom() {
        this.outlineElementModels = new ArrayList<>();
    }

    public void addOutlineElementModel(OutlineElementModel outlineElementModel) {
        this.outlineElementModels.add(outlineElementModel);
    }

    public List<OutlineElementModel> getOutlineElementModels() {
        return this.outlineElementModels;
    }

}
