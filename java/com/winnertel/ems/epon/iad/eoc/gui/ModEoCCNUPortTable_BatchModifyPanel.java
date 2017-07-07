package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNUPortTable;
import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNUServiceTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz03446
 * Date: 2010-11-4
 * Time: 11:02:14
 */
public class ModEoCCNUPortTable_BatchModifyPanel extends UPanel {

    private JLabel tfModEoCCNUPortCBATCardIndex = new JLabel();

    private JLabel tfModEoCCNUPortCNUIndex = new JLabel();

    private JLabel tfModEoCCNUPortIndex = new JLabel();

    private int[] modEoCCNUPortENVList = new int[]{
            0, 1,};
    private String[] modEoCCNUPortENTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfModEoCCNUPortEN = new JComboBox(modEoCCNUPortENTList);


    private JComboBox tfModEoCCNUPortService = new JComboBox();


    private final String modEoCCNUPortEN = fStringMap.getString("modEoCCNUPortEN") + " : ";
    private final String modEoCCNUPortService = fStringMap.getString("modEoCCNUPortService") + " : ";


    public ModEoCCNUPortTable_BatchModifyPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        /*
        baseInfoPanel.add(new JLabel(modEoCCNUPortCBATCardIndex));
        baseInfoPanel.add(tfModEoCCNUPortCBATCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUPortCNUIndex));
        baseInfoPanel.add(tfModEoCCNUPortCNUIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUPortIndex));
        baseInfoPanel.add(tfModEoCCNUPortIndex);
        baseInfoPanel.add(new HSpacer());
         */

        baseInfoPanel.add(new JLabel(modEoCCNUPortEN));
        tfModEoCCNUPortEN.setName(fStringMap.getString("modEoCCNUPortEN"));
        baseInfoPanel.add(tfModEoCCNUPortEN);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUPortService));
        tfModEoCCNUPortService.setName(fStringMap.getString("modEoCCNUPortService"));


        baseInfoPanel.add(tfModEoCCNUPortService);
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

        ModEoCCNUServiceTable service = new ModEoCCNUServiceTable(fApplication.getSnmpProxy());
        Vector<ModEoCCNUServiceTable> serviceList = BeanService.refreshTableBean(fApplication, service);

        tfModEoCCNUPortService.removeAllItems();
        tfModEoCCNUPortService.addItem("");
        for (ModEoCCNUServiceTable one : serviceList) {
            if (one.getModEoCCNUServiceName() != null) {
                tfModEoCCNUPortService.addItem(one.getModEoCCNUServiceIndex() + "-" + one.getModEoCCNUServiceName());
            } else {
                tfModEoCCNUPortService.addItem(String.valueOf(one.getModEoCCNUServiceIndex()));
            }
        }

        ModEoCCNUPortTable mbean = (ModEoCCNUPortTable) getModel();

        if (mbean == null)
            return;

        tfModEoCCNUPortCBATCardIndex.setText(mbean.getModEoCCNUPortCBATCardIndex().toString());
        tfModEoCCNUPortCNUIndex.setText(mbean.getModEoCCNUPortCNUIndex().toString());
        tfModEoCCNUPortIndex.setText(mbean.getModEoCCNUPortIndex().toString());
        tfModEoCCNUPortEN.setSelectedIndex(getIndexFromValue(modEoCCNUPortENVList, mbean.getModEoCCNUPortEN().intValue()));
        //tfModEoCCNUPortService.setValue(mbean.getModEoCCNUPortService().intValue());

    }
    /*
    public boolean validateFrom() {

        int[] rows=getTable().getSelectedRows();

        if(rows==null || rows.length<2){

            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_NeedMultiSelect_ModEoCCNUPortTable"));
            return false;
        }

        return true;
    } */

    public void updateModel() {

        ModEoCCNUPortTable mbean = (ModEoCCNUPortTable) getModel();
        mbean.setModEoCCNUPortEN(new Integer(modEoCCNUPortENVList[tfModEoCCNUPortEN.getSelectedIndex()]));


        String selectStr = (String) tfModEoCCNUPortService.getSelectedItem();

        int selServiceId = 0;
        try {
            if (selectStr != null && !selectStr.equals("")) {
                int pos = selectStr.indexOf("-");
                if (pos > 0) {
                    selServiceId = Integer.parseInt(selectStr.substring(0, pos));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SnmpTableModel model = (SnmpTableModel) getTable().getModel();
        int[] rows = getTable().getSelectedRows();
        Vector ve = model.getDataVector();

        if (rows != null && rows.length > 0) {
            if (rows.length == 1) {  //single
                //ModEoCCNUPortTable mbean = (ModEoCCNUPortTable) getModel();
                mbean.setModEoCCNUPortService(selServiceId);
            } else {

                for (int i = 0; i < rows.length; i++) {

                    try {
                        ModEoCCNUPortTable obj = (ModEoCCNUPortTable) ve.elementAt(rows[i]);
                        obj.setModEoCCNUPortService(selServiceId);
                        //obj.modify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }

        }


        //mbean.setModEoCCNUPortEN(new Integer(modEoCCNUPortENVList[tfModEoCCNUPortEN.getSelectedIndex()]));
        //mbean.setModEoCCNUPortService(new Integer(tfModEoCCNUPortService.getValue()));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}
