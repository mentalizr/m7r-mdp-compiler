package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.*;
import java.util.stream.Collectors;

public class DomImpl implements Dom {

    private final List<OutlineElementModel> outlineElementModels;

    public DomImpl() {
        this.outlineElementModels = new ArrayList<>();
    }

    @Override
    public void addOutlineElementModel(OutlineElementModel outlineElementModel) {
        this.outlineElementModels.add(outlineElementModel);
    }

    @Override
    public List<OutlineElementModel> getOutlineElementModels() {
        return this.outlineElementModels;
    }

    @Override
    public Set<String> getReferencedMediaResources() {
        return this.outlineElementModels.stream()
                .map(OutlineElementModel::getMediaResources)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

}
