package com.winnertel.ems.epon.iad.bbs4000.formatter.r311;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class EventInstanceFormatter extends SnmpFieldFormatter {

    public EventInstanceFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Integer entityType = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, "utsBbsEventLogEntityType");
        Long value = (Long) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        int instance = value.intValue();

        String strInstance = String.valueOf(instance);

        //
        // for BBS4000 v2.1.6
        //
        // In 4-6-6-8-8 shelf-slot-port-OnuID-OnuUNI port format,
        // port is set to 63,
        // ONU ID is set to 255,
        // ONU UNI port ID is set to 255
        //
        if(entityType == 2001) {
            strInstance = "Node";
        } else if(entityType == 2005) {
            int shelf = instance >> 28;
            strInstance = String.valueOf(shelf);
        } else if(entityType == 2006) {
            int shelf = instance >> 28;
            int groupid = instance - (shelf << 28);
            //strInstance = String.valueOf(shelf) + "-" + String.valueOf(groupid);
            strInstance = String.valueOf(groupid);
        } else if(entityType == 2002 || entityType == 2003 || entityType == 2004) {
            int shelf = instance >> 28;
            int slot = (instance - (shelf << 28)) >> 22;
            //strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot);
            strInstance = String.valueOf(slot);
        } else if(entityType == 2007) {
            int shelf = instance >> 28;
            int slot = (instance - (shelf << 28)) >> 22;
            int port = (instance - (shelf << 28) - (slot << 22)) >> 16;
            //strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot) + "-" + String.valueOf(port);
            strInstance = String.valueOf(slot) + "-" + String.valueOf(port);
        } else if(entityType == 2008) {
            int shelf = instance >> 28;
            int slot = (instance - (shelf << 28)) >> 22;
            int port = (instance - (shelf << 28) - (slot << 22)) >> 16;
            int onu = (instance - (shelf << 28) - (slot << 22) - (port << 16)) >> 8;
            //strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot) + "-" + String.valueOf(port) + "-" + onu;
            strInstance = String.valueOf(slot) + "-" + String.valueOf(port) + "-" + onu;
        } else if(entityType == 2009 || entityType == 2010 || entityType == 2011 || entityType == 2012) {
            int shelf = instance >> 28;
            int slot = (instance - (shelf << 28)) >> 22;
            int port = (instance - (shelf << 28) - (slot << 22)) >> 16;
            int onu = (instance - (shelf << 28) - (slot << 22) - (port << 16)) >> 8;
            int uni = instance - (shelf << 28) - (slot << 22) - (port << 16) - (onu << 8);
            //strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot) + "-" + String.valueOf(port) + "-" + onu + "-" + uni;
            strInstance = String.valueOf(slot) + "-" + String.valueOf(port) + "-" + onu + "-" + uni;
        }

        //
        // for ONU4024i, ONU404i
        //
        // In 8-8-8 shelf-slot-port format,
        // slot and port is set to 255
        //
        else if(entityType == 1000) {
            strInstance = "ONU Node";
        } else if(entityType == 1001) {
            int shelf = instance >> 16;
            strInstance = String.valueOf(shelf);
        } else if(entityType == 1005 || entityType == 1009 || entityType == 1012 || entityType == 1014) {
            int shelf = instance >> 16;
            int slot = (instance - (shelf << 16)) >> 8;
            int port = (instance - (shelf << 16) - (slot << 8));
            //strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot) + "-" + String.valueOf(port);
            strInstance = String.valueOf(slot) + "-" + String.valueOf(port);
        } else if(entityType == 1015) {
            int shelf = instance >> 16;
            int slot = (instance - (shelf << 16)) >> 8;
            int port = (instance - (shelf << 16) - (slot << 8));
            int channel = 1; //channnel is fixed at 1, others are reserved.
            //strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot) + "-" + String.valueOf(port) + "-" + channel;
            strInstance = String.valueOf(slot) + "-" + String.valueOf(port) + "-" + channel;
        } else if(entityType == 1002 || entityType == 1013 || entityType == 1016) {
            //strInstance = "0-0";
            strInstance = "0";
        } else if(entityType == 1003) {
            //TODO
            //Clock
        } else if(entityType == 1004) {
            //TODO
            //External
        } else if(entityType == 1007) {
            //TODO
            //V5 Signaling
        } else if(entityType == 1008) {
            //TODO
            //V5 E1 Link
        } else if(entityType == 1010) {
            //TODO
            //MG
        } else if(entityType == 1011) {
            //TODO
            //Fax Service
        }

        return strInstance;
    }

}