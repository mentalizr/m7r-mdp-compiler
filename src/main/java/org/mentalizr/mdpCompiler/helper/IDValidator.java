package org.mentalizr.mdpCompiler.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDValidator {

    private static final Pattern pattern = Pattern.compile("^[a-zA-z][a-zA-Z0-9-_.]*");

    public boolean isValid(String idString) {
        Matcher matcher = pattern.matcher(idString);
        return matcher.matches();
    }
}
