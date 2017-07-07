/*
 * Copyright (c) 2002-2003 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.gui.r200.action.ResetMultiOnuAction;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.OnuFilterPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.OnuMonitorTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.event.UEvent;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.IMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.gui.GuiStyle;
import com.winnertel.em.standard.snmp.action.ExportAction;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpCloseButton;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpField;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableButton;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.ems.epon.iad.util.GuiUtils;
import com.winnertel.inms.topodb.UTopoAPI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

/**
 * The OnuMonitorTablePanel class.
 */
public final class OnuMonitorTablePanel extends UPanel implements ActionListener {

    OnuFilterPanel filterPane = null;
    private Vector fButtonList = null;
    private SnmpTable fTable = null;
    private String neName = null;
    private JCheckBox isFilterEmptyMac=new JCheckBox(getString("isFilterEmptyMac"));
    public OnuMonitorTablePanel(IApplication app) {
        super(app);
        init();
    }

    protected void initGui() {
        try {
            neName = UTopoAPI.getAPI().getNodeNameByIP(fApplication.getSnmpProxy().getTargetHost());
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }

//        neName = ClientUtility.getNeNameByNeIp(fApplication.getSnmpProxy().getTargetHost());

        filterPane = new OnuFilterPanel(fApplication);
        filterPane.addActionListener(this);
        setLayout(new BorderLayout());
        add(filterPane, BorderLayout.NORTH);

        Vector vField = new Vector();
        SnmpField field = new SnmpField("onuLabel", getString("onuLabel"), null, (byte) 0, null, null);
        field.setMibProperty("onuLabel");
        vField.add(field);

        //NMS00071174
        field = new SnmpField("utsDot3Onu2CtcOnuMacAddr", getString("utsDot3Onu2CtcOnuMacAddr"), null, (byte) 0, null, null);
        field.setMibProperty("utsDot3Onu2CtcOnuMacAddr");
        vField.add(field);

        field = new SnmpField("utsDot3Onu2LoidAuthLoid", getString("utsDot3Onu2LoidAuthLoid"), null, (byte) 0, null, null);
        field.setMibProperty("utsDot3Onu2LoidAuthLoid");
        vField.add(field);

        //field = new SnmpField("ifOnuIndex", getString("ifOnuIndex"), null, (byte)0, null, new IfIndexFormatter(fApplication));
        field = new SnmpField("ifOnuIndex", getString("ifOnuIndex"), null, (byte) 0, null, null);
        field.setMibProperty("ifOnuIndex");
        vField.add(field);

        field = new SnmpField("onuType", getString("utsDot3OnuHwType"), null, (byte) 0, null, null);
        field.setMibProperty("onuType");
        vField.add(field);

        field = new SnmpField("switchIp", getString("switchIp"), null, (byte) 4, null, null);
        field.setMibProperty("switchIp");
        vField.add(field);

        HashMap map = new HashMap();
        map.put("1", getString("register"));
        map.put("2", getString("deregister"));
        field = new SnmpField("utsDot3Onu2CtcRegisterStatus", getString("utsDot3Onu2CtcRegisterStatus"), null, (byte) 0, map, null);
        field.setMibProperty("utsDot3Onu2CtcRegisterStatus");
        vField.add(field);

        map = new HashMap();
        map.put("1", getString("up"));
        map.put("2", getString("down"));
        field = new SnmpField("utsDot3Onu2CtcLinkStatus", getString("utsDot3Onu2CtcLinkStatus"), null, (byte) 0, map, null);
        field.setMibProperty("utsDot3Onu2CtcLinkStatus");
        vField.add(field);

        map = new HashMap();
        map.put("1", getString("on"));
        map.put("2", getString("off"));
        field = new SnmpField("utsDot3Onu2CtcPowerStatus", getString("utsDot3Onu2CtcPowerStatus"), null, (byte) 0, map, null);
        field.setMibProperty("utsDot3Onu2CtcPowerStatus");
        vField.add(field);

        OnuMonitorTable bean = new OnuMonitorTable(fApplication.getSnmpProxy());
        SnmpTable table = new SnmpTable(new SnmpTableModel(vField, bean, null, false));
        table.setMultipleSelection(true);
        table.setName(getString("ONU_Monitor"));

        setTable(table);

        isFilterEmptyMac.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
        
        Vector btnList = new Vector(4);
        //pass the refrence not the colon of the mib bean to panel directly.
        SnmpAction modifyAction = new SnmpAction(fApplication) {
            public void executeAction(ActionEvent e) {
                int selectedRow = fTable.getSelectedRow();
                if (selectedRow == -1) {
                    MessageDialog.showSelectRowDialog(fApplication);
                    return;
                }

                // no panel for modify command, just return
                if (fPanel == null && fDialog == null) {
                    return;
                }

                if (fDialog != null) {
                    SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
                    SnmpMibBean bean = tableModel.getRow(selectedRow);

                    //added by zengtian 2011/9/30 for MR:NMS00071173 -- begin
                    if (((OnuMonitorTable) bean).getUtsDot3Onu2CtcRegisterStatus() != 1) {
                        JOptionPane.showMessageDialog(null, getString("Err_Only_registered_ONU_Edited"), getString("warning"), JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    //added by zengtian 2011/9/30 for MR:NMS00071173 -- end

                    SnmpDialog dlg = (SnmpDialog) fDialog;
                    dlg.setMask(SnmpDialog.STYLE_REFRESH, true);
                    dlg.getPanel().setModel(bean);
                    dlg.getPanel().setTable(fTable);
                    dlg.getPanel().refresh();
                    fDialog.pack();
                    fDialog.show();

                    tableModel.setRow(selectedRow, bean);
                }
            }
        };
        modifyAction.putValue(BaseAction.ID, "Onu_Monitor_Modify");
        UPanel panel = new ModifyOnuLabelPanel(fApplication);
        SnmpDialog dlg = new SnmpDialog(fApplication, getString("Modify"), "Modify", "O|C");
        dlg.setPanel(panel);
        dlg.setTable(table);
        SnmpTableButton modifyButton = new SnmpTableButton("Modify", getString("Modify"), modifyAction);
        modifyButton.setDialog(dlg);
        btnList.add(modifyButton);

        SnmpAction resetAction = new ResetMultiOnuAction(fApplication);
        resetAction.putValue(BaseAction.ID, "Onu_Monitor_Reset");
        resetAction.setPanel(this);
        resetAction.setTable(fTable);
        SnmpTableButton resetButton = new SnmpTableButton("Custom", getString("Reset"), resetAction); 

        btnList.add(resetButton);

        SnmpAction action = new SnmpAction(fApplication) {
            public void executeAction(ActionEvent e) throws Exception {
                OnuMonitorTablePanel.this.refresh();
            }
        };
        action.setPanel(this);
        action.setTable(fTable);
        SnmpTableButton btRefresh = new SnmpTableButton(SnmpAction.IType.REFRESH, getString("Refresh"), action);
        
//        Properties tProperties = ClientUtility.getNePropertiesByNeName(neName);
//        String neType = "";
//        String neVersion = "";
//        if (tProperties != null) {
//            neType = tProperties.getProperty("neType", "FBW5000");
//            //neVersion = tProperties.getProperty("swVersion", "3.1.1");
//            try {
//                neVersion = SnmpUtility.getNeTotalVersion(neType, fApplication.getSnmpProxy().getTargetHost(), fApplication.getSnmpProxy().getTargetPort(),
//                		fApplication.getSnmpProxy().getReadCommunity());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

//        Vector switchVector = null;
//        if (!((neType.equals("FBW5000") && neVersion.startsWith("3.1") && DiscoveryUtility.isNeVersionGreaterThan(neVersion, "3.1.1.11"))
//                || (neType.equals("FBW5000") && neVersion.startsWith("2.2") && DiscoveryUtility.isNeVersionGreaterThan(neVersion, "2.2.1.6")))) {
//        	btnList.add(btRefresh);
//        }

        action = new ExportAction(fApplication);
        action.setPanel(this);
        action.setTable(fTable);
        SnmpTableButton btExport = new SnmpTableButton(SnmpAction.IType.EXPORT, getString("Export"), action);
        action.putValue(BaseAction.ID, "Onu_Monitor_Export");
        btnList.add(btExport);

        setButtonList(btnList, false, GuiStyle.getDefaultGuiStyle());
    }

    private JScrollPane initTablePane() {
        return new JScrollPane(fTable);
    }

    private JPanel initControlPane(boolean enableClosed, GuiStyle aStyle) {
        if (fButtonList == null) {
            return new JPanel();
        }

        int buttonCount = fButtonList.size();
        JPanel panel0 = new JPanel(new BorderLayout());
        JPanel panel = new JPanel(aStyle.getButtonsLayout());
        panel0.add(isFilterEmptyMac,BorderLayout.WEST);
        panel0.add(panel,BorderLayout.CENTER);
        for (int i = 0; i < buttonCount; i++) {
            SnmpTableButton tableButton = (SnmpTableButton) fButtonList.get(i);
            String text = tableButton.getText();
            if (text == null) {
                text = fApplication.getGlobalStringMap().getString(tableButton.getType());
            }
            JButton button = new JButton();
            SnmpAction action = tableButton.getAction();
            if (action != null) {
                action.setTable(fTable);
                action.setDialog(tableButton.getDialog());
                action.setPanel(this);
                button.setAction(action);
                button.setText(text);
            }
            panel.add(button);
        }
        enableButtonOperation(false);

        if (enableClosed) {
            SnmpCloseButton btnClose = new SnmpCloseButton(fApplication, this);
            panel.add(btnClose);
        }

        return panel0;
    }

    public IMibBean getModel() {
        if (fTable != null) {
            SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
            if (tableModel != null) {
                return tableModel.getMibBean();
            }
        }

        return null;
    }

    public void setButtonList(Vector aButtonList, boolean enableClosed, GuiStyle aStyle) {
        if (aButtonList != null && aButtonList.size() > 0) {
            fButtonList = aButtonList;
            JPanel controlPane = initControlPane(enableClosed, aStyle);
            JPanel p = new JPanel(new BorderLayout());
            p.add(controlPane, BorderLayout.CENTER);
            add(p, BorderLayout.SOUTH);
        }
    }

    public void setTable(SnmpTable aTable) {
        fTable = aTable;

        // double click on a row will bring up the modify dialog
        fTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
                    // programmatically perform a "click" on modify button
                    Action act = findAction(SnmpAction.IType.MODIFY);
                    if (act != null) {
                        act.actionPerformed(null);
                    }
                }
            }
        });

        fTable.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                enableButtonOperation(fTable.getRowCount() != 0);
                if (fTable.getRowCount() != 0) {
                    if (e != null && e.getType() == TableModelEvent.UPDATE) {
                        fTable.getSelectionModel().setSelectionInterval(fTable.getMarkedRow(), fTable.getMarkedRow());
                    }
                }
            }
        });

        fTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                SnmpAction act = findAction(SnmpAction.IType.MODIFY);
                if (act != null) {
                    UDialog dlg = act.getDialog();
                    if (dlg != null && dlg instanceof SnmpDialog) {
                        UPanel panel = ((SnmpDialog) dlg).getPanel();
                        if (fTable.getSelectedRowCount() == 1) {
                            panel.setCommand(SnmpAction.IType.MODIFY);
                        } else {
                            panel.setCommand(SnmpAction.IType.MODIFY_BATCH);
                        }
                    }
                }
            }
        });

        int columnCount = fTable.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            String colName = fTable.getColumnName(i);
            //if (getString("utsDot3Onu2CtcRegisterStatus").equalsIgnoreCase(colName)) {
            fTable.getColumn(fTable.getColumnName(i)).setCellRenderer(new TestDefaultTableCellRenderer(neName));
            //    break;
            //}
        }

        add(initTablePane(), BorderLayout.CENTER);
    }

    public SnmpTable getTable() {
        return fTable;
    }

    public void enableButtonOperation(boolean enable) {
        if (fButtonList == null) {
            return;
        }

        for (Object aFButtonList : fButtonList) {
            SnmpTableButton tableButton = (SnmpTableButton) aFButtonList;
            String tType = tableButton.getType();
            if (tType.equals(SnmpAction.IType.DELETE) || tType.equals(SnmpAction.IType.MODIFY)) {
                tableButton.getAction().setEnabled(enable);
            }
        }
    }

    public void refresh() {
        filterPane.refresh();
        actionPerformed(null);
    }

    public void actionPerformed(ActionEvent a) {

        BBS4000NE ne = new BBS4000NE(fApplication);
        int portCount = ne.getPortCount();
        int splitRatio = ne.getPonSplitRatio();

        Vector all = new Vector();
        SnmpMibBean bean = (SnmpMibBean) getModel();

        if (filterPane.getSelectedSlotId() == 0) { //select all
            int[] cardId = filterPane.getAllSlotId();

            bean.setIndex(0, null);
            bean.setIndex(1, null);
            bean.setIndex(2, null);
            bean.setIndex(3, null);

            bean.setIndexPrefix(null);

            for (int aCardId : cardId) {
                for (int j = 0; j < portCount; j++) {
                    for (int k = 0; k < splitRatio; k++) {
                        all.add(compose(aCardId, j + 1, k + 1));
                    }
                }
            }
        } else {
            if (filterPane.getSelectedPortId() == 0) { //select all
                bean.setIndex(0, filterPane.getSelectedSlotId());
                bean.setIndex(1, 1);
                bean.setIndex(2, 0);
                bean.setIndex(3, 0);

                bean.setIndexPrefix("" + filterPane.getSelectedSlotId());

                for (int j = 0; j < portCount; j++) {
                    for (int k = 0; k < splitRatio; k++) {
                        all.add(compose(filterPane.getSelectedSlotId(), j + 1, k + 1));
                    }
                }
            } else {
                if (filterPane.getSelectedOnuId() == 0) { //select all
                    bean.setIndex(0, filterPane.getSelectedSlotId());
                    bean.setIndex(1, 1);
                    bean.setIndex(2, filterPane.getSelectedPortId());
                    bean.setIndex(3, 0);

                    bean.setIndexPrefix("" + filterPane.getSelectedSlotId() + ".1." + filterPane.getSelectedPortId());

                    for (int k = 0; k < splitRatio; k++) {
                        all.add(compose(filterPane.getSelectedSlotId(), filterPane.getSelectedPortId(), k + 1));
                    }
                } else {
                    bean.setIndex(0, filterPane.getSelectedSlotId());
                    bean.setIndex(1, 1);
                    bean.setIndex(2, filterPane.getSelectedPortId());
                    bean.setIndex(3, filterPane.getSelectedOnuId() - 1);

                    bean.setIndexPrefix(filterPane.getSelectedSlotId() + ".1." + filterPane.getSelectedPortId() + "." + filterPane.getSelectedOnuId());

                    all.add(compose(filterPane.getSelectedSlotId(), filterPane.getSelectedPortId(), filterPane.getSelectedOnuId()));
                }
            }
        }

        try {
//            OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//            Map map = onuMgmtMgr.getOnuLabelMap(neName);
            Map map = new HashMap();

            Vector v = BeanService.refreshTableBean(fApplication, bean);
            if (v != null && v.size() != 0) {
                for (Object aV : v) {
                    OnuMonitorTable onu = (OnuMonitorTable) aV;
                    if (onu == null)
                        continue;

                    onu.setUtsDot3Onu2CtcLinkStatus(2);
                    onu.setUtsDot3Onu2CtcPowerStatus(2);

                    if (onu.getUtsDot3Onu2CtcRegisterStatus() == 1) { //register
                        onu.setUtsDot3Onu2CtcLinkStatus(1);
                        onu.setUtsDot3Onu2CtcPowerStatus(1);
                    }

                    if (onu.getSwitchIp() == null || onu.getSwitchIp().trim().length() == 0)
                        onu.setSwitchIp("0.0.0.0");
                    if (onu.getUtsDot3Onu2CtcOnuMacAddr() == null || onu.getUtsDot3Onu2CtcOnuMacAddr().trim().length() == 0)
                        onu.setUtsDot3Onu2CtcOnuMacAddr("00:00:00:00:00:00");

                    for (int j = 0; j < all.size(); j++) {
                        if (all.get(j).equals(onu)) {
                            String mac = onu.getUtsDot3Onu2CtcOnuMacAddr();
                            mac = mac.replaceAll(":", "-");
                            mac = mac.toLowerCase();
                            String key = new StringBuilder(neName).append(mac).toString();
                            onu.setOnuLabel((String) map.get(key));
                            all.set(j, onu);
                            //break;
                            continue;
                        } else {
                            OnuMonitorTable one = (OnuMonitorTable) all.get(j);
                            if (one.getUtsDot3Onu2CtcOnuMacAddr() == null || one.getUtsDot3Onu2CtcOnuMacAddr().trim().length() == 0)
                                one.setUtsDot3Onu2CtcOnuMacAddr("00:00:00:00:00:00");
                            if (one.getSwitchIp() == null || one.getSwitchIp().trim().length() == 0)
                                one.setSwitchIp("0.0.0.0");
                        }
                    }
                }
            } else {
                for (Object aV : all) {
                    OnuMonitorTable onu = (OnuMonitorTable) aV;
                    onu.setUtsDot3Onu2CtcOnuMacAddr("00:00:00:00:00:00");
                }
            }
            
            if(isFilterEmptyMac.isSelected()){
            	//remove all "00:00:00:00:00:00" in result
            	int i=0;
                while(true){
                	if(i>=all.size())break;
                    OnuMonitorTable onu = (OnuMonitorTable)all.get(i);;
                    if("00:00:00:00:00:00".equals(onu.getUtsDot3Onu2CtcOnuMacAddr())){
                    	all.remove(i);
                    }
                    else{
                    	i++;
                    }
            	}
            }
            SnmpTableModel model = (SnmpTableModel) fTable.getModel();
            model.setDataVector(all);
            fTable.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private OnuMonitorTable compose(int cardId, int portId, int onuId) {
        OnuMonitorTable onu = new OnuMonitorTable(fApplication.getSnmpProxy());
        onu.setUtsDot3Onu2CtcModuleId(cardId);
        onu.setUtsDot3Onu2CtcDeviceId(1);
        onu.setUtsDot3Onu2CtcPortId(portId);
        onu.setUtsDot3Onu2CtcLogicalPortId(onuId);
        onu.setUtsDot3Onu2CtcRegisterStatus(2); //deregister
        onu.setUtsDot3Onu2CtcLinkStatus(2);
        onu.setUtsDot3Onu2CtcPowerStatus(2);

        return onu;
    }

    private SnmpAction findAction(String aActionType) {
        if (fButtonList == null || fButtonList.size() == 0) {
            return null;
        }

        for (int i = 0; i < fButtonList.size(); i++) {
            SnmpTableButton snmpTableButton = (SnmpTableButton) fButtonList.elementAt(i);
            if (aActionType.equals(snmpTableButton.getType())) {
                return snmpTableButton.getAction();
            }
        }

        return null;
    }

    public void update(UEvent event) {
        try {
            Object obj = event.getSource();
            if (obj instanceof Properties) {
                Properties property = (Properties) event.getSource();
                SnmpTableModel model = (SnmpTableModel) fTable.getModel();
                SnmpMibBean bean = model.getMibBean();

                OnuMonitorTable one = (OnuMonitorTable) bean.encode(property);
                if (one == null)
                    return;

                switch (event.getType()) {
                    case 0: //refresh.
                        int count = model.getRowCount();
                        for (int i = 0; i < count; i++) {
                            if (model.getRow(i).equals(one)) {
                                OnuMonitorTable row = (OnuMonitorTable) model.getRow(i);
                                if (row == null)
                                    continue;

                                if (one.getUtsDot3Onu2SerialNumber() != null)
                                    row.setUtsDot3Onu2SerialNumber(one.getUtsDot3Onu2SerialNumber());
                                if (one.getUtsDot3Onu2CtcRegisterStatus() != null)
                                    row.setUtsDot3Onu2CtcRegisterStatus(one.getUtsDot3Onu2CtcRegisterStatus());
                                if (one.getUtsDot3Onu2CtcLinkStatus() != null)
                                    row.setUtsDot3Onu2CtcLinkStatus(one.getUtsDot3Onu2CtcLinkStatus());
                                if (one.getUtsDot3Onu2CtcPowerStatus() != null)
                                    row.setUtsDot3Onu2CtcPowerStatus(one.getUtsDot3Onu2CtcPowerStatus());

                                model.setRow(i, row);
                                fTable.updateUI();

                                break;
                            }
                        }
                        break;
                    case 1: //add
                        break;
                    case 2: //modify
                        break;
                    case 3:
                        break; //delete
                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private class TestDefaultTableCellRenderer extends DefaultTableCellRenderer {

        public String neName;

        public TestDefaultTableCellRenderer(String nename) {
            this.neName = nename;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (fTable == null)
                return null;

            JLabel lab = null;
            try {
                lab = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                SnmpTableModel model = (SnmpTableModel) fTable.getModel();
                if (model == null)
                    return null;

                OnuMonitorTable rowValue = (OnuMonitorTable) model.getRow(row);
                if (rowValue == null)
                    return null;

                GuiUtils.markColor4OnuLabel(lab, rowValue.getUtsDot3Onu2CtcStatus(), rowValue.getRegisteredever(), rowValue.isDyingGasp());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return lab;
        }

    }

    public String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fStringMap != null ? fStringMap.getString(s) : s;
    }

}