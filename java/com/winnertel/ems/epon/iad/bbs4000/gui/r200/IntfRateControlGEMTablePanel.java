package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.IntfRateControlGEMTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-18
 * Time: 17:05:09
 * To change this template use File | Settings | File Templates.
 */
public class IntfRateControlGEMTablePanel extends UPanel {

  private JLabel tfUtsIntfRateControlId = new JLabel();

  private int[] utsIntfRateControlMcastEnableVList = new int[]{1, 2, };

  private String[] utsIntfRateControlMcastEnableTList = new String[]
  {fStringMap.getString("enabled"), fStringMap.getString("disabled"), };

  private JComboBox tfUtsIntfRateControlMcastEnable = new JComboBox(utsIntfRateControlMcastEnableTList);

  private IntegerTextField tfUtsIntfRateControlMcastLimit = new IntegerTextField();

  private int[] utsIntfRateControlBcastEnableVList = new int[]{1, 2, };

  private String[] utsIntfRateControlBcastEnableTList = new String[]
  {fStringMap.getString("enabled"), fStringMap.getString("disabled"), };

  private JComboBox tfUtsIntfRateControlBcastEnable = new JComboBox(utsIntfRateControlBcastEnableTList);

  private IntegerTextField tfUtsIntfRateControlBcastLimit = new IntegerTextField();

  private int[] utsIntfRateControlUnicastEnableVList = new int[]{1, 2, };

  private String[] utsIntfRateControlUnicastEnableTList = new String[]
  {fStringMap.getString("enabled"), fStringMap.getString("disabled"), };

  private JComboBox tfUtsIntfRateControlUnicastEnable = new JComboBox(utsIntfRateControlUnicastEnableTList);

  private IntegerTextField tfUtsIntfRateControlUnicastLimit = new IntegerTextField();

  private IntegerTextField tfUtsIntfRateLimitIngressBandwidth = new IntegerTextField();

  private IntegerTextField tfUtsIntfRateLimitEgressBandwidth = new IntegerTextField();

  private int[] utsIntfRateControlIsolationCtrlVList = new int[]
  {2, 1, };

  private String[] utsIntfRateControlIsolationCtrlTList = new String[]
  {fStringMap.getString("disable"), fStringMap.getString("enable"), };

  private JComboBox tfUtsIntfRateControlIsolationCtrl = new JComboBox(utsIntfRateControlIsolationCtrlTList);

//	private int[] utsIntfRateControlUplinkSpeedVList = new int[]
//	{ 100, 1000, 10, };
//
//	private String[] utsIntfRateControlUplinkSpeedTList = new String[]
//	{ fStringMap.getString("hundred-mega"), fStringMap.getString("giga-mega"),
//			fStringMap.getString("ten-mega"), };
//
//	private JComboBox tfUtsIntfRateControlUplinkSpeed = new JComboBox(
//			utsIntfRateControlUplinkSpeedTList);

  private int[] utsIntfRateControlVlanIngressFilterVList = new int[]
  {2, 1, };

  private String[] utsIntfRateControlVlanIngressFilterTList = new String[]
  {fStringMap.getString("disable"), fStringMap.getString("enable"), };

  private JComboBox tfUtsIntfRateControlVlanIngressFilter = new JComboBox(utsIntfRateControlVlanIngressFilterTList);

//	private int[] utsIntfRateControlUplinkTranceiverTypeVList = new int[]
//	{ 1, 2, };

  private int[] utsIntfRateControlAutoNegotiationVList = new int[]
  {2, 1, };

  private String[] utsIntfRateControlAutoNegotiationTList = new String[]
  {fStringMap.getString("disable"), fStringMap.getString("enable"), };

  private JComboBox tfUtsIntfRateControlAutoNegotiation = new JComboBox(utsIntfRateControlAutoNegotiationTList);

  private int[] utsIntfRateLimitIngressBurstSizeVList = new int[]{
    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
  };
  private String[] utsIntfRateLimitIngressBurstSizeTList = new String[]{
    fStringMap.getString("disable"), "4KB", "8KB", "16KB", "32KB", "64KB", "128KB", "256KB", "512KB", "1MB", "2MB", "4MB", "8MB", "16MB"
  };
  private JComboBox tfUtsIntfRateLimitIngressBurstSize = new JComboBox(utsIntfRateLimitIngressBurstSizeTList);

  private int[] utsIntfRateLimitEgressBurstSizeVList = new int[]{
    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
  };
  private String[] utsIntfRateLimitEgressBurstSizeTList = new String[]{
    fStringMap.getString("disable"), "4KB", "8KB", "16KB", "32KB", "64KB", "128KB", "256KB", "512KB", "1MB", "2MB", "4MB", "8MB", "16MB"
  };
  private JComboBox tfUtsIntfRateLimitEgressBurstSize = new JComboBox(utsIntfRateLimitEgressBurstSizeTList);

