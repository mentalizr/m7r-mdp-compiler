package org.mentalizr.mdpCompiler.valueExtractor;

public abstract class ValueExctractorAbstractState {

    protected String educt;
    protected char startStopChar;
    protected char escapePrefix;

    protected int startIndex;
    protected int stopIndex;
    protected String value;

    public ValueExctractorAbstractState(String educt, char startStopChar, char escapePrefix) {
        this.educt = educt;
        this.startStopChar = startStopChar;
        this.escapePrefix = escapePrefix;

        this.startIndex = -1;
        this.stopIndex = -1;
        this.value = null;
    }

    public abstract ValueExctractorAbstractState processChar(int index);

    public boolean hasValue() {
        return this.value != null;
    }

    public String getValue() {
        return this.value;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getStopIndex() {
        return this.stopIndex;
    }

}
