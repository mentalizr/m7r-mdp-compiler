package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.MDPSyntaxError;
import org.mentalizr.mdpCompiler.document.Line;
import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.mdpTag.MDPTagSimple;
import org.mentalizr.mdpCompiler.mdpTag.MDPTagWithLink;

public abstract class OutlineElementTaggedModelBuilder extends OutlineElementModelBuilder {

    public OutlineElementTaggedModelBuilder(OutlineElementTagged outlineElementTagged) {
        super(outlineElementTagged);
    }

    public OutlineElementTagged getOutlineElementTagged() {
        return (OutlineElementTagged) this.outlineElement;
    }

    public abstract OutlineElementModel getModel(Extraction extraction) throws MDPSyntaxError;

    protected MDPTag parseMdpTagLine(Line mdpTagLine) throws MDPSyntaxError {
        OutlineElementTagged outlineElementTagged = getOutlineElementTagged();
        if (outlineElementTagged.withLink()) {
            return new MDPTagWithLink(outlineElementTagged, mdpTagLine);
        } else {
            return new MDPTagSimple(outlineElementTagged, mdpTagLine);
        }
    }

}
