package com.winnertel.em.standard.util.gui.input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MacAddressComboBoxEditor extends MacAddressField implements ComboBoxEditor {
    public MacAddressComboBoxEditor() {
    }

    public Component getEditorComponent() {
        return this;
    }

    public void setItem(Object anObject) {
        if (anObject != null)
            setValue(anObject.toString());
        else
            setValue((String) null);
    }

    public Object getItem() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < cells.length; i++) {
            sb.append(cells[i].getText()).append(":");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void selectAll() {
    }

    public void addActionListener(ActionListener l) {
    }

    public void removeActionListener(ActionListener l) {
    }
}