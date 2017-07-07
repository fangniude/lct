package com.winnertel.em.standard.util.gui.input.base;

import com.winnertel.em.standard.util.gui.input.resource.ResourceBundleProxy;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.text.MessageFormat;


/**
 * The FormattedField interface.
 */
public abstract class FormattedField extends JTextField {
    private int index;
    private ResourceBundleProxy bundleProxy;
    private String _name;

    //public abstract void setValue( String value );
    public abstract boolean insertVerify(String strOrigin, int iOffsets, String strInserted, int cellIndex);

    public int getIndex() {
        return index;
    }

    public FormattedField(int aIndex) {
        super();
        index = aIndex;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getString(String string) {
        if (bundleProxy == null) {
            bundleProxy = ResourceBundleProxy.getInstance();
            bundleProxy.setLocale(getLocale());
        }
        return bundleProxy.getString(string);
    }

    public void popupMessage(int minLen, int maxLen, String lastString) {
        popupMessage(MessageFormat.format(getString("string_length_between"), minLen, maxLen, lastString));
//        popupMessage(getString("Please enter a string value from ")
//                + minLen + getString(" to ") + maxLen + getString("@StringTail") + lastString);
    }

    public void popupMessage(int maxLen, String lastString) {
        popupMessage(MessageFormat.format(getString("string_should_less"), maxLen, lastString));
//        popupMessage(getString("Please enter a string what length is less than ")
//                + maxLen + getString("@LessTail") + lastString);
    }

    public void popupMessage(int min, int max) {
        //888 is not a valid entry. Please specify a integer between min and max
        popupMessage(MessageFormat.format(getString("value_between"), min, max));
//        popupMessage(getString("Please enter a value between ")
//                + min + getString(" and ") + max + getString("@IntegerTail"));
    }

    public void popupMessage(String aMessage) {
        String displayString;
        if (_name == null)
            displayString = aMessage;
        else
            displayString = _name + "  \n" + aMessage;

        if (SwingUtilities.isEventDispatchThread()) {
            JOptionPane.showMessageDialog(this, displayString, getString("Message"), JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void replaceSelection(String str) {
        String origin = getText();
        String selection = getSelectedText();
        if (selection != null) {
            origin = origin.substring(0, getSelectionStart()) + origin.substring(getSelectionStart() + selection.length());
        }

        if (insertVerify(origin, getSelectionStart(), str, index)) {
            super.replaceSelection(str);
        }
    }

    protected Document createDefaultModel() {
        return new FormattedField.CommonDocument();
    }

    protected class CommonDocument extends PlainDocument {
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if (str == null) return;
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (insertVerify(getText(0, getLength()), offs, str, index)) {
                    result[j++] = source[i];
                } else {
                    //toolkit.beep();
                    return;
                }
            }
            super.insertString(offs, new String(result, 0, j), a);
        }
    }
}
