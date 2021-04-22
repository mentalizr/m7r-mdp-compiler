package org.mentalizr.mdpCompiler.document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lines {

    public static List<Line> shallowCopy(List<Line> lineList) {
        return lineList.subList(0, lineList.size());
    }

    // TODO Parameter lineNumberStart an Pos. 1 zur Vereinheitlichung mit anderen create Methoden
    public static List<Line> create(List<String> linesAsString, int lineNumberStart) {

        if (lineNumberStart < 1) throw new IllegalArgumentException("Line number must be > 0");

        List<Line> lineList = new ArrayList<>();

        int lineNumber = lineNumberStart;

        for (String line : linesAsString) {
            lineList.add(new Line(line, lineNumber++));
        }

        return lineList;
    }

    public static List<Line> create(int lineNumberStart, String... linesAsString) {
        return create(Arrays.asList(linesAsString), lineNumberStart);
    }

    public static List<Line> create(String... linesAsString) {
        return create(Arrays.asList(linesAsString), 1);
    }

    public static List<String> asStrings(List<Line> lineList) {

        List<String> stringList = new ArrayList<>();

        for (Line line : lineList) {
            stringList.add(line.asString());
        }

        return stringList;
    }

}
