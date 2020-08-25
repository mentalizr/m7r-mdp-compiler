package org.mentalizr.mdpCompiler.document;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    @Test
    void createByLines() {

        List<Line> lineList = new ArrayList<>();
        lineList.add(new Line("line1", 0));
        lineList.add(new Line("line2", 1));
        lineList.add(new Line("line3", 2));

        Document document = new Document(lineList);

        check(document);
    }

    @Test
    void createByVarArgs() {

        Document document = new Document(
                "line1",
                "line2",
                "line3"
        );

        check(document);
    }

    @Test
    void createByStringList() {

        Document document = new Document(0, Arrays.asList(
                "line1",
                "line2",
                "line3"
        ));

        check(document);
    }

    @Test
    void provokeInconsistentLineNumber1() {

        List<Line> lineList = new ArrayList<>();
        lineList.add(new Line("line1", 0));
        lineList.add(new Line("line2", 2));
        lineList.add(new Line("line3", 3));

        try {
            new Document(lineList);
            fail("exception expected");
        } catch (IllegalArgumentException e) {
            // do intentionally nothing
        }
    }

    @Test
    void provokeInconsistentLineNumber2() {

        List<Line> lineList = new ArrayList<>();
        lineList.add(new Line("line1", 0));
        lineList.add(new Line("line2", 1));
        lineList.add(new Line("line3", 1));

        try {
            new Document(lineList);
            fail("exception expected");
        } catch (IllegalArgumentException e) {
            // do intentionally nothing
        }
    }

    private void check(Document document) {
        List<Line> lineList = document.getLines();

        assertNotNull(lineList);
        assertEquals(3, lineList.size());

        Line line = lineList.get(0);
        assertEquals(0, line.getLineIndex());
        assertEquals(1, line.getLineNr());
        assertEquals("line1", line.asString());

        line = lineList.get(1);
        assertEquals(1, line.getLineIndex());
        assertEquals(2, line.getLineNr());
        assertEquals("line2", line.asString());

        line = lineList.get(2);
        assertEquals(2, line.getLineIndex());
        assertEquals(3, line.getLineNr());
        assertEquals("line3", line.asString());
    }

}