/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.NeFileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3OnuClassifiImportTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Dot3OnuClassifiImportTablePanel class.
 * Created by DVM Creator
 */
public class Dot3OnuClassifiImportTablePanel extends UPanel implements ActionListener {

  private JComboBox tfUtsDot3OnuClassifiImportClassId = new JComboBox();

  private StringTextField tfUtsDot3OnuClassifiImportFileName = new StringTextField();

  private final String utsDot3OnuClassifiImportClassId = fStringMap.getString("utsDot3OnuClassifiImportClassId") + " : ";
  private final String utsDot3OnuClassifiImportFileName = fStringMap.getString("utsDot3OnuClassifiImportFileName") + " : ";


  public Dot3OnuClassifiImportTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    for (int i = 1; i <= 32; i++) {
      tfUtsDot3OnuClassifiImportClassId.addItem("" + i);
    }
    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiImportClassId));
    tfUtsDot3OnuClassifiImportClassId.setName(fStringMap.getString("utsDot3OnuClassifiImportClassId"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiImportClassId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiImportFileName));
    tfUtsDot3OnuClassifiImportFileName.setName(fStringMap.getString("utsDot3OnuClassifiImportFileName"));
    JButton browseButton = new JButton("...");
    browseButton.setPreferredSize(new Dimension(20, 20));
    browseButton.setFocusPainted(false);
    browseButton.addActionListener(this);
    JPanel filechoose = new JPanel();
    layout = new NTLayout(1, 2, NTLayout.CENTER, NTLayout.CENTER, 5, 5);
    filechoose.setLayout(layout);
    filechoose.add(tfUtsDot3OnuClassifiImportFileName);
    filechoose.add(browseButton);
    baseInfoPanel.add(filechoose) ;
    baseInfoPanel.add(new HSpacer());

    JPanel allPanel = new JPanel();
    layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(new VSpacer());
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);
    setPreferredSize(new Dimension(300, 100));
  }

  protected void initForm() {

    tfUtsDot3OnuClassifiImportFileName.setLenScope(1, 63);


  }

  public void refresh() {
  }

  public boolean validateFrom() {
    if (tfUtsDot3OnuClassifiImportFileName.getValue().trim().equals("")) {
      String error = fStringMap.getString("Err_Profile_Name_Empty");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      return false;
    }

    return true;
  }

  public void updateModel() {
    if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new Dot3OnuClassifiImportTable(fApplication.getSnmpProxy()));

    Dot3OnuClassifiImportTable mbean = (Dot3OnuClassifiImportTable) getModel();

    if (SnmpAction.IType.ADD.equals(fCommand)) {
      mbean.setUtsDot3OnuClassifiImportClassId(new Integer((String) tfUtsDot3OnuClassifiImportClassId.getSelectedItem()));
    }

    mbean.setUtsDot3OnuClassifiImportFileName(new String(tfUtsDot3OnuClassifiImportFileName.getValue()));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

  public void actionPerformed(ActionEvent actionEvent) {
    NeFileChooser chooser = new NeFileChooser(fApplication, (JDialog) SwingUtilities.getWindowAncestor(this));
    chooser.show();
    if (chooser.getSelectedFile() != null) {
      tfUtsDot3OnuClassifiImportFileName.setValue(chooser.getSelectedFile().getAbsoluteName());
    }
  }
}
