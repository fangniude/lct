package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATNetworkAttrGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCCBATNetworkAttrGroupPanel class.
 * Created by DVM Creator
 */
public class ModEoCCBATNetworkAttrGroupPanel extends UPanel {

    private MacAddressField tfModEoCCBATAdminMACAddress = new MacAddressField();

    private int[] modEoCCBATAdminIPModeVList = new int[]{
            1, 0,};
    private String[] modEoCCBATAdminIPModeTList = new String[]{
            fStringMap.getString("dynamic"),
            fStringMap.getString("static"),
    };
    private JComboBox tfModEoCCBATAdminIPMode = new JComboBox(modEoCCBATAdminIPModeTList);
    private IPAddressField tfModEoCCBATAdminIPAddress = new IPAddressField();

    private IPAddressField tfModEoCCBATAdminIPMask = new IPAddressField(IPAddressField.IPMASK);

    private IPAddressField tfModEoCCBATAdminIPGateway = new IPAddressField();


    private final String modEoCCBATAdminMACAddress = fStringMap.getString("modEoCCBATAdminMACAddress") + " : ";
    private final String modEoCCBATAdminIPMode = fStringMap.getString("modEoCCBATAdminIPMode") + " : ";
    private final String modEoCCBATAdminIPAddress = fStringMap.getString("modEoCCBATAdminIPAddress") + " : ";
    private final String modEoCCBATAdminIPMask = fStringMap.getString("modEoCCBATAdminIPMask") + " : ";
    private final String modEoCCBATAdminIPGateway = fStringMap.getString("modEoCCBATAdminIPGateway") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public ModEoCCBATNetworkAttrGroupPanel(IApplication app) {
        super(app);
        setModel(new ModEoCCBATNetworkAttrGroup(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCCBATNetworkAttrGroup");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCBATAdminMACAddress));
        baseInfoPanel.add(tfModEoCCBATAdminMACAddress);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminIPMode));
        tfModEoCCBATAdminIPMode.setName(fStringMap.getString("modEoCCBATAdminIPMode"));
        baseInfoPanel.add(tfModEoCCBATAdminIPMode);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminIPAddress));
        tfModEoCCBATAdminIPAddress.setName(fStringMap.getString("modEoCCBATAdminIPAddress"));
        baseInfoPanel.add(tfModEoCCBATAdminIPAddress);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminIPMask));
        tfModEoCCBATAdminIPMask.setName(fStringMap.getString("modEoCCBATAdminIPMask"));
        baseInfoPanel.add(tfModEoCCBATAdminIPMask);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminIPGateway));
        tfModEoCCBATAdminIPGateway.setName(fStringMap.getString("modEoCCBATAdminIPGateway"));
        baseInfoPanel.add(tfModEoCCBATAdminIPGateway);
        baseInfoPanel.add(new HSpacer());


        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);


    }

    protected void initForm() {
        tfModEoCCBATAdminMACAddress.setEditable(false);


    }

    public boolean validateFrom() {

        int iRet = MessageDialog.showConfirmDialog(fApplication, fStringMap.getString("Err_ConfirmChangeNetworkAttr"));
        if (iRet != 0) {
            return false;
        }

        return true;
    }

    public void refresh() {

        ModEoCCBATNetworkAttrGroup mbean = (ModEoCCBATNetworkAttrGroup) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfModEoCCBATAdminMACAddress.setValue(mbean.getModEoCCBATAdminMACAddress());
        tfModEoCCBATAdminIPMode.setSelectedIndex(getIndexFromValue(modEoCCBATAdminIPModeVList, mbean.getModEoCCBATAdminIPMode().intValue()));
        tfModEoCCBATAdminIPAddress.setValue(mbean.getModEoCCBATAdminIPAddress());

        String ipMask = mbean.getModEoCCBATAdminIPMask();
        tfModEoCCBATAdminIPMask.setValue(ipMask);
        tfModEoCCBATAdminIPGateway.setValue(mbean.getModEoCCBATAdminIPGateway());

    }

    public void updateModel() {

        ModEoCCBATNetworkAttrGroup mbean = (ModEoCCBATNetworkAttrGroup) getModel();


        mbean.setModEoCCBATAdminIPMode(new Integer(modEoCCBATAdminIPModeVList[tfModEoCCBATAdminIPMode.getSelectedIndex()]));
        mbean.setModEoCCBATAdminIPAddress(tfModEoCCBATAdminIPAddress.getIPString());
        mbean.setModEoCCBATAdminIPMask(tfModEoCCBATAdminIPMask.getIPString());
        mbean.setModEoCCBATAdminIPGateway(tfModEoCCBATAdminIPGateway.getIPString());


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}
