/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniTrunkGroupConfigTable;
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

public class UniTrunkGroupConfigTablePanel extends UPanel {

    private IntegerTextField tfUniTrunkGroupConfigIndex = new IntegerTextField();

    private StringTextField tfUniTrunkGroupConfigName = new StringTextField();

//    private StringTextField tfUniTrunkGroupConfigMember = new StringTextField();
    private JCheckBox[] tfUniTrunkGroupConfigMember = new JCheckBox[25];

    private int[] uniTrunkGroupConfigPolicyVList = new int[]{1, 2, 3, 4, 5, 6,};
    private String[] uniTrunkGroupConfigPolicyTList = new String[]{
            fStringMap.getString("srcMac"), //1
            fStringMap.getString("destMac"), //2
            fStringMap.getString("srcMacNDestMac"), //3
            fStringMap.getString("srcIp"), //4
            fStringMap.getString("destIp"), //5
            fStringMap.getString("srcIpNDestIp"), //6
    };
    private JComboBox tfUniTrunkGroupConfigPolicy = new JComboBox(uniTrunkGroupConfigPolicyTList);

    private final String uniTrunkGroupConfigIndex = fStringMap.getString("uniTrunkGroupConfigIndex") + " : ";
    private final String uniTrunkGroupConfigName = fStringMap.getString("uniTrunkGroupConfigName") + " : ";
    private final String uniTrunkGroupConfigMember = fStringMap.getString("uniTrunkGroupConfigMember") + " : ";
    private final String uniTrunkGroupConfigPolicy = fStringMap.getString("uniTrunkGroupConfigPolicy") + " : ";

    public UniTrunkGroupConfigTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(uniTrunkGroupConfigIndex));
        baseInfoPanel.add(tfUniTrunkGroupConfigIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniTrunkGroupConfigName));
        tfUniTrunkGroupConfigName.setName(fStringMap.getString("uniTrunkGroupConfigName"));
        baseInfoPanel.add(tfUniTrunkGroupConfigName);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(uniTrunkGroupConfigMember));
//        tfUniTrunkGroupConfigMember.setName(fStringMap.getString("uniTrunkGroupConfigMember"));
//        baseInfoPanel.add(tfUniTrunkGroupConfigMember);
//        baseInfoPanel.add(new HSpacer());

        JPanel memberPanel = new JPanel();
        layout = new NTLayout(5, 5, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        memberPanel.setLayout(layout);

        memberPanel.setBorder(BorderFactory.createTitledBorder(uniTrunkGroupConfigMember));
        for (int i = 0; i <24; i++) {

            tfUniTrunkGroupConfigMember[i] = new JCheckBox("0/" + (i+1));
            memberPanel.add(tfUniTrunkGroupConfigMember[i]);
        }

        memberPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniTrunkGroupConfigMember));
        baseInfoPanel.add(memberPanel);
        baseInfoPanel.add(new HSpacer());



        baseInfoPanel.add(new JLabel(uniTrunkGroupConfigPolicy));
        tfUniTrunkGroupConfigPolicy.setName(fStringMap.getString("uniTrunkGroupConfigPolicy"));
        baseInfoPanel.add(tfUniTrunkGroupConfigPolicy);
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
        tfUniTrunkGroupConfigName.setLenScope(0, 255);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfUniTrunkGroupConfigIndex.setEditable(true);
            return;
        } else {
            tfUniTrunkGroupConfigIndex.setEditable(false);
        }

        UniTrunkGroupConfigTable mbean = (UniTrunkGroupConfigTable) getModel();
        if (mbean == null)
            return;

        tfUniTrunkGroupConfigIndex.setValue(mbean.getUniTrunkGroupConfigIndex());

        tfUniTrunkGroupConfigName.setValue(mbean.getUniTrunkGroupConfigName());
//        tfUniTrunkGroupConfigMember.setValue(mbean.getUniTrunkGroupConfigMember());

        tfUniTrunkGroupConfigPolicy.setSelectedIndex(getIndexFromValue(uniTrunkGroupConfigPolicyVList, mbean.getUniTrunkGroupConfigPolicy()));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new UniTrunkGroupConfigTable(fApplication.getSnmpProxy()));

        UniTrunkGroupConfigTable mbean = (UniTrunkGroupConfigTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setUniTrunkGroupConfigIndex(new Integer(tfUniTrunkGroupConfigIndex.getValue()));
        }

        mbean.setUniTrunkGroupConfigName(new String(tfUniTrunkGroupConfigName.getValue()));
//        mbean.setUniTrunkGroupConfigMember(new String(tfUniTrunkGroupConfigMember.getValue()));
        mbean.setUniTrunkGroupConfigPolicy(new Integer(uniTrunkGroupConfigPolicyVList[tfUniTrunkGroupConfigPolicy.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}