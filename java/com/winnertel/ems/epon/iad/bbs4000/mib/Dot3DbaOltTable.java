package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3DbaOltTable class. Created by QuickDVM
 */
public class Dot3DbaOltTable extends SnmpMibBean
{
	public static final String ifIndex = "ifIndex";

	public static final String utsDot3DbaOltModuleId = "utsDot3DbaOltModuleId";

	public static final String utsDot3DbaOltPortId = "utsDot3DbaOltPortId";

	public static final String utsDot3DbaOltAlgorithm = "utsDot3DbaOltAlgorithm";

	public static final String utsDot3DbaOltDiscoverySize = "utsDot3DbaOltDiscoverySize";

	public static final String utsDot3DbaOltDiscoveryFreq = "utsDot3DbaOltDiscoveryFreq";

	public static final String utsDot3DbaOltCycleSize = "utsDot3DbaOltCycleSize";

//	public static final String utsDot3DbaOltPlatoCycleSize = "utsDot3DbaOltPlatoCycleSize";
//
//	public static final String utsDot3DbaOltPlatoDiscoveryFreq = "utsDot3DbaOltPlatoDiscoveryFreq";

	public Dot3DbaOltTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(ifIndex, new SnmpMibBeanProperty(ifIndex,
				".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));
		initProperty(utsDot3DbaOltModuleId,
				new SnmpMibBeanProperty(utsDot3DbaOltModuleId,
						".1.3.6.1.4.1.41355.1800.2.3.1.4.1.1.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3DbaOltPortId, new SnmpMibBeanProperty(
				utsDot3DbaOltPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.4.1.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3DbaOltAlgorithm,
				new SnmpMibBeanProperty(utsDot3DbaOltAlgorithm,
						".1.3.6.1.4.1.41355.1800.2.3.1.4.1.1.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3DbaOltDiscoverySize,
				new SnmpMibBeanProperty(utsDot3DbaOltDiscoverySize,
						".1.3.6.1.4.1.41355.1800.2.3.1.4.1.1.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3DbaOltDiscoveryFreq,
				new SnmpMibBeanProperty(utsDot3DbaOltDiscoveryFreq,
						".1.3.6.1.4.1.41355.1800.2.3.1.4.1.1.1.5",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3DbaOltCycleSize,
				new SnmpMibBeanProperty(utsDot3DbaOltCycleSize,
						".1.3.6.1.4.1.41355.1800.2.3.1.4.1.1.1.6",
						ISnmpConstant.INTEGER));
//		initProperty(utsDot3DbaOltPlatoCycleSize,
//				new SnmpMibBeanProperty(utsDot3DbaOltPlatoCycleSize,
//						".1.3.6.1.4.1.41355.1800.2.3.1.4.1.1.1.7",
//						ISnmpConstant.INTEGER));
//		initProperty(utsDot3DbaOltPlatoDiscoveryFreq,
//				new SnmpMibBeanProperty(utsDot3DbaOltPlatoDiscoveryFreq,
//						".1.3.6.1.4.1.41355.1800.2.3.1.4.1.1.1.8",
//						ISnmpConstant.INTEGER));

	}

	public Integer getIfIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setIfIndex(Integer aIfIndex)
	{
		setIndex(0, aIfIndex);
	}

	public Integer getUtsDot3DbaOltModuleId()
	{
		return (Integer) getProperty(utsDot3DbaOltModuleId).getValue();
	}

	public void setUtsDot3DbaOltModuleId(Integer aUtsDot3DbaOltModuleId)
	{
		getProperty(utsDot3DbaOltModuleId).setValue(aUtsDot3DbaOltModuleId);
	}

	public Integer getUtsDot3DbaOltPortId()
	{
		return (Integer) getProperty(utsDot3DbaOltPortId).getValue();
	}

	public void setUtsDot3DbaOltPortId(Integer aUtsDot3DbaOltPortId)
	{
		getProperty(utsDot3DbaOltPortId).setValue(aUtsDot3DbaOltPortId);
	}

	public Integer getUtsDot3DbaOltAlgorithm()
	{
		return (Integer) getProperty(utsDot3DbaOltAlgorithm).getValue();
	}

	public void setUtsDot3DbaOltAlgorithm(Integer aUtsDot3DbaOltAlgorithm)
	{
		getProperty(utsDot3DbaOltAlgorithm).setValue(aUtsDot3DbaOltAlgorithm);
	}

	public Integer getUtsDot3DbaOltDiscoverySize()
	{
		return (Integer) getProperty(utsDot3DbaOltDiscoverySize).getValue();
	}

	public void setUtsDot3DbaOltDiscoverySize(
			Integer aUtsDot3DbaOltDiscoverySize)
	{
		getProperty(utsDot3DbaOltDiscoverySize).setValue(
				aUtsDot3DbaOltDiscoverySize);
	}

	public Integer getUtsDot3DbaOltDiscoveryFreq()
	{
		return (Integer) getProperty(utsDot3DbaOltDiscoveryFreq).getValue();
	}

	public void setUtsDot3DbaOltDiscoveryFreq(
			Integer aUtsDot3DbaOltDiscoveryFreq)
	{
		getProperty(utsDot3DbaOltDiscoveryFreq).setValue(
				aUtsDot3DbaOltDiscoveryFreq);
	}

	public Integer getUtsDot3DbaOltCycleSize()
	{
		return (Integer) getProperty(utsDot3DbaOltCycleSize).getValue();
	}

	public void setUtsDot3DbaOltCycleSize(Integer aUtsDot3DbaOltCycleSize)
	{
		getProperty(utsDot3DbaOltCycleSize).setValue(aUtsDot3DbaOltCycleSize);
	}

//	public Integer getUtsDot3DbaOltPlatoCycleSize()
//	{
//		return (Integer) getProperty(utsDot3DbaOltPlatoCycleSize).getValue();
//	}
//
//	public void setUtsDot3DbaOltPlatoCycleSize(
//			Integer aUtsDot3DbaOltPlatoCycleSize)
//	{
//		getProperty(utsDot3DbaOltPlatoCycleSize).setValue(
//				aUtsDot3DbaOltPlatoCycleSize);
//	}
//
//	public Integer getUtsDot3DbaOltPlatoDiscoveryFreq()
//	{
//		return (Integer) getProperty(utsDot3DbaOltPlatoDiscoveryFreq)
//				.getValue();
//	}
//
//	public void setUtsDot3DbaOltPlatoDiscoveryFreq(
//			Integer aUtsDot3DbaOltPlatoDiscoveryFreq)
//	{
//		getProperty(utsDot3DbaOltPlatoDiscoveryFreq).setValue(
//				aUtsDot3DbaOltPlatoDiscoveryFreq);
//	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDot3DbaOltModuleId));
		prepareRead(super.getProperty(utsDot3DbaOltPortId));
		prepareRead(super.getProperty(utsDot3DbaOltAlgorithm));
		prepareRead(super.getProperty(utsDot3DbaOltDiscoverySize));
		prepareRead(super.getProperty(utsDot3DbaOltDiscoveryFreq));
		prepareRead(super.getProperty(utsDot3DbaOltCycleSize));
//		prepareRead(super.getProperty(utsDot3DbaOltPlatoCycleSize));
//		prepareRead(super.getProperty(utsDot3DbaOltPlatoDiscoveryFreq));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDot3DbaOltModuleId));
		prepareRead(super.getProperty(utsDot3DbaOltPortId));
		prepareRead(super.getProperty(utsDot3DbaOltAlgorithm));
		prepareRead(super.getProperty(utsDot3DbaOltDiscoverySize));
		prepareRead(super.getProperty(utsDot3DbaOltDiscoveryFreq));
		prepareRead(super.getProperty(utsDot3DbaOltCycleSize));
//		prepareRead(super.getProperty(utsDot3DbaOltPlatoCycleSize));
//		prepareRead(super.getProperty(utsDot3DbaOltPlatoDiscoveryFreq));

		setRowsToFetch(4);
		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsDot3DbaOltAlgorithm));
		prepareSave(getProperty(utsDot3DbaOltDiscoverySize));
		prepareSave(getProperty(utsDot3DbaOltDiscoveryFreq));
		prepareSave(getProperty(utsDot3DbaOltCycleSize));
//		prepareSave(getProperty(utsDot3DbaOltPlatoCycleSize));
//		prepareSave(getProperty(utsDot3DbaOltPlatoDiscoveryFreq));

		return save();
	}

}
