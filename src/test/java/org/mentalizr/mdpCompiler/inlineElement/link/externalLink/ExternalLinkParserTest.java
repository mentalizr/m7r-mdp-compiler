package org.mentalizr.mdpCompiler.inlineElement.link.externalLink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExternalLinkParserTest {

    @Test
    void parse() {
        ExternalLinkParser externalLinkParser = new ExternalLinkParser();
        String result = externalLinkParser.parse("Klicken Sie auf [Diesen Link](example.com) mal drauf.");
        assertEquals("Klicken Sie auf <a href=\"example.com\" class=\"external-link\" target=\"_blank\" rel=\"noreferrer noopener\">Diesen Link</a> mal drauf.", result);
    }

}