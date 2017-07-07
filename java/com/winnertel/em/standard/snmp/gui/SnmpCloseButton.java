package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnmpCloseButton extends JButton {
    private IApplication fApplication = null;


    public SnmpCloseButton(IApplication anApplication, final Container aContainer) {
        fApplication = anApplication;
        setText(fApplication.getGlobalStringMap().getString("Close"));
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiUtil.getParentDialog(aContainer).dispose();
            }
        });
    }
}
