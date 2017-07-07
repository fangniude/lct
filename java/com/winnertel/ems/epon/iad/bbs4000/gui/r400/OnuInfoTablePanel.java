/**
 * Created by Zhou Chao, 2010/3/8
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuInfoTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OnuInfoTablePanel extends UPanel {

/*
    private JLabel tfOnuDeviceIndex = new JLabel();
*/

    private StringTextField tfOnuName = new StringTextField();
/*
    private JLabel tfOnuType = new JLabel();
*/
    private IPAddressField tfOnuIpAddress = new IPAddressField();
    private IPAddressField tfOnuIpSubnetMask = new IPAddressField(IPAddressField.IPMASK);
    private IPAddressField tfOnuIpGateway = new IPAddressField();
/*
    private JLabel tfOnuMacAddress = new JLabel();

    private int[] onuOperationStatusVList = new int[]{1, 2, 3,};
    private String[] onuOperationStatusTList = new String[]{
            fStringMap.getString("up"), //1
            fStringMap.getString("down"), //2
            fStringMap.getString("testing"), //3
    };
    private JComboBox tfOnuOperationStatus = new JComboBox(onuOperationStatusTList);
*/

    private int[] onuAdminStatusVList = new int[]{1, 2, 3,};
    private String[] onuAdminStatusTList = new String[]{
            fStringMap.getString("up"), //1
            fStringMap.getString("down"), //2
            fStringMap.getString("testing"), //3
    };
    private JComboBox tfOnuAdminStatus = new JComboBox(onuAdminStatusTList);

/*
    private JLabel tfOnuChipVendor = new JLabel();
    private JLabel tfOnuChipType = new JLabel();
    private JLabel tfOnuChipVersion = new JLabel();
    private JLabel tfOnuSoftwareVersion = new JLabel();
    private JLabel tfOnuFirmwareVersion = new JLabel();
    private JLabel tfOnuTestDistance = new JLabel();
*/
    //private IntegerTextField tfOnuLlidId = new IntegerTextField();

    private IntegerTextField tfOnuMgmtCvlan = new IntegerTextField();
    private IntegerTextField tfOnuMgmtSvlan = new IntegerTextField();
    private JComboBox tfOnuMgmtPriority = new JComboBox();
//    private IPAddressField tfOnuMgmtSnmpTrapHost = new IPAddressField();
//    private StringTextField tfOnuMgmtSnmpCommunityForRead = new StringTextField();
//    private StringTextField tfOnuMgmtSnmpCommunityForWrite = new StringTextField();

/*
    private final String onuDeviceIndex = fStringMap.getString("onuDeviceIndex") + " : ";
*/
    private final String onuName = fStringMap.getString("onuName") + " : ";
/*
    private final String onuType = fStringMap.getString("onuType") + " : ";
*/
    private final String onuIpAddress = fStringMap.getString("onuIpAddress") + " : ";
    private final String onuIpSubnetMask = fStringMap.getString("onuIpSubnetMask") + " : ";
    private final String onuIpGateway = fStringMap.getString("onuIpGateway") + " : ";
/*
    private final String onuMacAddress = fStringMap.getString("onuMacAddress") + " : ";
    private final String onuOperationStatus = fStringMap.getString("onuOperationStatus") + " : ";
*/
    private final String onuAdminStatus = fStringMap.getString("onuAdminStatus") + " : ";
/*
    private final String onuChipVendor = fStringMap.getString("onuChipVendor") + " : ";
    private final String onuChipType = fStringMap.getString("onuChipType") + " : ";
    private final String onuChipVersion = fStringMap.getString("onuChipVersion") + " : ";
    private final String onuSoftwareVersion = fStringMap.getString("onuSoftwareVersion") + " : ";
    private final String onuFirmwareVersion = fStringMap.getString("onuFirmwareVersion") + " : ";
    private final String onuTestDistance = fStringMap.getString("onuTestDistance") + " : ";
*/
    //private final String onuLlidId = fStringMap.getString("onuLlidId") + " : ";

    //private final String resetONU = fStringMap.getString("resetONU") + " : ";
    private final String onuMgmtCvlan = fStringMap.getString("onuMgmtCvlan") + " : ";
    private final String onuMgmtSvlan = fStringMap.getString("onuMgmtSvlan") + " : ";
    private final String onuMgmtPriority = fStringMap.getString("onuMgmtPriority") + " : ";
