package org.mentalizr.mdpCompiler.outlineElement.special.directive;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.ArrayList;
import java.util.List;

public class DirectiveModel implements OutlineElementModel {

    private final List<String> directiveLines;

    public DirectiveModel(List<String> directiveLines) {
        this.directiveLines = new ArrayList<>(directiveLines);
    }

    public int getNrOfDirectiveLines() {
        return this.directiveLines.size();
    }

    public List<String> getDirectives() {
        return this.directiveLines;
    }

}
