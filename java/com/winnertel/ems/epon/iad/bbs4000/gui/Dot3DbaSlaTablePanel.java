package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3DbaSlaTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The Dot3DbaSlaTablePanel class. Created by DVM Creator
 */
public class Dot3DbaSlaTablePanel extends UPanel {

    private JLabel tfIfIndex = new JLabel();

//	private JLabel tfUtsDot3DbaSlaModuleId = new JLabel();
//
//	private JLabel tfUtsDot3DbaSlaPortId = new JLabel();
//
//	private JLabel tfUtsDot3DbaSlaLogicalPortId = new JLabel();

    private IntegerTextField tfUtsDot3DbaSlaUpCommittedBandwidth = new IntegerTextField();

    private IntegerTextField tfUtsDot3DbaSlaUpMaxBandwidth = new IntegerTextField();

    private IntegerTextField tfUtsDot3DbaSlaVLANID = new IntegerTextField();

    private int[] utsDot3DbaSlaUNIMaxMACAddressVList = new int[]
    {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 30, 62, 126, 254, 8190};

    private String[] utsDot3DbaSlaUNIMaxMACAddressTList = new String[]
    {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "30", "62", "126", "254", "NO Limit"};

    private JComboBox tfUtsDot3DbaSlaUNIMaxMACAddress = new JComboBox(utsDot3DbaSlaUNIMaxMACAddressTList);
//	private IntegerTextField tfUtsDot3DbaSlaUNIMaxMACAddress = new IntegerTextField();

//	private JLabel tfUtsDot3DbaSlaIPAddress = new JLabel();
//
//	private JLabel tfUtsDot3DbaSlaSubnetMask = new JLabel();
//
//	private JLabel tfUtsDot3DbaSlaCallingStationId = new JLabel();

    private int[] utsDot3DbaSlaPlatoClassVList = new int[]
    {0, 1, 2, 3, 4, 5, 6, 7};
    private String[] utsDot3DbaSlaPlatoClassTList = new String[]
    {"0", "1", "2", "3", "4", "5", "6", "7"};
    private JComboBox tfUtsDot3DbaSlaPlatoClass = new JComboBox(utsDot3DbaSlaPlatoClassTList);
//	private IntegerTextField tfUtsDot3DbaSlaPlatoClass = new IntegerTextField();

    private MacAddressField tfUtsDot3DbaSlaBindingMacAddress = new MacAddressField();

    private int[] utsDot3DbaSlaDownPolicingEnableVList = new int[]
    {2, 1, };

    private String[] utsDot3DbaSlaDownPolicingEnableTList = new String[]
    {fStringMap.getString("disable"), fStringMap.getString("enable"), };

    private JComboBox tfUtsDot3DbaSlaDownPolicingEnable = new JComboBox(utsDot3DbaSlaDownPolicingEnableTList);

    private IntegerTextField tfUtsDot3DbaSlaDownMaxBandwidth = new IntegerTextField();

    private IntegerTextField tfUtsDot3DbaSlaDownMaxBurstSize = new IntegerTextField();

    private int[] utsDot3DbaSlaP2PPolicingEnableVList = new int[]
    {2, 1, };

    private String[] utsDot3DbaSlaP2PPolicingEnableTList = new String[]
    {fStringMap.getString("disable"), fStringMap.getString("enable"), };

    private JComboBox tfUtsDot3DbaSlaP2PPolicingEnable = new JComboBox(utsDot3DbaSlaP2PPolicingEnableTList);

    private StringTextField tfUtsDot3DbaSlaP2PPolicingONUList = new StringTextField();

    private IntegerTextField tfUtsDot3DbaSlaP2PMaxBandwidth = new IntegerTextField();

    private IntegerTextField tfUtsDot3DbaSlaP2PMaxBurstSize = new IntegerTextField();

    private final String ifIndex = fStringMap.getString("ifOnuIndex") + " : ";

    private final String utsDot3DbaSlaUpCommittedBandwidth = fStringMap
            .getString("utsDot3DbaSlaUpCommittedBandwidth")
            + " : ";

    private final String utsDot3DbaSlaUpMaxBandwidth = fStringMap
            .getString("utsDot3DbaSlaUpMaxBandwidth")
            + " : ";

    private final String utsDot3DbaSlaVLANID = fStringMap
            .getString("utsDot3DbaSlaVLANID")
            + " : ";

    private final String utsDot3DbaSlaUNIMaxMACAddress = fStringMap
            .getString("utsDot3DbaSlaUNIMaxMACAddress")
            + " : ";

    private final String utsDot3DbaSlaPlatoClass = fStringMap
            .getString("utsDot3DbaSlaPlatoClass")
            + " : ";

