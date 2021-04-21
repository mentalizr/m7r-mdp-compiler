package org.mentalizr.mdpCompiler.outlineElement.extractor;

import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.ExtractionFactory;

import java.util.List;

public abstract class OutlineElementExtractor {

    public enum TerminationStrategy { INCLUDE, EXCLUDE_IGNORE, EXCLUDE_REPROCESS }

    protected ExtractionFactory extractionFactory;
    protected ExtractedOutlineElementBuffer extractedOutlineElementBuffer;

    public OutlineElementExtractor(ExtractionFactory extractionFactory) {
        this.extractionFactory = extractionFactory;
        this.extractedOutlineElementBuffer = new ExtractedOutlineElementBuffer();
    }

//    public List<Line> extract(DocumentIterator documentIterator) {
    public Extraction extract(DocumentIterator documentIterator) {

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

        List<Line> lines = extractedOutlineElementBuffer.getLines();
        return this.extractionFactory.createInstance(lines);
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
