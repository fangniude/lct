package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The IgmpInterfaceTable class. Created by QuickDVM
 */
public class IgmpInterfaceTable extends SnmpMibBean
{
	public static final String utsIgmpIntfIfIndex = "utsIgmpIntfIfIndex";

	public static final String utsIgmpIntfVersion = "utsIgmpIntfVersion";

	public static final String utsIgmpIntfQuerier = "utsIgmpIntfQuerier";

	public static final String utsIgmpIntfGrpMembInterval = "utsIgmpIntfGrpMembInterval";

	public static final String utsIgmpIntfLastMembQueryIntvl = "utsIgmpIntfLastMembQueryIntvl";

	public static final String utsIgmpIntfQueryInterval = "utsIgmpIntfQueryInterval";

	public static final String utsIgmpIntfQueryMaxRespTime = "utsIgmpIntfQueryMaxRespTime";

	public static final String utsIgmpIntfRobustness = "utsIgmpIntfRobustness";

	public static final String utsIgmpIntfStartupQueryIntval = "utsIgmpIntfStartupQueryIntval";

	public static final String utsIgmpIntfUnsolictReportIntval = "utsIgmpIntfUnsolictReportIntval";

	public static final String utsIgmpIntfGroups = "utsIgmpIntfGroups";

	public static final String utsIgmpIntfProxyStatus = "utsIgmpIntfProxyStatus";

//    public static final String utsIgmpIntfStatus = "utsIgmpIntfStatus";

