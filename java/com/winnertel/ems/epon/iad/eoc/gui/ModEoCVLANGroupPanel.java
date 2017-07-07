package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCVLANGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCVLANGroupPanel class.
 * Created by DVM Creator
 */
public class ModEoCVLANGroupPanel extends UPanel {

    private JLabel tfModEoCVLANVersionNumber = new JLabel();

    private JLabel tfModEoCVLANMaxVID = new JLabel();

    private JLabel tfModEoCVLANMaxSupportedVLANs = new JLabel();

    private JLabel tfModEoCVLANCreatedVLANNumber = new JLabel();

    private JLabel tfModEoCVLANVIDList = new JLabel();

    private JLabel tfModEoCVLANNextFreeVID = new JLabel();


    private final String modEoCVLANVersionNumber = fStringMap.getString("modEoCVLANVersionNumber") + " : ";
    private final String modEoCVLANMaxVID = fStringMap.getString("modEoCVLANMaxVID") + " : ";
    private final String modEoCVLANMaxSupportedVLANs = fStringMap.getString("modEoCVLANMaxSupportedVLANs") + " : ";
    private final String modEoCVLANCreatedVLANNumber = fStringMap.getString("modEoCVLANCreatedVLANNumber") + " : ";
    private final String modEoCVLANVIDList = fStringMap.getString("modEoCVLANVIDList") + " : ";
    private final String modEoCVLANNextFreeVID = fStringMap.getString("modEoCVLANNextFreeVID") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public ModEoCVLANGroupPanel(IApplication app) {
        super(app);
        setModel(new ModEoCVLANGroup(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCVLANGroup");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        //buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCVLANVersionNumber));
        baseInfoPanel.add(tfModEoCVLANVersionNumber);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANMaxVID));
        baseInfoPanel.add(tfModEoCVLANMaxVID);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANMaxSupportedVLANs));
        baseInfoPanel.add(tfModEoCVLANMaxSupportedVLANs);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANCreatedVLANNumber));
        baseInfoPanel.add(tfModEoCVLANCreatedVLANNumber);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANVIDList));
        baseInfoPanel.add(tfModEoCVLANVIDList);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANNextFreeVID));
        baseInfoPanel.add(tfModEoCVLANNextFreeVID);
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


    }

    public void refresh() {

        ModEoCVLANGroup mbean = (ModEoCVLANGroup) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfModEoCVLANVersionNumber.setText(mbean.getModEoCVLANVersionNumber().toString());
        tfModEoCVLANMaxVID.setText(mbean.getModEoCVLANMaxVID().toString());
        tfModEoCVLANMaxSupportedVLANs.setText(mbean.getModEoCVLANMaxSupportedVLANs().toString());
        tfModEoCVLANCreatedVLANNumber.setText(mbean.getModEoCVLANCreatedVLANNumber().toString());
        byte[] byteVid = mbean.getModEoCVLANVIDList();
        String strVid = "";
        if (byteVid != null) {
            /*
            for (int i=0;i<byteVid.length;i++){
                strVid=strVid+ String.valueOf((byteVid[i]>>4)&0xF)+String.valueOf((byteVid[i])&0xF)+" ";
                
            } */

            int portIdx = 0;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteVid.length; i = i + 1) {

                for (int j = 0; j < 8; j++) {

                    if ((byteVid[i] & (0x80 >> j)) == (0x80 >> j)) {
                        sb.append(portIdx);
                        sb.append(" ");
                    }

                    portIdx = portIdx + 1;
                }
            }

            strVid = sb.toString();
        }

        tfModEoCVLANVIDList.setText(strVid);
        tfModEoCVLANNextFreeVID.setText(mbean.getModEoCVLANNextFreeVID().toString());

    }

    public void updateModel() {

        ModEoCVLANGroup mbean = (ModEoCVLANGroup) getModel();


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}