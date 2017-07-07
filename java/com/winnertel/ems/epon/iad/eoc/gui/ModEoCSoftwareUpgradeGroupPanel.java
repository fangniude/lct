package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCSoftwareUpgradeGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCSoftwareUpgradeGroupPanel class.
 * Created by DVM Creator
 */
public class ModEoCSoftwareUpgradeGroupPanel extends UPanel {

    private IPAddressField tfModEoCSoftwaretUpgradeServerIP = new IPAddressField();

    private IntegerTextField tfModEoCSoftwareUpgradeServerPort = new IntegerTextField();

    private StringTextField tfModEoCSoftwareUpgradeLogin = new StringTextField();

    private StringTextField tfModEoCSoftwareUpgradePassWord = new StringTextField();


    private final String modEoCSoftwaretUpgradeServerIP = fStringMap.getString("modEoCSoftwaretUpgradeServerIP") + " : ";
    private final String modEoCSoftwareUpgradeServerPort = fStringMap.getString("modEoCSoftwareUpgradeServerPort") + " : ";
    private final String modEoCSoftwareUpgradeLogin = fStringMap.getString("modEoCSoftwareUpgradeLogin") + " : ";
    private final String modEoCSoftwareUpgradePassWord = fStringMap.getString("modEoCSoftwareUpgradePassWord") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public ModEoCSoftwareUpgradeGroupPanel(IApplication app) {
        super(app);
        setModel(new ModEoCSoftwareUpgradeGroup(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCSoftwareUpgradeGroup");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCSoftwaretUpgradeServerIP));
        tfModEoCSoftwaretUpgradeServerIP.setName(fStringMap.getString("modEoCSoftwaretUpgradeServerIP"));
        baseInfoPanel.add(tfModEoCSoftwaretUpgradeServerIP);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCSoftwareUpgradeServerPort));
        tfModEoCSoftwareUpgradeServerPort.setName(fStringMap.getString("modEoCSoftwareUpgradeServerPort"));
        baseInfoPanel.add(tfModEoCSoftwareUpgradeServerPort);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCSoftwareUpgradeLogin));
        tfModEoCSoftwareUpgradeLogin.setName(fStringMap.getString("modEoCSoftwareUpgradeLogin"));
        baseInfoPanel.add(tfModEoCSoftwareUpgradeLogin);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCSoftwareUpgradePassWord));
        tfModEoCSoftwareUpgradePassWord.setName(fStringMap.getString("modEoCSoftwareUpgradePassWord"));
        baseInfoPanel.add(tfModEoCSoftwareUpgradePassWord);
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

        tfModEoCSoftwareUpgradeServerPort.setValueScope(1, 65535);

        tfModEoCSoftwareUpgradeLogin.setLenScope(1, 32);

        tfModEoCSoftwareUpgradePassWord.setLenScope(1, 16);


    }

    public void refresh() {

        ModEoCSoftwareUpgradeGroup mbean = (ModEoCSoftwareUpgradeGroup) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfModEoCSoftwaretUpgradeServerIP.setValue(mbean.getModEoCSoftwaretUpgradeServerIP());
        tfModEoCSoftwareUpgradeServerPort.setValue(mbean.getModEoCSoftwareUpgradeServerPort().intValue());
        tfModEoCSoftwareUpgradeLogin.setValue(mbean.getModEoCSoftwareUpgradeLogin());
        tfModEoCSoftwareUpgradePassWord.setValue(mbean.getModEoCSoftwareUpgradePassWord());

    }

    public void updateModel() {

        ModEoCSoftwareUpgradeGroup mbean = (ModEoCSoftwareUpgradeGroup) getModel();

        mbean.setModEoCSoftwaretUpgradeServerIP(tfModEoCSoftwaretUpgradeServerIP.getIPString());
        mbean.setModEoCSoftwareUpgradeServerPort(new Integer(tfModEoCSoftwareUpgradeServerPort.getValue()));
        mbean.setModEoCSoftwareUpgradeLogin(new String(tfModEoCSoftwareUpgradeLogin.getValue()));
        mbean.setModEoCSoftwareUpgradePassWord(new String(tfModEoCSoftwareUpgradePassWord.getValue()));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}