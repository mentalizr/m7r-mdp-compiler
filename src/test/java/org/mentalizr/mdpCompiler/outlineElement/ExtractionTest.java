package org.mentalizr.mdpCompiler.outlineElement;

import org.junit.jupiter.api.Test;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.document.Lines;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgText.ImgTextExtraction;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExtractionTest {

    @Test
    void getLinesWithoutTagLine() {

        List<Line> lines = Lines.create("line 1", "line 2", "line 3");

        Extraction extraction = new ImgTextExtraction(lines);

        List<Line> linesWithoutTagLine = extraction.getLinesWithoutTagLine();

        for (Line line : linesWithoutTagLine) {
            System.out.println(line.toString());
        }

        assertEquals(2, linesWithoutTagLine.size());
        assertEquals("line 2", linesWithoutTagLine.get(0).asString());
        assertEquals("line 3", linesWithoutTagLine.get(1).asString());
    }

}