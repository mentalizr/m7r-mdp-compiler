package org.mentalizr.mdpCompiler.document;

import org.mentalizr.mdpCompiler.MDPSyntaxError;

public class DocumentSanityChecker {

    public static void check(Document document) throws MDPSyntaxError {

        DocumentIterator documentIterator = document.getDocumentIterator();

        while (documentIterator.hasNextLine()) {
            Line line = documentIterator.getNextLine();
            checkLine(line);
        }
    }

    public static void checkLine(Line line) throws MDPSyntaxError {
        checkForTab(line);
        checkForInconsistentIndent(line);
    }

    private static void checkForTab(Line line) throws MDPSyntaxError {
        int tabIndex = line.asString().indexOf('\t');
        if (tabIndex >= 0) {
            throw new MDPSyntaxError(line, "Found character 'tab' in line at position " + (tabIndex + 1) + ".");
        }
    }

    private static void checkForInconsistentIndent(Line line) throws MDPSyntaxError {
        String lineString = line.asString();

        if (!lineString.startsWith(" ")) return;

        int indexOfPostIndent = 0;
        for (; indexOfPostIndent < lineString.length(); indexOfPostIndent++) {
            if (lineString.charAt(indexOfPostIndent) == ' ') continue;
            if (indexOfPostIndent % 4 != 0) throw new MDPSyntaxError(line, "Malformed indentation. Number of indenting spaces is not a multiple of 4: " + indexOfPostIndent);
            break;
        }

    }
}
