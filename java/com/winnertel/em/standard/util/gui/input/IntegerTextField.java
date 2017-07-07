package com.winnertel.em.standard.util.gui.input;

import com.winnertel.em.standard.util.gui.input.base.FormattedField;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;


public class IntegerTextField extends FormattedField {
    private int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
    ;
    private int defaultValue = Integer.MIN_VALUE;
    private HashMap validValues;

    public IntegerTextField() {
        this(0);
    }

    private IntegerTextField(int aIndex) {
        super(aIndex);
        this.setColumns(10);

        this.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            }

            public void focusLost(FocusEvent e) {
                focusLostVerify();
            }
        });
    }

    public void setValue(int value) {
        if (!isValidValue(value)) return;
        setText("" + value);
    }

    public void setDefaultValue(int value) {
        defaultValue = value;
        setText("" + value);
    }

    public int getValue() {
        if (getText().equals("")) return 0;
        return Integer.parseInt(this.getText());
    }

    public void addValidValue(int value) {
        if (validValues == null) validValues = new HashMap();
        validValues.put(new Integer(value), "");
    }

    private boolean isValidValue(int value) {
        if (max != Integer.MAX_VALUE || min != Integer.MIN_VALUE) {
            if (value < min || value > max) {
                if (validValues == null) return false;
                return validValues.get(new Integer(value)) == null ? false : true;
            }
            ;
        }
        return true;
    }

    private boolean isValidValue(String s) {
        try {
            return isValidValue(Integer.parseInt(s));
        } catch (Exception e) {
            return false;
        }
    }

    public void setValueScope(int aMin, int aMax) {
        if (aMin > aMax) return;
        max = aMax;
        min = aMin;
        setText("" + min);
    }

    //set the right value and popup a message ,or there are repeat verification;
    private void focusLostVerify() {
        if (!this.isEditable()) return;
        if (!this.isEnabled()) return;
        String str = getText();
        if (str.equals("") && min != Integer.MIN_VALUE) {
            setText(String.valueOf(min));
            super.popupMessage(min, max);
            //this.requestFocus();
        }
        if (max != Integer.MAX_VALUE || min != Integer.MIN_VALUE) {
            if (!isValidValue(str)) {
                if (this.defaultValue != Integer.MIN_VALUE) {
                    setText(String.valueOf(defaultValue));
                } else
                    setText(String.valueOf(min));
                super.popupMessage(min, max);

                //    this.requestFocus();
            }
        }
    }

    //set the right value and popup a message ,or there are repeat verification;
    public boolean insertVerify(String strOrigin, int iOffsets, String strInserted, int cellIndex) {

        String str = strOrigin.substring(0, iOffsets)
                + strInserted
                + strOrigin.substring(iOffsets, strOrigin.length());

        if (str.equals("-")) return true;

        char[] source = str.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (i == 0 && source[0] == '-')
                continue;

            if (!(source[i] >= '0' && source[i] <= '9'))
                return false;
        }
        if (max == Integer.MAX_VALUE && min == Integer.MIN_VALUE) return true;
        try {
            if ((Integer.parseInt(str)) > max) {
                setText("" + max);
                super.popupMessage(min, max);
                return false;
            }
        } catch (NumberFormatException ex) {
            setText("" + max);
            super.popupMessage(min, max);
            return false;
        }

        return true;
    }

}
