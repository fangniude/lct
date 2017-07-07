package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniTrunkTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class SniTrunkTablePanel extends UPanel {

    private JLabel tfSniTrunkGroupIndex = new JLabel();

    private int[] sniTrunkGroupAdminStatusVList = new int[]{
            3, 1, 2,};
    private String[] sniTrunkGroupAdminStatusTList = new String[]{
            fStringMap.getString("testing"),
            fStringMap.getString("up"),
            fStringMap.getString("down"),
    };
    private JComboBox tfSniTrunkGroupAdminStatus = new JComboBox(sniTrunkGroupAdminStatusTList);


    private final String sniTrunkGroupIndex = fStringMap.getString("sniTrunkGroupIndex") + " : ";
    private final String sniTrunkGroupAdminStatus = fStringMap.getString("sniTrunkGroupAdminStatus") + " : ";


    public SniTrunkTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(sniTrunkGroupIndex));
        baseInfoPanel.add(tfSniTrunkGroupIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(sniTrunkGroupAdminStatus));
        tfSniTrunkGroupAdminStatus.setName(fStringMap.getString("sniTrunkGroupAdminStatus"));
        baseInfoPanel.add(tfSniTrunkGroupAdminStatus);
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
        SniTrunkTable mbean = (SniTrunkTable) getModel();

        tfSniTrunkGroupIndex.setText(mbean.getSniTrunkGroupIndex().toString());
        tfSniTrunkGroupAdminStatus.setSelectedIndex(getIndexFromValue(sniTrunkGroupAdminStatusVList, mbean.getSniTrunkGroupAdminStatus()));
    }

    public void updateModel() {
        SniTrunkTable mbean = (SniTrunkTable) getModel();

        mbean.setSniTrunkGroupAdminStatus(sniTrunkGroupAdminStatusVList[tfSniTrunkGroupAdminStatus.getSelectedIndex()]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for(int i = 0; i != list.length; i++) {
            if(list[i] == v) return i;
        }
        return 0;
    }
}
