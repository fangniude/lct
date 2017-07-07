package com.winnertel.em.framework.gui.swing;

import com.klg.jclass.field.JCLabelField;
import com.klg.jclass.field.validate.JCValidator;
import com.klg.jclass.util.value.JCValueModel;

public class ULabelField extends JCLabelField {
    public ULabelField() {
    }

    public ULabelField(JCValueModel aValueModel) {
        super(aValueModel);
    }

    public ULabelField(JCValueModel aValueModel, JCValidator aValidator) {
        super(aValueModel, aValidator);
    }
}
