package org.mentalizr.mdpCompiler.inlineElement.inlineParser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InlineParserTest {

    @Test
    @DisplayName("Markdown 3-Star")
    void parse() {

        InlineParserConfig inlineParserConfig = new InlineParserConfig("***", "***", "<em><strong>", "</em></strong>");
        InlineParser inlineParser = new InlineParser(inlineParserConfig, innerToken -> innerToken);

        String out = inlineParser.parse("Hier steht etwas in ***stark-kursiv*** oder?");
        assertEquals("Hier steht etwas in <em><strong>stark-kursiv</em></strong> oder?", out);

        out = inlineParser.parse("Hier steht etwas am Ende in ***stark-kursiv***");
        assertEquals("Hier steht etwas am Ende in <em><strong>stark-kursiv</em></strong>", out);

        out = inlineParser.parse("***stark-kursiv*** am Anfang!");
        assertEquals("<em><strong>stark-kursiv</em></strong> am Anfang!", out);

        out = inlineParser.parse("***stark-kursiv***");
        assertEquals("<em><strong>stark-kursiv</em></strong>", out);

        out = inlineParser.parse("Hier steht etwas in ***stark-kursiv*** und ***nochmal in stark-kursiv*** oder?");
        assertEquals("Hier steht etwas in <em><strong>stark-kursiv</em></strong> und <em><strong>nochmal in stark-kursiv</em></strong> oder?", out);
    }

    @Test
    @DisplayName("Markdown 2-Star")
    void parse2Star() {

        InlineParserConfig inlineParserConfig = new InlineParserConfig("**", "**", "<strong>", "</strong>");
        InlineParser inlineParser = new InlineParser(inlineParserConfig, innerToken -> innerToken);

        String out = inlineParser.parse("Hier steht etwas in **stark** oder?");
        assertEquals("Hier steht etwas in <strong>stark</strong> oder?", out);

        out = inlineParser.parse("Hier steht etwas am Ende in **stark**");
        assertEquals("Hier steht etwas am Ende in <strong>stark</strong>", out);

        out = inlineParser.parse("**stark** am Anfang!");
        assertEquals("<strong>stark</strong> am Anfang!", out);

        out = inlineParser.parse("**stark**");
        assertEquals("<strong>stark</strong>", out);

        out = inlineParser.parse("Hier steht etwas in **stark** und **nochmal in stark** oder?");
        assertEquals("Hier steht etwas in <strong>stark</strong> und <strong>nochmal in stark</strong> oder?", out);
    }

    @Test
    @DisplayName("Markdown 1-Star")
    void parse1Star() {

        InlineParserConfig inlineParserConfig = new InlineParserConfig("*", "*", "<em>", "</em>");
        InlineParser inlineParser = new InlineParser(inlineParserConfig, innerToken -> innerToken);

        String out = inlineParser.parse("Hier steht etwas in *kursiv* oder?");
        assertEquals("Hier steht etwas in <em>kursiv</em> oder?", out);

        out = inlineParser.parse("Hier steht etwas am Ende in *kursiv*");
        assertEquals("Hier steht etwas am Ende in <em>kursiv</em>", out);

        out = inlineParser.parse("*kursiv* am Anfang!");
        assertEquals("<em>kursiv</em> am Anfang!", out);

        out = inlineParser.parse("*kursiv*");
        assertEquals("<em>kursiv</em>", out);

        out = inlineParser.parse("Hier steht etwas in *kursiv* und *nochmal in kursiv* oder?");
        assertEquals("Hier steht etwas in <em>kursiv</em> und <em>nochmal in kursiv</em> oder?", out);
    }

}