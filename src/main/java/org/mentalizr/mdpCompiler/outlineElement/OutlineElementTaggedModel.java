package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.mdpTag.MDPTag;

public class OutlineElementTaggedModel extends OutlineElementModel {

    protected MDPTag mdpTag;

    public MDPTag getMdpTag() {
        return mdpTag;
    }

    public void setMdpTag(MDPTag mdpTag) {
        this.mdpTag = mdpTag;
    }

}
