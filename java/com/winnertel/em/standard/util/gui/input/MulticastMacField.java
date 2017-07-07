package com.winnertel.em.standard.util.gui.input;

import com.winnertel.em.standard.util.gui.input.base.FormattedField;

public class MulticastMacField extends FormattedField {


    int textFieldLength = 2;

    public MulticastMacField(int aIndex) {
        super(aIndex);
        if (aIndex == 0 || aIndex == 1 || aIndex == 2) {
            if (aIndex == 0) setValue("01");
            if (aIndex == 1) setValue("00");
            if (aIndex == 2) setValue("5E");
            this.setEnabled(false);
        } else {
            setValue("00");
        }
    }

    public void setValue(String value) {
        setText(value);
    }

    public boolean insertVerify(String strOrigin, int iOffsets, String strInserted, int cellIndex) {
        String str = strOrigin.substring(0, iOffsets)
                + strInserted
                + strOrigin.substring(iOffsets, strOrigin.length());
        char[] source = str.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (!((source[i] >= 'a' && source[i] <= 'f') ||
                    (source[i] >= 'A' && source[i] <= 'F') ||
                    (source[i] >= '0' && source[i] <= '9')))
                return false;
        }
        if (str.length() > 2) {
            popupMessage(getString("valid_mac_item_required"));
//            super.popupMessage(getString("Please specify a value between 00 and FF"));
            return false;
        }
//            if ( ( str.length() == 2 ) && ( getIndex() == 0 ) && ( Integer.parseInt( str, 16 ) % 2 == 1 ) )
//            {
//
//                 super.popupMessage( getString("The first field must be even") );
//                return false;
//            }
        return true;
    }

}