  private int[] utsIntfRateControlUplinkDuplexStatusVList = new int[]{1, 2};
  private String[] utsIntfRateControlUplinkDuplexStatusTList = new String[]{fStringMap.getString("full-duplex"), fStringMap.getString("half-duplex")};
  private JComboBox tfUtsIntfRateControlUplinkDuplexStatus = new JComboBox(utsIntfRateControlUplinkDuplexStatusTList);

  private final String utsIntfRateControlId = fStringMap
      .getString("utsIntfRateControlId")
      + " : ";

  private final String utsIntfRateControlMcastEnable = fStringMap
      .getString("utsIntfRateControlMcastEnable")
      + " : ";

  private final String utsIntfRateControlMcastLimit = fStringMap
      .getString("utsIntfRateControlMcastLimit")
      + " : ";

  private final String utsIntfRateControlBcastEnable = fStringMap
      .getString("utsIntfRateControlBcastEnable")
      + " : ";

  private final String utsIntfRateControlBcastLimit = fStringMap
      .getString("utsIntfRateControlBcastLimit")
      + " : ";

  private final String utsIntfRateControlUnicastEnable = fStringMap
      .getString("utsIntfRateControlUnicastEnable")
      + " : ";

  private final String utsIntfRateControlUnicastLimit = fStringMap
      .getString("utsIntfRateControlUnicastLimit")
      + " : ";

  private final String utsIntfRateLimitIngressBandwidth = fStringMap
      .getString("utsIntfRateLimitIngressBandwidth")
      + " : ";

  private final String utsIntfRateLimitEgressBandwidth = fStringMap
      .getString("utsIntfRateLimitEgressBandwidth")
      + " : ";

  private final String utsIntfRateControlIsolationCtrl = fStringMap
      .getString("utsIntfRateControlIsolationCtrl")
      + " : ";

//	private final String utsIntfRateControlUplinkSpeed = fStringMap
//			.getString("utsIntfRateControlUplinkSpeed")
//			+ " : ";

  private final String utsIntfRateControlVlanIngressFilter = fStringMap
      .getString("utsIntfRateControlVlanIngressFilter")
      + " : ";

  private final String utsIntfRateControlAutoNegotiation = fStringMap
      .getString("utsIntfRateControlAutoNegotiation")
      + " : ";

  private final String utsIntfRateLimitIngressBurstSize = fStringMap
      .getString("utsIntfRateLimitIngressBurstSize")
      + " : ";

  private final String utsIntfRateLimitEgressBurstSize = fStringMap
      .getString("utsIntfRateLimitEgressBurstSize")
      + " : ";
  private final String utsIntfRateControlUplinkDuplexStatus = fStringMap
      .getString("utsIntfRateControlUplinkDuplexStatus")
      + " : ";

  public IntfRateControlGEMTablePanel(IApplication app) {
    super(app);
    setModel(new IntfRateControlGEMTable(app.getSnmpProxy()));
    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(15, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsIntfRateControlId));
    baseInfoPanel.add(tfUtsIntfRateControlId);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateControlMcastEnable));
    tfUtsIntfRateControlMcastEnable.setName(fStringMap.getString("utsIntfRateControlMcastEnable"));
    baseInfoPanel.add(tfUtsIntfRateControlMcastEnable);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateControlMcastLimit));
    tfUtsIntfRateControlMcastLimit.setName(fStringMap.getString("utsIntfRateControlMcastLimit"));
    baseInfoPanel.add(tfUtsIntfRateControlMcastLimit);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateControlBcastEnable));
    tfUtsIntfRateControlBcastEnable.setName(fStringMap.getString("utsIntfRateControlBcastEnable"));
    baseInfoPanel.add(tfUtsIntfRateControlBcastEnable);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateControlBcastLimit));
    tfUtsIntfRateControlBcastLimit.setName(fStringMap.getString("utsIntfRateControlBcastLimit"));
    baseInfoPanel.add(tfUtsIntfRateControlBcastLimit);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateControlUnicastEnable));
    tfUtsIntfRateControlUnicastEnable.setName(fStringMap.getString("utsIntfRateControlUnicastEnable"));
    baseInfoPanel.add(tfUtsIntfRateControlUnicastEnable);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateControlUnicastLimit));
    tfUtsIntfRateControlUnicastLimit.setName(fStringMap.getString("utsIntfRateControlUnicastLimit"));
    baseInfoPanel.add(tfUtsIntfRateControlUnicastLimit);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateLimitIngressBandwidth));
    tfUtsIntfRateLimitIngressBandwidth.setName(fStringMap.getString("utsIntfRateLimitIngressBandwidth"));
    baseInfoPanel.add(tfUtsIntfRateLimitIngressBandwidth);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateLimitEgressBandwidth));
    tfUtsIntfRateLimitEgressBandwidth.setName(fStringMap.getString("utsIntfRateLimitEgressBandwidth"));
    baseInfoPanel.add(tfUtsIntfRateLimitEgressBandwidth);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateControlIsolationCtrl));
    tfUtsIntfRateControlIsolationCtrl.setName(fStringMap.getString("utsIntfRateControlIsolationCtrl"));
    baseInfoPanel.add(tfUtsIntfRateControlIsolationCtrl);
    baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsIntfRateControlUplinkSpeed));
