package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.OnuLoopbackTestTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Olt2PortTablePanel class.
 * Created by DVM Creator
 */
public class OnuLoopbackTestTablePanel extends UPanel {

  private JLabel tfUtsDot3OltModuleId = new JLabel();

//  private JLabel tfUtsDot3OltDeviceId = new JLabel();

  private JLabel tfUtsDot3OltPortId = new JLabel();

  private int[] vList = new int[]{2, 1};
  private String[] tList = new String[]{
    fStringMap.getString("enable"),
    fStringMap.getString("disable")
  };

  private JComboBox tfUtsDot3OltPortLoopbackDetection = new JComboBox(tList);

  private String[] utsDot3OltPortLoopbackDetectionControlTList = new String[]{
    fStringMap.getString("true"),
    fStringMap.getString("false"),
  };
  private JComboBox tfUtsDot3OltPortLoopbackDetectionControl = new JComboBox(utsDot3OltPortLoopbackDetectionControlTList);

  private final String utsDot3OltModuleId = fStringMap.getString("utsDot3OltModuleId") + " : ";
  private final String utsDot3OltPortId = fStringMap.getString("utsDot3OltPortId") + " : ";
  private final String utsDot3OltPortLoopbackDetection = fStringMap.getString("utsDot3OltPortLoopbackDetection") + " : ";
  private final String utsDot3OltPortLoopbackDetectionControl = fStringMap.getString("utsDot3OltPortLoopbackDetectionControl") + " : ";

  public OnuLoopbackTestTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OltModuleId));
    baseInfoPanel.add(tfUtsDot3OltModuleId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltPortId));
    baseInfoPanel.add(tfUtsDot3OltPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltPortLoopbackDetection));
    tfUtsDot3OltPortLoopbackDetection.setName(fStringMap.getString("utsDot3OltPortLoopbackDetection"));
    baseInfoPanel.add(tfUtsDot3OltPortLoopbackDetection);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsDot3OltPortLoopbackDetectionControl));
    tfUtsDot3OltPortLoopbackDetectionControl.setName(fStringMap.getString("utsDot3OltPortLoopbackDetectionControl"));
    baseInfoPanel.add(tfUtsDot3OltPortLoopbackDetectionControl);
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

  public void refresh() {
    OnuLoopbackTestTable mbean = (OnuLoopbackTestTable) getModel();

    tfUtsDot3OltModuleId.setText(mbean.getUtsDot3OltModuleId().toString());
    tfUtsDot3OltPortId.setText(mbean.getUtsDot3OltPortId().toString());
    tfUtsDot3OltPortLoopbackDetection.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsDot3OltPortLoopbackDetection().intValue()));
    tfUtsDot3OltPortLoopbackDetectionControl.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsDot3OltPortLoopbackDetectionControl().intValue()));

  }

  public boolean validateFrom()
  {
    return true;
  }

  public void updateModel() {
    OnuLoopbackTestTable mbean = (OnuLoopbackTestTable) getModel();

    mbean.setUtsDot3OltPortLoopbackDetection(new Integer(vList[tfUtsDot3OltPortLoopbackDetection.getSelectedIndex()]));
    mbean.setUtsDot3OltPortLoopbackDetectionControl(new Integer(vList[tfUtsDot3OltPortLoopbackDetectionControl.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }
}
