package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCIGMPSnoopingTable class.
 * Created by QuickDVM
 */
public class ModEoCIGMPSnoopingTable extends EocBaseSnmpMibBean {
    public static final String modEoCIGMPSnoopingCBATCardIndex = "modEoCIGMPSnoopingCBATCardIndex";
    public static final String modEoCIGMPSnoopingCNUIndex = "modEoCIGMPSnoopingCNUIndex";
    public static final String modEoCIGMPSnoopingDevMACAddress = "modEoCIGMPSnoopingDevMACAddress";
    public static final String modEoCIGMPSnoopingEN = "modEoCIGMPSnoopingEN";

    private String cltLocation = null;

    public ModEoCIGMPSnoopingTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCIGMPSnoopingCBATCardIndex, new SnmpMibBeanProperty(modEoCIGMPSnoopingCBATCardIndex, MIB_Head1 + ".7.1.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCIGMPSnoopingCNUIndex, new SnmpMibBeanProperty(modEoCIGMPSnoopingCNUIndex, MIB_Head1 + ".7.1.1.2", ISnmpConstant.INTEGER));
        initProperty(modEoCIGMPSnoopingDevMACAddress, new SnmpMibBeanProperty(modEoCIGMPSnoopingDevMACAddress, MIB_Head1 + ".7.1.1.3", ISnmpConstant.OCTETS));
        initProperty(modEoCIGMPSnoopingEN, new SnmpMibBeanProperty(modEoCIGMPSnoopingEN, MIB_Head1 + ".7.1.1.4", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCIGMPSnoopingCBATCardIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCIGMPSnoopingCBATCardIndex(Integer aModEoCIGMPSnoopingCBATCardIndex) {
        setIndex(0, aModEoCIGMPSnoopingCBATCardIndex);
    }


    public Integer getModEoCIGMPSnoopingCNUIndex() {
        return (Integer) getIndex(1);
    }

    public void setModEoCIGMPSnoopingCNUIndex(Integer aModEoCIGMPSnoopingCNUIndex) {
        setIndex(1, aModEoCIGMPSnoopingCNUIndex);
    }


    public byte[] getModEoCIGMPSnoopingDevMACAddress() {
        return (byte[]) getProperty(modEoCIGMPSnoopingDevMACAddress).getValue();
    }

    public void setModEoCIGMPSnoopingDevMACAddress(byte[] aModEoCIGMPSnoopingDevMACAddress) {
        getProperty(modEoCIGMPSnoopingDevMACAddress).setValue(aModEoCIGMPSnoopingDevMACAddress);
    }

    public Integer getModEoCIGMPSnoopingEN() {
        return (Integer) getProperty(modEoCIGMPSnoopingEN).getValue();
    }

    public void setModEoCIGMPSnoopingEN(Integer aModEoCIGMPSnoopingEN) {
        getProperty(modEoCIGMPSnoopingEN).setValue(aModEoCIGMPSnoopingEN);
    }

    public String getCltLocation() {
        return cltLocation;
    }

    public void setCltLocation(String location) {
        cltLocation = location;
    }


    public boolean retrieve() throws MibBeanException {
        //prepareRead(super.getProperty(modEoCIGMPSnoopingDevMACAddress));
        prepareRead(super.getProperty(modEoCIGMPSnoopingEN));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        //prepareRead(super.getProperty(modEoCIGMPSnoopingDevMACAddress));
        prepareRead(super.getProperty(modEoCIGMPSnoopingEN));

        Vector v = loadAll(new int[]{1, 1});

        /*if (!EocUtils.isLCT() && !DebugMode.isDebug()) { //TODO..
            try {
                ITerminalMgmtService eocService = (ITerminalMgmtService) EocUtils.getRemoteAPI(ITerminalMgmtService.class.getName());
                Map map = eocService.getInstallLocation(fSnmpProxy.getTargetHost());
                for (int i = 0; i < v.size(); i++) {
                    ModEoCIGMPSnoopingTable bean = (ModEoCIGMPSnoopingTable) v.get(i);
                    String key = new StringBuilder().append(bean.getModEoCIGMPSnoopingCBATCardIndex()).append(",").append(bean.getModEoCIGMPSnoopingCNUIndex()).toString();
                    if (map.containsKey(key)) {
                        bean.setCltLocation((String) map.get(key));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/

        return v;
    }


    public boolean modify() throws MibBeanException {
        //prepareSave(getProperty(modEoCIGMPSnoopingDevMACAddress));
        prepareSave(getProperty(modEoCIGMPSnoopingEN));

        return save();
    }


}