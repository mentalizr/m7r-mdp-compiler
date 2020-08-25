package org.mentalizr.mdpCompiler.mdpTag;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MDPTagSimpleWithLinkTest {

    @Test
    @DisplayName("Plausibilitätstest")
    void test() throws MDPSyntaxError {
        Line educt = Line.createLine0("@img-fluid[alt=\"Ein alternativer Text\"](link)");
        MDPTagWithLink mdpTag = new MDPTagWithLink("img-fluid", educt);
        assertEquals("alt=\"Ein alternativer Text\"", mdpTag.getAttributeString());
        assertEquals("link", mdpTag.getLinkString());
    }


}