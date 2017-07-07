package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The QosExtDscpTrustTable class. Created by QuickDVM
 */
public class LgQosExtDscpTrustTable extends SnmpMibBean
{
	public static final String utsMLSQosExtDscpTrustIntfIndex = "utsMLSQosExtDscpTrustIntfIndex";

	public static final String utsMLSQosExtDscpTrustModuleId = "utsMLSQosExtDscpTrustModuleId";

	public static final String utsMLSQosExtDscpTrustPortId = "utsMLSQosExtDscpTrustPortId";

	public static final String utsMLSQosExtDscpTrustLagPortId = "utsMLSQosExtDscpTrustLagPortId";

	public static final String utsMLSQosExtDscpTrustMode = "utsMLSQosExtDscpTrustMode";

	public static final String utsMLSQosExtDscpTrustIntfQosCtrl = "utsMLSQosExtDscpTrustIntfQosCtrl";

	public LgQosExtDscpTrustTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsMLSQosExtDscpTrustIntfIndex, new SnmpMibBeanProperty(
				utsMLSQosExtDscpTrustIntfIndex,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.1", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpTrustModuleId, new SnmpMibBeanProperty(
				utsMLSQosExtDscpTrustModuleId,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.2", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpTrustPortId, new SnmpMibBeanProperty(
				utsMLSQosExtDscpTrustPortId,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.3", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpTrustLagPortId, new SnmpMibBeanProperty(
				utsMLSQosExtDscpTrustLagPortId,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.4", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpTrustMode, new SnmpMibBeanProperty(
				utsMLSQosExtDscpTrustMode,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.5", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpTrustIntfQosCtrl, new SnmpMibBeanProperty(
				utsMLSQosExtDscpTrustIntfQosCtrl,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.6", ISnmpConstant.INTEGER));

	}

	public Integer getUtsMLSQosExtDscpTrustIntfIndex()
	{
      return (Integer)getIndex(0);
	}

	public void setUtsMLSQosExtDscpTrustIntfIndex(
			Integer aUtsMLSQosExtDscpTrustIntfIndex)
	{
		setIndex(0, aUtsMLSQosExtDscpTrustIntfIndex);
	}

	public Integer getUtsMLSQosExtDscpTrustModuleId()
	{
		return (Integer) getProperty(utsMLSQosExtDscpTrustModuleId).getValue();
	}

	public void setUtsMLSQosExtDscpTrustModuleId(
			Integer aUtsMLSQosExtDscpTrustModuleId)
	{
		getProperty(utsMLSQosExtDscpTrustModuleId).setValue(
				aUtsMLSQosExtDscpTrustModuleId);
	}

	public Integer getUtsMLSQosExtDscpTrustPortId()
	{
		return (Integer) getProperty(utsMLSQosExtDscpTrustPortId).getValue();
	}

	public void setUtsMLSQosExtDscpTrustPortId(
			Integer aUtsMLSQosExtDscpTrustPortId)
	{
		getProperty(utsMLSQosExtDscpTrustPortId).setValue(
				aUtsMLSQosExtDscpTrustPortId);
	}

	public Integer getUtsMLSQosExtDscpTrustLagPortId()
	{
		return (Integer) getProperty(utsMLSQosExtDscpTrustLagPortId).getValue();
	}

	public void setUtsMLSQosExtDscpTrustLagPortId(
			Integer aUtsMLSQosExtDscpTrustLagPortId)
	{
		getProperty(utsMLSQosExtDscpTrustLagPortId).setValue(
				aUtsMLSQosExtDscpTrustLagPortId);
	}

	public Integer getUtsMLSQosExtDscpTrustMode()
	{
		return (Integer) getProperty(utsMLSQosExtDscpTrustMode).getValue();
	}

	public void setUtsMLSQosExtDscpTrustMode(Integer aUtsMLSQosExtDscpTrustMode)
	{
		getProperty(utsMLSQosExtDscpTrustMode).setValue(
				aUtsMLSQosExtDscpTrustMode);
	}

	public Integer getUtsMLSQosExtDscpTrustIntfQosCtrl()
	{
		return (Integer) getProperty(utsMLSQosExtDscpTrustIntfQosCtrl)
				.getValue();
	}

	public void setUtsMLSQosExtDscpTrustIntfQosCtrl(
			Integer aUtsMLSQosExtDscpTrustIntfQosCtrl)
	{
		getProperty(utsMLSQosExtDscpTrustIntfQosCtrl).setValue(
				aUtsMLSQosExtDscpTrustIntfQosCtrl);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsMLSQosExtDscpTrustModuleId));
		prepareRead(super.getProperty(utsMLSQosExtDscpTrustPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpTrustLagPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpTrustMode));
		prepareRead(super.getProperty(utsMLSQosExtDscpTrustIntfQosCtrl));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsMLSQosExtDscpTrustModuleId));
		prepareRead(super.getProperty(utsMLSQosExtDscpTrustPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpTrustLagPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpTrustMode));
		prepareRead(super.getProperty(utsMLSQosExtDscpTrustIntfQosCtrl));

    setRowsToFetch(24);
		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsMLSQosExtDscpTrustMode));
		prepareSave(getProperty(utsMLSQosExtDscpTrustIntfQosCtrl));

		return save();
	}

}
