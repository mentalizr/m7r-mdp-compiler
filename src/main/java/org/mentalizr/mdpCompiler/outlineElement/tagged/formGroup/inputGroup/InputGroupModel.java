package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.inputGroup;

import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.SubModelsWithSingleLine;

import java.util.List;

public class InputGroupModel extends SubModelsWithSingleLine {

    public InputGroupModel(MDPTag mdpTag, String singleLine) {
        super(new InputGroup(), mdpTag, singleLine);
    }

    public InputGroupModel(MDPTag mdpTag, List<OutlineElementModel> childModels) {
        super(new InputGroup(), mdpTag, childModels);
    }

    public InputGroupAttributes getInputGroupAttributes() {
        return (InputGroupAttributes) this.mdpTag.getAttributes();
    }

}
