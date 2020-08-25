package org.mentalizr.mdpCompiler.remnants;

import de.arthurpicht.utils.core.strings.Strings;

import java.util.ArrayList;
import java.util.List;

public class TempHelper {

    public static List<String> splitAtDelimiters(String string, String delimiter) {

        if (!string.contains(delimiter)) {
            throw new IllegalArgumentException("Delimiter not contained in specified string.");
        }

        List<String> splitString = new ArrayList<>();
        String workString = string;

        while (workString.contains(delimiter)) {
            String[] bifurcatedString = Strings.splitAtDelimiter(workString, delimiter);

            if (!bifurcatedString[0].equals("")) {
                splitString.add(bifurcatedString[0]);
            }
            workString = bifurcatedString[1];
        }

        if (!workString.equals("")) {
            splitString.add(workString);
        }

        return splitString;
    }

}
