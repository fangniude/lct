/**
 * Created by Zhou Chao, 2010/7/6
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuAuthenticationBlockTable extends SnmpMibBean {

    public static final String onuAuthenBlockOnuId = "onuAuthenBlockOnuId";
    public static final String onuAuthenBlockMacAddress = "onuAuthenBlockMacAddress";
    public static final String authenTime = "authenTime";

    public OnuAuthenticationBlockTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuAuthenBlockOnuId, new SnmpMibBeanProperty(onuAuthenBlockOnuId, ".1.3.6.1.4.1.17409.2.3.4.5.3.1.1", ISnmpConstant.INTEGER));
        initProperty(onuAuthenBlockMacAddress, new SnmpMibBeanProperty(onuAuthenBlockMacAddress, ".1.3.6.1.4.1.17409.2.3.4.5.3.1.2", ISnmpConstant.OCTETS));
        initProperty(authenTime, new SnmpMibBeanProperty(authenTime, ".1.3.6.1.4.1.17409.2.3.4.5.3.1.3", ISnmpConstant.TIME_TICKS));
    }

    public Integer getOnuAuthenBlockOnuId() {
        return (Integer) getIndex(0);
    }

    public void setOnuAuthenBlockOnuId(Integer aOnuAuthenBlockOnuId) {
        setIndex(0, aOnuAuthenBlockOnuId);
    }

    public byte[] getOnuAuthenBlockMacAddress() {
        return (byte[]) getProperty(onuAuthenBlockMacAddress).getValue();
    }

    public void setOnuAuthenBlockMacAddress(byte[] aOnuAuthenBlockMacAddress) {
        getProperty(onuAuthenBlockMacAddress).setValue(aOnuAuthenBlockMacAddress);
    }

    public Long getAuthenTime() {
        return (Long) getProperty(authenTime).getValue();
    }

    public void setAuthenTime(Long aAuthenTime) {
        getProperty(authenTime).setValue(aAuthenTime);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuAuthenBlockMacAddress));
        prepareRead(getProperty(authenTime));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuAuthenBlockMacAddress));
        prepareRead(getProperty(authenTime));

        return loadAll(new int[]{1});
    }

}