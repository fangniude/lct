package com.winnertel.em.framework.gui.swing;

import com.klg.jclass.field.JCSpinField;
import com.klg.jclass.field.validate.JCValidator;
import com.klg.jclass.util.value.JCValueModel;

public class USpinField extends JCSpinField {
    public USpinField() {
    }

    public USpinField(JCValueModel aValueModel) {
        super(aValueModel);
    }

    public USpinField(JCValueModel aValueModel, JCValidator aValidator) {
        super(aValueModel, aValidator);
    }
}
