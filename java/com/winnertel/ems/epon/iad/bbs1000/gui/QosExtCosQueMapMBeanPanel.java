package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.mib.QosExtCosQueMapMBean;

import javax.swing.*;
import java.awt.*;

/**
 * The QosExtCosQueMapMBeanPanel class.
 * Created by DVM Creator
 */
public class QosExtCosQueMapMBeanPanel extends UPanel {

  private JLabel tfUtsMLSQosExtCosPriority = new JLabel();

  private IntegerTextField tfUtsMLSQosExtCosQueueNum = new IntegerTextField();


  private final String utsMLSQosExtCosPriority = fStringMap.getString("utsMLSQosExtCosPriority") + " : ";
  private final String utsMLSQosExtCosQueueNum = fStringMap.getString("utsMLSQosExtCosQueueNum") + " : ";


  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;


  public QosExtCosQueMapMBeanPanel(IApplication app) {
    super(app);
    setModel(new QosExtCosQueMapMBean(app.getSnmpProxy()));
    init();
  }

  public void initGui() {

    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_QosExtCosQueMapMBean");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsMLSQosExtCosPriority));
    baseInfoPanel.add(tfUtsMLSQosExtCosPriority);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsMLSQosExtCosQueueNum));
    tfUtsMLSQosExtCosQueueNum.setName(fStringMap.getString("utsMLSQosExtCosQueueNum"));
    baseInfoPanel.add(tfUtsMLSQosExtCosQueueNum);
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
    tfUtsMLSQosExtCosQueueNum.setValueScope(0, 3);
  }

  public void refresh() {
    QosExtCosQueMapMBean mbean = (QosExtCosQueMapMBean) getModel();
    BeanService.refreshBean(fApplication, mbean);

    tfUtsMLSQosExtCosPriority.setText(mbean.getUtsMLSQosExtCosPriority().toString());
    tfUtsMLSQosExtCosQueueNum.setValue(mbean.getUtsMLSQosExtCosQueueNum().intValue());

  }

  public void updateModel() {

    QosExtCosQueMapMBean mbean = (QosExtCosQueMapMBean) getModel();


    mbean.setUtsMLSQosExtCosQueueNum(new Integer(tfUtsMLSQosExtCosQueueNum.getValue()));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}
