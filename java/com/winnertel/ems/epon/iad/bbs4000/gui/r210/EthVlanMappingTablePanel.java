package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r210.EthVlanMappingTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r210.PortBasedVLAN;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

public class EthVlanMappingTablePanel extends UPanel implements ActionListener {

    private JComboBox tfUtsEthVlanMappingIfIndex = new JComboBox();

    private JComboBox tfUtsEthVlanMappingInnerVID = new JComboBox();
    private JComboBox tfUtsEthVlanMappingOuterVID = new JComboBox();

    private int[] utsEthSmartQinQFrameTypeVList = new int[]{1, 2,};
    private String[] utsEthSmartQinQFrameTypeTList = new String[]{
            fStringMap.getString("singletag"),
            fStringMap.getString("doubletag"),
    };
    private JComboBox tfutsEthVlanMappingTagMode = new JComboBox(utsEthSmartQinQFrameTypeTList);

    private HashMap map = new HashMap();

    private final String utsEthVlanMappingIfIndex = fStringMap.getString("utsEthVlanMappingIfIndex") + ": ";
    private final String utsEthVlanMappingInnerVID = fStringMap.getString("utsEthVlanMappingInnerVID") + ": ";
    private final String utsEthVlanMappingOuterVID = fStringMap.getString("utsEthVlanMappingOuterVID") + ": ";
    private final String utsEthVlanMappingTagMode = fStringMap.getString("utsEthVlanMappingTagMode") + ": ";

    public EthVlanMappingTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsEthVlanMappingIfIndex));
        tfUtsEthVlanMappingIfIndex.setName(fStringMap.getString("utsEthVlanMappingModuleID"));
        tfUtsEthVlanMappingIfIndex.addActionListener(this);
        baseInfoPanel.add(tfUtsEthVlanMappingIfIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthVlanMappingInnerVID));
        tfUtsEthVlanMappingInnerVID.setName(fStringMap.getString("utsEthVlanMappingInnerVID"));
        tfUtsEthVlanMappingInnerVID.addActionListener(this);
        baseInfoPanel.add(tfUtsEthVlanMappingInnerVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthVlanMappingOuterVID));
        tfUtsEthVlanMappingOuterVID.setName(fStringMap.getString("utsEthSmartQinQEtherType"));
        baseInfoPanel.add(tfUtsEthVlanMappingOuterVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthVlanMappingTagMode));
        tfutsEthVlanMappingTagMode.setName(fStringMap.getString("utsEthVlanMappingTagMode"));
        baseInfoPanel.add(tfutsEthVlanMappingTagMode);
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

    public void refresh() {
        map.clear();
        tfUtsEthVlanMappingIfIndex.removeActionListener(this);
        tfUtsEthVlanMappingIfIndex.removeAllItems();
        tfUtsEthVlanMappingIfIndex.addActionListener(this);

        Vector ifIndexList = new Vector();

        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector cardList = BeanService.refreshTableBean(fApplication, bean);
        System.out.println( "EthVlanMappingTablePanel.refresh version=" + fApplication.getActiveDeviceManager().getVersion() );
        for (int i = 0; i < cardList.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) cardList.get(i);
            System.out.println("EthVlanMappingTablePanel.refresh card=" + card.getUtsEponModuleBoardType() + "," + card.getUtsEponModuleBoardPhyId() );
            if(fApplication.getActiveDeviceManager().getVersion().startsWith("1.")){//GPON version start with "1.x.x"
            	if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                    for (int j = 1; j <= 4; j++) {
                        ifIndexList.add(card.getUtsEponModuleBoardPhyId() + "/" + j);
                    }
                }	
            	else
            		if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
            			for (int j = 1; j <= 4; j++) {
            				ifIndexList.add(card.getUtsEponModuleBoardPhyId() + "/" + j);
            			}
            		}
            }
        }

        PortBasedVLAN vlan = new PortBasedVLAN(fApplication.getSnmpProxy());
        Vector vlanList = BeanService.refreshTableBean(fApplication, vlan);

        System.out.println("EthVlanMappingTablePanel.refresh vlan list=" + vlanList.size() );
        for (int i = 0; i < vlanList.size(); i++) {
            vlan = (PortBasedVLAN) vlanList.get(i);
            String[] portList = ConfigUtility.portMappingToStringArray(vlan.getUtsLagExtDot1qVlanPortListPorts());
            for (int j = 0; j < portList.length; j++) {
                if (ifIndexList.contains(portList[j])) {
                    Vector list = (Vector) map.get(portList[j]);
                    if (list == null) {
                        list = new Vector();
                        map.put(portList[j], list);
                    }
                    if (!list.contains(vlan.getUtsLagExtDot1qVlanIndex())) {
                        list.add(vlan.getUtsLagExtDot1qVlanIndex());
                    }
                }
            }
        }

