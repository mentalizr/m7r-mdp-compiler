package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public Set<String> getMediaResources() {
        Set<String> mediaResources = new HashSet<>();
        for (ColumnContent columnContent : this.columnContentList) {
            mediaResources.addAll(columnContent.getMediaResources());
        }
        return mediaResources;
    }

}
