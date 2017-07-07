package com.winnertel.ems.epon.iad.bbs1000.gui.r341;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.TableModel;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.EthIntelligentLinkTable;

public class EthIntelligentLinkTablePanel extends UPanel implements ActionListener {
    private JComboBox tfUtsEthIntelligentLinkGroupId = new JComboBox();

//    private StringTextField tfUtsEthIntelligentLinkGroupName = new StringTextField();

    private int[] utsEthIntelligentLinkInterfaceTypeVList = new int[]{1, 2};
    private String[] utsEthIntelligentLinkInterfaceTypeTList = new String[]{
            fStringMap.getString("ethernetport"), fStringMap.getString("linkaggroup")
    };
    private JComboBox tfUtsEthIntelligentLinkInterfaceType = new JComboBox(utsEthIntelligentLinkInterfaceTypeTList);

    private JComboBox tfUtsEthIntelligentLinkMasterInterface = new JComboBox();
    private JComboBox tfUtsEthIntelligentLinkSlaveInterface = new JComboBox();

    private int[] utsEthIntelligentLinkAutoReturnVList = new int[] {0, 1};
    private String[] utsEthIntelligentLinkAutoReturnTList = new String[] {
            fStringMap.getString("disable"), fStringMap.getString("enable")
    };
    private JComboBox tfUtsEthIntelligentLinkAutoReturn = new JComboBox(utsEthIntelligentLinkAutoReturnTList);
    private IntegerTextField tfUtsEthIntelligentLinkAutoWtr = new IntegerTextField();

    private Vector geList = new Vector();
    private Vector lgList = new Vector();
    private final String utsEthIntelligentLinkGroupId = fStringMap.getString("utsEthIntelligentLinkGroupId") + " : ";
    private final String utsEthIntelligentLinkGroupName = fStringMap.getString("utsEthIntelligentLinkGroupName") + " : ";
    private final String utsEthIntelligentLinkInterfaceType = fStringMap.getString("utsEthIntelligentLinkInterfaceType") + " : ";
    private final String utsEthIntelligentLinkMasterInterface = fStringMap.getString("utsEthIntelligentLinkMasterInterface") + " : ";
    private final String utsEthIntelligentLinkSlaveInterface = fStringMap.getString("utsEthIntelligentLinkSlaveInterface") + " : ";
    private final String utsEthIntelligentLinkAutoReturn = fStringMap.getString("utsEthIntelligentLinkAutoReturn") + " : ";
    private final String utsEthIntelligentLinkAutoWtr = fStringMap.getString("utsEthIntelligentLinkAutoWtr") + " : ";

    public EthIntelligentLinkTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsEthIntelligentLinkGroupId));
        tfUtsEthIntelligentLinkGroupId.setName(fStringMap.getString("utsEthIntelligentLinkGroupId"));
        baseInfoPanel.add(tfUtsEthIntelligentLinkGroupId);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(utsEthIntelligentLinkGroupName));
