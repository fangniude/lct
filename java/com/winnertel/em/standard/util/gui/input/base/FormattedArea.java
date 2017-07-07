package com.winnertel.em.standard.util.gui.input.base;

import com.winnertel.em.standard.util.gui.input.resource.ResourceBundleProxy;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.text.MessageFormat;

public abstract class FormattedArea extends JTextArea {
    private Toolkit toolkit;
    private int index;
    private ResourceBundleProxy bundleProxy;
    private String _name;

    //public abstract void setValue( String value );
    public abstract boolean insertVerify(String strOrigin, int iOffsets, String strInserted, int cellIndex);

    public int getIndex() {
        return index;
    }

    public FormattedArea(int aIndex) {
        super();
        index = aIndex;
        toolkit = Toolkit.getDefaultToolkit();

    }

    public void setName(String name) {
        _name = name;
    }

    protected String getString(String string) {
        if (bundleProxy == null)
            bundleProxy = ResourceBundleProxy.getInstance();
        return bundleProxy.getString(string);
    }

    public void popupMessage(int minLen, int maxLen, String lastString) {
        popupMessage(MessageFormat.format(getString("string_length_between"), minLen, maxLen, lastString));
//
//        popupMessage(getString("Please specify a string what length is between ")
//                + minLen + getString("_and_") + maxLen + getString("@StringTail") + lastString);
    }

    public void popupMessage(int maxLen, String lastString) {

        popupMessage(MessageFormat.format(getString("string_should_less"), maxLen, lastString));
//        popupMessage(getString("Please specify a string what length is less than ")
//                + maxLen + getString("@LessTail") + lastString);
    }

    public void popupMessage(int min, int max) {
        //888 is not a valid entry. Please specify a integer between min and max
        popupMessage(MessageFormat.format(getString("value_between"), min, max));
//        popupMessage(getString("Please_specify_a_value_between_")
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
        //this.requestFocus(); // this line can bring subtle problem ,
        // but there is a focus lost verification , if have not this line
        // the textfield must have a default value instead.
        // so i have to use this line
        // pls check all class for avoiding repeat of this line
        //todo  , ipaddress have this question , but it seems ok.

    }

    protected Document createDefaultModel() {
        return new FormattedArea.CommonDocument();
    }

    protected class CommonDocument extends PlainDocument {


        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if (str == null) return;
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (insertVerify(getText(0, getLength()), offs, str, index) == true) {
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
