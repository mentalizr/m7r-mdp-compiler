package org.mentalizr.mdpCompiler.inlineElement.link.infoLink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfoLinkParserTest {

    @Test
    void parse() {
        InfoLinkParser infoLinkParser = new InfoLinkParser();
        String line = "Here some text with a @info[special info](1) within.";
        String result = infoLinkParser.parse(line);

        assertEquals("Here some text with a <a href=\"#\" id=\"infolink_1\" class=\"infolink\">special info</a> within.", result);
    }

}