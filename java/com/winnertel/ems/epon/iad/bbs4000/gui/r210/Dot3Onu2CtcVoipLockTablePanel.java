package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Onu2CtcVoipLockTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

public class Dot3Onu2CtcVoipLockTablePanel extends UPanel {
  private PortBitMapPanel tfUtsDot3Onu2CtcVoIPPortLock = new PortBitMapPanel(8);

  public Dot3Onu2CtcVoipLockTablePanel(IApplication app) {
    super(app);
    init();
  }

  public void initGui() {
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(1, 2, NTLayout.CENTER, NTLayout.TOP, 5,
        5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    tfUtsDot3Onu2CtcVoIPPortLock.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("utsDot3Onu2CtcVoIPPortLock")));
    baseInfoPanel.add(tfUtsDot3Onu2CtcVoIPPortLock);
    baseInfoPanel.add(new HSpacer());

    setLayout(new BorderLayout());
    add(baseInfoPanel, BorderLayout.CENTER);
  }

  protected void initForm() {

  }

  public void refresh() {
    Dot3Onu2CtcVoipLockTable mbean = (Dot3Onu2CtcVoipLockTable) getModel();

    tfUtsDot3Onu2CtcVoIPPortLock.setValue(mbean.getUtsDot3Onu2CtcVoIPPortLock());
  }

  public boolean validateFrom() {
    return true;
  }

  public void updateModel() {
    Dot3Onu2CtcVoipLockTable mbean = (Dot3Onu2CtcVoipLockTable) getModel();

    mbean.setUtsDot3Onu2CtcVoIPPortLock(tfUtsDot3Onu2CtcVoIPPortLock.getValue());
  }
}

