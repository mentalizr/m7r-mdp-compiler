package org.mentalizr.mdpCompiler.attributeParser;

public class NoValidAssignmentException extends AttributeParserException {

    public NoValidAssignmentException(String preValueString) {
        super("Malformed attribute specification. No valid assignment: '" + preValueString + "'.");
    }
}
