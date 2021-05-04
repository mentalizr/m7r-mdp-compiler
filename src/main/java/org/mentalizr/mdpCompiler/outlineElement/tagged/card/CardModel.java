package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementTaggedModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.OutlineElementTaggedAttributes;
import org.mentalizr.mdpCompiler.outlineElement.tagged.SubModelsWithSingleLine;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardModel extends SubModelsWithSingleLine {

    public CardModel(MDPTag mdpTag, String singleLine) {
        super(new Card(), mdpTag, singleLine);
    }

    public CardModel(MDPTag mdpTag, List<OutlineElementModel> childModels) {
        super(new Card(), mdpTag, childModels);
    }

    public CardAttributes getCardAttributes() {
        return (CardAttributes) this.mdpTag.getAttributes();
    }

}
