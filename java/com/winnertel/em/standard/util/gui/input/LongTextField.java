package com.winnertel.em.standard.util.gui.input;

import com.winnertel.em.standard.util.gui.input.base.FormattedField;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.MessageFormat;
import java.util.HashMap;

public class LongTextField extends FormattedField {
    public static final int MAX_COLUMN = 20;
    private long max = Long.MAX_VALUE, min = Long.MIN_VALUE;
    ;
    private long defaultValue = Long.MIN_VALUE;
    private HashMap validValues;

    public LongTextField() {
        this(0);
    }

    private LongTextField(int aIndex) {
        super(aIndex);
        this.setColumns(MAX_COLUMN);

        this.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            }

            public void focusLost(FocusEvent e) {
                focusLostVerify();
            }
        });
    }

    public void setValue(long value) {
        if (!isValidValue(value)) return;
        setText("" + value);
    }

    public void setDefaultValue(long value) {
        defaultValue = value;
        setText("" + value);
    }

    public long getValue() {
        if (getText().equals("")) return 0;
        return Long.parseLong(this.getText());
    }

    public void addValidValue(long value) {
        if (validValues == null) validValues = new HashMap();
        validValues.put(new Long(value), "");
    }

    private boolean isValidValue(long value) {
        if (max != Long.MAX_VALUE || min != Long.MIN_VALUE) {
            if (value < min || value > max) {
                if (validValues == null) return false;
                return validValues.get(new Long(value)) == null ? false : true;
            }
            ;
        }
        return true;
    }

    public void setValueScope(long aMin, long aMax) {
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
        if (str.equals("") && min != Long.MIN_VALUE) {
            setText(String.valueOf(min));
            popupMessage(min, max);
        }
        if (max != Long.MAX_VALUE && min != Long.MIN_VALUE) {
            if (!isValidValue(Long.parseLong(str))) {
                if (this.defaultValue != Long.MIN_VALUE) {
                    setText(String.valueOf(defaultValue));
                } else
                    setText(String.valueOf(min));
                popupMessage(min, max);

                //    this.requestFocus();
            }
        }
    }

    //set the right value and popup a message ,or there are repeat verification;
    public boolean insertVerify(String strOrigin, int iOffsets, String strInserted, int cellIndex) {

        String str = strOrigin.substring(0, iOffsets)
                + strInserted
                + strOrigin.substring(iOffsets, strOrigin.length());
        char[] source = str.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (!(source[i] >= '0' && source[i] <= '9'))
                return false;
        }
        if (max == Long.MAX_VALUE && min == Long.MIN_VALUE) return true;
        if ((Long.parseLong(str)) > max) {
            setText("" + max);
            popupMessage(min, max);
            return false;
        }

        return true;
    }

    public void popupMessage(long min, long max) {
        popupMessage(MessageFormat.format(getString("value_between"), min, max));
//        popupMessage(getString("Please enter a value between ")
//                + min + getString(" and ") + max + getString("@IntegerTail"));
    }
}

