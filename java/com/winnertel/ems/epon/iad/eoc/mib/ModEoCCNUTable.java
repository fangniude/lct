package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCCNUTable class.
 * Created by QuickDVM
 */
public class ModEoCCNUTable extends EocBaseSnmpMibBean {
    public static final String modEoCCNUCBATCardIndex = "modEoCCNUCBATCardIndex";
    public static final String modEoCCNUIndex = "modEoCCNUIndex";
    public static final String modEoCCNUMACAddress = "modEoCCNUMACAddress";
    public static final String modEoCCNUOnlineStatus = "modEoCCNUOnlineStatus";
    public static final String modEoCCNUModelNumber = "modEoCCNUModelNumber";
    public static final String modEoCCNUPortAmount = "modEoCCNUPortAmount";
    public static final String modEoCCNUAuthorizationState = "modEoCCNUAuthorizationState";
    public static final String modEoCCNUSoftwareVersion = "modEoCCNUSoftwareVersion";
    public static final String modEoCCNUReset = "modEoCCNUReset";
    public static final String modEoCCNURFAttenuation = "modEoCCNURFAttenuation";
    public static final String modEoCCNURFDownstreamQuality = "modEoCCNURFDownstreamQuality";
    public static final String modEoCCNURFUpstreamQuality = "modEoCCNURFUpstreamQuality";
    public static final String modEoCCNUPhyDownstreamRate = "modEoCCNUPhyDownstreamRate";
    public static final String modEoCCNUPhyUpstreamRate = "modEoCCNUPhyUpstreamRate";
    public static final String modEoCCNUConfigurationSaving = "modEoCCNUConfigurationSaving";
    public static final String modEoCCNUConfigurationResult = "modEoCCNUConfigurationResult";
    public static final String modEoCCNUAction = "modEoCCNUAction";

    private String installAddress = null;

