package org.mentalizr.mdpCompiler.inlineElement.link;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkParserTest {

    private static class TestLinkParser extends LinkParser {

        public TestLinkParser(String prefix, LinkLineRendererInterface linkLineRendererImpl) {
            super(prefix, linkLineRendererImpl);
        }
    }

    @Test
    void parse() {

        LinkLineRendererInterface linkLineRendererTest = new TestLinkLineRenderer();
        TestLinkParser linkParser = new TestLinkParser("[", linkLineRendererTest);

        String result = linkParser.parse("Klicken Sie auf [Diesen Link](example.com) mal drauf.");

        assertEquals("Klicken Sie auf [*]Diesen Link[*]example.com[*] mal drauf.", result);
    }

}