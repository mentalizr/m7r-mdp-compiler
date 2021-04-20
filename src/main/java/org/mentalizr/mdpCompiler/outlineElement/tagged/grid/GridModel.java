package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.ArrayList;
import java.util.List;

public class GridModel extends OutlineElementModel {

    private final List<ColumnContent> columnContentList;
    private ColumnContent curColumnContent;

    public GridModel() {
        this.columnContentList = new ArrayList<>();
        this.curColumnContent = null;
    }

    public void createNextColumn(String classValue) {
        this.curColumnContent = new ColumnContent(classValue);
        this.columnContentList.add(this.curColumnContent);
    }

    public void addContentLine(Line lineOfContent) {
        this.curColumnContent.add(lineOfContent);
    }

    public List<ColumnContent> getColumnContentList() {
        return columnContentList;
    }

    public boolean hasCurCard() {
        return this.curColumnContent != null;
    }
}
