package org.mentalizr.mdpCompiler.outlineElement.md.ul;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.ArrayList;
import java.util.List;

public class ULModel extends OutlineElementModel {

    private final List<String> itemList;

    public ULModel() {
        super(new UL());
        this.itemList = new ArrayList<>();
    }

    public void addItem(String item) {
        this.itemList.add(item);
    }

    public List<String> getItemList() {
        return this.itemList;
    }

}
