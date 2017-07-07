package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The LinkAggregationControl class. Created by QuickDVM
 */
public class LinkAggregationControl extends SnmpMibBean
{
	public static final String utsIntfRateControlUplinkSpeed = "utsIntfRateControlUplinkSpeed";

	public static final String utsIntfRateControlVlanIngressFilter = "utsIntfRateControlVlanIngressFilter";

	public static final String utsIntfRateControlUplinkTranceiverType = "utsIntfRateControlUplinkTranceiverType";

	public static final String utsIntfRateControlAutoNegotiation = "utsIntfRateControlAutoNegotiation";

	public static final String utsSwitchPortExtIfNum = "utsSwitchPortExtIfNum";

	public static final String utsSwitchPortExtModuleId = "utsSwitchPortExtModuleId";

	public static final String utsSwitchPortExtPortId = "utsSwitchPortExtPortId";

	public static final String utsSwitchPortExtLAGId = "utsSwitchPortExtLAGId";

	public static final String utsSwitchPortExtPortType = "utsSwitchPortExtPortType";

	public static final String utsSwitchPortExtACLDefAction = "utsSwitchPortExtACLDefAction";

	public static final String utsSwitchPortExtAdmFlowControlRx = "utsSwitchPortExtAdmFlowControlRx";

	public static final String utsSwitchPortExtAdmFlowControlTx = "utsSwitchPortExtAdmFlowControlTx";

	public static final String utsSwitchPortExtIpMuticastFilter = "utsSwitchPortExtIpMuticastFilter";

