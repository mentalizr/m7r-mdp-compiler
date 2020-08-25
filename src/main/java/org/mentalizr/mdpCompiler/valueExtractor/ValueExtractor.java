package org.mentalizr.mdpCompiler.valueExtractor;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;

/**
 *
 * Extrahiert aus einem spez. String (Parameter educt) einen Wert als Teilstring (Value), der durch den
 * spez. startStopChar begrenzt ist. Die startStopChars sind dabei nicht teil des extrahierten
 * Wert. Der Wert selbst kann den startStopChar enthalten, indem ihm in dem Ausgangsstring (educt) der
 * spez. escapePrefix vorangestellt wird.
 *
 * Siehe die Tests für Bsp.
 *
 */
public class ValueExtractor {

    private final String educt;
    private final char startStopChar;
    private final char escapePrefix;

    private ValueExctractorAbstractState exctractorAbstractState;

    public ValueExtractor(String educt, char startStopChar, char escapePrefix) {

        AssertMethodPrecondition.parameterNotNull("educt", educt);
        if (startStopChar == escapePrefix) throw new IllegalArgumentException("'startStopChar' ist gleich 'escapePrefix'");

        this.educt = educt;
        this.startStopChar = startStopChar;
        this.escapePrefix = escapePrefix;

        this.exctractorAbstractState = new ValueExtractorPreState(educt, startStopChar, escapePrefix);

        for (int i=0; i<educt.length(); i++) {

            this.exctractorAbstractState = this.exctractorAbstractState.processChar(i);
            if (this.exctractorAbstractState instanceof ValueExtractorPostState) break;
        }
    }

    /**
     * Liefert den bei Initialisierung spezifizierten Ausgangsstring.
     *
     * @return
     */
    public String getEduct() {
        return educt;
    }

    /**
     * Liefert den bei Initialisierung spezifizierten Character, der den Wert abgrenzt.
     *
     * @return
     */
    public char getStartStopChar() {
        return startStopChar;
    }

    /**
     * Liefert den bei Initialisierung spezifizierten Character, der einen innerhalb des Wertes
     * enthaltenen StartStopChar escapiert.
     *
     * @return
     */
    public char getEscapePrefix() {
        return escapePrefix;
    }

    /**
     * Prüft, ob ein Wert gefunden wurde.
     *
     * @return true, wenn ein Wert gefunden wurde, sonst false.
     */
    public boolean hasValue() {
        return this.exctractorAbstractState.hasValue();
    }

    /**
     * Liefert den gefunden Wert.
     *
     * @return Gefundener Wert. null, wenn kein Wert gefunden werden konnte.
     */
    public String getValue() {
        return this.exctractorAbstractState.getValue();
    }

    /**
     * Liefert den Index-Wert des begrenzenden Zeichens vor dem Wertes. -1 wenn kein Wert gefunden wurde.
     *
     * @return
     */
    public int getStartIndex() {
        return this.exctractorAbstractState.getStartIndex();
    }

    /**
     * Liefert den Index-Wert des begrenzenden Zeichens nach dem Wert. -1 wenn kein Wert gefunden wurde.
     *
     * @return
     */
    public int getStopIndex() {
        return this.exctractorAbstractState.getStopIndex();
    }

    public static void main(String[] args) {

        String test = "adfdsf \"Wert\"lkj";
        ValueExtractor valueExtractor = new ValueExtractor(test, '"', '\\');
        if (valueExtractor.hasValue()) {
            System.out.println("start: " + valueExtractor.getStartIndex() + ", stop: " + valueExtractor.getStopIndex() + " value: " + valueExtractor.getValue());
        } else {
            System.out.println("Keinen Wert gefunden.");
        }

    }

}
