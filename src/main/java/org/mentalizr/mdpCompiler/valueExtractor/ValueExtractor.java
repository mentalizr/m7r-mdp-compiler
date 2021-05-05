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

    private ValueExtractorAbstractState exctractorAbstractState;

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

    public String getEduct() {
        return educt;
    }

    public char getStartStopChar() {
        return startStopChar;
    }

    public char getEscapePrefix() {
        return escapePrefix;
    }

    public boolean hasValue() {
        return this.exctractorAbstractState.hasValue();
    }

    public String getValue() {
        return this.exctractorAbstractState.getValue();
    }

    public int getStartIndex() {
        return this.exctractorAbstractState.getStartIndex();
    }

    public int getStopIndex() {
        return this.exctractorAbstractState.getStopIndex();
    }

}
