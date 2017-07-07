package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3OltOpmThreshold extends SnmpMibBean {

	public static final String utsDot3OltOpmVoltageMinAlarmThreshold = "utsDot3OltOpmVoltageMinAlarmThreshold";
	public static final String utsDot3OltOpmVoltageMaxAlarmThreshold = "utsDot3OltOpmVoltageMaxAlarmThreshold";
	public static final String utsDot3OltOpmBiasCurrentMinAlarmThreshold = "utsDot3OltOpmBiasCurrentMinAlarmThreshold";
	public static final String utsDot3OltOpmBiasCurrentMaxAlarmThreshold = "utsDot3OltOpmBiasCurrentMaxAlarmThreshold";
	public static final String utsDot3OltOpmTemperatureMinAlarmThreshold = "utsDot3OltOpmTemperatureMinAlarmThreshold";
	public static final String utsDot3OltOpmTemperatureMaxAlarmThreshold = "utsDot3OltOpmTemperatureMaxAlarmThreshold";
	public static final String utsDot3OltOpmTxPowerMinAlarmThreshold = "utsDot3OltOpmTxPowerMinAlarmThreshold";
	public static final String utsDot3OltOpmTxPowerMaxAlarmThreshold = "utsDot3OltOpmTxPowerMaxAlarmThreshold";
	public static final String utsDot3OltOpmVoltageMinWarningThreshold = "utsDot3OltOpmVoltageMinWarningThreshold";
	public static final String utsDot3OltOpmVoltageMaxWarningThreshold = "utsDot3OltOpmVoltageMaxWarningThreshold";
	public static final String utsDot3OltOpmBiasCurrentMinWarningThreshold = "utsDot3OltOpmBiasCurrentMinWarningThreshold";
	public static final String utsDot3OltOpmBiasCurrentMaxWarningThreshold = "utsDot3OltOpmBiasCurrentMaxWarningThreshold";
	public static final String utsDot3OltOpmTemperatureMinWarningThreshold = "utsDot3OltOpmTemperatureMinWarningThreshold";
	public static final String utsDot3OltOpmTemperatureMaxWarningThreshold = "utsDot3OltOpmTemperatureMaxWarningThreshold";
	public static final String utsDot3OltOpmTxPowerMinWarningThreshold = "utsDot3OltOpmTxPowerMinWarningThreshold";
	public static final String utsDot3OltOpmTxPowerMaxWarningThreshold = "utsDot3OltOpmTxPowerMaxWarningThreshold";
	public static final String utsDot3OltOpmOnuRxPowerMinAlarmThreshold = "utsDot3OltOpmOnuRxPowerMinAlarmThreshold";
	public static final String utsDot3OltOpmOnuRxPowerMaxAlarmThreshold = "utsDot3OltOpmOnuRxPowerMaxAlarmThreshold";
	public static final String utsDot3OltOpmOnuRxPowerMinWarningThreshold = "utsDot3OltOpmOnuRxPowerMinWarningThreshold";
	public static final String utsDot3OltOpmOnuRxPowerMaxWarningThreshold = "utsDot3OltOpmOnuRxPowerMaxWarningThreshold";

	public Dot3OltOpmThreshold(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OltOpmVoltageMinAlarmThreshold,
				new SnmpMibBeanProperty(utsDot3OltOpmVoltageMinAlarmThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.1",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmVoltageMaxAlarmThreshold,
				new SnmpMibBeanProperty(utsDot3OltOpmVoltageMaxAlarmThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.2",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmBiasCurrentMinAlarmThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmBiasCurrentMinAlarmThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmBiasCurrentMaxAlarmThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmBiasCurrentMaxAlarmThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.4",
						ISnmpConstant.INTEGER));

		initProperty(utsDot3OltOpmTemperatureMinAlarmThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmTemperatureMinAlarmThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.5",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmTemperatureMaxAlarmThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmTemperatureMaxAlarmThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.6",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmTxPowerMinAlarmThreshold,
				new SnmpMibBeanProperty(utsDot3OltOpmTxPowerMinAlarmThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.7",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmTxPowerMaxAlarmThreshold,
				new SnmpMibBeanProperty(utsDot3OltOpmTxPowerMaxAlarmThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.8",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmVoltageMinWarningThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmVoltageMinWarningThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.9",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmVoltageMaxWarningThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmVoltageMaxWarningThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.10",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmBiasCurrentMinWarningThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmBiasCurrentMinWarningThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.11",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmBiasCurrentMaxWarningThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmBiasCurrentMaxWarningThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.12",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmTemperatureMinWarningThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmTemperatureMinWarningThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.13",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmTemperatureMaxWarningThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmTemperatureMaxWarningThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.14",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmTxPowerMinWarningThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmTxPowerMinWarningThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.15",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmTxPowerMaxWarningThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmTxPowerMaxWarningThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.16",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOnuRxPowerMinAlarmThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmOnuRxPowerMinAlarmThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.17",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOnuRxPowerMaxAlarmThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmOnuRxPowerMaxAlarmThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.18",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOnuRxPowerMinWarningThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmOnuRxPowerMinWarningThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.19",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOnuRxPowerMaxWarningThreshold,
				new SnmpMibBeanProperty(
						utsDot3OltOpmOnuRxPowerMaxWarningThreshold,
						".1.3.6.1.4.1.41355.1800.2.1.1.4.10.20",
						ISnmpConstant.INTEGER));
	}

	public Integer getUtsDot3OltOpmVoltageMinAlarmThreshold() {
//		return (Integer) getProperty(utsDot3OltOpmVoltageMinAlarmThreshold)
//				.getValue() / 10;
		int value = (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmVoltageMinAlarmThreshold).getValue()/ 10.0));
		if(value>6550 && value <= 6554) return 6550;
		return value;
	}

	public void setUtsDot3OltOpmVoltageMinAlarmThreshold(
			Integer aUtsDot3OltOpmVoltageMinAlarmThreshold) {
		getProperty(utsDot3OltOpmVoltageMinAlarmThreshold).setValue(
				aUtsDot3OltOpmVoltageMinAlarmThreshold * 10);
	}

	public Integer getUtsDot3OltOpmVoltageMaxAlarmThreshold() {
//		return (Integer) getProperty(utsDot3OltOpmVoltageMaxAlarmThreshold)
//				.getValue() / 10;
		int value = (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmVoltageMaxAlarmThreshold).getValue()/ 10.0));
		if(value>6550 && value <= 6554) return 6550;
		return value;
	}

	public void setUtsDot3OltOpmVoltageMaxAlarmThreshold(
			Integer aUtsDot3OltOpmVoltageMaxAlarmThreshold) {
		getProperty(utsDot3OltOpmVoltageMaxAlarmThreshold).setValue(
				aUtsDot3OltOpmVoltageMaxAlarmThreshold * 10);
	}

	public Integer getUtsDot3OltOpmBiasCurrentMinAlarmThreshold() {
//		return (Integer) getProperty(utsDot3OltOpmBiasCurrentMinAlarmThreshold)
//				.getValue() / 500;
		
		return (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmBiasCurrentMinAlarmThreshold).getValue()/ 500.0));
	}

	public void setUtsDot3OltOpmBiasCurrentMinAlarmThreshold(
			Integer aUtsDot3OltOpmBiasCurrentMinAlarmThreshold) {
		getProperty(utsDot3OltOpmBiasCurrentMinAlarmThreshold).setValue(
				aUtsDot3OltOpmBiasCurrentMinAlarmThreshold * 500);
	}

	public Integer getUtsDot3OltOpmBiasCurrentMaxAlarmThreshold() {
//		return (Integer) getProperty(utsDot3OltOpmBiasCurrentMaxAlarmThreshold)
//				.getValue() / 500;
		return (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmBiasCurrentMaxAlarmThreshold).getValue()/ 500.0));
	}

	public void setUtsDot3OltOpmBiasCurrentMaxAlarmThreshold(
			Integer aUtsDot3OltOpmBiasCurrentMaxAlarmThreshold) {
		getProperty(utsDot3OltOpmBiasCurrentMaxAlarmThreshold).setValue(
				aUtsDot3OltOpmBiasCurrentMaxAlarmThreshold * 500);
	}

	public Integer getUtsDot3OltOpmTemperatureMinAlarmThreshold() {
//		return (Integer) getProperty(utsDot3OltOpmTemperatureMinAlarmThreshold)
//				.getValue() / 256;
		return (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmTemperatureMinAlarmThreshold).getValue()/ 256.0));
	}

	public void setUtsDot3OltOpmTemperatureMinAlarmThreshold(
			Integer aUtsDot3OltOpmTemperatureMinAlarmThreshold) {
		getProperty(utsDot3OltOpmTemperatureMinAlarmThreshold).setValue(
				aUtsDot3OltOpmTemperatureMinAlarmThreshold * 256);
	}

	public Integer getUtsDot3OltOpmTemperatureMaxAlarmThreshold() {
//		return (Integer) getProperty(utsDot3OltOpmTemperatureMaxAlarmThreshold)
//				.getValue() / 256;
		return (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmTemperatureMaxAlarmThreshold).getValue()/ 256.0));
	}

	public void setUtsDot3OltOpmTemperatureMaxAlarmThreshold(
			Integer aUtsDot3OltOpmTemperatureMaxAlarmThreshold) {
		getProperty(utsDot3OltOpmTemperatureMaxAlarmThreshold).setValue(
				aUtsDot3OltOpmTemperatureMaxAlarmThreshold * 256);
	}

	public Double getUtsDot3OltOpmTxPowerMinAlarmThreshold() {
		if ((Integer) getProperty(utsDot3OltOpmTxPowerMinAlarmThreshold)
				.getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsDot3OltOpmTxPowerMinAlarmThreshold).getValue() / 10000.0);
		if(d>8.1 && d <=8.2) return 8.1;
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setUtsDot3OltOpmTxPowerMinAlarmThreshold(
			Double aUtsDot3OltOpmTxPowerMinAlarmThreshold) {
		getProperty(utsDot3OltOpmTxPowerMinAlarmThreshold)
				.setValue(
						(int) java.lang.Math
								.round(java.lang.Math
										.pow(
												10,
												aUtsDot3OltOpmTxPowerMinAlarmThreshold / 10.0) * 10000));
	}

	public Double getUtsDot3OltOpmTxPowerMaxAlarmThreshold() {
		if ((Integer) getProperty(utsDot3OltOpmTxPowerMaxAlarmThreshold)
				.getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsDot3OltOpmTxPowerMaxAlarmThreshold).getValue() / 10000.0);
		if(d>8.1 && d <=8.2) return 8.1;
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setUtsDot3OltOpmTxPowerMaxAlarmThreshold(
			Double aUtsDot3OltOpmTxPowerMaxAlarmThreshold) {
		getProperty(utsDot3OltOpmTxPowerMaxAlarmThreshold)
				.setValue(
						(int) java.lang.Math
								.round(java.lang.Math
										.pow(
												10,
												aUtsDot3OltOpmTxPowerMaxAlarmThreshold / 10.0) * 10000));
	}

	public Integer getUtsDot3OltOpmVoltageMinWarningThreshold() {
//		return (Integer) getProperty(utsDot3OltOpmVoltageMinWarningThreshold)
//				.getValue() / 10;
		int value = (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmVoltageMinWarningThreshold).getValue()/ 10.0));
		if(value>6550 && value <= 6554) return 6550;
		return value;
	}

	public void setUtsDot3OltOpmVoltageMinWarningThreshold(
			Integer aUtsDot3OltOpmVoltageMinWarningThreshold) {
		getProperty(utsDot3OltOpmVoltageMinWarningThreshold).setValue(
				aUtsDot3OltOpmVoltageMinWarningThreshold * 10);
	}

	public Integer getUtsDot3OltOpmVoltageMaxWarningThreshold() {
//		return (Integer) getProperty(utsDot3OltOpmVoltageMaxWarningThreshold)
//				.getValue() / 10;
		int value = (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmVoltageMaxWarningThreshold).getValue()/ 10.0));
		if(value>6550 && value <= 6554) return 6550;
		return value;
	}

	public void setUtsDot3OltOpmVoltageMaxWarningThreshold(
			Integer aUtsDot3OltOpmVoltageMaxWarningThreshold) {
		getProperty(utsDot3OltOpmVoltageMaxWarningThreshold).setValue(
				aUtsDot3OltOpmVoltageMaxWarningThreshold * 10);
	}

	public Integer getUtsDot3OltOpmBiasCurrentMinWarningThreshold() {
//		return (Integer) getProperty(
//				utsDot3OltOpmBiasCurrentMinWarningThreshold).getValue() / 500;
		return (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmBiasCurrentMinWarningThreshold).getValue()/ 500.0));
	}

	public void setUtsDot3OltOpmBiasCurrentMinWarningThreshold(
			Integer aUtsDot3OltOpmBiasCurrentMinWarningThreshold) {
		getProperty(utsDot3OltOpmBiasCurrentMinWarningThreshold).setValue(
				aUtsDot3OltOpmBiasCurrentMinWarningThreshold * 500);
	}

	public Integer getUtsDot3OltOpmBiasCurrentMaxWarningThreshold() {
//		return (Integer) getProperty(
//				utsDot3OltOpmBiasCurrentMaxWarningThreshold).getValue() / 500;
		return (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmBiasCurrentMaxWarningThreshold).getValue()/ 500.0));
	}

	public void setUtsDot3OltOpmBiasCurrentMaxWarningThreshold(
			Integer aUtsDot3OltOpmBiasCurrentMaxWarningThreshold) {
		getProperty(utsDot3OltOpmBiasCurrentMaxWarningThreshold).setValue(
				aUtsDot3OltOpmBiasCurrentMaxWarningThreshold * 500);
	}

	public Integer getUtsDot3OltOpmTemperatureMinWarningThreshold() {
//		return (Integer) getProperty(
//				utsDot3OltOpmTemperatureMinWarningThreshold).getValue() / 256;
		return (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmTemperatureMinWarningThreshold).getValue()/ 256.0));
	}

	public void setUtsDot3OltOpmTemperatureMinWarningThreshold(
			Integer aUtsDot3OltOpmTemperatureMinWarningThreshold) {
		getProperty(utsDot3OltOpmTemperatureMinWarningThreshold).setValue(
				aUtsDot3OltOpmTemperatureMinWarningThreshold * 256);
	}

	public Integer getUtsDot3OltOpmTemperatureMaxWarningThreshold() {
//		return (Integer) getProperty(
//				utsDot3OltOpmTemperatureMaxWarningThreshold).getValue() / 256;
		return (int)(java.lang.Math.round((Integer)getProperty(utsDot3OltOpmTemperatureMaxWarningThreshold).getValue()/ 256.0));
	}

	public void setUtsDot3OltOpmTemperatureMaxWarningThreshold(
			Integer aUtsDot3OltOpmTemperatureMaxWarningThreshold) {
		getProperty(utsDot3OltOpmTemperatureMaxWarningThreshold)
				.setValue(
						java.lang.Math
								.round(aUtsDot3OltOpmTemperatureMaxWarningThreshold * 256));
	}

	public Double getUtsDot3OltOpmTxPowerMinWarningThreshold() {
		if ((Integer) getProperty(utsDot3OltOpmTxPowerMinWarningThreshold)
				.getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsDot3OltOpmTxPowerMinWarningThreshold).getValue() / 10000.0);
		if(d>8.1 && d <=8.2) return 8.1;
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setUtsDot3OltOpmTxPowerMinWarningThreshold(
			Double aUtsDot3OltOpmTxPowerMinWarningThreshold) {
		getProperty(utsDot3OltOpmTxPowerMinWarningThreshold)
				.setValue(
						(int) java.lang.Math
								.round(java.lang.Math
										.pow(
												10,
												aUtsDot3OltOpmTxPowerMinWarningThreshold / 10.0) * 10000));
	}

	public Double getUtsDot3OltOpmTxPowerMaxWarningThreshold() {
		if ((Integer) getProperty(utsDot3OltOpmTxPowerMaxWarningThreshold)
				.getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsDot3OltOpmTxPowerMaxWarningThreshold).getValue() / 10000.0);
		if(d>8.1 && d <=8.2) return 8.1;
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setUtsDot3OltOpmTxPowerMaxWarningThreshold(
			Double aUtsDot3OltOpmTxPowerMaxWarningThreshold) {
		getProperty(utsDot3OltOpmTxPowerMaxWarningThreshold)
				.setValue(
						(int) java.lang.Math
								.round(java.lang.Math
										.pow(
												10,
												aUtsDot3OltOpmTxPowerMaxWarningThreshold / 10.0) * 10000));
	}

	public Double getUtsDot3OltOpmOnuRxPowerMinAlarmThreshold() {
		if ((Integer) getProperty(utsDot3OltOpmOnuRxPowerMinAlarmThreshold)
				.getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsDot3OltOpmOnuRxPowerMinAlarmThreshold).getValue() / 10000.0);
		if(d>8.1 && d <=8.2) return 8.1;
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setUtsDot3OltOpmOnuRxPowerMinAlarmThreshold(
			Double aUtsDot3OltOpmOnuRxPowerMinAlarmThreshold) {
//		if (aUtsDot3OltOpmOnuRxPowerMinAlarmThreshold != 0) {
			getProperty(utsDot3OltOpmOnuRxPowerMinAlarmThreshold)
					.setValue(
							(int) java.lang.Math
									.round(java.lang.Math
											.pow(
													10,
													aUtsDot3OltOpmOnuRxPowerMinAlarmThreshold / 10.0) * 10000));
//		}
	}

	public Double getUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold() {
		if ((Integer) getProperty(utsDot3OltOpmOnuRxPowerMaxAlarmThreshold)
				.getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsDot3OltOpmOnuRxPowerMaxAlarmThreshold).getValue() / 10000.0);
		if(d>8.1 && d <=8.2) return 8.1;
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold(
			Double aUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold) {
//		if (aUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold != 0) {
			getProperty(utsDot3OltOpmOnuRxPowerMaxAlarmThreshold)
					.setValue(
							(int) java.lang.Math
									.round(java.lang.Math
											.pow(
													10,
													aUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold / 10.0) * 10000));
//		}
	}

	public Double getUtsDot3OltOpmOnuRxPowerMinWarningThreshold() {
		if ((Integer) getProperty(utsDot3OltOpmOnuRxPowerMinWarningThreshold)
				.getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math
				.log10((Integer) getProperty(
						utsDot3OltOpmOnuRxPowerMinWarningThreshold).getValue() / 10000.0);
		if(d>8.1 && d <=8.2) return 8.1;
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setUtsDot3OltOpmOnuRxPowerMinWarningThreshold(
			Double aUtsDot3OltOpmOnuRxPowerMinWarningThreshold) {
		getProperty(utsDot3OltOpmOnuRxPowerMinWarningThreshold)
				.setValue(
						(int) java.lang.Math
								.round(java.lang.Math
										.pow(
												10,
												aUtsDot3OltOpmOnuRxPowerMinWarningThreshold / 10.0) * 10000));
	}

	public Double getUtsDot3OltOpmOnuRxPowerMaxWarningThreshold() {
		if ((Integer) getProperty(utsDot3OltOpmOnuRxPowerMaxWarningThreshold)
				.getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math
				.log10((Integer) getProperty(
						utsDot3OltOpmOnuRxPowerMaxWarningThreshold).getValue() / 10000.0);
		if(d>8.1 && d <=8.2) return 8.1;
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setUtsDot3OltOpmOnuRxPowerMaxWarningThreshold(
			Double aUtsDot3OltOpmOnuRxPowerMaxWarningThreshold) {
		getProperty(utsDot3OltOpmOnuRxPowerMaxWarningThreshold)
				.setValue(
						(int) java.lang.Math
								.round(java.lang.Math
										.pow(
												10,
												aUtsDot3OltOpmOnuRxPowerMaxWarningThreshold / 10.0) * 10000));
		
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(getProperty(utsDot3OltOpmVoltageMinAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmVoltageMaxAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmBiasCurrentMinAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmBiasCurrentMaxAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmTemperatureMinAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmTemperatureMaxAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmTxPowerMinAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmTxPowerMaxAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmVoltageMinWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmVoltageMaxWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmBiasCurrentMinWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmBiasCurrentMaxWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmTemperatureMinWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmTemperatureMaxWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmTxPowerMinWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmTxPowerMaxWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmOnuRxPowerMinAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmOnuRxPowerMaxAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmOnuRxPowerMinWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmOnuRxPowerMaxWarningThreshold));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(getProperty(utsDot3OltOpmVoltageMinAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmVoltageMaxAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmBiasCurrentMinAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmBiasCurrentMaxAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmTemperatureMinAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmTemperatureMaxAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmTxPowerMinAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmTxPowerMaxAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmVoltageMinWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmVoltageMaxWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmBiasCurrentMinWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmBiasCurrentMaxWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmTemperatureMinWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmTemperatureMaxWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmTxPowerMinWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmTxPowerMaxWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmOnuRxPowerMinAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmOnuRxPowerMaxAlarmThreshold));
		prepareRead(getProperty(utsDot3OltOpmOnuRxPowerMinWarningThreshold));
		prepareRead(getProperty(utsDot3OltOpmOnuRxPowerMaxWarningThreshold));

		return loadAll(new int[] { 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3OltOpmVoltageMinAlarmThreshold));
		prepareSave(getProperty(utsDot3OltOpmVoltageMaxAlarmThreshold));
		prepareSave(getProperty(utsDot3OltOpmBiasCurrentMinAlarmThreshold));
		prepareSave(getProperty(utsDot3OltOpmBiasCurrentMaxAlarmThreshold));
		prepareSave(getProperty(utsDot3OltOpmTemperatureMinAlarmThreshold));
		prepareSave(getProperty(utsDot3OltOpmTemperatureMaxAlarmThreshold));
		prepareSave(getProperty(utsDot3OltOpmTxPowerMinAlarmThreshold));
		prepareSave(getProperty(utsDot3OltOpmTxPowerMaxAlarmThreshold));
		prepareSave(getProperty(utsDot3OltOpmVoltageMinWarningThreshold));
		prepareSave(getProperty(utsDot3OltOpmVoltageMaxWarningThreshold));
		prepareSave(getProperty(utsDot3OltOpmBiasCurrentMinWarningThreshold));
		prepareSave(getProperty(utsDot3OltOpmBiasCurrentMaxWarningThreshold));
		prepareSave(getProperty(utsDot3OltOpmTemperatureMinWarningThreshold));
		prepareSave(getProperty(utsDot3OltOpmTemperatureMaxWarningThreshold));
		prepareSave(getProperty(utsDot3OltOpmTxPowerMinWarningThreshold));
		prepareSave(getProperty(utsDot3OltOpmTxPowerMaxWarningThreshold));
		prepareSave(getProperty(utsDot3OltOpmOnuRxPowerMinAlarmThreshold));
		prepareSave(getProperty(utsDot3OltOpmOnuRxPowerMaxAlarmThreshold));
		prepareSave(getProperty(utsDot3OltOpmOnuRxPowerMinWarningThreshold));
		prepareSave(getProperty(utsDot3OltOpmOnuRxPowerMaxWarningThreshold));

		return save();
	}

}
