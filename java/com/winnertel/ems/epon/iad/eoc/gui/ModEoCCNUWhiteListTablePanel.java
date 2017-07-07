package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNUWhiteListTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCCNUWhiteListTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCCNUWhiteListTablePanel extends UPanel {

    private IntegerTextField tfModEoCCNUWhiteListIndex = new IntegerTextField();

//    private IPAddressField tfModEoCCNUWhiteListIPAddress = new IPAddressField();

    private MacAddressField tfModEoCCNUWhiteListMACAddress = new MacAddressField();

    private int[] modEoCCNUWhiteListAuthorizationVList = new int[]{
            1, 0,};
    private String[] modEoCCNUWhiteListAuthorizationTList = new String[]{
            fStringMap.getString("authorized"),
            fStringMap.getString("not-authorized"),
    };
    private JComboBox tfModEoCCNUWhiteListAuthorization = new JComboBox(modEoCCNUWhiteListAuthorizationTList);
    private IntegerTextField tfModEoCCNUWhiteListRFOutputLevel = new IntegerTextField();

    private int[] modEoCCNUWhiteListAutoUpgradeENVList = new int[]{
            0, 1,};
    private String[] modEoCCNUWhiteListAutoUpgradeENTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfModEoCCNUWhiteListAutoUpgradeEN = new JComboBox(modEoCCNUWhiteListAutoUpgradeENTList);
    private int[] modEoCCNUWhiteListRegisterOnlineStatusVList = new int[]{
            0, 1,};
    private String[] modEoCCNUWhiteListRegisterOnlineStatusTList = new String[]{
            fStringMap.getString("offline"),
            fStringMap.getString("online"),
    };
    private JComboBox tfModEoCCNUWhiteListRegisterOnlineStatus = new JComboBox(modEoCCNUWhiteListRegisterOnlineStatusTList);
//    private IntegerTextField tfModEoCCNUWhiteListStartTime = new IntegerTextField();

//    private IntegerTextField tfModEoCCNUWhiteListEndTime = new IntegerTextField();

    /*
        private int[] modEoCCNUWhiteListRowStatusVList =new int[]{
1,2,5,4,3,6,};
private String[] modEoCCNUWhiteListRowStatusTList =new String[]{
        fStringMap.getString("active"),
        fStringMap.getString("notInService"),
        fStringMap.getString("createAndWait"),
        fStringMap.getString("createAndGo"),
        fStringMap.getString("notReady"),
        fStringMap.getString("destroy"),
};
private JComboBox tfModEoCCNUWhiteListRowStatus = new JComboBox( modEoCCNUWhiteListRowStatusTList);
       */

    private final String modEoCCNUWhiteListIndex = fStringMap.getString("modEoCCNUWhiteListIndex") + " : ";
    //    private final String modEoCCNUWhiteListIPAddress = fStringMap.getString("modEoCCNUWhiteListIPAddress") + " : ";
    private final String modEoCCNUWhiteListMACAddress = fStringMap.getString("modEoCCNUWhiteListMACAddress") + " : ";
    private final String modEoCCNUWhiteListAuthorization = fStringMap.getString("modEoCCNUWhiteListAuthorization") + " : ";
    private final String modEoCCNUWhiteListRFOutputLevel = fStringMap.getString("modEoCCNUWhiteListRFOutputLevel") + " : ";
    private final String modEoCCNUWhiteListAutoUpgradeEN = fStringMap.getString("modEoCCNUWhiteListAutoUpgradeEN") + " : ";
    private final String modEoCCNUWhiteListRegisterOnlineStatus = fStringMap.getString("modEoCCNUWhiteListRegisterOnlineStatus") + " : ";
//    private final String modEoCCNUWhiteListStartTime = fStringMap.getString("modEoCCNUWhiteListStartTime") + " : ";
//    private final String modEoCCNUWhiteListEndTime = fStringMap.getString("modEoCCNUWhiteListEndTime") + " : ";


    public ModEoCCNUWhiteListTablePanel(IApplication app) {
        super(app);

        init();
    }

    public boolean validateFrom() {
        int count = this.getTable().getRowCount();
        int vid = tfModEoCCNUWhiteListIndex.getValue();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            for (int i = 0; i < count; i++) {
                int tvid = (Integer) this.getTable().getValueAt(i, 0);
                if (tvid == vid) {
                    JOptionPane.showMessageDialog(this, fStringMap
                            .getString("White List Index already exists."));
                    return false;
                }
            }
        }
        return true;
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListIndex));
        baseInfoPanel.add(tfModEoCCNUWhiteListIndex);
        baseInfoPanel.add(new HSpacer());


