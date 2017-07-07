package com.winnertel.em.standard.util.gui.input.base;

import com.winnertel.em.standard.util.gui.input.factory.TextFieldFactory;

public class IPTextField extends FormattedField {

    int textFieldLength = 3;
    private int type;

    private boolean verifyValue(int cellIndex, int value) {
        if (cellIndex == 0) {
            switch (type) {
                case TextFieldFactory.IPMASK: {
                    if (value > 255) {
                        setText("255");
                        popupMessage(0, 255);
                        return false;
                    }
                    break;
                }

                case TextFieldFactory.IPMULTICAST: {
                    if (value > 239 || (value >= 100 && value < 224)) {
                        setText("224");
                        popupMessage(224, 239);
                        return false;
                    }
                    break;
                }
                case TextFieldFactory.IPUNICAST: {
                    if (value > 223 || value < 1) {
                        setText("223");
                        popupMessage(1, 223);
                        return false;
                    }
                    break;
                }
                case TextFieldFactory.IPUNICAST_INCLUDING_UNKNOWN: {
                    if (value > 223 || value < 0) {
                        setText("0");
                        popupMessage(0, 223);
                        return false;
                    }
                    break;
                }
            }
        } else {
            if (value > 255) {
                setText("0");
                popupMessage(0, 255);
                return false;
            }
        }
        return true;
    }

    ;

    public boolean insertVerify(String strOrigin, int iOffsets, String strInserted, int cellIndex) {
        if (!this.isEditable()) return true;
        String str = strOrigin.substring(0, iOffsets)
                + strInserted
                + strOrigin.substring(iOffsets, strOrigin.length());
        if (str.length() > 3) return false;
        char[] source = str.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] > '9' || source[i] < '0') return false;
        }
        int value = Integer.parseInt(str);
        return verifyValue(cellIndex, value);// only verify the max,the min is verified by focuslost

    }

    public IPTextField(int type, int aIndex) {
        super(aIndex);
        this.type = type;
    }

    public void setValue(String value) {
        setText(value);
    }


}

