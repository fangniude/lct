package com.winnertel.em.standard.util.gui.input;

import com.winnertel.em.standard.util.gui.input.base.FormattedField;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.MessageFormat;
import java.util.HashMap;

public class DoubleTextField extends FormattedField {
    public static final int MAX_COLUMN = 20;
    private double max = Double.MAX_VALUE, min = Double.MIN_VALUE;
    ;
    private double defaultValue = Double.MIN_VALUE;
    private HashMap validValues;

    public DoubleTextField() {
        this(0);
    }

    private DoubleTextField(int aIndex) {
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

    public void setValue(double value) {
        if (!isValidValue(value)) return;
        setText("" + value);
    }

    public void setDefaultValue(double value) {
        defaultValue = value;
        setText("" + value);
    }

    public double getValue() {
        if (getText().equals("")) return 0;
        return Double.parseDouble(this.getText());
    }

    public void addValidValue(double value) {
        if (validValues == null) validValues = new HashMap();
        validValues.put(new Double(value), "");
    }

    private boolean isValidValue(double value) {
        if (max != Double.MAX_VALUE || min != Double.MIN_VALUE) {
            if (value < min || value > max) {
                if (validValues == null) return false;
                return validValues.get(new Double(value)) == null ? false : true;
            }
            ;
        }
        return true;
    }

    public void setValueScope(double aMin, double aMax) {
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
        if (str.equals("") && min != Double.MIN_VALUE) {
            setText(String.valueOf(min));
            popupMessage(min, max);
        }
        if (max != Double.MAX_VALUE || min != Double.MIN_VALUE) {
            if (!isValidValue(Double.parseDouble(str))) {
                if (this.defaultValue != Double.MIN_VALUE) {
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

        if (str.equals("-")) return true;

        char[] source = str.toCharArray();
        boolean isPoint = false;
        for (int i = 0; i < source.length; i++) {
            if (i == 0 && source[0] == '-')
                continue;
            if (!isPoint && source[i] == '.') {
                isPoint = true;
                continue;
            }
            if (!(source[i] >= '0' && source[i] <= '9'))
                return false;
        }
        if (max == Double.MAX_VALUE && min == Double.MIN_VALUE) return true;
        if ((Double.parseDouble(str)) > max) {
            setText("" + max);
            popupMessage(min, max);
            return false;
        }

        return true;
    }

    public void popupMessage(double min, double max) {
        popupMessage(MessageFormat.format(getString("value_between"), min, max));
//        popupMessage(getString("Please enter a value between ")
//                + min + getString(" and ") + max + getString("@DoubleTail"));
    }
}
