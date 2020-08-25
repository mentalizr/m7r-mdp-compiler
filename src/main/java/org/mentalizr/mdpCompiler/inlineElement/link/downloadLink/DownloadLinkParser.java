package org.mentalizr.mdpCompiler.inlineElement.link.downloadLink;

import org.mentalizr.mdpCompiler.inlineElement.link.MDPLinkParser;

public class DownloadLinkParser extends MDPLinkParser {

    public DownloadLinkParser() {
        super("download", new DownloadLinkLineRenderer());
    }
}
