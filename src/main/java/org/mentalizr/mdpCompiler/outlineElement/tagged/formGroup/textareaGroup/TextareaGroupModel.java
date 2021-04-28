package org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.textareaGroup;

import org.mentalizr.mdpCompiler.mdpTag.MDPTag;
import org.mentalizr.mdpCompiler.outlineElement.OutlineElementModel;
import org.mentalizr.mdpCompiler.outlineElement.tagged.SubModelsWithSingleLine;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup.RadioGroup;
import org.mentalizr.mdpCompiler.outlineElement.tagged.formGroup.radioGroup.RadioGroupAttributes;

import java.util.List;

public class TextareaGroupModel extends SubModelsWithSingleLine {

    public TextareaGroupModel(MDPTag mdpTag, String singleLine) {
        super(new TextareaGroup(), mdpTag, singleLine);
    }

    public TextareaGroupModel(MDPTag mdpTag, List<OutlineElementModel> childModels) {
        super(new TextareaGroup(), mdpTag, childModels);
    }

    public TextareaGroupAttributes getTextareaGroupAttributes() {
        return (TextareaGroupAttributes) this.mdpTag.getAttributes();
    }

}
