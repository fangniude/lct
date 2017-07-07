package com.winnertel.em.framework.gui.swing;

import com.klg.jclass.field.JCPopupField;
import com.klg.jclass.field.validate.JCValidator;
import com.klg.jclass.util.value.JCValueModel;

public class UPopupField extends JCPopupField {
    public UPopupField() {
    }

    public UPopupField(JCValueModel aValueModel) {
        super(aValueModel);
    }

    public UPopupField(JCValueModel aValueModel, JCValidator aValidator) {
        super(aValueModel, aValidator);
    }
}
