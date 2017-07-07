package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.mib.r300.OnuDynMultiGroupTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The OnuDynMultiGroupTablePanel class.
 * Created by DVM Creator
 */
public class OnuDynMultiGroupTablePanel extends UPanel {

  private JLabel tfOnuDynamicMultiGroupSlotNo = new JLabel();

  private JLabel tfOnuDynamicMultiGroupPortNo = new JLabel();

  private JLabel tfOnuDynamicMultiGroupLogicalPortNo = new JLabel();

  private JLabel tfOnuDynamicMultiGroupVirtualPortNo = new JLabel();

  private JLabel tfOnuDynamicMulticastGroupAddress = new JLabel();

  private JLabel tfOnuDynamicMultiGroupVlanID = new JLabel();

  private JLabel tfSourceIPAddress = new JLabel();

  private final String onuDynamicMultiGroupSlotNo = fStringMap
      .getString("onuDynamicMultiGroupSlotNo")
      + " : ";
  private final String onuDynamicMultiGroupPortNo = fStringMap
      .getString("onuDynamicMultiGroupPortNo")
      + " : ";
  private final String onuDynamicMultiGroupLogicalPortNo = fStringMap
      .getString("onuDynamicMultiGroupLogicalPortNo")
      + " : ";
  private final String onuDynamicMultiGroupVirtualPortNo = fStringMap
      .getString("onuDynamicMultiGroupVirtualPortNo")
      + " : ";
  private final String onuDynamicMulticastGroupAddress = fStringMap
      .getString("onuDynamicMulticastGroupAddress")
      + " : ";
  private final String onuDynamicMultiGroupVlanID = fStringMap
      .getString("onuDynamicMultiGroupVlanID")
      + " : ";
  private final String sourceIPAddress = fStringMap
      .getString("sourceIPAddress")
      + " : ";

  public OnuDynMultiGroupTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(onuDynamicMultiGroupSlotNo));
    baseInfoPanel.add(tfOnuDynamicMultiGroupSlotNo);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(onuDynamicMultiGroupPortNo));
    baseInfoPanel.add(tfOnuDynamicMultiGroupPortNo);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(onuDynamicMultiGroupLogicalPortNo));
    baseInfoPanel.add(tfOnuDynamicMultiGroupLogicalPortNo);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(onuDynamicMultiGroupVirtualPortNo));
    baseInfoPanel.add(tfOnuDynamicMultiGroupVirtualPortNo);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(onuDynamicMulticastGroupAddress));
    baseInfoPanel.add(tfOnuDynamicMulticastGroupAddress);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(onuDynamicMultiGroupVlanID));
    baseInfoPanel.add(tfOnuDynamicMultiGroupVlanID);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(sourceIPAddress));
    baseInfoPanel.add(tfSourceIPAddress);
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

  }

  public void refresh() {

    OnuDynMultiGroupTable mbean = (OnuDynMultiGroupTable) getModel();

    tfOnuDynamicMultiGroupSlotNo.setText(mbean.getOnuDynamicMultiGroupSlotNo()
        .toString());
    tfOnuDynamicMultiGroupPortNo.setText(mbean.getOnuDynamicMultiGroupPortNo()
        .toString());
    tfOnuDynamicMultiGroupLogicalPortNo.setText(mbean
        .getOnuDynamicMultiGroupLogicalPortNo().toString());
    tfOnuDynamicMultiGroupVirtualPortNo.setText(mbean
        .getOnuDynamicMultiGroupVirtualPortNo().toString());
    tfOnuDynamicMulticastGroupAddress.setText(mbean
        .getOnuDynamicMulticastGroupAddress());
    tfOnuDynamicMultiGroupVlanID.setText(mbean.getOnuDynamicMultiGroupVlanID()
        .toString());
    tfSourceIPAddress.setText(mbean.getSourceIPAddress());

  }

  public void updateModel() {

    OnuDynMultiGroupTable mbean = (OnuDynMultiGroupTable) getModel();

  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v)
        return i;
    }
    return 0;
  }

}
