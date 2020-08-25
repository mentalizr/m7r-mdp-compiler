package org.mentalizr.mdpCompilerTestResrc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
class DiffHelperTest {

    @Test
    void firstDiffIndex_sameLengthDifferInLastChar() {
        int i = DiffHelper.firstDiffIndex("ABC", "ABB");
        assertEquals(2, i);
    }

    @Test
    void firstDiffIndex_completelyDifferent() {
        int i = DiffHelper.firstDiffIndex("ABC", "BBB");
        assertEquals(0, i);
    }

    @Test
    void firstDiffIndex_probeLonger() {
        int i = DiffHelper.firstDiffIndex("ABC", "ABCD");
        assertEquals(3, i);
    }

    @Test
    void firstDiffIndex_probeShorter() {
        int i = DiffHelper.firstDiffIndex("ABC", "AB");
        assertEquals(2, i);
    }

    @Test
    void firstDiffIndex_Equals() {
        int i = DiffHelper.firstDiffIndex("ABC", "ABC");
        assertEquals(-1, i);
    }

    @Test
    void firstDiffIndex_ReferenceEmpty() {
        int i = DiffHelper.firstDiffIndex("", "ABC");
        assertEquals(0, i);
    }

    @Test
    void firstDiffIndex_ProbeEmpty() {
        int i = DiffHelper.firstDiffIndex("ABC", "");
        assertEquals(0, i);
    }


}