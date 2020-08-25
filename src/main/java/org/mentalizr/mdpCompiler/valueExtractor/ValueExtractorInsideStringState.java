package org.mentalizr.mdpCompiler.valueExtractor;

public class ValueExtractorInsideStringState extends ValueExctractorAbstractState {

    private final int startIndex;
    private final StringBuilder stringBuilder;

    public ValueExtractorInsideStringState(String educt, char startStopChar, char escapePrefix, int startIndex) {
        super(educt, startStopChar, escapePrefix);
        this.startIndex = startIndex;
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public ValueExctractorAbstractState processChar(int index) {

        char currentChar = educt.charAt(index);

        if (isStopChar(currentChar, index)) {
            String value = this.stringBuilder.toString();
            return new ValueExtractorPostState(this.educt, this.startStopChar, this.escapePrefix, this.startIndex, index, value);

        } else if (isEscapedStartStopChar(currentChar, index)) {
            this.stringBuilder.setLength(this.stringBuilder.length() - 1);

        }
        this.stringBuilder.append(currentChar);
        return this;
    }

    private boolean isStopChar(char currentChar, int index) {
        return (currentChar == this.startStopChar && !isPrevCharEscapeChar(index));
    }

    private boolean isEscapedStartStopChar(char currentChar, int index) {
        return (currentChar == this.startStopChar && isPrevCharEscapeChar(index));
    }

    private boolean isPrevCharEscapeChar(int index) {
        char prevChar = this.educt.charAt(index - 1);
        return (prevChar == this.escapePrefix);
    }



}
