package com.winnertel.em.framework.gui.util;

import com.winnertel.em.framework.gui.IGuiComposer;

public class DvmStringMap implements IStringMap {
    private IGuiComposer fGuiComposer = null;


    public DvmStringMap(IGuiComposer aGuiComposer) {
        fGuiComposer = aGuiComposer;
    }


    public String getString(String aKey) {
        return fGuiComposer.getString(aKey);
    }
}
