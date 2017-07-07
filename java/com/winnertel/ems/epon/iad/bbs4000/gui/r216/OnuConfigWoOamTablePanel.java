/**
 * Created by Zhou Chao, 2009/7/30
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r216;

import com.winnertel.ems.epon.iad.bbs4000.mib.r216.OnuConfigWoOamTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OnuConfigWoOamTablePanel extends UPanel {

    //private JLabel tfUtsOnuSlotId = new JLabel();
    //private JLabel tfUtsOnuPortId = new JLabel();
    //private JLabel tfUtsOnuLogicalPortId = new JLabel();

    private int[] utsOnuCtcExtOamEnableVList = new int[]{1, 2,};
    private String[] utsOnuCtcExtOamEnableTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable"),
    };
    private JComboBox tfUtsOnuCtcExtOamEnable = new JComboBox(utsOnuCtcExtOamEnableTList);

    private StringTextField tfUtsOnuDescription = new StringTextField();

    //private int[] utsOnuAdminStatusVList = new int[]{1, 2, 3,};
    //private String[] utsOnuAdminStatusTList = new String[]{
    //        fStringMap.getString("up"),
    //        fStringMap.getString("down"),
    //        fStringMap.getString("testing"),
    //};
    //private JComboBox tfUtsOnuAdminStatus = new JComboBox(utsOnuAdminStatusTList);

    //private final String utsOnuSlotId = fStringMap.getString("utsOnuSlotId") + ": ";
    //private final String utsOnuPortId = fStringMap.getString("utsOnuPortId") + ": ";
    //private final String utsOnuLogicalPortId = fStringMap.getString("utsOnuLogicalPortId") + ": ";
    private final String utsOnuCtcExtOamEnable = fStringMap.getString("utsOnuCtcExtOamEnable") + ": ";
    private final String utsOnuDescription = fStringMap.getString("utsOnuDescription") + ": ";
    //private final String utsOnuAdminStatus = fStringMap.getString("utsOnuAdminStatus") + ": ";

    public OnuConfigWoOamTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsOnuCtcExtOamEnable));
        tfUtsOnuCtcExtOamEnable.setName(fStringMap.getString("utsOnuCtcExtOamEnable"));
        baseInfoPanel.add(tfUtsOnuCtcExtOamEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsOnuDescription));
        tfUtsOnuDescription.setName(fStringMap.getString("utsOnuDescription"));
        baseInfoPanel.add(tfUtsOnuDescription);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsOnuAdminStatus));
        //tfUtsOnuAdminStatus.setName(fStringMap.getString("utsOnuAdminStatus"));
        //baseInfoPanel.add(tfUtsOnuAdminStatus);
        //baseInfoPanel.add(new HSpacer());

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
        OnuConfigWoOamTable mbean = (OnuConfigWoOamTable) getModel();
        if (mbean == null)
            return;

        tfUtsOnuCtcExtOamEnable.setSelectedIndex(getIndexFromValue(utsOnuCtcExtOamEnableVList, mbean.getUtsOnuCtcExtOamEnable()));
        tfUtsOnuDescription.setValue(mbean.getUtsOnuDescription());
        //tfUtsOnuAdminStatus.setSelectedIndex(getIndexFromValue(utsOnuAdminStatusVList, mbean.getUtsOnuAdminStatus()));
    }

    public void updateModel() {
        OnuConfigWoOamTable mbean = (OnuConfigWoOamTable) getModel();
        if (mbean == null)
            return;

        mbean.setUtsOnuCtcExtOamEnable(utsOnuCtcExtOamEnableVList[tfUtsOnuCtcExtOamEnable.getSelectedIndex()]);
        mbean.setUtsOnuDescription(tfUtsOnuDescription.getValue());
        //mbean.setUtsOnuAdminStatus(utsOnuAdminStatusVList[tfUtsOnuAdminStatus.getSelectedIndex()]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}