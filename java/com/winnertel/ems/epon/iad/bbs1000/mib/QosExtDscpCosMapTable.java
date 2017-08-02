package com.winnertel.ems.epon.iad.bbs1000.mib;

import java.util.Vector;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The QosExtDscpCosMapTable class. Created by QuickDVM
 */
public class QosExtDscpCosMapTable extends SnmpMibBean
{
	public static final String utsMLSQosExtDscpCosMapIntfIndex = "utsMLSQosExtDscpCosMapIntfIndex";

	public static final String utsMLSQosExtDscpCosMapModuleId = "utsMLSQosExtDscpCosMapModuleId";

	public static final String utsMLSQosExtDscpCosMapPortId = "utsMLSQosExtDscpCosMapPortId";

	public static final String utsMLSQosExtDscpCosMapLagPortId = "utsMLSQosExtDscpCosMapLagPortId";

	public static final String utsMLSQosExtDscpCosMapDscpVal = "utsMLSQosExtDscpCosMapDscpVal";

	public static final String utsMLSQosExtDscpCosMapCosVal = "utsMLSQosExtDscpCosMapCosVal";

	public QosExtDscpCosMapTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsMLSQosExtDscpCosMapIntfIndex, new SnmpMibBeanProperty(
				utsMLSQosExtDscpCosMapIntfIndex,
				".1.3.6.1.4.1.45121.1800.2.4.1.1.3.1.1", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpCosMapModuleId, new SnmpMibBeanProperty(
				utsMLSQosExtDscpCosMapModuleId,
				".1.3.6.1.4.1.45121.1800.2.4.1.1.3.1.2", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpCosMapPortId, new SnmpMibBeanProperty(
				utsMLSQosExtDscpCosMapPortId,
				".1.3.6.1.4.1.45121.1800.2.4.1.1.3.1.3", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpCosMapLagPortId, new SnmpMibBeanProperty(
				utsMLSQosExtDscpCosMapLagPortId,
				".1.3.6.1.4.1.45121.1800.2.4.1.1.3.1.4", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpCosMapDscpVal, new SnmpMibBeanProperty(
				utsMLSQosExtDscpCosMapDscpVal,
				".1.3.6.1.4.1.45121.1800.2.4.1.1.3.1.5", ISnmpConstant.INTEGER));
		initProperty(utsMLSQosExtDscpCosMapCosVal, new SnmpMibBeanProperty(
				utsMLSQosExtDscpCosMapCosVal,
				".1.3.6.1.4.1.45121.1800.2.4.1.1.3.1.6", ISnmpConstant.INTEGER));

	}

	public Integer getUtsMLSQosExtDscpCosMapIntfIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsMLSQosExtDscpCosMapIntfIndex(
			Integer aUtsMLSQosExtDscpCosMapIntfIndex)
	{
		setIndex(0, aUtsMLSQosExtDscpCosMapIntfIndex);
	}

	public Integer getUtsMLSQosExtDscpCosMapDscpVal()
	{
		return (Integer) getIndex(1);
	}

	public void setUtsMLSQosExtDscpCosMapDscpVal(
			Integer aUtsMLSQosExtDscpCosMapDscpVal)
	{
		setIndex(1, aUtsMLSQosExtDscpCosMapDscpVal);
	}

	public Integer getUtsMLSQosExtDscpCosMapModuleId()
	{
		return (Integer) getProperty(utsMLSQosExtDscpCosMapModuleId).getValue();
	}

	public void setUtsMLSQosExtDscpCosMapModuleId(
			Integer aUtsMLSQosExtDscpCosMapModuleId)
	{
		getProperty(utsMLSQosExtDscpCosMapModuleId).setValue(
				aUtsMLSQosExtDscpCosMapModuleId);
	}

	public Integer getUtsMLSQosExtDscpCosMapPortId()
	{
		return (Integer) getProperty(utsMLSQosExtDscpCosMapPortId).getValue();
	}

	public void setUtsMLSQosExtDscpCosMapPortId(
			Integer aUtsMLSQosExtDscpCosMapPortId)
	{
		getProperty(utsMLSQosExtDscpCosMapPortId).setValue(
				aUtsMLSQosExtDscpCosMapPortId);
	}

	public Integer getUtsMLSQosExtDscpCosMapLagPortId()
	{
		return (Integer) getProperty(utsMLSQosExtDscpCosMapLagPortId)
				.getValue();
	}

	public void setUtsMLSQosExtDscpCosMapLagPortId(
			Integer aUtsMLSQosExtDscpCosMapLagPortId)
	{
		getProperty(utsMLSQosExtDscpCosMapLagPortId).setValue(
				aUtsMLSQosExtDscpCosMapLagPortId);
	}

	public Integer getUtsMLSQosExtDscpCosMapCosVal()
	{
		return (Integer) getProperty(utsMLSQosExtDscpCosMapCosVal).getValue();
	}

	public void setUtsMLSQosExtDscpCosMapCosVal(
			Integer aUtsMLSQosExtDscpCosMapCosVal)
	{
		getProperty(utsMLSQosExtDscpCosMapCosVal).setValue(
				aUtsMLSQosExtDscpCosMapCosVal);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsMLSQosExtDscpCosMapModuleId));
		prepareRead(super.getProperty(utsMLSQosExtDscpCosMapPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpCosMapLagPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpCosMapCosVal));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsMLSQosExtDscpCosMapModuleId));
		prepareRead(super.getProperty(utsMLSQosExtDscpCosMapPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpCosMapLagPortId));
		prepareRead(super.getProperty(utsMLSQosExtDscpCosMapCosVal));

		return loadAll(new int[]
		{ 1, 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsMLSQosExtDscpCosMapCosVal));

		return save();
	}

    public boolean delete() throws MibBeanException{
        Vector v = new QosExtDscpCosMapTable(fSnmpProxy).retrieveAll();
        if(v!=null){
            for(int i=0;i<v.size();i++){
            	QosExtDscpCosMapTable tmpCosMapTbl = (QosExtDscpCosMapTable)v.get(i);
                int tmpCosMapPriority = tmpCosMapTbl.getUtsMLSQosExtDscpCosMapDscpVal().intValue();
                if ( tmpCosMapPriority >= 0 && tmpCosMapPriority <= 7) {
                	tmpCosMapTbl.setUtsMLSQosExtDscpCosMapCosVal( new Integer(0) );
                } else if ( tmpCosMapPriority >= 8 && tmpCosMapPriority <= 15) {
                	tmpCosMapTbl.setUtsMLSQosExtDscpCosMapCosVal( new Integer(1) );
                } else if ( tmpCosMapPriority >= 16 && tmpCosMapPriority <= 23) {
                	tmpCosMapTbl.setUtsMLSQosExtDscpCosMapCosVal( new Integer(2) );
                } else if ( tmpCosMapPriority >= 24 && tmpCosMapPriority <= 31) {
                	tmpCosMapTbl.setUtsMLSQosExtDscpCosMapCosVal( new Integer(3) );
                } else if ( tmpCosMapPriority >= 32 && tmpCosMapPriority <= 39) {
                	tmpCosMapTbl.setUtsMLSQosExtDscpCosMapCosVal( new Integer(4) );
                } else if ( tmpCosMapPriority >= 40 && tmpCosMapPriority <= 47) {
                	tmpCosMapTbl.setUtsMLSQosExtDscpCosMapCosVal( new Integer(5) );
                } else if ( tmpCosMapPriority >= 48 && tmpCosMapPriority <= 55) {
                	tmpCosMapTbl.setUtsMLSQosExtDscpCosMapCosVal( new Integer(6) );
                } else if ( tmpCosMapPriority >= 56 && tmpCosMapPriority <= 63) {
                	tmpCosMapTbl.setUtsMLSQosExtDscpCosMapCosVal( new Integer(7) );
                }

                tmpCosMapTbl.prepareSave(tmpCosMapTbl.getProperty(utsMLSQosExtDscpCosMapCosVal));
                tmpCosMapTbl.save();
            }
        }
        return true;
    }
}
