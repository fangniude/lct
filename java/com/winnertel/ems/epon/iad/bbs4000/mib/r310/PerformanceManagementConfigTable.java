package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import java.util.Vector;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class PerformanceManagementConfigTable extends SnmpMibBean {
	public static final String epPonIf2ExtManageStatId = "epPonIf2ExtManageStatId";
	
	public static final String epPonIf2ExtManageStatStartTime = "epPonIf2ExtManageStatStartTime";

	public static final String epPonIf2ExtManageStatMeasureCyc = "epPonIf2ExtManageStatMeasureCyc";

	public static final String epPonIf2ExtManageStatTaskState = "epPonIf2ExtManageStatTaskState";
	
	public static final String epPonIf2ExtManageStatMO = "epPonIf2ExtManageStatMO";

	public PerformanceManagementConfigTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(epPonIf2ExtManageStatId, new SnmpMibBeanProperty(
				epPonIf2ExtManageStatId,
				".1.3.6.1.4.1.41355.1800.4.2.1.1.9.1",
				ISnmpConstant.OCTETS
				));
		initProperty(epPonIf2ExtManageStatStartTime, new SnmpMibBeanProperty(
				epPonIf2ExtManageStatStartTime,
				".1.3.6.1.4.1.41355.1800.4.2.1.1.9.2",
				ISnmpConstant.OCTETS
				));
		initProperty(epPonIf2ExtManageStatMeasureCyc, new SnmpMibBeanProperty(
				epPonIf2ExtManageStatMeasureCyc,
				".1.3.6.1.4.1.41355.1800.4.2.1.1.9.3",
				ISnmpConstant.INTEGER));
		initProperty(epPonIf2ExtManageStatTaskState, new SnmpMibBeanProperty(
				epPonIf2ExtManageStatTaskState,
				".1.3.6.1.4.1.41355.1800.4.2.1.1.9.4",
				ISnmpConstant.INTEGER));
		initProperty(epPonIf2ExtManageStatMO, new SnmpMibBeanProperty(
				epPonIf2ExtManageStatMO,
				".1.3.6.1.4.1.41355.1800.4.2.1.1.9.5",
				ISnmpConstant.INTEGER));
	}

	public Integer getEpPonIf2ExtManageStatId() {
		return (Integer) getIndex(0);
	}

	public void setEpPonIf2ExtManageStatId(Integer aEpPonIf2ExtManageStatId) {
		setIndex(0, aEpPonIf2ExtManageStatId);
	}
	
	public byte[] getEpPonIf2ExtManageStatStartTime() {
		return (byte[]) getProperty(epPonIf2ExtManageStatStartTime).getValue();
	}

	public void setEpPonIf2ExtManageStatStartTime(byte[] aEpPonIf2ExtManageStatStartTime) {
		getProperty(epPonIf2ExtManageStatStartTime).setValue(aEpPonIf2ExtManageStatStartTime);
	}

	public Integer getEpPonIf2ExtManageStatMeasureCyc() {
		return (Integer) getProperty(epPonIf2ExtManageStatMeasureCyc).getValue();
	}

	public void setEpPonIf2ExtManageStatMeasureCyc(Integer aEpPonIf2ExtManageStatMeasureCyc) {
		getProperty(epPonIf2ExtManageStatMeasureCyc).setValue(aEpPonIf2ExtManageStatMeasureCyc);
	}

	public Integer getEpPonIf2ExtManageStatTaskState() {
		return (Integer) getProperty(epPonIf2ExtManageStatTaskState).getValue();
	}

	public void setEpPonIf2ExtManageStatTaskState(
			Integer aEpPonIf2ExtManageStatTaskState) {
		getProperty(epPonIf2ExtManageStatTaskState).setValue(
				aEpPonIf2ExtManageStatTaskState);
	}
	
	public Integer getEpPonIf2ExtManageStatMO() {
		return (Integer) getProperty(epPonIf2ExtManageStatMO).getValue();
	}

	public void setEpPonIf2ExtManageStatMO(
			Integer aEpPonIf2ExtManageStatMO) {
		getProperty(epPonIf2ExtManageStatMO).setValue(
				aEpPonIf2ExtManageStatMO);
	}

	
	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(epPonIf2ExtManageStatStartTime));
		prepareRead(super.getProperty(epPonIf2ExtManageStatMeasureCyc));
		prepareRead(super.getProperty(epPonIf2ExtManageStatTaskState));
		prepareRead(super.getProperty(epPonIf2ExtManageStatMO));

		return load();
	}
	
	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(epPonIf2ExtManageStatStartTime));
		prepareRead(super.getProperty(epPonIf2ExtManageStatMeasureCyc));
		prepareRead(super.getProperty(epPonIf2ExtManageStatTaskState));
		prepareRead(super.getProperty(epPonIf2ExtManageStatMO));

        return loadAll(new int[]{1});
    }

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(epPonIf2ExtManageStatStartTime));
		prepareSave(getProperty(epPonIf2ExtManageStatMeasureCyc));
		prepareSave(getProperty(epPonIf2ExtManageStatTaskState));
		prepareSave(getProperty(epPonIf2ExtManageStatMO));

		return save();
	}

}
