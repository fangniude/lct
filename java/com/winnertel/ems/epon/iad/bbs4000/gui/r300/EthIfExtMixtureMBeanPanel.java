package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.EthInterface;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.PortTreeNodeBuilder;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.SuperVlanInterface;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.SVIMemberVlanListInputPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.ems.epon.iad.bbs4000.mib.SecondIPAddressTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.SuperSVITable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.EthIfExtMixtureMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class EthIfExtMixtureMBeanPanel extends UPanel implements ActionListener, ItemListener {

    private JComboBox tfIfIndex = new JComboBox();
    private IPAddressField tfUtsEthIfExtIpAddress = new IPAddressField();
    private IPAddressField tfUtsEthIfExtIpNetmask = new IPAddressField(IPAddressField.IPMASK);

    private int[] utsEthIfExtAdminStatusVList = new int[]{1, 2,};
    private String[] utsEthIfExtAdminStatusTList = new String[]{
            fStringMap.getString("up"),
            fStringMap.getString("down"),
    };
    private JComboBox tfUtsEthIfExtAdminStatus = new JComboBox(utsEthIfExtAdminStatusTList);

    private JCheckBox cbSecondIP = new JCheckBox(fStringMap.getString("Second IP"));
    private IPAddressField tfUtsIfSecondIpAddress = new IPAddressField();
    private IPAddressField tfUtsIfSecondIpNetmask = new IPAddressField(IPAddressField.IPMASK);

    private JCheckBox cbHasSVI = new JCheckBox(fStringMap.getString("Super SVI"));
    private SVIMemberVlanListInputPanel vlanListInputPanel = new SVIMemberVlanListInputPanel(fApplication);

    private final String ifIndex = fStringMap.getString("ifIndex") + ": ";
    //private final String utsEthIfExtPortType = fStringMap.getString("utsEthIfExtPortType") + ": ";
    private final String utsEthIfExtIpAddress = fStringMap.getString("utsEthIfExtIpAddress") + ": ";
    private final String utsEthIfExtIpNetmask = fStringMap.getString("utsEthIfExtIpNetmask") + ": ";
    private final String utsEthIfExtAdminStatus = fStringMap.getString("utsEthIfExtAdminStatus") + ": ";
    private final String utsIfSecondIpIfIndex = fStringMap.getString("utsIfSecondIpIfIndex") + ": ";
    private final String utsIfSecondIpAddress = fStringMap.getString("utsIfSecondIpAddress") + ": ";
    private final String utsIfSecondIpNetmask = fStringMap.getString("utsIfSecondIpNetmask") + ": ";
    private final String utsIntfSuperSVIVlanId = fStringMap.getString("utsIntfSuperSVIVlanId") + ": ";
    private final String utsIntfSuperSVIVlanMemberBitmap = fStringMap.getString("utsIntfSuperSVIVlanMemberBitmap") + ": ";

    private IApplication fAppliction;

    public EthIfExtMixtureMBeanPanel(IApplication app) {
        super(app);
        fAppliction = app;
        setModel(new EthIfExtMixtureMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(ifIndex));
        tfIfIndex.addActionListener(this);
        tfIfIndex.addItemListener(this);
        tfIfIndex.setActionCommand("ifindex");

        baseInfoPanel.add(tfIfIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthIfExtIpAddress));
        tfUtsEthIfExtIpAddress.setName(fStringMap.getString("utsEthIfExtIpAddress"));
        baseInfoPanel.add(tfUtsEthIfExtIpAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthIfExtIpNetmask));
        tfUtsEthIfExtIpNetmask.setName(fStringMap.getString("utsEthIfExtIpNetmask"));
        baseInfoPanel.add(tfUtsEthIfExtIpNetmask);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthIfExtAdminStatus));
        tfUtsEthIfExtAdminStatus.setName(fStringMap.getString("utsEthIfExtAdminStatus"));
        baseInfoPanel.add(tfUtsEthIfExtAdminStatus);
        baseInfoPanel.add(new HSpacer());

        // Second IP Address
        JPanel secondIPInfoPanel = new JPanel();
        NTLayout secondLayout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.FILL, 5, 5);
        secondLayout.setMargins(6, 10, 6, 10);
        secondIPInfoPanel.setLayout(secondLayout);
        secondIPInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        cbSecondIP.addActionListener(this);
        cbSecondIP.setActionCommand("secondip");
        secondIPInfoPanel.add(cbSecondIP);
        secondIPInfoPanel.add(new JLabel());
        secondIPInfoPanel.add(new HSpacer());

        tfUtsIfSecondIpAddress.setMaximumSize(new Dimension(200, 25));
        tfUtsIfSecondIpAddress.setMinimumSize(new Dimension(200, 25));
        secondIPInfoPanel.add(new JLabel(utsIfSecondIpAddress));
        tfUtsIfSecondIpAddress.setName(fStringMap.getString("utsIfSecondIpAddress"));
        secondIPInfoPanel.add(tfUtsIfSecondIpAddress);
        secondIPInfoPanel.add(new HSpacer());

        tfUtsIfSecondIpNetmask.setMaximumSize(new Dimension(200, 25));
        tfUtsIfSecondIpNetmask.setMinimumSize(new Dimension(200, 25));
        secondIPInfoPanel.add(new JLabel(utsIfSecondIpNetmask));
        tfUtsIfSecondIpNetmask.setName(fStringMap.getString("utsIfSecondIpNetmask"));
        secondIPInfoPanel.add(tfUtsIfSecondIpNetmask);
        secondIPInfoPanel.add(new HSpacer());

        // Super SVI
        JPanel superSVIPanel = new JPanel();
        NTLayout superSVILayout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.FILL, 5, 5);
        superSVILayout.setMargins(6, 10, 6, 10);
        superSVIPanel.setLayout(superSVILayout);

        cbHasSVI.setActionCommand("hassvi");
        cbHasSVI.addActionListener(this);
        superSVIPanel.add(cbHasSVI);
        superSVIPanel.add(new JLabel());
        superSVIPanel.add(new HSpacer());

        superSVIPanel.add(new JLabel(utsIntfSuperSVIVlanMemberBitmap));
        vlanListInputPanel.setName(fStringMap.getString("utsIntfSuperSVIVlanMemberBitmap"));
        superSVIPanel.add(vlanListInputPanel);
        superSVIPanel.add(new HSpacer());

        superSVIPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(secondIPInfoPanel);
        allPanel.add(superSVIPanel);
        allPanel.add(new VSpacer());

        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    public void refreshEthIfExt(EthIfExtMixtureMBean mbean) {
        tfIfIndex.removeAllItems();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            String[] ports = getPortCanChangeToLayer3EthIfExt();
            for (int i = 0; i < ports.length; i++) {
                tfIfIndex.addItem(ports[i]);
            }

            return;
        }

        //EthIfExtTable mbean = (EthIfExtTable) getModel();
        tfIfIndex.addItem(ConfigUtility.formatIfIndex((mbean.getUtsEthIfExtIfIndex().toString())));
        //tfUtsEthIfExtIpAddress.setEditable(false);
        tfUtsEthIfExtIpAddress.setValue(mbean.getUtsEthIfExtIpAddress());
        //tfUtsEthIfExtIpNetmask.setEditable(false);
        tfUtsEthIfExtIpNetmask.setValue(mbean.getUtsEthIfExtIpNetmask());

        // disable edit of IP Address if configured in Second IP table
        try {
            tfUtsEthIfExtIpAddress.setEditable(true);
            tfUtsEthIfExtIpNetmask.setEditable(true);

            SecondIPAddressTable secIPAddrTblMBean = new SecondIPAddressTable(fApplication.getSnmpProxy());
            Vector secIPAddrTblVec = secIPAddrTblMBean.retrieveAll();
            int thisIfExtIdx = mbean.getUtsEthIfExtIfIndex().intValue();
            for (int i = 0; i < secIPAddrTblVec.size(); i++) {
                SecondIPAddressTable tmpSecIPAddrTbl = (SecondIPAddressTable) secIPAddrTblVec.elementAt(i);
                int tmpIfExtIdx = tmpSecIPAddrTbl.getUtsIfSecondIpIfIndex().intValue();
                if (thisIfExtIdx == tmpIfExtIdx) {
                    tfUtsEthIfExtIpAddress.setEditable(false);
                    tfUtsEthIfExtIpNetmask.setEditable(false);
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        tfUtsEthIfExtAdminStatus.setSelectedIndex(getIndexFromValueEthIfExt(utsEthIfExtAdminStatusVList, mbean.getUtsEthIfExtAdminStatus().intValue()));
    }

    public boolean validateFromEthIfExt() {
        try {
            String thisIdx = (String) tfIfIndex.getSelectedItem();
            String thisIPAddr = tfUtsEthIfExtIpAddress.getIPString();
            String thisIPMask = tfUtsEthIfExtIpNetmask.getIPString();

            if (thisIPAddr.equals("0.0.0.0")) {
                String error = fStringMap.getString("Err_IP_Is_Zero");
                MessageDialog.showInfoMessageDialog(fApplication, error);
                return false;
            }

            if (thisIPMask.equals("0.0.0.0")) {
                String error = fStringMap.getString("Err_Netmask_Is_Zero");
                MessageDialog.showInfoMessageDialog(fApplication, error);
                return false;
            }

            // validate EthIfExt Table's ip address, network mask, etc.
            EthIfExtTable ifExtMBean = new EthIfExtTable(fApplication.getSnmpProxy());
            Vector ifExtVec = ifExtMBean.retrieveAll();

            for (int i = 0; ifExtVec != null && i < ifExtVec.size(); i++) {
                EthIfExtTable tmpIfExtTbl = (EthIfExtTable) ifExtVec.elementAt(i);
                String tmpIdx = ConfigUtility.formatIfIndex(tmpIfExtTbl.getUtsEthIfExtIfIndex().toString());
                String tmpIPAddr = tmpIfExtTbl.getUtsEthIfExtIpAddress();
                String tmpIPMask = tmpIfExtTbl.getUtsEthIfExtIpNetmask();

                if (tmpIPAddr.equals("0.0.0.0") && tmpIPMask.equals("0.0.0.0"))
                    continue;

                String netMask = ConfigUtility.compareNetMask(thisIPMask, tmpIPMask);
                String thisNetAddr = ConfigUtility.getSubnetAddress(thisIPAddr, netMask);
                String tmpNetAddr = ConfigUtility.getSubnetAddress(tmpIPAddr, netMask);

                if ((!thisIdx.equals(tmpIdx)) && thisNetAddr.equals(tmpNetAddr)) {
                    String error = fStringMap.getString("Err_Duplicate_IP_In_Layer3");
                    MessageDialog.showInfoMessageDialog(fApplication, error);
                    return false;
                }
            }

            // validate second ip address ip address, network mask, etc.
            SecondIPAddressTable secIPAddrMBean = new SecondIPAddressTable(fApplication.getSnmpProxy());
            Vector secIPAddrVec = secIPAddrMBean.retrieveAll();

            if (thisIPAddr.equals("0.0.0.0")) {
                String error = fStringMap.getString("Err_IP_Is_Zero");
                MessageDialog.showInfoMessageDialog(fApplication, error);
                return false;
            }

            if (thisIPMask.equals("0.0.0.0")) {
                String error = fStringMap.getString("Err_Netmask_Is_Zero");
                MessageDialog.showInfoMessageDialog(fApplication, error);
                return false;
            }

            EthIfExtMixtureMBean mbean = (EthIfExtMixtureMBean) getModel();

            for (int i = 0; secIPAddrVec != null && i < secIPAddrVec.size(); i++) {
                SecondIPAddressTable secIPAddrTbl = (SecondIPAddressTable) secIPAddrVec.elementAt(i);
                String tmpIPAddr = secIPAddrTbl.getUtsIfSecondIpAddress();
                String tmpIPMask = secIPAddrTbl.getUtsIfSecondIpNetmask();

                if (tmpIPAddr.equals("0.0.0.0") && tmpIPMask.equals("0.0.0.0"))
                    continue;

                String netMask = ConfigUtility.compareNetMask(thisIPMask, tmpIPMask);
                String thisNetAddr = ConfigUtility.getSubnetAddress(thisIPAddr, netMask);
                String tmpNetAddr = ConfigUtility.getSubnetAddress(tmpIPAddr, netMask);

                if (thisNetAddr.equals(tmpNetAddr) && !thisNetAddr.equals(mbean.getUtsIfSecondIpAddress())) {
                    String error = fStringMap.getString("Err_Duplicate_IP_In_Second_Layer3");
                    MessageDialog.showInfoMessageDialog(fApplication, error);
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }

    public void updateModelEthIfExt(EthIfExtMixtureMBean mbean) {
        //if (SnmpAction.IType.ADD.equals(fCommand))
        //  setModel(new EthIfExtTable(fApplication.getSnmpProxy()));
        //
        //EthIfExtTable mbean = (EthIfExtTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setIfIndex(new Integer(ConfigUtility.generateIfIndex(tfIfIndex.getSelectedItem().toString())));
            mbean.setUtsEthIfExtSwitchMode(new Integer(2));
        }

        mbean.setUtsEthIfExtIpAddress(tfUtsEthIfExtIpAddress.getIPString());
        mbean.setUtsEthIfExtIpNetmask(tfUtsEthIfExtIpNetmask.getIPString());
        mbean.setUtsEthIfExtAdminStatus(new Integer(utsEthIfExtAdminStatusVList[tfUtsEthIfExtAdminStatus.getSelectedIndex()]));
    }

    public int getIndexFromValueEthIfExt(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    /**
     * some layer2 interface cannot configured to layer3 1.vlan belongs to
     * SuperSVI 2.port belongs to link aggregation
     *
     * @return
     */
    private String[] getPortCanChangeToLayer3EthIfExt() {
        ArrayList list = new ArrayList();
        ISnmpProxy aSnmpProxy = fApplication.getSnmpProxy();

        try {
            EthIfExtTable ifExtMBean = new EthIfExtTable(aSnmpProxy);
            Vector ifExtVec = ifExtMBean.retrieveRealAll();

            for (int i = 0; i < ifExtVec.size(); i++) {
                EthIfExtTable tmpIfExtTbl = (EthIfExtTable) ifExtVec.elementAt(i);
                int portType = tmpIfExtTbl.getUtsEthIfExtPortType().intValue();

                if (portType == 1) {
                    if (tmpIfExtTbl.getUtsEthIfExtSwitchMode().intValue() == 1 || (tmpIfExtTbl.getUtsEthIfExtSwitchMode().intValue() == 2 && tmpIfExtTbl.getUtsEthIfExtIpAddress().equals("0.0.0.0"))) {
                        list.add(tmpIfExtTbl.getUtsEthIfExtModuleId() + "/" + tmpIfExtTbl.getUtsEthIfExtPortId());
                    }
                } else if (portType == 2) {
                    if (tmpIfExtTbl.getUtsEthIfExtSwitchMode().intValue() == 1) {
                        list.add("lg" + tmpIfExtTbl.getUtsEthIfExtLinkAggGroupId());
                    }
                } else if (portType == 4) {
                    if (tmpIfExtTbl.getUtsEthIfExtSwitchMode().intValue() == 1) {
                        list.add("vlan" + tmpIfExtTbl.getUtsEthIfExtVlanId());
                    }
                }
            }

            // remove port that in Link Aggregation set
            LinkAggregation lgMBean = new LinkAggregation(aSnmpProxy);
            Vector lgVec = lgMBean.retrieveAll();
            if (lgVec == null)
                lgVec = new Vector(0);

            Set l2PortInLGSet = new HashSet();
            for (int i = 0; i < lgVec.size(); i++) {
                LinkAggregation tmpLGMBean = (LinkAggregation) lgVec.get(i);
                String[] array = ConfigUtility.portMappingToStringArray(tmpLGMBean.getUtsLagExtDot3adAggPortListPorts());
                for (int j = 0; j < array.length; j++) {
                    l2PortInLGSet.add(array[j]);
                }
            }

            for (Iterator iter = l2PortInLGSet.iterator(); iter.hasNext();) {
                list.remove(iter.next());
            }

            // remove the vlan constained by Super VLAN.
            SuperSVITable sviTable = new SuperSVITable(aSnmpProxy);
            Vector sviVector = sviTable.retrieveAll();
            for (int i = 0; i < sviVector.size(); i++) {
                SuperSVITable svi = (SuperSVITable) sviVector.get(i);
                int[] vlan = ConfigUtility.VlanMappingToVlanArray(svi.getUtsIntfSuperSVIVlanMemberBitmap());
                for (int j = 0; j < vlan.length; j++) {
                    list.remove("vlan" + vlan[j]);
                }
            }

            // remove port and LG defined in VLAN table
            // 2006-11-16, remove this restriction as this operation has been
            // supported by NE
            /*
                * PortBasedVLAN portVLANMBean = new PortBasedVLAN( aSnmpProxy );
                * Vector vLANVec = portVLANMBean.retrieveAll(); if ( vLANVec ==
                * null ) vLANVec = new Vector(0);
                *
                * for ( int i = 0; i < vLANVec.size(); i++ ) { PortBasedVLAN
                * tmpPortVLAN = (PortBasedVLAN)vLANVec.elementAt(i); int tmpvlanIdx =
                * tmpPortVLAN.getUtsLagExtDot1qVlanIndex().intValue();
                *
                * if ( tmpvlanIdx == 1 ) continue;
                *
                * Set portListsStr = parsePortListString (
                * tmpPortVLAN.getUtsLagExtDot1qVlanPortListPorts() );
                *
                * for ( Iterator iter = portListsStr.iterator(); iter.hasNext(); ) {
                * list.remove( iter.next() ); } }
                */
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return (String[]) list.toArray(new String[0]);
    }

    protected Set parsePortListStringEthIfExt(String portListString) {
        Set portListSet = new HashSet();
        String[] portListArray = portListString.split(" ");
        for (int i = 0; i < portListArray.length; i++) {
            // parse link aggreagration
            if (portListArray[i].indexOf("lg") == 0) {
                portListSet.add(portListArray[i]);
                continue;
            }

            // parse port list
            String[] tmpPortRange = portListArray[i].split("/");
            if (tmpPortRange.length == 2) {
                int begB, begE, endB, endE;
                String[] tmpBegSlotRange = tmpPortRange[0].split("-");
                if (tmpBegSlotRange.length == 1) {
                    begB = begE = Integer.parseInt(tmpBegSlotRange[0]);
                } else if (tmpBegSlotRange.length == 2) {
                    begB = Integer.parseInt(tmpBegSlotRange[0]);
                    begE = Integer.parseInt(tmpBegSlotRange[1]);
                } else {
                    continue;
                }

                String[] tmpEndSlotRange = tmpPortRange[1].split("-");
                if (tmpEndSlotRange.length == 1) {
                    endB = endE = Integer.parseInt(tmpEndSlotRange[0]);
                } else if (tmpEndSlotRange.length == 2) {
                    endB = Integer.parseInt(tmpEndSlotRange[0]);
                    endE = Integer.parseInt(tmpEndSlotRange[1]);
                } else {
                    continue;
                }

                for (int begI = begB; begI <= begE; begI++) {
                    for (int endI = endB; endI <= endE; endI++) {
                        portListSet.add(begI + "/" + endI);
                    }
                }
            }
        }

        return portListSet;
    }

    public void refreshSecondIP(EthIfExtMixtureMBean mbean) {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //tfUtsIfSecondIpIfIndex.removeAllItems();
            //
            //ISnmpProxy aSnmpProxy = fApplication.getSnmpProxy();
            //PortTreeNodeBuilder builder = new PortTreeNodeBuilder(aSnmpProxy);
            //EthInterface[] threeLayerInterface = builder.getLayer3EthInterface();
            //for (int i = 0; i < threeLayerInterface.length; i++) {
            //  tfUtsIfSecondIpIfIndex.addItem(threeLayerInterface[i].getInterfaceID());
            //}
            //
            return;
        }
        //SecondIPAddressTable mbean = (SecondIPAddressTable) getModel();

        //tfUtsIfSecondIpIfIndex.setText(mbean.getUtsIfSecondIpIfIndex().toString());
        cbSecondIP.setSelected(mbean.isHasSencondIP());
        enableSecondIP(mbean.isHasSencondIP());
        if (mbean.isHasSencondIP()) {
            tfUtsIfSecondIpAddress.setValue(mbean.getUtsIfSecondIpAddress());
            tfUtsIfSecondIpNetmask.setValue(mbean.getUtsIfSecondIpNetmask());
        }
        //tfUtsIfSecondIpStatus.setSelectedIndex(getIndexFromValue(utsIfSecondIpStatusVList, mbean.getUtsIfSecondIpStatus().intValue()));
    }

    public boolean validateFromSecondIP() {
        try {
            if (!cbSecondIP.isSelected())
                return true;

            // if both second IP and second ip netmask are not changed, just return
            EthIfExtMixtureMBean mbean = (EthIfExtMixtureMBean) getModel();
            boolean bNotChanged = tfUtsIfSecondIpAddress.getIPString().equals(mbean.getUtsIfSecondIpAddress()) && tfUtsIfSecondIpNetmask.getIPString().equals(mbean.getUtsIfSecondIpNetmask());
            if (bNotChanged) {
                return true;
            }

            String thisIPAddr = tfUtsIfSecondIpAddress.getIPString();
            String thisIPMask = tfUtsIfSecondIpNetmask.getIPString();
            if (thisIPAddr.equals("0.0.0.0")) {
                MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_IP_Is_Zero"));
                return false;
            }
            if (thisIPMask.equals("0.0.0.0")) {
                MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Netmask_Is_Zero"));
                return false;
            }

            // Check whether both Primary IP Address and Second IP Address are in same Net
            String primaryIP = tfUtsEthIfExtIpAddress.getIPString();
            String netMaskPrimarySecond = ConfigUtility.compareNetMask(thisIPMask, primaryIP);
            String thisNetAddr = ConfigUtility.getSubnetAddress(thisIPAddr, netMaskPrimarySecond);
            String primaryNetAddr = ConfigUtility.getSubnetAddress(primaryIP, netMaskPrimarySecond);
            if (thisNetAddr.equals(primaryNetAddr)) {
                MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Duplicate_IP_In_Second_Layer3"));
                return false;
            }

            // validate second ip address ip address, network mask, etc.
            SecondIPAddressTable secIPAddrMBean = new SecondIPAddressTable(fApplication.getSnmpProxy());
            Vector secIPAddrVec = secIPAddrMBean.retrieveAll();
            for (int i = 0; secIPAddrVec != null && i < secIPAddrVec.size(); i++) {
                SecondIPAddressTable secIPAddrTbl = (SecondIPAddressTable) secIPAddrVec.elementAt(i);
                String tmpIPAddr = secIPAddrTbl.getUtsIfSecondIpAddress();
                String tmpIPMask = secIPAddrTbl.getUtsIfSecondIpNetmask();
                if (tmpIPAddr.equals("0.0.0.0") && tmpIPMask.equals("0.0.0.0"))
                    continue;

                String netMask = ConfigUtility.compareNetMask(thisIPMask, tmpIPMask);
                thisNetAddr = ConfigUtility.getSubnetAddress(thisIPAddr, netMask);
                String tmpNetAddr = ConfigUtility.getSubnetAddress(tmpIPAddr, netMask);
                if (thisNetAddr.equals(tmpNetAddr)) {
                    MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Duplicate_IP_In_Second_Layer3"));
                    return false;
                }
            }

            // validate EthIfExt Table's ip address, network mask, etc.
            EthIfExtTable ifExtMBean = new EthIfExtTable(fApplication.getSnmpProxy());
            Vector ifExtVec = ifExtMBean.retrieveAll();
            if (thisIPAddr.equals("0.0.0.0")) {
                MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_IP_Is_Zero"));
                return false;
            }
            if (thisIPMask.equals("0.0.0.0")) {
                MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Netmask_Is_Zero"));
                return false;
            }

            for (int i = 0; ifExtVec != null && i < ifExtVec.size(); i++) {
                EthIfExtTable tmpIfExtTbl = (EthIfExtTable) ifExtVec.elementAt(i);
                String tmpIPAddr = tmpIfExtTbl.getUtsEthIfExtIpAddress();
                String tmpIPMask = tmpIfExtTbl.getUtsEthIfExtIpNetmask();

                if (tmpIPAddr.equals("0.0.0.0") && tmpIPMask.equals("0.0.0.0"))
                    continue;

                String netMask = ConfigUtility.compareNetMask(thisIPMask, tmpIPMask);
                thisNetAddr = ConfigUtility.getSubnetAddress(thisIPAddr, netMask);
                String tmpNetAddr = ConfigUtility.getSubnetAddress(tmpIPAddr, netMask);
                if (thisNetAddr.equals(tmpNetAddr)) {
                    MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Duplicate_IP_In_Layer3"));
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }

    public void updateModelSecondIP(EthIfExtMixtureMBean mbean) {
        //if (SnmpAction.IType.ADD.equals(fCommand))
        //  setModel(new SecondIPAddressTable(fApplication.getSnmpProxy()));
        //
        //SecondIPAddressTable mbean = (SecondIPAddressTable) getModel();

        boolean selected = cbSecondIP.isSelected();
        // no select Second IP, and has Second IP, should delete the second IP entry.
        if (!selected) {
            try {
                if (mbean.isHasSencondIP()) {
                    mbean.deleteOldSecondIP();
                    mbean.setHasSencondIP(selected);
                    mbean.setUtsIfSecondIpAddress("");
                    mbean.setUtsIfSecondIpNetmask("");
                }
            } catch (Exception ex) {
            }
            return;
        } else {
            boolean bNotChanged = tfUtsIfSecondIpAddress.getIPString().equals(mbean.getUtsIfSecondIpAddress()) && tfUtsIfSecondIpNetmask.getIPString().equals(mbean.getUtsIfSecondIpNetmask());
            // selected and Not changed.
            if (bNotChanged) {
                return;
            }

            // Selected and Changed. Firstly delete the old Second IP Entry, then add the new Entry.
            try {
                if (mbean.isHasSencondIP()) {
                    mbean.deleteOldSecondIP();
                }
            } catch (Exception ex) {
            }

            mbean.setHasSencondIP(selected);
//			if (SnmpAction.IType.ADD.equals(fCommand)) {
//				// here set the value of index
//				//mbean.setUtsIfSecondIpIfIndex(new Integer(ConfigUtility.generateIfIndex(tfUtsIfSecondIpIfIndex.getSelectedItem().toString())));
//				mbean.setUtsIfSecondIpIfIndex(new Integer(ConfigUtility.generateIfIndex(tfIfIndex.getSelectedItem().toString())));
//			}

            mbean.setUtsIfSecondIpIfIndex(new Integer(ConfigUtility.generateIfIndex(tfIfIndex.getSelectedItem().toString())));
            mbean.setUtsIfSecondIpAddress(tfUtsIfSecondIpAddress.getIPString());
            mbean.setUtsIfSecondIpNetmask(tfUtsIfSecondIpNetmask.getIPString());

            // Add the new Second IP entry.
            try {
            	if (!SnmpAction.IType.ADD.equals(fCommand)) {
            		mbean.addNewSecondIP();
            	}
            } catch (MibBeanException e) {
                e.printStackTrace();
            }
        }
        //mbean.setUtsIfSecondIpStatus(new Integer(utsIfSecondIpStatusVList[tfUtsIfSecondIpStatus.getSelectedIndex()]));
    }

    public int getIndexFromValueSecondIP(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public void refreshSuperSVI(EthIfExtMixtureMBean mbean) {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //tfUtsIntfSuperSVIVlanId.removeAllItems();
            //String[] vlan = getVlanForAdd();
            //for (int i = 0; i < vlan.length; i++) {
            //  tfUtsIntfSuperSVIVlanId.addItem(vlan[i]);
            //}
            return;
        }

        //SuperSVITable mbean = (SuperSVITable) getModel();
        //tfUtsIntfSuperSVIVlanId.setEditable(false);
        //tfUtsIntfSuperSVIVlanId.removeAllItems();
        //tfUtsIntfSuperSVIVlanId.addItem("" + mbean.getUtsIntfSuperSVIVlanId());

        cbHasSVI.setSelected(mbean.isHasSVI());
        enableHasSVI(mbean.isHasSVI());
        if (mbean.isHasSVI()) {
            vlanListInputPanel.setVlanList(mbean.getUtsIntfSuperSVIVlanMemberBitmap());
        }
    }

    public void updateModelSuperSVI(EthIfExtMixtureMBean mbean) {
        //if (SnmpAction.IType.ADD.equals(fCommand))
        //  setModel(new SuperSVITable(fApplication.getSnmpProxy()));
        //
        //SuperSVITable mbean = (SuperSVITable) getModel();

        boolean selected = cbHasSVI.isSelected();
        if (!selected) {
            if (mbean.isHasSVI()) {
                try {
                    mbean.deleteOldSVI();
                    mbean.setHasSVI(selected);
                    mbean.setUtsIntfSuperSVIVlanId(-1);
                } catch (MibBeanException e) {
                    e.printStackTrace();
                }
            }
            return;
        } else {
            String index = tfIfIndex.getSelectedItem().toString();
            if (index.startsWith("vlan")) {
                index = index.substring(4);
            }

            byte[] bitMap = vlanListInputPanel.getVlanList();
            boolean bNotChanged = index.equals(mbean.getUtsIntfSuperSVIVlanId()) && bitMap.equals(mbean.getUtsIntfSuperSVIVlanMemberBitmap());

            if (bNotChanged) {
                return;
            }

            if (mbean.isHasSVI()) {
                try {
                    mbean.deleteOldSVI();
                } catch (MibBeanException e) {
                    e.printStackTrace();
                }
            }
            mbean.setHasSVI(selected);
            mbean.setUtsIntfSuperSVIVlanId(new Integer(index));
            mbean.setUtsIntfSuperSVIVlanMemberBitmap(vlanListInputPanel.getVlanList());

            try {
            	if (!SnmpAction.IType.ADD.equals(fCommand)) {
            		mbean.addNewSVI();
            	}
            } catch (MibBeanException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean validateFromSuperSVI() {
        //String vlanID = (String) tfUtsIntfSuperSVIVlanId.getSelectedItem();
        //
        //if (vlanID == null) {
        //  String error = fStringMap.getString("Err_Super_VLAN_Is_Empty");
        //  MessageDialog.showInfoMessageDialog(fApplication, error);
        //  return false;
        //}

        if (!cbHasSVI.isSelected())
            return true;

        String result = vlanListInputPanel.validateForm();
        if (result != null) {
            MessageDialog.showInfoMessageDialog(fApplication, result);
            return false;
        }

        return true;
    }

    private String[] getVlanForAddSuperSVI() {
        ArrayList list = new ArrayList();

        EthInterface[] layer3Vlan = getLayer3VlanSuperSVI();
        SuperVlanInterface[] superVlan = SuperVlanInterface.getSuperVlanInterface(this.fApplication.getSnmpProxy());

        for (int i = 0; i < layer3Vlan.length; i++) {
            String vlan = layer3Vlan[i].getInterfaceID().substring(4);
            for (int j = 0; j < superVlan.length; j++) {
                if (vlan != null && vlan.equals(superVlan[j].getVlanId())) {
                    vlan = null;
                }
            }

            if (vlan != null) {
                list.add(vlan);
            }
        }

        return (String[]) list.toArray(new String[0]);
    }

    private EthInterface[] getLayer3VlanSuperSVI() {
        ArrayList list = new ArrayList();
        PortTreeNodeBuilder builder = new PortTreeNodeBuilder(this.fApplication.getSnmpProxy());
        EthInterface[] layer3Interface = builder.getLayer3EthInterface();

        for (int i = 0; i < layer3Interface.length; i++) {
            if (layer3Interface[i].getInterfaceID().indexOf("vlan") != -1) {
                list.add(layer3Interface[i]);
            }
        }

        return (EthInterface[]) list.toArray(new EthInterface[0]);
    }

    private boolean isVlanIndex() {
        try {
            String selectedIndex = (String) tfIfIndex.getSelectedItem();
            return selectedIndex.indexOf("vlan") != -1;
        } catch (Exception ex) {
            return false;
        }
    }

    private Integer getVlanID(String index) {
        index = index.substring(4);
        return Integer.parseInt(index);
    }

    public void actionPerformed(ActionEvent e) {
        //String value = (String) tfUtsIntfSuperSVIVlanId.getSelectedItem();
        String cmdStr = e.getActionCommand();
        if ("ifindex".equals(cmdStr)) {
            if (isVlanIndex()) {
                cbHasSVI.setEnabled(true);
                String value = (String) tfIfIndex.getSelectedItem();

                if (value != null) {
                    vlanListInputPanel.setSuperSVI(getVlanID(value));
                }
            } else {
                cbHasSVI.setEnabled(false);
            }
        }

        if ("secondip".equals(cmdStr)) {
            boolean enable = cbSecondIP.isSelected();
            enableSecondIP(enable);
        }

        if ("hassvi".equals(cmdStr)) {
            boolean enable = cbHasSVI.isSelected();
            enableHasSVI(enable);
        }
    }

    private void enableHasSVI(boolean enabled) {
        cbHasSVI.setSelected(enabled);
        Component[] comps = vlanListInputPanel.getComponents();

        for (Component comp : comps) {
            comp.setEnabled(enabled);
        }
    }

    private void enableSecondIP(boolean enabled) {
        cbSecondIP.setSelected(enabled);
        tfUtsIfSecondIpAddress.setEnabled(enabled);
        tfUtsIfSecondIpNetmask.setEnabled(enabled);
    }

    public void refresh() {
        EthIfExtMixtureMBean mbean = (EthIfExtMixtureMBean) getModel();
        refreshEthIfExt(mbean);

        if (mbean.isHasSencondIP()) {
            refreshSecondIP(mbean);
        }
        enableSecondIP(mbean.isHasSencondIP());

        if (mbean.isHasSVI()) {
            refreshSuperSVI(mbean);
        }
        enableHasSVI(mbean.isHasSVI());

        if (isVlanIndex()) {
            cbHasSVI.setEnabled(true);
            String value = (String) tfIfIndex.getSelectedItem();

            if (value != null) {
                vlanListInputPanel.setSuperSVI(getVlanID(value));
            }
        } else {
            cbHasSVI.setEnabled(false);
        }
    }

    public boolean validateFrom() {
        return validateFromEthIfExt() && validateFromSecondIP() && validateFromSuperSVI();
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new EthIfExtMixtureMBean(fApplication.getSnmpProxy()));

        EthIfExtMixtureMBean mbean = (EthIfExtMixtureMBean) getModel();

        updateModelEthIfExt(mbean);
        updateModelSecondIP(mbean);
        updateModelSuperSVI(mbean);
    }

    public void itemStateChanged(ItemEvent e) {
        if (isVlanIndex()) {
            cbHasSVI.setEnabled(true);
            String value = (String) tfIfIndex.getSelectedItem();
            if (value != null) {
                vlanListInputPanel.setSuperSVI(getVlanID(value));
            }
        } else {
            cbHasSVI.setEnabled(false);
        }
    }

}