	public LinkAggregationControl(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsIntfRateControlUplinkSpeed, new SnmpMibBeanProperty(
				utsIntfRateControlUplinkSpeed,
				".1.3.6.1.4.1.41355.1800.2.2.1.5.3.1.1.13",
				ISnmpConstant.INTEGER));
		initProperty(utsIntfRateControlVlanIngressFilter,
				new SnmpMibBeanProperty(utsIntfRateControlVlanIngressFilter,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.3.1.1.14",
						ISnmpConstant.INTEGER));
		initProperty(utsIntfRateControlUplinkTranceiverType,
				new SnmpMibBeanProperty(utsIntfRateControlUplinkTranceiverType,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.3.1.1.15",
						ISnmpConstant.INTEGER));
		initProperty(utsIntfRateControlAutoNegotiation,
				new SnmpMibBeanProperty(utsIntfRateControlAutoNegotiation,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.3.1.1.16",
						ISnmpConstant.INTEGER));
		initProperty(utsSwitchPortExtIfNum, new SnmpMibBeanProperty(
				utsSwitchPortExtIfNum, ".1.3.6.1.4.1.41355.1800.2.2.1.8.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsSwitchPortExtModuleId, new SnmpMibBeanProperty(
				utsSwitchPortExtModuleId, ".1.3.6.1.4.1.41355.1800.2.2.1.8.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsSwitchPortExtPortId, new SnmpMibBeanProperty(
				utsSwitchPortExtPortId, ".1.3.6.1.4.1.41355.1800.2.2.1.8.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsSwitchPortExtLAGId, new SnmpMibBeanProperty(
				utsSwitchPortExtLAGId, ".1.3.6.1.4.1.41355.1800.2.2.1.8.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsSwitchPortExtPortType, new SnmpMibBeanProperty(
				utsSwitchPortExtPortType, ".1.3.6.1.4.1.41355.1800.2.2.1.8.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsSwitchPortExtACLDefAction, new SnmpMibBeanProperty(
				utsSwitchPortExtACLDefAction,
				".1.3.6.1.4.1.41355.1800.2.2.1.8.1.6", ISnmpConstant.INTEGER));
		initProperty(utsSwitchPortExtAdmFlowControlRx, new SnmpMibBeanProperty(
				utsSwitchPortExtAdmFlowControlRx,
				".1.3.6.1.4.1.41355.1800.2.2.1.8.1.7", ISnmpConstant.INTEGER));
		initProperty(utsSwitchPortExtAdmFlowControlTx, new SnmpMibBeanProperty(
				utsSwitchPortExtAdmFlowControlTx,
				".1.3.6.1.4.1.41355.1800.2.2.1.8.1.9", ISnmpConstant.INTEGER));
		initProperty(utsSwitchPortExtIpMuticastFilter, new SnmpMibBeanProperty(
				utsSwitchPortExtIpMuticastFilter,
				".1.3.6.1.4.1.41355.1800.2.2.1.8.1.11", ISnmpConstant.INTEGER));

	}

	public Integer getUtsSwitchPortExtIfNum()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsSwitchPortExtIfNum(Integer aUtsSwitchPortExtIfNum)
	{
		setIndex(0, aUtsSwitchPortExtIfNum);
	}

	public Integer getUtsIntfRateControlUplinkSpeed()
	{
		return (Integer) getProperty(utsIntfRateControlUplinkSpeed).getValue();
	}

	public void setUtsIntfRateControlUplinkSpeed(
			Integer aUtsIntfRateControlUplinkSpeed)
	{
		getProperty(utsIntfRateControlUplinkSpeed).setValue(
				aUtsIntfRateControlUplinkSpeed);
	}

	public Integer getUtsIntfRateControlVlanIngressFilter()
	{
		return (Integer) getProperty(utsIntfRateControlVlanIngressFilter)
				.getValue();
	}

	public void setUtsIntfRateControlVlanIngressFilter(
			Integer aUtsIntfRateControlVlanIngressFilter)
	{
		getProperty(utsIntfRateControlVlanIngressFilter).setValue(
				aUtsIntfRateControlVlanIngressFilter);
	}

	public Integer getUtsIntfRateControlUplinkTranceiverType()
	{
		return (Integer) getProperty(utsIntfRateControlUplinkTranceiverType)
				.getValue();
	}

	public void setUtsIntfRateControlUplinkTranceiverType(
			Integer aUtsIntfRateControlUplinkTranceiverType)
	{
		getProperty(utsIntfRateControlUplinkTranceiverType).setValue(
				aUtsIntfRateControlUplinkTranceiverType);
	}

	public Integer getUtsIntfRateControlAutoNegotiation()
	{
		return (Integer) getProperty(utsIntfRateControlAutoNegotiation)
				.getValue();
	}

	public void setUtsIntfRateControlAutoNegotiation(
			Integer aUtsIntfRateControlAutoNegotiation)
	{
		getProperty(utsIntfRateControlAutoNegotiation).setValue(
				aUtsIntfRateControlAutoNegotiation);
	}

	public Integer getUtsSwitchPortExtModuleId()
	{
		return (Integer) getProperty(utsSwitchPortExtModuleId).getValue();
	}

	public void setUtsSwitchPortExtModuleId(Integer aUtsSwitchPortExtModuleId)
	{
		getProperty(utsSwitchPortExtModuleId).setValue(
				aUtsSwitchPortExtModuleId);
	}

	public Integer getUtsSwitchPortExtPortId()
	{
		return (Integer) getProperty(utsSwitchPortExtPortId).getValue();
	}

	public void setUtsSwitchPortExtPortId(Integer aUtsSwitchPortExtPortId)
	{
		getProperty(utsSwitchPortExtPortId).setValue(aUtsSwitchPortExtPortId);
	}

	public Integer getUtsSwitchPortExtLAGId()
	{
		return (Integer) getProperty(utsSwitchPortExtLAGId).getValue();
	}

	public void setUtsSwitchPortExtLAGId(Integer aUtsSwitchPortExtLAGId)
	{
		getProperty(utsSwitchPortExtLAGId).setValue(aUtsSwitchPortExtLAGId);
	}

	public Integer getUtsSwitchPortExtPortType()
	{
		return (Integer) getProperty(utsSwitchPortExtPortType).getValue();
	}

	public void setUtsSwitchPortExtPortType(Integer aUtsSwitchPortExtPortType)
	{
		getProperty(utsSwitchPortExtPortType).setValue(
				aUtsSwitchPortExtPortType);
	}

	public Integer getUtsSwitchPortExtACLDefAction()
	{
		return (Integer) getProperty(utsSwitchPortExtACLDefAction).getValue();
	}

	public void setUtsSwitchPortExtACLDefAction(
			Integer aUtsSwitchPortExtACLDefAction)
	{
		getProperty(utsSwitchPortExtACLDefAction).setValue(
				aUtsSwitchPortExtACLDefAction);
	}

	public Integer getUtsSwitchPortExtAdmFlowControlRx()
	{
		return (Integer) getProperty(utsSwitchPortExtAdmFlowControlRx)
				.getValue();
	}

	public void setUtsSwitchPortExtAdmFlowControlRx(
			Integer aUtsSwitchPortExtAdmFlowControlRx)
	{
		getProperty(utsSwitchPortExtAdmFlowControlRx).setValue(
				aUtsSwitchPortExtAdmFlowControlRx);
	}

	public Integer getUtsSwitchPortExtAdmFlowControlTx()
	{
		return (Integer) getProperty(utsSwitchPortExtAdmFlowControlTx)
				.getValue();
	}

	public void setUtsSwitchPortExtAdmFlowControlTx(
			Integer aUtsSwitchPortExtAdmFlowControlTx)
	{
		getProperty(utsSwitchPortExtAdmFlowControlTx).setValue(
				aUtsSwitchPortExtAdmFlowControlTx);
	}

	public Integer getUtsSwitchPortExtIpMuticastFilter()
	{
		return (Integer) getProperty(utsSwitchPortExtIpMuticastFilter)
				.getValue();
	}

	public void setUtsSwitchPortExtIpMuticastFilter(
			Integer aUtsSwitchPortExtIpMuticastFilter)
	{
		getProperty(utsSwitchPortExtIpMuticastFilter).setValue(
				aUtsSwitchPortExtIpMuticastFilter);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIntfRateControlUplinkSpeed));
		prepareRead(super.getProperty(utsIntfRateControlVlanIngressFilter));
		prepareRead(super.getProperty(utsIntfRateControlUplinkTranceiverType));
		prepareRead(super.getProperty(utsIntfRateControlAutoNegotiation));
		prepareRead(super.getProperty(utsSwitchPortExtModuleId));
		prepareRead(super.getProperty(utsSwitchPortExtPortId));
		prepareRead(super.getProperty(utsSwitchPortExtLAGId));
		prepareRead(super.getProperty(utsSwitchPortExtPortType));
		prepareRead(super.getProperty(utsSwitchPortExtACLDefAction));
		prepareRead(super.getProperty(utsSwitchPortExtAdmFlowControlRx));
		prepareRead(super.getProperty(utsSwitchPortExtAdmFlowControlTx));
		prepareRead(super.getProperty(utsSwitchPortExtIpMuticastFilter));

		return load();
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsIntfRateControlUplinkSpeed));
		prepareSave(getProperty(utsIntfRateControlVlanIngressFilter));
		prepareSave(getProperty(utsIntfRateControlAutoNegotiation));
		prepareSave(getProperty(utsSwitchPortExtACLDefAction));
		prepareSave(getProperty(utsSwitchPortExtAdmFlowControlRx));
		prepareSave(getProperty(utsSwitchPortExtAdmFlowControlTx));
		prepareSave(getProperty(utsSwitchPortExtIpMuticastFilter));

		return save();
	}

}
