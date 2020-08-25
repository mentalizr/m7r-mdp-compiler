package org.mentalizr.mdpCompiler.inlineElement.link.downloadLink;

import org.mentalizr.mdpCompiler.inlineElement.link.LinkParserResultForLine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DownloadLinkLineRendererTest {

    @Test
    public void process() {

        LinkParserResultForLine linkParserResultForLine
                = new LinkParserResultForLine(new String[]{"pre", "text", "id", "post"});
        DownloadLinkLineRenderer downloadLinkLineRenderer = new DownloadLinkLineRenderer();
        String result = downloadLinkLineRenderer.process(linkParserResultForLine);

        assertEquals("pre<a href=\"service/v1/mediaAV/id\" class=\"download-link\" download=\"id\">text</a>post", result);
    }

}