//    private final String onuMgmtSnmpTrapHost = fStringMap.getString("onuMgmtSnmpTrapHost") + " : ";
//    private final String onuMgmtSnmpCommunityForRead = fStringMap.getString("onuMgmtSnmpCommunityForRead") + " : ";
//    private final String onuMgmtSnmpCommunityForWrite = fStringMap.getString("onuMgmtSnmpCommunityForWrite") + " : ";

    public OnuInfoTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

/*
        baseInfoPanel.add(new JLabel(onuDeviceIndex));
        baseInfoPanel.add(tfOnuDeviceIndex);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(onuName));
        tfOnuName.setName(fStringMap.getString("onuName"));
        baseInfoPanel.add(tfOnuName);
        baseInfoPanel.add(new HSpacer());

/*
        baseInfoPanel.add(new JLabel(onuType));
        baseInfoPanel.add(tfOnuType);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(onuIpAddress));
        tfOnuIpAddress.setName(fStringMap.getString("onuIpAddress"));
        baseInfoPanel.add(tfOnuIpAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuIpSubnetMask));
        tfOnuIpSubnetMask.setName(fStringMap.getString("onuIpSubnetMask"));
        baseInfoPanel.add(tfOnuIpSubnetMask);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuIpGateway));
        tfOnuIpGateway.setName(fStringMap.getString("onuIpGateway"));
        baseInfoPanel.add(tfOnuIpGateway);
        baseInfoPanel.add(new HSpacer());

/*
        baseInfoPanel.add(new JLabel(onuMacAddress));
        baseInfoPanel.add(tfOnuMacAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOperationStatus));
        baseInfoPanel.add(tfOnuOperationStatus);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(onuAdminStatus));
        tfOnuAdminStatus.setName(fStringMap.getString("onuAdminStatus"));
        baseInfoPanel.add(tfOnuAdminStatus);
        baseInfoPanel.add(new HSpacer());

/*
        baseInfoPanel.add(new JLabel(onuChipVendor));
        baseInfoPanel.add(tfOnuChipVendor);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuChipType));
        baseInfoPanel.add(tfOnuChipType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuChipVersion));
        baseInfoPanel.add(tfOnuChipVersion);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuSoftwareVersion));
        baseInfoPanel.add(tfOnuSoftwareVersion);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuFirmwareVersion));
        baseInfoPanel.add(tfOnuFirmwareVersion);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuTestDistance));
        baseInfoPanel.add(tfOnuTestDistance);
        baseInfoPanel.add(new HSpacer());
*/

        //baseInfoPanel.add(new JLabel(onuLlidId));
        //tfOnuLlidId.setName(fStringMap.getString("onuLlidId"));
        //baseInfoPanel.add(tfOnuLlidId);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(resetONU));
        //tfResetONU.setName(fStringMap.getString("resetONU"));
        //baseInfoPanel.add(tfResetONU);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMgmtCvlan));
        tfOnuMgmtCvlan.setName(fStringMap.getString("onuMgmtCvlan"));
        baseInfoPanel.add(tfOnuMgmtCvlan);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuMgmtSvlan));
        tfOnuMgmtSvlan.setName(fStringMap.getString("onuMgmtSvlan"));
        baseInfoPanel.add(tfOnuMgmtSvlan);
        baseInfoPanel.add(new HSpacer());

        for (int i = 0; i < 8; i++) {
            tfOnuMgmtPriority.addItem(i);
        }
        baseInfoPanel.add(new JLabel(onuMgmtPriority));
        tfOnuMgmtPriority.setName(fStringMap.getString("onuMgmtPriority"));
        baseInfoPanel.add(tfOnuMgmtPriority);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(onuMgmtSnmpTrapHost));
//        tfOnuMgmtSnmpTrapHost.setName(fStringMap.getString("onuMgmtSnmpTrapHost"));
//        baseInfoPanel.add(tfOnuMgmtSnmpTrapHost);
//        baseInfoPanel.add(new HSpacer());
//
//
//        baseInfoPanel.add(new JLabel(onuMgmtSnmpCommunityForRead));
//        tfOnuMgmtSnmpCommunityForRead.setName(fStringMap.getString("onuMgmtSnmpCommunityForRead"));
//        baseInfoPanel.add(tfOnuMgmtSnmpCommunityForRead);
//        baseInfoPanel.add(new HSpacer());
//
//
//        baseInfoPanel.add(new JLabel(onuMgmtSnmpCommunityForWrite));
//        tfOnuMgmtSnmpCommunityForWrite.setName(fStringMap.getString("onuMgmtSnmpCommunityForWrite"));
//        baseInfoPanel.add(tfOnuMgmtSnmpCommunityForWrite);
//        baseInfoPanel.add(new HSpacer());

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
        tfOnuName.setLenScope(0, 255);
        //tfOnuMacAddress.setEditable(false);
