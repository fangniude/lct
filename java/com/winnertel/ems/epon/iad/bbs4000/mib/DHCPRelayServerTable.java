package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The DHCPRelayServerTable class. Created by QuickDVM
 */
public class DHCPRelayServerTable extends SnmpMibBean
{
	public static final String utsDHCPRelayIfIndex = "utsDHCPRelayIfIndex";

	public static final String utsDHCPRelayServerID = "utsDHCPRelayServerID";

	public static final String utsDHCPRelayGateway = "utsDHCPRelayGateway";

	public static final String utsDHCPRelaySecondServer = "utsDHCPRelaySecondServer";

	public DHCPRelayServerTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsDHCPRelayIfIndex, new SnmpMibBeanProperty(
				utsDHCPRelayIfIndex, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.12.1.1",ISnmpConstant.INTEGER));
		initProperty(utsDHCPRelayServerID,
				new SnmpMibBeanProperty(utsDHCPRelayServerID,".1.3.6.1.4.1.45121.1800.2.2.1.6.3.12.1.2",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDHCPRelayGateway, new SnmpMibBeanProperty(
				utsDHCPRelayGateway, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.12.1.3",
				ISnmpConstant.IP_ADDRESS));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.3.12.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDHCPRelaySecondServer,
				new SnmpMibBeanProperty(utsDHCPRelaySecondServer,
						".1.3.6.1.4.1.45121.1800.2.2.1.6.3.12.1.5",
						ISnmpConstant.IP_ADDRESS));

	}

	public Integer getUtsDHCPRelayIfIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsDHCPRelayIfIndex(Integer aUtsDHCPRelayIfIndex)
	{
		setIndex(0, aUtsDHCPRelayIfIndex);
	}

	public String getUtsDHCPRelayServerID()
	{
		return (String) getProperty(utsDHCPRelayServerID).getValue();
	}

	public void setUtsDHCPRelayServerID(String aUtsDHCPRelayServerID)
	{
		getProperty(utsDHCPRelayServerID).setValue(aUtsDHCPRelayServerID);
	}

	public String getUtsDHCPRelayGateway()
	{
		return (String) getProperty(utsDHCPRelayGateway).getValue();
	}

	public void setUtsDHCPRelayGateway(String aUtsDHCPRelayGateway)
	{
		getProperty(utsDHCPRelayGateway).setValue(aUtsDHCPRelayGateway);
	}

	public String getUtsDHCPRelaySecondServer()
	{
		return (String) getProperty(utsDHCPRelaySecondServer).getValue();
	}

	public void setUtsDHCPRelaySecondServer(String aUtsDHCPRelaySecondServer)
	{
		getProperty(utsDHCPRelaySecondServer).setValue(
				aUtsDHCPRelaySecondServer);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDHCPRelayServerID));
		prepareRead(super.getProperty(utsDHCPRelayGateway));

		prepareRead(super.getProperty(utsDHCPRelaySecondServer));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDHCPRelayServerID));
		prepareRead(super.getProperty(utsDHCPRelayGateway));

		prepareRead(super.getProperty(utsDHCPRelaySecondServer));

		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsDHCPRelayIfIndex));
		prepareSave(getProperty(utsDHCPRelayServerID));
		prepareSave(getProperty(utsDHCPRelayGateway));

		prepareSave(getProperty(utsDHCPRelaySecondServer));

		return save();
	}

	public boolean add() throws MibBeanException
	{
 	      		prepareSave(getProperty(utsDHCPRelayIfIndex));
		prepareSave(getProperty(utsDHCPRelayServerID));
		prepareSave(getProperty(utsDHCPRelayGateway));

		prepareSave(getProperty(utsDHCPRelaySecondServer));
		super.setRowStatus(new Integer(4));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public boolean delete() throws MibBeanException
	{
        String ssever = this.getUtsDHCPRelaySecondServer();
        this.setUtsDHCPRelayServerID(getProperty(utsDHCPRelayServerID).getValue().toString());
        prepareSave(getProperty(utsDHCPRelayServerID));
        this.setUtsDHCPRelayGateway(getProperty(utsDHCPRelayGateway).getValue().toString());
        prepareSave(getProperty(utsDHCPRelayGateway));

       	super.setRowStatus(new Integer(6));
		prepareSave(getProperty(ROW_STATUS));
        this.setUtsDHCPRelayIfIndex(new Integer(getIndex(0).toString()));
		prepareSave(getProperty(utsDHCPRelayIfIndex));
        if(!ssever.equals("0.0.0.0")){
            this.setUtsDHCPRelaySecondServer(getProperty(utsDHCPRelaySecondServer).getValue().toString());
            prepareSave(getProperty(utsDHCPRelaySecondServer));
        }
        return save();
	}

}
