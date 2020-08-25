package org.mentalizr.mdpCompiler.outlineElement;

import org.mentalizr.mdpCompiler.MDPSyntaxError;

/**
 * Receives all lines belonging to outline element including mdp tag line.
 * Builds respective model.
 */
public interface OutlineElementModelBuilder {

    public OutlineElementModel getModel() throws MDPSyntaxError;
}
