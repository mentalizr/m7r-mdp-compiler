package org.mentalizr.mdpCompiler.mdpTag;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;
import de.arthurpicht.utils.core.strings.Strings;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;

public class MDPTagWithLink implements MDPTag {

    // z.B.: @TAG[hier der attribute String](hier der link String)

    private static final String MID_DELIMITER = "](";
    private static final String END_DELIMITER = ")";

    private final String pre;
    private final String attributeString;
    private final String linkString;
    private final String post;

    public MDPTagWithLink(String tagName, Line line) throws MDPSyntaxError {

        AssertMethodPrecondition.parameterNotNull("tagName", tagName);
        AssertMethodPrecondition.parameterNotNull("line", line);

        String prefix = tagName + "[";

        String[] splitLineArray;
        try {
            splitLineArray = Strings.multiSplit(line.asString(), prefix, MID_DELIMITER, END_DELIMITER);
        } catch (IllegalArgumentException e) {
            throw new MDPSyntaxError(line, "Malformed MDP-Tag.");
        }

        if (splitLineArray.length != 4) throw new RuntimeException("Assertion failed: Illegal number of flakes.");

        this.pre = splitLineArray[0];
        this.attributeString = splitLineArray[1].trim();
        this.linkString = splitLineArray[2].trim();
        this.post = splitLineArray[3];
    }


    @Override
    public String getPre() {
        return this.pre;
    }

    @Override
    public String getAttributeString() {
        return this.attributeString;
    }

    @Override
    public String getLinkString() {
        return this.linkString;
    }

    @Override
    public String getPost() {
        return this.post;
    }
}
