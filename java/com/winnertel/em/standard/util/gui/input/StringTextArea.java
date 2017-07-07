package com.winnertel.em.standard.util.gui.input;

import com.winnertel.em.standard.util.gui.input.base.FormattedArea;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class StringTextArea extends FormattedArea {
    private int minLen = -1;
    private int maxLen = -1;
    private String defaultString;

    //private FormattedField realTextField = new FormattedField(0);
    public StringTextArea() {
        this(10); //modify it using setColumns()
    }

    public void setValue(String text) {
        if (maxLen == -1 && minLen == -1) {
            setText(text);
            return;
        }
        if (text.getBytes().length > maxLen && maxLen != -1) {
            byte[] maxBytes = new byte[maxLen];
            System.arraycopy(text.getBytes(), 0, maxBytes, 0, maxLen);
            setText(new String(maxBytes));
            return;
        }
        if (text.getBytes().length < minLen) {
            if (defaultString == null) {
                setText(getDefaultString(minLen));     // must have a default value!!
                //super.popupMessage(minLen,maxLen,"");    // quiet
            } else {
                setText(defaultString);
                //super.popu pMessage( minLen,maxLen,  ","+ getString("defaultString")+": "+defaultString);
            }
        }
        setText(text);
    }

    public String getValue() {
        return getText();
    }

    public void setMaxLen(int maxLen) {
        if (maxLen <= 0) return;
        this.maxLen = maxLen;
    }

    public void setLenScope(int minLen, int maxLen) {
        if (minLen < 0 || maxLen < 0 || maxLen < minLen) return;
        this.minLen = minLen;
        this.maxLen = maxLen;
        setText(getDefaultString(minLen));
    }

    public void setDefaultString(String defaultString) {
        this.defaultString = defaultString;
        setText(defaultString);
    }

    public StringTextArea(int columns) {
        super(0);
        this.setColumns(columns);
        this.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {

            }

            public void focusLost(FocusEvent e) {
                if (e.isTemporary()) return;
                focusLostVerify();
            }
        });
    }

    private String getDefaultString(int len) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++)
            sb.append(" ");
        return sb.toString();
    }

    private void focusLostVerify() {
        if (!this.isEditable()) return;
        if (!this.isEnabled()) return;
        if (minLen != -1 && maxLen != -1) {
            if (getText().getBytes().length < minLen) {
                if (defaultString == null) {
                    setText(getDefaultString(minLen));     // must have a default value!!
                    super.popupMessage(minLen, maxLen, "");
                } else {
                    setText(defaultString);
                    super.popupMessage(minLen, maxLen, "," + getString("defaultString") + ": " + defaultString);
                }


            }
        }
    }

    public boolean insertVerify(String strOrigin, int iOffsets, String strInserted, int cellIndex) {

        if (maxLen == -1 && minLen == -1) return true;
        String str = strOrigin.substring(0, iOffsets)
                + strInserted
                + strOrigin.substring(iOffsets, strOrigin.length());
        if (str.getBytes().length > maxLen) {
            if (minLen == -1) // not specify the minLen;
            {
                super.popupMessage(maxLen, "");
            } else
                super.popupMessage(minLen, maxLen, "");
            return false;
        }
        return true;
    }

}
