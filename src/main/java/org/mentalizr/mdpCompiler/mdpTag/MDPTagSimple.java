package org.mentalizr.mdpCompiler.mdpTag;

import de.arthurpicht.utils.core.strings.Strings;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;

public class MDPTagSimple extends MDPTag {

    // z.B.: @TAG[this is the attribute string]

    private static final String END_DELIMITER = "]";

    public MDPTagSimple(OutlineElementTagged outlineElementTagged, Line line) throws MDPSyntaxError {
        super(outlineElementTagged, line);

        String prefix = getTagName() + "[";

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

        createAttributes();
    }

    @Override
    public String getLinkString() {
        throw new IllegalStateException("Method not provided.");
    }

}
