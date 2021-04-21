package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.DocumentIterator;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.md.heading.*;
import org.mentalizr.mdpCompiler.outlineElement.md.hr.HRFactory;
import org.mentalizr.mdpCompiler.outlineElement.md.paragraph.ParagraphFactory;
import org.mentalizr.mdpCompiler.outlineElement.md.table.TableFactory;
import org.mentalizr.mdpCompiler.outlineElement.md.ul.ULFactory;
import org.mentalizr.mdpCompiler.outlineElement.special.comment.CommentFactory;
import org.mentalizr.mdpCompiler.outlineElement.special.directive.DirectiveFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.audio.AudioFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.card.CardFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion.AccordionFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse.CollapseFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroupFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup.RadioGroupFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup.TextareaGroupFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.grid.GridFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.html.HtmlFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter.ImgCenterFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid.ImgFluidFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgText.ImgTextFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion.MCQuestionFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.video.VideoFactory;
import org.mentalizr.mdpCompiler.result.Result;

import java.util.ArrayList;
import java.util.List;

public class OutlineElementRegistryNew {

    private final List<OutlineElementFactory> outlineElementMDFactoryList;
    private final List<OutlineElementFactory> outlineElementTaggedFactoryList;
    private final List<OutlineElementFactory> outlineElementTaggedNestableFactoryList;
    private final OutlineElementFactory defaultElement;

    public OutlineElementRegistryNew() {

        this.outlineElementMDFactoryList = new ArrayList<>();
        this.outlineElementTaggedFactoryList = new ArrayList<>();
        this.outlineElementTaggedNestableFactoryList = new ArrayList<>();

        this.defaultElement = new ParagraphFactory();

        this.outlineElementMDFactoryList.add(new CommentFactory());
        this.outlineElementMDFactoryList.add(new H1Factory());
        this.outlineElementMDFactoryList.add(new H2Factory());
        this.outlineElementMDFactoryList.add(new H3Factory());
        this.outlineElementMDFactoryList.add(new H4Factory());
        this.outlineElementMDFactoryList.add(new H5Factory());
        this.outlineElementMDFactoryList.add(new ULFactory());
        this.outlineElementMDFactoryList.add(new HRFactory());
        this.outlineElementMDFactoryList.add(new TableFactory());

        this.outlineElementTaggedNestableFactoryList.add(new AccordionFactory());
        this.outlineElementTaggedNestableFactoryList.add(new CollapseFactory());
        this.outlineElementTaggedNestableFactoryList.add(new ImgFluidFactory());
        this.outlineElementTaggedNestableFactoryList.add(new ImgCenterFactory());
        this.outlineElementTaggedNestableFactoryList.add(new ImgTextFactory());
        this.outlineElementTaggedNestableFactoryList.add(new TextareaGroupFactory());
        this.outlineElementTaggedNestableFactoryList.add(new CardFactory());
        this.outlineElementTaggedNestableFactoryList.add(new InputGroupFactory());
        this.outlineElementTaggedNestableFactoryList.add(new RadioGroupFactory());
        this.outlineElementTaggedNestableFactoryList.add(new AlertFactory());
        this.outlineElementTaggedNestableFactoryList.add(new GridFactory());
        this.outlineElementTaggedNestableFactoryList.add(new VideoFactory());
        this.outlineElementTaggedNestableFactoryList.add(new AudioFactory());
        this.outlineElementTaggedNestableFactoryList.add(new HtmlFactory());
        this.outlineElementTaggedNestableFactoryList.add(new MCQuestionFactory());

        this.outlineElementTaggedFactoryList.add(new DirectiveFactory());
    }

    public OutlineElement getMatchingElement(Line line, MDPCompiler.Mode mode, DocumentIterator documentIterator, Result result) throws MDPSyntaxError {

        if (mode == MDPCompiler.Mode.MDP_COMPLETE) {
            for (OutlineElementFactory factory : this.outlineElementTaggedFactoryList) {
                if (factory.isResponsible(line)) return factory.getInstance(documentIterator.getCurrentLine());
            }
        }

        if (mode == MDPCompiler.Mode.MD_AND_MDP_NESTABLE || mode == MDPCompiler.Mode.MDP_COMPLETE) {
            for (OutlineElementFactory factory : this.outlineElementTaggedNestableFactoryList) {
                if (factory.isResponsible(line)) return factory.getInstance(documentIterator.getCurrentLine());
            }
        }

        for (OutlineElementFactory factory : this.outlineElementMDFactoryList) {
            if (factory.isResponsible(line)) return factory.getInstance(documentIterator.getCurrentLine());
        }

        return this.defaultElement.getInstance(documentIterator.getCurrentLine());
    }

}