    private final String utsDot3DbaSlaBindingMacAddress = fStringMap
            .getString("utsDot3DbaSlaBindingMacAddress")
            + " : ";

    private final String utsDot3DbaSlaDownPolicingEnable = fStringMap
            .getString("utsDot3DbaSlaDownPolicingEnable")
            + " : ";

    private final String utsDot3DbaSlaDownMaxBandwidth = fStringMap
            .getString("utsDot3DbaSlaDownMaxBandwidth")
            + " : ";

    private final String utsDot3DbaSlaDownMaxBurstSize = fStringMap
            .getString("utsDot3DbaSlaDownMaxBurstSize")
            + " : ";

    private final String utsDot3DbaSlaP2PPolicingEnable = fStringMap
            .getString("utsDot3DbaSlaP2PPolicingEnable")
            + " : ";

    private final String utsDot3DbaSlaP2PPolicingONUList = fStringMap
            .getString("utsDot3DbaSlaP2PPolicingONUList")
            + " : ";

    private final String utsDot3DbaSlaP2PMaxBandwidth = fStringMap
            .getString("utsDot3DbaSlaP2PMaxBandwidth")
            + " : ";

    private final String utsDot3DbaSlaP2PMaxBurstSize = fStringMap
            .getString("utsDot3DbaSlaP2PMaxBurstSize")
            + " : ";

