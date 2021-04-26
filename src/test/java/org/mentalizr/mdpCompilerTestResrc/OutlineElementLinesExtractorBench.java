package org.mentalizr.mdpCompilerTestResrc;

import de.arthurpicht.utils.io.textfile.TextFile;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.extractor.OutlineElementExtractor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutlineElementLinesExtractorBench {

    @SuppressWarnings("SpellCheckingInspection")
    private static final boolean SOUT_RESULT = true;

    public static void execute(@SuppressWarnings("SpellCheckingInspection") String testname, DocumentIterator documentIterator, OutlineElementExtractor outlineElementExtractor, File file, int expectedDocumentIteratorIndex) throws IOException {

        List<String> expectedLines = TextFile.getLinesAsStrings(file);
        execute(testname, documentIterator, outlineElementExtractor, expectedLines, expectedDocumentIteratorIndex);

//        documentIterator.getNextLine();
//        Extraction extraction = outlineElementExtractor.extract(documentIterator);
//
//        List<String> mdpLinesAsString = new ArrayList<>();
//        for (Line extractedLine : extraction.getLines()) {
//            String mdpLineAsString = extractedLine.asString();
//            mdpLinesAsString.add(mdpLineAsString);
//        }
//
//        if (SOUT_RESULT) {
//            System.out.println("### Begin [OutlineElementLinesExtractorBench] " + testname);
//            for (String mdpLineAsString : mdpLinesAsString) {
//                System.out.println(mdpLineAsString);
//            }
//            System.out.println("### End -----");
//        }
//
//        List<String> expectedLines = TextFile.getLinesAsStrings(file);
//        assertEquals(expectedLines, mdpLinesAsString);
//        assertEquals(expectedDocumentIteratorIndex, documentIterator.getIndex());
    }

    public static void execute(@SuppressWarnings("SpellCheckingInspection") String testname, DocumentIterator documentIterator, OutlineElementExtractor outlineElementExtractor, List<String> expectedLines, int expectedDocumentIteratorIndex) throws IOException {

        documentIterator.getNextLine();
        Extraction extraction = outlineElementExtractor.extract(documentIterator);

        List<String> mdpLinesAsStrings = extraction.asStrings();

//        List<String> mdpLinesAsString = new ArrayList<>();
//        for (Line extractedLine : extraction.getLines()) {
//            String mdpLineAsString = extractedLine.asString();
//            mdpLinesAsString.add(mdpLineAsString);
//        }

        if (SOUT_RESULT) {
            System.out.println("### Begin [OutlineElementLinesExtractorBench] " + testname);
            for (String mdpLineAsString : mdpLinesAsStrings) {
                System.out.println(mdpLineAsString);
            }
            System.out.println("### End -----");
        }


        assertEquals(expectedLines, mdpLinesAsStrings);
        assertEquals(expectedDocumentIteratorIndex, documentIterator.getIndex());
    }

}
