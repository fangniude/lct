package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.EthSmartQinQTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.HexTextField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class EthSmartQinQTablePanel extends UPanel {
    private JComboBox tfUtsEthSmartQinQModuleID = new JComboBox();
    private JComboBox tfUtsEthSmartQinQPortID = new JComboBox();
    private int[] utsEthSmartQinQFrameTypeVList = new int[]{1, 2, 3};
    private String[] utsEthSmartQinQFrameTypeTList = new String[]{
            fStringMap.getString("EthernetII"), fStringMap.getString("SNAP"),
            fStringMap.getString("LLC")
    };
    private JComboBox tfUtsEthSmartQinQFrameType = new JComboBox(utsEthSmartQinQFrameTypeTList);

    /* remarked by Zhou Chao, 2008/7/3
    private int[] utsEthSmartQinQEtherTypeVList = new int[] {0x0806, 0x0803, 0x0800};
    private String[] utsEthSmartQinQEtherTypeTList = new String[] {
        fStringMap.getString("ARP"),
        fStringMap.getString("ECMA"),
        fStringMap.getString("IP")
    };
    */
    //private JComboBox tfUtsEthSmartQinQEtherType = new JComboBox(utsEthSmartQinQEtherTypeTList); //remarked by Zhou Chao, 2008/7/3
    private HexTextField tfUtsEthSmartQinQEtherType = new HexTextField(); //added by Zhou Chao, 2008/7/3
    private IntegerTextField tfUtsEthSmartQinQOutterVLANID = new IntegerTextField();

    private BaseModuleType fModuleType = new ModuleType();

    private final String utsEthSmartQinQModuleID = fStringMap.getString("utsEthSmartQinQModuleID") + " : ";
    private final String utsEthSmartQinQPortID = fStringMap.getString("utsEthSmartQinQPortID") + " : ";
    private final String utsEthSmartQinQFrameType = fStringMap.getString("utsEthSmartQinQFrameType") + " : ";
    private final String utsEthSmartQinQEtherType = fStringMap.getString("utsEthSmartQinQEtherType") + " : ";
    private final String utsEthSmartQinQOutterVLANID = fStringMap.getString("utsEthSmartQinQOutterVLANID") + " : ";

    public EthSmartQinQTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        for (int i = 1; i <= 4; i++) {
            tfUtsEthSmartQinQPortID.addItem(i);
        }

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsEthSmartQinQModuleID));
        tfUtsEthSmartQinQModuleID.setName(fStringMap.getString("utsEthSmartQinQModuleID"));
        baseInfoPanel.add(tfUtsEthSmartQinQModuleID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthSmartQinQPortID));
        tfUtsEthSmartQinQPortID.setName(fStringMap.getString("utsEthSmartQinQPortID"));
        baseInfoPanel.add(tfUtsEthSmartQinQPortID);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEthSmartQinQFrameType));
        tfUtsEthSmartQinQFrameType.setName(fStringMap.getString("utsEthSmartQinQFrameType"));
        baseInfoPanel.add(tfUtsEthSmartQinQFrameType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthSmartQinQEtherType));
        tfUtsEthSmartQinQEtherType.setName(fStringMap.getString("utsEthSmartQinQEtherType"));
        baseInfoPanel.add(tfUtsEthSmartQinQEtherType);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEthSmartQinQOutterVLANID));
        tfUtsEthSmartQinQOutterVLANID.setName(fStringMap.getString("utsEthSmartQinQOutterVLANID"));
        baseInfoPanel.add(tfUtsEthSmartQinQOutterVLANID);
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
        tfUtsEthSmartQinQOutterVLANID.setValueScope(1, 4094);
    }

    public void refresh() {
        tfUtsEthSmartQinQModuleID.removeAllItems();

        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, bean);

        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                bean = (BBS4000CardMibBean) v.get(i);

                if (fModuleType.isGPMModule(bean.getUtsEponModuleBoardType())) {
                    tfUtsEthSmartQinQModuleID.addItem(bean.getUtsEponModuleBoardPhyId());
                }
            }
        }
    }

    public boolean validateFrom() {
        if (tfUtsEthSmartQinQModuleID.getSelectedIndex() == -1) {
            String msg = fStringMap.getString("Err_Module_Id_Is_Null");
            MessageDialog.showInfoMessageDialog(fApplication, msg);

            return false;
        }

        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new EthSmartQinQTable(fApplication.getSnmpProxy()));
        }

        EthSmartQinQTable mbean = (EthSmartQinQTable) getModel();
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            Integer card = (Integer) tfUtsEthSmartQinQModuleID.getSelectedItem();
            Integer port = (Integer) (Integer) tfUtsEthSmartQinQPortID.getSelectedItem();
            mbean.setIfIndex(ConfigUtility.generateIfIndex(card + "/" + port));
            mbean.setUtsEthSmartQinQModuleID(card);
            mbean.setUtsEthSmartQinQPortID(port);
            mbean.setUtsEthSmartQinQFrameType(utsEthSmartQinQFrameTypeVList[tfUtsEthSmartQinQFrameType.getSelectedIndex()]);
            //mbean.setUtsEthSmartQinQEtherType(utsEthSmartQinQEtherTypeVList[tfUtsEthSmartQinQEtherType.getSelectedIndex()]); //remarked by Zhou Chao, 2008/7/3
            mbean.setUtsEthSmartQinQEtherType(Integer.valueOf(tfUtsEthSmartQinQEtherType.getValue(), 16)); //added by Zhou Chao, 2008/7/3
        }

        mbean.setUtsEthSmartQinQOutterVLANID(tfUtsEthSmartQinQOutterVLANID.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }
}


