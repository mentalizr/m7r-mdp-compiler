package org.mentalizr.mdpCompiler.inlineElement.link.externalLink;

import org.mentalizr.mdpCompiler.inlineElement.link.LinkParser;

public class ExternalLinkParser extends LinkParser {

    public ExternalLinkParser() {
        super("[", new ExternalLinkLineRenderer());
    }
}
