package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.List;
import java.util.Set;

public interface Dom {

    void addOutlineElementModel(OutlineElementModel outlineElementModel);

    List<OutlineElementModel> getOutlineElementModels();

    Set<String> getReferencedMediaResources();
}
