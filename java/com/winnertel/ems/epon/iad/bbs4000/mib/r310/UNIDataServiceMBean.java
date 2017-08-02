package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Map;
import java.util.Vector;

public class UNIDataServiceMBean extends SnmpMibBean {
	public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
	public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
	public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
	public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";

	public static final String utsDot3OnuEtherPortIndex = "utsDot3OnuEtherPortIndex";
	public static final String utsDot3OnuEtherPortPhyAdminCtrl = "utsDot3OnuEtherPortPhyAdminCtrl";
	public static final String utsDot3OnuEtherPortAutoNegAdminCtrl = "utsDot3OnuEtherPortAutoNegAdminCtrl";

	public static final String utsDot3OnuEtherPortPause = "utsDot3OnuEtherPortPause";

	public static final String utsDot3OnuEtherPortPolicingEnable = "utsDot3OnuEtherPortPolicingEnable";
	public static final String utsDot3OnuEtherPortPolicingCIR = "utsDot3OnuEtherPortPolicingCIR";
	public static final String utsDot3OnuEtherPortPolicingCBS = "utsDot3OnuEtherPortPolicingCBS";
	public static final String utsDot3OnuEtherPortPolicingEBS = "utsDot3OnuEtherPortPolicingEBS";

	public static final String utsDot3OnuEtherPortVlanMode = "utsDot3OnuEtherPortVlanMode";
	public static final String utsDot3OnuEtherPortVlanTag = "utsDot3OnuEtherPortVlanTag";
	public static final String utsDot3OnuEtherPortVlanTPID = "utsDot3OnuEtherPortVlanTPID";
	public static final String utsDot3OnuEtherPortVlanTranslation = "utsDot3OnuEtherPortVlanTranslation";
	public static final String utsDot3OnuEtherPortVlanNaggregationNumber = "utsDot3OnuEtherPortVlanNaggregationNumber";
	public static final String utsDot3OnuEtherPortVlanNaggregation = "utsDot3OnuEtherPortVlanNaggregation";
	public static final String utsDot3OnuEtherPortVlanTrunk = "utsDot3OnuEtherPortVlanTrunk";

	public static final String utsDot3OnuEtherPortDSPolicingEnable = "utsDot3OnuEtherPortDSPolicingEnable";
	public static final String utsDot3OnuEtherPortDSPolicingCIR = "utsDot3OnuEtherPortDSPolicingCIR";
	public static final String utsDot3OnuEtherPortDSPolicingPIR = "utsDot3OnuEtherPortDSPolicingPIR";
	
	private String onuLabel = null; //added by Zengtian, 2011/9/8

	public UNIDataServiceMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(
				utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(
				utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(
				utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(
				utsDot3OnuLogicalPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortIndex,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.5",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuEtherPortPhyAdminCtrl, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortPhyAdminCtrl,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortAutoNegAdminCtrl,
				new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegAdminCtrl,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.12",
						ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuEtherPortPause, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortPause,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.31",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuEtherPortPolicingEnable,
				new SnmpMibBeanProperty(utsDot3OnuEtherPortPolicingEnable,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.32",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortPolicingCIR, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortPolicingCIR,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.33",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortPolicingCBS, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortPolicingCBS,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.34",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortPolicingEBS, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortPolicingEBS,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.35",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuEtherPortVlanMode, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortVlanMode,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.36",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortVlanTPID, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortVlanTPID,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.37",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortVlanTag, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortVlanTag,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.38",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortVlanTranslation,
				new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTranslation,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.40",
						ISnmpConstant.OCTETS));

		initProperty(utsDot3OnuEtherPortVlanNaggregationNumber,
				new SnmpMibBeanProperty(
						utsDot3OnuEtherPortVlanNaggregationNumber,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.50",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortVlanNaggregation,
				new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanNaggregation,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.51",
						ISnmpConstant.OCTETS));
		initProperty(utsDot3OnuEtherPortVlanTrunk, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortVlanTrunk,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.52",
				ISnmpConstant.OCTETS));

		initProperty(utsDot3OnuEtherPortDSPolicingEnable,
				new SnmpMibBeanProperty(utsDot3OnuEtherPortDSPolicingEnable,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.47",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortDSPolicingCIR, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortDSPolicingCIR,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.48",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortDSPolicingPIR, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortDSPolicingPIR,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.49",
				ISnmpConstant.INTEGER));
	}

	public Integer getUtsDot3OnuModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3OnuModuleId(Integer aUtsDot3OnuModuleId) {
		setIndex(0, aUtsDot3OnuModuleId);
	}

	public Integer getUtsDot3OnuDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3OnuDeviceId(Integer aUtsDot3OnuDeviceId) {
		setIndex(1, aUtsDot3OnuDeviceId);
	}

	public Integer getUtsDot3OnuPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3OnuPortId(Integer aUtsDot3OnuPortId) {
		setIndex(2, aUtsDot3OnuPortId);
	}

	public Integer getUtsDot3OnuLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3OnuLogicalPortId(Integer aUtsDot3OnuLogicalPortId) {
		setIndex(3, aUtsDot3OnuLogicalPortId);
	}

	public Integer getUtsDot3OnuEtherPortIndex() {
		return (Integer) getIndex(4);
	}

	public void setUtsDot3OnuEtherPortIndex(Integer aUtsDot3OnuEtherPortIndex) {
		setIndex(4, aUtsDot3OnuEtherPortIndex);
	}

	public Integer getUtsDot3OnuEtherPortPhyAdminCtrl() {
		return (Integer) getProperty(utsDot3OnuEtherPortPhyAdminCtrl)
				.getValue();
	}

	public void setUtsDot3OnuEtherPortPhyAdminCtrl(
			Integer aUtsDot3OnuEtherPortPhyAdminCtrl) {
		getProperty(utsDot3OnuEtherPortPhyAdminCtrl).setValue(
				aUtsDot3OnuEtherPortPhyAdminCtrl);
	}

	public Integer getUtsDot3OnuEtherPortAutoNegAdminCtrl() {
		return (Integer) getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl)
				.getValue();
	}

