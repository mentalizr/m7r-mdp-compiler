package org.mentalizr.mdpCompiler.mdpTag;

import de.arthurpicht.utils.core.assertion.AssertMethodPrecondition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MDPTagUtil {

    private final static Pattern headerMarkPattern = Pattern.compile("^@.+\\[.*\\].*");

    public static boolean isMDPTag(String mdpTag) {

        AssertMethodPrecondition.parameterNotNull("mdpTag", mdpTag);

        mdpTag = mdpTag.trim();
        Matcher matcher = headerMarkPattern.matcher(mdpTag);
        return matcher.matches();

    }

}
