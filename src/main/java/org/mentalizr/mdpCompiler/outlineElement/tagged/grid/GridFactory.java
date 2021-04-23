package org.mentalizr.mdpCompiler.outlineElement.tagged.grid;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class GridFactory extends OutlineElementFactory {

    public GridFactory() {
        super(Grid.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new Grid();
    }
}
