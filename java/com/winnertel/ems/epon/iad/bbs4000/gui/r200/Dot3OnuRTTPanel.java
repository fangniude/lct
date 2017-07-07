package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3OnuRTT;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dot3OnuRTTPanel extends UPanel implements ActionListener {
  private JCheckBox minCheckBox = new JCheckBox(fStringMap.getString("Min"));
  private IntegerTextField minField = new IntegerTextField();

  private JCheckBox maxCheckBox = new JCheckBox(fStringMap.getString("Max"));
  private IntegerTextField maxField = new IntegerTextField();


  public Dot3OnuRTTPanel(IApplication app) {
    super(app);
    init();
  }

  public void initGui() {
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    minCheckBox.setSelected(true);
    minCheckBox.addActionListener(this);
    baseInfoPanel.add(minCheckBox);
    baseInfoPanel.add(minField);
    baseInfoPanel.add(new HSpacer());

    maxCheckBox.setSelected(true);
    maxCheckBox.addActionListener(this);
    baseInfoPanel.add(maxCheckBox);
    baseInfoPanel.add(maxField);
    baseInfoPanel.add(new HSpacer());


    setLayout(new BorderLayout());
    add(baseInfoPanel, BorderLayout.CENTER);
  }

  protected void initForm() {
    minField.setValue(0);
    maxField.setValue(100);
  }

  public void refresh() {
  }

  public void updateModel() {
    Dot3OnuRTT bean = (Dot3OnuRTT)getModel();

    if(minCheckBox.isSelected() && !minField.getText().equals("")) {
      bean.setMin(minField.getValue());
    }else {
      bean.setMin(null);
    }

    if(maxCheckBox.isSelected() && !minField.getText().equals("")) {
      bean.setMax(maxField.getValue());
    } else {
      bean.setMax(null);
    }
  }

  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == minCheckBox) {
      minField.setEnabled(minCheckBox.isSelected());
    }else if(e.getSource() == maxCheckBox) {
      maxField.setEnabled(maxCheckBox.isSelected());
    }
  }
}
