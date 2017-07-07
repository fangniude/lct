package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCVLANTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCVLANTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCVLANTablePanel extends UPanel {

    private IntegerTextField tfModEoCVLANIndex = new IntegerTextField();

    private StringTextField tfModEoCVLANName = new StringTextField();

    private int[] modEoCVLANFlagVList = new int[]{
            1, 0,};
    private String[] modEoCVLANFlagTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfModEoCVLANFlag = new JComboBox(modEoCVLANFlagTList);

    /*
        private int[] modEoCVLANRowStatusVList =new int[]{
1,2,5,4,3,6,};
private String[] modEoCVLANRowStatusTList =new String[]{
        fStringMap.getString("active"),
        fStringMap.getString("notInService"),
        fStringMap.getString("createAndWait"),
        fStringMap.getString("createAndGo"),
        fStringMap.getString("notReady"),
        fStringMap.getString("destroy"),
};
private JComboBox tfModEoCVLANRowStatus = new JComboBox( modEoCVLANRowStatusTList);
        */

    private final String modEoCVLANIndex = fStringMap.getString("modEoCVLANIndex") + " : ";
    private final String modEoCVLANName = fStringMap.getString("modEoCVLANName") + " : ";
    private final String modEoCVLANFlag = fStringMap.getString("modEoCVLANFlag") + " : ";


    public ModEoCVLANTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCVLANIndex));
        baseInfoPanel.add(tfModEoCVLANIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANName));
        tfModEoCVLANName.setName(fStringMap.getString("modEoCVLANName"));
        baseInfoPanel.add(tfModEoCVLANName);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANFlag));
        tfModEoCVLANFlag.setName(fStringMap.getString("modEoCVLANFlag"));
        baseInfoPanel.add(tfModEoCVLANFlag);
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

        tfModEoCVLANName.setLenScope(0, 64);


    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) return;
        ModEoCVLANTable mbean = (ModEoCVLANTable) getModel();

        tfModEoCVLANIndex.setText(mbean.getModEoCVLANIndex().toString());
        tfModEoCVLANName.setValue(mbean.getModEoCVLANName());
        tfModEoCVLANFlag.setSelectedIndex(getIndexFromValue(modEoCVLANFlagVList, mbean.getModEoCVLANFlag().intValue()));
        //    tfModEoCVLANRowStatus.setSelectedIndex(getIndexFromValue(modEoCVLANRowStatusVList,mbean.getModEoCVLANRowStatus().intValue()));

    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new ModEoCVLANTable(fApplication.getSnmpProxy()));

        ModEoCVLANTable mbean = (ModEoCVLANTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            //   mbean.set??(new Integer(??.getValue()));
            mbean.setModEoCVLANIndex(tfModEoCVLANIndex.getValue());
        }


        mbean.setModEoCVLANName(new String(tfModEoCVLANName.getValue()));
        mbean.setModEoCVLANFlag(new Integer(modEoCVLANFlagVList[tfModEoCVLANFlag.getSelectedIndex()]));
        //  mbean.setModEoCVLANRowStatus(new Integer(modEoCVLANRowStatusVList[tfModEoCVLANRowStatus.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}