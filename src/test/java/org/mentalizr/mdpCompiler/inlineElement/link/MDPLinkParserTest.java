package org.mentalizr.mdpCompiler.inlineElement.link;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MDPLinkParserTest {

    private static class TestMDPLinkParser extends MDPLinkParser {

        public TestMDPLinkParser(String inlineTagName, LinkLineRendererInterface linkLineRendererImpl) {
            super(inlineTagName, linkLineRendererImpl);
        }
    }

    @Test
    void parse() {

        LinkLineRendererInterface testLinkLineRenderer = new TestLinkLineRenderer();
        MDPLinkParser mdpLinkParser = new TestMDPLinkParser("inlineTag", testLinkLineRenderer);

        String result = mdpLinkParser.parse("Im Informationstext @inlineTag[Was ist eigentlich mit mir los?](1) erhalten Sie einen Überblick");

        assertEquals("Im Informationstext [*]Was ist eigentlich mit mir los?[*]1[*] erhalten Sie einen Überblick", result);
    }

}