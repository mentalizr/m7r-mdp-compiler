package org.mentalizr.mdpCompiler.outlineElement.tagged.imgText;

import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.SubModels;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImgTextModel extends SubModels {

    public ImgTextModel(MDPTag mdpTag, List<OutlineElementModel> childElements) {
        super(new ImgText(), mdpTag, childElements);
    }

    public ImgTextAttributes getImgTextAttributes() {
        return (ImgTextAttributes) this.mdpTag.getAttributes();
    }

    @Override
    public Set<String> getMediaResources() {
        Set<String> mediaResources = new HashSet<>(super.getMediaResources());
        mediaResources.add(this.getMdpTag().getLinkString());
        return mediaResources;
    }
}
