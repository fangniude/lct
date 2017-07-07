package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;

import java.util.Properties;

public class SnmpFieldReference {
    private SnmpMibBean fMibBean = null;

    private String fMibProperty = null;

    private Properties fCondtion = new Properties();


    public SnmpFieldReference(SnmpMibBean aMibBean, String aMibProperty) {
        fMibBean = aMibBean;
        fMibProperty = aMibProperty;
    }


    public SnmpMibBean getMibBean() {
        return fMibBean;
    }

    public String getMibProperty() {
        return fMibProperty;
    }


    public void addConditionItem(String aMibProperty, String aRefMibProperty) {
        fCondtion.setProperty(aMibProperty, aRefMibProperty);
    }

    public Properties getCondition() {
        return fCondtion;
    }
}
