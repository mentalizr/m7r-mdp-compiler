package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.ArrayList;
import java.util.List;

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

}
