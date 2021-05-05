package org.mentalizr.mdpCompiler.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFile {

    public static List<String> getLinesAsStrings(File file) throws IOException {
        // TODO modernize that, use Path instead of File
        // Files.lines(htmlFile).collect(Collectors.toList());

        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

}
