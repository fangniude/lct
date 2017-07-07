package com.winnertel.em.framework.gui.swing;

import com.klg.jclass.field.JCComboField;
import com.klg.jclass.field.validate.JCValidator;
import com.klg.jclass.util.value.JCValueModel;

public class UComboField extends JCComboField {
    public UComboField() {
    }

    public UComboField(JCValueModel aValueModel) {
        super(aValueModel);
    }

    public UComboField(JCValueModel aValueModel, JCValidator aValidator) {
        super(aValueModel, aValidator);
    }
}
