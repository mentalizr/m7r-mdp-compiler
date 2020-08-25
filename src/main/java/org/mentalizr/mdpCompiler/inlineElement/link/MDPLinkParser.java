package org.mentalizr.mdpCompiler.inlineElement.link;

public abstract class MDPLinkParser extends LinkParser {

    public MDPLinkParser(String inlineTagName, LinkLineRendererInterface linkLineRendererImpl) {
        super("@" + inlineTagName + "[", linkLineRendererImpl);
    }

}
