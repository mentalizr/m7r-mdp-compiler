package org.mentalizr.mdpCompiler;

public class CompilerContext {

    private static final String SERVICE_CONTEXT_URL = "service/v1/";

    private final boolean outerElement;
    private final int indentLevel;

    public CompilerContext(boolean outerElement, int indentLevel) {
        this.outerElement = outerElement;
        this.indentLevel = indentLevel;
    }

    public static CompilerContext getDefaultTestContext() {
        return new CompilerContext(true, 0);
    }

    public boolean isOuterElement() {
        return outerElement;
    }

    public boolean isInnerElement() {
        return !this.outerElement;
    }

    public int getIndentLevel() {
//        return isOuterElement() ? 0 : 1;
        return this.indentLevel;
    }

    public String getServiceContextURL() {
        return SERVICE_CONTEXT_URL;
    }

}
