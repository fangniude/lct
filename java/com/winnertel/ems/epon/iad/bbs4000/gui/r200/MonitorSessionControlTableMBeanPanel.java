package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.MonitorSessionControlTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MonitorSessionControlTableMBeanPanel extends UPanel implements ActionListener, ListSelectionListener {

    private JComboBox tfUtsMonitorSessionID = new JComboBox();
    private JComboBox tfUtsMonitorSessionModule = new JComboBox();
    private JComboBox tfUtsMonitorSessionPort = new JComboBox();
    private JList tfUtsMonitorSessionIngressPortBitLists = new JList();
    private JList tfUtsMonitorSessionEngressPortBitLists = new JList();
    private int[] utsMonitorSessionActiveVList = new int[]{1, 2};
    private String[] utsMonitorSessionActiveTList = new String[]{
            fStringMap.getString("enable"), fStringMap.getString("disable")
    };
    private JComboBox tfUtsMonitorSessionActive = new JComboBox(utsMonitorSessionActiveTList);

    private final String utsMonitorSessionID = fStringMap.getString("utsMonitorSessionID") + " : ";
    private final String utsMonitorSessionModule = fStringMap.getString("utsMonitorSessionModule") + " : ";
    private final String utsMonitorSessionPort = fStringMap.getString("utsMonitorSessionPort") + " : ";
    private final String utsMonitorSessionIngressPortBitLists = fStringMap.getString("utsMonitorSessionIngressPortBitLists") + " : ";
    private final String utsMonitorSessionEngressPortBitLists = fStringMap.getString("utsMonitorSessionEngressPortBitLists") + " : ";
    private final String utsMonitorSessionActive = fStringMap.getString("utsMonitorSessionActive");

    public MonitorSessionControlTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        //init the data
        for (int i = 1; i <= 4; i++) {
            tfUtsMonitorSessionPort.addItem(i);
        }

        for (int i = 1; i <= 11; i++) {
            tfUtsMonitorSessionModule.addItem(i);
        }

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsMonitorSessionID));
        tfUtsMonitorSessionID.setName(fStringMap.getString("utsMonitorSessionID"));
        tfUtsMonitorSessionID.addActionListener(this);
        baseInfoPanel.add(tfUtsMonitorSessionID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsMonitorSessionModule));
        tfUtsMonitorSessionModule.setName(fStringMap.getString("utsMonitorSessionModule"));
        tfUtsMonitorSessionModule.addActionListener(this);
        baseInfoPanel.add(tfUtsMonitorSessionModule);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsMonitorSessionPort));
        tfUtsMonitorSessionPort.setName(fStringMap.getString("utsMonitorSessionPort"));
        tfUtsMonitorSessionPort.addActionListener(this);
        baseInfoPanel.add(tfUtsMonitorSessionPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsMonitorSessionIngressPortBitLists));
        tfUtsMonitorSessionIngressPortBitLists.setName(fStringMap.getString("utsMonitorSessionIngressPortBitLists"));
        JScrollPane pane1 = new JScrollPane(tfUtsMonitorSessionIngressPortBitLists);
        pane1.setPreferredSize(new Dimension(120, 100));
        baseInfoPanel.add(pane1);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsMonitorSessionEngressPortBitLists));
        tfUtsMonitorSessionEngressPortBitLists.setName(fStringMap.getString("utsMonitorSessionEngressPortBitLists"));
        JScrollPane pane2 = new JScrollPane(tfUtsMonitorSessionEngressPortBitLists);
        pane2.setPreferredSize(new Dimension(120, 100));
        baseInfoPanel.add(pane2);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsMonitorSessionActive));
        tfUtsMonitorSessionActive.setName(utsMonitorSessionActive);
        baseInfoPanel.add(tfUtsMonitorSessionActive);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        tfUtsMonitorSessionIngressPortBitLists.addListSelectionListener(this);
        tfUtsMonitorSessionEngressPortBitLists.addListSelectionListener(this);
    }

    protected void initForm() {
    }

    public void refresh() {
        tfUtsMonitorSessionID.removeAllItems();
        for (int i = 1; i <= 4; i++) {
            tfUtsMonitorSessionID.addItem(i);
        }

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfUtsMonitorSessionID.setEnabled(true);

            MonitorSessionControlTableMBean mbean = new MonitorSessionControlTableMBean(fApplication.getSnmpProxy());
            Vector v = BeanService.refreshTableBean(fApplication, mbean);
            if (SnmpAction.IType.ADD.equals(fCommand)) {
                if (mbean != null) {
                    for (int i = 0; i < v.size(); i++) {
                        MonitorSessionControlTableMBean one = (MonitorSessionControlTableMBean) v.get(i);
                        tfUtsMonitorSessionID.removeItem(one.getUtsMonitorSessionID());
                    }
                }
            }

            return;
        }

        if (SnmpAction.IType.MODIFY.equals(fCommand)) {
            tfUtsMonitorSessionID.setEnabled(false);
        }

        MonitorSessionControlTableMBean mbean = (MonitorSessionControlTableMBean) getModel();
        tfUtsMonitorSessionID.setSelectedItem(mbean.getUtsMonitorSessionID());
        tfUtsMonitorSessionModule.setSelectedItem(mbean.getUtsMonitorSessionModule());
        tfUtsMonitorSessionPort.setSelectedItem(mbean.getUtsMonitorSessionPort());
        setPortBitList(tfUtsMonitorSessionIngressPortBitLists, mbean.getUtsMonitorSessionIngressPortBitLists());
        setPortBitList(tfUtsMonitorSessionEngressPortBitLists, mbean.getUtsMonitorSessionEngressPortBitLists());
        tfUtsMonitorSessionActive.setSelectedIndex(getIndexFromValue(utsMonitorSessionActiveVList, mbean.getUtsMonitorSessionActive().intValue()));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new MonitorSessionControlTableMBean(fApplication.getSnmpProxy()));
        }

        MonitorSessionControlTableMBean mbean = (MonitorSessionControlTableMBean) getModel();
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setUtsMonitorSessionID((Integer) tfUtsMonitorSessionID.getSelectedItem());
        }

        mbean.setUtsMonitorSessionModule((Integer) tfUtsMonitorSessionModule.getSelectedItem());
        mbean.setUtsMonitorSessionPort((Integer) tfUtsMonitorSessionPort.getSelectedItem());
        mbean.setUtsMonitorSessionIngressPortBitLists(getPortBitList(tfUtsMonitorSessionIngressPortBitLists));
        mbean.setUtsMonitorSessionEngressPortBitLists(getPortBitList(tfUtsMonitorSessionEngressPortBitLists));
        mbean.setUtsMonitorSessionActive(new Integer(utsMonitorSessionActiveVList[tfUtsMonitorSessionActive.getSelectedIndex()]));
    }

    protected byte[] getPortBitList(JList list) {
        Object[] objs = list.getSelectedValues();
        String[] array = new String[objs.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = objs[i].toString();
        }

        return ConfigUtility.StringArrayToPortMapping(array);
    }

    protected void setPortBitList(JList list, byte[] b) {
        String[] array = ConfigUtility.portMappingToStringArray(b);
        DefaultListModel model = (DefaultListModel) list.getModel();
        int[] indices = new int[array.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = model.indexOf(array[i]);
        }
        list.clearSelection();
        list.setSelectedIndices(indices);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    /*
    boolean startsWithNum(String str) {
        if (!(str.startsWith("lg") || str.startsWith("ge"))) {
            String[] split = str.split("/");
            if (split.length != 2)
                return false;

            //check the format like: 1-5/1-4.
            String[] cards = split[0].split("-");
            String[] ports = split[1].split("-");
            if (cards.length > 2 || ports.length > 2) return false;

            try {
                for (int i = 0; i < cards.length; i++) {
                    if (Integer.parseInt(cards[i]) < 1 || Integer.parseInt(cards[i]) > 12)
                        return false;
                }

                for (int i = 0; i < ports.length; i++) {
                    if (Integer.parseInt(ports[i]) < 1 || Integer.parseInt(ports[i]) > 4)
                        return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }
    */

    /*
    public void actionPerformed(ActionEvent e) {
        DefaultListModel model = new DefaultListModel();
        model.addElement(" ");
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 4; j++) {
                model.addElement(i + "/" + j);
            }
        }

        model.removeElement(tfUtsMonitorSessionModule.getSelectedItem() + "/" + tfUtsMonitorSessionPort.getSelectedItem());

        tfUtsMonitorSessionIngressPortBitLists.setModel(model);
        tfUtsMonitorSessionEngressPortBitLists.setModel(model);
    }
    */

    public void actionPerformed(ActionEvent e) {
        DefaultListModel model = new DefaultListModel();
        model.addElement(" ");

        Vector allPorts = null;
        try {
            allPorts = getPortList();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (allPorts != null) {
            for (int i = 0; i < allPorts.size(); i++) {
                model.addElement(allPorts.get(i));
            }
        }

        model.removeElement(tfUtsMonitorSessionModule.getSelectedItem() + "/" + tfUtsMonitorSessionPort.getSelectedItem());

        tfUtsMonitorSessionIngressPortBitLists.setModel(model);
        tfUtsMonitorSessionEngressPortBitLists.setModel(model);
    }

    private Vector getPortList() throws Exception {
        Vector allPortList = new Vector();
        /*
        BBS4000CardMibBean cardMBean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, cardMBean);
        ModuleType moduleType = new ModuleType();
        for (int i = 0; i < v.size(); i++) {
            int moduleBoardPhyId = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardPhyId();
            int moduleBoardType = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardType();
            int modulePhyPreStat = ((BBS4000CardMibBean) v.get(i)).getUtsEponModulePhyPresenceStat();
            int moduleAdminState = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleAdminState();
            if ((moduleType.isGEMModule(moduleBoardType) || moduleType.isEPMModule(moduleBoardType)) && modulePhyPreStat == 1 && moduleAdminState == 2) {
                for (int j = 1; j <= 4; j++) {
                    allPortList.add(moduleBoardPhyId + "/" + j);
                }
            }
        }
        */
        for (int i = 1; i <= 11; i++) {
            for (int j = 1; j <= 4; j++) {
                allPortList.add(i + "/" + j);
            }
        }

        EthIfExtTable portMBean = new EthIfExtTable(fApplication.getSnmpProxy());
        Vector portVec = portMBean.retrieveRealAll();
        // remove layer-3 ports and add vlan IDs
        for (int i = 0; i < portVec.size(); i++) {
            EthIfExtTable tmpL2PortTbl = (EthIfExtTable) portVec.elementAt(i);
            String portName = tmpL2PortTbl.getUtsEthIfExtModuleId() + "/" + tmpL2PortTbl.getUtsEthIfExtPortId();
            int tmpPortType = tmpL2PortTbl.getUtsEthIfExtPortType();
            int switchMode = tmpL2PortTbl.getUtsEthIfExtSwitchMode();
            if (tmpPortType == 1) {
                // remove layer-3 ports
                if (switchMode == 2) {
                    allPortList.remove(portName);
                }
            } else if (tmpPortType == 2 && switchMode == 1) { //lg and lay 2.
                allPortList.add("lg" + tmpL2PortTbl.getUtsEthIfExtLinkAggGroupId());
            }
        }

        // remove L2 port that in Link Aggregation set
        LinkAggregation lgMBean = new LinkAggregation(fApplication.getSnmpProxy());
        Vector lgVec = BeanService.refreshTableBean(fApplication, lgMBean);
        if (lgVec == null)
            lgVec = new Vector(0);
        for (int i = 0; i < lgVec.size(); i++) {
            LinkAggregation tmpLGMBean = (LinkAggregation) lgVec.get(i);
            String[] array = ConfigUtility.portMappingToStringArray(tmpLGMBean.getUtsLagExtDot3adAggPortListPorts());
            for (int j = 0; j < array.length; j++) {
                allPortList.remove(array[j]);
            }
        }

        return allPortList;
    }

    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList) e.getSource();
        if (list.isSelectedIndex(0))
            list.setSelectedIndex(0);
    }

}