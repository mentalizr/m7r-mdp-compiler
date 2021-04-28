package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.ArrayList;
import java.util.List;

public class GridLineModel {

    private final List<ColumnLineContent> columnContentList;
    private ColumnLineContent curColumnContent;

    public GridLineModel() {
        this.columnContentList = new ArrayList<>();
        this.curColumnContent = null;
    }

    public void createNextColumn(String classValue) {
        this.curColumnContent = new ColumnLineContent(classValue);
        this.columnContentList.add(this.curColumnContent);
    }

    public void addContentLine(Line lineOfContent) {
        this.curColumnContent.add(lineOfContent);
    }

    public List<ColumnLineContent> getColumnContentList() {
        return columnContentList;
    }

    public boolean hasCurCard() {
        return this.curColumnContent != null;
    }

}
