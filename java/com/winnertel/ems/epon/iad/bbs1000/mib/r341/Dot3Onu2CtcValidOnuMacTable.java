package com.winnertel.ems.epon.iad.bbs1000.mib.r341;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Onu2CtcValidOnuMacTable extends SnmpMibBean {
	public static final String utsDot3OnuValidOnuMacModuleId = "utsDot3OnuValidOnuMacModuleId";
	public static final String utsDot3OnuValidOnuMacDeviceId = "utsDot3OnuValidOnuMacDeviceId";
	public static final String utsDot3OnuValidOnuMacPortId = "utsDot3OnuValidOnuMacPortId";
	public static final String utsDot3OnuValidOnuMacAppLPortId = "utsDot3OnuValidOnuMacAppLPortId";

	public static final String utsDot3OnuDescription = "utsDot3OnuDescription";
	public static final String utsDot3Onu2ConfiguredOnuType = "utsDot3Onu2ConfiguredOnuType";
	public static final String utsDot3OnuAuthMethod = "utsDot3OnuAuthMethod";
	public static final String utsDot3ValidOnuMacAddr = "utsDot3ValidOnuMacAddr";
	public static final String utsDot3Onu2LoidAuthLoid = "utsDot3Onu2LoidAuthLoid";
	public static final String utsDot3Onu2LoidAuthPassword = "utsDot3Onu2LoidAuthPassword";
	
	private String onuLabel = null; //added by Zengtian, 2011/9/14

	public Dot3Onu2CtcValidOnuMacTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OnuValidOnuMacModuleId, new SnmpMibBeanProperty(
				utsDot3OnuValidOnuMacModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.17.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuValidOnuMacDeviceId, new SnmpMibBeanProperty(
				utsDot3OnuValidOnuMacDeviceId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.17.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuValidOnuMacPortId, new SnmpMibBeanProperty(
				utsDot3OnuValidOnuMacPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.17.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuValidOnuMacAppLPortId, new SnmpMibBeanProperty(
				utsDot3OnuValidOnuMacAppLPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.17.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3ValidOnuMacAddr, new SnmpMibBeanProperty(
				utsDot3ValidOnuMacAddr,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.17.1.5",
				ISnmpConstant.MAC_ADDRESS));
		initProperty(utsDot3Onu2ConfiguredOnuType, new SnmpMibBeanProperty(
				utsDot3Onu2ConfiguredOnuType,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.17.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2LoidAuthLoid,
				new SnmpMibBeanProperty(utsDot3Onu2LoidAuthLoid,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.17.1.7",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2LoidAuthPassword,
				new SnmpMibBeanProperty(utsDot3Onu2LoidAuthPassword,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.17.1.8",
						ISnmpConstant.STRING));
		initProperty(utsDot3OnuAuthMethod, new SnmpMibBeanProperty(
				utsDot3OnuAuthMethod,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.17.1.9",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDescription, new SnmpMibBeanProperty(
				utsDot3OnuDescription,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.17.1.10",
				ISnmpConstant.STRING));
	}

	public Integer getUtsDot3OnuValidOnuMacModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3OnuValidOnuMacModuleId(
			Integer aUtsDot3OnuValidOnuMacModuleId) {
		setIndex(0, aUtsDot3OnuValidOnuMacModuleId);
	}

	public Integer getUtsDot3OnuValidOnuMacDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3OnuValidOnuMacDeviceId(
			Integer aUtsDot3OnuValidOnuMacDeviceId) {
		setIndex(1, aUtsDot3OnuValidOnuMacDeviceId);
	}

	public Integer getUtsDot3OnuValidOnuMacPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3OnuValidOnuMacPortId(
			Integer aUtsDot3OnuValidOnuMacPortId) {
		setIndex(2, aUtsDot3OnuValidOnuMacPortId);
	}

	public Integer getUtsDot3OnuValidOnuMacAppLPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3OnuValidOnuMacAppLPortId(
			Integer aUtsDot3OnuValidOnuMacAppLPortId) {
		setIndex(3, aUtsDot3OnuValidOnuMacAppLPortId);
	}

	public byte[] getUtsDot3ValidOnuMacAddr() {
		return (byte[]) getProperty(utsDot3ValidOnuMacAddr).getValue();
	}

	public void setUtsDot3ValidOnuMacAddr(byte[] aUtsDot3ValidOnuMacAddr) {
		getProperty(utsDot3ValidOnuMacAddr).setValue(aUtsDot3ValidOnuMacAddr);
	}

	public Integer getUtsDot3Onu2ConfiguredOnuType() {
		return (Integer) getProperty(utsDot3Onu2ConfiguredOnuType).getValue();
	}

	public void setUtsDot3Onu2ConfiguredOnuType(
			Integer aUtsDot3Onu2ConfiguredOnuType) {
		getProperty(utsDot3Onu2ConfiguredOnuType).setValue(
				aUtsDot3Onu2ConfiguredOnuType);
	}

	public String getUtsDot3Onu2LoidAuthLoid() {
		return (String) getProperty(utsDot3Onu2LoidAuthLoid).getValue();
	}

	public void setUtsDot3Onu2LoidAuthLoid(String aUtsDot3Onu2LoidAuthLoid) {
		getProperty(utsDot3Onu2LoidAuthLoid)
				.setValue(aUtsDot3Onu2LoidAuthLoid);
	}

	public String getUtsDot3Onu2LoidAuthPassword() {
		return (String) getProperty(utsDot3Onu2LoidAuthPassword).getValue();
	}

	public void setUtsDot3Onu2LoidAuthPassword(
			String aUtsDot3Onu2LoidAuthPassword) {
		getProperty(utsDot3Onu2LoidAuthPassword).setValue(
				aUtsDot3Onu2LoidAuthPassword);
	}

	public Integer getUtsDot3OnuAuthMethod() {
		return (Integer) getProperty(utsDot3OnuAuthMethod).getValue();
	}

	public void setUtsDot3OnuAuthMethod(Integer aUtsDot3OnuAuthMethod) {
		getProperty(utsDot3OnuAuthMethod).setValue(aUtsDot3OnuAuthMethod);
	}

	public String getUtsDot3OnuDescription() {
		return (String) getProperty(utsDot3OnuDescription).getValue();
	}

	public void setUtsDot3OnuDescription(String aUtsDot3OnuDescription) {
		getProperty(utsDot3OnuDescription).setValue(aUtsDot3OnuDescription);
	}
	
	//added by Zengtian, 2011/9/14
    public String getOnuLabel() {
        return onuLabel;
    }

    //added by Zengtian, 2011/9/14
    public void setOnuLabel(String label) {
        onuLabel = label;
    }

//	public boolean resetONU() throws MibBeanException {
//		setUtsDot3Onu2CtcReset(1);
//		prepareSave(getProperty(utsDot3Onu2CtcReset));
//
//		return save();
//	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(getProperty(utsDot3ValidOnuMacAddr));
		prepareRead(getProperty(utsDot3Onu2ConfiguredOnuType));
		prepareRead(getProperty(utsDot3Onu2LoidAuthLoid));
		prepareRead(getProperty(utsDot3Onu2LoidAuthPassword));
		prepareRead(getProperty(utsDot3OnuAuthMethod));
		prepareRead(getProperty(utsDot3OnuDescription));

		boolean isload = load();
//        if (isload && !DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//
//                //find the onu by module/port/logicalid
//                String key = new StringBuilder(neName).append(getUtsDot3OnuValidOnuMacModuleId()).append("/").append(getUtsDot3OnuValidOnuMacPortId()).append("/").append(getUtsDot3OnuValidOnuMacAppLPortId()).toString();
//                if (map.containsKey(key)) {
//                    setOnuLabel((String) map.get(key));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        
        return isload;

	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(getProperty(utsDot3ValidOnuMacAddr));
		prepareRead(getProperty(utsDot3Onu2ConfiguredOnuType));
		prepareRead(getProperty(utsDot3Onu2LoidAuthLoid));
		prepareRead(getProperty(utsDot3Onu2LoidAuthPassword));
		prepareRead(getProperty(utsDot3OnuAuthMethod));
		prepareRead(getProperty(utsDot3OnuDescription));

		Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zengtian, 2011/9/14
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Dot3Onu2CtcValidOnuMacTable bean = (Dot3Onu2CtcValidOnuMacTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3OnuValidOnuMacModuleId()).append("/").append(bean.getUtsDot3OnuValidOnuMacPortId()).append("/").append(bean.getUtsDot3OnuValidOnuMacAppLPortId()).toString();
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
		prepareSave(getProperty(utsDot3ValidOnuMacAddr));
		prepareSave(getProperty(utsDot3Onu2ConfiguredOnuType));
		prepareSave(getProperty(utsDot3Onu2LoidAuthLoid));
		prepareSave(getProperty(utsDot3Onu2LoidAuthPassword));
//		prepareSave(getProperty(utsDot3OnuAuthMethod));
		prepareSave(getProperty(utsDot3OnuDescription));

		return save();
	}

}
