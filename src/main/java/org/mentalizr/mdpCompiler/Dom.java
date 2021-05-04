package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.*;
import java.util.stream.Collectors;

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

    public Set<String> getReferencedMediaResources() {
        return this.outlineElementModels.stream()
                .map(OutlineElementModel::getMediaResources)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

}
