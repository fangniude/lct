package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATCardMACCNUIsolationTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCCBATCardMACCNUIsolationTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCCBATCardMACCNUIsolationTablePanel extends UPanel {

    private JLabel tfModEoCCBATCardMACCNUIsolationIndex = new JLabel();

    private int[] modEoCCBATCardMACCNUIsolationENVList = new int[]{
            1, 0};
    private String[] modEoCCBATCardMACCNUIsolationENTList = new String[]{
            fStringMap.getString("true") + "(1)",
            fStringMap.getString("false") + "(0)",
    };
    private JComboBox tfModEoCCBATCardMACCNUIsolationEN = new JComboBox(modEoCCBATCardMACCNUIsolationENTList);


    private final String modEoCCBATCardMACCNUIsolationIndex = fStringMap.getString("modEoCCBATCardMACCNUIsolationIndex") + " : ";
    private final String modEoCCBATCardMACCNUIsolationEN = fStringMap.getString("modEoCCBATCardMACCNUIsolationEN") + " : ";


    public ModEoCCBATCardMACCNUIsolationTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCBATCardMACCNUIsolationIndex));
        baseInfoPanel.add(tfModEoCCBATCardMACCNUIsolationIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardMACCNUIsolationEN));
        tfModEoCCBATCardMACCNUIsolationEN.setName(fStringMap.getString("modEoCCBATCardMACCNUIsolationEN"));
        baseInfoPanel.add(tfModEoCCBATCardMACCNUIsolationEN);
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

        ModEoCCBATCardMACCNUIsolationTable mbean = (ModEoCCBATCardMACCNUIsolationTable) getModel();

        if (mbean == null)
            return;

        tfModEoCCBATCardMACCNUIsolationIndex.setText(mbean.getModEoCCBATCardMACCNUIsolationIndex().toString());
        tfModEoCCBATCardMACCNUIsolationEN.setSelectedIndex(getIndexFromValue(modEoCCBATCardMACCNUIsolationENVList, mbean.getModEoCCBATCardMACCNUIsolationEN().intValue()));

    }

    public void updateModel() {

        ModEoCCBATCardMACCNUIsolationTable mbean = (ModEoCCBATCardMACCNUIsolationTable) getModel();


        mbean.setModEoCCBATCardMACCNUIsolationEN(new Integer(modEoCCBATCardMACCNUIsolationENVList[tfModEoCCBATCardMACCNUIsolationEN.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}