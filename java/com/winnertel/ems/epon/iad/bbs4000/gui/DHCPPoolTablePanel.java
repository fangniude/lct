package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.snmp.SnmpUtility;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The DHCPPoolTablePanel class. Created by DVM Creator
 */
public class DHCPPoolTablePanel extends UPanel {

    private StringTextField tfUtsDHCPPoolName = new StringTextField();

    private IPAddressField tfUtsDHCPPoolNetworkAddress = new IPAddressField();

    private IPAddressField tfUtsDHCPPoolNetworkMask = new IPAddressField(true);

    private StringTextField tfUtsDHCPPoolClassId = new StringTextField();

    private IntegerTextField tfUtsDHCPPoolLeaseTime = new IntegerTextField();

    private StringTextField tfUtsDHCPPoolMeritDump = new StringTextField();

    private StringTextField tfUtsDHCPPoolRootPath = new StringTextField();

    private final String utsDHCPPoolName = fStringMap
            .getString("utsDHCPPoolName")
            + " : ";

    private final String utsDHCPPoolNetworkAddress = fStringMap
            .getString("utsDHCPPoolNetworkAddress")
            + " : ";

    private final String utsDHCPPoolNetworkMask = fStringMap
            .getString("utsDHCPPoolNetworkMask")
            + " : ";

    private final String utsDHCPPoolClassId = fStringMap
            .getString("utsDHCPPoolClassId")
            + " : ";

    private final String utsDHCPPoolLeaseTime = fStringMap
            .getString("utsDHCPPoolLeaseTime")
            + " : ";

    private final String utsDHCPPoolMeritDump = fStringMap
            .getString("utsDHCPPoolMeritDump")
            + " : ";

    private final String utsDHCPPoolRootPath = fStringMap
            .getString("utsDHCPPoolRootPath")
            + " : ";

    public DHCPPoolTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5,
                5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDHCPPoolName));
        tfUtsDHCPPoolName.setName(fStringMap.getString("utsDHCPPoolName"));
        baseInfoPanel.add(tfUtsDHCPPoolName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDHCPPoolNetworkAddress));
        tfUtsDHCPPoolNetworkAddress.setName(fStringMap
                .getString("utsDHCPPoolNetworkAddress"));
        baseInfoPanel.add(tfUtsDHCPPoolNetworkAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDHCPPoolNetworkMask));
        tfUtsDHCPPoolNetworkMask.setName(fStringMap
                .getString("utsDHCPPoolNetworkMask"));
        baseInfoPanel.add(tfUtsDHCPPoolNetworkMask);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDHCPPoolClassId));
        tfUtsDHCPPoolClassId
                .setName(fStringMap.getString("utsDHCPPoolClassId"));
        baseInfoPanel.add(tfUtsDHCPPoolClassId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDHCPPoolLeaseTime));
        tfUtsDHCPPoolLeaseTime.setName(fStringMap
                .getString("utsDHCPPoolLeaseTime"));
        baseInfoPanel.add(tfUtsDHCPPoolLeaseTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDHCPPoolMeritDump));
        tfUtsDHCPPoolMeritDump.setName(fStringMap
                .getString("utsDHCPPoolMeritDump"));
        baseInfoPanel.add(tfUtsDHCPPoolMeritDump);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDHCPPoolRootPath));
        tfUtsDHCPPoolRootPath.setName(fStringMap
                .getString("utsDHCPPoolRootPath"));
        baseInfoPanel.add(tfUtsDHCPPoolRootPath);
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
        tfUtsDHCPPoolName.setLenScope(0, 63);
        tfUtsDHCPPoolClassId.setLenScope(0, 63);
        tfUtsDHCPPoolMeritDump.setLenScope(0, 63);
        tfUtsDHCPPoolRootPath.setLenScope(0, 63);
        tfUtsDHCPPoolLeaseTime.setValueScope(-1, 525600);
        tfUtsDHCPPoolNetworkAddress.setValue("111.0.0.0");
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            DHCPPoolTable mbean = new DHCPPoolTable(fApplication.getSnmpProxy());
            Vector v = BeanService.refreshTableBean(fApplication, mbean);
            if (v != null)
                if (v.size() == 5) {
                    String error = "There are at most five records.";
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                } else {
                    tfUtsDHCPPoolName.setValue("");
                    tfUtsDHCPPoolNetworkAddress.setValue("111.0.0.");
                    tfUtsDHCPPoolNetworkMask.setValue("255.255.255.0");
                    tfUtsDHCPPoolClassId.setValue("");
                    tfUtsDHCPPoolLeaseTime.setValue(1440);
                    tfUtsDHCPPoolMeritDump.setValue("");
                    tfUtsDHCPPoolRootPath.setValue("");
                    return;
                }
        }
        DHCPPoolTable mbean = (DHCPPoolTable) getModel();

        if (SnmpAction.IType.MODIFY.equals(fCommand)) {
            tfUtsDHCPPoolName.setEditable(false);
            tfUtsDHCPPoolNetworkAddress.setEditable(false);
            tfUtsDHCPPoolNetworkMask.setEditable(false);
            tfUtsDHCPPoolClassId.setEditable(false);
        }

        tfUtsDHCPPoolName.setValue(mbean.getUtsDHCPPoolName().toString());
        tfUtsDHCPPoolNetworkAddress.setValue(mbean.getUtsDHCPPoolNetworkAddress());
        tfUtsDHCPPoolNetworkMask.setValue(mbean.getUtsDHCPPoolNetworkMask());
        tfUtsDHCPPoolClassId.setValue(mbean.getUtsDHCPPoolClassId());
        tfUtsDHCPPoolLeaseTime.setValue(mbean.getUtsDHCPPoolLeaseTime().intValue());
        tfUtsDHCPPoolMeritDump.setValue(mbean.getUtsDHCPPoolMeritDump());
        tfUtsDHCPPoolRootPath.setValue(mbean.getUtsDHCPPoolRootPath());

    }

    public boolean validateFrom() {
    	byte[] networkAddrArray = tfUtsDHCPPoolNetworkAddress.getValue();
        if (  networkAddrArray[0] == 0 ){
            JOptionPane.showMessageDialog(this, 
            		fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_DHCP_Pool_NetAddr") );
            return false;
        }
        
        if(tfUtsDHCPPoolLeaseTime.getValue() == 0) {
        	JOptionPane.showMessageDialog(this, 
            		fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_DHCP_Pool_LeaseTime") );
            return false;
        }

        return true;
	}

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new DHCPPoolTable(fApplication.getSnmpProxy()));

        DHCPPoolTable mbean = (DHCPPoolTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // // here set the value of index
            mbean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(new String(tfUtsDHCPPoolName.getValue())));
        }

//		mbean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(new String(tfUtsDHCPPoolName.getValue())));

        mbean.setUtsDHCPPoolNetworkAddress(new String(tfUtsDHCPPoolNetworkAddress.getIPString()));
        mbean.setUtsDHCPPoolNetworkMask(new String(tfUtsDHCPPoolNetworkMask.getIPString()));
        mbean.setUtsDHCPPoolClassId(new String(tfUtsDHCPPoolClassId.getValue()));
        mbean.setUtsDHCPPoolLeaseTime(new Integer(tfUtsDHCPPoolLeaseTime.getValue()));
        mbean.setUtsDHCPPoolMeritDump(new String(tfUtsDHCPPoolMeritDump.getValue()));
        mbean.setUtsDHCPPoolRootPath(new String(tfUtsDHCPPoolRootPath.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
