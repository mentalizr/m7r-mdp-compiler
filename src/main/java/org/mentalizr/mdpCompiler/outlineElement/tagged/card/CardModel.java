package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;

import java.util.List;

public class CardModel extends OutlineElementTaggedModel {

    private final String singleLine;
    private final List<OutlineElementModel> childModels;


    public CardModel(MDPTag mdpTag, String singleLine) {
        super(new Card());
        setMdpTag(mdpTag);
        this.singleLine = singleLine;
        this.childModels = null;
    }

    public CardModel(MDPTag mdpTag, List<OutlineElementModel> childModels) {
        super(new Card());
        setMdpTag(mdpTag);
        this.singleLine = null;
        this.childModels = childModels;
    }

    public boolean hasChildModels() {
        return this.childModels != null;
    }

    public List<OutlineElementModel> getChildModels() {
        if (this.childModels == null)
            throw new IllegalStateException("No child models existing. Check before calling.");
        return this.childModels;
    }

    public boolean hasSingleLine() {
        return this.singleLine != null;
    }

    public String getSingleLine() {
        if (this.singleLine == null)
            throw new IllegalStateException("No line existing. Check before calling.");
        return this.singleLine;
    }

    public OutlineElementTaggedAttributes getOutlineElementTaggedAttributes() {
        return this.mdpTag.getAttributes();
    }

}
