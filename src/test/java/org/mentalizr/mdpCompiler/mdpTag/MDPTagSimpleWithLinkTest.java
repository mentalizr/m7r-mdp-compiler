package org.mentalizr.mdpCompiler.mdpTag;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid.ImgFluid;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MDPTagSimpleWithLinkTest {

    @Test
    @DisplayName("Plausibilitätstest")
    void test() throws MDPSyntaxError {
        Line educt = Line.createLine0("@img-fluid[alt=\"Ein alternativer Text\"](link)");
        MDPTagWithLink mdpTag = new MDPTagWithLink(new ImgFluid(), educt);
        assertEquals("alt=\"Ein alternativer Text\"", mdpTag.getAttributeString());
        assertEquals("link", mdpTag.getLinkString());
    }

}