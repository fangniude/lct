package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.BoardTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class BoardTablePanel extends UPanel {

    private int[] bAdminStatusVList = new int[]{1, 2, 3,};
    private String[] bAdminStatusTList = new String[]{
            fStringMap.getString("up"), //1
            fStringMap.getString("down"), //2
            fStringMap.getString("testing"), //3
    };
    private JComboBox tfBAdminStatus = new JComboBox(bAdminStatusTList);

    private final String bDeviceIndex = fStringMap.getString("bDeviceIndex") + " : ";
    private final String bCardIndex = fStringMap.getString("bCardIndex") + " : ";
    private final String bAdminStatus = fStringMap.getString("bAdminStatus") + " : ";

    public BoardTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(bAdminStatus));
        tfBAdminStatus.setName(fStringMap.getString("bAdminStatus"));
        baseInfoPanel.add(tfBAdminStatus);
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
        BoardTable mbean = (BoardTable) getModel();
        if (mbean == null)
            return;

        tfBAdminStatus.setSelectedIndex(getIndexFromValue(bAdminStatusVList, mbean.getAdminStatus() != null ? mbean.getAdminStatus() : 0));
    }

    public void updateModel() {
        BoardTable mbean = (BoardTable) getModel();
        if (mbean == null)
            return;

        mbean.setAdminStatus(new Integer(bAdminStatusVList[tfBAdminStatus.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}