//        tfOnuMgmtSnmpCommunityForRead.setLenScope(0,255);
//        tfOnuMgmtSnmpCommunityForWrite.setLenScope(0,255);
    }

    public void refresh() {
        OnuInfoTable mbean = (OnuInfoTable) getModel();
        if (mbean == null)
            return;

/*
        tfOnuDeviceIndex.setText(mbean.getOnuDeviceIndex() != null ? mbean.getOnuDeviceIndex().toString() : "");
*/
        tfOnuName.setValue(mbean.getOnuName());
/*
        tfOnuType.setText(mbean.getOnuType());
*/
        tfOnuIpAddress.setValue(mbean.getOnuIpAddress());
        tfOnuIpSubnetMask.setValue(mbean.getOnuIpSubnetMask());
        tfOnuIpGateway.setValue(mbean.getOnuIpGateway());
/*
        tfOnuMacAddress.setText(mbean.getOnuMacAddress());
        tfOnuOperationStatus.setSelectedIndex(getIndexFromValue(onuOperationStatusVList, mbean.getOnuOperationStatus()));
*/
        tfOnuAdminStatus.setSelectedIndex(getIndexFromValue(onuAdminStatusVList, mbean.getOnuAdminStatus()));
/*
        tfOnuChipVendor.setText(mbean.getOnuChipVendor());
        tfOnuChipType.setText(mbean.getOnuChipType());
        tfOnuChipVersion.setText(mbean.getOnuChipVersion());
        tfOnuSoftwareVersion.setText(mbean.getOnuSoftwareVersion());
        tfOnuFirmwareVersion.setText(mbean.getOnuFirmwareVersion());
        tfOnuTestDistance.setText(mbean.getOnuTestDistance() != null ? mbean.getOnuTestDistance().toString() : "");
*/
        //tfOnuLlidId.setValue(mbean.getOnuLlidId());
        tfOnuMgmtCvlan.setValue(mbean.getOnuMgmtCvlan().intValue());
        tfOnuMgmtSvlan.setValue(mbean.getOnuMgmtSvlan().intValue());
        tfOnuMgmtPriority.setSelectedItem(mbean.getOnuMgmtPriority());
//        tfOnuMgmtSnmpTrapHost.setValue(mbean.getOnuMgmtSnmpTrapHost());
//        tfOnuMgmtSnmpCommunityForRead.setValue(mbean.getOnuMgmtSnmpCommunityForRead());
//        tfOnuMgmtSnmpCommunityForWrite.setValue(mbean.getOnuMgmtSnmpCommunityForWrite());
    }

    public void updateModel() {
        OnuInfoTable mbean = (OnuInfoTable) getModel();
        if (mbean == null)
            return;

        mbean.setOnuName(tfOnuName.getValue());
        mbean.setOnuIpAddress(tfOnuIpAddress.getIPString());
        mbean.setOnuIpSubnetMask(tfOnuIpSubnetMask.getIPString());
        mbean.setOnuIpGateway(tfOnuIpGateway.getIPString());
        mbean.setOnuAdminStatus(new Integer(onuAdminStatusVList[tfOnuAdminStatus.getSelectedIndex()]));
        //mbean.setOnuLlidId(new Integer(tfOnuLlidId.getValue()));
        mbean.setOnuMgmtCvlan(new Integer(tfOnuMgmtCvlan.getValue()));
        mbean.setOnuMgmtSvlan(new Integer(tfOnuMgmtSvlan.getValue()));
        mbean.setOnuMgmtPriority((Integer) tfOnuMgmtPriority.getSelectedItem());
//        mbean.setOnuMgmtSnmpTrapHost(tfOnuMgmtSnmpTrapHost.getIPString());
//        mbean.setOnuMgmtSnmpCommunityForRead(tfOnuMgmtSnmpCommunityForRead.getValue());
//        mbean.setOnuMgmtSnmpCommunityForWrite(tfOnuMgmtSnmpCommunityForWrite.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}