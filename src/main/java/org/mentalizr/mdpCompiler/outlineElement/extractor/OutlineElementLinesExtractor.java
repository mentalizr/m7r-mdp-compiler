package org.mentalizr.mdpCompiler.outlineElement.extractor;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;

import java.util.List;

public abstract class OutlineElementLinesExtractor {

    public enum TerminationStrategy { INCLUDE, EXCLUDE_IGNORE, EXCLUDE_REPROCESS }

//    protected DocumentIterator documentIterator;
    protected ExtractedOutlineElementBuffer extractedOutlineElementBuffer;

    public OutlineElementLinesExtractor() {

//        this.documentIterator = documentIterator;
        this.extractedOutlineElementBuffer = new ExtractedOutlineElementBuffer();
//
//        if (!documentIterator.hasCurrentLine())
//            throw new IllegalStateException("Specified DocumentIterator has no first line.");
//
//        Line firstLine = this.documentIterator.getCurrentLine();
//        this.extractedOutlineElementBuffer.add(firstLine);
    }

    public List<Line> extract(DocumentIterator documentIterator) {

//        ExtractedOutlineElementBuffer extractedOutlineElementBuffer = new ExtractedOutlineElementBuffer();

        if (!documentIterator.hasCurrentLine())
            throw new IllegalStateException("Specified DocumentIterator has no first line.");

        Line firstLine = documentIterator.getCurrentLine();
        extractedOutlineElementBuffer.add(firstLine);

        while (documentIterator.hasNextLine()) {

            Line line = documentIterator.getNextLine();

            if (!isTerminated(line)) {
                extractedOutlineElementBuffer.add(line);

            } else {

                if (getTerminationStrategy() == TerminationStrategy.INCLUDE) {
                    extractedOutlineElementBuffer.add(line);
                } else if (getTerminationStrategy() == TerminationStrategy.EXCLUDE_REPROCESS) {
                    documentIterator.getPreviousLine();
                } else if (getTerminationStrategy() == TerminationStrategy.EXCLUDE_IGNORE) {
                    // do intentionally nothing
                }

                break;
            }
        }

        extractedOutlineElementBuffer.stripTrailingEmptyLines();

        return extractedOutlineElementBuffer.getLines();
    }

    protected abstract boolean isTerminated(Line line);

    protected abstract TerminationStrategy getTerminationStrategy();

    /**
     * Override this method if some further custom modification of extracted lines is necessary,
     * e.g. stripping empty lines.
     */
    protected void postProcessExtractedLines() {

    }

}
