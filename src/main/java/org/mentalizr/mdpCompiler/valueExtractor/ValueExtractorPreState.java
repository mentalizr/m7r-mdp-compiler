package org.mentalizr.mdpCompiler.valueExtractor;

public class ValueExtractorPreState extends ValueExtractorAbstractState {

    public ValueExtractorPreState(String educt, char startStopChar, char escapePrefix) {
        super(educt, startStopChar, escapePrefix);
    }

    @Override
    public ValueExtractorAbstractState processChar(int index) {
        if (isStartChar(index)) {
            return new ValueExtractorInsideStringState(this.educt, this.startStopChar, this.escapePrefix, index);
        }
        return this;
    }

    private boolean isStartChar(int index) {
        return this.educt.charAt(index) == this.startStopChar;
    }

}
