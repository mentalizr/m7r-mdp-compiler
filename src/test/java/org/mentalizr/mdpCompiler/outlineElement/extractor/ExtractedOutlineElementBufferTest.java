package org.mentalizr.mdpCompiler.outlineElement.extractor;

import org.mentalizr.mdpCompiler.document.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtractedOutlineElementBufferTest {

    @Test
    void stripTrailingEmptyLines1_singleLine() {

        ExtractedOutlineElementBuffer extractedOutlineElementBuffer = new ExtractedOutlineElementBuffer();
        extractedOutlineElementBuffer.add(new Line("Hier steht was", 1));
        extractedOutlineElementBuffer.stripTrailingEmptyLines();

        assertEquals(1, extractedOutlineElementBuffer.getNrOfLines());
        assertEquals("Hier steht was", extractedOutlineElementBuffer.getLines().get(0).asString());
    }

    @Test
    void stripTrailingEmptyLines2_twoLines() {

        ExtractedOutlineElementBuffer extractedOutlineElementBuffer = new ExtractedOutlineElementBuffer();
        extractedOutlineElementBuffer.add(new Line("Hier steht was", 1));
        extractedOutlineElementBuffer.add(new Line("Hier steht noch was", 2));

        extractedOutlineElementBuffer.stripTrailingEmptyLines();

        assertEquals(2, extractedOutlineElementBuffer.getNrOfLines());
        assertEquals("Hier steht was", extractedOutlineElementBuffer.getLines().get(0).asString());
        assertEquals("Hier steht noch was", extractedOutlineElementBuffer.getLines().get(1).asString());
    }

    @Test
    void stripTrailingEmptyLines3_singleTrailingEmptyLine() {

        ExtractedOutlineElementBuffer extractedOutlineElementBuffer = new ExtractedOutlineElementBuffer();
        extractedOutlineElementBuffer.add(new Line("Hier steht was", 1));
        extractedOutlineElementBuffer.add(new Line("Hier steht noch was", 2));
        extractedOutlineElementBuffer.add(new Line("", 3));

        extractedOutlineElementBuffer.stripTrailingEmptyLines();

        assertEquals(2, extractedOutlineElementBuffer.getNrOfLines());
        assertEquals("Hier steht was", extractedOutlineElementBuffer.getLines().get(0).asString());
        assertEquals("Hier steht noch was", extractedOutlineElementBuffer.getLines().get(1).asString());
    }

    @Test
    void stripTrailingEmptyLines4_twoTrailingEmptyLines() {

        ExtractedOutlineElementBuffer extractedOutlineElementBuffer = new ExtractedOutlineElementBuffer();
        extractedOutlineElementBuffer.add(new Line("Hier steht was", 1));
        extractedOutlineElementBuffer.add(new Line("Hier steht noch was", 2));
        extractedOutlineElementBuffer.add(new Line("", 3));
        extractedOutlineElementBuffer.add(new Line("", 4));

        extractedOutlineElementBuffer.stripTrailingEmptyLines();

        assertEquals(2, extractedOutlineElementBuffer.getNrOfLines());
        assertEquals("Hier steht was", extractedOutlineElementBuffer.getLines().get(0).asString());
        assertEquals("Hier steht noch was", extractedOutlineElementBuffer.getLines().get(1).asString());
    }

    @Test
    void stripTrailingEmptyLines5_intermittentEmtpyLine() {

        ExtractedOutlineElementBuffer extractedOutlineElementBuffer = new ExtractedOutlineElementBuffer();
        extractedOutlineElementBuffer.add(new Line("Hier steht was", 1));
        extractedOutlineElementBuffer.add(new Line("", 2));
        extractedOutlineElementBuffer.add(new Line("Hier steht noch was", 3));
        extractedOutlineElementBuffer.add(new Line("", 4));
        extractedOutlineElementBuffer.add(new Line("", 5));

        extractedOutlineElementBuffer.stripTrailingEmptyLines();

        assertEquals(3, extractedOutlineElementBuffer.getNrOfLines());
        assertEquals("Hier steht was", extractedOutlineElementBuffer.getLines().get(0).asString());
        assertEquals("", extractedOutlineElementBuffer.getLines().get(1).asString());
        assertEquals("Hier steht noch was", extractedOutlineElementBuffer.getLines().get(2).asString());
    }

    @Test
    void stripTrailingEmptyLines6_BlankNotEmpty() {

        ExtractedOutlineElementBuffer extractedOutlineElementBuffer = new ExtractedOutlineElementBuffer();
        extractedOutlineElementBuffer.add(new Line("Hier steht was", 1));
        extractedOutlineElementBuffer.add(new Line("", 2));
        extractedOutlineElementBuffer.add(new Line("Hier steht noch was", 3));
        extractedOutlineElementBuffer.add(new Line("", 4));
        extractedOutlineElementBuffer.add(new Line(" ", 5));

        extractedOutlineElementBuffer.stripTrailingEmptyLines();

        assertEquals(3, extractedOutlineElementBuffer.getNrOfLines());
        assertEquals("Hier steht was", extractedOutlineElementBuffer.getLines().get(0).asString());
        assertEquals("", extractedOutlineElementBuffer.getLines().get(1).asString());
        assertEquals("Hier steht noch was", extractedOutlineElementBuffer.getLines().get(2).asString());
    }

}