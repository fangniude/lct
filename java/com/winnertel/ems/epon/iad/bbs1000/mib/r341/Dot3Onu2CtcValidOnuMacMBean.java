package com.winnertel.ems.epon.iad.bbs1000.mib.r341;

import com.winnertel.ems.epon.iad.bbs4000.mib.r216.MduMgmtIpConfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Onu2TrafficProfTable;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Hashtable;
import java.util.Vector;

public class Dot3Onu2CtcValidOnuMacMBean extends SnmpMibBean {
	public static final String utsDot3OnuValidOnuMacModuleId = "utsDot3OnuValidOnuMacModuleId";
	public static final String utsDot3OnuValidOnuMacDeviceId = "utsDot3OnuValidOnuMacDeviceId";
	public static final String utsDot3OnuValidOnuMacPortId = "utsDot3OnuValidOnuMacPortId";
	public static final String utsDot3OnuValidOnuMacAppLPortId = "utsDot3OnuValidOnuMacAppLPortId";
	public static final String utsDot3ValidOnuMacAddr = "utsDot3ValidOnuMacAddr";
	public static final String utsDot3Onu2ConfiguredOnuType = "utsDot3Onu2ConfiguredOnuType";
	public static final String utsDot3Onu2LoidAuthLoid = "utsDot3Onu2LoidAuthLoid";
	public static final String utsDot3Onu2LoidAuthPassword = "utsDot3Onu2LoidAuthPassword";
	public static final String utsDot3OnuAuthMethod = "utsDot3OnuAuthMethod";
	public static final String utsDot3OnuDescription = "utsDot3OnuDescription";

	public static final String utsDot3OnuUpstreamPir = "utsDot3OnuUpstreamPir";
	public static final String utsDot3OnuDownstreamPir = "utsDot3OnuDownstreamPir";
	public static final String utsDot3OnuUpstreamCir = "utsDot3OnuUpstreamCir";
	public static final String utsDot3OnuDownstreamCir = "utsDot3OnuDownstreamCir";
	public static final String utsDot3OnuUpstreamMaxBurstSize = "utsDot3OnuUpstreamMaxBurstSize";
	public static final String utsDot3OnuDownstreamMaxBurstSize = "utsDot3OnuDownstreamMaxBurstSize";
	public static final String utsDot3OnuUpstreamWeight = "utsDot3OnuUpstreamWeight";
	public static final String utsDot3OnuUpstreamFir = "utsDot3OnuUpstreamFir";
	public static final String utsDot3OnuAppliedDbaProfile = "utsDot3OnuAppliedDbaProfile";

	public static final String utsDot3Onu2CtcMduMgmtIpConfIpAddr = "utsDot3Onu2CtcMduMgmtIpConfIpAddr";
    public static final String utsDot3Onu2CtcMduMgmtIpConfIpMask = "utsDot3Onu2CtcMduMgmtIpConfIpMask";
    public static final String utsDot3Onu2CtcMduMgmtIpConfGw = "utsDot3Onu2CtcMduMgmtIpConfGw";
    public static final String utsDot3Onu2CtcMduMgmtIpConfCvlan = "utsDot3Onu2CtcMduMgmtIpConfCvlan";
    public static final String utsDot3Onu2CtcMduMgmtIpConfSvlan = "utsDot3Onu2CtcMduMgmtIpConfSvlan";

	public Onu2TrafficProfTable trafficProfTableBean = null;

	
	public MduMgmtIpConfTable mduMgmtIPCfgBean = null;
	
	private String onuLabel = null; //added by Zengtian, 2011/9/14

	public Dot3Onu2CtcValidOnuMacMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		fSnmpProxy = aSnmpProxy;

