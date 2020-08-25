package org.mentalizr.mdpCompiler.valueExtractor;

public class ValueExtractorPostState extends ValueExctractorAbstractState {

    public ValueExtractorPostState(String educt, char startStopChar, char escapePrefix, int startIndex, int stopIndex, String value) {
        super(educt, startStopChar, escapePrefix);
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.value = value;
    }

    @Override
    public ValueExctractorAbstractState processChar(int index) {
        throw new IllegalArgumentException();
    }
}
