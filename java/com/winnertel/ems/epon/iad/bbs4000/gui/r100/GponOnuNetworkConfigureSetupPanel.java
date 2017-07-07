/**
 * Created by Zhou Chao, 2008/10/01 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuNetworkConfigureMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.input.base.IPAddressDataLayer;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class GponOnuNetworkConfigureSetupPanel extends UPanel {

    //------------------- MIB items -------------------
    private JLabel tfOnuCfgSlotNo = new JLabel();
    private JLabel tfOnuCfgPortNo = new JLabel();
    private JLabel tfOnuCfgLogicalPortNo = new JLabel();

    //private JLabel tfOnuCfgOnuMacAddress = new JLabel();

/*
    private int[] onuCfgOnuDHCPModeVList = new int[]{1, 2,};
    private String[] onuCfgOnuDHCPModeTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfOnuCfgOnuDHCPMode = new JComboBox(onuCfgOnuDHCPModeTList);
*/

    private IPAddressField tfOnuCfgOnuIPAddress = new IPAddressField();
    private IPAddressField tfOnuCfgOnuIPMask = new IPAddressField(IPAddressDataLayer.IPMASK);
    private IPAddressField tfOnuCfgOnuDefaultGateway = new IPAddressField();

    private LongTextField tfOnuCfgMacLimit = new LongTextField();
    //private IntegerTextField tfOnuCfgOnuFastLeaveCapability = new IntegerTextField();

    private final String onuCfgSlotNo = fStringMap.getString("onuCfgSlotNo") + ": ";
    private final String onuCfgPortNo = fStringMap.getString("onuCfgPortNo") + ": ";
    private final String onuCfgLogicalPortNo = fStringMap.getString("onuCfgLogicalPortNo") + ": ";
    //private final String onuCfgOnuMacAddress = fStringMap.getString("onuCfgOnuMacAddress") + ": ";
/*
    private final String onuCfgOnuDHCPMode = fStringMap.getString("onuCfgOnuDHCPMode") + ": ";
*/
    private final String onuCfgOnuIPAddress = fStringMap.getString("onuCfgOnuIPAddress") + ": ";
    private final String onuCfgOnuIPMask = fStringMap.getString("onuCfgOnuIPMask") + ": ";
    private final String onuCfgOnuDefaultGateway = fStringMap.getString("onuCfgOnuDefaultGateway") + ": ";
    private final String onuCfgMacLimit = fStringMap.getString("onuCfgMacLimit") + ": ";
    //private final String onuCfgOnuFastLeaveCapability = fStringMap.getString("onuCfgOnuFastLeaveCapability") + ": ";

    public GponOnuNetworkConfigureSetupPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
/*
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
*/
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuCfgSlotNo));
        baseInfoPanel.add(tfOnuCfgSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgPortNo));
        baseInfoPanel.add(tfOnuCfgPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgLogicalPortNo));
        baseInfoPanel.add(tfOnuCfgLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(onuCfgOnuMacAddress));
        baseInfoPanel.add(tfOnuCfgOnuMacAddress);
        baseInfoPanel.add(new HSpacer());
        */

