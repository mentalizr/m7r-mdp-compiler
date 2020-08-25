package org.mentalizr.mdpCompiler.outlineElement.md.table;

import java.util.ArrayList;
import java.util.List;

public class TableModelColMetaData {

    public enum Alignment { LEFT, RIGHT, CENTER}

    private final List<Alignment> colMeta;

    public TableModelColMetaData() {
        this.colMeta = new ArrayList<>();
    }

    public void addColAlignLeft() {
        this.colMeta.add(Alignment.LEFT);
    }

    public void addColAlignRight() {
        this.colMeta.add(Alignment.RIGHT);
    }

    public void addColAlignCenter() {
        this.colMeta.add(Alignment.CENTER);
    }

    public int getNrCols() {
        return this.colMeta.size();
    }

    public Alignment getAlignment(int i) {
        if (i >= this.colMeta.size()) throw new IllegalStateException();
        return this.colMeta.get(i);
    }

}
