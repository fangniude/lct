package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.StpPortTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class StpPortTablePanel extends UPanel {

    private IntegerTextField tfStpPortPriority = new IntegerTextField();
    private IntegerTextField tfStpPortPathCost = new IntegerTextField();

    private int[] stpPortRstpProtocolMigrationVList = new int[]{1, 2,};
    private String[] stpPortRstpProtocolMigrationTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfStpPortRstpProtocolMigration = new JComboBox(stpPortRstpProtocolMigrationTList);

    private int[] stpPortRstpAdminEdgePortVList = new int[]{1, 2,};
    private String[] stpPortRstpAdminEdgePortTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfStpPortRstpAdminEdgePort = new JComboBox(stpPortRstpAdminEdgePortTList);

    private int[] stpPortPointToPointAdminStatusVList = new int[]{0, 1, 2,};
    private String[] stpPortPointToPointAdminStatusTList = new String[]{
            fStringMap.getString("forceFalse"), //0
            fStringMap.getString("forceTrue"), //1
            fStringMap.getString("auto"), //2
    };
    private JComboBox tfStpPortPointToPointAdminStatus = new JComboBox(stpPortPointToPointAdminStatusTList);

    private int[] stpPortEnabledVList = new int[]{1, 2,};
    private String[] stpPortEnabledTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfStpPortEnabled = new JComboBox(stpPortEnabledTList);

    private final String stpPortPriority = fStringMap.getString("stpPortPriority") + " : ";
    private final String stpPortPathCost = fStringMap.getString("stpPortPathCost") + " : ";
    private final String stpPortRstpProtocolMigration = fStringMap.getString("stpPortRstpProtocolMigration") + " : ";
    private final String stpPortRstpAdminEdgePort = fStringMap.getString("stpPortRstpAdminEdgePort") + " : ";
    private final String stpPortPointToPointAdminStatus = fStringMap.getString("stpPortPointToPointAdminStatus") + " : ";
    private final String stpPortEnabled = fStringMap.getString("stpPortEnabled") + " : ";

    public StpPortTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(stpPortPriority));
        tfStpPortPriority.setName(fStringMap.getString("stpPortPriority"));
        baseInfoPanel.add(tfStpPortPriority);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(stpPortPathCost));
        tfStpPortPathCost.setName(fStringMap.getString("stpPortPathCost"));
        baseInfoPanel.add(tfStpPortPathCost);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(stpPortRstpProtocolMigration));
        tfStpPortRstpProtocolMigration.setName(fStringMap.getString("stpPortRstpProtocolMigration"));
        baseInfoPanel.add(tfStpPortRstpProtocolMigration);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(stpPortRstpAdminEdgePort));
        tfStpPortRstpAdminEdgePort.setName(fStringMap.getString("stpPortRstpAdminEdgePort"));
        baseInfoPanel.add(tfStpPortRstpAdminEdgePort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(stpPortPointToPointAdminStatus));
        tfStpPortPointToPointAdminStatus.setName(fStringMap.getString("stpPortPointToPointAdminStatus"));
        baseInfoPanel.add(tfStpPortPointToPointAdminStatus);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(stpPortEnabled));
        tfStpPortEnabled.setName(fStringMap.getString("stpPortEnabled"));
        baseInfoPanel.add(tfStpPortEnabled);
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
        tfStpPortPriority.setValueScope(0, 255);
        tfStpPortPathCost.setValueScope(1, 200000000);
    }

    public void refresh() {
        StpPortTable mbean = (StpPortTable) getModel();
        if (mbean == null)
            return;

        tfStpPortPriority.setValue(mbean.getStpPortPriority());
        tfStpPortPathCost.setValue(mbean.getStpPortPathCost());
        tfStpPortRstpProtocolMigration.setSelectedIndex(getIndexFromValue(stpPortRstpProtocolMigrationVList, mbean.getStpPortRstpProtocolMigration()));
        tfStpPortRstpAdminEdgePort.setSelectedIndex(getIndexFromValue(stpPortRstpAdminEdgePortVList, mbean.getStpPortRstpAdminEdgePort()));
        tfStpPortPointToPointAdminStatus.setSelectedIndex(getIndexFromValue(stpPortPointToPointAdminStatusVList, mbean.getStpPortPointToPointAdminStatus()));
        tfStpPortEnabled.setSelectedIndex(getIndexFromValue(stpPortEnabledVList, mbean.getStpPortEnabled()));
    }

    public void updateModel() {
        StpPortTable mbean = (StpPortTable) getModel();
        if (mbean == null)
            return;

        mbean.setStpPortPriority(new Integer(tfStpPortPriority.getValue()));
        mbean.setStpPortPathCost(new Integer(tfStpPortPathCost.getValue()));
        mbean.setStpPortRstpProtocolMigration(new Integer(stpPortRstpProtocolMigrationVList[tfStpPortRstpProtocolMigration.getSelectedIndex()]));
        mbean.setStpPortRstpAdminEdgePort(new Integer(stpPortRstpAdminEdgePortVList[tfStpPortRstpAdminEdgePort.getSelectedIndex()]));
        mbean.setStpPortPointToPointAdminStatus(new Integer(stpPortPointToPointAdminStatusVList[tfStpPortPointToPointAdminStatus.getSelectedIndex()]));
        mbean.setStpPortEnabled(new Integer(stpPortEnabledVList[tfStpPortEnabled.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}