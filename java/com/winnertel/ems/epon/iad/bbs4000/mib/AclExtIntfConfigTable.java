package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The AclExtIntfConfigTable class. Created by QuickDVM
 */
public class AclExtIntfConfigTable extends SnmpMibBean
{
	public static final String utsAclExtIntfConfigIntfNum = "utsAclExtIntfConfigIntfNum";

	public static final String utsAclExtIntfConfigIntfModule = "utsAclExtIntfConfigIntfModule";

	public static final String utsAclExtIntfConfigIntfPort = "utsAclExtIntfConfigIntfPort";

	public static final String utsAclExtIntfConfigIntfLagGrpId = "utsAclExtIntfConfigIntfLagGrpId";

	public static final String utsAclExtIntfConfigIntfFilterType = "utsAclExtIntfConfigIntfFilterType";

	public static final String utsAclExtIntfConfigApplProfileId = "utsAclExtIntfConfigApplProfileId";

	public AclExtIntfConfigTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsAclExtIntfConfigIntfNum, new SnmpMibBeanProperty(
				utsAclExtIntfConfigIntfNum,
				".1.3.6.1.4.1.45121.1800.2.4.2.2.1.1", ISnmpConstant.INTEGER));
		initProperty(utsAclExtIntfConfigIntfModule, new SnmpMibBeanProperty(
				utsAclExtIntfConfigIntfModule,
				".1.3.6.1.4.1.45121.1800.2.4.2.2.1.2", ISnmpConstant.INTEGER));
		initProperty(utsAclExtIntfConfigIntfPort, new SnmpMibBeanProperty(
				utsAclExtIntfConfigIntfPort,
				".1.3.6.1.4.1.45121.1800.2.4.2.2.1.3", ISnmpConstant.INTEGER));
		initProperty(utsAclExtIntfConfigIntfLagGrpId, new SnmpMibBeanProperty(
				utsAclExtIntfConfigIntfLagGrpId,
				".1.3.6.1.4.1.45121.1800.2.4.2.2.1.4", ISnmpConstant.INTEGER));
		initProperty(utsAclExtIntfConfigIntfFilterType,
				new SnmpMibBeanProperty(utsAclExtIntfConfigIntfFilterType,
						".1.3.6.1.4.1.45121.1800.2.4.2.2.1.5",
						ISnmpConstant.INTEGER));
		initProperty(utsAclExtIntfConfigApplProfileId, new SnmpMibBeanProperty(
				utsAclExtIntfConfigApplProfileId,
				".1.3.6.1.4.1.45121.1800.2.4.2.2.1.6", ISnmpConstant.INTEGER));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.45121.1800.2.4.2.2.1.7", ISnmpConstant.INTEGER));

	}

	public String getUtsAclExtIntfConfigIntfNum()
	{
		int i = ( (Integer) getIndex(0)).intValue();
    if(i<49)
        return ""+ ((i-1)/4+1+"/"+((i%4==0)?4:(i%4)));
    else if(i == 5000)
        return "CPU Port";
    else{
        return "lg"+(i-48);
    }

  }

	public void setUtsAclExtIntfConfigIntfNum(
			Integer aUtsAclExtIntfConfigIntfNum)
	{
		setIndex(0, aUtsAclExtIntfConfigIntfNum);
	}

	public Integer getUtsAclExtIntfConfigIntfModule()
	{
		return (Integer) getProperty(utsAclExtIntfConfigIntfModule).getValue();
	}

	public void setUtsAclExtIntfConfigIntfModule(
			Integer aUtsAclExtIntfConfigIntfModule)
	{
		getProperty(utsAclExtIntfConfigIntfModule).setValue(
				aUtsAclExtIntfConfigIntfModule);
	}

	public Integer getUtsAclExtIntfConfigIntfPort()
	{
		return (Integer) getProperty(utsAclExtIntfConfigIntfPort).getValue();
	}

	public void setUtsAclExtIntfConfigIntfPort(
			Integer aUtsAclExtIntfConfigIntfPort)
	{
		getProperty(utsAclExtIntfConfigIntfPort).setValue(
				aUtsAclExtIntfConfigIntfPort);
	}

	public Integer getUtsAclExtIntfConfigIntfLagGrpId()
	{
		return (Integer) getProperty(utsAclExtIntfConfigIntfLagGrpId)
				.getValue();
	}

	public void setUtsAclExtIntfConfigIntfLagGrpId(
			Integer aUtsAclExtIntfConfigIntfLagGrpId)
	{
		getProperty(utsAclExtIntfConfigIntfLagGrpId).setValue(
				aUtsAclExtIntfConfigIntfLagGrpId);
	}

	public Integer getUtsAclExtIntfConfigIntfFilterType()
	{
		return (Integer) getProperty(utsAclExtIntfConfigIntfFilterType)
				.getValue();
	}

	public void setUtsAclExtIntfConfigIntfFilterType(
			Integer aUtsAclExtIntfConfigIntfFilterType)
	{
		getProperty(utsAclExtIntfConfigIntfFilterType).setValue(
				aUtsAclExtIntfConfigIntfFilterType);
	}

	public Integer getUtsAclExtIntfConfigApplProfileId()
	{
		return (Integer) getProperty(utsAclExtIntfConfigApplProfileId)
				.getValue();
	}

	public void setUtsAclExtIntfConfigApplProfileId(
			Integer aUtsAclExtIntfConfigApplProfileId)
	{
		getProperty(utsAclExtIntfConfigApplProfileId).setValue(
				aUtsAclExtIntfConfigApplProfileId);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsAclExtIntfConfigIntfModule));
		prepareRead(super.getProperty(utsAclExtIntfConfigIntfPort));
		prepareRead(super.getProperty(utsAclExtIntfConfigIntfLagGrpId));
		prepareRead(super.getProperty(utsAclExtIntfConfigIntfFilterType));
		prepareRead(super.getProperty(utsAclExtIntfConfigApplProfileId));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsAclExtIntfConfigIntfModule));
		prepareRead(super.getProperty(utsAclExtIntfConfigIntfPort));
		prepareRead(super.getProperty(utsAclExtIntfConfigIntfLagGrpId));
		prepareRead(super.getProperty(utsAclExtIntfConfigIntfFilterType));
		prepareRead(super.getProperty(utsAclExtIntfConfigApplProfileId));

		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsAclExtIntfConfigIntfNum));
		prepareSave(getProperty(utsAclExtIntfConfigApplProfileId));

		return save();
	}

	public boolean add() throws MibBeanException
	{
        prepareSave(getProperty(utsAclExtIntfConfigIntfNum));
		prepareSave(getProperty(utsAclExtIntfConfigApplProfileId));
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