//		tfUtsIntfRateControlUplinkSpeed.setName(fStringMap.getString("utsIntfRateControlUplinkSpeed"));
//		baseInfoPanel.add(tfUtsIntfRateControlUplinkSpeed);
//		baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateControlVlanIngressFilter));
    tfUtsIntfRateControlVlanIngressFilter.setName(fStringMap.getString("utsIntfRateControlVlanIngressFilter"));
    baseInfoPanel.add(tfUtsIntfRateControlVlanIngressFilter);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateControlAutoNegotiation));
    tfUtsIntfRateControlAutoNegotiation.setName(fStringMap.getString("utsIntfRateControlAutoNegotiation"));
    baseInfoPanel.add(tfUtsIntfRateControlAutoNegotiation);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateLimitIngressBurstSize));
    tfUtsIntfRateLimitIngressBurstSize.setName(fStringMap.getString("utsIntfRateLimitIngressBurstSize"));
    baseInfoPanel.add(tfUtsIntfRateLimitIngressBurstSize);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateLimitEgressBurstSize));
    tfUtsIntfRateLimitEgressBurstSize.setName(fStringMap.getString("utsIntfRateLimitEgressBurstSize"));
    baseInfoPanel.add(tfUtsIntfRateLimitEgressBurstSize);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfRateControlUplinkDuplexStatus));
    tfUtsIntfRateControlUplinkDuplexStatus.setName(fStringMap.getString("utsIntfRateControlUplinkDuplexStatus"));
    baseInfoPanel.add(tfUtsIntfRateControlUplinkDuplexStatus);
    baseInfoPanel.add(new HSpacer());

    JPanel allPanel = new JPanel();
    layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(new VSpacer());
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);
  }

  protected void initForm() {
    tfUtsIntfRateControlMcastLimit.setValueScope(0, 33550000);
    tfUtsIntfRateControlBcastLimit.setValueScope(0, 33550000);
    tfUtsIntfRateControlUnicastLimit.setValueScope(0, 33550000);
    tfUtsIntfRateLimitIngressBandwidth.setValueScope(1, 1000);
    tfUtsIntfRateLimitEgressBandwidth.setValueScope(1, 1000);
  }

  public void refresh() {

    IntfRateControlGEMTable mbean = (IntfRateControlGEMTable) getModel();

    tfUtsIntfRateControlId.setText(mbean
        .getUtsIntfRateControlModuleId().toString() + "/" +
        mbean.getUtsIntfRateControlPortId().toString());
    tfUtsIntfRateControlMcastEnable.setSelectedIndex(getIndexFromValue(utsIntfRateControlMcastEnableVList, mbean
        .getUtsIntfRateControlMcastEnable().intValue()));
    tfUtsIntfRateControlMcastLimit.setValue(mbean
        .getUtsIntfRateControlMcastLimit().intValue());
    tfUtsIntfRateControlBcastEnable.setSelectedIndex(getIndexFromValue(utsIntfRateControlBcastEnableVList, mbean
        .getUtsIntfRateControlBcastEnable().intValue()));
    tfUtsIntfRateControlBcastLimit.setValue(mbean
        .getUtsIntfRateControlBcastLimit().intValue());
    tfUtsIntfRateControlUnicastEnable.setSelectedIndex(getIndexFromValue(utsIntfRateControlUnicastEnableVList, mbean
        .getUtsIntfRateControlUnicastEnable().intValue()));
    tfUtsIntfRateControlUnicastLimit.setValue(mbean
        .getUtsIntfRateControlUnicastLimit().intValue());
    tfUtsIntfRateLimitIngressBandwidth.setValue(mbean
        .getUtsIntfRateLimitIngressBandwidth().intValue());
    tfUtsIntfRateLimitEgressBandwidth.setValue(mbean
        .getUtsIntfRateLimitEgressBandwidth().intValue());
    tfUtsIntfRateControlIsolationCtrl.setSelectedIndex(getIndexFromValue(utsIntfRateControlIsolationCtrlVList, mbean
        .getUtsIntfRateControlIsolationCtrl().intValue()));
    tfUtsIntfRateControlIsolationCtrl.setEnabled(false);
//		tfUtsIntfRateControlUplinkSpeed.setSelectedIndex(getIndexFromValue(
//				utsIntfRateControlUplinkSpeedVList, mbean
//						.getUtsIntfRateControlUplinkSpeed().intValue()));
    tfUtsIntfRateControlVlanIngressFilter
        .setSelectedIndex(getIndexFromValue(utsIntfRateControlVlanIngressFilterVList, mbean
        .getUtsIntfRateControlVlanIngressFilter()
        .intValue()));

    tfUtsIntfRateControlAutoNegotiation.setSelectedIndex(getIndexFromValue(utsIntfRateControlAutoNegotiationVList, mbean
        .getUtsIntfRateControlAutoNegotiation().intValue()));
    tfUtsIntfRateLimitIngressBurstSize.setSelectedIndex(getIndexFromValue(utsIntfRateLimitIngressBurstSizeVList, mbean
        .getUtsIntfRateLimitIngressBurstSize().intValue()));
    tfUtsIntfRateLimitEgressBurstSize.setSelectedIndex(getIndexFromValue(utsIntfRateLimitEgressBurstSizeVList, mbean
        .getUtsIntfRateLimitEgressBurstSize().intValue()));
    tfUtsIntfRateControlUplinkDuplexStatus.setSelectedIndex(getIndexFromValue(utsIntfRateControlUplinkDuplexStatusVList, mbean
        .getUtsIntfRateControlUplinkDuplexStatus().intValue()));
  }

  public void updateModel() {

    IntfRateControlGEMTable mbean = (IntfRateControlGEMTable) getModel();

    mbean.setUtsIntfRateControlMcastEnable(new Integer(utsIntfRateControlMcastEnableVList[tfUtsIntfRateControlMcastEnable
        .getSelectedIndex()]));
    mbean.setUtsIntfRateControlMcastLimit(new Integer(tfUtsIntfRateControlMcastLimit.getValue()));
    mbean.setUtsIntfRateControlBcastEnable(new Integer(utsIntfRateControlBcastEnableVList[tfUtsIntfRateControlBcastEnable
        .getSelectedIndex()]));
    mbean.setUtsIntfRateControlBcastLimit(new Integer(tfUtsIntfRateControlBcastLimit.getValue()));
    mbean.setUtsIntfRateControlUnicastEnable(new Integer(utsIntfRateControlUnicastEnableVList[tfUtsIntfRateControlUnicastEnable
        .getSelectedIndex()]));
    mbean.setUtsIntfRateControlUnicastLimit(new Integer(tfUtsIntfRateControlUnicastLimit.getValue()));
    mbean.setUtsIntfRateLimitIngressBandwidth(new Integer(tfUtsIntfRateLimitIngressBandwidth.getValue()));
    mbean.setUtsIntfRateLimitEgressBandwidth(new Integer(tfUtsIntfRateLimitEgressBandwidth.getValue()));
    mbean.setUtsIntfRateControlIsolationCtrl(new Integer(utsIntfRateControlIsolationCtrlVList[tfUtsIntfRateControlIsolationCtrl.getSelectedIndex()]));
//		mbean.setUtsIntfRateControlUplinkSpeed(new Integer(
//						utsIntfRateControlUplinkSpeedVList[tfUtsIntfRateControlUplinkSpeed.getSelectedIndex()]));
    mbean.setUtsIntfRateControlVlanIngressFilter(new Integer(utsIntfRateControlVlanIngressFilterVList[tfUtsIntfRateControlVlanIngressFilter
        .getSelectedIndex()]));

    mbean.setUtsIntfRateControlAutoNegotiation(new Integer(utsIntfRateControlAutoNegotiationVList[tfUtsIntfRateControlAutoNegotiation.getSelectedIndex()]));
    mbean.setUtsIntfRateLimitIngressBurstSize(new Integer(utsIntfRateLimitIngressBurstSizeVList[tfUtsIntfRateLimitIngressBurstSize.getSelectedIndex()]));
    mbean.setUtsIntfRateLimitEgressBurstSize(new Integer(utsIntfRateLimitEgressBurstSizeVList[tfUtsIntfRateLimitEgressBurstSize.getSelectedIndex()]));
    mbean.setUtsIntfRateControlUplinkDuplexStatus(new Integer(utsIntfRateControlUplinkDuplexStatusVList[tfUtsIntfRateControlUplinkDuplexStatus.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v)
        return i;
    }
    return 0;
  }

}
