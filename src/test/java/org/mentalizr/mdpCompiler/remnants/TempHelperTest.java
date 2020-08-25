package org.mentalizr.mdpCompiler.remnants;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
class TempHelperTest {

    @Test
    void splitAtDelimiters_Plausi01() {

        String string = "Dies.ist.ein.Test";
        List<String> splitString = TempHelper.splitAtDelimiters(string, ".");

        assertEquals(4, splitString.size());
        assertEquals("Dies", splitString.get(0));
        assertEquals("ist", splitString.get(1));
        assertEquals("ein", splitString.get(2));
        assertEquals("Test", splitString.get(3));
    }

    @Test
    void splitAtDelimiters_Minimal() {

        String string = ".";
        List<String> splitString = TempHelper.splitAtDelimiters(string, ".");

        assertEquals(0, splitString.size());
    }

    @Test
    void splitAtDelimiters_StartWithDelimiter() {

        String string = ".aha";
        List<String> splitString = TempHelper.splitAtDelimiters(string, ".");

        assertEquals(1, splitString.size());
        assertEquals("aha", splitString.get(0));
    }

    @Test
    void splitAtDelimiters_StopWithDelimiter() {

        String string = "aha.";
        List<String> splitString = TempHelper.splitAtDelimiters(string, ".");

        assertEquals(1, splitString.size());
        assertEquals("aha", splitString.get(0));
    }

    @Test
    void splitAtDelimiters_StartAndStopWithDelimiter1() {

        String string = ".aha.";
        List<String> splitString = TempHelper.splitAtDelimiters(string, ".");

        assertEquals(1, splitString.size());
        assertEquals("aha", splitString.get(0));
    }

    @Test
    void splitAtDelimiters_StartAndStopWithDelimiter2() {

        String string = ".aha.soso.";
        List<String> splitString = TempHelper.splitAtDelimiters(string, ".");

        assertEquals(2, splitString.size());
        assertEquals("aha", splitString.get(0));
        assertEquals("soso", splitString.get(1));
    }

    @Test
    void splitAtDelimiters_consecutiveDelimiters1() {

        String string = ".aha..";
        List<String> splitString = TempHelper.splitAtDelimiters(string, ".");

        assertEquals(1, splitString.size());
        assertEquals("aha", splitString.get(0));
    }

    @Test
    void splitAtDelimiters_consecutiveDelimiters2() {

        String string = "..aha..";
        List<String> splitString = TempHelper.splitAtDelimiters(string, ".");

        assertEquals(1, splitString.size());
        assertEquals("aha", splitString.get(0));
    }

    @Test
    void splitAtDelimiters_consecutiveDelimiters3() {

        String string = ".aha......soso.";
        List<String> splitString = TempHelper.splitAtDelimiters(string, ".");

        assertEquals(2, splitString.size());
        assertEquals("aha", splitString.get(0));
        assertEquals("soso", splitString.get(1));
    }

    @Test
    void splitAtDelimiters_consecutiveDelimiters4() {

        String string = "aha......soso";
        List<String> splitString = TempHelper.splitAtDelimiters(string, ".");

        assertEquals(2, splitString.size());
        assertEquals("aha", splitString.get(0));
        assertEquals("soso", splitString.get(1));
    }

}