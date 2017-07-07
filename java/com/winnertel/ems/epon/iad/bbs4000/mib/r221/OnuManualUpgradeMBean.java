package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class OnuManualUpgradeMBean extends SnmpMibBean {
    public static final String utsDot3OnuFWUpgradeManualPortListBitMap = "utsDot3OnuFWUpgradeManualPortListBitMap";
    public static final String utsDot3OnuFWUpgradeManualOption = "utsDot3OnuFWUpgradeManualOption";
    public static final String utsDot3OnuFWUpgradeManualActCommitFlag = "utsDot3OnuFWUpgradeManualActCommitFlag";

    public OnuManualUpgradeMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuFWUpgradeManualPortListBitMap, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeManualPortListBitMap, ".1.3.6.1.4.1.41355.1800.2.3.1.7.3.2.1", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuFWUpgradeManualOption, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeManualOption, ".1.3.6.1.4.1.41355.1800.2.3.1.7.3.2.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradeManualActCommitFlag, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeManualActCommitFlag, ".1.3.6.1.4.1.41355.1800.2.3.1.7.3.2.3", ISnmpConstant.INTEGER));

    }

    public byte[] getUtsDot3OnuFWUpgradeManualPortListBitMap() {
        return (byte[]) getProperty(utsDot3OnuFWUpgradeManualPortListBitMap).getValue();
    }

    public void setUtsDot3OnuFWUpgradeManualPortListBitMap(byte[] onuPotListBitMap) {
        getProperty(utsDot3OnuFWUpgradeManualPortListBitMap).setValue(onuPotListBitMap);
    }

    public Integer getUtsDot3OnuFWUpgradeManualOption() {
        return (Integer) getProperty(utsDot3OnuFWUpgradeManualOption).getValue();
    }

    public void setUtsDot3OnuFWUpgradeManualOption(Integer onuPotListBitMap) {
        getProperty(utsDot3OnuFWUpgradeManualOption).setValue(onuPotListBitMap);
    }

    public Integer getUtsDot3OnuFWUpgradeManualActCommitFlag() {
        return (Integer) getProperty(utsDot3OnuFWUpgradeManualActCommitFlag).getValue();
    }

    public void setUtsDot3OnuFWUpgradeManualActCommitFlag(Integer aUtsDot3OnuFWUpgradeManualActCommitFlag) {
        getProperty(utsDot3OnuFWUpgradeManualActCommitFlag).setValue(aUtsDot3OnuFWUpgradeManualActCommitFlag);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeManualPortListBitMap));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeManualOption));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeManualActCommitFlag));

        return load();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuFWUpgradeManualPortListBitMap));
        prepareSave(getProperty(utsDot3OnuFWUpgradeManualOption));
        prepareSave(getProperty(utsDot3OnuFWUpgradeManualActCommitFlag));

        return save();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuFWUpgradeManualPortListBitMap));
        prepareSave(getProperty(utsDot3OnuFWUpgradeManualOption));
        prepareSave(getProperty(utsDot3OnuFWUpgradeManualActCommitFlag));

        return save();
    }
}
