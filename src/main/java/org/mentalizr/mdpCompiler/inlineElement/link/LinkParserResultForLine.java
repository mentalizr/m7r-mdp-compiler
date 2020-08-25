package org.mentalizr.mdpCompiler.inlineElement.link;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;

public class LinkParserResultForLine {

    private final String pre;
    private final String text;
    private final String id;
    private final String post;

    public LinkParserResultForLine(String[] paras) {

        AssertMethodPrecondition.parameterNotNull("paras", paras);

        if (paras.length != 4) throw new RuntimeException("Anzahl der Parameter falsch.");

        this.pre = paras[0];
        this.text = paras[1];
        this.id = paras[2];
        this.post = paras[3];
    }

    public String getPre() {
        return pre;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public String getPost() {
        return post;
    }
}
