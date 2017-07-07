package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.UNIDataServiceMBean;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Map;
import java.util.Vector;

public class UNIDataServiceMBean500 extends UNIDataServiceMBean{
	
	public static final String utsDot3OnuEthernetPortPri = "utsDot3OnuEthernetPortPri";
	
	public UNIDataServiceMBean500(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(
				utsDot3OnuModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(
				utsDot3OnuDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(
				utsDot3OnuPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(
				utsDot3OnuLogicalPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortIndex,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.5",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuEtherPortPhyAdminCtrl, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortPhyAdminCtrl,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortAutoNegAdminCtrl,
				new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegAdminCtrl,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.12",
						ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuEtherPortPause, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortPause,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.31",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuEtherPortPolicingEnable,
				new SnmpMibBeanProperty(utsDot3OnuEtherPortPolicingEnable,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.32",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortPolicingCIR, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortPolicingCIR,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.33",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortPolicingCBS, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortPolicingCBS,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.34",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortPolicingEBS, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortPolicingEBS,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.35",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuEtherPortVlanMode, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortVlanMode,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.36",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortVlanTPID, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortVlanTPID,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.37",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortVlanTag, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortVlanTag,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.38",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortVlanTranslation,
				new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTranslation,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.40",
						ISnmpConstant.OCTETS));

		initProperty(utsDot3OnuEtherPortVlanNaggregationNumber,
				new SnmpMibBeanProperty(
						utsDot3OnuEtherPortVlanNaggregationNumber,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.50",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortVlanNaggregation,
				new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanNaggregation,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.51",
						ISnmpConstant.OCTETS));
		initProperty(utsDot3OnuEtherPortVlanTrunk, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortVlanTrunk,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.52",
				ISnmpConstant.OCTETS));
		initProperty(utsDot3OnuEthernetPortPri, new SnmpMibBeanProperty(utsDot3OnuEthernetPortPri, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.55", ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuEtherPortDSPolicingEnable,
				new SnmpMibBeanProperty(utsDot3OnuEtherPortDSPolicingEnable,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.47",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortDSPolicingCIR, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortDSPolicingCIR,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.48",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortDSPolicingPIR, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortDSPolicingPIR,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.49",
				ISnmpConstant.INTEGER));
	}
	
	public Integer getUtsDot3OnuEthernetPortPri() {
        return (Integer) getProperty(utsDot3OnuEthernetPortPri).getValue();
    }

    public void setUtsDot3OnuEthernetPortPri(Integer aUtsDot3OnuEthernetPortPri) {
        getProperty(utsDot3OnuEthernetPortPri).setValue(aUtsDot3OnuEthernetPortPri);
    }
    
    public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OnuEtherPortPhyAdminCtrl));
		prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl));
		prepareRead(super.getProperty(utsDot3OnuEtherPortPause));

		prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEnable));
		prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCIR));
		prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCBS));
		prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEBS));

		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanMode));
		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTPID));
		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTag));
		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTranslation));
		prepareRead(super
				.getProperty(utsDot3OnuEtherPortVlanNaggregationNumber));
		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanNaggregation));
		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTrunk));
		prepareRead(super.getProperty(utsDot3OnuEthernetPortPri));

		prepareRead(super.getProperty(utsDot3OnuEtherPortDSPolicingEnable));
		prepareRead(super.getProperty(utsDot3OnuEtherPortDSPolicingCIR));
		prepareRead(super.getProperty(utsDot3OnuEtherPortDSPolicingPIR));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OnuEtherPortPhyAdminCtrl));
		prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl));
		prepareRead(super.getProperty(utsDot3OnuEtherPortPause));

		prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEnable));
		prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCIR));
		prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCBS));
		prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEBS));

		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanMode));
		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTPID));
		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTag));
		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTranslation));
		prepareRead(super
				.getProperty(utsDot3OnuEtherPortVlanNaggregationNumber));
		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanNaggregation));
		prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTrunk));
		prepareRead(super.getProperty(utsDot3OnuEthernetPortPri));

		prepareSave(getProperty(utsDot3OnuEtherPortDSPolicingEnable));
		prepareSave(getProperty(utsDot3OnuEtherPortDSPolicingCIR));
		prepareSave(getProperty(utsDot3OnuEtherPortDSPolicingPIR));
		
		
		//added by Zengtian, 2011/9/8
        String neName = "";
        Map map = null;
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                map = onuMgmtMgr.getOnuLabelMap(neName);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        Vector result = loadAll(new int[] { 1, 1, 1, 1, 1 });
        for (int i = 0; i < result.size(); i++) 
        {
        	UNIDataServiceMBean bean = (UNIDataServiceMBean) result.get(i);
             //find the onu by module/port/logicalid
             String key = new StringBuilder(neName).append(bean.getUtsDot3OnuModuleId()).append("/").append(bean.getUtsDot3OnuPortId()).append("/").append(bean.getUtsDot3OnuLogicalPortId()).toString();
             if (map.containsKey(key)) {
                 bean.setOnuLabel((String) map.get(key));
             }
        }

        return result;

		
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3OnuEtherPortPhyAdminCtrl));
		prepareSave(getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl));
		prepareSave(getProperty(utsDot3OnuEtherPortPause));

		prepareSave(getProperty(utsDot3OnuEtherPortPolicingEnable));
		prepareSave(getProperty(utsDot3OnuEtherPortPolicingCIR));
		prepareSave(getProperty(utsDot3OnuEtherPortPolicingCBS));
		prepareSave(getProperty(utsDot3OnuEtherPortPolicingEBS));

		prepareSave(getProperty(utsDot3OnuEtherPortVlanMode));
		prepareSave(getProperty(utsDot3OnuEtherPortVlanTPID));
		prepareSave(getProperty(utsDot3OnuEtherPortVlanTag));
		prepareSave(getProperty(utsDot3OnuEtherPortVlanTranslation));
		prepareSave(getProperty(utsDot3OnuEtherPortVlanNaggregationNumber));
		prepareSave(getProperty(utsDot3OnuEtherPortVlanNaggregation));
		prepareSave(getProperty(utsDot3OnuEtherPortVlanTrunk));
		prepareSave(getProperty(utsDot3OnuEthernetPortPri));

		prepareSave(getProperty(utsDot3OnuEtherPortDSPolicingEnable));
		prepareSave(getProperty(utsDot3OnuEtherPortDSPolicingCIR));
		prepareSave(getProperty(utsDot3OnuEtherPortDSPolicingPIR));

		return save();
	}
}
