package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3OltOpmThreshold;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.DoubleTextField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Dot3OltOpmThresholdPanel extends UPanel {
	private IntegerTextField tfUtsDot3OltOpmVoltageMinAlarmThreshold = new IntegerTextField();
	private IntegerTextField tfUtsDot3OltOpmVoltageMaxAlarmThreshold = new IntegerTextField();
	private IntegerTextField tfUtsDot3OltOpmBiasCurrentMinAlarmThreshold = new IntegerTextField();
	private IntegerTextField tfUtsDot3OltOpmBiasCurrentMaxAlarmThreshold = new IntegerTextField();
	private IntegerTextField tfUtsDot3OltOpmTemperatureMinAlarmThreshold = new IntegerTextField();
	private IntegerTextField tfUtsDot3OltOpmTemperatureMaxAlarmThreshold = new IntegerTextField();
	private DoubleTextField tfUtsDot3OltOpmTxPowerMinAlarmThreshold = new DoubleTextField();
	private DoubleTextField tfUtsDot3OltOpmTxPowerMaxAlarmThreshold = new DoubleTextField();
	private IntegerTextField tfUtsDot3OltOpmVoltageMinWarningThreshold = new IntegerTextField();
	private IntegerTextField tfUtsDot3OltOpmVoltageMaxWarningThreshold = new IntegerTextField();
	private IntegerTextField tfUtsDot3OltOpmBiasCurrentMinWarningThreshold = new IntegerTextField();
	private IntegerTextField tfUtsDot3OltOpmBiasCurrentMaxWarningThreshold = new IntegerTextField();
	private IntegerTextField tfUtsDot3OltOpmTemperatureMinWarningThreshold = new IntegerTextField();
	private IntegerTextField tfUtsDot3OltOpmTemperatureMaxWarningThreshold = new IntegerTextField();
	private DoubleTextField tfUtsDot3OltOpmTxPowerMinWarningThreshold = new DoubleTextField();
	private DoubleTextField tfUtsDot3OltOpmTxPowerMaxWarningThreshold = new DoubleTextField();
	private DoubleTextField tfUtsDot3OltOpmOnuRxPowerMinAlarmThreshold = new DoubleTextField();
	private DoubleTextField tfUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold = new DoubleTextField();
	private DoubleTextField tfUtsDot3OltOpmOnuRxPowerMinWarningThreshold = new DoubleTextField();
	private DoubleTextField tfUtsDot3OltOpmOnuRxPowerMaxWarningThreshold = new DoubleTextField();

	private final String utsDot3OltOpmVoltageMinAlarmThreshold = fStringMap
			.getString("utsDot3OltOpmVoltageMinAlarmThreshold")
			+ " : ";
	private final String utsDot3OltOpmVoltageMaxAlarmThreshold = fStringMap
			.getString("utsDot3OltOpmVoltageMaxAlarmThreshold")
			+ " : ";
	private final String utsDot3OltOpmBiasCurrentMinAlarmThreshold = fStringMap
			.getString("utsDot3OltOpmBiasCurrentMinAlarmThreshold")
			+ " : ";
	private final String utsDot3OltOpmBiasCurrentMaxAlarmThreshold = fStringMap
			.getString("utsDot3OltOpmBiasCurrentMaxAlarmThreshold")
			+ " : ";
	private final String utsDot3OltOpmTemperatureMinAlarmThreshold = fStringMap
			.getString("utsDot3OltOpmTemperatureMinAlarmThreshold")
			+ " : ";
	private final String utsDot3OltOpmTemperatureMaxAlarmThreshold = fStringMap
			.getString("utsDot3OltOpmTemperatureMaxAlarmThreshold")
			+ " : ";
	private final String utsDot3OltOpmTxPowerMinAlarmThreshold = fStringMap
			.getString("utsDot3OltOpmTxPowerMinAlarmThreshold")
			+ " : ";
	private final String utsDot3OltOpmTxPowerMaxAlarmThreshold = fStringMap
			.getString("utsDot3OltOpmTxPowerMaxAlarmThreshold")
			+ " : ";
	private final String utsDot3OltOpmVoltageMinWarningThreshold = fStringMap
			.getString("utsDot3OltOpmVoltageMinWarningThreshold")
			+ " : ";
	private final String utsDot3OltOpmVoltageMaxWarningThreshold = fStringMap
			.getString("utsDot3OltOpmVoltageMaxWarningThreshold")
			+ " : ";
	private final String utsDot3OltOpmBiasCurrentMinWarningThreshold = fStringMap
			.getString("utsDot3OltOpmBiasCurrentMinWarningThreshold")
			+ " : ";
	private final String utsDot3OltOpmBiasCurrentMaxWarningThreshold = fStringMap
			.getString("utsDot3OltOpmBiasCurrentMaxWarningThreshold")
			+ " : ";
	private final String utsDot3OltOpmTemperatureMinWarningThreshold = fStringMap
			.getString("utsDot3OltOpmTemperatureMinWarningThreshold")
			+ " : ";
	private final String utsDot3OltOpmTemperatureMaxWarningThreshold = fStringMap
			.getString("utsDot3OltOpmTemperatureMaxWarningThreshold")
			+ " : ";
	private final String utsDot3OltOpmTxPowerMinWarningThreshold = fStringMap
			.getString("utsDot3OltOpmTxPowerMinWarningThreshold")
			+ " : ";
	private final String utsDot3OltOpmTxPowerMaxWarningThreshold = fStringMap
			.getString("utsDot3OltOpmTxPowerMaxWarningThreshold")
			+ " : ";
	private final String utsDot3OltOpmOnuRxPowerMinAlarmThreshold = fStringMap
			.getString("utsDot3OltOpmOnuRxPowerMinAlarmThreshold")
			+ " : ";
	private final String utsDot3OltOpmOnuRxPowerMaxAlarmThreshold = fStringMap
			.getString("utsDot3OltOpmOnuRxPowerMaxAlarmThreshold")
			+ " : ";
	private final String utsDot3OltOpmOnuRxPowerMinWarningThreshold = fStringMap
			.getString("utsDot3OltOpmOnuRxPowerMinWarningThreshold")
			+ " : ";
	private final String utsDot3OltOpmOnuRxPowerMaxWarningThreshold = fStringMap
			.getString("utsDot3OltOpmOnuRxPowerMaxWarningThreshold")
			+ " : ";

	private SnmpApplyButton btApply;
	private SnmpRefreshButton btRefresh;

	public Dot3OltOpmThresholdPanel(IApplication app) {
		super(app);
		setModel(new Dot3OltOpmThreshold(app.getSnmpProxy()));
		init();
	}

	public void initGui() {
		btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction().putValue(BaseAction.ID,
				"Modify_GponAlarmTableScalars");
		btRefresh = new SnmpRefreshButton(fApplication, this);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
		buttonsPanel.add(btRefresh);

		JPanel baseInfoPanel = new JPanel();
		ThresholdNTLayout layout = new ThresholdNTLayout(10, 6, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmVoltageMinAlarmThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmVoltageMinAlarmThreshold);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmVoltageMaxAlarmThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmVoltageMaxAlarmThreshold);
//		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3OltOpmBiasCurrentMinAlarmThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmBiasCurrentMinAlarmThreshold);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3OltOpmBiasCurrentMaxAlarmThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmBiasCurrentMaxAlarmThreshold);
//		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3OltOpmTemperatureMinAlarmThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmTemperatureMinAlarmThreshold);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3OltOpmTemperatureMaxAlarmThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmTemperatureMaxAlarmThreshold);
//		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmVoltageMinWarningThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmVoltageMinWarningThreshold);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmVoltageMaxWarningThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmVoltageMaxWarningThreshold);
//		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3OltOpmBiasCurrentMinWarningThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmBiasCurrentMinWarningThreshold);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3OltOpmBiasCurrentMaxWarningThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmBiasCurrentMaxWarningThreshold);
//		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3OltOpmTemperatureMinWarningThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmTemperatureMinWarningThreshold);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3OltOpmTemperatureMaxWarningThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmTemperatureMaxWarningThreshold);
//		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmTxPowerMinAlarmThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmTxPowerMinAlarmThreshold);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmTxPowerMaxAlarmThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmTxPowerMaxAlarmThreshold);
//		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmTxPowerMinWarningThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmTxPowerMinWarningThreshold);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmTxPowerMaxWarningThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmTxPowerMaxWarningThreshold);
//		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOnuRxPowerMinAlarmThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmOnuRxPowerMinAlarmThreshold);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOnuRxPowerMaxAlarmThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold);
//		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3OltOpmOnuRxPowerMinWarningThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmOnuRxPowerMinWarningThreshold);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3OltOpmOnuRxPowerMaxWarningThreshold));
		baseInfoPanel.add(tfUtsDot3OltOpmOnuRxPowerMaxWarningThreshold);
//		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		JPanel allPanel = new JPanel();
		NTLayout layout1 = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout1.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout1);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

		add(buttonsPanel, BorderLayout.SOUTH);
	}

	protected void initForm() {
		// The unit is 100 uV. The range is 0 to 6.55 v.
		tfUtsDot3OltOpmVoltageMinAlarmThreshold.setValueScope(0, 6550);

		// The unit is 100 uV. The range is 0 to 6.55 v.
		tfUtsDot3OltOpmVoltageMaxAlarmThreshold.setValueScope(0, 6550);

		// The unit is 2 uA. The range is 0 to 131 mA.
		tfUtsDot3OltOpmBiasCurrentMinAlarmThreshold.setValueScope(0, 131);

		// The unit is 2 uA. The range is 0 to 131 mA.
		tfUtsDot3OltOpmBiasCurrentMaxAlarmThreshold.setValueScope(0, 131);

		// The unit is 1/256 degree. The range is -128 C to 128 C..
		tfUtsDot3OltOpmTemperatureMinAlarmThreshold.setValueScope(-128, 128);

		// The unit is 1/256 degree. The range is -128 C to 128 C..
		tfUtsDot3OltOpmTemperatureMaxAlarmThreshold.setValueScope(-128, 128);

		// The unit is 0.1uW. The range is 0 to 6.5535mW.
		tfUtsDot3OltOpmTxPowerMinAlarmThreshold.setValueScope(-40, 8.1);

		// The unit is 0.1uW. The range is 0 to 6.5535mW.
		tfUtsDot3OltOpmTxPowerMaxAlarmThreshold.setValueScope(-40, 8.1);

		// The unit is 100 uV. The range is 0 to 6.55 v.
		tfUtsDot3OltOpmVoltageMinWarningThreshold.setValueScope(0, 6550);

		// The unit is 100 uV. The range is 0 to 6.55 v.
		tfUtsDot3OltOpmVoltageMaxWarningThreshold.setValueScope(0, 6550);

		// The unit is 2 uA. The range is 0 to 131 mA.
		tfUtsDot3OltOpmBiasCurrentMinWarningThreshold.setValueScope(0, 131);

		// The unit is 2 uA. The range is 0 to 131 mA.
		tfUtsDot3OltOpmBiasCurrentMaxWarningThreshold.setValueScope(0, 131);

		// The unit is 1/256 degree. The range is -128 C to 128 C..
		tfUtsDot3OltOpmTemperatureMinWarningThreshold.setValueScope(-128, 128);

		// The unit is 1/256 degree. The range is -128 C to 128 C..
		tfUtsDot3OltOpmTemperatureMaxWarningThreshold.setValueScope(-128, 128);

		// The unit is 0.1uW. The range is 0 to 6.5535mW.0x80000000
		tfUtsDot3OltOpmTxPowerMinWarningThreshold.setValueScope(-40, 8.1);

		// The unit is 0.1uW. The range is 0 to 6.5535mW.
		tfUtsDot3OltOpmTxPowerMaxWarningThreshold.setValueScope(-40, 8.1);

		// The unit is 0.1uW. The range is 0 to 6.5535mW.
		tfUtsDot3OltOpmOnuRxPowerMinAlarmThreshold.setValueScope(-40, 8.1);

		// The unit is 0.1uW. The range is 0 to 6.5535mW.
		tfUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold.setValueScope(-40, 8.1);

		// The unit is 0.1uW. The range is 0 to 6.5535mW.
		tfUtsDot3OltOpmOnuRxPowerMinWarningThreshold.setValueScope(-40, 8.1);

		// The unit is 0.1uW. The range is 0 to 6.5535mW.
		tfUtsDot3OltOpmOnuRxPowerMaxWarningThreshold.setValueScope(-40, 8.1);
	}

	public boolean validateFrom() {
		if (!isFormatValidate(tfUtsDot3OltOpmTxPowerMinAlarmThreshold
				.getValue())) {
			MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Format_Value"));
			return false;
		}
		if (!isFormatValidate(tfUtsDot3OltOpmTxPowerMaxAlarmThreshold
				.getValue())) {
			MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Format_Value"));
			return false;
		}
		if (!isFormatValidate(tfUtsDot3OltOpmTxPowerMinWarningThreshold
				.getValue())) {
			MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Format_Value"));
			return false;
		}
		if (!isFormatValidate(tfUtsDot3OltOpmTxPowerMaxWarningThreshold
				.getValue())) {
			MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Format_Value"));
			return false;
		}
		if (!isFormatValidate(tfUtsDot3OltOpmOnuRxPowerMinAlarmThreshold
				.getValue())) {
			MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Format_Value"));
			return false;
		}
		if (!isFormatValidate(tfUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold
				.getValue())) {
			MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Format_Value"));
			return false;
		}
		if (!isFormatValidate(tfUtsDot3OltOpmOnuRxPowerMinWarningThreshold
				.getValue())) {
			MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Format_Value"));
			return false;
		}
		if (!isFormatValidate(tfUtsDot3OltOpmOnuRxPowerMaxWarningThreshold
				.getValue())) {
			MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Format_Value"));
			return false;
		}

		return true;
	}

	protected boolean isFormatValidate(Double d) {
		String s = d.toString();
		if (s.contains(".")) {
			if (s.subSequence(s.lastIndexOf(".") + 1, s.length()).length() > 2)
				return false;
		}

		return true;
	}

	public void refresh() {
		Dot3OltOpmThreshold mbean = (Dot3OltOpmThreshold) getModel();
		BeanService.refreshBean(fApplication, mbean);

		tfUtsDot3OltOpmVoltageMinAlarmThreshold.setValue(mbean
				.getUtsDot3OltOpmVoltageMinAlarmThreshold());
		tfUtsDot3OltOpmVoltageMaxAlarmThreshold.setValue(mbean
				.getUtsDot3OltOpmVoltageMaxAlarmThreshold());
		tfUtsDot3OltOpmBiasCurrentMinAlarmThreshold.setValue(mbean
				.getUtsDot3OltOpmBiasCurrentMinAlarmThreshold());
		tfUtsDot3OltOpmBiasCurrentMaxAlarmThreshold.setValue(mbean
				.getUtsDot3OltOpmBiasCurrentMaxAlarmThreshold() == null ? 67890
				: mbean.getUtsDot3OltOpmBiasCurrentMaxAlarmThreshold());
		tfUtsDot3OltOpmTemperatureMinAlarmThreshold.setValue(mbean
				.getUtsDot3OltOpmTemperatureMinAlarmThreshold());
		tfUtsDot3OltOpmTemperatureMaxAlarmThreshold.setValue(mbean
				.getUtsDot3OltOpmTemperatureMaxAlarmThreshold());

		if (mbean.getUtsDot3OltOpmTxPowerMinAlarmThreshold() > -41) {
			tfUtsDot3OltOpmTxPowerMinAlarmThreshold.setValue(mbean
					.getUtsDot3OltOpmTxPowerMinAlarmThreshold());
		} else {
			tfUtsDot3OltOpmTxPowerMinAlarmThreshold.setText("   ");
		}
		if (mbean.getUtsDot3OltOpmTxPowerMaxAlarmThreshold() > -41) {
			tfUtsDot3OltOpmTxPowerMaxAlarmThreshold.setValue(mbean
					.getUtsDot3OltOpmTxPowerMaxAlarmThreshold());
		} else {
			tfUtsDot3OltOpmTxPowerMaxAlarmThreshold.setText("   ");
		}
		tfUtsDot3OltOpmVoltageMinWarningThreshold.setValue(mbean
				.getUtsDot3OltOpmVoltageMinWarningThreshold());
		tfUtsDot3OltOpmVoltageMaxWarningThreshold.setValue(mbean
				.getUtsDot3OltOpmVoltageMaxWarningThreshold());
		tfUtsDot3OltOpmBiasCurrentMinWarningThreshold.setValue(mbean
				.getUtsDot3OltOpmBiasCurrentMinWarningThreshold());
		tfUtsDot3OltOpmBiasCurrentMaxWarningThreshold.setValue(mbean
				.getUtsDot3OltOpmBiasCurrentMaxWarningThreshold());
		tfUtsDot3OltOpmTemperatureMinWarningThreshold.setValue(mbean
				.getUtsDot3OltOpmTemperatureMinWarningThreshold());
		if (mbean.getUtsDot3OltOpmTemperatureMaxWarningThreshold() > -41) {
			tfUtsDot3OltOpmTemperatureMaxWarningThreshold.setValue(mbean
					.getUtsDot3OltOpmTemperatureMaxWarningThreshold());
		} else {
			tfUtsDot3OltOpmTemperatureMaxWarningThreshold.setText("   ");
		}
		if (mbean.getUtsDot3OltOpmTxPowerMinWarningThreshold() > -41) {
			tfUtsDot3OltOpmTxPowerMinWarningThreshold.setValue(mbean
					.getUtsDot3OltOpmTxPowerMinWarningThreshold());
		} else {
			tfUtsDot3OltOpmTxPowerMinWarningThreshold.setText("    ");
		}
		if (mbean.getUtsDot3OltOpmTxPowerMaxWarningThreshold() > -41) {
			tfUtsDot3OltOpmTxPowerMaxWarningThreshold.setValue(mbean
					.getUtsDot3OltOpmTxPowerMaxWarningThreshold());
		} else {
			tfUtsDot3OltOpmTxPowerMaxWarningThreshold.setText("    ");
		}
		if (mbean.getUtsDot3OltOpmOnuRxPowerMinAlarmThreshold() > -41) {
			tfUtsDot3OltOpmOnuRxPowerMinAlarmThreshold.setValue(mbean
					.getUtsDot3OltOpmOnuRxPowerMinAlarmThreshold());
		} else {
			tfUtsDot3OltOpmOnuRxPowerMinAlarmThreshold.setText("   ");
		}
		if (mbean.getUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold() > -41) {
			tfUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold.setValue(mbean
					.getUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold());
		} else {
			tfUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold.setText("    ");
		}
		if (mbean.getUtsDot3OltOpmOnuRxPowerMinWarningThreshold() > -41) {
			tfUtsDot3OltOpmOnuRxPowerMinWarningThreshold.setValue(mbean
					.getUtsDot3OltOpmOnuRxPowerMinWarningThreshold());
		} else {
			tfUtsDot3OltOpmOnuRxPowerMinWarningThreshold.setText("   ");
		}
		if (mbean.getUtsDot3OltOpmOnuRxPowerMaxWarningThreshold() > -41) {
			tfUtsDot3OltOpmOnuRxPowerMaxWarningThreshold.setValue(mbean
					.getUtsDot3OltOpmOnuRxPowerMaxWarningThreshold());
		} else {
			tfUtsDot3OltOpmOnuRxPowerMaxWarningThreshold.setText("   ");
		}
	}

	public void updateModel() {
		Dot3OltOpmThreshold mbean = (Dot3OltOpmThreshold) getModel();
		if (mbean == null)
			return;

		mbean.setUtsDot3OltOpmVoltageMinAlarmThreshold(new Integer(
				tfUtsDot3OltOpmVoltageMinAlarmThreshold.getValue()));
		mbean.setUtsDot3OltOpmVoltageMaxAlarmThreshold(new Integer(
				tfUtsDot3OltOpmVoltageMaxAlarmThreshold.getValue()));
		mbean.setUtsDot3OltOpmBiasCurrentMinAlarmThreshold(new Integer(
				tfUtsDot3OltOpmBiasCurrentMinAlarmThreshold.getValue()));
		mbean.setUtsDot3OltOpmBiasCurrentMaxAlarmThreshold(new Integer(
				tfUtsDot3OltOpmBiasCurrentMaxAlarmThreshold.getValue()));
		mbean.setUtsDot3OltOpmTemperatureMinAlarmThreshold(new Integer(
				tfUtsDot3OltOpmTemperatureMinAlarmThreshold.getValue()));
		mbean.setUtsDot3OltOpmTemperatureMaxAlarmThreshold(new Integer(
				tfUtsDot3OltOpmTemperatureMaxAlarmThreshold.getValue()));
		if (!tfUtsDot3OltOpmTxPowerMinAlarmThreshold.getText().trim()
				.equals("")) {
			mbean.setUtsDot3OltOpmTxPowerMinAlarmThreshold(new Double(
					tfUtsDot3OltOpmTxPowerMinAlarmThreshold.getValue()));
		}
		if (!tfUtsDot3OltOpmTxPowerMaxAlarmThreshold.getText().trim()
				.equals("")) {
			mbean.setUtsDot3OltOpmTxPowerMaxAlarmThreshold(new Double(
					tfUtsDot3OltOpmTxPowerMaxAlarmThreshold.getValue()));
		}
		mbean.setUtsDot3OltOpmVoltageMinWarningThreshold(new Integer(
				tfUtsDot3OltOpmVoltageMinWarningThreshold.getValue()));
		mbean.setUtsDot3OltOpmVoltageMaxWarningThreshold(new Integer(
				tfUtsDot3OltOpmVoltageMaxWarningThreshold.getValue()));
		mbean.setUtsDot3OltOpmBiasCurrentMinWarningThreshold(new Integer(
				tfUtsDot3OltOpmBiasCurrentMinWarningThreshold.getValue()));
		mbean.setUtsDot3OltOpmBiasCurrentMaxWarningThreshold(new Integer(
				tfUtsDot3OltOpmBiasCurrentMaxWarningThreshold.getValue()));
		mbean.setUtsDot3OltOpmTemperatureMinWarningThreshold(new Integer(
				tfUtsDot3OltOpmTemperatureMinWarningThreshold.getValue()));
		mbean.setUtsDot3OltOpmTemperatureMaxWarningThreshold(new Integer(
				tfUtsDot3OltOpmTemperatureMaxWarningThreshold.getValue()));
		if (!tfUtsDot3OltOpmTxPowerMinWarningThreshold.getText().trim().equals(
				"")) {
			mbean.setUtsDot3OltOpmTxPowerMinWarningThreshold(new Double(
					tfUtsDot3OltOpmTxPowerMinWarningThreshold.getValue()));
		}
		if (!tfUtsDot3OltOpmTxPowerMaxWarningThreshold.getText().trim().equals(
				"")) {
			mbean.setUtsDot3OltOpmTxPowerMaxWarningThreshold(new Double(
					tfUtsDot3OltOpmTxPowerMaxWarningThreshold.getValue()));
		}
		if (!tfUtsDot3OltOpmOnuRxPowerMinAlarmThreshold.getText().trim()
				.equals("")) {
			mbean.setUtsDot3OltOpmOnuRxPowerMinAlarmThreshold(new Double(
					tfUtsDot3OltOpmOnuRxPowerMinAlarmThreshold.getValue()));
		}
		if (!tfUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold.getText().trim()
				.equals("")) {
			mbean.setUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold(new Double(
					tfUtsDot3OltOpmOnuRxPowerMaxAlarmThreshold.getValue()));
		}
		if (!tfUtsDot3OltOpmOnuRxPowerMinWarningThreshold.getText().trim()
				.equals("")) {
			mbean.setUtsDot3OltOpmOnuRxPowerMinWarningThreshold(new Double(
					tfUtsDot3OltOpmOnuRxPowerMinWarningThreshold.getValue()));
		}
		if (!tfUtsDot3OltOpmOnuRxPowerMaxWarningThreshold.getText().trim()
				.equals("")) {
			mbean.setUtsDot3OltOpmOnuRxPowerMaxWarningThreshold(new Double(
					tfUtsDot3OltOpmOnuRxPowerMaxWarningThreshold.getValue()));
		}
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}

		return 0;
	}
	
	class ThresholdNTLayout extends NTLayout {
		public ThresholdNTLayout( int rows, int cols,
                int hAlignment, int vAlignment,
                int hgap, int vgap ) {
			super(rows, cols, hAlignment, vAlignment, hgap, vgap);
		}
		
		public Dimension preferredLayoutSize( Container parent ) {
	        synchronized ( parent.getTreeLock() ) {
	            int ncomponents = parent.getComponentCount();
	            Insets insets = parent.getInsets();

	            int nrows = rows;
	            int ncols = cols;
	            if ( nrows > 0 ) {
	                ncols = ( ncomponents + nrows - 1 ) / nrows;
	            } else {
	                nrows = ( ncomponents + ncols - 1 ) / ncols;
	            }
	            int totalWidth = 0;
	            int totalHeight = 0;
	            int[] prefWidth = new int[ncols];
	            int[] prefHeight = new int[nrows];
	            for ( int i = 0; i < ncols; i++ ) {
	                prefWidth[i] = minW;
	                for ( int j = 0; j < nrows; j++ ) {
	                    int index = j * ncols + i;
	                    if ( index >= ncomponents ) continue;
	                    Component comp = parent.getComponent( index );
	                    Dimension d = comp.getPreferredSize();
	                    if ( d.width > prefWidth[i] )
	                        prefWidth[i] = d.width;
	                }
	                if(i % 3 == 1)
	                totalWidth = totalWidth + prefWidth[i] / 2;
	                this.columnScale[i] = prefWidth[i];
	            }
	            for ( int i = 0; i < nrows; i++ ) {
	                prefHeight[i] = minH;
	                for ( int j = 0; j < ncols; j++ ) {
	                    int index = i * ncols + j;
	                    if ( index >= ncomponents ) continue;
	                    Component comp = parent.getComponent( index );
	                    Dimension d = comp.getPreferredSize();
	                    if ( d.height > prefHeight[i] )
	                        prefHeight[i] = d.height;
	                }
	                totalHeight = totalHeight + prefHeight[i];
	                this.rowScale[i] = prefHeight[i];
	            }

	            return new Dimension( totalWidth + leftBorder + insets.left +
	                                  rightBorder + insets.right + ( ncols - 1 ) * hgap,
	                                  totalHeight + topBorder + insets.top +
	                                  bottomBorder + insets.bottom + ( nrows - 1 ) * vgap );
	        }
	    }
		
		protected void allocateSuitableSizes( Container parent ) {

	        int totalWidth = 0;
	        int totalHeight = 0;

	        rowSizes = new int[rows];
	        columnSizes = new int[cols];
	        Dimension thisSize = parent.getSize();
	        Insets insets = parent.getInsets();
	        int width = thisSize.width - leftBorder - rightBorder - ( insets.left + insets.right )
	                - ( cols - 1 ) * hgap;
	        int height = thisSize.height - topBorder - bottomBorder - ( insets.top + insets.bottom )
	                - ( rows - 1 ) * vgap;
	        int ncomponents = parent.getComponentCount();
	        int nrows = rows;
	        int ncols = cols;
	        int[] prefWidth = new int[ncols];
	        int[] prefHeight = new int[nrows];

	        //set all scales of column spring
	        Vector columnSprings = new Vector();
	        boolean haveColSpring = false;
	        for ( int i = 0; i < ncols; i++ ) {
	            prefWidth[i] = minW;
	            for ( int j = 0; j < nrows; j++ ) {
	                int index = j * ncols + i;
	                if ( index >= ncomponents ) continue;
	                Component comp = parent.getComponent( index );
	                if ( comp instanceof HSpacer ) {
	                    HSpacer spacer = (HSpacer)comp;
	                    if (spacer.isSpring()){//not a type of solid
	                     columnSprings.add( new Integer( i ) );
	                     haveColSpring = true;
	                     break;
	                    }//else same as a common component;
	                }
	                Dimension d = comp.getPreferredSize();
	                if ( d.width > prefWidth[i] )
	                    prefWidth[i] = d.width;
	            }
	            if ( haveColSpring ) {
	                haveColSpring = false;
	                continue;
	            }
	            totalWidth = totalWidth + prefWidth[i];
	            this.columnScale[i] = prefWidth[i];
	        }
	        if ( columnSprings.size() > 0 ) {
	            double springSize = ( width - totalWidth ) / columnSprings.size();
	            for ( int i = 0; i < ncols; i++ ) {
	                if ( columnSprings.indexOf( new Integer( i ) ) != -1 ) {
	                    columnScale[i] = springSize;
	                }
	            }
	        }
	        //set all scales of row spring
	        Vector rowSprings = new Vector();
	        boolean haveRowSpring = false;
	        for ( int i = 0; i < nrows; i++ ) {
	            prefHeight[i] = minH;
	            for ( int j = 0; j < ncols; j++ ) {
	                int index = i * ncols + j;
	                if ( index >= ncomponents ) continue;
	                Component comp = parent.getComponent( index );
	                if ( comp instanceof VSpacer ) {
	                    VSpacer spacer = (VSpacer)comp;
	                    if (spacer.isSpring()){
	                     rowSprings.add( new Integer( i ) );
	                     haveRowSpring = true;
	                     break;
	                    }
	                }
	                Dimension d = comp.getPreferredSize();
	                if ( d.height > prefHeight[i] )
	                    prefHeight[i] = d.height;
	            }
	            if ( haveRowSpring ) {
	                haveRowSpring = false;
	                continue;
	            }
	            totalHeight = totalHeight + prefHeight[i];
	            this.rowScale[i] = prefHeight[i];
	        }
	        if ( rowSprings.size() > 0 ) {
	            double springSize = ( height - totalHeight ) / rowSprings.size();
	            for ( int i = 0; i < nrows; i++ ) {
	                if ( rowSprings.indexOf( new Integer( i ) ) != -1 ) {
	                    rowScale[i] = springSize;
	                }
	            }
	        }
	        // allocate the all size of comp according to their scals ,height and  width
	        double totalRowProps = 0.0;
	        for ( int i = 0; i < rows; i++ ) {
	            totalRowProps += rowScale[i];
	        }
	        double totalColumnProps = 0.0;
	        for ( int j = 0; j < cols; j++ ) {
	            totalColumnProps += columnScale[j];
	        }

	        for ( int p = 0; p < rows; p++ ) {
	        	rowSizes[p] = ( int ) ( rowScale[p] * height / totalRowProps );
	        }
	        for ( int q = 0; q < cols; q++ ) {
	        	if(q % 3 == 0)
	        		columnSizes[q] = ( int ) ( columnScale[q] * width / totalColumnProps );
	        	if(q % 3 == 1)
	        		columnSizes[q] = ( int ) ( columnScale[q] * width / totalColumnProps / 3 + 20);
	        }
	    }
	}

}