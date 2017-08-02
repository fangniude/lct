package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.VlanModeConfigMBean;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class VlanModeConfigMBean500 extends VlanModeConfigMBean {
	
	public static final String utsDot3OnuEthernetPortPri = "utsDot3OnuEthernetPortPri";
	
	public VlanModeConfigMBean500(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }
	
	protected void init() {
        initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(utsDot3OnuEtherPortIndex, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanMode, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.36", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanTag, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTag, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.38", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanTPID, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTPID, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.37", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanTranslation, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTranslation, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.40", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuEtherPortVlanNaggregationNumber, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanNaggregationNumber, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.50", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanNaggregation, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanNaggregation, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.51", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuEtherPortVlanTrunk, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTrunk, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.52", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuEthernetPortPri, new SnmpMibBeanProperty(utsDot3OnuEthernetPortPri, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.55", ISnmpConstant.INTEGER));
    }
	
	public Integer getUtsDot3OnuEthernetPortPri() {
        return (Integer) getProperty(utsDot3OnuEthernetPortPri).getValue();
    }

    public void setUtsDot3OnuEthernetPortPri(Integer aUtsDot3OnuEthernetPortPri) {
        getProperty(utsDot3OnuEthernetPortPri).setValue(aUtsDot3OnuEthernetPortPri);
    }
    
    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuEtherPortVlanMode));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTag));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTPID));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTranslation));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanNaggregationNumber));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanNaggregation));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTrunk));
        prepareRead(getProperty(utsDot3OnuEthernetPortPri));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuEtherPortVlanMode));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTag));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTPID));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTranslation));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanNaggregationNumber));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanNaggregation));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTrunk));
        prepareRead(getProperty(utsDot3OnuEthernetPortPri));

        Vector v = loadAll(new int[]{1, 1, 1, 1, 1});
//
//        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    VlanModeConfigMBean bean = (VlanModeConfigMBean) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3OnuModuleId()).append("/").append(bean.getUtsDot3OnuPortId()).append("/").append(bean.getUtsDot3OnuLogicalPortId()).toString();
//                    if (map.containsKey(key)) {
//                        bean.setOnuLabel((String) map.get(key));
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return v;
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuEtherPortVlanMode));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanTag));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanTPID));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanTranslation));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanNaggregationNumber));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanNaggregation));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanTrunk));
        prepareSave(getProperty(utsDot3OnuEthernetPortPri));

        return save();
    }

}
