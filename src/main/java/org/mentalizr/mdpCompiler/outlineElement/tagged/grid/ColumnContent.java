package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ColumnContent {

    private final String classValue;
    private final List<OutlineElementModel> childElements;

    public ColumnContent(String classValue, List<OutlineElementModel> childElements) {
        this.classValue = classValue;
        this.childElements = childElements;
    }

    public String getClassValue() {
        return this.classValue;
    }

    public List<OutlineElementModel> getChildElements() {
        return this.childElements;
    }

    public Set<String> getMediaResources() {
        Set<String> mediaResources = new HashSet<>();
        for (OutlineElementModel outlineElementModel : this.childElements) {
            mediaResources.addAll(outlineElementModel.getMediaResources());
        }
        return mediaResources;
    }

}
