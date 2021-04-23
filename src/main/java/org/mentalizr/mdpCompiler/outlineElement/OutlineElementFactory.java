package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.result.Result;

public abstract class OutlineElementFactory {

    protected String prefix;

    public OutlineElementFactory(String prefix) {
        this.prefix = prefix;
    }

    public boolean isResponsible(Line line) {
        return line.asString().startsWith(this.prefix);
    }

    public abstract OutlineElement getInstance();

}
