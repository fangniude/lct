/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class ControlledMulticastPackageTable extends SnmpMibBean {

    public static final String cmIndex = "cmIndex";
    public static final String cmName = "cmName";
    public static final String cmProxyList = "cmProxyList";
    public static final String multicastUserAuthority = "multicastUserAuthority";
    public static final String maxRequestChannelNum = "maxRequestChannelNum";
    public static final String singlePreviewTime = "singlePreviewTime";
    public static final String totalPreviewTime = "totalPreviewTime";
    public static final String previewResetTime = "previewResetTime";
    public static final String previewCount = "previewCount";

    public ControlledMulticastPackageTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(cmIndex, new SnmpMibBeanProperty(cmIndex, ".1.3.6.1.4.1.17409.2.3.6.4.2.1.1", ISnmpConstant.INTEGER));
        initProperty(cmName, new SnmpMibBeanProperty(cmName, ".1.3.6.1.4.1.17409.2.3.6.4.2.1.2", ISnmpConstant.STRING));
        initProperty(cmProxyList, new SnmpMibBeanProperty(cmProxyList, ".1.3.6.1.4.1.17409.2.3.6.4.2.1.3", ISnmpConstant.OCTETS));
        initProperty(multicastUserAuthority, new SnmpMibBeanProperty(multicastUserAuthority, ".1.3.6.1.4.1.17409.2.3.6.4.2.1.4", ISnmpConstant.INTEGER));
        initProperty(maxRequestChannelNum, new SnmpMibBeanProperty(maxRequestChannelNum, ".1.3.6.1.4.1.17409.2.3.6.4.2.1.5", ISnmpConstant.INTEGER));
        initProperty(singlePreviewTime, new SnmpMibBeanProperty(singlePreviewTime, ".1.3.6.1.4.1.17409.2.3.6.4.2.1.6", ISnmpConstant.INTEGER));
        initProperty(totalPreviewTime, new SnmpMibBeanProperty(totalPreviewTime, ".1.3.6.1.4.1.17409.2.3.6.4.2.1.7", ISnmpConstant.INTEGER));
        initProperty(previewResetTime, new SnmpMibBeanProperty(previewResetTime, ".1.3.6.1.4.1.17409.2.3.6.4.2.1.8", ISnmpConstant.INTEGER));
        initProperty(previewCount, new SnmpMibBeanProperty(previewCount, ".1.3.6.1.4.1.17409.2.3.6.4.2.1.9", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.6.4.2.1.10", ISnmpConstant.INTEGER));
    }

    public Integer getCmIndex() {
        return (Integer) getIndex(0);
    }

    public void setCmIndex(Integer aCmIndex) {
        setIndex(0, aCmIndex);
    }

    public String getCmName() {
        return (String) getProperty(cmName).getValue();
    }

    public void setCmName(String aCmName) {
        getProperty(cmName).setValue(aCmName);
    }

    public byte[] getCmProxyList() {
        return (byte[]) getProperty(cmProxyList).getValue();
    }

    public void setCmProxyList(byte[] aCmProxyList) {
        getProperty(cmProxyList).setValue(aCmProxyList);
    }

    public Integer getMulticastUserAuthority() {
        return (Integer) getProperty(multicastUserAuthority).getValue();
    }

    public void setMulticastUserAuthority(Integer aMulticastUserAuthority) {
        getProperty(multicastUserAuthority).setValue(aMulticastUserAuthority);
    }

    public Integer getMaxRequestChannelNum() {
        return (Integer) getProperty(maxRequestChannelNum).getValue();
    }

    public void setMaxRequestChannelNum(Integer aMaxRequestChannelNum) {
        getProperty(maxRequestChannelNum).setValue(aMaxRequestChannelNum);
    }

    public Integer getSinglePreviewTime() {
        return (Integer) getProperty(singlePreviewTime).getValue();
    }

    public void setSinglePreviewTime(Integer aSinglePreviewTime) {
        getProperty(singlePreviewTime).setValue(aSinglePreviewTime);
    }

    public Integer getTotalPreviewTime() {
        return (Integer) getProperty(totalPreviewTime).getValue();
    }

    public void setTotalPreviewTime(Integer aTotalPreviewTime) {
        getProperty(totalPreviewTime).setValue(aTotalPreviewTime);
    }

    public Integer getPreviewResetTime() {
        return (Integer) getProperty(previewResetTime).getValue();
    }

    public void setPreviewResetTime(Integer aPreviewResetTime) {
        getProperty(previewResetTime).setValue(aPreviewResetTime);
    }

    public Integer getPreviewCount() {
        return (Integer) getProperty(previewCount).getValue();
    }

    public void setPreviewCount(Integer aPreviewCount) {
        getProperty(previewCount).setValue(aPreviewCount);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(cmName));
        prepareRead(getProperty(cmProxyList));
        prepareRead(getProperty(multicastUserAuthority));
        prepareRead(getProperty(maxRequestChannelNum));
        prepareRead(getProperty(singlePreviewTime));
        prepareRead(getProperty(totalPreviewTime));
        prepareRead(getProperty(previewResetTime));
        prepareRead(getProperty(previewCount));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(cmName));
        prepareRead(getProperty(cmProxyList));
        prepareRead(getProperty(multicastUserAuthority));
        prepareRead(getProperty(maxRequestChannelNum));
        prepareRead(getProperty(singlePreviewTime));
        prepareRead(getProperty(totalPreviewTime));
        prepareRead(getProperty(previewResetTime));
        prepareRead(getProperty(previewCount));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(cmName));
        prepareSave(getProperty(cmProxyList));
        prepareSave(getProperty(multicastUserAuthority));
        prepareSave(getProperty(maxRequestChannelNum));
        prepareSave(getProperty(singlePreviewTime));
        prepareSave(getProperty(totalPreviewTime));
        prepareSave(getProperty(previewResetTime));
        prepareSave(getProperty(previewCount));

        setRowStatus(new Integer(1));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(cmName));
        prepareSave(getProperty(cmProxyList));
        prepareSave(getProperty(multicastUserAuthority));
        prepareSave(getProperty(maxRequestChannelNum));
        prepareSave(getProperty(singlePreviewTime));
        prepareSave(getProperty(totalPreviewTime));
        prepareSave(getProperty(previewResetTime));
        prepareSave(getProperty(previewCount));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}