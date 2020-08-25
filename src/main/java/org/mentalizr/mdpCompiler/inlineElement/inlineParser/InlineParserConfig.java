package org.mentalizr.mdpCompiler.inlineElement.inlineParser;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;

public class InlineParserConfig {

    private final String beginToken;
    private final String endToken;
    private final String beginTokenSubstitute;
    private final String endTokenSubstitute;


    public InlineParserConfig(String beginToken, String endToken, String beginTokenSubstitute, String endTokenSubstitute) {

        AssertMethodPrecondition.parameterNotNull("beginToken", beginToken);
        this.beginToken = beginToken;

        AssertMethodPrecondition.parameterNotNull("endToken", endToken);
        this.endToken = endToken;

        AssertMethodPrecondition.parameterNotNull("beginTokenSubstitute", beginTokenSubstitute);
        this.beginTokenSubstitute = beginTokenSubstitute;

        AssertMethodPrecondition.parameterNotNull("endTokenSubstitute", endTokenSubstitute);
        this.endTokenSubstitute = endTokenSubstitute;
    }

    public String getBeginToken() {
        return beginToken;
    }

    public String getEndToken() {
        return endToken;
    }

    public String getBeginTokenSubstitute() {
        return beginTokenSubstitute;
    }

    public String getEndTokenSubstitute() {
        return endTokenSubstitute;
    }

    public int getBeginTokenLength() {
        return this.beginToken.length();
    }

    public int getEndTokenLength() {
        return this.endToken.length();
    }
}
