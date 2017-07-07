package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OltPropertyTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The aaaPanel class.
 * Created by DVM Creator
 */
public class OltPropertyTablePanel extends UPanel {

    private JLabel tfOltDeviceIndex = new JLabel();

    private StringTextField tfOltName = new StringTextField();

    private int[] oltAdminStatusVList = new int[]{
            1, 2,};
    private String[] oltAdminStatusTList = new String[]{
            fStringMap.getString("up"),
            fStringMap.getString("down"),
    };
    private JComboBox tfOltAdminStatus = new JComboBox(oltAdminStatusTList);

    private final String oltDeviceIndex = fStringMap.getString("oltDeviceIndex") + " : ";
    private final String oltName = fStringMap.getString("oltName") + " : ";
    private final String oltAdminStatus = fStringMap.getString("oltAdminStatus") + " : ";

    public OltPropertyTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(oltDeviceIndex));
        baseInfoPanel.add(tfOltDeviceIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(oltName));
        tfOltName.setName(fStringMap.getString("oltName"));
        baseInfoPanel.add(tfOltName);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(oltAdminStatus));
        tfOltAdminStatus.setName(fStringMap.getString("oltAdminStatus"));
        baseInfoPanel.add(tfOltAdminStatus);
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
        tfOltName.setLenScope(0, 255);
    }

    public void refresh() {
        OltPropertyTable mbean = (OltPropertyTable) getModel();

        tfOltDeviceIndex.setText(mbean.getOltDeviceIndex().toString());
        tfOltName.setValue(mbean.getOltName());
        tfOltAdminStatus.setSelectedIndex(getIndexFromValue(oltAdminStatusVList, mbean.getOltAdminStatus().intValue()));
    }

    public void updateModel() {
        OltPropertyTable mbean = (OltPropertyTable) getModel();

        mbean.setOltName(tfOltName.getValue());

        mbean.setOltAdminStatus(new Integer(oltAdminStatusVList[tfOltAdminStatus.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for(int i = 0; i != list.length; i++) {
            if(list[i] == v) return i;
        }
        return 0;
    }

}
