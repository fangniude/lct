package com.winnertel.lct.batch.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Lewis
 * 2017-07-15.
 */
public class VlanMemberFormatter extends SnmpFieldFormatter {

    private final Vector<String> portList;

    public VlanMemberFormatter(IApplication anApplication) {
        super(anApplication);
        portList = getPortList();
    }

    @Override
    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        if (aProperty.equals("member")) {
            String tagMemberHex = String.valueOf(MibBeanUtil.getSimpleProperty(aMibBean, "tagMember"));
            String tagedPort = getTagedPort(tagMemberHex);
            List<String> tagedStrList = new ArrayList<>();
            for (int i = 0; i < tagedPort.length(); i++) {
                if (tagedPort.charAt(i) == '1') {
                    tagedStrList.add(portList.get(i));
                }
            }
            return String.join(", ", tagedStrList);
        } else if ("tagMember".equals(aProperty)) {
            String memberHex = String.valueOf(MibBeanUtil.getSimpleProperty(aMibBean, "member"));
            String tagMemberHex = String.valueOf(MibBeanUtil.getSimpleProperty(aMibBean, "tagMember"));
            String tagedPort = getUnTagedPort(memberHex, tagMemberHex);
            List<String> tagedStrList = new ArrayList<>();
            for (int i = 0; i < tagedPort.length(); i++) {
                if (tagedPort.charAt(i) == '1') {
                    tagedStrList.add(portList.get(i));
                }
            }
            return String.join(", ", tagedStrList);
        }
        return "";
    }

    private String getTagedPort(String tagMember) {
        String str = Integer.toBinaryString(Integer.valueOf(tagMember.substring(2), 16));
        StringBuilder sb = new StringBuilder(str).reverse();
        while (sb.length() < 8) {
            sb.append("0");
        }
        return sb.toString();
    }

    private String getUnTagedPort(String member, String tagMember) {
        Integer mem = Integer.valueOf(member.substring(2), 16);
        Integer tag = Integer.valueOf(tagMember.substring(2), 16);
        int unTag = mem ^ tag;
        String str = Integer.toBinaryString(unTag);
        StringBuilder sb = new StringBuilder(str).reverse();
        while (sb.length() < 8) {
            sb.append("0");
        }
        return sb.toString();
    }

    private Vector<String> getPortList() {
        Vector<String> allPortList = new Vector();
        allPortList.add("PON 1/1");
        allPortList.add("PON 1/2");
        allPortList.add("PON 1/3");
        allPortList.add("PON 1/4");
        allPortList.add("GE 2/1");
        allPortList.add("GE 2/2");
        allPortList.add("GE 2/3");
        allPortList.add("GE 2/4");

        return allPortList;
    }
}
