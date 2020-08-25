package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.inlineElement.inlineParser.InlineParserMDP;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
class InlineParserMDPTest {

    @Test
    void mdInline() {

        InlineParserMDP inlineParserMDP = new InlineParserMDP();
        String out = inlineParserMDP.parse("Hier steht etwas in *kursiv* und **stark** und ***stark-kursiv*** und `code` in einer Zeile.");

        System.out.println(out);

        assertEquals(
                "Hier steht etwas in <em>kursiv</em> und <strong>stark</strong> und <em><strong>stark-kursiv</strong></em> und <code>code</code> in einer Zeile.",
                out);
    }

    @Test
    void infoLink() {

        InlineParserMDP inlineParserMDP = new InlineParserMDP();
        String out = inlineParserMDP.parse("This is a line with a @info[included info link.](1)");

        System.out.println(out);

        assertEquals(
                "This is a line with a <a href=\"#\" id=\"infolink_1\" class=\"infolink\">included info link.</a>",
                out);
    }

}