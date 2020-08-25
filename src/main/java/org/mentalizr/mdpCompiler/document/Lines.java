package org.mentalizr.mdpCompiler.document;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    public static List<Line> shallowCopy(List<Line> lineList) {
        return lineList.subList(0, lineList.size());
    }

    public static List<Line> create(List<String> linesAsString, int lineNumberStart) {

        List<Line> lineList = new ArrayList<>();

        int lineNumber = lineNumberStart;

        for (String line : linesAsString) {
            lineList.add(new Line(line, lineNumber++));
        }

        return lineList;
    }

    public static List<String> getStrings(List<Line> lineList) {

        List<String> stringList = new ArrayList<>();

        for (Line line : lineList) {
            stringList.add(line.asString());
        }

        return stringList;
    }

}
