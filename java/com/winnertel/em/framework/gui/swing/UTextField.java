package com.winnertel.em.framework.gui.swing;

import com.klg.jclass.field.JCTextField;
import com.klg.jclass.field.validate.JCValidator;
import com.klg.jclass.util.value.JCValueModel;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class UTextField extends JCTextField {
    public UTextField() {
        this(null, null);
    }

    public UTextField(JCValueModel aValueModel) {
        this(aValueModel, null);
    }

    public UTextField(JCValueModel aValueModel, JCValidator aValidator) {
        super(aValueModel, aValidator);
        setDocument(new LimitedDocument(0));
    }


    public void setMaxLength(int len) {
        ((LimitedDocument) getDocument()).setMaxCharacters(len);
    }


    public void setValue(Object o) {
        super.setValue(o);

        if (o == null) {
            super.setText(null);
        } else {
            super.setText(o.toString());
        }
    }


    private class LimitedDocument extends PlainDocument {
        int fMaxCharacters;


        public LimitedDocument() {
            // no limitation
            fMaxCharacters = 0;
        }

        public LimitedDocument(int maxChars) {
            fMaxCharacters = maxChars;
        }


        public void setMaxCharacters(int aMaxCharacters) {
            fMaxCharacters = aMaxCharacters;
        }


        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {

            if ((str == null) || (str.length() == 0)) {
                return;
            }

            if ((fMaxCharacters == 0 || (getLength() + str.length()) <= fMaxCharacters))
                super.insertString(offs, str, a);
            else {
                Toolkit.getDefaultToolkit().beep();
                super.insertString(offs, str.substring(0, fMaxCharacters - getLength()), a);
            }
        }
    }

}
