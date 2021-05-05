package org.mentalizr.mdpCompiler.outlineElement.tagged.collapsable;

import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollapsableCardContent {

    private final int index;
    private final String header;
    private final List<OutlineElementModel> childElements;
    private final String singleLine;

    public CollapsableCardContent(int index, String header, List<OutlineElementModel> childElements) {
        this.index = index;
        this.header = header;
        this.childElements = childElements;
        this.singleLine = null;
    }

    public CollapsableCardContent(int index, String header, String singleLine) {
        this.index = index;
        this.header = header;
        this.childElements = null;
        this.singleLine = singleLine;
    }

    public String getHeader() {
        return this.header;
    }

    public List<OutlineElementModel> getChildElements() {
        return this.childElements;
    }

    public String getSingleLine() {
        return this.singleLine;
    }

    public boolean hasSingleLine() {
        return this.singleLine != null;
    }

    public boolean hasChildElements() {
        return this.childElements != null;
    }

    public Set<String> getMediaResources() {
        if (hasChildElements()) {
            Set<String> mediaResources = new HashSet<>();
            //noinspection ConstantConditions
            for (OutlineElementModel outlineElementModel : this.childElements) {
                mediaResources.addAll(outlineElementModel.getMediaResources());
            }
            return mediaResources;
        } else {
            return Collections.emptySet();
        }
    }

}
