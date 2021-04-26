package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.document.Line;

import java.util.Objects;

public abstract class OutlineElementFactory {

    protected String prefix;

    public OutlineElementFactory(String prefix) {
        this.prefix = prefix;
    }

    public boolean isResponsible(Line line) {
        return line.asString().startsWith(this.prefix);
    }

    public abstract OutlineElement getInstance();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutlineElementFactory that = (OutlineElementFactory) o;
        return prefix.equals(that.prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix);
    }
}
