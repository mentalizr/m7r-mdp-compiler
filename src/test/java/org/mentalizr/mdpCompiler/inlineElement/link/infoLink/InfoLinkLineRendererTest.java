package org.mentalizr.mdpCompiler.inlineElement.link.infoLink;

import org.mentalizr.mdpCompiler.inlineElement.link.LinkParserResultForLine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfoLinkLineRendererTest {

    @Test
    public void process() {

        LinkParserResultForLine linkParserResultForLine = new LinkParserResultForLine(new String[]{"pre", "text", "id", "post"});
        InfoLinkLineRenderer infoLinkLineRenderer = new InfoLinkLineRenderer();
        String result = infoLinkLineRenderer.process(linkParserResultForLine);

        assertEquals("pre<a href=\"#\" id=\"infolink_id\" class=\"infolink\">text</a>post", result);
    }

}