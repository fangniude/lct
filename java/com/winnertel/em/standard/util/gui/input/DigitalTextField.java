package com.winnertel.em.standard.util.gui.input;

import com.winnertel.em.standard.util.gui.input.base.FormattedField;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class DigitalTextField extends FormattedField {
    private int minLen = -1;
    private int maxLen = -1;
    private String defaultString = "";

    public DigitalTextField() {
        this(10);
    }

    public DigitalTextField(int columns) {
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

    public String getValue() {
        return getText();
    }

    public void setValue(String text) {
        if (text == null || text.trim().equals("")) {
            if (maxLen == -1 && minLen == -1) {
                setText("");
                return;
            } else {
                return;
            }
        }

        String str = text.trim();
        if (!isDigital(str)) return;

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
            return;
        }

        setText(text);
    }


    public void setMinLen(int minLen) {
        if (minLen <= 0 || minLen > maxLen) return;
        this.minLen = minLen;

        fireScopeChangedEvent();
    }

    public void setMaxLen(int maxLen) {
        if (maxLen <= 0) return;
        this.maxLen = maxLen;

        fireScopeChangedEvent();
    }

    public void setLenScope(int minLen, int maxLen) {
        if (minLen < 0 || maxLen < 0 || maxLen < minLen) return;
        this.minLen = minLen;
        this.maxLen = maxLen;

        fireScopeChangedEvent();
    }

    protected void fireScopeChangedEvent() {
        String text = getText();

        if (text.getBytes().length > maxLen && maxLen != -1) {
            byte[] maxBytes = new byte[maxLen];
            System.arraycopy(text.getBytes(), 0, maxBytes, 0, maxLen);
            setText(new String(maxBytes));
            return;
        }
    }

    public void setDefaultString(String defaultString) {
        if (checkValid(defaultString)) {
            this.defaultString = defaultString;
            setText(defaultString);
        }
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
        String str = strOrigin.substring(0, iOffsets)
                + strInserted
                + strOrigin.substring(iOffsets, strOrigin.length());

        if (!isDigital(str)) return false;

        if (maxLen == -1 && minLen == -1) return true;
        if (str.getBytes().length > maxLen) {
            if (minLen == -1) // not specify the minLen;
            {
                super.popupMessage(maxLen, "");
            } else {
                super.popupMessage(minLen, maxLen, "");
            }
            return false;
        }
        return true;
    }

    public boolean checkValid() {
        return checkValid(getText());
    }

    protected boolean checkValid(String text) {
        if (text == null || text.trim().equals("")) {
            if (maxLen == -1 && minLen == -1) {
                return true;
            } else {
                return false;
            }
        }

        String str = text.trim();

        if (!isDigital(str)) return false;

        if (maxLen == -1 && minLen == -1) {
            return true;
        }

        if (text.getBytes().length > maxLen && maxLen != -1) {
            return false;
        }

        if (text.getBytes().length < minLen) {
            return false;
        }

        return true;
    }

    protected boolean isDigital(String text) {
        String str = text.trim();
        char[] source = str.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (!(source[i] >= '0' && source[i] <= '9'))
                return false;
        }

        return true;
    }

}