    public ModEoCCNUTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCNUCBATCardIndex, new SnmpMibBeanProperty(modEoCCNUCBATCardIndex, MIB_Head1 + ".5.2.4.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUIndex, new SnmpMibBeanProperty(modEoCCNUIndex, MIB_Head1 + ".5.2.4.1.2", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUMACAddress, new SnmpMibBeanProperty(modEoCCNUMACAddress, MIB_Head1 + ".5.2.4.1.3", ISnmpConstant.OCTETS));
        initProperty(modEoCCNUOnlineStatus, new SnmpMibBeanProperty(modEoCCNUOnlineStatus, MIB_Head1 + ".5.2.4.1.4", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUModelNumber, new SnmpMibBeanProperty(modEoCCNUModelNumber, MIB_Head1 + ".5.2.4.1.5", ISnmpConstant.STRING));
        initProperty(modEoCCNUPortAmount, new SnmpMibBeanProperty(modEoCCNUPortAmount, MIB_Head1 + ".5.2.4.1.6", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUAuthorizationState, new SnmpMibBeanProperty(modEoCCNUAuthorizationState, MIB_Head1 + ".5.2.4.1.7", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUSoftwareVersion, new SnmpMibBeanProperty(modEoCCNUSoftwareVersion, MIB_Head1 + ".5.2.4.1.8", ISnmpConstant.STRING));
        initProperty(modEoCCNUReset, new SnmpMibBeanProperty(modEoCCNUReset, MIB_Head1 + ".5.2.4.1.9", ISnmpConstant.INTEGER));
        initProperty(modEoCCNURFAttenuation, new SnmpMibBeanProperty(modEoCCNURFAttenuation, MIB_Head1 + ".5.2.4.1.10", ISnmpConstant.INTEGER));
        initProperty(modEoCCNURFDownstreamQuality, new SnmpMibBeanProperty(modEoCCNURFDownstreamQuality, MIB_Head1 + ".5.2.4.1.11", ISnmpConstant.INTEGER));
        initProperty(modEoCCNURFUpstreamQuality, new SnmpMibBeanProperty(modEoCCNURFUpstreamQuality, MIB_Head1 + ".5.2.4.1.12", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUPhyDownstreamRate, new SnmpMibBeanProperty(modEoCCNUPhyDownstreamRate, MIB_Head1 + ".5.2.4.1.13", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUPhyUpstreamRate, new SnmpMibBeanProperty(modEoCCNUPhyUpstreamRate, MIB_Head1 + ".5.2.4.1.14", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUConfigurationSaving, new SnmpMibBeanProperty(modEoCCNUConfigurationSaving, MIB_Head1 + ".5.2.4.1.15", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUConfigurationResult, new SnmpMibBeanProperty(modEoCCNUConfigurationResult, MIB_Head1 + ".5.2.4.1.16", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUAction, new SnmpMibBeanProperty(modEoCCNUAction, MIB_Head1 + ".5.2.4.1.17", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCNUCBATCardIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCCNUCBATCardIndex(Integer aModEoCCNUCBATCardIndex) {
        setIndex(0, aModEoCCNUCBATCardIndex);
    }


    public Integer getModEoCCNUIndex() {
        return (Integer) getIndex(1);
    }

    public void setModEoCCNUIndex(Integer aModEoCCNUIndex) {
        setIndex(1, aModEoCCNUIndex);
    }


    public byte[] getModEoCCNUMACAddress() {
        return (byte[]) getProperty(modEoCCNUMACAddress).getValue();
    }

    public void setModEoCCNUMACAddress(byte[] aModEoCCNUMACAddress) {
        getProperty(modEoCCNUMACAddress).setValue(aModEoCCNUMACAddress);
    }

    public Integer getModEoCCNUOnlineStatus() {
        return (Integer) getProperty(modEoCCNUOnlineStatus).getValue();
    }

    public void setModEoCCNUOnlineStatus(Integer aModEoCCNUOnlineStatus) {
        getProperty(modEoCCNUOnlineStatus).setValue(aModEoCCNUOnlineStatus);
    }

    public String getModEoCCNUModelNumber() {
        return (String) getProperty(modEoCCNUModelNumber).getValue();
    }

    public void setModEoCCNUModelNumber(String aModEoCCNUModelNumber) {
        getProperty(modEoCCNUModelNumber).setValue(aModEoCCNUModelNumber);
    }

    public Integer getModEoCCNUPortAmount() {
        return (Integer) getProperty(modEoCCNUPortAmount).getValue();
    }

    public void setModEoCCNUPortAmount(Integer aModEoCCNUPortAmount) {
        getProperty(modEoCCNUPortAmount).setValue(aModEoCCNUPortAmount);
    }

    public Integer getModEoCCNUAuthorizationState() {
        return (Integer) getProperty(modEoCCNUAuthorizationState).getValue();
    }

    public void setModEoCCNUAuthorizationState(Integer aModEoCCNUAuthorizationState) {
        getProperty(modEoCCNUAuthorizationState).setValue(aModEoCCNUAuthorizationState);
    }

    public String getModEoCCNUSoftwareVersion() {
        return (String) getProperty(modEoCCNUSoftwareVersion).getValue();
    }

    public void setModEoCCNUSoftwareVersion(String aModEoCCNUSoftwareVersion) {
        getProperty(modEoCCNUSoftwareVersion).setValue(aModEoCCNUSoftwareVersion);
    }

    public Integer getModEoCCNUReset() {
        return (Integer) getProperty(modEoCCNUReset).getValue();
    }

    public void setModEoCCNUReset(Integer aModEoCCNUReset) {
        getProperty(modEoCCNUReset).setValue(aModEoCCNUReset);
    }

    public Integer getModEoCCNURFAttenuation() {
        return (Integer) getProperty(modEoCCNURFAttenuation).getValue();
    }

    public void setModEoCCNURFAttenuation(Integer aModEoCCNURFAttenuation) {
        getProperty(modEoCCNURFAttenuation).setValue(aModEoCCNURFAttenuation);
    }

    public Integer getModEoCCNURFDownstreamQuality() {
        return (Integer) getProperty(modEoCCNURFDownstreamQuality).getValue();
    }

    public void setModEoCCNURFDownstreamQuality(Integer aModEoCCNURFDownstreamQuality) {
        getProperty(modEoCCNURFDownstreamQuality).setValue(aModEoCCNURFDownstreamQuality);
    }

    public Integer getModEoCCNURFUpstreamQuality() {
        return (Integer) getProperty(modEoCCNURFUpstreamQuality).getValue();
    }

    public void setModEoCCNURFUpstreamQuality(Integer aModEoCCNURFUpstreamQuality) {
        getProperty(modEoCCNURFUpstreamQuality).setValue(aModEoCCNURFUpstreamQuality);
    }

    public Integer getModEoCCNUPhyDownstreamRate() {
        return (Integer) getProperty(modEoCCNUPhyDownstreamRate).getValue();
    }

    public void setModEoCCNUPhyDownstreamRate(Integer aModEoCCNUPhyDownstreamRate) {
        getProperty(modEoCCNUPhyDownstreamRate).setValue(aModEoCCNUPhyDownstreamRate);
    }

    public Integer getModEoCCNUPhyUpstreamRate() {
        return (Integer) getProperty(modEoCCNUPhyUpstreamRate).getValue();
    }

    public void setModEoCCNUPhyUpstreamRate(Integer aModEoCCNUPhyUpstreamRate) {
        getProperty(modEoCCNUPhyUpstreamRate).setValue(aModEoCCNUPhyUpstreamRate);
    }

    public Integer getModEoCCNUConfigurationSaving() {
        return (Integer) getProperty(modEoCCNUConfigurationSaving).getValue();
    }

    public void setModEoCCNUConfigurationSaving(Integer aModEoCCNUConfigurationSaving) {
        getProperty(modEoCCNUConfigurationSaving).setValue(aModEoCCNUConfigurationSaving);
    }

    public Integer getModEoCCNUConfigurationResult() {
        return (Integer) getProperty(modEoCCNUConfigurationResult).getValue();
    }

    public void setModEoCCNUConfigurationResult(Integer aModEoCCNUConfigurationResult) {
        getProperty(modEoCCNUConfigurationResult).setValue(aModEoCCNUConfigurationResult);
    }

    public Integer getModEoCCNUAction() {
        return (Integer) getProperty(modEoCCNUAction).getValue();
    }

    public void setModEoCCNUAction(Integer aModEoCCNUAction) {
        getProperty(modEoCCNUAction).setValue(aModEoCCNUAction);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCNUMACAddress));
        prepareRead(super.getProperty(modEoCCNUOnlineStatus));
        prepareRead(super.getProperty(modEoCCNUModelNumber));
        prepareRead(super.getProperty(modEoCCNUPortAmount));
        prepareRead(super.getProperty(modEoCCNUAuthorizationState));
        prepareRead(super.getProperty(modEoCCNUSoftwareVersion));
        prepareRead(super.getProperty(modEoCCNUReset));
        prepareRead(super.getProperty(modEoCCNURFAttenuation));
        prepareRead(super.getProperty(modEoCCNURFDownstreamQuality));
        prepareRead(super.getProperty(modEoCCNURFUpstreamQuality));
        prepareRead(super.getProperty(modEoCCNUPhyDownstreamRate));
        prepareRead(super.getProperty(modEoCCNUPhyUpstreamRate));
        prepareRead(super.getProperty(modEoCCNUConfigurationSaving));
        prepareRead(super.getProperty(modEoCCNUConfigurationResult));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCNUMACAddress));
        prepareRead(super.getProperty(modEoCCNUOnlineStatus));
        prepareRead(super.getProperty(modEoCCNUModelNumber));
        prepareRead(super.getProperty(modEoCCNUPortAmount));
        prepareRead(super.getProperty(modEoCCNUAuthorizationState));
        prepareRead(super.getProperty(modEoCCNUSoftwareVersion));
        prepareRead(super.getProperty(modEoCCNUReset));
        prepareRead(super.getProperty(modEoCCNURFAttenuation));
        prepareRead(super.getProperty(modEoCCNURFDownstreamQuality));
        prepareRead(super.getProperty(modEoCCNURFUpstreamQuality));
        prepareRead(super.getProperty(modEoCCNUPhyDownstreamRate));
        prepareRead(super.getProperty(modEoCCNUPhyUpstreamRate));
        prepareRead(super.getProperty(modEoCCNUConfigurationSaving));
        prepareRead(super.getProperty(modEoCCNUConfigurationResult));

        Vector v = loadAll(new int[]{1, 1});

        /*try {

            ITerminalMgmtService terminalService = (ITerminalMgmtService) RMIUtil
                    .lookupAPI(ITerminalMgmtService.class.getName());

            Map map = terminalService.getInstallLocation(fSnmpProxy.getTargetHost());

            for (int i = 0; i < v.size(); i++) {
                ModEoCCNUTable bean = (ModEoCCNUTable) v.get(i);

                //find the cnu by  cardId and portId.
                int cardId = bean.getModEoCCNUCBATCardIndex();
                int portId = bean.getModEoCCNUIndex();
                String key = cardId + "," + portId;
                String macKey = OctetToMacAddress(bean.getModEoCCNUMACAddress());
                if (map.containsKey(key)) {
                    bean.setInstallAddress((String) map.get(key));
                } else {
                    //find the cnu by macAddress
                    if (map.containsKey(macKey)) {
                        bean.setInstallAddress((String) map.get(macKey));
                    } else {
                        //not found in CNU management system and not on line.
                        bean.setInstallAddress("");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        return v;
    }

    public static String OctetToMacAddress(byte[] value) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < value.length; i++) {
            int bi = value[i] & 0xff;
            if (bi >= 0 && bi < 16) {
                sb.append('0');
            }

            sb.append(Integer.toHexString(bi));

            if (i < value.length - 1) {
                sb.append("-");
            }
        }

        return sb.toString().toUpperCase();
    }

    public String getInstallAddress() {
        return installAddress;
    }

    public void setInstallAddress(String installAddress) {
        this.installAddress = installAddress;
    }

    public boolean resetCNU() throws MibBeanException {
        setModEoCCNUReset(1);
        prepareSave(getProperty(modEoCCNUReset));

        return save();
    }

    public boolean saveCNU() throws MibBeanException {

        setModEoCCNUConfigurationSaving(1);
        prepareSave(getProperty(modEoCCNUConfigurationSaving));

        return save();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCNUReset));
        prepareSave(getProperty(modEoCCNUConfigurationSaving));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setModEoCCNUAction(new Integer(1));
        prepareSave(getProperty(modEoCCNUAction));
        return save();
    }

}