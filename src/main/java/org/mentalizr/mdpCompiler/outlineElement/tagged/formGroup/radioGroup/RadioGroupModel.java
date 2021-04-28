package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup;

import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.SubModelsWithSingleLine;

import java.util.List;

public class RadioGroupModel extends SubModelsWithSingleLine {

    public RadioGroupModel(MDPTag mdpTag, String singleLine) {
        super(new RadioGroup(), mdpTag, singleLine);
    }

    public RadioGroupModel(MDPTag mdpTag, List<OutlineElementModel> childModels) {
        super(new RadioGroup(), mdpTag, childModels);
    }

    public RadioGroupAttributes getRadioGroupAttributes() {
        return (RadioGroupAttributes) this.mdpTag.getAttributes();
    }

}
