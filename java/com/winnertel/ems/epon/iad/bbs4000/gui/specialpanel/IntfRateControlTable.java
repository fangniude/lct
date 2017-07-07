package com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel;

import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-18
 * Time: 17:04:05
 * To change this template use File | Settings | File Templates.
 */
public class IntfRateControlTable  extends SnmpMibBean
{
  public static final String ifIndex = "ifIndex";

	public static final String utsIntfRateControlModuleId = "utsIntfRateControlModuleId";

	public static final String utsIntfRateControlPortId = "utsIntfRateControlPortId";

	public static final String utsIntfRateControlUplinkSpeed = "utsIntfRateControlUplinkSpeed";

	public IntfRateControlTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
        initProperty(ifIndex, new SnmpMibBeanProperty(ifIndex, ".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));

		initProperty(utsIntfRateControlModuleId,
				new SnmpMibBeanProperty(utsIntfRateControlModuleId,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.3.1.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsIntfRateControlPortId,
				new SnmpMibBeanProperty(utsIntfRateControlPortId,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.3.1.1.2",
						ISnmpConstant.INTEGER));
		initProperty(utsIntfRateControlUplinkSpeed, new SnmpMibBeanProperty(
				utsIntfRateControlUplinkSpeed,
				".1.3.6.1.4.1.41355.1800.2.2.1.5.3.1.1.13",
				ISnmpConstant.INTEGER));
	}
  public Integer getIfIndex() {
      return new Integer(ConfigUtility.generateIfIndex(getIndex(0)+"/"+getIndex(1)));
    }

    public void setIfIndex(Integer aIfIndex) {
      String index = ConfigUtility.formatIfIndex(aIfIndex.toString());
      setIndex(0, new Integer(index.substring(0, index.indexOf("/"))));
      setIndex(1, new Integer(index.substring(index.indexOf("/")+1, index.length())));
    }


	public Integer getUtsIntfRateControlModuleId()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsIntfRateControlModuleId(
			Integer aUtsIntfRateControlModuleId)
	{
		setIndex(0, aUtsIntfRateControlModuleId);
	}

	public Integer getUtsIntfRateControlPortId()
	{
		return (Integer) getIndex(1);
	}

	public void setUtsIntfRateControlPortId(Integer aUtsIntfRateControlPortId)
	{
		setIndex(1, aUtsIntfRateControlPortId);
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

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIntfRateControlUplinkSpeed));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIntfRateControlUplinkSpeed));

		return loadAll(new int[]{ 1, 1 });
	}

	public boolean modify() throws MibBeanException
	{
    prepareSave(getProperty(utsIntfRateControlUplinkSpeed));

		return save();
	}

}
