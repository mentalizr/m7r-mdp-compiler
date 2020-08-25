package org.mentalizr.mdpCompiler.mdpTag;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;
import de.arthurpicht.utils.core.strings.Strings;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;

public class MDPTagSimple implements MDPTag {

    // z.B.: @TAG[hier der attribute String]

    private static final String END_DELIMITER = "]";

    private final String pre;
    private final String attributeString;
    private final String post;

    public MDPTagSimple(String tagName, Line line) throws MDPSyntaxError {

        AssertMethodPrecondition.parameterNotNullAndNotEmpty("tagName", tagName);
        AssertMethodPrecondition.parameterNotNull("line", line);

        String prefix = tagName + "[";

        String[] splitLineArray;
        try {
            splitLineArray = Strings.multiSplit(line.asString(), prefix, END_DELIMITER);
        } catch (IllegalArgumentException e) {
            throw new MDPSyntaxError(line, "Malformed MDP-Tag.");
        }

        if (splitLineArray.length != 3) throw new RuntimeException("Assertion failed: Illegal number of flakes.");

        this.pre = splitLineArray[0];
        this.attributeString = splitLineArray[1].trim();
        this.post = splitLineArray[2];
    }

    @Override
    public String getPre() {
        return this.pre;
    }

    @Override
    public String getAttributeString() {
        return this.attributeString.trim();
    }

    @Override
    public String getLinkString() {
        throw new IllegalStateException("Method not provided.");
    }

    @Override
    public String getPost() {
        return this.post;
    }
}
