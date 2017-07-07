package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATDevInfoGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCCBATDevInfoGroupPanel class.
 * Created by DVM Creator
 */
public class ModEoCCBATDevInfoGroupPanel extends UPanel {

    private StringTextField tfModEoCCBATAdminLogicalID = new StringTextField();

    private StringTextField tfModEoCCBATAdminTechProject = new StringTextField();

    private StringTextField tfModEoCCBATAdminManufactoryInfo = new StringTextField();

    private StringTextField tfModEoCCBATAdminModelNumber = new StringTextField();

    private StringTextField tfModEoCCBATAdminSerialNumber = new StringTextField();

    private StringTextField tfModEoCCBATAdminSoftwareVersion = new StringTextField();

    private StringTextField tfModEoCCBATAdminHardwareVersion = new StringTextField();

    private StringTextField tfModEoCCBATAdminVendorSpecialInfo = new StringTextField();


    private final String modEoCCBATAdminLogicalID = fStringMap.getString("modEoCCBATAdminLogicalID") + " : ";
    private final String modEoCCBATAdminTechProject = fStringMap.getString("modEoCCBATAdminTechProject") + " : ";
    private final String modEoCCBATAdminManufactoryInfo = fStringMap.getString("modEoCCBATAdminManufactoryInfo") + " : ";
    private final String modEoCCBATAdminModelNumber = fStringMap.getString("modEoCCBATAdminModelNumber") + " : ";
    private final String modEoCCBATAdminSerialNumber = fStringMap.getString("modEoCCBATAdminSerialNumber") + " : ";
    private final String modEoCCBATAdminSoftwareVersion = fStringMap.getString("modEoCCBATAdminSoftwareVersion") + " : ";
    private final String modEoCCBATAdminHardwareVersion = fStringMap.getString("modEoCCBATAdminHardwareVersion") + " : ";
    private final String modEoCCBATAdminVendorSpecialInfo = fStringMap.getString("modEoCCBATAdminVendorSpecialInfo") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public ModEoCCBATDevInfoGroupPanel(IApplication app) {
        super(app);
        setModel(new ModEoCCBATDevInfoGroup(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCCBATDevInfoGroup");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        //baseInfoPanel.setPreferredSize(new Dimension(600,300));
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCBATAdminLogicalID));
        tfModEoCCBATAdminLogicalID.setName(fStringMap.getString("modEoCCBATAdminLogicalID"));

        Dimension dim = new Dimension(300, 22);
        //tfModEoCCBATAdminLogicalID.setMinimumSize(dim);
        //tfModEoCCBATAdminLogicalID.setPreferredSize(dim);
        tfModEoCCBATAdminLogicalID.setColumns(40);
        baseInfoPanel.add(tfModEoCCBATAdminLogicalID);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminTechProject));
        //tfModEoCCBATAdminTechProject.setMinimumSize(dim);
        baseInfoPanel.add(tfModEoCCBATAdminTechProject);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminManufactoryInfo));
        baseInfoPanel.add(tfModEoCCBATAdminManufactoryInfo);
        //tfModEoCCBATAdminManufactoryInfo.setMinimumSize(dim);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminModelNumber));
        baseInfoPanel.add(tfModEoCCBATAdminModelNumber);
        //tfModEoCCBATAdminModelNumber.setPreferredSize(dim);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminSerialNumber));
        baseInfoPanel.add(tfModEoCCBATAdminSerialNumber);
        //tfModEoCCBATAdminSerialNumber.setPreferredSize(dim);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminSoftwareVersion));
        baseInfoPanel.add(tfModEoCCBATAdminSoftwareVersion);
        //tfModEoCCBATAdminSoftwareVersion.setPreferredSize(dim);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminHardwareVersion));
        baseInfoPanel.add(tfModEoCCBATAdminHardwareVersion);
        //tfModEoCCBATAdminHardwareVersion.setPreferredSize(dim);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminVendorSpecialInfo));
        baseInfoPanel.add(tfModEoCCBATAdminVendorSpecialInfo);
        //tfModEoCCBATAdminVendorSpecialInfo.setPreferredSize(dim);
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
        tfModEoCCBATAdminLogicalID.setLenScope(0, 40);
        tfModEoCCBATAdminTechProject.setEditable(false);
        tfModEoCCBATAdminManufactoryInfo.setEditable(false);

        tfModEoCCBATAdminModelNumber.setEditable(false);
        tfModEoCCBATAdminSerialNumber.setEditable(false);
        tfModEoCCBATAdminSoftwareVersion.setEditable(false);

        tfModEoCCBATAdminHardwareVersion.setEditable(false);
        tfModEoCCBATAdminVendorSpecialInfo.setEditable(false);


    }

    public void refresh() {

        ModEoCCBATDevInfoGroup mbean = (ModEoCCBATDevInfoGroup) getModel();

        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfModEoCCBATAdminLogicalID.setValue(mbean.getModEoCCBATAdminLogicalID());
        tfModEoCCBATAdminTechProject.setText(mbean.getModEoCCBATAdminTechProject());
        //tfModEoCCBATAdminManufactoryInfo.setText(mbean.getModEoCCBATAdminManufactoryInfo());  P3 special case
        tfModEoCCBATAdminManufactoryInfo.setText("Winnertel");
        tfModEoCCBATAdminModelNumber.setText(mbean.getModEoCCBATAdminModelNumber());
        tfModEoCCBATAdminSerialNumber.setText(mbean.getModEoCCBATAdminSerialNumber());
        tfModEoCCBATAdminSoftwareVersion.setText(mbean.getModEoCCBATAdminSoftwareVersion());
        tfModEoCCBATAdminHardwareVersion.setText(mbean.getModEoCCBATAdminHardwareVersion());
        tfModEoCCBATAdminVendorSpecialInfo.setText(mbean.getModEoCCBATAdminVendorSpecialInfo());
        //tfModEoCCBATAdminVendorSpecialInfo.setText("");

    }

    public void updateModel() {

        ModEoCCBATDevInfoGroup mbean = (ModEoCCBATDevInfoGroup) getModel();

        mbean.setModEoCCBATAdminLogicalID(new String(tfModEoCCBATAdminLogicalID.getValue()));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}