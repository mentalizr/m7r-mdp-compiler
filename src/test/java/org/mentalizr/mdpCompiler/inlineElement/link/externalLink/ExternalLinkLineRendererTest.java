package org.mentalizr.mdpCompiler.inlineElement.link.externalLink;

import org.mentalizr.mdpCompiler.inlineElement.link.LinkParserResultForLine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExternalLinkLineRendererTest {

    @Test
    public void process() {

        LinkParserResultForLine linkParserResultForLine
                = new LinkParserResultForLine(new String[]{"pre", "text", "id", "post"});
        ExternalLinkLineRenderer externalLinkLineRenderer = new ExternalLinkLineRenderer();
        String result = externalLinkLineRenderer.process(linkParserResultForLine);

        assertEquals("pre<a href=\"id\" class=\"external-link\" target=\"_blank\" rel=\"noreferrer noopener\">text</a>post", result);
    }

}