/*
        baseInfoPanel.add(new JLabel(onuCfgOnuDHCPMode));
        tfOnuCfgOnuDHCPMode.setName(fStringMap.getString("onuCfgOnuDHCPMode"));
        baseInfoPanel.add(tfOnuCfgOnuDHCPMode);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(onuCfgOnuIPAddress));
        tfOnuCfgOnuIPAddress.setName(fStringMap.getString("onuCfgOnuIPAddress"));
        baseInfoPanel.add(tfOnuCfgOnuIPAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgOnuIPMask));
        tfOnuCfgOnuIPMask.setName(fStringMap.getString("onuCfgOnuIPMask"));
        baseInfoPanel.add(tfOnuCfgOnuIPMask);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgOnuDefaultGateway));
        tfOnuCfgOnuDefaultGateway.setName(fStringMap.getString("onuCfgOnuDefaultGateway"));
        baseInfoPanel.add(tfOnuCfgOnuDefaultGateway);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgMacLimit));
        tfOnuCfgMacLimit.setName(fStringMap.getString("onuCfgMacLimit"));
        baseInfoPanel.add(tfOnuCfgMacLimit);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

/*
        tfOnuCfgOnuDHCPMode.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (tfOnuCfgOnuDHCPMode != null) {
                    if (tfOnuCfgOnuDHCPMode.getSelectedIndex() == 0) { //enable DHCP
                        tfOnuCfgOnuIPAddress.setEnabled(false);
                        tfOnuCfgOnuIPMask.setEnabled(false);
                        tfOnuCfgOnuDefaultGateway.setEnabled(false);
                    } else {
                        tfOnuCfgOnuIPAddress.setEnabled(true);
                        tfOnuCfgOnuIPMask.setEnabled(true);
                        tfOnuCfgOnuDefaultGateway.setEnabled(true);
                    }
                }
            }
        });
*/
    }

    protected void initForm() {
        //tfOnuCfgOnuMacAddress.setEditable(false);
        tfOnuCfgMacLimit.setValueScope(1, 1024);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            return;

        GponOnuNetworkConfigureMBean mbean = (GponOnuNetworkConfigureMBean) getModel();
        if (mbean == null)
            return;

        tfOnuCfgSlotNo.setText((mbean.getOnuCfgSlotNo() != null) ? mbean.getOnuCfgSlotNo().toString() : "");
        tfOnuCfgPortNo.setText((mbean.getOnuCfgPortNo() != null) ? mbean.getOnuCfgPortNo().toString() : "");
        tfOnuCfgLogicalPortNo.setText((mbean.getOnuCfgLogicalPortNo() != null) ? mbean.getOnuCfgLogicalPortNo().toString() : "");

        //tfOnuCfgOnuMacAddress.setText((mbean.getOnuCfgOnuMacAddress() != null) ? mbean.getOnuCfgOnuMacAddress() : "");

/*
        tfOnuCfgOnuDHCPMode.setEnabled(mbean.getOnuCfgOnuDHCPMode() != null);
        tfOnuCfgOnuDHCPMode.setSelectedIndex(getIndexFromValue(onuCfgOnuDHCPModeVList, (mbean.getOnuCfgOnuDHCPMode() != null) ? mbean.getOnuCfgOnuDHCPMode() : 1));

        if (tfOnuCfgOnuDHCPMode.isEnabled()) {
            if (tfOnuCfgOnuDHCPMode.getSelectedIndex() == 0) { //enable DHCP
                tfOnuCfgOnuIPAddress.setEnabled(false);
                tfOnuCfgOnuIPMask.setEnabled(false);
                tfOnuCfgOnuDefaultGateway.setEnabled(false);
            } else {
*/
                tfOnuCfgOnuIPAddress.setEnabled(true);
                tfOnuCfgOnuIPMask.setEnabled(true);
                tfOnuCfgOnuDefaultGateway.setEnabled(true);
/*
            }
*/

            tfOnuCfgOnuIPAddress.setEnabled(mbean.getOnuCfgOnuIPAddress() != null);
            tfOnuCfgOnuIPAddress.setValue((mbean.getOnuCfgOnuIPAddress() != null) ? mbean.getOnuCfgOnuIPAddress() : "");

            tfOnuCfgOnuIPMask.setEnabled(mbean.getOnuCfgOnuIPMask() != null);
            tfOnuCfgOnuIPMask.setValue((mbean.getOnuCfgOnuIPMask() != null) ? mbean.getOnuCfgOnuIPMask() : "");

            tfOnuCfgOnuDefaultGateway.setEnabled(mbean.getOnuCfgOnuDefaultGateway() != null);
            tfOnuCfgOnuDefaultGateway.setValue((mbean.getOnuCfgOnuDefaultGateway() != null) ? mbean.getOnuCfgOnuDefaultGateway() : "");
/*
        }
*/

        tfOnuCfgMacLimit.setEnabled(mbean.getOnuCfgMacLimit() != null);
        tfOnuCfgMacLimit.setValue((mbean.getOnuCfgMacLimit() != null) ? mbean.getOnuCfgMacLimit() : 32);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOnuNetworkConfigureMBean(fApplication.getSnmpProxy()));

        GponOnuNetworkConfigureMBean mbean = (GponOnuNetworkConfigureMBean) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //...
        }

/*
        if (tfOnuCfgOnuDHCPMode.isEnabled())
            mbean.setOnuCfgOnuDHCPMode(onuCfgOnuDHCPModeVList[tfOnuCfgOnuDHCPMode.getSelectedIndex()]);
*/

        if (tfOnuCfgOnuIPAddress.isEnabled() && !tfOnuCfgOnuIPAddress.getIPString().equals(mbean.getOnuCfgOnuIPAddress()))
            mbean.setOnuCfgOnuIPAddress(tfOnuCfgOnuIPAddress.getIPString());

        if (tfOnuCfgOnuIPMask.isEnabled() && !tfOnuCfgOnuIPMask.getIPString().equals(mbean.getOnuCfgOnuIPMask()))
            mbean.setOnuCfgOnuIPMask(tfOnuCfgOnuIPMask.getIPString());

        if (tfOnuCfgOnuDefaultGateway.isEnabled())
            mbean.setOnuCfgOnuDefaultGateway(tfOnuCfgOnuDefaultGateway.getIPString());

        if (tfOnuCfgMacLimit.isEnabled() && tfOnuCfgMacLimit.getValue() != mbean.getOnuCfgMacLimit())
            mbean.setOnuCfgMacLimit(tfOnuCfgMacLimit.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}