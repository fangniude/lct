package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2DbaGlbTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Dot3Olt2DbaGlbTablePanel  extends UPanel {

  private JLabel tfUtsDot3OltModuleId = new JLabel();

//  private JLabel tfUtsDot3OltDeviceId = new JLabel();

  private int[] utsDot3OltDbaModeVList = new int[]{
    1, 2, 3, };
  private String[] utsDot3OltDbaModeTList = new String[]{
    fStringMap.getString("hardware-dba"),
    fStringMap.getString("software-dba"),
    fStringMap.getString("hardware-dynamic-dba"),
  };
  private JComboBox tfUtsDot3OltDbaMode = new JComboBox(utsDot3OltDbaModeTList);
  private int[] utsDot3OltDbaAlgorithmVList = new int[]{
    1, 2, 3, };
  private String[] utsDot3OltDbaAlgorithmTList = new String[]{
    fStringMap.getString("max-min"),
    fStringMap.getString("ceilingmax-min"),
    fStringMap.getString("fixedmin"),
  };
  private JComboBox tfUtsDot3OltDbaAlgorithm = new JComboBox(utsDot3OltDbaAlgorithmTList);


  private final String utsDot3OltModuleId4 = fStringMap.getString("utsDot3OltModuleId") + " : ";
//  private final String utsDot3OltDeviceId4 = fStringMap.getString("utsDot3OltDeviceId") + " : ";
  private final String utsDot3OltDbaMode = fStringMap.getString("utsDot3OltDbaMode") + " : ";
  private final String utsDot3OltDbaAlgorithm = fStringMap.getString("utsDot3OltDbaAlgorithm") + " : ";


  public Dot3Olt2DbaGlbTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OltModuleId4));
    baseInfoPanel.add(tfUtsDot3OltModuleId);
    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OltDeviceId4));
//    baseInfoPanel.add(tfUtsDot3OltDeviceId);
//    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltDbaMode));
    tfUtsDot3OltDbaMode.setName(fStringMap.getString("utsDot3OltDbaMode"));
    baseInfoPanel.add(tfUtsDot3OltDbaMode);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltDbaAlgorithm));
    tfUtsDot3OltDbaAlgorithm.setName(fStringMap.getString("utsDot3OltDbaAlgorithm"));
    baseInfoPanel.add(tfUtsDot3OltDbaAlgorithm);
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

    Dot3Olt2DbaGlbTable mbean = (Dot3Olt2DbaGlbTable) getModel();

    tfUtsDot3OltModuleId.setText(mbean.getUtsDot3OltModuleId().toString());
//    tfUtsDot3OltDeviceId.setText(mbean.getUtsDot3OltDeviceId().toString());
    tfUtsDot3OltDbaMode.setSelectedIndex(getIndexFromValue(utsDot3OltDbaModeVList, mbean.getUtsDot3OltDbaMode().intValue()));
    tfUtsDot3OltDbaAlgorithm.setSelectedIndex(getIndexFromValue(utsDot3OltDbaAlgorithmVList, mbean.getUtsDot3OltDbaAlgorithm().intValue()));

  }

  public void updateModel() {

    Dot3Olt2DbaGlbTable mbean = (Dot3Olt2DbaGlbTable) getModel();


    mbean.setUtsDot3OltDbaMode(new Integer(utsDot3OltDbaModeVList[tfUtsDot3OltDbaMode.getSelectedIndex()]));
    mbean.setUtsDot3OltDbaAlgorithm(new Integer(utsDot3OltDbaAlgorithmVList[tfUtsDot3OltDbaAlgorithm.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}
