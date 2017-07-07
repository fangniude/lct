package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.event.UEvent;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.IMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.gui.GuiStyle;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import java.util.Vector;

public final class SnmpTablePane extends UPanel {

    private Vector fButtonList = null;

    private SnmpTable fTable = null;

    public SnmpTablePane(IApplication app) {
        super(app);
        init();
    }


    protected void initGui() {
        setLayout(new BorderLayout());
    }

    private JScrollPane initTablePane() {
        return new JScrollPane(fTable);
    }

    private JPanel initControlPane(boolean enableClosed, GuiStyle aStyle) {
        if (fButtonList == null) {
            return new JPanel();
        }
        int buttonCount = fButtonList.size();
        JPanel panel = new JPanel(aStyle.getButtonsLayout());
        //JPanel panel = new JPanel( new GridLayout(1, buttonCount, 5, 5) );
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
        return panel;
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
    
    public Vector getButtonList(){
    	return fButtonList;
    }


    public void setTable(SnmpTable aTable) {
    	//this is a not good Solution
//    	TableFilterHeader filterHeader = new TableFilterHeader(aTable, AutoChoices.ENABLED);
    	fTable = aTable;
    	SnmpTableModel sm = (SnmpTableModel)fTable.getModel();
    	TableModelListener[] tl = sm.getTableModelListeners();
    	for (int i = 0; i < tl.length; i++) {
    		fTable.getModel().removeTableModelListener(tl[i]);
		}
 
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
        
        for (int i = 1; i <= tl.length; i++) {
        	fTable.getModel().addTableModelListener(tl[tl.length-i]);
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
        for (int x = 0; x < fButtonList.size(); x++) {
            SnmpTableButton tableButton = (SnmpTableButton) fButtonList.get(x);
            String tType = tableButton.getType();
            if (tType.equals(SnmpAction.IType.DELETE) ||
                    tType.equals(SnmpAction.IType.MODIFY)) {
                tableButton.getAction().setEnabled(enable);
            }
        }
    }

    public void refresh() {
        new RefreshAllCommand(fApplication, fTable).execute();
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

                SnmpMibBean one = bean.encode(property);

                if (one == null) return;

                switch (event.getType()) {
                    case 0://refresh.
                        int count = model.getRowCount();
                        for (int i = 0; i < count; i++) {
                            if (model.getRow(i).equals(one)) {
                                model.setRow(i, one);
                                break;
                            }
                        }
                        break;
                    case 1://add
                        break;
                    case 2://modify
                        break;
                    case 3:
                        break;//delete
                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
