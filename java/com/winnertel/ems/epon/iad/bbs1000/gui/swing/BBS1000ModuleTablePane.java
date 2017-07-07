package com.winnertel.ems.epon.iad.bbs1000.gui.swing;

import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.ems.epon.util.ConfigUtility;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class BBS1000ModuleTablePane extends UPanel implements ActionListener {
  private OnLineSlotFilterPanel modulePanel = null;

  private SnmpTablePane snmpPanel;

  public BBS1000ModuleTablePane(IApplication app) {
    super(app);
    init();
  }

  public void initGui() {
    modulePanel = new OnLineSlotFilterPanel(fApplication);
    modulePanel.addActionListener(this);

    setLayout(new BorderLayout());
    add(modulePanel, BorderLayout.NORTH);
  }

  public void refresh() {
    modulePanel.refresh();

    if(snmpPanel == null) {
      IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
      snmpPanel = (SnmpTablePane) composer.composeSnmpTablePane(getName());
      add(snmpPanel, BorderLayout.CENTER);
    }

    //force the table pane refresh the data.
    actionPerformed(null);
  }

  public void actionPerformed(ActionEvent e) {
    SnmpMibBean bean = (SnmpMibBean) snmpPanel.getModel();

    Object[] index = generateIndex(getName());
    if(index != null) {
      for(int i = 0; i < index.length; i++) {
        bean.setIndex(i, index[i]);
      }
    }

    bean.setRowsToFetch(getRowsToFetch(getName()));
    bean.setIndexPrefix(getIndexPrefix(getName()));

    snmpPanel.refresh();
  }

  private Object[] generateIndex(String panel)
  {
    Object[] result = null;

    if(panel.equals("Interface_table")) {
      result = new Integer[1];

      if(modulePanel.getSelectedSlotId() != 0) {
        int ifIndex = ConfigUtility.generateIfIndex(modulePanel.getSelectedSlotId() + "/1");
        result[0] = new Integer((ifIndex - 29664));
      }

      //if select all module(getSelectedSlotId() == 0), don't initialize the array,  use null to erase the index list.
    }
    else if(panel.equals("SwitchPortExtTable_Panel") || panel.equals("QosExtDscpTrustTable_Panel")) {
      result = new String[1];

      if(modulePanel.getSelectedSlotId() != 0) {
        result[0] = "" + (modulePanel.getSelectedSlotId() -1) * 4;
      }
    }
    else if(panel.equals("IntfRateControlTable_Panel") || panel.equals("Dot3OltOpmOltDataTable_Panel")) {
      result = new String[2];

      if(modulePanel.getSelectedSlotId() != 0) {
        result[0] = "" + (modulePanel.getSelectedSlotId() - 1);
        result[1] = "4";
      }
    }
    else if(panel.equals("Dot3Olt2PortDiagnosisTable_Panel")) {
      result = new Integer[3];

      if(modulePanel.getSelectedSlotId() != 0) {
        result[0] = new Integer(modulePanel.getSelectedSlotId());
        result[1] = new Integer(1);
        result[2] = new Integer(0);
      }
    }
    else if(panel.equals("QosExtCosQueueSchedTable_Panel") || panel.equals("QosExtIpPrecDscpMapTable_Panel"))
    {
      result = new String[2];

      if(modulePanel.getSelectedSlotId() != 0) {
        result[0] = "" + (modulePanel.getSelectedSlotId() -1) * 4;
        result[1] = "7";
      }
    }
    else if(panel.equals("QosExtDscpCosMapTable_Panel") || panel.equals("QosExtDscpMutMapTable_Panel"))
    {
      result = new Integer[2];

      if(modulePanel.getSelectedSlotId() != 0) {
        result[0] = (modulePanel.getSelectedSlotId()-1)*4;
        result[1] = 63;
      }
    }

    return result;
  }

  private int getRowsToFetch(String panel)
  {
    if(modulePanel.getSelectedSlotId() == 0) { //if select all module, use 0 to erase the row count.
      return 0;
    }

    if(panel.equals("SwitchPortExtTable_Panel") || panel.equals("QosExtDscpTrustTable_Panel"))
    {
      return 4;
    }

    if(panel.equals("QosExtCosQueueSchedTable_Panel")) {
      return 16;
    }

    if(panel.equals("QosExtIpPrecDscpMapTable_Panel"))
    {
      return 32;
    }

    if(panel.equals("QosExtDscpCosMapTable_Panel") || panel.equals("QosExtDscpMutMapTable_Panel"))
    {
      return 256;
    }

    return 0;
  }

  private String getIndexPrefix(String panel)
  {
    if(modulePanel.getSelectedSlotId() == 0) {//if select all module, use 0 to erase the row count.
      return null;
    }

    if(panel.equals("SwitchPortExtTable_Panel") || panel.equals("QosExtDscpTrustTable_Panel")
        || panel.equals("QosExtCosQueueSchedTable_Panel") || panel.equals("QosExtIpPrecDscpMapTable_Panel")
        || panel.equals("QosExtDscpCosMapTable_Panel") || panel.equals("QosExtDscpMutMapTable_Panel")) {
      return null;
    }

    return "" + modulePanel.getSelectedSlotId();
  }
}
