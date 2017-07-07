package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCVLANPortTable class.
 * Created by QuickDVM
 */
public class ModEoCVLANPortTable extends EocBaseSnmpMibBean {
    public static final String modEoCVLANCBATCardIndex = "modEoCVLANCBATCardIndex";
    public static final String modEoCVLANCNUIndex = "modEoCVLANCNUIndex";
    public static final String modEoCVLANPortIndex = "modEoCVLANPortIndex";
    public static final String modEoCVLANPortPVID = "modEoCVLANPortPVID";
    public static final String modEoCVLANPortTPID = "modEoCVLANPortTPID";
    public static final String modEoCVLANPortPrio = "modEoCVLANPortPrio";
    public static final String modEoCVLANPortVIDList = "modEoCVLANPortVIDList";
    public static final String modEoCVLANPortUntaggedVIDList = "modEoCVLANPortUntaggedVIDList";
    public static final String modEoCVLANPortMode = "modEoCVLANPortMode";

    private String cltLocation = null;

    public ModEoCVLANPortTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCVLANCBATCardIndex, new SnmpMibBeanProperty(modEoCVLANCBATCardIndex, MIB_Head1 + ".9.8.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCVLANCNUIndex, new SnmpMibBeanProperty(modEoCVLANCNUIndex, MIB_Head1 + ".9.8.1.2", ISnmpConstant.INTEGER));
        initProperty(modEoCVLANPortIndex, new SnmpMibBeanProperty(modEoCVLANPortIndex, MIB_Head1 + ".9.8.1.3", ISnmpConstant.INTEGER));
        initProperty(modEoCVLANPortPVID, new SnmpMibBeanProperty(modEoCVLANPortPVID, MIB_Head1 + ".9.8.1.4", ISnmpConstant.INTEGER));
        initProperty(modEoCVLANPortTPID, new SnmpMibBeanProperty(modEoCVLANPortTPID, MIB_Head1 + ".9.8.1.5", ISnmpConstant.INTEGER));
        initProperty(modEoCVLANPortPrio, new SnmpMibBeanProperty(modEoCVLANPortPrio, MIB_Head1 + ".9.8.1.6", ISnmpConstant.INTEGER));
        initProperty(modEoCVLANPortVIDList, new SnmpMibBeanProperty(modEoCVLANPortVIDList, MIB_Head1 + ".9.8.1.7", ISnmpConstant.OCTETS));
        initProperty(modEoCVLANPortUntaggedVIDList, new SnmpMibBeanProperty(modEoCVLANPortUntaggedVIDList, MIB_Head1 + ".9.8.1.8", ISnmpConstant.OCTETS));
        initProperty(modEoCVLANPortMode, new SnmpMibBeanProperty(modEoCVLANPortMode, MIB_Head1 + ".9.8.1.9", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCVLANCBATCardIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCVLANCBATCardIndex(Integer aModEoCVLANCBATCardIndex) {
        setIndex(0, aModEoCVLANCBATCardIndex);
    }


    public Integer getModEoCVLANCNUIndex() {
        return (Integer) getIndex(1);
    }

    public void setModEoCVLANCNUIndex(Integer aModEoCVLANCNUIndex) {
        setIndex(1, aModEoCVLANCNUIndex);
    }


    public Integer getModEoCVLANPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setModEoCVLANPortIndex(Integer aModEoCVLANPortIndex) {
        setIndex(2, aModEoCVLANPortIndex);
    }


    public Integer getModEoCVLANPortPVID() {
        return (Integer) getProperty(modEoCVLANPortPVID).getValue();
    }

    public void setModEoCVLANPortPVID(Integer aModEoCVLANPortPVID) {
        getProperty(modEoCVLANPortPVID).setValue(aModEoCVLANPortPVID);
    }

    public Integer getModEoCVLANPortTPID() {
        return (Integer) getProperty(modEoCVLANPortTPID).getValue();
    }

    public void setModEoCVLANPortTPID(Integer aModEoCVLANPortTPID) {
        getProperty(modEoCVLANPortTPID).setValue(aModEoCVLANPortTPID);
    }

    public Integer getModEoCVLANPortPrio() {
        return (Integer) getProperty(modEoCVLANPortPrio).getValue();
    }

    public void setModEoCVLANPortPrio(Integer aModEoCVLANPortPrio) {
        getProperty(modEoCVLANPortPrio).setValue(aModEoCVLANPortPrio);
    }

    public byte[] getModEoCVLANPortVIDList() {
        return (byte[]) getProperty(modEoCVLANPortVIDList).getValue();
    }

    public void setModEoCVLANPortVIDList(byte[] aModEoCVLANPortVIDList) {
        getProperty(modEoCVLANPortVIDList).setValue(aModEoCVLANPortVIDList);
    }

    public byte[] getModEoCVLANPortUntaggedVIDList() {
        return (byte[]) getProperty(modEoCVLANPortUntaggedVIDList).getValue();
    }

    public void setModEoCVLANPortUntaggedVIDList(byte[] aModEoCVLANPortUntaggedVIDList) {
        getProperty(modEoCVLANPortUntaggedVIDList).setValue(aModEoCVLANPortUntaggedVIDList);
    }

    public Integer getModEoCVLANPortMode() {
        return (Integer) getProperty(modEoCVLANPortMode).getValue();
    }

    public void setModEoCVLANPortMode(Integer aModEoCVLANPortMode) {
        getProperty(modEoCVLANPortMode).setValue(aModEoCVLANPortMode);
    }

    public String getCltLocation() {
        return cltLocation;
    }

    public void setCltLocation(String location) {
        cltLocation = location;
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCVLANPortPVID));
        prepareRead(super.getProperty(modEoCVLANPortTPID));
        prepareRead(super.getProperty(modEoCVLANPortPrio));
        prepareRead(super.getProperty(modEoCVLANPortVIDList));
        prepareRead(super.getProperty(modEoCVLANPortUntaggedVIDList));
        prepareRead(super.getProperty(modEoCVLANPortMode));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCVLANPortPVID));
        prepareRead(super.getProperty(modEoCVLANPortTPID));
        prepareRead(super.getProperty(modEoCVLANPortPrio));
        prepareRead(super.getProperty(modEoCVLANPortVIDList));
        prepareRead(super.getProperty(modEoCVLANPortUntaggedVIDList));
        prepareRead(super.getProperty(modEoCVLANPortMode));

        Vector v = loadAll(new int[]{1, 1, 1});

        /*if (!EocUtils.isLCT() && !DebugMode.isDebug()) { //TODO..
            try {
                ITerminalMgmtService eocService = (ITerminalMgmtService) EocUtils.getRemoteAPI(ITerminalMgmtService.class.getName());
                Map map = eocService.getInstallLocation(fSnmpProxy.getTargetHost());
                for (int i = 0; i < v.size(); i++) {
                    ModEoCVLANPortTable bean = (ModEoCVLANPortTable) v.get(i);
                    String key = new StringBuilder().append(bean.getModEoCVLANCBATCardIndex()).append(",").append(bean.getModEoCVLANCNUIndex()).toString();
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
        prepareSave(getProperty(modEoCVLANPortPVID));
        prepareSave(getProperty(modEoCVLANPortTPID));
        prepareSave(getProperty(modEoCVLANPortPrio));
        prepareSave(getProperty(modEoCVLANPortVIDList));
        prepareSave(getProperty(modEoCVLANPortUntaggedVIDList));
        prepareSave(getProperty(modEoCVLANPortMode));

        return save();
    }


}