//        tfUtsEthIntelligentLinkGroupName.setName(fStringMap.getString("utsEthIntelligentLinkGroupName"));
////        tfUtsEthIntelligentLinkGroupName.setEnabled(false);
//        baseInfoPanel.add(tfUtsEthIntelligentLinkGroupName);
//        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthIntelligentLinkInterfaceType));
        tfUtsEthIntelligentLinkInterfaceType.setName(fStringMap.getString("utsEthIntelligentLinkInterfaceType"));
        tfUtsEthIntelligentLinkInterfaceType.addActionListener(this);
        baseInfoPanel.add(tfUtsEthIntelligentLinkInterfaceType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthIntelligentLinkMasterInterface));
        tfUtsEthIntelligentLinkMasterInterface.setName(fStringMap.getString("utsEthIntelligentLinkMasterInterface"));
        baseInfoPanel.add(tfUtsEthIntelligentLinkMasterInterface);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthIntelligentLinkSlaveInterface));
        tfUtsEthIntelligentLinkSlaveInterface.setName(fStringMap.getString("utsEthIntelligentLinkSlaveInterface"));
        baseInfoPanel.add(tfUtsEthIntelligentLinkSlaveInterface);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthIntelligentLinkAutoReturn));
        tfUtsEthIntelligentLinkAutoReturn.setName(fStringMap.getString("utsEthIntelligentLinkAutoReturn"));
        baseInfoPanel.add(tfUtsEthIntelligentLinkAutoReturn);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthIntelligentLinkAutoWtr));
        tfUtsEthIntelligentLinkAutoWtr.setName(fStringMap.getString("utsEthIntelligentLinkAutoWtr"));
        baseInfoPanel.add(tfUtsEthIntelligentLinkAutoWtr);
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
//        tfUtsEthIntelligentLinkGroupName.setLenScope(0, 16);
        tfUtsEthIntelligentLinkAutoWtr.setValueScope(10, 3600);
    }

    public void refresh() {
        if(SnmpAction.IType.ADD.equals(fCommand)) {
            //group id
            tfUtsEthIntelligentLinkGroupId.removeAllItems();

            for(int i = 1; i <= 8; i++)
                tfUtsEthIntelligentLinkGroupId.addItem(i);

            EthIntelligentLinkTable mbean = new EthIntelligentLinkTable(fApplication.getSnmpProxy());

            Vector v = BeanService.refreshTableBean(fApplication, mbean);
            for(int i = 0; i < v.size(); i++)
                tfUtsEthIntelligentLinkGroupId.removeItem(((EthIntelligentLinkTable) v.get(i)).getUtsEthIntelligentLinkGroupId());

            //GE Port and LG.
            geList.clear();
            lgList.clear();
            BBS1000CardMibBean cardMBean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
            Vector cardList = BeanService.refreshTableBean(fApplication, cardMBean);
            ModuleType moduleType = new ModuleType();

            for(int i = 0; i < cardList.size(); i++) {
            	BBS1000CardMibBean card = (BBS1000CardMibBean) cardList.get(i);
                if(moduleType.isGSMModule(card.getUtsEponModuleBoardType())) {
                    for(int j = 1; j <= 4; j++) {
                        geList.add(card.getUtsEponModuleBoardPhyId() + "/" + j);
                    }
                }
            }

            LinkAggregation lgBean = new LinkAggregation(fApplication.getSnmpProxy());
            v = BeanService.refreshTableBean(fApplication, lgBean);
            for(int i = 0; i < v.size(); i++) {
                lgBean = (LinkAggregation) v.get(i);
                lgList.add("lg" + lgBean.getUtsLagExtDot3adAggGroupId());
                String[] ports = ConfigUtility.portMappingToStringArray(lgBean.getUtsLagExtDot3adAggPortListPorts());

                for(int j = 0; j < ports.length; j++) {
                    geList.remove(ports[j]);
                }
            }
            
            TableModel table = getTable().getModel();
            for(int i = 0; i < table.getRowCount(); i++) {
            	geList.remove(table.getValueAt(i, 2));
            	geList.remove(table.getValueAt(i, 4));
            }
        } else {
            EthIntelligentLinkTable mbean = (EthIntelligentLinkTable) getModel();

            tfUtsEthIntelligentLinkAutoReturn.setSelectedIndex(getIndexFromValue(utsEthIntelligentLinkAutoReturnVList, mbean.getUtsEthIntelligentLinkAutoReturn()));
            tfUtsEthIntelligentLinkAutoWtr.setValue(mbean.getUtsEthIntelligentLinkAutoWtr());
        }

        //
        actionPerformed(null);
    }

    public boolean validateFrom() {

        if(tfUtsEthIntelligentLinkMasterInterface.getSelectedIndex() == -1) {
            String err = fStringMap.getString("Err_Master_Interface_Is_Null");
            MessageDialog.showInfoMessageDialog(fApplication, err);
            return false;
        }

        if(tfUtsEthIntelligentLinkSlaveInterface.getSelectedIndex() == -1) {
            String err = fStringMap.getString("Err_Salve_Interface_Is_Null");
            MessageDialog.showInfoMessageDialog(fApplication, err);
            return false;
        }

        if(tfUtsEthIntelligentLinkMasterInterface.getSelectedIndex() == tfUtsEthIntelligentLinkSlaveInterface.getSelectedIndex())
        {
            String err = fStringMap.getString("Err_Master_Salve_Interface_Is_Same");
            MessageDialog.showInfoMessageDialog(fApplication, err);
            return false;
        }

        return true;
    }

    public void updateModel() {
        if(SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new EthIntelligentLinkTable(fApplication.getSnmpProxy()));

            EthIntelligentLinkTable mbean = (EthIntelligentLinkTable) getModel();
            mbean.setUtsEthIntelligentLinkGroupId((Integer) tfUtsEthIntelligentLinkGroupId.getSelectedItem());

//            if(tfUtsEthIntelligentLinkGroupName.isEnabled())
//                mbean.setUtsEthIntelligentLinkGroupName(tfUtsEthIntelligentLinkGroupName.getValue());

            mbean.setUtsEthIntelligentLinkMasterPortType(utsEthIntelligentLinkInterfaceTypeVList[tfUtsEthIntelligentLinkInterfaceType.getSelectedIndex()]);
            mbean.setUtsEthIntelligentLinkMasterInterface((String) tfUtsEthIntelligentLinkMasterInterface.getSelectedItem());
            mbean.setUtsEthIntelligentLinkSlavePortType(utsEthIntelligentLinkInterfaceTypeVList[tfUtsEthIntelligentLinkInterfaceType.getSelectedIndex()]);
            mbean.setUtsEthIntelligentLinkSlaveInterface((String) tfUtsEthIntelligentLinkSlaveInterface.getSelectedItem());
            mbean.setUtsEthIntelligentLinkAutoReturn(utsEthIntelligentLinkAutoReturnVList[tfUtsEthIntelligentLinkAutoReturn.getSelectedIndex()]);
            mbean.setUtsEthIntelligentLinkAutoWtr(tfUtsEthIntelligentLinkAutoWtr.getValue());
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for(int i = 0; i != list.length; i++) {
            if(list[i] == v) return i;
        }
        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        //ether port
        if(tfUtsEthIntelligentLinkInterfaceType.getSelectedIndex() == 0) {
            fill(tfUtsEthIntelligentLinkMasterInterface, geList);
            fill(tfUtsEthIntelligentLinkSlaveInterface, geList);
        } else {
            fill(tfUtsEthIntelligentLinkMasterInterface, lgList);
            fill(tfUtsEthIntelligentLinkSlaveInterface, lgList);
        }
    }

    private void fill(JComboBox box, Vector v) {
        box.removeAllItems();

        for(int i = 0; i < v.size(); i++) {
            box.addItem(v.get(i));
        }
    }
}
