package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.PONProtectionMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class PONProtectionMBeanPanel extends UPanel {

    private JLabel tfUtsPonTrunckProtectionGroupId = new JLabel();
    private StringTextField tfUtsPonTrunckProtectionName = new StringTextField();
    private JLabel tfUtsPonTrunckProtectionPort1PortId = new JLabel();
    private JLabel tfUtsPonTrunckProtectionPort2PortId = new JLabel();

    private int[] utsPonTrunckProtectionRowStatusVList = new int[]{2, 1,};
    private String[] utsPonTrunckProtectionRowStatusTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsPonTrunckProtectionRowStatus = new JComboBox(utsPonTrunckProtectionRowStatusTList);

    private final String utsPonTrunckProtectionGroupId = fStringMap.getString("utsPonTrunckProtectionGroupId") + ": ";
    private final String utsPonTrunckProtectionName = fStringMap.getString("utsPonTrunckProtectionName") + ": ";
    private final String utsPonTrunckProtectionPort1PortId = fStringMap.getString("utsPonTrunckProtectionPort1PortId") + ": ";
    private final String utsPonTrunckProtectionPort2PortId = fStringMap.getString("utsPonTrunckProtectionPort2PortId") + ": ";
    private final String utsPonTrunckProtectionRowStatus = fStringMap.getString("utsPonTrunckProtectionRowStatus") + ": ";

    public PONProtectionMBeanPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionGroupId));
        tfUtsPonTrunckProtectionGroupId.setName(fStringMap.getString("utsPonTrunckProtectionGroupId"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionGroupId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionName));
        tfUtsPonTrunckProtectionName.setName(fStringMap.getString("utsPonTrunckProtectionName"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionPort1PortId));
        tfUtsPonTrunckProtectionPort1PortId.setName(fStringMap.getString("utsPonTrunckProtectionPort1PortId"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionPort1PortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionPort2PortId));
        tfUtsPonTrunckProtectionPort2PortId.setName(fStringMap.getString("utsPonTrunckProtectionPort2PortId"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionPort2PortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionRowStatus));
        tfUtsPonTrunckProtectionRowStatus.setName(fStringMap.getString("utsPonTrunckProtectionRowStatus"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionRowStatus);
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
        tfUtsPonTrunckProtectionName.setLenScope(0, 16);
    }

    public void refresh() {
        PONProtectionMBean mbean = (PONProtectionMBean) getModel();
        if (mbean == null)
            return;

        tfUtsPonTrunckProtectionGroupId.setText(mbean.getUtsPonTrunckProtectionGroupId() != null ? "" + mbean.getUtsPonTrunckProtectionGroupId() : "");
        tfUtsPonTrunckProtectionName.setText(mbean.getUtsPonTrunckProtectionName() != null ? mbean.getUtsPonTrunckProtectionName() : "");
        tfUtsPonTrunckProtectionPort1PortId.setText(mbean.getUtsPonTrunckProtectionPort1PortId() != null ? mbean.getUtsPonTrunckProtectionPort1PortId() : "");
        tfUtsPonTrunckProtectionPort2PortId.setText(mbean.getUtsPonTrunckProtectionPort2PortId() != null ? mbean.getUtsPonTrunckProtectionPort2PortId() : "");
        tfUtsPonTrunckProtectionRowStatus.setSelectedIndex(getIndexFromValue(utsPonTrunckProtectionRowStatusVList, mbean.getUtsPonTrunckProtectionRowStatus() != null ? mbean.getUtsPonTrunckProtectionRowStatus() : 2));
    }

    public void updateModel() {
        PONProtectionMBean mbean = (PONProtectionMBean) getModel();
        if (mbean == null)
            return;

        mbean.setUtsPonTrunckProtectionName(tfUtsPonTrunckProtectionName.getValue());
        mbean.setUtsPonTrunckProtectionRowStatus(utsPonTrunckProtectionRowStatusVList[tfUtsPonTrunckProtectionRowStatus.getSelectedIndex()]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}