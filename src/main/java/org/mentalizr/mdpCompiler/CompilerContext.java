package org.mentalizr.mdpCompiler;

public class CompilerContext {

    private static final String SERVICE_CONTEXT_URL = "service/v1/";
    private static final String MEDIA_CONTEXT_URL = "media/";

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
        return this.indentLevel;
    }

    public String getServiceContextURL() {
        return SERVICE_CONTEXT_URL;
    }

    public String getMediaContextUrl() {
        return MEDIA_CONTEXT_URL;
    }

}
