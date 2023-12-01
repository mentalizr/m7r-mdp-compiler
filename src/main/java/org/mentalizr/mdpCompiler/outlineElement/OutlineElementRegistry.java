package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.MDPCompiler;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.outlineElement.md.heading.*;
import org.mentalizr.mdpCompiler.outlineElement.md.hr.HR;
import org.mentalizr.mdpCompiler.outlineElement.md.paragraph.Paragraph;
import org.mentalizr.mdpCompiler.outlineElement.md.table.Table;
import org.mentalizr.mdpCompiler.outlineElement.md.ul.UL;
import org.mentalizr.mdpCompiler.outlineElement.special.comment.Comment;
import org.mentalizr.mdpCompiler.outlineElement.special.directive.Directive;
import org.mentalizr.mdpCompiler.outlineElement.tagged.alert.Alert;
import org.mentalizr.mdpCompiler.outlineElement.tagged.audio.Audio;
import org.mentalizr.mdpCompiler.outlineElement.tagged.card.Card;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.accordion.Accordion;
import org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable.collapse.Collapse;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup.InputGroup;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup.RadioGroup;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup.TextareaGroup;
import org.mentalizr.mdpCompiler.outlineElement.tagged.grid.Grid;
import org.mentalizr.mdpCompiler.outlineElement.tagged.html.Html;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgCenter.ImgCenter;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgFluid.ImgFluid;
import org.mentalizr.mdpCompiler.outlineElement.tagged.imgText.ImgText;
import org.mentalizr.mdpCompiler.outlineElement.tagged.mcQuestion.MCQuestion;
import org.mentalizr.mdpCompiler.outlineElement.tagged.multiAudio.MultiAudio;
import org.mentalizr.mdpCompiler.outlineElement.tagged.video.Video;

import java.util.ArrayList;
import java.util.List;

public class OutlineElementRegistry {

    private final List<OutlineElement> outlineElementMDFactoryList;
    private final List<OutlineElement> outlineElementTaggedFactoryList;
    private final List<OutlineElement> outlineElementTaggedNestableFactoryList;
    private final OutlineElement defaultElement;

    public OutlineElementRegistry() {

        this.outlineElementMDFactoryList = new ArrayList<>();
        this.outlineElementTaggedFactoryList = new ArrayList<>();
        this.outlineElementTaggedNestableFactoryList = new ArrayList<>();

        this.defaultElement = new Paragraph();

        this.outlineElementMDFactoryList.add(new Comment());
        this.outlineElementMDFactoryList.add(new H1());
        this.outlineElementMDFactoryList.add(new H2());
        this.outlineElementMDFactoryList.add(new H3());
        this.outlineElementMDFactoryList.add(new H4());
        this.outlineElementMDFactoryList.add(new H5());
        this.outlineElementMDFactoryList.add(new UL());
        this.outlineElementMDFactoryList.add(new HR());
        this.outlineElementMDFactoryList.add(new Table());

        this.outlineElementTaggedNestableFactoryList.add(new Accordion());
        this.outlineElementTaggedNestableFactoryList.add(new Collapse());
        this.outlineElementTaggedNestableFactoryList.add(new ImgFluid());
        this.outlineElementTaggedNestableFactoryList.add(new ImgCenter());
        this.outlineElementTaggedNestableFactoryList.add(new ImgText());
        this.outlineElementTaggedNestableFactoryList.add(new TextareaGroup());
        this.outlineElementTaggedNestableFactoryList.add(new Card());
        this.outlineElementTaggedNestableFactoryList.add(new InputGroup());
        this.outlineElementTaggedNestableFactoryList.add(new RadioGroup());
        this.outlineElementTaggedNestableFactoryList.add(new Alert());
        this.outlineElementTaggedNestableFactoryList.add(new Grid());
        this.outlineElementTaggedNestableFactoryList.add(new Video());
        this.outlineElementTaggedNestableFactoryList.add(new Audio());
        this.outlineElementTaggedNestableFactoryList.add(new MultiAudio());
        this.outlineElementTaggedNestableFactoryList.add(new Html());
        this.outlineElementTaggedNestableFactoryList.add(new MCQuestion());

        this.outlineElementTaggedFactoryList.add(new Directive());
    }

    public OutlineElement getMatchingElement(Line tagLine, MDPCompiler.Mode mode) {

        if (mode == MDPCompiler.Mode.MDP_COMPLETE) {
            for (OutlineElement factory : this.outlineElementTaggedFactoryList) {
                if (factory.isResponsible(tagLine)) return factory;
            }
        }

        if (mode == MDPCompiler.Mode.MD_AND_MDP_NESTABLE || mode == MDPCompiler.Mode.MDP_COMPLETE) {
            for (OutlineElement factory : this.outlineElementTaggedNestableFactoryList) {
                if (factory.isResponsible(tagLine)) return factory;
            }
        }

        for (OutlineElement factory : this.outlineElementMDFactoryList) {
            if (factory.isResponsible(tagLine)) return factory;
        }

        return this.defaultElement;
    }

}