		trafficProfTableBean = new Onu2TrafficProfTable(aSnmpProxy);
		mduMgmtIPCfgBean = new MduMgmtIpConfTable(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OnuValidOnuMacModuleId, new SnmpMibBeanProperty(
				utsDot3OnuValidOnuMacModuleId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuValidOnuMacDeviceId, new SnmpMibBeanProperty(
				utsDot3OnuValidOnuMacDeviceId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuValidOnuMacPortId, new SnmpMibBeanProperty(
				utsDot3OnuValidOnuMacPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuValidOnuMacAppLPortId, new SnmpMibBeanProperty(
				utsDot3OnuValidOnuMacAppLPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3ValidOnuMacAddr, new SnmpMibBeanProperty(
				utsDot3ValidOnuMacAddr,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.5",
				ISnmpConstant.MAC_ADDRESS));
		initProperty(utsDot3Onu2ConfiguredOnuType, new SnmpMibBeanProperty(
				utsDot3Onu2ConfiguredOnuType,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2LoidAuthLoid,
				new SnmpMibBeanProperty(utsDot3Onu2LoidAuthLoid,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.7",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2LoidAuthPassword,
				new SnmpMibBeanProperty(utsDot3Onu2LoidAuthPassword,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.8",
						ISnmpConstant.STRING));
		initProperty(utsDot3OnuAuthMethod, new SnmpMibBeanProperty(
				utsDot3OnuAuthMethod,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.9",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDescription, new SnmpMibBeanProperty(
				utsDot3OnuDescription,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.10",
				ISnmpConstant.STRING));

		initProperty(utsDot3OnuUpstreamPir,
				new SnmpMibBeanProperty(utsDot3OnuUpstreamPir,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.5",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDownstreamPir,
				new SnmpMibBeanProperty(utsDot3OnuDownstreamPir,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.6",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuUpstreamCir,
				new SnmpMibBeanProperty(utsDot3OnuUpstreamCir,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.7",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDownstreamCir,
				new SnmpMibBeanProperty(utsDot3OnuDownstreamCir,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.8",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuUpstreamMaxBurstSize,
				new SnmpMibBeanProperty(utsDot3OnuUpstreamMaxBurstSize,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.9",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDownstreamMaxBurstSize, new SnmpMibBeanProperty(
				utsDot3OnuDownstreamMaxBurstSize,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.10",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuUpstreamWeight, new SnmpMibBeanProperty(
				utsDot3OnuUpstreamWeight,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.11",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuUpstreamFir, new SnmpMibBeanProperty(
				utsDot3OnuUpstreamFir,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.12",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuAppliedDbaProfile, new SnmpMibBeanProperty(
				utsDot3OnuAppliedDbaProfile,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.13",
				ISnmpConstant.INTEGER));
				
		initProperty(utsDot3Onu2CtcMduMgmtIpConfIpAddr,
				new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfIpAddr,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.32.1.5",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2CtcMduMgmtIpConfIpMask,
				new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfIpMask,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.32.1.6",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2CtcMduMgmtIpConfGw, new SnmpMibBeanProperty(
				utsDot3Onu2CtcMduMgmtIpConfGw,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.32.1.7",
				ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2CtcMduMgmtIpConfCvlan, new SnmpMibBeanProperty(
				utsDot3Onu2CtcMduMgmtIpConfCvlan,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.32.1.8",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcMduMgmtIpConfSvlan, new SnmpMibBeanProperty(
				utsDot3Onu2CtcMduMgmtIpConfSvlan,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.32.1.9",
				ISnmpConstant.INTEGER));
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
		getProperty(utsDot3Onu2LoidAuthLoid).setValue(aUtsDot3Onu2LoidAuthLoid);
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

	public Integer getUtsDot3OnuUpstreamPir() {
		if (trafficProfTableBean != null)
			return trafficProfTableBean.getUtsDot3OnuUpstreamPir();
		return null;
	}

	public void setUtsDot3OnuUpstreamPir(Integer aUtsDot3OnuUpstreamPir) {
		if (trafficProfTableBean == null) {
			trafficProfTableBean = new Onu2TrafficProfTable(fSnmpProxy);
			trafficProfTableBean
					.setUtsDot3OnuTProfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			trafficProfTableBean
					.setUtsDot3OnuTProfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			trafficProfTableBean
					.setUtsDot3OnuTProfPortId(getUtsDot3OnuValidOnuMacPortId());
			trafficProfTableBean
					.setUtsDot3OnuTProfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}

		trafficProfTableBean.setUtsDot3OnuUpstreamPir(aUtsDot3OnuUpstreamPir);
	}

	public Integer getUtsDot3OnuDownstreamPir() {
		if (trafficProfTableBean != null)
			return trafficProfTableBean.getUtsDot3OnuDownstreamPir();
		return null;
	}

	public void setUtsDot3OnuDownstreamPir(Integer aUtsDot3OnuDownstreamPir) {
		if (trafficProfTableBean == null) {
			trafficProfTableBean = new Onu2TrafficProfTable(fSnmpProxy);
			trafficProfTableBean
					.setUtsDot3OnuTProfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			trafficProfTableBean
					.setUtsDot3OnuTProfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			trafficProfTableBean
					.setUtsDot3OnuTProfPortId(getUtsDot3OnuValidOnuMacPortId());
			trafficProfTableBean
					.setUtsDot3OnuTProfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}

		trafficProfTableBean
				.setUtsDot3OnuDownstreamPir(aUtsDot3OnuDownstreamPir);
	}

	public Integer getUtsDot3OnuUpstreamCir() {
		if (trafficProfTableBean != null)
			return trafficProfTableBean.getUtsDot3OnuUpstreamCir();
		return null;
	}

	public void setUtsDot3OnuUpstreamCir(Integer aUtsDot3OnuUpstreamCir) {
		if (trafficProfTableBean == null) {
			trafficProfTableBean = new Onu2TrafficProfTable(fSnmpProxy);
			trafficProfTableBean
					.setUtsDot3OnuTProfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			trafficProfTableBean
					.setUtsDot3OnuTProfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			trafficProfTableBean
					.setUtsDot3OnuTProfPortId(getUtsDot3OnuValidOnuMacPortId());
			trafficProfTableBean
					.setUtsDot3OnuTProfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		trafficProfTableBean.setUtsDot3OnuUpstreamCir(aUtsDot3OnuUpstreamCir);
	}

	public Integer getUtsDot3OnuDownstreamCir() {
		if (trafficProfTableBean != null)
			return trafficProfTableBean.getUtsDot3OnuDownstreamCir();
		return null;
	}

	public void setUtsDot3OnuDownstreamCir(Integer aUtsDot3OnuDownstreamCir) {
		if (trafficProfTableBean == null) {
			trafficProfTableBean = new Onu2TrafficProfTable(fSnmpProxy);
			trafficProfTableBean
					.setUtsDot3OnuTProfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			trafficProfTableBean
					.setUtsDot3OnuTProfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			trafficProfTableBean
					.setUtsDot3OnuTProfPortId(getUtsDot3OnuValidOnuMacPortId());
			trafficProfTableBean
					.setUtsDot3OnuTProfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		trafficProfTableBean
				.setUtsDot3OnuDownstreamCir(aUtsDot3OnuDownstreamCir);
	}

	public Integer getUtsDot3OnuUpstreamMaxBurstSize() {
		if (trafficProfTableBean != null)
			return trafficProfTableBean.getUtsDot3OnuUpstreamMaxBurstSize();
		return null;
	}

	public void setUtsDot3OnuUpstreamMaxBurstSize(
			Integer aUtsDot3OnuUpstreamMaxBurstSize) {
		if (trafficProfTableBean == null) {
			trafficProfTableBean = new Onu2TrafficProfTable(fSnmpProxy);
			trafficProfTableBean
					.setUtsDot3OnuTProfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			trafficProfTableBean
					.setUtsDot3OnuTProfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			trafficProfTableBean
					.setUtsDot3OnuTProfPortId(getUtsDot3OnuValidOnuMacPortId());
			trafficProfTableBean
					.setUtsDot3OnuTProfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		trafficProfTableBean
				.setUtsDot3OnuUpstreamMaxBurstSize(aUtsDot3OnuUpstreamMaxBurstSize);
	}

	public Integer getUtsDot3OnuDownstreamMaxBurstSize() {
		if (trafficProfTableBean != null)
			return trafficProfTableBean.getUtsDot3OnuDownstreamMaxBurstSize();
		return null;
	}

	public void setUtsDot3OnuDownstreamMaxBurstSize(
			Integer aUtsDot3OnuDownstreamMaxBurstSize) {
		if (trafficProfTableBean == null) {
			trafficProfTableBean = new Onu2TrafficProfTable(fSnmpProxy);
			trafficProfTableBean
					.setUtsDot3OnuTProfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			trafficProfTableBean
					.setUtsDot3OnuTProfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			trafficProfTableBean
					.setUtsDot3OnuTProfPortId(getUtsDot3OnuValidOnuMacPortId());
			trafficProfTableBean
					.setUtsDot3OnuTProfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		trafficProfTableBean
				.setUtsDot3OnuDownstreamMaxBurstSize(aUtsDot3OnuDownstreamMaxBurstSize);
	}

	public Integer getUtsDot3OnuUpstreamWeight() {
		if (trafficProfTableBean != null)
			return trafficProfTableBean.getUtsDot3OnuUpstreamWeight();
		return null;
	}

	public void setUtsDot3OnuUpstreamWeight(Integer aUtsDot3OnuUpstreamWeight) {
		if (trafficProfTableBean == null) {
			trafficProfTableBean = new Onu2TrafficProfTable(fSnmpProxy);
			trafficProfTableBean
					.setUtsDot3OnuTProfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			trafficProfTableBean
					.setUtsDot3OnuTProfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			trafficProfTableBean
					.setUtsDot3OnuTProfPortId(getUtsDot3OnuValidOnuMacPortId());
			trafficProfTableBean
					.setUtsDot3OnuTProfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		trafficProfTableBean
				.setUtsDot3OnuUpstreamWeight(aUtsDot3OnuUpstreamWeight);
	}

	public Integer getUtsDot3OnuUpstreamFir() {
		if (trafficProfTableBean != null)
			return trafficProfTableBean.getUtsDot3OnuUpstreamFir();
		return null;
	}

	public void setUtsDot3OnuUpstreamFir(Integer aUtsDot3OnuUpstreamFir) {
		if (trafficProfTableBean == null) {
			trafficProfTableBean = new Onu2TrafficProfTable(fSnmpProxy);
			trafficProfTableBean
					.setUtsDot3OnuTProfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			trafficProfTableBean
					.setUtsDot3OnuTProfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			trafficProfTableBean
					.setUtsDot3OnuTProfPortId(getUtsDot3OnuValidOnuMacPortId());
			trafficProfTableBean
					.setUtsDot3OnuTProfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		trafficProfTableBean
				.setUtsDot3OnuUpstreamFir(aUtsDot3OnuUpstreamFir);
	}

	public Integer getUtsDot3OnuAppliedDbaProfile() {
		if (trafficProfTableBean != null)
			return trafficProfTableBean.getUtsDot3OnuAppliedDbaProfile();
		return null;
	}

	public void setUtsDot3OnuAppliedDbaProfile(
			Integer aUtsDot3OnuAppliedDbaProfile) {
		if (trafficProfTableBean == null) {
			trafficProfTableBean = new Onu2TrafficProfTable(fSnmpProxy);
			trafficProfTableBean
					.setUtsDot3OnuTProfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			trafficProfTableBean
					.setUtsDot3OnuTProfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			trafficProfTableBean
					.setUtsDot3OnuTProfPortId(getUtsDot3OnuValidOnuMacPortId());
			trafficProfTableBean
					.setUtsDot3OnuTProfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		trafficProfTableBean
				.setUtsDot3OnuAppliedDbaProfile(aUtsDot3OnuAppliedDbaProfile);
	}
	
	
	public String getUtsDot3Onu2CtcMduMgmtIpConfIpAddr() {
		if (mduMgmtIPCfgBean != null)
			return mduMgmtIPCfgBean.getUtsDot3Onu2CtcMduMgmtIpConfIpAddr();
		return null;
	}

	public void setUtsDot3Onu2CtcMduMgmtIpConfIpAddr(
			String aUtsDot3Onu2CtcMduMgmtIpConfIpAddr) {
		if (mduMgmtIPCfgBean == null) {
			mduMgmtIPCfgBean = new MduMgmtIpConfTable(fSnmpProxy);
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfPortId(getUtsDot3OnuValidOnuMacPortId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		mduMgmtIPCfgBean
				.setUtsDot3Onu2CtcMduMgmtIpConfIpAddr(aUtsDot3Onu2CtcMduMgmtIpConfIpAddr);
	}

	public String getUtsDot3Onu2CtcMduMgmtIpConfIpMask() {
		if (mduMgmtIPCfgBean != null)
			return mduMgmtIPCfgBean.getUtsDot3Onu2CtcMduMgmtIpConfIpMask();
		return null;
	}

	public void setUtsDot3Onu2CtcMduMgmtIpConfIpMask(
			String aUtsDot3Onu2CtcMduMgmtIpConfIpMask) {
		if (mduMgmtIPCfgBean == null) {
			mduMgmtIPCfgBean = new MduMgmtIpConfTable(fSnmpProxy);
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfPortId(getUtsDot3OnuValidOnuMacPortId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		mduMgmtIPCfgBean
				.setUtsDot3Onu2CtcMduMgmtIpConfIpMask(aUtsDot3Onu2CtcMduMgmtIpConfIpMask);
	}

	public String getUtsDot3Onu2CtcMduMgmtIpConfGw() {
		if (mduMgmtIPCfgBean != null)
			return mduMgmtIPCfgBean.getUtsDot3Onu2CtcMduMgmtIpConfGw();
		return null;
	}

	public void setUtsDot3Onu2CtcMduMgmtIpConfGw(
			String aUtsDot3Onu2CtcMduMgmtIpConfGw) {
		if (mduMgmtIPCfgBean == null) {
			mduMgmtIPCfgBean = new MduMgmtIpConfTable(fSnmpProxy);
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfPortId(getUtsDot3OnuValidOnuMacPortId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		mduMgmtIPCfgBean
				.setUtsDot3Onu2CtcMduMgmtIpConfGw(aUtsDot3Onu2CtcMduMgmtIpConfGw);
	}

	public Integer getUtsDot3Onu2CtcMduMgmtIpConfCvlan() {
		if (mduMgmtIPCfgBean != null)
			return mduMgmtIPCfgBean.getUtsDot3Onu2CtcMduMgmtIpConfCvlan();
		return null;
	}

	public void setUtsDot3Onu2CtcMduMgmtIpConfCvlan(
			Integer aUtsDot3Onu2CtcMduMgmtIpConfCvlan) {
		if (mduMgmtIPCfgBean == null) {
			mduMgmtIPCfgBean = new MduMgmtIpConfTable(fSnmpProxy);
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfPortId(getUtsDot3OnuValidOnuMacPortId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		mduMgmtIPCfgBean
				.setUtsDot3Onu2CtcMduMgmtIpConfCvlan(aUtsDot3Onu2CtcMduMgmtIpConfCvlan);
	}

	public Integer getUtsDot3Onu2CtcMduMgmtIpConfSvlan() {
		if (mduMgmtIPCfgBean != null)
			return mduMgmtIPCfgBean.getUtsDot3Onu2CtcMduMgmtIpConfSvlan();
		return null;
	}

	public void setUtsDot3Onu2CtcMduMgmtIpConfSvlan(
			Integer aUtsDot3Onu2CtcMduMgmtIpConfSvlan) {
		if (mduMgmtIPCfgBean == null) {
			mduMgmtIPCfgBean = new MduMgmtIpConfTable(fSnmpProxy);
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfPortId(getUtsDot3OnuValidOnuMacPortId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		mduMgmtIPCfgBean
				.setUtsDot3Onu2CtcMduMgmtIpConfSvlan(aUtsDot3Onu2CtcMduMgmtIpConfSvlan);
	}

	public Onu2TrafficProfTable getTrafficProfTableBean() {
		return trafficProfTableBean;
	}

	public void setTrafficProfTableBean(
			Onu2TrafficProfTable trafficProfTableBean) {
		this.trafficProfTableBean = trafficProfTableBean;
	}

	
	public MduMgmtIpConfTable getMduMgmtIpCfgBean() {
		return mduMgmtIPCfgBean;
	}

	public void setMduMgmtIpCfgBean(
			MduMgmtIpConfTable mgmtIPCfgTable) {
		this.mduMgmtIPCfgBean = mgmtIPCfgTable;
	}
	
	//added by Zengtian, 2011/9/14
    public String getOnuLabel() {
        return onuLabel;
    }

    //added by Zengtian, 2011/9/14
    public void setOnuLabel(String label) {
        onuLabel = label;
    }

	public boolean retrieve() throws MibBeanException {
		if (trafficProfTableBean == null) {
			trafficProfTableBean = new Onu2TrafficProfTable(fSnmpProxy);
			trafficProfTableBean
					.setUtsDot3OnuTProfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			trafficProfTableBean
					.setUtsDot3OnuTProfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			trafficProfTableBean
					.setUtsDot3OnuTProfPortId(getUtsDot3OnuValidOnuMacPortId());
			trafficProfTableBean
					.setUtsDot3OnuTProfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		boolean bl2 = trafficProfTableBean.retrieve();
		
		if (mduMgmtIPCfgBean == null) {
			mduMgmtIPCfgBean = new MduMgmtIpConfTable(fSnmpProxy);
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfModuleId(getUtsDot3OnuValidOnuMacModuleId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfDeviceId(getUtsDot3OnuValidOnuMacDeviceId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfPortId(getUtsDot3OnuValidOnuMacPortId());
			mduMgmtIPCfgBean
					.setUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId(getUtsDot3OnuValidOnuMacAppLPortId());
		}
		boolean bl5 = mduMgmtIPCfgBean.retrieve();

		prepareRead(getProperty(utsDot3ValidOnuMacAddr));
		prepareRead(getProperty(utsDot3Onu2ConfiguredOnuType));
		prepareRead(getProperty(utsDot3Onu2LoidAuthLoid));
		prepareRead(getProperty(utsDot3Onu2LoidAuthPassword));
		prepareRead(getProperty(utsDot3OnuAuthMethod));
		prepareRead(getProperty(utsDot3OnuDescription));

		boolean bl1 = load();

		return bl1 && bl2 && bl5;

	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(getProperty(utsDot3ValidOnuMacAddr));
		prepareRead(getProperty(utsDot3Onu2ConfiguredOnuType));
		prepareRead(getProperty(utsDot3Onu2LoidAuthLoid));
		prepareRead(getProperty(utsDot3Onu2LoidAuthPassword));
		prepareRead(getProperty(utsDot3OnuAuthMethod));
		prepareRead(getProperty(utsDot3OnuDescription));

		Vector macTable = loadAll(new int[] { 1, 1, 1, 1 });

		Vector profTable = trafficProfTableBean.retrieveAll();
		Vector mgmtIpTable = mduMgmtIPCfgBean.retrieveAll();

		Hashtable<String, Onu2TrafficProfTable> index2ProfBean = new Hashtable<String, Onu2TrafficProfTable>();
		for (int i = 0; i < profTable.size(); i++) {
			Onu2TrafficProfTable mBean = (Onu2TrafficProfTable) profTable
					.get(i);
			Integer moduleId = mBean.getUtsDot3OnuTProfModuleId();
			Integer deviceId = mBean.getUtsDot3OnuTProfDeviceId();
			Integer portId = mBean.getUtsDot3OnuTProfPortId();
			Integer logicalId = mBean.getUtsDot3OnuTProfLogicalPortId();

			index2ProfBean.put(moduleId + "-" + deviceId + "-" + portId + "-"
					+ logicalId, mBean);
		}
		
		Hashtable<String, MduMgmtIpConfTable> index2MgmtIpBean = new Hashtable<String, MduMgmtIpConfTable>();
		for (int i = 0; i < mgmtIpTable.size(); i++) {
			MduMgmtIpConfTable mBean = (MduMgmtIpConfTable) mgmtIpTable.get(i);
			Integer moduleId = mBean.getUtsDot3Onu2CtcMduMgmtIpConfModuleId();
			Integer deviceId = mBean.getUtsDot3Onu2CtcMduMgmtIpConfDeviceId();
			Integer portId = mBean.getUtsDot3Onu2CtcMduMgmtIpConfPortId();
			Integer logicalId = mBean.getUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId();

			index2MgmtIpBean.put(moduleId + "-" + deviceId + "-" + portId + "-"
					+ logicalId, mBean);
		}

		Vector result = new Vector();
		for (int i = 0; i < macTable.size(); i++) {
			Dot3Onu2CtcValidOnuMacMBean macBean = (Dot3Onu2CtcValidOnuMacMBean) macTable
					.get(i);
			Integer moduleId = macBean.getUtsDot3OnuValidOnuMacModuleId();
			Integer deviceId = macBean.getUtsDot3OnuValidOnuMacDeviceId();
			Integer portId = macBean.getUtsDot3OnuValidOnuMacPortId();
			Integer logicalId = macBean.getUtsDot3OnuValidOnuMacAppLPortId();

			macBean.setTrafficProfTableBean(index2ProfBean.get(moduleId + "-"
					+ deviceId + "-" + portId + "-" + logicalId));
			
			macBean.setMduMgmtIpCfgBean(index2MgmtIpBean.get(moduleId + "-"
					+ deviceId + "-" + portId + "-" + logicalId));

			result.add(macBean);
		}
		
		  //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < result.size(); i++) {
//                    Dot3Onu2CtcValidOnuMacMBean bean = (Dot3Onu2CtcValidOnuMacMBean) result.get(i);
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

		return result;

	}

	public boolean modify() throws MibBeanException {
		boolean bl2 = true, bl4 = true, bl5 = true;
		if (trafficProfTableBean != null
				&& getUtsDot3OnuAppliedDbaProfile() != null)
			bl2 = trafficProfTableBean.modify();
		
		if(mduMgmtIPCfgBean != null)
			bl5 = mduMgmtIPCfgBean.modify();

		if (getUtsDot3ValidOnuMacAddr() != null)
			prepareSave(getProperty(utsDot3ValidOnuMacAddr));
		prepareSave(getProperty(utsDot3Onu2ConfiguredOnuType));
		if (getUtsDot3Onu2LoidAuthLoid() != null)
			prepareSave(getProperty(utsDot3Onu2LoidAuthLoid));
		if (getUtsDot3Onu2LoidAuthPassword() != null)
			prepareSave(getProperty(utsDot3Onu2LoidAuthPassword));
		prepareSave(getProperty(utsDot3OnuDescription));

		return save() & bl2 & bl4 & bl5;
	}

}
