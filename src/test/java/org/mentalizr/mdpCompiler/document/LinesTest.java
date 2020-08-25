package org.mentalizr.mdpCompiler.document;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinesTest {

    @Test
    void create() {

        List<String> lines = Arrays.asList(
                "erste Zeile",
                "zweite Zeile",
                "dritte Zeile"
        );

        List<Line> lineList = Lines.create(lines, 1);

        assertEquals(lineList.size(), 3);

        assertEquals("erste Zeile", lineList.get(0).asString());
        assertEquals(1, lineList.get(0).getLineIndex());

        assertEquals("zweite Zeile", lineList.get(1).asString());
        assertEquals(2, lineList.get(1).getLineIndex());

        assertEquals("dritte Zeile", lineList.get(2).asString());
        assertEquals(3, lineList.get(2).getLineIndex());
    }

}