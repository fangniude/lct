package com.winnertel.em.standard.util.gui.input.factory;

import com.winnertel.em.standard.util.gui.input.MulticastMacField;
import com.winnertel.em.standard.util.gui.input.base.FormattedField;

public class MulticastMacFactory extends TextFieldFactory {

    private static Object initLock = new Object();
    private static TextFieldFactory factory = null;

    private MulticastMacFactory() {
    }

    public static TextFieldFactory getInstance() {
        synchronized (initLock) {
            if (factory == null) {
                factory = new MulticastMacFactory();
            }
            return factory;
        }
    }

    public FormattedField create(int index) {


        return new MulticastMacField(index);
    }


}
