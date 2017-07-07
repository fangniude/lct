package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.mib.QosExtCosQueueSchedTable;
import com.winnertel.ems.epon.iad.bbs1000.formatter.SwitchInterfaceIndexFormatter;

import javax.swing.*;
import java.awt.*;

/**
 * The QosExtCosQueueSchedTablePanel class. Created by DVM Creator
 */
public class QosExtCosQueueSchedTablePanel extends UPanel {
  private JLabel tfUtsMLSQosExtCosQueueSchedIntfIndex = new JLabel();
  private JLabel tfUtsMLSQosExtCosQueueSchedQueueNum = new JLabel();
  private JComboBox tfUtsMLSQosExtCosQueueSchedWeight = new JComboBox();


//  private int[] utsMLSQosExtCosQueueSchedModeVList = new int[]
//  {2, 3, 4, };
//  {2, 3, };

//  private String[] utsMLSQosExtCosQueueSchedModeTList = new String[]
//  {fStringMap.getString("sp"), fStringMap.getString("wrr"), fStringMap.getString("spandwrr"), };
//  {fStringMap.getString("sp"), fStringMap.getString("wrr"), };

//  private JComboBox tfUtsMLSQosExtCosQueueSchedMode = new JComboBox(utsMLSQosExtCosQueueSchedModeTList);

  private final String utsMLSQosExtCosQueueSchedIntfIndex = fStringMap.getString("utsMLSQosExtCosQueueSchedIntfIndex") + " : ";
  private final String utsMLSQosExtCosQueueSchedQueueNum = fStringMap.getString("utsMLSQosExtCosQueueSchedQueueNum") + " : ";
  private final String utsMLSQosExtCosQueueSchedWeight = fStringMap.getString("utsMLSQosExtCosQueueSchedWeight")+ " : ";

//  private final String utsMLSQosExtCosQueueSchedMode = fStringMap
//      .getString("utsMLSQosExtCosQueueSchedMode")
//      + " : ";

  public QosExtCosQueueSchedTablePanel(IApplication app) {
    super(app);
    setModel(new QosExtCosQueueSchedTable(app.getSnmpProxy()));

    init();
  }

  public void initGui() {
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsMLSQosExtCosQueueSchedIntfIndex));
    tfUtsMLSQosExtCosQueueSchedIntfIndex.setName(utsMLSQosExtCosQueueSchedIntfIndex);
    baseInfoPanel.add(tfUtsMLSQosExtCosQueueSchedIntfIndex);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsMLSQosExtCosQueueSchedQueueNum));
    baseInfoPanel.add(tfUtsMLSQosExtCosQueueSchedQueueNum);
    baseInfoPanel.add(new HSpacer());

//    tfUtsMLSQosExtCosQueueSchedMode.addActionListener(this);
//    baseInfoPanel.add(new JLabel(utsMLSQosExtCosQueueSchedMode));
//    tfUtsMLSQosExtCosQueueSchedMode.setName(fStringMap
//        .getString("utsMLSQosExtCosQueueSchedMode"));
//    baseInfoPanel.add(tfUtsMLSQosExtCosQueueSchedMode);
//    baseInfoPanel.add(new HSpacer());

    for (int i = 0; i <= 15; i++) {
      tfUtsMLSQosExtCosQueueSchedWeight.addItem(new Integer(i));
    }
    baseInfoPanel.add(new JLabel(utsMLSQosExtCosQueueSchedWeight));
    tfUtsMLSQosExtCosQueueSchedWeight.setName(fStringMap
        .getString("utsMLSQosExtCosQueueSchedWeight"));
    baseInfoPanel.add(tfUtsMLSQosExtCosQueueSchedWeight);
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
    QosExtCosQueueSchedTable mbean = (QosExtCosQueueSchedTable) getModel();
    tfUtsMLSQosExtCosQueueSchedIntfIndex.setText(SwitchInterfaceIndexFormatter.format(mbean.getUtsMLSQosExtCosQueueSchedIntfIndex()));
    tfUtsMLSQosExtCosQueueSchedQueueNum.setText("" + mbean.getUtsMLSQosExtCosQueueSchedQueueNum());
    tfUtsMLSQosExtCosQueueSchedWeight.setSelectedItem(mbean.getUtsMLSQosExtCosQueueSchedWeight());
//    tfUtsMLSQosExtCosQueueSchedMode.setSelectedIndex(getIndexFromValue(utsMLSQosExtCosQueueSchedModeVList, mbean.getUtsMLSQosExtCosQueueSchedMode().intValue()));
  }

  public void updateModel() {
    QosExtCosQueueSchedTable mbean = (QosExtCosQueueSchedTable) getModel();

    mbean.setUtsMLSQosExtCosQueueSchedWeight((Integer) tfUtsMLSQosExtCosQueueSchedWeight.getSelectedItem());

//    mbean.setUtsMLSQosExtCosQueueSchedMode(new Integer(utsMLSQosExtCosQueueSchedModeVList[tfUtsMLSQosExtCosQueueSchedMode.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v)
        return i;
    }
    return 0;
  }
}
