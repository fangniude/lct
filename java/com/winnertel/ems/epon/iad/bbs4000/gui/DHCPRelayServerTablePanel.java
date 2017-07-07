package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPRelayServerTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

//modified by Zhou Chao, 2009/1/9
public class DHCPRelayServerTablePanel extends UPanel {

    private JComboBox cbUtsDHCPRelayIfIndex = new JComboBox();
    private IPAddressField tfUtsDHCPRelayServerID = new IPAddressField();
    private IPAddressField tfUtsDHCPRelayGateway = new IPAddressField(); //(For NMS00064414) remarked by Zhou Chao, 2009/1/9
    private IPAddressField tfUtsDHCPRelaySecondServer = new IPAddressField();

    private final String utsDHCPRelayIfIndex = fStringMap.getString("utsDHCPRelayIfIndex") + ": ";
    private final String utsDHCPRelayServerID = fStringMap.getString("utsDHCPRelayServerID") + ": ";
    private final String utsDHCPRelayGateway = fStringMap.getString("utsDHCPRelayGateway") + ": "; //(For NMS00064414) remarked by Zhou Chao, 2009/1/9
    private final String utsDHCPRelaySecondServer = fStringMap.getString("utsDHCPRelaySecondServer") + ": ";

    public DHCPRelayServerTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDHCPRelayIfIndex));
        cbUtsDHCPRelayIfIndex.setName(fStringMap.getString("utsDHCPRelayIfIndex"));
        baseInfoPanel.add(cbUtsDHCPRelayIfIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDHCPRelayServerID));
        tfUtsDHCPRelayServerID.setName(fStringMap.getString("utsDHCPRelayServerID"));
        baseInfoPanel.add(tfUtsDHCPRelayServerID);
        baseInfoPanel.add(new HSpacer());

        
        baseInfoPanel.add(new JLabel(utsDHCPRelayGateway));
        tfUtsDHCPRelayGateway.setName(fStringMap.getString("utsDHCPRelayGateway"));
        baseInfoPanel.add(tfUtsDHCPRelayGateway);
        baseInfoPanel.add(new HSpacer());
        

        baseInfoPanel.add(new JLabel(utsDHCPRelaySecondServer));
        tfUtsDHCPRelaySecondServer.setName(fStringMap.getString("utsDHCPRelaySecondServer"));
        baseInfoPanel.add(tfUtsDHCPRelaySecondServer);
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
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            cbUtsDHCPRelayIfIndex.removeAllItems();
            EthIfExtTable tablembean = new EthIfExtTable(fApplication.getSnmpProxy());
            DHCPRelayServerTable mbean = new DHCPRelayServerTable(fApplication.getSnmpProxy());
            Vector v = BeanService.refreshTableBean(fApplication, tablembean);
            Vector serverv = BeanService.refreshTableBean(fApplication, mbean);
            if (v != null) {
                for (int i = 0; i < v.size(); i++) {
                    EthIfExtTable one = (EthIfExtTable) v.get(i);
                    String index = ConfigUtility.formatIfIndex(one.getIfIndex().toString());
                    if (index.length() >= 4) {
                        if (index.substring(0, 4).compareToIgnoreCase("vlan") == 0) {
                            if (serverv != null && serverv.size() != 0) {
                                int j = 0;
                                for (j = 0; j < serverv.size(); j++) {
                                    DHCPRelayServerTable serverone = (DHCPRelayServerTable) serverv.get(j);
                                    if (index.equals(ConfigUtility.formatIfIndex(serverone.getUtsDHCPRelayIfIndex().toString())))
                                        break;
                                }
                                if (j == serverv.size())
                                    cbUtsDHCPRelayIfIndex.addItem(index);
                            } else
                                cbUtsDHCPRelayIfIndex.addItem(index);
                        }
                    }
                }

                return;
            }
        }

        if (SnmpAction.IType.MODIFY.equals(fCommand)) {
            DHCPRelayServerTable mbean = (DHCPRelayServerTable) getModel();
            cbUtsDHCPRelayIfIndex.addItem(ConfigUtility.formatIfIndex(mbean.getUtsDHCPRelayIfIndex().toString()));
            cbUtsDHCPRelayIfIndex.setEnabled(false);
            //tfUtsDHCPRelayIfIndex.setValue(mbean.getUtsDHCPRelayIfIndex());
            tfUtsDHCPRelayServerID.setValue(mbean.getUtsDHCPRelayServerID());
            tfUtsDHCPRelayGateway.setValue(mbean.getUtsDHCPRelayGateway()); //(For NMS00064414) remarked by Zhou Chao, 2009/1/9
            //tfUtsDHCPRelayStatus.setSelectedIndex(getIndexFromValue(utsDHCPRelayStatusVList, mbean.getUtsDHCPRelayStatus()));
            tfUtsDHCPRelaySecondServer.setValue(mbean.getUtsDHCPRelaySecondServer());
        }
    }

    public boolean validateFrom() {
        /*
        DHCPGeneral mbean = new DHCPGeneral(fApplication.getSnmpProxy());
        BeanService.refreshBean(fApplication, mbean);
        if (!(mbean.getUtsDHCPServiceState().intValue() == 3)) {
            String error = "Please set the DHCP Service status to " + "Relay Active before adding the Relay Server.";
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }
        */

        if (tfUtsDHCPRelayServerID.getIPString().equals("0.0.0.0")
            || tfUtsDHCPRelayGateway.getIPString().equals("0.0.0.0") //(For NMS00064414) remarked by Zhou Chao, 2009/1/9
                ) {
            String error = fStringMap.getString("Err_Server_Or_Gateway_Ip_Is_Zero");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            DHCPRelayServerTable thismbean = new DHCPRelayServerTable(fApplication.getSnmpProxy());
            Vector v = new Vector();
            try {
                v = thismbean.retrieveAll();
            } catch (MibBeanException e) {
                e.printStackTrace();
            }
            int index = ConfigUtility.generateIfIndex(cbUtsDHCPRelayIfIndex.getSelectedItem().toString());
            if (v != null) {
                for (int i = 0; i < v.size(); i++) {
                    DHCPRelayServerTable one = (DHCPRelayServerTable) v.get(i);
                    if (one.getUtsDHCPRelayIfIndex() == index) {
                        String error = fStringMap.getString("Err_Port_Exist");
                        MessageDialog.showErrorMessageDialog(fApplication, error);
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new DHCPRelayServerTable(fApplication.getSnmpProxy()));

        DHCPRelayServerTable mbean = (DHCPRelayServerTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            int index = ConfigUtility.generateIfIndex(cbUtsDHCPRelayIfIndex.getSelectedItem().toString());
            mbean.setUtsDHCPRelayIfIndex(index);
        }
        /*
        String secondIP = tfUtsDHCPRelaySecondServer.getIPString();
        if (secondIP.equals("") || secondIP.equals("0.0.0.0")) {
            tfUtsDHCPRelaySecondServer.setValue(tfUtsDHCPRelayGateway.getIPString());
        }
        */ //(For NMS00064414) remarked by Zhou Chao, 2009/1/9

        mbean.setUtsDHCPRelayServerID(tfUtsDHCPRelayServerID.getIPString());
        mbean.setUtsDHCPRelayGateway(tfUtsDHCPRelayGateway.getIPString()); //(For NMS00064414) remarked by Zhou Chao, 2009/1/9
        //mbean.setUtsDHCPRelayStatus(utsDHCPRelayStatusVList[tfUtsDHCPRelayStatus.getSelectedIndex()]);
        mbean.setUtsDHCPRelaySecondServer(tfUtsDHCPRelaySecondServer.getIPString());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public void afterUpdateModel() {
        GuiUtil.getParentDialog(this).dispose();
    }

}