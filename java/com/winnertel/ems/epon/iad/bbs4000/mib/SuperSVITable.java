package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The SuperSVITable class. Created by QuickDVM
 */
public class SuperSVITable extends SnmpMibBean
{
	public static final String utsIntfSuperSVIVlanId = "utsIntfSuperSVIVlanId";

	public static final String utsIntfSuperSVIVlanMemberBitmap = "utsIntfSuperSVIVlanMemberBitmap";

	public SuperSVITable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsIntfSuperSVIVlanId, new SnmpMibBeanProperty(
				utsIntfSuperSVIVlanId, ".1.3.6.1.4.1.41355.1800.2.2.1.6.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsIntfSuperSVIVlanMemberBitmap, new SnmpMibBeanProperty(
				utsIntfSuperSVIVlanMemberBitmap,
				".1.3.6.1.4.1.41355.1800.2.2.1.6.1.1.2", ISnmpConstant.OCTETS));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.41355.1800.2.2.1.6.1.1.3", ISnmpConstant.INTEGER));

	}

	public Integer getUtsIntfSuperSVIVlanId()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsIntfSuperSVIVlanId(Integer aUtsIntfSuperSVIVlanId)
	{
		setIndex(0, aUtsIntfSuperSVIVlanId);
	}

	public byte[] getUtsIntfSuperSVIVlanMemberBitmap()
	{
		return (byte[])getProperty(utsIntfSuperSVIVlanMemberBitmap).getValue();
	}

	public void setUtsIntfSuperSVIVlanMemberBitmap(
			byte[] aUtsIntfSuperSVIVlanMemberBitmap)
	{
		getProperty(utsIntfSuperSVIVlanMemberBitmap).setValue(
				aUtsIntfSuperSVIVlanMemberBitmap);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIntfSuperSVIVlanMemberBitmap));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIntfSuperSVIVlanMemberBitmap));

		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsIntfSuperSVIVlanMemberBitmap));

		return save();
	}

	public boolean add() throws MibBeanException
	{
		prepareSave(getProperty(utsIntfSuperSVIVlanMemberBitmap));
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
