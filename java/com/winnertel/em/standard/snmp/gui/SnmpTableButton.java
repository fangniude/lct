package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;

public class SnmpTableButton {
    private String fType = null;

    private String fText = null;

    private SnmpAction fAction = null;

    private UDialog fDialog = null;


    public SnmpTableButton(String aType, String aText, SnmpAction aAction) {
        fType = aType;
        fText = aText;
        fAction = aAction;
    }


    public String getType() {
        return fType;
    }

    public void setType(String aType) {
        fType = aType;
    }


    public String getText() {
        return fText;
    }

    public void setText(String aText) {
        fText = aText;
    }


    public SnmpAction getAction() {
        return fAction;
    }

    public void setAction(SnmpAction aAction) {
        fAction = aAction;
    }


    public UDialog getDialog() {
        return fDialog;
    }

    public void setDialog(UDialog aDialog) {
        fDialog = aDialog;
    }
}
