package org.mentalizr.mdpCompiler.valueExtractor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
class ValueExtractorTest {

    @DisplayName("Wert in der Mitte")
    @Test
    void wertInDerMitte() {
        String test = "adfdsf \"Wert\"lkj";
        ValueExtractor valueExtractor = new ValueExtractor(test, '"', '\\');
        assertTrue(valueExtractor.hasValue());
        assertEquals("Wert", valueExtractor.getValue());
        assertEquals(7, valueExtractor.getStartIndex());
        assertEquals(12, valueExtractor.getStopIndex());
    }

    @DisplayName("Wert am Anfang")
    @Test
    void wertAmAnfang() {
        String test = "\"Wert\"lkj";
        ValueExtractor valueExtractor = new ValueExtractor(test, '"', '\\');
        assertTrue(valueExtractor.hasValue());
        assertEquals("Wert", valueExtractor.getValue());
        assertEquals(0, valueExtractor.getStartIndex());
        assertEquals(5, valueExtractor.getStopIndex());
    }

    @DisplayName("Wert am Ende")
    @Test
    void wertAmEnde() {
        String test = "asdfa\"Wert\"";
        ValueExtractor valueExtractor = new ValueExtractor(test, '"', '\\');
        assertTrue(valueExtractor.hasValue());
        assertEquals("Wert", valueExtractor.getValue());
        assertEquals(5, valueExtractor.getStartIndex());
        assertEquals(10, valueExtractor.getStopIndex());
    }

    @DisplayName("Nur Wert")
    @Test
    void nurWert() {
        String test = "\"Wert\"";
        ValueExtractor valueExtractor = new ValueExtractor(test, '"', '\\');
        assertTrue(valueExtractor.hasValue());
        assertEquals("Wert", valueExtractor.getValue());
        assertEquals(0, valueExtractor.getStartIndex());
        assertEquals(5, valueExtractor.getStopIndex());
    }

    @DisplayName("Kein Wert 1")
    @Test
    void keinWert1() {
        String test = "Wert\"";
        ValueExtractor valueExtractor = new ValueExtractor(test, '"', '\\');
        assertFalse(valueExtractor.hasValue());
    }

    @DisplayName("Kein Wert 2")
    @Test
    void keinWert2() {
        String test = "\"Wert";
        ValueExtractor valueExtractor = new ValueExtractor(test, '"', '\\');
        assertFalse(valueExtractor.hasValue());
    }

    @DisplayName("Kein Wert 3")
    @Test
    void keinWert3() {
        String test = "Wert";
        ValueExtractor valueExtractor = new ValueExtractor(test, '"', '\\');
        assertFalse(valueExtractor.hasValue());
    }

    @DisplayName("Eskapierter Wert")
    @Test
    void eskapierterWert() {
        // 'Vor "We*"rt" Nach' -> 'We"rt'
        String test = "Vor \"We*\"rt\" Nach";
        ValueExtractor valueExtractor = new ValueExtractor(test, '"', '*');
        assertTrue(valueExtractor.hasValue());
        assertEquals("We\"rt", valueExtractor.getValue());
        assertEquals(4, valueExtractor.getStartIndex());
        assertEquals(11, valueExtractor.getStopIndex());
    }

    @DisplayName("Escape Character ohne Escape")
    @Test
    void escapeCharOhneEscape() {
        String test = "Vor \"We*rt\" Nach";
        ValueExtractor valueExtractor = new ValueExtractor(test, '"', '*');
        assertTrue(valueExtractor.hasValue());
        assertEquals("We*rt", valueExtractor.getValue());
        assertEquals(4, valueExtractor.getStartIndex());
        assertEquals(10, valueExtractor.getStopIndex());
    }

}