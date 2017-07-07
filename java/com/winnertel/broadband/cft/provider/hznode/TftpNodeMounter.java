/*
* Copyright (c) 2002-2003 UTStarcom, Inc.
* All rights reserved.
*
* Created on 2004-11-3
*/
package com.winnertel.broadband.cft.provider.hznode;

import com.winnertel.broadband.cft.context.Context;
import com.winnertel.broadband.cft.mounter.IDirFetcher;
import com.winnertel.broadband.cft.mounter.MountException;
import com.winnertel.broadband.cft.mounter.Mounter;
import com.winnertel.broadband.cft.unit.IMutableUnit;
import com.winnertel.broadband.cft.unit.impl.NodeFile;
import com.winnertel.broadband.cft.unit.impl.NodeFileUnit;
import com.winnertel.broadband.cft.unit.impl.NodeLoadPara;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.snmp.snmp2.DefaultSnmpException;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TftpNodeMounter extends Mounter {

    public TftpNodeMounter(IDirFetcher fetcher) {
        super(fetcher);
    }

    public void mount(Context context, IMutableUnit root) throws MountException {
        SnmpParameter para = new SnmpParameter(context.getMoIp());
        SnmpProxy proxy = new SnmpProxy(para);
        buildNode(root, proxy, "flash://");
    }

    private void buildNode(IMutableUnit node, SnmpProxy proxy, String dir) {
        String s = getFilesBySnmp(proxy, dir);

        String[] fileList = parseFileList(s);

        for (String s1 : fileList) {
            String[] split = s1.split(",");
            NodeFile file = null;
            if (split.length < 4) {
                continue;// TODO now the first package NE received form NE only 3 items
            }
            IMutableUnit child = null;
            if (split.length == 4) {// is file? format: filename, size, date, time
                file = new NodeFile(split[0], Long.valueOf(split[1]), String.format("%s-%s", split[2], split[3]), true);
            } else { // is dir ? format: filename,DIR,size,date,time
                file = new NodeFile(split[0], Long.valueOf(split[2]), String.format("%s-%s", split[3], split[4]), false);
            }
            NodeLoadPara loadPara = new NodeLoadPara(split[0], ((NodeLoadPara) node.getLoadInfo()).getPort());
            child = new NodeFileUnit(file, loadPara);

            if (!child.isLeaf() && !".".equals(child.getName()) && !"..".equals(child.getName())) {
                buildNode(child, proxy, dir + child.getName() + File.separator);
            }

            child.setParent(node);
            node.addChild(child);
        }

    }

    private String getFilesBySnmp(SnmpProxy proxy, String dir) {
        try {
            if (saveSuccess(proxy, dir)) {
                Thread.sleep(2000);
                String[] valueList = {
                        ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.3.0",
                        ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.8.0"
                };

                StringBuffer sb = new StringBuffer();

                while (true) {
                    Object[] result = proxy.loadRow(valueList);
                    byte[] v = (byte[]) result[0];
                    if (v != null && v.length > 0) {
                        sb.append(new String(v));

                        Object o = result[1];
                        if (result[1] == null || "1".equals(o.toString())) {
                            break;
                        }
                    } else {
                        break;
                    }
                }

                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean saveSuccess(SnmpProxy proxy, String dir) throws DefaultSnmpException {
        String[] oidsList = {
                ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.2.0",
                ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.1.0"
        };

        Object[] valueList = {
                dir, 1
        };

        byte[] typeList = {
                ISnmpConstant.STRING, ISnmpConstant.INTEGER
        };

        return proxy.saveRow(oidsList, valueList, typeList);

    }

    private String[] parseFileList(String fileList) {
        StringTokenizer st = new StringTokenizer(fileList, ";");
        ArrayList list = new ArrayList(st.countTokens());

        while (st.hasMoreTokens()) {
            String temp = st.nextToken().trim();
            if (temp != null && !temp.equals("")) {
                if (temp.startsWith("'") && temp.endsWith("'")) {
                    temp = temp.substring(1, temp.length() - 1);
                }
                if (temp.length() > 0)
                    list.add(temp);
            }
        }

        return (String[]) list.toArray(new String[0]);
    }

}