	public void setUtsDot3OnuEtherPortAutoNegAdminCtrl(
			Integer aUtsDot3OnuEtherPortAutoNegAdminCtrl) {
		getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl).setValue(
				aUtsDot3OnuEtherPortAutoNegAdminCtrl);
	}

	public Integer getUtsDot3OnuEtherPortPause() {
		return (Integer) getProperty(utsDot3OnuEtherPortPause).getValue();
	}

	public void setUtsDot3OnuEtherPortPause(Integer aUtsDot3OnuEtherPortPause) {
		getProperty(utsDot3OnuEtherPortPause).setValue(
				aUtsDot3OnuEtherPortPause);
	}

	public Integer getUtsDot3OnuEtherPortPolicingEnable() {
		return (Integer) getProperty(utsDot3OnuEtherPortPolicingEnable)
				.getValue();
	}

	public void setUtsDot3OnuEtherPortPolicingEnable(
			Integer aUtsDot3OnuEtherPortPolicingEnable) {
		getProperty(utsDot3OnuEtherPortPolicingEnable).setValue(
				aUtsDot3OnuEtherPortPolicingEnable);
	}

	public Integer getUtsDot3OnuEtherPortPolicingCIR() {
		return (Integer) getProperty(utsDot3OnuEtherPortPolicingCIR).getValue();
	}

	public void setUtsDot3OnuEtherPortPolicingCIR(
			Integer aUtsDot3OnuEtherPortPolicingCIR) {
		getProperty(utsDot3OnuEtherPortPolicingCIR).setValue(
				aUtsDot3OnuEtherPortPolicingCIR);
	}

	public Integer getUtsDot3OnuEtherPortPolicingCBS() {
		return (Integer) getProperty(utsDot3OnuEtherPortPolicingCBS).getValue();
	}

	public void setUtsDot3OnuEtherPortPolicingCBS(
			Integer aUtsDot3OnuEtherPortPolicingCBS) {
		getProperty(utsDot3OnuEtherPortPolicingCBS).setValue(
				aUtsDot3OnuEtherPortPolicingCBS);
	}

	public Integer getUtsDot3OnuEtherPortPolicingEBS() {
		return (Integer) getProperty(utsDot3OnuEtherPortPolicingEBS).getValue();
	}

	public void setUtsDot3OnuEtherPortPolicingEBS(
			Integer aUtsDot3OnuEtherPortPolicingEBS) {
		getProperty(utsDot3OnuEtherPortPolicingEBS).setValue(
				aUtsDot3OnuEtherPortPolicingEBS);
	}

	public Integer getUtsDot3OnuEtherPortVlanMode() {
		return (Integer) getProperty(utsDot3OnuEtherPortVlanMode).getValue();
	}

	public void setUtsDot3OnuEtherPortVlanMode(
			Integer aUtsDot3OnuEtherPortVlanMode) {
		getProperty(utsDot3OnuEtherPortVlanMode).setValue(
				aUtsDot3OnuEtherPortVlanMode);
	}

	public Integer getUtsDot3OnuEtherPortVlanTag() {
		return (Integer) getProperty(utsDot3OnuEtherPortVlanTag).getValue();
	}

	public void setUtsDot3OnuEtherPortVlanTag(
			Integer aUtsDot3OnuEtherPortVlanTag) {
		getProperty(utsDot3OnuEtherPortVlanTag).setValue(
				aUtsDot3OnuEtherPortVlanTag);
	}

	public Integer getUtsDot3OnuEtherPortVlanTPID() {
		return (Integer) getProperty(utsDot3OnuEtherPortVlanTPID).getValue();
	}

	public void setUtsDot3OnuEtherPortVlanTPID(
			Integer aUtsDot3OnuEtherPortVlanTPID) {
		getProperty(utsDot3OnuEtherPortVlanTPID).setValue(
				aUtsDot3OnuEtherPortVlanTPID);
	}

	public byte[] getUtsDot3OnuEtherPortVlanTranslation() {
		return (byte[]) getProperty(utsDot3OnuEtherPortVlanTranslation)
				.getValue();
	}

	public Integer getUtsDot3OnuEtherPortVlanNaggregationNumber() {
		return (Integer) getProperty(utsDot3OnuEtherPortVlanNaggregationNumber)
				.getValue();
	}

	public void setUtsDot3OnuEtherPortVlanNaggregationNumber(
			Integer aUtsDot3OnuEtherPortVlanNaggregationNumber) {
		getProperty(utsDot3OnuEtherPortVlanNaggregationNumber).setValue(
				aUtsDot3OnuEtherPortVlanNaggregationNumber);
	}

	public byte[] getUtsDot3OnuEtherPortVlanNaggregation() {
		return (byte[]) getProperty(utsDot3OnuEtherPortVlanNaggregation)
				.getValue();
	}

	public void setUtsDot3OnuEtherPortVlanNaggregation(
			byte[] aUtsDot3OnuEtherPortVlanNaggregation) {
		getProperty(utsDot3OnuEtherPortVlanNaggregation).setValue(
				aUtsDot3OnuEtherPortVlanNaggregation);
	}

	public byte[] getUtsDot3OnuEtherPortVlanTrunk() {
		return (byte[]) getProperty(utsDot3OnuEtherPortVlanTrunk).getValue();
	}

	public void setUtsDot3OnuEtherPortVlanTrunk(
			byte[] aUtsDot3OnuEtherPortVlanTrunk) {
		getProperty(utsDot3OnuEtherPortVlanTrunk).setValue(
				aUtsDot3OnuEtherPortVlanTrunk);
	}

	public void setUtsDot3OnuEtherPortVlanTranslation(
			byte[] aUtsDot3OnuEtherPortVlanTranslation) {
		getProperty(utsDot3OnuEtherPortVlanTranslation).setValue(
				aUtsDot3OnuEtherPortVlanTranslation);
	}

	public Integer getUtsDot3OnuEtherPortDSPolicingEnable() {
		return (Integer) getProperty(utsDot3OnuEtherPortDSPolicingEnable)
				.getValue();
	}

	public void setUtsDot3OnuEtherPortDSPolicingEnable(
			Integer aUtsDot3OnuEtherPortDSPolicingEnable) {
		getProperty(utsDot3OnuEtherPortDSPolicingEnable).setValue(
				aUtsDot3OnuEtherPortDSPolicingEnable);
	}

	public Integer getUtsDot3OnuEtherPortDSPolicingCIR() {
		return (Integer) getProperty(utsDot3OnuEtherPortDSPolicingCIR)
				.getValue();
	}

	public void setUtsDot3OnuEtherPortDSPolicingCIR(
			Integer aUtsDot3OnuEtherPortDSPolicingCIR) {
		getProperty(utsDot3OnuEtherPortDSPolicingCIR).setValue(
				aUtsDot3OnuEtherPortDSPolicingCIR);
	}

	public Integer getUtsDot3OnuEtherPortDSPolicingPIR() {
		return (Integer) getProperty(utsDot3OnuEtherPortDSPolicingPIR)
				.getValue();
	}

	public void setUtsDot3OnuEtherPortDSPolicingPIR(
			Integer aUtsDot3OnuEtherPortDSPolicingPIR) {
		getProperty(utsDot3OnuEtherPortDSPolicingPIR).setValue(
				aUtsDot3OnuEtherPortDSPolicingPIR);
	}
	
	//added by Zengtian, 2011/9/8
    public String getOnuLabel() {
        return onuLabel;
    }

    //added by Zengtian, 2011/9/8
    public void setOnuLabel(String label) {
        onuLabel = label;
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

		prepareSave(getProperty(utsDot3OnuEtherPortDSPolicingEnable));
		prepareSave(getProperty(utsDot3OnuEtherPortDSPolicingCIR));
		prepareSave(getProperty(utsDot3OnuEtherPortDSPolicingPIR));

		return save();
	}
}