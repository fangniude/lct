/**
 * Created by Zhou Chao, 2008/10/01 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuVoipConfigureMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GponOnuVoipConfigureSetupPanel extends UPanel {

    //------------------- MIB items -------------------
    private JLabel tfOnuCfgSlotNo = new JLabel();
    private JLabel tfOnuCfgPortNo = new JLabel();
    private JLabel tfOnuCfgLogicalPortNo = new JLabel();

    private int[] onuCfgOnuVoIPBindingTypeVList = new int[]{1, 2,};
    private String[] onuCfgOnuVoIPBindingTypeTList = new String[]{
            fStringMap.getString("onu-based"),
            fStringMap.getString("pots-uni-based"),
    };
    private JComboBox tfOnuCfgOnuVoIPBindingType = new JComboBox(onuCfgOnuVoIPBindingTypeTList);

    private StringTextField tfOnuCfgOnuVoIPUserName = new StringTextField();
    private StringTextField tfOnuCfgOnuVoIPPassword = new StringTextField();

    private ProfileChooser tfOnuCfgOnuVoIPServiceProfileIndex = new ProfileChooser(fApplication);

    private final String onuCfgSlotNo = fStringMap.getString("onuCfgSlotNo") + ": ";
    private final String onuCfgPortNo = fStringMap.getString("onuCfgPortNo") + ": ";
    private final String onuCfgLogicalPortNo = fStringMap.getString("onuCfgLogicalPortNo") + ": ";
    private final String onuCfgOnuVoIPBindingType = fStringMap.getString("onuCfgOnuVoIPBindingType") + ": ";
    private final String onuCfgOnuVoIPUserName = fStringMap.getString("onuCfgOnuVoIPUserName") + ": ";
    private final String onuCfgOnuVoIPPassword = fStringMap.getString("onuCfgOnuVoIPPassword") + ": ";
    private final String onuCfgOnuVoIPServiceProfileName = fStringMap.getString("onuCfgOnuVoIPServiceProfileName") + ": ";

    public GponOnuVoipConfigureSetupPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
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

        tfOnuCfgOnuVoIPBindingType.setEnabled(false);
        baseInfoPanel.add(new JLabel(onuCfgOnuVoIPBindingType));
        tfOnuCfgOnuVoIPBindingType.setName(fStringMap.getString("onuCfgOnuVoIPBindingType"));
        baseInfoPanel.add(tfOnuCfgOnuVoIPBindingType);
        baseInfoPanel.add(new HSpacer());
        tfOnuCfgOnuVoIPBindingType.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                if(onuCfgOnuVoIPBindingTypeVList[tfOnuCfgOnuVoIPBindingType.getSelectedIndex()]==1){
                    tfOnuCfgOnuVoIPUserName.setEnabled(true);
                    tfOnuCfgOnuVoIPPassword.setEnabled(true);
                }
                else{
                    tfOnuCfgOnuVoIPUserName.setEnabled(false);
                    tfOnuCfgOnuVoIPPassword.setEnabled(false);
                }
                    
                
            }
            
        });

        baseInfoPanel.add(new JLabel(onuCfgOnuVoIPUserName));
        tfOnuCfgOnuVoIPUserName.setName(fStringMap.getString("onuCfgOnuVoIPUserName"));
        baseInfoPanel.add(tfOnuCfgOnuVoIPUserName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgOnuVoIPPassword));
        tfOnuCfgOnuVoIPPassword.setName(fStringMap.getString("onuCfgOnuVoIPPassword"));
        baseInfoPanel.add(tfOnuCfgOnuVoIPPassword);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgOnuVoIPServiceProfileName));
        tfOnuCfgOnuVoIPServiceProfileIndex.setName(fStringMap.getString("onuCfgOnuVoIPServiceProfileName"));
        tfOnuCfgOnuVoIPServiceProfileIndex.setProfile("GponOnuVoipSvcProTable_Panel");
        baseInfoPanel.add(tfOnuCfgOnuVoIPServiceProfileIndex);
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
            tfOnuCfgOnuVoIPServiceProfileIndex.refresh();
            tfOnuCfgOnuVoIPServiceProfileIndex.setSelectedProfileIndex(1);

            return;
        }

        GponOnuVoipConfigureMBean mbean = (GponOnuVoipConfigureMBean) getModel();
        if (mbean == null)
            return;

        tfOnuCfgSlotNo.setText((mbean.getOnuCfgSlotNo() != null) ? mbean.getOnuCfgSlotNo().toString() : "");
        tfOnuCfgPortNo.setText((mbean.getOnuCfgPortNo() != null) ? mbean.getOnuCfgPortNo().toString() : "");
        tfOnuCfgLogicalPortNo.setText((mbean.getOnuCfgLogicalPortNo() != null) ? mbean.getOnuCfgLogicalPortNo().toString() : "");

        tfOnuCfgOnuVoIPBindingType.setEnabled(mbean.getOnuCfgOnuVoIPBindingType() != null);
        tfOnuCfgOnuVoIPBindingType.setSelectedIndex(getIndexFromValue(onuCfgOnuVoIPBindingTypeVList, (mbean.getOnuCfgOnuVoIPBindingType() != null) ? mbean.getOnuCfgOnuVoIPBindingType() : 0));

        tfOnuCfgOnuVoIPUserName.setEnabled(mbean.getOnuCfgOnuVoIPUserName() != null);
        tfOnuCfgOnuVoIPUserName.setValue((mbean.getOnuCfgOnuVoIPUserName() != null) ? mbean.getOnuCfgOnuVoIPUserName() : "voip");

        tfOnuCfgOnuVoIPPassword.setEnabled(mbean.getOnuCfgOnuVoIPPassword() != null);
        tfOnuCfgOnuVoIPPassword.setValue((mbean.getOnuCfgOnuVoIPPassword() != null) ? mbean.getOnuCfgOnuVoIPPassword() : "voip");
        if(onuCfgOnuVoIPBindingTypeVList[tfOnuCfgOnuVoIPBindingType.getSelectedIndex()]==1){
            tfOnuCfgOnuVoIPUserName.setEnabled(true);
            tfOnuCfgOnuVoIPPassword.setEnabled(true);
        }
        else{
            tfOnuCfgOnuVoIPUserName.setEnabled(false);
            tfOnuCfgOnuVoIPPassword.setEnabled(false);
        }
        tfOnuCfgOnuVoIPServiceProfileIndex.refresh();
        tfOnuCfgOnuVoIPServiceProfileIndex.setEnabled(mbean.getOnuCfgOnuVoIPServiceProfileIndex() != null);
        tfOnuCfgOnuVoIPServiceProfileIndex.setSelectedProfileIndex(mbean.getOnuCfgOnuVoIPServiceProfileIndex());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOnuVoipConfigureMBean(fApplication.getSnmpProxy()));

        GponOnuVoipConfigureMBean mbean = (GponOnuVoipConfigureMBean) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //...
        }

        if (tfOnuCfgOnuVoIPBindingType.isEnabled())
            mbean.setOnuCfgOnuVoIPBindingType(onuCfgOnuVoIPBindingTypeVList[tfOnuCfgOnuVoIPBindingType.getSelectedIndex()]);

        if (tfOnuCfgOnuVoIPUserName.isEnabled())
            mbean.setOnuCfgOnuVoIPUserName(tfOnuCfgOnuVoIPUserName.getValue());

        if (tfOnuCfgOnuVoIPPassword.isEnabled())
            mbean.setOnuCfgOnuVoIPPassword(tfOnuCfgOnuVoIPPassword.getValue());

        if (tfOnuCfgOnuVoIPServiceProfileIndex.isEnabled())
            mbean.setOnuCfgOnuVoIPServiceProfileIndex(tfOnuCfgOnuVoIPServiceProfileIndex.getSelectedProfileIndex() >= 0 ? tfOnuCfgOnuVoIPServiceProfileIndex.getSelectedProfileIndex() : 1);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}