//        int index = 0;
//        while (index < ifIndexList.size()) {
//            String ifIndex = (String) ifIndexList.get(index);
//            Vector list = (Vector) map.get( ifIndex );
//            if (list == null || list.size() < 2) {
//                System.out.println("EthVlanMappingTablePanel.refresh find ifIndex exists in vlan table:" + ifIndex );
//                ifIndexList.remove(index);
//            } else {
//                index++;
//            }
//        }

        for (int i = 0; i < ifIndexList.size(); i++) {
            tfUtsEthVlanMappingIfIndex.addItem(ifIndexList.get(i));
        }
    }

    public boolean validateFrom() {
        if (tfUtsEthVlanMappingIfIndex.getSelectedIndex() == -1) {
            String msg = fStringMap.getString("Err_If_Index_Is_Null");
            MessageDialog.showInfoMessageDialog(fApplication, msg);

            return false;
        }

        EthVlanMappingTable bean = new EthVlanMappingTable(fApplication.getSnmpProxy());
        Vector mappingList = BeanService.refreshTableBean(fApplication, bean);

        for (int i = 0; i < mappingList.size(); i++) {
            bean = (EthVlanMappingTable) mappingList.get(i);

            //The recorder exists in system.
            if (tfUtsEthVlanMappingIfIndex.getSelectedItem().equals(bean.getUtsEthVlanMappingIfIndex())
                    && Integer.parseInt(((String) tfUtsEthVlanMappingInnerVID.getSelectedItem()).substring(4)) == bean.getUtsEthVlanMappingInnerVID()
                    && Integer.parseInt(((String) tfUtsEthVlanMappingOuterVID.getSelectedItem()).substring(4)) == bean.getUtsEthVlanMappingOuterVID()
                    ) {
                String msg = fStringMap.getString("Err_Vlan_Mapping_Exists");
                MessageDialog.showInfoMessageDialog(fApplication, msg);

                return false;
            }
        }

        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new EthVlanMappingTable(fApplication.getSnmpProxy()));
        }

        EthVlanMappingTable mbean = (EthVlanMappingTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            String ifIndex = (String) tfUtsEthVlanMappingIfIndex.getSelectedItem();
            String[] split = ifIndex.split("/");
            mbean.setUtsEthVlanMappingModuleID(Integer.parseInt(split[0]));
            mbean.setUtsEthVlanMappingPortID(Integer.parseInt(split[1]));
            mbean.setUtsEthVlanMappingInnerVID(Integer.parseInt(((String) tfUtsEthVlanMappingInnerVID.getSelectedItem()).substring(4)));
            mbean.setUtsEthVlanMappingOuterVID(Integer.parseInt(((String) tfUtsEthVlanMappingOuterVID.getSelectedItem()).substring(4)));
            mbean.setUtsEthVlanMappingTagMode(utsEthSmartQinQFrameTypeVList[tfutsEthVlanMappingTagMode.getSelectedIndex()]);
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        Vector v = (Vector) map.get(tfUtsEthVlanMappingIfIndex.getSelectedItem());
        if (e.getSource() == tfUtsEthVlanMappingIfIndex) {
            tfUtsEthVlanMappingInnerVID.removeAllItems();
            for (int i = 0; i < v.size(); i++) {
                tfUtsEthVlanMappingInnerVID.addItem("vlan" + v.get(i));
            }
        } else if (e.getSource() == tfUtsEthVlanMappingInnerVID) {
            tfUtsEthVlanMappingOuterVID.removeAllItems();
            for (int i = 0; i < v.size(); i++) {
                //if (i != tfUtsEthVlanMappingInnerVID.getSelectedIndex()) { //remarked by Zhou Chao
                tfUtsEthVlanMappingOuterVID.addItem("vlan" + v.get(i));
                //}
            }
        }
    }

}