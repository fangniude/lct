package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The AclExtProfileImportTable class. Created by QuickDVM
 */
public class AclExtProfileImportTable extends SnmpMibBean
{
	public static final String utsAclExtProfileImportProfileId = "utsAclExtProfileImportProfileId";

	public static final String utsAclExtProfileImportFileName = "utsAclExtProfileImportFileName";

	public AclExtProfileImportTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsAclExtProfileImportProfileId, new SnmpMibBeanProperty(
				utsAclExtProfileImportProfileId,
				".1.3.6.1.4.1.41355.1800.2.4.2.3.1.1", ISnmpConstant.INTEGER));
		initProperty(utsAclExtProfileImportFileName, new SnmpMibBeanProperty(
				utsAclExtProfileImportFileName,
				".1.3.6.1.4.1.41355.1800.2.4.2.3.1.2", ISnmpConstant.STRING));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.41355.1800.2.4.2.3.1.3", ISnmpConstant.INTEGER));

	}

	public Integer getUtsAclExtProfileImportProfileId()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsAclExtProfileImportProfileId(
			Integer aUtsAclExtProfileImportProfileId)
	{
		setIndex(0, aUtsAclExtProfileImportProfileId);
        getProperty(utsAclExtProfileImportProfileId).setValue(
				aUtsAclExtProfileImportProfileId);
	}

	public String getUtsAclExtProfileImportFileName()
	{
		return (String) getProperty(utsAclExtProfileImportFileName).getValue();
	}

	public void setUtsAclExtProfileImportFileName(
			String aUtsAclExtProfileImportFileName)
	{
		getProperty(utsAclExtProfileImportFileName).setValue(
				aUtsAclExtProfileImportFileName);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsAclExtProfileImportFileName));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsAclExtProfileImportFileName));

		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsAclExtProfileImportProfileId));
		prepareSave(getProperty(utsAclExtProfileImportFileName));

		return save();
	}

	public boolean add() throws MibBeanException
	{
        prepareSave(getProperty(utsAclExtProfileImportProfileId));
		prepareSave(getProperty(utsAclExtProfileImportFileName));
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
