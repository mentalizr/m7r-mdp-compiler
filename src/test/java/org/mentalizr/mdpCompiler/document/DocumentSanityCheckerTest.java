package org.mentalizr.mdpCompiler.document;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentSanityCheckerTest {

    @Test
    void plausibility() throws MDPSyntaxError {
        Line line = Line.createLine0("Nothing illegal.");
        DocumentSanityChecker.checkLine(line);
    }

    @Test
    void tabAtFirstPosition() {
        Line line = Line.createLine0("\tTab here.");
        System.out.println(line.asString());
        try {
            DocumentSanityChecker.checkLine(line);
            fail("exception excpected");
        } catch (MDPSyntaxError mdpSyntaxError) {
            // do intentionally nothing
            System.out.println(mdpSyntaxError.getMessage());
        }
    }

    @Test
    void tabMiddlePosition() {
        Line line = Line.createLine0("Tab here\t123");
        System.out.println(line.asString());
        try {
            DocumentSanityChecker.checkLine(line);
            fail("exception excpected");
        } catch (MDPSyntaxError mdpSyntaxError) {
            // do intentionally nothing
            System.out.println(mdpSyntaxError.getMessage());
        }
    }

    @Test
    void tabEndPosition() {
        Line line = Line.createLine0("Tab here\t");
        System.out.println(line.asString());
        try {
            DocumentSanityChecker.checkLine(line);
            fail("exception excpected");
        } catch (MDPSyntaxError mdpSyntaxError) {
            // do intentionally nothing
            System.out.println(mdpSyntaxError.getMessage());
        }
    }

    @Test
    void indentation4() throws MDPSyntaxError {
        Line line = Line.createLine0("    legal indentation");
        DocumentSanityChecker.checkLine(line);
    }

    @Test
    void indentation8() throws MDPSyntaxError {
        Line line = Line.createLine0("        legal indentation");
        DocumentSanityChecker.checkLine(line);
    }

    @Test
    void indentation7() {
        Line line = Line.createLine0("       illegal indentation");
        try {
            DocumentSanityChecker.checkLine(line);
        } catch (MDPSyntaxError mdpSyntaxError) {
            // din
        }
    }

}