//        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListIPAddress));
//        tfModEoCCNUWhiteListIPAddress.setName(fStringMap.getString("modEoCCNUWhiteListIPAddress"));
//        baseInfoPanel.add(tfModEoCCNUWhiteListIPAddress);
//        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListMACAddress));
        tfModEoCCNUWhiteListMACAddress.setName(fStringMap.getString("modEoCCNUWhiteListMACAddress"));
        baseInfoPanel.add(tfModEoCCNUWhiteListMACAddress);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListAuthorization));
        tfModEoCCNUWhiteListAuthorization.setName(fStringMap.getString("modEoCCNUWhiteListAuthorization"));
        baseInfoPanel.add(tfModEoCCNUWhiteListAuthorization);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListRFOutputLevel));
        tfModEoCCNUWhiteListRFOutputLevel.setName(fStringMap.getString("modEoCCNUWhiteListRFOutputLevel"));
        baseInfoPanel.add(tfModEoCCNUWhiteListRFOutputLevel);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListAutoUpgradeEN));
        tfModEoCCNUWhiteListAutoUpgradeEN.setName(fStringMap.getString("modEoCCNUWhiteListAutoUpgradeEN"));
        baseInfoPanel.add(tfModEoCCNUWhiteListAutoUpgradeEN);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListRegisterOnlineStatus));
        baseInfoPanel.add(tfModEoCCNUWhiteListRegisterOnlineStatus);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListStartTime));
        tfModEoCCNUWhiteListStartTime.setName(fStringMap.getString("modEoCCNUWhiteListStartTime"));
        baseInfoPanel.add(tfModEoCCNUWhiteListStartTime);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListEndTime));
        tfModEoCCNUWhiteListEndTime.setName(fStringMap.getString("modEoCCNUWhiteListEndTime"));
        baseInfoPanel.add(tfModEoCCNUWhiteListEndTime);
        baseInfoPanel.add(new HSpacer());
        */

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


        //      tfModEoCCNUWhiteListStartTime.setValueScope( 0,4294967295 );

        //     tfModEoCCNUWhiteListEndTime.setValueScope( 0,4294967295 );
        tfModEoCCNUWhiteListRegisterOnlineStatus.setEnabled(false);

    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfModEoCCNUWhiteListIndex.setEditable(true);
            return;
        }
        tfModEoCCNUWhiteListIndex.setEditable(false);

        ModEoCCNUWhiteListTable mbean = (ModEoCCNUWhiteListTable) getModel();

        tfModEoCCNUWhiteListIndex.setText(mbean.getModEoCCNUWhiteListIndex().toString());
//        tfModEoCCNUWhiteListIPAddress.setValue(mbean.getModEoCCNUWhiteListIPAddress());
        tfModEoCCNUWhiteListMACAddress.setValue(mbean.getModEoCCNUWhiteListMACAddress());
        tfModEoCCNUWhiteListAuthorization.setSelectedIndex(getIndexFromValue(modEoCCNUWhiteListAuthorizationVList, mbean.getModEoCCNUWhiteListAuthorization().intValue()));
        tfModEoCCNUWhiteListRFOutputLevel.setValue(mbean.getModEoCCNUWhiteListRFOutputLevel().intValue());
        tfModEoCCNUWhiteListAutoUpgradeEN.setSelectedIndex(getIndexFromValue(modEoCCNUWhiteListAutoUpgradeENVList, mbean.getModEoCCNUWhiteListAutoUpgradeEN().intValue()));
        tfModEoCCNUWhiteListRegisterOnlineStatus.setSelectedIndex(getIndexFromValue(modEoCCNUWhiteListRegisterOnlineStatusVList, mbean.getModEoCCNUWhiteListRegisterOnlineStatus().intValue()));
        //tfModEoCCNUWhiteListStartTime.setValue(mbean.getModEoCCNUWhiteListStartTime().intValue());
        //tfModEoCCNUWhiteListEndTime.setValue(mbean.getModEoCCNUWhiteListEndTime().intValue());
        //  tfModEoCCNUWhiteListRowStatus.setSelectedIndex(getIndexFromValue(modEoCCNUWhiteListRowStatusVList,mbean.getModEoCCNUWhiteListRowStatus().intValue()));

    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new ModEoCCNUWhiteListTable(fApplication.getSnmpProxy()));

        ModEoCCNUWhiteListTable mbean = (ModEoCCNUWhiteListTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            //    mbean.set??(new Integer(??.getValue()));
            mbean.setModEoCCNUWhiteListIndex(tfModEoCCNUWhiteListIndex.getValue());
        }


//        mbean.setModEoCCNUWhiteListIPAddress(new String(tfModEoCCNUWhiteListIPAddress.getIPString()));
        mbean.setModEoCCNUWhiteListMACAddress(tfModEoCCNUWhiteListMACAddress.getValue());
        mbean.setModEoCCNUWhiteListAuthorization(new Integer(modEoCCNUWhiteListAuthorizationVList[tfModEoCCNUWhiteListAuthorization.getSelectedIndex()]));
        mbean.setModEoCCNUWhiteListRFOutputLevel(new Integer(tfModEoCCNUWhiteListRFOutputLevel.getValue()));
        mbean.setModEoCCNUWhiteListAutoUpgradeEN(new Integer(modEoCCNUWhiteListAutoUpgradeENVList[tfModEoCCNUWhiteListAutoUpgradeEN.getSelectedIndex()]));

        //mbean.setModEoCCNUWhiteListStartTime(new Long(tfModEoCCNUWhiteListStartTime.getValue()));
        //mbean.setModEoCCNUWhiteListEndTime(new Long(tfModEoCCNUWhiteListEndTime.getValue()));
        //     mbean.setModEoCCNUWhiteListRowStatus(new Integer(modEoCCNUWhiteListRowStatusVList[tfModEoCCNUWhiteListRowStatus.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}
