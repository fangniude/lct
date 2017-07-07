package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNUPortTable;
import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNUServiceTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The ModEoCCNUPortTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCCNUPortTablePanel extends UPanel {

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


    private final String modEoCCNUPortCBATCardIndex = fStringMap.getString("modEoCCNUPortCBATCardIndex") + " : ";
    private final String modEoCCNUPortCNUIndex = fStringMap.getString("modEoCCNUPortCNUIndex") + " : ";
    private final String modEoCCNUPortIndex = fStringMap.getString("modEoCCNUPortIndex") + " : ";
    private final String modEoCCNUPortEN = fStringMap.getString("modEoCCNUPortEN") + " : ";
    private final String modEoCCNUPortService = fStringMap.getString("modEoCCNUPortService") + " : ";


    public ModEoCCNUPortTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCNUPortCBATCardIndex));
        baseInfoPanel.add(tfModEoCCNUPortCBATCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUPortCNUIndex));
        baseInfoPanel.add(tfModEoCCNUPortCNUIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUPortIndex));
        baseInfoPanel.add(tfModEoCCNUPortIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUPortEN));
        tfModEoCCNUPortEN.setName(fStringMap.getString("modEoCCNUPortEN"));
        baseInfoPanel.add(tfModEoCCNUPortEN);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUPortService));
        tfModEoCCNUPortService.setName(fStringMap.getString("modEoCCNUPortService"));
        baseInfoPanel.add(tfModEoCCNUPortService);
        baseInfoPanel.add(new HSpacer());

        setLayout(new BorderLayout());
        add(baseInfoPanel, BorderLayout.CENTER);
    }

    protected void initForm() {


    }

    public void refresh() {

        ModEoCCNUPortTable mbean = (ModEoCCNUPortTable) getModel();

        if (mbean == null)
            return;

        tfModEoCCNUPortCBATCardIndex.setText(mbean.getModEoCCNUPortCBATCardIndex().toString());
        tfModEoCCNUPortCNUIndex.setText(mbean.getModEoCCNUPortCNUIndex().toString());
        tfModEoCCNUPortIndex.setText(mbean.getModEoCCNUPortIndex().toString());
        tfModEoCCNUPortEN.setSelectedIndex(getIndexFromValue(modEoCCNUPortENVList, mbean.getModEoCCNUPortEN().intValue()));

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

    }

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

        mbean.setModEoCCNUPortService(selServiceId);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}