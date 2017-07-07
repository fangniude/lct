package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.MacAddressFormatter;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class AclRuleFieldFormatter  extends SnmpFieldFormatter {

    public AclRuleFieldFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
//            cbMatchedSourseMac.setSelected();
//            cbMatchedDestinationMac.setSelected((mask[0] & 0x40) != 0);
//            cbMatchedVlanId.setSelected((mask[0] & 0x20) != 0);
//            cbMatchedEthernetType.setSelected((mask[0] & 0x10) != 0);
//            cbMatchedSourseIP.setSelected((mask[0] & 0x08) != 0);
//            cbMatchedDestinationIP.setSelected((mask[0] & 0x04) != 0);
//            cbMatchedIpMessageType.setSelected((mask[0] & 0x02) != 0);
//            cbMatchedDscp.setSelected((mask[0] & 0x01) != 0);
//            cbMatchedSoursePort.setSelected((mask[1] & 0x80) != 0);
//            cbMatchedDestinationPort.setSelected((mask[1] & 0x40) != 0);
//
        byte[] mask = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, "matchedFieldSelection");
        if(mask == null || mask.length < 2) return null;
        
        if("matchedSourseMac".equals(aProperty)) {
            if((mask[0] & 0x80) != 0) {
                return MacAddressFormatter.format((byte[])MibBeanUtil.getSimpleProperty(aMibBean, aProperty));
            }
        } else if("matchedDestinationMac".equals(aProperty)) {
            if((mask[0] & 0x40) != 0) {
                return MacAddressFormatter.format((byte[])MibBeanUtil.getSimpleProperty(aMibBean, aProperty));
            }
        } else if("matchedVlanId".equals(aProperty)) {
            if((mask[0] & 0x20) != 0) {
                return MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            }
        } else if("matchedEthernetType".equals(aProperty)) {
            if((mask[0] & 0x10) != 0) {
                return MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            }
        } else if("matchedSourseIP".equals(aProperty)) {
            if((mask[0] & 0x08) != 0) {
                return MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            }
        } else if("matchedDestinationIP".equals(aProperty)) {
            if((mask[0] & 0x04) != 0) {
                return MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            }
        } else if("matchedIpMessageType".equals(aProperty)) {
            if((mask[0] & 0x02) != 0) {
                return MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            }
        } else if("matchedDscp".equals(aProperty)) {
            if((mask[0] & 0x01) != 0) {
                return MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            }
        } else if("matchedSoursePort".equals(aProperty)) {
            if((mask[1] & 0x80) != 0) {
                return MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            }
        } else if("matchedDestinationPort".equals(aProperty)) {
            if((mask[1] & 0x40) != 0) {
                return MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            }
        }

        return "-";
    }

}