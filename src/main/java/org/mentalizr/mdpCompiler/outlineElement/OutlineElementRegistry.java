package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.md.heading.*;
import org.mentalizr.mdpCompiler.outlineElement.md.hr.HR;
import org.mentalizr.mdpCompiler.outlineElement.md.hr.HRFactory;
import org.mentalizr.mdpCompiler.outlineElement.md.paragraph.ParagraphFactory;
import org.mentalizr.mdpCompiler.outlineElement.md.table.Table;
import org.mentalizr.mdpCompiler.outlineElement.md.table.TableFactory;
import org.mentalizr.mdpCompiler.outlineElement.md.ul.UL;
import org.mentalizr.mdpCompiler.outlineElement.md.ul.ULFactory;
import org.mentalizr.mdpCompiler.outlineElement.special.comment.Comment;
import org.mentalizr.mdpCompiler.outlineElement.special.comment.CommentFactory;
import org.mentalizr.mdpCompiler.outlineElement.special.directive.Directive;
import org.mentalizr.mdpCompiler.outlineElement.special.directive.DirectiveFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.Alert;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.AlertFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.audio.Audio;
import org.mentalizr.mdpCompiler.outlineElement.tagged.audio.AudioFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.card.Card;
import org.mentalizr.mdpCompiler.outlineElement.tagged.card.CardFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion.Accordion;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion.AccordionFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse.Collapse;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse.CollapseFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroup;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroupFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup.RadioGroup;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup.RadioGroupFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup.TextareaGroup;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup.TextareaGroupFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.grid.Grid;
import org.mentalizr.mdpCompiler.outlineElement.tagged.grid.GridFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.html.Html;
import org.mentalizr.mdpCompiler.outlineElement.tagged.html.HtmlFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter.ImgCenter;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter.ImgCenterFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid.ImgFluid;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid.ImgFluidFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgText.ImgText;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgText.ImgTextFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion.MCQuestion;
import org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion.MCQuestionFactory;
import org.mentalizr.mdpCompiler.outlineElement.tagged.video.Video;
import org.mentalizr.mdpCompiler.outlineElement.tagged.video.VideoFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutlineElementRegistry {

    private final List<OutlineElementFactory> outlineElementMDFactoryList;
//    private final Map<String, OutlineElementFactory> outlineElementMDFactoryMap;
    private final List<OutlineElementFactory> outlineElementTaggedFactoryList;
//    private final Map<String, OutlineElementFactory> outlineElementTaggedFactoryMap;
    private final List<OutlineElementFactory> outlineElementTaggedNestableFactoryList;
//    private final Map<String, OutlineElementFactory> outlineElementTaggedNestableFactoryMap;
    private final OutlineElementFactory defaultElement;

    public OutlineElementRegistry() {

        this.outlineElementMDFactoryList = new ArrayList<>();
        this.outlineElementTaggedFactoryList = new ArrayList<>();
        this.outlineElementTaggedNestableFactoryList = new ArrayList<>();

        this.defaultElement = new ParagraphFactory();

//        this.outlineElementMDFactoryMap = new HashMap<>();
//        this.outlineElementMDFactoryMap.put(Comment.PREFIX, new CommentFactory());
//        this.outlineElementMDFactoryMap.put(H1.PREFIX, new H1Factory());
//        this.outlineElementMDFactoryMap.put(H2.PREFIX, new H2Factory());
//        this.outlineElementMDFactoryMap.put(H3.PREFIX, new H3Factory());
//        this.outlineElementMDFactoryMap.put(H4.PREFIX, new H4Factory());
//        this.outlineElementMDFactoryMap.put(H5.PREFIX, new H5Factory());
//        this.outlineElementMDFactoryMap.put(UL.PREFIX, new ULFactory());
//        this.outlineElementMDFactoryMap.put(HR.PREFIX, new HRFactory());
//        this.outlineElementMDFactoryMap.put(Table.PREFIX, new TableFactory());

        this.outlineElementMDFactoryList.add(new CommentFactory());
        this.outlineElementMDFactoryList.add(new H1Factory());
        this.outlineElementMDFactoryList.add(new H2Factory());
        this.outlineElementMDFactoryList.add(new H3Factory());
        this.outlineElementMDFactoryList.add(new H4Factory());
        this.outlineElementMDFactoryList.add(new H5Factory());
        this.outlineElementMDFactoryList.add(new ULFactory());
        this.outlineElementMDFactoryList.add(new HRFactory());
        this.outlineElementMDFactoryList.add(new TableFactory());

//        this.outlineElementTaggedNestableFactoryMap = new HashMap<>();
//        this.outlineElementTaggedNestableFactoryMap.put(Accordion.TAG, new AccordionFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(Collapse.TAG, new CollapseFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(ImgFluid.TAG, new ImgFluidFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(ImgCenter.TAG, new ImgCenterFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(ImgText.TAG, new ImgTextFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(TextareaGroup.TAG, new TextareaGroupFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(Card.TAG, new CardFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(InputGroup.TAG, new InputGroupFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(RadioGroup.TAG, new RadioGroupFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(Alert.TAG, new AlertFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(Grid.TAG, new GridFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(Video.TAG, new VideoFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(Audio.TAG, new AudioFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(Html.TAG, new HtmlFactory());
//        this.outlineElementTaggedNestableFactoryMap.put(MCQuestion.TAG, new MCQuestionFactory());

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

//        this.outlineElementTaggedFactoryMap = new HashMap<>();
//        this.outlineElementTaggedFactoryMap.put(Directive.PREFIX, new DirectiveFactory());

        this.outlineElementTaggedFactoryList.add(new DirectiveFactory());
    }

    public OutlineElement getMatchingElement(Line tagLine, MDPCompiler.Mode mode) {

        if (mode == MDPCompiler.Mode.MDP_COMPLETE) {
            for (OutlineElementFactory factory : this.outlineElementTaggedFactoryList) {
                if (factory.isResponsible(tagLine)) return factory.getInstance();
            }
        }

        if (mode == MDPCompiler.Mode.MD_AND_MDP_NESTABLE || mode == MDPCompiler.Mode.MDP_COMPLETE) {
            for (OutlineElementFactory factory : this.outlineElementTaggedNestableFactoryList) {
                if (factory.isResponsible(tagLine)) return factory.getInstance();
            }
        }

        for (OutlineElementFactory factory : this.outlineElementMDFactoryList) {
            if (factory.isResponsible(tagLine)) return factory.getInstance();
        }

        return this.defaultElement.getInstance();
    }

}
