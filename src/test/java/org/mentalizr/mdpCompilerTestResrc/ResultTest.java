package org.mentalizr.mdpCompilerTestResrc;

import org.mentalizr.mdpCompiler.result.Result;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public class ResultTest implements Result {

    // TODO identischer Code zu ResultWriter --> Refactoring

    private final List<String> resultLines;

    public ResultTest() {
        this.resultLines = new ArrayList<>();
    }

    @Override
    public void addLn(String line) {
        this.resultLines.add(line);
    }

    @Override
    public void addLn(int indentLevel, String line) {

        String string = "    ".repeat(Math.max(0, indentLevel)) +
                line;
        this.resultLines.add(string);
    }

    @Override
    public void addResult(Result resultToBeAdded) {

        List<String> linesToBeAdded = resultToBeAdded.getResultLines();

        for (String string : linesToBeAdded) {
            addLn(string);
        }
    }

    @Override
    public List<String> getResultLines() {
        return this.resultLines;
    }
}
