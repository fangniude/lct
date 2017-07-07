package com.winnertel.em.standard.util.gui.input.factory;

import com.winnertel.em.standard.util.gui.input.base.FormattedField;
import com.winnertel.em.standard.util.gui.input.base.HexIntegerTextField;


public class HexIntegerTextFieldFactory extends TextFieldFactory {

    private static Object initLock = new Object();
    private static TextFieldFactory factory = null;

    private HexIntegerTextFieldFactory() {
    }

    public static TextFieldFactory getInstance() {
        synchronized (initLock) {
            if (factory == null) {
                factory = new HexIntegerTextFieldFactory();
            }
            return factory;
        }
    }

    public FormattedField create(int index) {
        return new HexIntegerTextField(index);
    }


}
