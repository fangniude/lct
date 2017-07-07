package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The IgmpSnoopCfgTable class. Created by QuickDVM
 */
public class IgmpSnoopCfgTable extends SnmpMibBean
{
	public static final String utsIgmpSnoopVlanId = "utsIgmpSnoopVlanId";

	public static final String utsIgmpSnoopLastMembAgeTmr = "utsIgmpSnoopLastMembAgeTmr";

	public static final String utsIgmpSnoopMCAgeTmr = "utsIgmpSnoopMCAgeTmr";

	public static final String utsIgmpSnoopRouterAgeTmr = "utsIgmpSnoopRouterAgeTmr";

	public static final String utsIgmpSnoopSrcOnlyMcAgeTmr = "utsIgmpSnoopSrcOnlyMcAgeTmr";

	public IgmpSnoopCfgTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsIgmpSnoopVlanId, new SnmpMibBeanProperty(
				utsIgmpSnoopVlanId, ".1.3.6.1.4.1.41355.1800.2.2.1.5.5.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsIgmpSnoopLastMembAgeTmr,
				new SnmpMibBeanProperty(utsIgmpSnoopLastMembAgeTmr,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.5.1.1.2",
						ISnmpConstant.INTEGER));
		initProperty(utsIgmpSnoopMCAgeTmr, new SnmpMibBeanProperty(
				utsIgmpSnoopMCAgeTmr, ".1.3.6.1.4.1.41355.1800.2.2.1.5.5.1.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsIgmpSnoopRouterAgeTmr,
				new SnmpMibBeanProperty(utsIgmpSnoopRouterAgeTmr,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.5.1.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsIgmpSnoopSrcOnlyMcAgeTmr,
				new SnmpMibBeanProperty(utsIgmpSnoopSrcOnlyMcAgeTmr,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.5.1.1.5",
						ISnmpConstant.INTEGER));

	}

	public Integer getUtsIgmpSnoopVlanId()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsIgmpSnoopVlanId(Integer aUtsIgmpSnoopVlanId)
	{
		setIndex(0, aUtsIgmpSnoopVlanId);
	}

	public Integer getUtsIgmpSnoopLastMembAgeTmr()
	{
		return (Integer) getProperty(utsIgmpSnoopLastMembAgeTmr).getValue();
	}

	public void setUtsIgmpSnoopLastMembAgeTmr(
			Integer aUtsIgmpSnoopLastMembAgeTmr)
	{
		getProperty(utsIgmpSnoopLastMembAgeTmr).setValue(
				aUtsIgmpSnoopLastMembAgeTmr);
	}

	public Integer getUtsIgmpSnoopMCAgeTmr()
	{
		return (Integer) getProperty(utsIgmpSnoopMCAgeTmr).getValue();
	}

	public void setUtsIgmpSnoopMCAgeTmr(Integer aUtsIgmpSnoopMCAgeTmr)
	{
		getProperty(utsIgmpSnoopMCAgeTmr).setValue(aUtsIgmpSnoopMCAgeTmr);
	}

	public Integer getUtsIgmpSnoopRouterAgeTmr()
	{
		return (Integer) getProperty(utsIgmpSnoopRouterAgeTmr).getValue();
	}

	public void setUtsIgmpSnoopRouterAgeTmr(Integer aUtsIgmpSnoopRouterAgeTmr)
	{
		getProperty(utsIgmpSnoopRouterAgeTmr).setValue(
				aUtsIgmpSnoopRouterAgeTmr);
	}

	public Integer getUtsIgmpSnoopSrcOnlyMcAgeTmr()
	{
		return (Integer) getProperty(utsIgmpSnoopSrcOnlyMcAgeTmr).getValue();
	}

	public void setUtsIgmpSnoopSrcOnlyMcAgeTmr(
			Integer aUtsIgmpSnoopSrcOnlyMcAgeTmr)
	{
		getProperty(utsIgmpSnoopSrcOnlyMcAgeTmr).setValue(
				aUtsIgmpSnoopSrcOnlyMcAgeTmr);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIgmpSnoopLastMembAgeTmr));
		prepareRead(super.getProperty(utsIgmpSnoopMCAgeTmr));
		prepareRead(super.getProperty(utsIgmpSnoopRouterAgeTmr));
		prepareRead(super.getProperty(utsIgmpSnoopSrcOnlyMcAgeTmr));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIgmpSnoopLastMembAgeTmr));
		prepareRead(super.getProperty(utsIgmpSnoopMCAgeTmr));
		prepareRead(super.getProperty(utsIgmpSnoopRouterAgeTmr));
		prepareRead(super.getProperty(utsIgmpSnoopSrcOnlyMcAgeTmr));

		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsIgmpSnoopLastMembAgeTmr));
		prepareSave(getProperty(utsIgmpSnoopMCAgeTmr));
		prepareSave(getProperty(utsIgmpSnoopRouterAgeTmr));
		prepareSave(getProperty(utsIgmpSnoopSrcOnlyMcAgeTmr));

		return save();
	}

}
