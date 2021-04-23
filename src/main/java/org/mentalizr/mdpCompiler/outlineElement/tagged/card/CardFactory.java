package org.mentalizr.mdpCompiler.outlineElement.tagged.card;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElement;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementFactory;

public class CardFactory extends OutlineElementFactory {

    public CardFactory() {
        super(Card.TAG);
    }

    @Override
    public OutlineElement getInstance() {
        return new Card();
    }
}
