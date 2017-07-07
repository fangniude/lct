/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniTrunkGroupTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class UniTrunkGroupTablePanel extends UPanel {

    private IntegerTextField tfUniTrunkGroupIndex = new IntegerTextField();

    private int[] uniTrunkGroupOperationStatusVList = new int[]{1, 2, 3,};
    private String[] uniTrunkGroupOperationStatusTList = new String[]{
            fStringMap.getString("up"), //1
            fStringMap.getString("down"), //2
            fStringMap.getString("testing"), //3
    };
    private JComboBox tfUniTrunkGroupOperationStatus = new JComboBox(uniTrunkGroupOperationStatusTList);

    private JLabel tfUniTrunkGroupActualSpeed = new JLabel();

    private int[] uniTrunkGroupAdminStatusVList = new int[]{1, 2, 3,};
    private String[] uniTrunkGroupAdminStatusTList = new String[]{
            fStringMap.getString("up"), //1
            fStringMap.getString("down"), //2
            fStringMap.getString("testing"), //3
    };
    private JComboBox tfUniTrunkGroupAdminStatus = new JComboBox(uniTrunkGroupAdminStatusTList);

    private final String uniTrunkGroupIndex = fStringMap.getString("uniTrunkGroupIndex") + " : ";
    private final String uniTrunkGroupOperationStatus = fStringMap.getString("uniTrunkGroupOperationStatus") + " : ";
    private final String uniTrunkGroupActualSpeed = fStringMap.getString("uniTrunkGroupActualSpeed") + " : ";
    private final String uniTrunkGroupAdminStatus = fStringMap.getString("uniTrunkGroupAdminStatus") + " : ";

    public UniTrunkGroupTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(uniTrunkGroupIndex));
        baseInfoPanel.add(tfUniTrunkGroupIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniTrunkGroupOperationStatus));
        baseInfoPanel.add(tfUniTrunkGroupOperationStatus);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniTrunkGroupActualSpeed));
        baseInfoPanel.add(tfUniTrunkGroupActualSpeed);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniTrunkGroupAdminStatus));
        tfUniTrunkGroupAdminStatus.setName(fStringMap.getString("uniTrunkGroupAdminStatus"));
        baseInfoPanel.add(tfUniTrunkGroupAdminStatus);
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
            tfUniTrunkGroupIndex.setEditable(true);
            return;
        } else {
            tfUniTrunkGroupIndex.setEditable(false);
        }

        UniTrunkGroupTable mbean = (UniTrunkGroupTable) getModel();
        if (mbean == null)
            return;

        tfUniTrunkGroupIndex.setValue(mbean.getUniTrunkGroupIndex());

        tfUniTrunkGroupOperationStatus.setSelectedIndex(getIndexFromValue(uniTrunkGroupOperationStatusVList, mbean.getUniTrunkGroupOperationStatus()));
        tfUniTrunkGroupActualSpeed.setText(mbean.getUniTrunkGroupActualSpeed().toString());
        tfUniTrunkGroupAdminStatus.setSelectedIndex(getIndexFromValue(uniTrunkGroupAdminStatusVList, mbean.getUniTrunkGroupAdminStatus()));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new UniTrunkGroupTable(fApplication.getSnmpProxy()));

        UniTrunkGroupTable mbean = (UniTrunkGroupTable) getModel();
        if (mbean == null)
            return;


        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setUniTrunkGroupIndex(new Integer(tfUniTrunkGroupIndex.getValue()));
        }

        mbean.setUniTrunkGroupAdminStatus(new Integer(uniTrunkGroupAdminStatusVList[tfUniTrunkGroupAdminStatus.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}