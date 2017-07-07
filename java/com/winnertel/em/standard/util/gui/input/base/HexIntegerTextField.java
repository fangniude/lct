package com.winnertel.em.standard.util.gui.input.base;


public class HexIntegerTextField extends FormattedField {
    int textFieldLength = 2;
    private int max = Integer.MAX_VALUE,min = Integer.MIN_VALUE;

    public HexIntegerTextField() {
        this(0);
        textFieldLength = -1;
    }

    public HexIntegerTextField(int aIndex) {
        super(aIndex);
    }

    public HexIntegerTextField(int aIndex, int length) {
        super(aIndex);

        if (length > 0) textFieldLength = length;
    }

    public void setValue(String value) {
        setText(value);
    }

    public void setValueScope(int aMin, int aMax) {
        if (aMin > aMax)
            return;
        max = aMax;
        min = aMin;
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
        if (str.length() > 2 && textFieldLength == 2) {
            popupMessage(getString("valid_mac_item_required"));
//            super.popupMessage(getString("Please enter a value between 00 and FF"));
            return false;
        }

        if (str.equals("") && min != Integer.MIN_VALUE) {
            setText(String.valueOf(min));
            popupMessage(Integer.toHexString(min), Integer.toHexString(max));
        }
        if (max != Integer.MAX_VALUE || min != Integer.MIN_VALUE) {
            if (!isValidValue(str)) {
//                if (this.defaultValue != Integer.MIN_VALUE) {
//                    setText(String.valueOf(defaultValue));
//                }
                setText(String.valueOf(min));
            }
        }

        return true;
    }

    private boolean isValidValue(String s) {
        try {
            return isValidValue(Integer.parseInt(s, 16));
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidValue(int value) {
        if (max != Integer.MAX_VALUE || min != Integer.MIN_VALUE) {
            if (value < min || value > max) {
                return false;
            }
        }
        return true;
    }

    public void popupMessage( String min, String max ) {
        popupMessage( getString( "Please enter a value between " )
                + min + getString( " and " ) + max + getString( "@HexIntegerTail" ) );
    }

}