	public IgmpInterfaceTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsIgmpIntfIfIndex, new SnmpMibBeanProperty(
				utsIgmpIntfIfIndex, ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsIgmpIntfVersion, new SnmpMibBeanProperty(
				utsIgmpIntfVersion, ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsIgmpIntfQuerier, new SnmpMibBeanProperty(
				utsIgmpIntfQuerier, ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.3",
				ISnmpConstant.STRING));
		initProperty(utsIgmpIntfGrpMembInterval,
				new SnmpMibBeanProperty(utsIgmpIntfGrpMembInterval,
						".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsIgmpIntfLastMembQueryIntvl,
				new SnmpMibBeanProperty(utsIgmpIntfLastMembQueryIntvl,
						".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.5",
						ISnmpConstant.INTEGER));
		initProperty(utsIgmpIntfQueryInterval,
				new SnmpMibBeanProperty(utsIgmpIntfQueryInterval,
						".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.6",
						ISnmpConstant.INTEGER));
		initProperty(utsIgmpIntfQueryMaxRespTime,
				new SnmpMibBeanProperty(utsIgmpIntfQueryMaxRespTime,
						".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.7",
						ISnmpConstant.INTEGER));
		initProperty(utsIgmpIntfRobustness,
				new SnmpMibBeanProperty(utsIgmpIntfRobustness,
						".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.8",
						ISnmpConstant.INTEGER));
		initProperty(utsIgmpIntfStartupQueryIntval,
				new SnmpMibBeanProperty(utsIgmpIntfStartupQueryIntval,
						".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.9",
						ISnmpConstant.INTEGER));
		initProperty(utsIgmpIntfUnsolictReportIntval, new SnmpMibBeanProperty(
				utsIgmpIntfUnsolictReportIntval,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.10",
				ISnmpConstant.INTEGER));
		initProperty(utsIgmpIntfGroups, new SnmpMibBeanProperty(
				utsIgmpIntfGroups, ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.11",
				ISnmpConstant.INTEGER));
		initProperty(utsIgmpIntfProxyStatus, new SnmpMibBeanProperty(
				utsIgmpIntfProxyStatus,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.12",
				ISnmpConstant.INTEGER));
//		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
//				".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.13",
//				ISnmpConstant.INTEGER));
//        initProperty(utsIgmpIntfStatus,new SnmpMibBeanProperty(utsIgmpIntfStatus,
//                ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.1.1.13",ISnmpConstant.INTEGER));
	}

	public String getUtsIgmpIntfIfIndex()
	{
        Integer index = (Integer) getIndex(0);
		return ConfigUtility.formatIfIndex(index.toString());
	}

	public void setUtsIgmpIntfIfIndex(Integer aUtsIgmpIntfIfIndex)
	{
		setIndex(0, aUtsIgmpIntfIfIndex);
	}

	public Integer getUtsIgmpIntfVersion()
	{
		return (Integer) getProperty(utsIgmpIntfVersion).getValue();
	}

	public void setUtsIgmpIntfVersion(Integer aUtsIgmpIntfVersion)
	{
		getProperty(utsIgmpIntfVersion).setValue(aUtsIgmpIntfVersion);
	}

	public String getUtsIgmpIntfQuerier()
	{
		return (String) getProperty(utsIgmpIntfQuerier).getValue();
	}

	public void setUtsIgmpIntfQuerier(String aUtsIgmpIntfQuerier)
	{
		getProperty(utsIgmpIntfQuerier).setValue(aUtsIgmpIntfQuerier);
	}

	public Integer getUtsIgmpIntfGrpMembInterval()
	{
		return (Integer) getProperty(utsIgmpIntfGrpMembInterval).getValue();
	}

	public void setUtsIgmpIntfGrpMembInterval(
			Integer aUtsIgmpIntfGrpMembInterval)
	{
		getProperty(utsIgmpIntfGrpMembInterval).setValue(
				aUtsIgmpIntfGrpMembInterval);
	}

	public Integer getUtsIgmpIntfLastMembQueryIntvl()
	{
		return (Integer) getProperty(utsIgmpIntfLastMembQueryIntvl).getValue();
	}

	public void setUtsIgmpIntfLastMembQueryIntvl(
			Integer aUtsIgmpIntfLastMembQueryIntvl)
	{
		getProperty(utsIgmpIntfLastMembQueryIntvl).setValue(
				aUtsIgmpIntfLastMembQueryIntvl);
	}

	public Integer getUtsIgmpIntfQueryInterval()
	{
		return (Integer) getProperty(utsIgmpIntfQueryInterval).getValue();
	}

	public void setUtsIgmpIntfQueryInterval(Integer aUtsIgmpIntfQueryInterval)
	{
		getProperty(utsIgmpIntfQueryInterval).setValue(
				aUtsIgmpIntfQueryInterval);
	}

	public Integer getUtsIgmpIntfQueryMaxRespTime()
	{
		return (Integer) getProperty(utsIgmpIntfQueryMaxRespTime).getValue();
	}

	public void setUtsIgmpIntfQueryMaxRespTime(
			Integer aUtsIgmpIntfQueryMaxRespTime)
	{
		getProperty(utsIgmpIntfQueryMaxRespTime).setValue(
				aUtsIgmpIntfQueryMaxRespTime);
	}

	public Integer getUtsIgmpIntfRobustness()
	{
		return (Integer) getProperty(utsIgmpIntfRobustness).getValue();
	}

	public void setUtsIgmpIntfRobustness(Integer aUtsIgmpIntfRobustness)
	{
		getProperty(utsIgmpIntfRobustness).setValue(aUtsIgmpIntfRobustness);
	}

	public Integer getUtsIgmpIntfStartupQueryIntval()
	{
		return (Integer) getProperty(utsIgmpIntfStartupQueryIntval).getValue();
	}

	public void setUtsIgmpIntfStartupQueryIntval(
			Integer aUtsIgmpIntfStartupQueryIntval)
	{
		getProperty(utsIgmpIntfStartupQueryIntval).setValue(
				aUtsIgmpIntfStartupQueryIntval);
	}

	public Integer getUtsIgmpIntfUnsolictReportIntval()
	{
		return (Integer) getProperty(utsIgmpIntfUnsolictReportIntval)
				.getValue();
	}

	public void setUtsIgmpIntfUnsolictReportIntval(
			Integer aUtsIgmpIntfUnsolictReportIntval)
	{
		getProperty(utsIgmpIntfUnsolictReportIntval).setValue(
				aUtsIgmpIntfUnsolictReportIntval);
	}

	public Integer getUtsIgmpIntfGroups()
	{
		return (Integer) getProperty(utsIgmpIntfGroups).getValue();
	}

	public void setUtsIgmpIntfGroups(Integer aUtsIgmpIntfGroups)
	{
		getProperty(utsIgmpIntfGroups).setValue(aUtsIgmpIntfGroups);
	}

	public Integer getUtsIgmpIntfProxyStatus()
	{
		return (Integer) getProperty(utsIgmpIntfProxyStatus).getValue();
	}

	public void setUtsIgmpIntfProxyStatus(Integer aUtsIgmpIntfProxyStatus)
	{
		getProperty(utsIgmpIntfProxyStatus).setValue(aUtsIgmpIntfProxyStatus);
	}
//  public Integer getUtsIgmpIntfStatus()
//	{
//		return (Integer) getProperty(utsIgmpIntfStatus).getValue();
//	}
//
//	public void setUtsIgmpIntfStatus(Integer aUtsIgmpIntfStatus)
//	{
//		getProperty(utsIgmpIntfStatus).setValue(aUtsIgmpIntfStatus);
//	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIgmpIntfVersion));
		prepareRead(super.getProperty(utsIgmpIntfQuerier));
		prepareRead(super.getProperty(utsIgmpIntfGrpMembInterval));
		prepareRead(super.getProperty(utsIgmpIntfLastMembQueryIntvl));
		prepareRead(super.getProperty(utsIgmpIntfQueryInterval));
		prepareRead(super.getProperty(utsIgmpIntfQueryMaxRespTime));
		prepareRead(super.getProperty(utsIgmpIntfRobustness));
		prepareRead(super.getProperty(utsIgmpIntfStartupQueryIntval));
		prepareRead(super.getProperty(utsIgmpIntfUnsolictReportIntval));
		prepareRead(super.getProperty(utsIgmpIntfGroups));
		prepareRead(super.getProperty(utsIgmpIntfProxyStatus));
//        prepareRead(super.getProperty(utsIgmpIntfStatus));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIgmpIntfVersion));
		prepareRead(super.getProperty(utsIgmpIntfQuerier));
		prepareRead(super.getProperty(utsIgmpIntfGrpMembInterval));
		prepareRead(super.getProperty(utsIgmpIntfLastMembQueryIntvl));
		prepareRead(super.getProperty(utsIgmpIntfQueryInterval));
		prepareRead(super.getProperty(utsIgmpIntfQueryMaxRespTime));
		prepareRead(super.getProperty(utsIgmpIntfRobustness));
		prepareRead(super.getProperty(utsIgmpIntfStartupQueryIntval));
		prepareRead(super.getProperty(utsIgmpIntfUnsolictReportIntval));
		prepareRead(super.getProperty(utsIgmpIntfGroups));
		prepareRead(super.getProperty(utsIgmpIntfProxyStatus));
//        prepareRead(super.getProperty(utsIgmpIntfStatus));

		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsIgmpIntfVersion));
		prepareSave(getProperty(utsIgmpIntfLastMembQueryIntvl));
		prepareSave(getProperty(utsIgmpIntfQueryInterval));
		prepareSave(getProperty(utsIgmpIntfQueryMaxRespTime));
		prepareSave(getProperty(utsIgmpIntfRobustness));
		prepareSave(getProperty(utsIgmpIntfStartupQueryIntval));
		prepareSave(getProperty(utsIgmpIntfUnsolictReportIntval));
		prepareSave(getProperty(utsIgmpIntfProxyStatus));
//        prepareSave(getProperty(utsIgmpIntfStatus));

		return save();
	}

	public boolean add() throws MibBeanException
	{
		super.setRowStatus(new Integer(4));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public boolean delete() throws MibBeanException
	{
		super.setRowStatus(new Integer(6));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

}
