package org.mentalizr.mdpCompiler.inlineElement.link.infoLink;

import org.mentalizr.mdpCompiler.inlineElement.link.MDPLinkParser;

public class InfoLinkParser extends MDPLinkParser {

    public InfoLinkParser() {
        super("info", new InfoLinkLineRenderer());
    }
}
