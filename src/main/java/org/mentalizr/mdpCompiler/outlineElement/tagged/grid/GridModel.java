package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.ArrayList;
import java.util.List;

public class GridModel extends OutlineElementTaggedModel {

    private final List<ColumnContent> columnContentList;

    public GridModel() {
        super(new Grid());
        this.columnContentList = new ArrayList<>();
    }

    public void addColumnContent(ColumnContent columnContent) {
        this.columnContentList.add(columnContent);
    }

    public List<ColumnContent> getColumnContentList() {
        return this.columnContentList;
    }

    public GridAttributes getGridAttributes() {
        return (GridAttributes) this.mdpTag.getAttributes();
    }

}
