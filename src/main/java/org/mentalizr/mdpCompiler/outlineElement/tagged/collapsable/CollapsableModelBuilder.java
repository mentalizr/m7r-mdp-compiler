package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Document;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.Extraction;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTagged;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModelBuilder;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion.Accordion;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion.AccordionModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse.Collapse;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse.CollapseModel;

import java.util.List;

public class CollapsableModelBuilder extends OutlineElementTaggedModelBuilder {

    public CollapsableModelBuilder(OutlineElementTagged outlineElementTagged) {
        super(outlineElementTagged);
    }

    @Override
    public CollapsableModel getModel(Extraction extraction) throws MDPSyntaxError {

        if (!(extraction instanceof CollapsableExtraction))
            throw new RuntimeException(CollapsableExtraction.class.getSimpleName() + " expected.");

        if (extraction.isEmpty())
            throw new IllegalStateException("Insufficient number of lines.");

        CollapsableModel collapsableModel = createCollapsableModelInstance(extraction);

        CollapsableLineModel collapsableLineModel = getCollapsableLineModel(extraction);
        List<CollapsableCardLineContent> collapsableCardLineContentList = collapsableLineModel.getCollapsableCardContentList();
        for (CollapsableCardLineContent collapsableCardLineContent : collapsableCardLineContentList) {
            CollapsableCardContent collapsableCardContent;
            if (collapsableCardLineContent.hasSingleLine()) {
                String singleLine = collapsableCardLineContent.getSingleLine();
                collapsableCardContent = new CollapsableCardContent(-1, collapsableCardLineContent.getHeader(), singleLine);
            } else {
                Document cardDocument = collapsableCardLineContent.getContentAsDocument();
                List<OutlineElementModel> outlineElementModelList = MDPCompiler.getModelsForSubdocument(cardDocument);
                collapsableCardContent = new CollapsableCardContent(-1, collapsableCardLineContent.getHeader(), outlineElementModelList);
            }
            collapsableModel.addCardContent(collapsableCardContent);
        }

        return collapsableModel;
    }

    private CollapsableModel createCollapsableModelInstance(Extraction extraction) throws MDPSyntaxError {
        MDPTag mdpTag = parseMdpTagLine(extraction.getTagLine());

        if (this.outlineElement instanceof Accordion) {
            return new AccordionModel(mdpTag);
        } else if (this.outlineElement instanceof Collapse) {
            return new CollapseModel(mdpTag);
        } else {
            throw new RuntimeException("Illegal subtype of OutlineElement: " +
                    this.outlineElement.getClass().getSimpleName());
        }
    }

    private CollapsableLineModel getCollapsableLineModel(Extraction extraction) throws MDPSyntaxError {

        CollapsableLineModel collapsableLineModel = new CollapsableLineModel();

        int tagLineIndex = extraction.getTagLineIndex();
        List<Line> lines = extraction.getLinesWithoutTagLine();

        for (Line line : lines) {
            String lineString = line.asString();

            if (lineString.startsWith("    ")) {
                processIndentedContent(line, collapsableLineModel);

            } else if (line.asString().startsWith("--- ")) {
                processHeaderDefinition(line, collapsableLineModel);

            } else if (line.asString().isBlank()) {
                if (line.getLineIndex() == tagLineIndex + 1) {
                    throw new MDPSyntaxError(line, "Malformed accordion content definition. First line of content must not be blank.");
                }
                collapsableLineModel.addContentLine(line);

            } else {
                throw new IllegalStateException("Unrecognized content found. Should have led to termination in extraction stage. " + line.asString());
            }
        }

        return collapsableLineModel;
    }

    private void processIndentedContent(Line line, CollapsableLineModel collapsableModel) throws MDPSyntaxError {

        if (!collapsableModel.hasCurCard())
            throw new MDPSyntaxError(line, "Missing header definition for collapsable content element.");

//        String contentLine = line.asString().substring(4).trim();
        String contentLine = line.asString().substring(4);
        collapsableModel.addContentLine(new Line(contentLine, line.getLineIndex()));
    }

    private void processHeaderDefinition(Line line, CollapsableLineModel collapsableModel) {
        String header = line.asString().substring(4);
        collapsableModel.createNextCard(header);
    }

}
