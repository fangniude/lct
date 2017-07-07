package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The QosExtDscpMutMapTable class. Created by QuickDVM
 */
public class QosExtDscpMutMapTable extends SnmpMibBean
{
	public static final String utsMLSQosExtDscpMutMapIntfIndex = "utsMLSQosExtDscpMutMapIntfIndex";

	public static final String utsMLSQosExtDscpMutMapModuleId = "utsMLSQosExtDscpMutMapModuleId";

	public static final String utsMLSQosExtDscpMutMapPortId = "utsMLSQosExtDscpMutMapPortId";

	public static final String utsMLSQosExtDscpMutMapLagPortId = "utsMLSQosExtDscpMutMapLagPortId";

	public static final String utsMLSQosExtDscpMutMapDscpVal = "utsMLSQosExtDscpMutMapDscpVal";

	public static final String utsMLSQosExtDscpMutMapMutVal = "utsMLSQosExtDscpMutMapMutVal";

	public QosExtDscpMutMapTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsMLSQosExtDscpMutMapIntfIndex, new SnmpMibBeanProperty(
				utsMLSQosExtDscpMutMapIntfIndex,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.4.1.1", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpMutMapModuleId, new SnmpMibBeanProperty(
				utsMLSQosExtDscpMutMapModuleId,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.4.1.2", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpMutMapPortId, new SnmpMibBeanProperty(
				utsMLSQosExtDscpMutMapPortId,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.4.1.3", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpMutMapLagPortId, new SnmpMibBeanProperty(
				utsMLSQosExtDscpMutMapLagPortId,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.4.1.4", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpMutMapDscpVal, new SnmpMibBeanProperty(
				utsMLSQosExtDscpMutMapDscpVal,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.4.1.5", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpMutMapMutVal, new SnmpMibBeanProperty(
				utsMLSQosExtDscpMutMapMutVal,
				".1.3.6.1.4.1.41355.1800.2.4.1.1.4.1.6", ISnmpConstant.INTEGER));

	}

	public Integer getUtsMLSQosExtDscpMutMapIntfIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsMLSQosExtDscpMutMapIntfIndex(
			Integer aUtsMLSQosExtDscpMutMapIntfIndex)
	{
		setIndex(0, aUtsMLSQosExtDscpMutMapIntfIndex);
	}

	public Integer getUtsMLSQosExtDscpMutMapDscpVal()
	{
		return (Integer) getIndex(1);
	}

	public void setUtsMLSQosExtDscpMutMapDscpVal(
			Integer aUtsMLSQosExtDscpMutMapDscpVal)
	{
		setIndex(1, aUtsMLSQosExtDscpMutMapDscpVal);
	}

	public Integer getUtsMLSQosExtDscpMutMapModuleId()
	{
		return (Integer) getProperty(utsMLSQosExtDscpMutMapModuleId).getValue();
	}

	public void setUtsMLSQosExtDscpMutMapModuleId(
			Integer aUtsMLSQosExtDscpMutMapModuleId)
	{
		getProperty(utsMLSQosExtDscpMutMapModuleId).setValue(
				aUtsMLSQosExtDscpMutMapModuleId);
	}

	public Integer getUtsMLSQosExtDscpMutMapPortId()
	{
		return (Integer) getProperty(utsMLSQosExtDscpMutMapPortId).getValue();
	}

	public void setUtsMLSQosExtDscpMutMapPortId(
			Integer aUtsMLSQosExtDscpMutMapPortId)
	{
		getProperty(utsMLSQosExtDscpMutMapPortId).setValue(
				aUtsMLSQosExtDscpMutMapPortId);
	}

	public Integer getUtsMLSQosExtDscpMutMapLagPortId()
	{
		return (Integer) getProperty(utsMLSQosExtDscpMutMapLagPortId)
				.getValue();
	}

	public void setUtsMLSQosExtDscpMutMapLagPortId(
			Integer aUtsMLSQosExtDscpMutMapLagPortId)
	{
		getProperty(utsMLSQosExtDscpMutMapLagPortId).setValue(
				aUtsMLSQosExtDscpMutMapLagPortId);
	}

	public Integer getUtsMLSQosExtDscpMutMapMutVal()
	{
		return (Integer) getProperty(utsMLSQosExtDscpMutMapMutVal).getValue();
	}

	public void setUtsMLSQosExtDscpMutMapMutVal(
			Integer aUtsMLSQosExtDscpMutMapMutVal)
	{
		getProperty(utsMLSQosExtDscpMutMapMutVal).setValue(
				aUtsMLSQosExtDscpMutMapMutVal);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsMLSQosExtDscpMutMapModuleId));
		prepareRead(super.getProperty(utsMLSQosExtDscpMutMapPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpMutMapLagPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpMutMapMutVal));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsMLSQosExtDscpMutMapModuleId));
		prepareRead(super.getProperty(utsMLSQosExtDscpMutMapPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpMutMapLagPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpMutMapMutVal));

		return loadAll(new int[] { 1, 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsMLSQosExtDscpMutMapMutVal));

		return save();
	}

    public boolean delete() throws MibBeanException{

    	Vector v = new QosExtDscpMutMapTable(fSnmpProxy).retrieveAll();

        if(v!=null){
            for(int i=0;i<v.size();i++){
                QosExtDscpMutMapTable tmpMutMapTbl = (QosExtDscpMutMapTable)v.get(i);
                int tmpMutPriority = tmpMutMapTbl.getUtsMLSQosExtDscpMutMapDscpVal().intValue();
                tmpMutMapTbl.setUtsMLSQosExtDscpMutMapMutVal( new Integer(tmpMutPriority) );
                tmpMutMapTbl.prepareSave(tmpMutMapTbl.getProperty(utsMLSQosExtDscpMutMapMutVal));
                tmpMutMapTbl.save();
            }
        }
        return true;
    }
}
