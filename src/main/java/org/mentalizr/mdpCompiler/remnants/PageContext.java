package org.mentalizr.mdpCompiler.remnants;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;

import java.util.HashSet;
import java.util.Set;

public class PageContext {

    private static final Set<String> idSet = new HashSet<>();
    private static final Set<String> nameSet = new HashSet<>();

    synchronized public static void addId(Line line, String id) throws MDPSyntaxError {
        if (idSet.contains(id)) throw new MDPSyntaxError(line, "Attribut 'id' mit Bezeichnung '" + id + "' existiert bereits auf dieser Seite.");
        idSet.add(id);
    }

    synchronized public static void addName(Line line, String name) throws MDPSyntaxError {
        if (nameSet.contains(name)) throw new MDPSyntaxError(line, "Attribut 'name' mit Bezeichnung '" + name + "' existiert bereits auf dieser Seite.");
        nameSet.add(name);
    }

}