    public Dot3DbaSlaTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(14, 3, NTLayout.FILL, NTLayout.CENTER,
                5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(ifIndex));
        baseInfoPanel.add(tfIfIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaUpCommittedBandwidth));
        tfUtsDot3DbaSlaUpCommittedBandwidth.setName(fStringMap
                .getString("utsDot3DbaSlaUpCommittedBandwidth"));
        tfUtsDot3DbaSlaUpCommittedBandwidth.setPreferredSize(new Dimension(100, 30));
        baseInfoPanel.add(tfUtsDot3DbaSlaUpCommittedBandwidth);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaUpMaxBandwidth));
        tfUtsDot3DbaSlaUpMaxBandwidth.setName(fStringMap
                .getString("utsDot3DbaSlaUpMaxBandwidth"));
        baseInfoPanel.add(tfUtsDot3DbaSlaUpMaxBandwidth);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaVLANID));
        tfUtsDot3DbaSlaVLANID.setName(fStringMap
                .getString("utsDot3DbaSlaVLANID"));
        baseInfoPanel.add(tfUtsDot3DbaSlaVLANID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaUNIMaxMACAddress));
        tfUtsDot3DbaSlaUNIMaxMACAddress.setName(fStringMap
                .getString("utsDot3DbaSlaUNIMaxMACAddress"));
        baseInfoPanel.add(tfUtsDot3DbaSlaUNIMaxMACAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaPlatoClass));
        tfUtsDot3DbaSlaPlatoClass.setName(fStringMap
                .getString("utsDot3DbaSlaPlatoClass"));
        baseInfoPanel.add(tfUtsDot3DbaSlaPlatoClass);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaBindingMacAddress));
        tfUtsDot3DbaSlaBindingMacAddress.setName(fStringMap
                .getString("utsDot3DbaSlaBindingMacAddress"));

        baseInfoPanel.add(tfUtsDot3DbaSlaBindingMacAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaDownPolicingEnable));
        tfUtsDot3DbaSlaDownPolicingEnable.setName(fStringMap
                .getString("utsDot3DbaSlaDownPolicingEnable"));
        baseInfoPanel.add(tfUtsDot3DbaSlaDownPolicingEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaDownMaxBandwidth));
        tfUtsDot3DbaSlaDownMaxBandwidth.setName(fStringMap
                .getString("utsDot3DbaSlaDownMaxBandwidth"));
        baseInfoPanel.add(tfUtsDot3DbaSlaDownMaxBandwidth);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaDownMaxBurstSize));
        tfUtsDot3DbaSlaDownMaxBurstSize.setName(fStringMap
                .getString("utsDot3DbaSlaDownMaxBurstSize"));
        baseInfoPanel.add(tfUtsDot3DbaSlaDownMaxBurstSize);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaP2PPolicingEnable));
        tfUtsDot3DbaSlaP2PPolicingEnable.setName(fStringMap
                .getString("utsDot3DbaSlaP2PPolicingEnable"));
        baseInfoPanel.add(tfUtsDot3DbaSlaP2PPolicingEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaP2PPolicingONUList));
        tfUtsDot3DbaSlaP2PPolicingONUList.setName(fStringMap
                .getString("utsDot3DbaSlaP2PPolicingONUList"));
        baseInfoPanel.add(tfUtsDot3DbaSlaP2PPolicingONUList);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaP2PMaxBandwidth));
        tfUtsDot3DbaSlaP2PMaxBandwidth.setName(fStringMap
                .getString("utsDot3DbaSlaP2PMaxBandwidth"));
        baseInfoPanel.add(tfUtsDot3DbaSlaP2PMaxBandwidth);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaSlaP2PMaxBurstSize));
        tfUtsDot3DbaSlaP2PMaxBurstSize.setName(fStringMap
                .getString("utsDot3DbaSlaP2PMaxBurstSize"));
        baseInfoPanel.add(tfUtsDot3DbaSlaP2PMaxBurstSize);
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
        tfUtsDot3DbaSlaUpCommittedBandwidth.setValueScope(1, 1000000);
        tfUtsDot3DbaSlaUpMaxBandwidth.setValueScope(1, 1000000);
        tfUtsDot3DbaSlaVLANID.setValueScope(1, 4094);
        tfUtsDot3DbaSlaDownMaxBandwidth.setValueScope(0, 1000000);
        tfUtsDot3DbaSlaDownMaxBurstSize.setValueScope(0, 8192);
        tfUtsDot3DbaSlaP2PMaxBandwidth.setValueScope(0, 1000000);
        tfUtsDot3DbaSlaP2PMaxBurstSize.setValueScope(0, 8192);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            return;
        }

        Dot3DbaSlaTable mbean = (Dot3DbaSlaTable) getModel();

        tfIfIndex.setText(ConfigUtility.formatIfIndex(mbean.getIfOnuIndex().toString()));
        tfUtsDot3DbaSlaUpCommittedBandwidth.setValue(mbean.getUtsDot3DbaSlaUpCommittedBandwidth().intValue());
        tfUtsDot3DbaSlaUpMaxBandwidth.setValue(mbean.getUtsDot3DbaSlaUpMaxBandwidth().intValue());
        tfUtsDot3DbaSlaVLANID.setValue(mbean.getUtsDot3DbaSlaVLANID().intValue());
        tfUtsDot3DbaSlaUNIMaxMACAddress.setSelectedIndex(getIndexFromValue(utsDot3DbaSlaUNIMaxMACAddressVList, mbean.getUtsDot3DbaSlaUNIMaxMACAddress().intValue()));
        tfUtsDot3DbaSlaPlatoClass.setSelectedIndex(getIndexFromValue(utsDot3DbaSlaPlatoClassVList, mbean.getUtsDot3DbaSlaPlatoClass()
                .intValue()));
        tfUtsDot3DbaSlaBindingMacAddress.setValue(mbean.getUtsDot3DbaSlaBindingMacAddress());
        tfUtsDot3DbaSlaDownPolicingEnable.setSelectedIndex(getIndexFromValue(utsDot3DbaSlaDownPolicingEnableVList, mbean.getUtsDot3DbaSlaDownPolicingEnable().intValue()));
        tfUtsDot3DbaSlaDownMaxBandwidth.setValue(mbean.getUtsDot3DbaSlaDownMaxBandwidth().intValue());
        tfUtsDot3DbaSlaDownMaxBurstSize.setValue(mbean
                .getUtsDot3DbaSlaDownMaxBurstSize().intValue());
        tfUtsDot3DbaSlaP2PPolicingEnable.setSelectedIndex(getIndexFromValue(utsDot3DbaSlaP2PPolicingEnableVList, mbean.getUtsDot3DbaSlaP2PPolicingEnable().intValue()));
        tfUtsDot3DbaSlaP2PPolicingONUList.setValue(ConfigUtility.toOnuP2PString(mbean.getUtsDot3DbaSlaP2PPolicingONUList()));
        tfUtsDot3DbaSlaP2PMaxBandwidth.setValue(mbean.getUtsDot3DbaSlaP2PMaxBandwidth().intValue());
        tfUtsDot3DbaSlaP2PMaxBurstSize.setValue(mbean.getUtsDot3DbaSlaP2PMaxBurstSize().intValue());

    }

    public boolean validateFrom() {
        String index = tfIfIndex.getText();
        String[] token = index.split("/");
        Dot3DbaSlaTable mbean = new Dot3DbaSlaTable(fApplication.getSnmpProxy());
        int totalcommi = 0;
        Vector v = new Vector();
        try {
            /*The port ifIndex is the previous row data.*/
            int ifIndex = ConfigUtility.generateIfIndex(token[0] + "/" + token[1]); //port if index
            mbean.setIndex(0, "" + ifIndex);
            v = mbean.retrieveAll();
        } catch (MibBeanException e) {
            e.printStackTrace();
        }
        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                Dot3DbaSlaTable one = (Dot3DbaSlaTable) v.get(i);
                if (one.getUtsDot3DbaSlaModuleId().intValue() == Integer.parseInt(token[0])
                        && one.getUtsDot3DbaSlaPortId().intValue() == Integer.parseInt(token[1])
                        && one.getUtsDot3DbaSlaLogicalPortId().intValue() != Integer.parseInt(token[2])) {
                    totalcommi += one.getUtsDot3DbaSlaUpCommittedBandwidth().intValue();
                }

            }
            int leftcommi = 1000000 - totalcommi;
            if (tfUtsDot3DbaSlaUpCommittedBandwidth.getValue() > leftcommi) {
                String error = fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_1")
                         + token[0] + "/" + token[1] + fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_2")
                         + "\r\n" + fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_3") +
                         + leftcommi + fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_4");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
        }
        return true;
    }

    public void updateModel() {

        Dot3DbaSlaTable mbean = (Dot3DbaSlaTable) getModel();

        String oldMac = ConfigUtility.OctetToMacAddress(mbean.getUtsDot3DbaSlaBindingMacAddress());
        mbean.setUtsDot3DbaSlaUpCommittedBandwidth(new Integer(tfUtsDot3DbaSlaUpCommittedBandwidth.getValue()));
        mbean.setUtsDot3DbaSlaUpMaxBandwidth(new Integer(tfUtsDot3DbaSlaUpMaxBandwidth.getValue()));
        mbean.setUtsDot3DbaSlaVLANID(new Integer(tfUtsDot3DbaSlaVLANID
                .getValue()));
        mbean.setUtsDot3DbaSlaUNIMaxMACAddress(new Integer(utsDot3DbaSlaUNIMaxMACAddressVList[tfUtsDot3DbaSlaUNIMaxMACAddress.getSelectedIndex()]));

        mbean.setUtsDot3DbaSlaPlatoClass(new Integer(utsDot3DbaSlaPlatoClassVList[tfUtsDot3DbaSlaPlatoClass.getSelectedIndex()]));
        mbean.setUtsDot3DbaSlaBindingMacAddress(tfUtsDot3DbaSlaBindingMacAddress
                .getValue());
        mbean.setUtsDot3DbaSlaDownPolicingEnable(new Integer(utsDot3DbaSlaDownPolicingEnableVList[tfUtsDot3DbaSlaDownPolicingEnable
                .getSelectedIndex()]));
        mbean.setUtsDot3DbaSlaDownMaxBandwidth(new Integer(tfUtsDot3DbaSlaDownMaxBandwidth.getValue()));
        mbean.setUtsDot3DbaSlaDownMaxBurstSize(new Integer(tfUtsDot3DbaSlaDownMaxBurstSize.getValue()));
        mbean.setUtsDot3DbaSlaP2PPolicingEnable(new Integer(utsDot3DbaSlaP2PPolicingEnableVList[tfUtsDot3DbaSlaP2PPolicingEnable
                .getSelectedIndex()]));
        mbean.setUtsDot3DbaSlaP2PPolicingONUList(ConfigUtility.toOnuBitList(ConfigUtility.transferBitMap(tfUtsDot3DbaSlaP2PPolicingONUList.getValue())));
        mbean.setUtsDot3DbaSlaP2PMaxBandwidth(new Integer(tfUtsDot3DbaSlaP2PMaxBandwidth.getValue()));
        mbean.setUtsDot3DbaSlaP2PMaxBurstSize(new Integer(tfUtsDot3DbaSlaP2PMaxBurstSize.getValue()));

//        try
//        {
//          UnboundOnuMgmtMgr onuMgmtMgr = (UnboundOnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "UnboundOnuMgmtMgr");
//          if(onuMgmtMgr != null)
//          {
//            String newMac = ConfigUtility.OctetToMacAddress(tfUtsDot3DbaSlaBindingMacAddress.getValue());
//
//            if(!newMac.equals(oldMac))
//            {
//              UnboundOnuMOD onu = new UnboundOnuMOD();
//              onu.setCardId("" + mbean.getUtsDot3DbaSlaModuleId());
//              onu.setPortId("" + mbean.getUtsDot3DbaSlaPortId());
//              onu.setLlId("" + mbean.getUtsDot3DbaSlaLogicalPortId());
//              onu.setNeName(fApplication.getActiveDeviceManager().getName());
//
//              if(newMac.equals("00-00-00-00-00-00"))
//              {
//                onu.setMacAddress(oldMac);
//                onuMgmtMgr.addUnbindOnu(onu);
//              }
//              else
//              {
//                onu.setMacAddress(newMac);
//                onuMgmtMgr.deleteUnbindOnu(onu);
//              }
//            }
//          }
//        }
//        catch(Exception e)
//        {
//          e.printStackTrace();
//        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }


}
