package com.winnertel.ems.epon.iad.bbs1000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BBS1000LTMModuleTablePane extends UPanel implements ActionListener {

    private OnLineLTMSlotFilterPanel modulePanel = null;

    private SnmpTablePane snmpPanel;

    public BBS1000LTMModuleTablePane(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        modulePanel = new OnLineLTMSlotFilterPanel(fApplication);
        modulePanel.addActionListener(this);

        setLayout(new BorderLayout());
        add(modulePanel, BorderLayout.NORTH);
        //add(snmpPanel, BorderLayout.CENTER);
    }

    public void refresh() {
        if (snmpPanel == null) {
            IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
            snmpPanel = (SnmpTablePane) composer.composeSnmpTablePane(getName());
            add(snmpPanel, BorderLayout.CENTER);
        }

        modulePanel.refresh();

        //force the table pane refresh the data.
        actionPerformed(null);
        //qosTablePanel.refresh();
    }

    public void actionPerformed(ActionEvent e) {
        SnmpMibBean bean = (SnmpMibBean) snmpPanel.getModel();

        Object[] index = generateIndex(getName());
        if (index != null) {
            for (int i = 0; i < index.length; i++) {
                bean.setIndex(i, index[i]);
            }
        }

        //bean.setRowsToFetch(getRowsToFetch(getName()));
        bean.setIndexPrefix(getIndexPrefix(getName()));

        snmpPanel.refresh();
    }

    private Object[] generateIndex(String panel) {
        Object[] result = null;

        if (panel.equals("Dot3Olt2PortTable_Panel")
                || panel.equals("Dot3Olt2PortDbaTable_Panel")
                || panel.equals("ONU_Registration")
                || panel.equals("OnuLoopbackTestTable_Panel")) {
            result = new Integer[3];

            if (modulePanel.getSelectedSlotId() != 0) {
                result[0] = new Integer(modulePanel.getSelectedSlotId());
                result[1] = new Integer(1);
                result[2] = new Integer(0);
            }
        }
        
        else if(panel.equals("OltSelectiveQinQ_Panel"))
        {
          result = new Integer[8];

          if(modulePanel.getSelectedSlotId() != 0) {
            result[0] = new Integer(modulePanel.getSelectedSlotId());
            result[1] = new Integer(1);
            result[2] = new Integer(0);
            result[3] = new Integer(0);
            result[4] = new Integer(0);
            result[5] = new Integer(0);
            result[6] = new Integer(0);
            result[7] = new Integer(0);
          }
        }
        
        else if(panel.equals("Dot3OltOpmOltDataTable_Panel"))
        {
          result = new Integer[2];

          if(modulePanel.getSelectedSlotId() != 0) {
            result[0] = new Integer(modulePanel.getSelectedSlotId());
            result[1] = new Integer(0);
          }
        }

        return result;
    }

    private int getRowsToFetch(String panel) {
        if (modulePanel.getSelectedSlotId() == 0) {//if select all module, use 0 to erase the row count.
            return 0;
        }

        return 4;
    }

    private String getIndexPrefix(String panel) {
        if (modulePanel.getSelectedSlotId() == 0) { //if select all module, use 0 to erase the row count.
            return null;
        }

        return "" + modulePanel.getSelectedSlotId();

        /*
        String prefix = null;
        String sSlotId = fApplication.getActiveDeviceManager().getProperties().getProperty(CommonConstant.CURRENT_SLOT_ID);

        if (panel.equals("Dot3Onu2CtcValidOnuMacTable_Panel") || panel.equals("PonIf2ExtStatTable_ONU_Panel") || panel.equals("OnuCtcMulticastOnlineGroupStatTable_Panel")) {
            prefix = sSlotId + ".1";
        } else if (
        */
        /* panel.equals("EthSmartQinQTable_Panel") || */
        /*
        panel.equals("EthVlanMappingTable_Panel")
                || panel.equals("Dot3OnuRTT_Panel")) {
            prefix = sSlotId + ".";
        } else if (panel.equals("Dot3Onu2CtcEtherPortTable_Panel")
                || panel.equals("OnuCtcBandCtrlTable_Panel") || panel.equals("Dot3Olt2VlanStackingTable_Panel")
                || panel.equals("Dot3Onu2CtcClassifiAppTable_Panel") || panel.equals("Dot3Onu2CtcMulticastCtrlTable_Panel")
                || panel.equals("PonVlanTranslationTable_Panel") || panel.equals("OnuCtcMulticastStatForUserPortTable_Panel")

                || "UNIMulticastConfigure_Panel".equals(panel)
                || "VlanModeConfigMBean_Panel".equals(panel)
                || "UNIVlanStackingMBean_Panel".equals(panel)
                || "Dot3Onu2CtcEtherPortRateTable_Panel".equals(panel)
                ) {
            prefix = fApplication.getActiveDeviceManager().getProperties().getProperty(CommonConstant.CURRENT_ONU_IFINDEX) + ".";
        }

        return prefix;
        */
    }

}