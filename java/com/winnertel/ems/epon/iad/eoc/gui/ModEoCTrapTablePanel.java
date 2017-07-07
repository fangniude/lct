package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCTrapTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCTrapTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCTrapTablePanel extends UPanel {

    private IntegerTextField tfModEoCTrapIndex = new IntegerTextField();

    private IPAddressField tfModEoCTrapIP = new IPAddressField();

    private StringTextField tfModEoCTrapCommunity = new StringTextField();

//    private int[] modEoCTrapStatusVList = new int[]{
//            1, 2,};
//    private String[] modEoCTrapStatusTList = new String[]{
//            fStringMap.getString("true"),
//            fStringMap.getString("false"),
//    };
//    private JComboBox tfModEoCTrapStatus = new JComboBox(modEoCTrapStatusTList);

    /*
    private int[] modEoCTrapRowStatusVList = new int[]{
            1, 2, 5, 4, 3, 6,};
    private String[] modEoCTrapRowStatusTList = new String[]{
            fStringMap.getString("active"),
            fStringMap.getString("notInService"),
            fStringMap.getString("createAndWait"),
            fStringMap.getString("createAndGo"),
            fStringMap.getString("notReady"),
            fStringMap.getString("destroy"),
    };
    private JComboBox tfModEoCTrapRowStatus = new JComboBox(modEoCTrapRowStatusTList);
    */

    private final String modEoCTrapIndex = fStringMap.getString("modEoCTrapIndex") + " : ";
    private final String modEoCTrapIP = fStringMap.getString("modEoCTrapIP") + " : ";
    private final String modEoCTrapCommunity = fStringMap.getString("modEoCTrapCommunity") + " : ";
//    private final String modEoCTrapStatus = fStringMap.getString("modEoCTrapStatus") + " : ";


    public ModEoCTrapTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCTrapIndex));
        baseInfoPanel.add(tfModEoCTrapIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCTrapIP));
        tfModEoCTrapIP.setName(fStringMap.getString("modEoCTrapIP"));
        baseInfoPanel.add(tfModEoCTrapIP);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCTrapCommunity));
        baseInfoPanel.add(tfModEoCTrapCommunity);
        baseInfoPanel.add(new HSpacer());


//        baseInfoPanel.add(new JLabel(modEoCTrapStatus));
//        baseInfoPanel.add(tfModEoCTrapStatus);
//        baseInfoPanel.add(new HSpacer());


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
            tfModEoCTrapIndex.setEditable(true);
            return;
        }
        tfModEoCTrapIndex.setEditable(false);

        ModEoCTrapTable mbean = (ModEoCTrapTable) getModel();

        tfModEoCTrapIndex.setText(mbean.getModEoCTrapIndex().toString());
        tfModEoCTrapIP.setValue(mbean.getModEoCTrapIP());
        tfModEoCTrapCommunity.setText(mbean.getModEoCTrapCommunity());
//        tfModEoCTrapStatus.setSelectedIndex(getIndexFromValue(modEoCTrapStatusVList, mbean.getModEoCTrapStatus().intValue()));
        //tfModEoCTrapRowStatus.setSelectedIndex(getIndexFromValue(modEoCTrapRowStatusVList, mbean.getModEoCTrapRowStatus().intValue()));

    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new ModEoCTrapTable(fApplication.getSnmpProxy()));

        ModEoCTrapTable mbean = (ModEoCTrapTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setModEoCTrapIndex(new Integer(tfModEoCTrapIndex.getValue()));
        }


        mbean.setModEoCTrapIP(new String(tfModEoCTrapIP.getIPString()));
        mbean.setModEoCTrapCommunity(new String(tfModEoCTrapCommunity.getValue()));
//        mbean.setModEoCTrapStatus(new Integer(modEoCTrapStatusVList[tfModEoCTrapStatus.getSelectedIndex()]));
//        mbean.setModEoCTrapRowStatus(new Integer(modEoCTrapRowStatusVList[tfModEoCTrapRowStatus.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }
}
