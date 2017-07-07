package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATAdminSNMPCommunityTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCCBATAdminSNMPCommunityTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCCBATAdminSNMPCommunityTablePanel extends UPanel {

    private IntegerTextField tfModEoCCBATAdminSNMPCommunityIndex = new IntegerTextField();

    private StringTextField tfModEoCCBATAdminSNMPCommunity = new StringTextField();

    private int[] modEoCCBATAdminSNMPCommunityPermissionVList = new int[]{
            1, 2,};
    private String[] modEoCCBATAdminSNMPCommunityPermissionTList = new String[]{
            fStringMap.getString("ro"),
            fStringMap.getString("rw"),
    };
    private JComboBox tfModEoCCBATAdminSNMPCommunityPermission = new JComboBox(modEoCCBATAdminSNMPCommunityPermissionTList);
    /* private int[] modEoCCBATAdminSNMPCommunityRowStatusVList =new int[]{
1,2,5,4,3,6,};
private String[] modEoCCBATAdminSNMPCommunityRowStatusTList =new String[]{
fStringMap.getString("active"),
fStringMap.getString("notInService"),
fStringMap.getString("createAndWait"),
fStringMap.getString("createAndGo"),
fStringMap.getString("notReady"),
fStringMap.getString("destroy"),
};
private JComboBox tfModEoCCBATAdminSNMPCommunityRowStatus = new JComboBox( modEoCCBATAdminSNMPCommunityRowStatusTList);
    */

    private final String modEoCCBATAdminSNMPCommunityIndex = fStringMap.getString("modEoCCBATAdminSNMPCommunityIndex") + " : ";
    private final String modEoCCBATAdminSNMPCommunity = fStringMap.getString("modEoCCBATAdminSNMPCommunity") + " : ";
    private final String modEoCCBATAdminSNMPCommunityPermission = fStringMap.getString("modEoCCBATAdminSNMPCommunityPermission") + " : ";


    public ModEoCCBATAdminSNMPCommunityTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCBATAdminSNMPCommunityIndex));
        baseInfoPanel.add(tfModEoCCBATAdminSNMPCommunityIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminSNMPCommunity));
        tfModEoCCBATAdminSNMPCommunity.setName(fStringMap.getString("modEoCCBATAdminSNMPCommunity"));
        baseInfoPanel.add(tfModEoCCBATAdminSNMPCommunity);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminSNMPCommunityPermission));
        tfModEoCCBATAdminSNMPCommunityPermission.setName(fStringMap.getString("modEoCCBATAdminSNMPCommunityPermission"));
        baseInfoPanel.add(tfModEoCCBATAdminSNMPCommunityPermission);
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

        tfModEoCCBATAdminSNMPCommunity.setLenScope(1, 16);


    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) return;
        ModEoCCBATAdminSNMPCommunityTable mbean = (ModEoCCBATAdminSNMPCommunityTable) getModel();

        tfModEoCCBATAdminSNMPCommunityIndex.setText(mbean.getModEoCCBATAdminSNMPCommunityIndex().toString());
        tfModEoCCBATAdminSNMPCommunity.setValue(mbean.getModEoCCBATAdminSNMPCommunity());
        tfModEoCCBATAdminSNMPCommunityPermission.setSelectedIndex(getIndexFromValue(modEoCCBATAdminSNMPCommunityPermissionVList, mbean.getModEoCCBATAdminSNMPCommunityPermission().intValue()));
        // tfModEoCCBATAdminSNMPCommunityRowStatus.setSelectedIndex(getIndexFromValue(modEoCCBATAdminSNMPCommunityRowStatusVList,mbean.getModEoCCBATAdminSNMPCommunityRowStatus().intValue()));

    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new ModEoCCBATAdminSNMPCommunityTable(fApplication.getSnmpProxy()));

        ModEoCCBATAdminSNMPCommunityTable mbean = (ModEoCCBATAdminSNMPCommunityTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            //      mbean.set??(new Integer(??.getValue()));
            mbean.setModEoCCBATAdminSNMPCommunityIndex(tfModEoCCBATAdminSNMPCommunityIndex.getValue());
        }


        mbean.setModEoCCBATAdminSNMPCommunity(new String(tfModEoCCBATAdminSNMPCommunity.getValue()));
        mbean.setModEoCCBATAdminSNMPCommunityPermission(new Integer(modEoCCBATAdminSNMPCommunityPermissionVList[tfModEoCCBATAdminSNMPCommunityPermission.getSelectedIndex()]));
        //    mbean.setModEoCCBATAdminSNMPCommunityRowStatus(new Integer(modEoCCBATAdminSNMPCommunityRowStatusVList[tfModEoCCBATAdminSNMPCommunityRowStatus.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}