package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.gui.CustomTablePanel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BBS4000OnuTablePane extends CustomTablePanel implements ActionListener {
    private ILogger fLogger = LoggerController.createLogger(BBS4000OnuTablePane.class);
    protected OnuFilterPanel filterPane = null;
    protected SnmpTablePane snmpPanel;
    protected JButton refreshButton;
    private RetrieveWorker retrieveWorker;

    public BBS4000OnuTablePane(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        filterPane = new OnuFilterPanel(fApplication);
        filterPane.addActionListener(this);
        refreshButton = filterPane.getRefreshButton();

        setLayout(new BorderLayout());
        add(filterPane, BorderLayout.NORTH);
    }

    protected void initForm() {
    }

    public void refresh() {
        fLogger.debug("refresh Panel:" + getName());
        if (snmpPanel == null) {
            IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
            snmpPanel = (SnmpTablePane) composer.composeSnmpTablePane(getName());
            add(snmpPanel, BorderLayout.CENTER);
        }

        filterPane.refresh();
        refreshTable();
    }

    @Override
    public void refreshTable() {
        fLogger.debug("refreshTable start");

        // if the retrieve thread is running, stop it
        if (retrieveWorker != null) {
            retrieveWorker.stop();
        }

        SnmpMibBean bean = (SnmpMibBean) snmpPanel.getModel();

        String[] index = getIndex(getName());

        if (index != null) {
            for (int i = 0; i < index.length; i++) {
                bean.setIndex(i, index[i]);
            }
        }

        bean.setIndexPrefix(getIndexPrefix());

        bean.setRowsToFetch(1);

        retrieveWorker = new RetrieveWorker(snmpPanel.getTable()) {
            @Override
            protected void beforeRetrieve() {
                refreshButton.setText(fApplication.getGlobalStringMap().getString("Cancel"));
                refreshButton.setIcon(new ImageIcon(getClass().getResource("/com/winnertel/ems/epon/iad/bbs4000/gui/swing/images/wait.gif")));
            }

            @Override
            protected void afterRetrieve() {
                refreshButton.setText(fApplication.getGlobalStringMap().getString("Refresh"));
                refreshButton.setIcon(null);
            }
        };
        retrieveWorker.execute();
    }

    public void actionPerformed(ActionEvent e) {
        if (refreshButton.getText().equals(fApplication.getGlobalStringMap().getString("Refresh"))) {
            fLogger.debug("Refresh Button clicked, now refresh the table.");
            refreshTable();
        } else if (refreshButton.getText().equals(fApplication.getGlobalStringMap().getString("Cancel"))) {
            fLogger.debug("Cancle Button clicked, now cancel retrieve data thread.");
            if (retrieveWorker != null) {
                retrieveWorker.stop();
            }
        }
    }

    private String[] getIndex(String panel) {
        String[] index = null;

        if (panel.equals("OnuSelectiveQinQ_Panel") || panel.equals("OnuFlexQinQMBean_Panel")) {
            index = new String[8];

            //fill the index.
            if (filterPane.getSelectedSlotId() != 0) {
                index[0] = "" + filterPane.getSelectedSlotId();
                index[1] = "1";

                if (filterPane.getSelectedPortId() == 0) {
                    index[2] = "1";
                    index[3] = "1";
                } else {
                    index[2] = "" + filterPane.getSelectedPortId();
                    if (filterPane.getSelectedOnuId() == 0) {
                        index[3] = "1";
                    } else {
                        index[3] = "" + filterPane.getSelectedOnuId();
                    }
                }

                index[4] = "0";
                index[5] = "0";
                index[6] = "0";
                index[7] = "0";
            }
        } else if (panel.equals("Dot3Onu2CtcClassifiAppTable_Panel")) {
            index = new String[7];

            //fill the index.
            if (filterPane.getSelectedSlotId() != 0) {
                index[0] = "" + filterPane.getSelectedSlotId();
                index[1] = "1";

                if (filterPane.getSelectedPortId() == 0) {
                    index[2] = "1";
                    index[3] = "1";
                } else {
                    index[2] = "" + filterPane.getSelectedPortId();
                    if (filterPane.getSelectedOnuId() == 0) {
                        index[3] = "1";
                    } else {
                        index[3] = "" + filterPane.getSelectedOnuId();
                    }
                }

                index[4] = "0";
                index[5] = "0";
                index[6] = "0";
            }
        } else if (panel.equals("Onu2CtcAlarmReportingTable_Panel")) {
            index = new String[4];

            //fill the index.
            if (filterPane.getSelectedSlotId() != 0) {
                index[0] = "" + filterPane.getSelectedSlotId();
                index[1] = "1";

                if (filterPane.getSelectedPortId() == 0) {
                    index[2] = "1";
                    index[3] = "1";
                } else {
                    index[2] = "" + filterPane.getSelectedPortId();
                    if (filterPane.getSelectedOnuId() == 0) {
                        index[3] = "1";
                    } else {
                        index[3] = "" + filterPane.getSelectedOnuId();
                    }
                }

                //        index[4] = "0";
                //        index[5] = "0";
            }
        } else if (panel.equals("Dot3Onu2CtcEtherPortTable_Panel") || panel.equals("OnuCtcBandCtrlTable_Panel")//
                || panel.equals("Dot3Olt2VlanStackingTable_Panel") || panel.equals("PonVlanTranslationTable_Panel")//
                || panel.equals("OnuCtcMulticastStatForUserPortTable_Panel") || panel.equals("Dot3Onu2CtcMulticastCtrlTable_Panel")//
                || panel.equals("UNIMulticastConfigure_Panel") || panel.equals("VlanModeConfigMBean_Panel") || panel.equals("VlanModeConfigMBean500_Panel")//
                || panel.equals("Dot3Onu2CtcEtherPortRateTable_Panel") || panel.equals("Dot3Onu2CtcPortsCftTable_Panel")//
                || panel.equals("Onu2CtcPotsCfgTable_Panel") || panel.equals("UNIDataServiceMBean_Panel") || panel.equals("UNIDataServiceMBean500_Panel")//
                || panel.equals("UNIIPTVServiceMBean_Panel") || panel.equals("Dot3Onu2Ctc3UniTable_Panel")//
                || panel.equals("Dot3Onu2DlConsoleTable_Panel") || panel.equals("Dot3Onu2PrivateUniOamTable_Panel")//
                || panel.equals("Dot3Onu2PrivateUniStatsTable_Panel") || panel.equals("Dot3Onu2PrivateUniFlowAclQosTable_Panel")//
                || panel.equals("Dot3Onu2CtcLpbkDetectTable_Panel")) {
            index = new String[5];

            //fill the index.
            if (filterPane.getSelectedSlotId() != 0) {
                index[0] = "" + filterPane.getSelectedSlotId();
                index[1] = "1";

                if (filterPane.getSelectedPortId() == 0) {
                    index[2] = "1";
                    index[3] = "1";
                } else {
                    index[2] = "" + filterPane.getSelectedPortId();
                    if (filterPane.getSelectedOnuId() == 0) {
                        index[3] = "1";
                    } else {
                        index[3] = "" + filterPane.getSelectedOnuId();
                    }
                }

                index[4] = "0";
            }
        } else if (panel.equals("Dot3OnuSwitchTable_Panel") || panel.equals("Dot3UnboundOnuTable_Panel") || panel.equals("OnuConfigWoOamTable_Panel")//
                || panel.equals("Dot3OltOpmOnuRxPowerTable_Panel")) {
            index = new String[3];
            if (filterPane.getSelectedSlotId() != 0) {
                index[0] = "" + filterPane.getSelectedSlotId();

                if (filterPane.getSelectedPortId() == 0) {
                    index[1] = "1";
                    index[2] = "0";
                } else {
                    index[1] = "" + filterPane.getSelectedPortId();
                    if (filterPane.getSelectedOnuId() == 0) {
                        index[2] = "0";
                    } else {
                        index[2] = "" + (filterPane.getSelectedOnuId() - 1);
                    }
                }
            }
        } else if (panel.equals("Dot3Onu2UniStaticMacTable_Panel")) {
            index = new String[6];
            if (filterPane.getSelectedSlotId() != 0) {
                index[0] = "" + filterPane.getSelectedSlotId();
                index[1] = "1";
                if (filterPane.getSelectedPortId() == 0) {
                    index[2] = "0";
                    index[3] = "0";
                } else {
                    index[2] = "" + filterPane.getSelectedPortId();
                    if (filterPane.getSelectedOnuId() == 0) {
                        index[3] = "0";
                    } else {
                        index[3] = "" + (filterPane.getSelectedOnuId());
                    }
                }
                index[4] = "0";
                index[5] = "0.0.0.0.0.0";
                //          index[6] = "0";
                //          index[7] = "0";
                //          index[8] = "0";
                //          index[9] = "0";
                //          index[10] = "0";
            }
        } else {
            index = new String[4];

            //fill the index.
            if (filterPane.getSelectedSlotId() != 0) {
                index[0] = "" + filterPane.getSelectedSlotId();
                index[1] = "1";

                if (filterPane.getSelectedPortId() == 0) {
                    index[2] = "1";
                    index[3] = "0";
                } else {
                    index[2] = "" + filterPane.getSelectedPortId();
                    if (filterPane.getSelectedOnuId() == 0) {
                        index[3] = "0";
                    } else {
                        index[3] = "" + (filterPane.getSelectedOnuId() - 1);
                    }
                }
            }
        }


        return index;
    }

    private String getIndexPrefix() {
        if (getName().equals("Dot3OnuSwitchTable_Panel") || getName().equals("Dot3UnboundOnuTable_Panel") || getName().equals("OnuConfigWoOamTable_Panel")//
                || getName().equals("Dot3OltOpmOnuRxPowerTable_Panel")) {
            if (filterPane.getSelectedSlotId() != 0) { //select all
                if (filterPane.getSelectedPortId() == 0) { //select all
                    return "" + filterPane.getSelectedSlotId();
                } else {
                    if (filterPane.getSelectedOnuId() == 0) { //select all
                        return filterPane.getSelectedSlotId() + "." + filterPane.getSelectedPortId();
                    } else {
                        return filterPane.getSelectedSlotId() + "." + filterPane.getSelectedPortId() + "." + filterPane.getSelectedOnuId();
                    }
                }
            }
        } else {
            if (filterPane.getSelectedSlotId() != 0) { //select all
                if (filterPane.getSelectedPortId() == 0) { //select all
                    return "" + filterPane.getSelectedSlotId();
                } else {
                    if (filterPane.getSelectedOnuId() == 0) { //select all
                        return filterPane.getSelectedSlotId() + ".1." + filterPane.getSelectedPortId();
                    } else {
                        return filterPane.getSelectedSlotId() + ".1." + filterPane.getSelectedPortId() + "." + filterPane.getSelectedOnuId();
                    }
                }
            }
        }
        return null;
    }

    public OnuFilterPanel getFilterPane() {
        return filterPane;
    }
}
