package org.mentalizr.mdpCompiler.result;

import java.util.List;

public interface Result {

    void addLn(String line);

    void addLn(int indentLevel, String line);

    void addResult(Result result);

    List<String> getResultLines();
}
