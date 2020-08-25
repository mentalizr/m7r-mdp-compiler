package org.mentalizr.mdpCompiler.attributeParser;

public class TokenNotRecognizedException extends AttributeParserException {

    public TokenNotRecognizedException(String educt) {
        super("Malformed attribute specification. Token not recognized as value or assignment: '" + educt + "'.");
    }
}
