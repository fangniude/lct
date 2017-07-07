/**
 * Created by Zhou Chao, 2009/3/13
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponSfpE1MngIpCfgTable extends SnmpMibBean {

    public static final String sfpE1MngIpCfgSlotNo = "sfpE1MngIpCfgSlotNo";
    public static final String sfpE1MngIpCfgPortNo = "sfpE1MngIpCfgPortNo";
    public static final String sfpE1MngIpCfgMngIpAddress = "sfpE1MngIpCfgMngIpAddress";
    public static final String sfpE1MngIpCfgMngIpMask = "sfpE1MngIpCfgMngIpMask";
    public static final String sfpE1MngIpCfgMngIpDefaultGw = "sfpE1MngIpCfgMngIpDefaultGw";

    public GponSfpE1MngIpCfgTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgSlotNo, new SnmpMibBeanProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1001.1.1.1", ISnmpConstant.INTEGER));
        initProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgPortNo, new SnmpMibBeanProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1001.1.1.2", ISnmpConstant.INTEGER));
        initProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpAddress, new SnmpMibBeanProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpAddress, ".1.3.6.1.4.1.41355.1.3.10.5.1001.1.1.11", ISnmpConstant.IP_ADDRESS));
        initProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpMask, new SnmpMibBeanProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpMask, ".1.3.6.1.4.1.41355.1.3.10.5.1001.1.1.12", ISnmpConstant.IP_ADDRESS));
        initProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpDefaultGw, new SnmpMibBeanProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpDefaultGw, ".1.3.6.1.4.1.41355.1.3.10.5.1001.1.1.13", ISnmpConstant.IP_ADDRESS));
    }

    public Integer getSfpE1MngIpCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setSfpE1MngIpCfgSlotNo(Integer aSfpE1MngIpCfgSlotNo) {
        setIndex(0, aSfpE1MngIpCfgSlotNo);
    }

    public Integer getSfpE1MngIpCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setSfpE1MngIpCfgPortNo(Integer aSfpE1MngIpCfgPortNo) {
        setIndex(1, aSfpE1MngIpCfgPortNo);
    }

    public String getSfpE1MngIpCfgMngIpAddress() {
        return (String) getProperty(sfpE1MngIpCfgMngIpAddress).getValue();
    }

    public void setSfpE1MngIpCfgMngIpAddress(String aSfpE1MngIpCfgMngIpAddress) {
        getProperty(sfpE1MngIpCfgMngIpAddress).setValue(aSfpE1MngIpCfgMngIpAddress);
    }

    public String getSfpE1MngIpCfgMngIpMask() {
        return (String) getProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpMask).getValue();
    }

    public void setSfpE1MngIpCfgMngIpMask(String aSfpE1MngIpCfgMngIpMask) {
        getProperty(sfpE1MngIpCfgMngIpMask).setValue(aSfpE1MngIpCfgMngIpMask);
    }

    public String getSfpE1MngIpCfgMngIpDefaultGw() {
        return (String) getProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpDefaultGw).getValue();
    }

    public void setSfpE1MngIpCfgMngIpDefaultGw(String aSfpE1MngIpCfgMngIpDefaultGw) {
        getProperty(sfpE1MngIpCfgMngIpDefaultGw).setValue(aSfpE1MngIpCfgMngIpDefaultGw);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpAddress));
        prepareRead(getProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpMask));
        prepareRead(getProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpDefaultGw));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpAddress));
        prepareRead(getProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpMask));
        prepareRead(getProperty(GponSfpE1MngIpCfgTable.sfpE1MngIpCfgMngIpDefaultGw));

        return loadAll(new int[]{1, 1});
    }

}
