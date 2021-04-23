package org.mentalizr.mdpCompiler.mdpTag;

import de.arthurpicht.utils.core.strings.Strings;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;

public class MDPTagWithLink extends MDPTag {

    // z.B.: @TAG[hier der attribute String](hier der link String)

    private static final String MID_DELIMITER = "](";
    private static final String END_DELIMITER = ")";

    public MDPTagWithLink(OutlineElementTagged outlineElementTagged, Line line) throws MDPSyntaxError {
        super(outlineElementTagged, line);

        String prefix = getTagName() + "[";

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

        createAttributes();
    }

}
