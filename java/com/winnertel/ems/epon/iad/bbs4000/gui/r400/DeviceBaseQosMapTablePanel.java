/**
 * Created by Zhou Chao, 2010/5/26
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.DeviceBaseQosMapTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DeviceBaseQosMapTablePanel extends UPanel {

    private int[] baseQosMapRuleIndexVList = new int[]{1, 2, 3,};
    private String[] baseQosMapRuleIndexTList = new String[]{
            fStringMap.getString("cos"), //1
            fStringMap.getString("tos"), //2
            fStringMap.getString("diffserv"), //3
    };
    private JComboBox tfBaseQosMapRuleIndex = new JComboBox(baseQosMapRuleIndexTList);

    private String[] baseQosMapOctet8VList = null;
    private String[] baseQosMapOctet16VList = null;
    private String[] baseQosMapOctet64VList = null;
    private JComboBox[] tfBaseQosMapOctet = null;

    private final String baseQosMapRuleIndex = fStringMap.getString("deviceBaseQosMapRuleIndex") + " : ";
    private final String baseQosMapOctet = fStringMap.getString("deviceBaseQosMapOctet") + " : ";

    public DeviceBaseQosMapTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(baseQosMapRuleIndex));
        baseInfoPanel.add(tfBaseQosMapRuleIndex);
        baseInfoPanel.add(new HSpacer());
        tfBaseQosMapRuleIndex.setEnabled(false);

        //BaseQosMapOctet panel
        JPanel baseQosMapOctetPanel = new JPanel();
        NTLayout layout1 = new NTLayout(16, 8, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout1.setMargins(6, 10, 6, 10);
        baseQosMapOctetPanel.setLayout(layout1);
        baseQosMapOctetPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(baseQosMapOctet)));

        baseQosMapOctet8VList = new String[8];
        for (int i = 0; i < baseQosMapOctet8VList.length; i++) {
            baseQosMapOctet8VList[i] = String.valueOf(i);
        }
        baseQosMapOctet16VList = new String[16];
        for (int i = 0; i < baseQosMapOctet16VList.length; i++) {
            baseQosMapOctet16VList[i] = String.valueOf(i);
        }
        baseQosMapOctet64VList = new String[64];
        for (int i = 0; i < baseQosMapOctet64VList.length; i++) {
            baseQosMapOctet64VList[i] = String.valueOf(i);
        }

        tfBaseQosMapOctet = new JComboBox[64];
        for (int i = 0; i < tfBaseQosMapOctet.length; i++) {
            tfBaseQosMapOctet[i] = new JComboBox();
            tfBaseQosMapOctet[i].setEnabled(false);
            baseQosMapOctetPanel.add(new JLabel(fStringMap.getString("priority") + i));
            baseQosMapOctetPanel.add(tfBaseQosMapOctet[i]);
        }

        tfBaseQosMapRuleIndex.setSelectedItem(null);
        tfBaseQosMapRuleIndex.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int rule = tfBaseQosMapRuleIndex.getSelectedIndex() + 1;
                selectBaseQosMaoOctetPanel(rule);
            }
        });

        JPanel allPanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(baseQosMapOctetPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(new JScrollPane(allPanel), BorderLayout.CENTER);

        setPreferredSize(new Dimension(500, 400));
    }

    protected void initForm() {
    }

    public void selectBaseQosMaoOctetPanel(int rule) {
        switch (rule) {
            case 1: //cos
                for (int i = 0; i < tfBaseQosMapOctet.length; i++) {
                    tfBaseQosMapOctet[i].setModel(new DefaultComboBoxModel(baseQosMapOctet8VList));
                    tfBaseQosMapOctet[i].setEnabled(i < 8);
                }
                break;
            case 2: //tos
                for (int i = 0; i < tfBaseQosMapOctet.length; i++) {
                    tfBaseQosMapOctet[i].setModel(new DefaultComboBoxModel(baseQosMapOctet16VList));
                    tfBaseQosMapOctet[i].setEnabled(i < 16);
                }
                break;
            default: //diffserv
                for (int i = 0; i < tfBaseQosMapOctet.length; i++) {
                    tfBaseQosMapOctet[i].setModel(new DefaultComboBoxModel(baseQosMapOctet64VList));
                    tfBaseQosMapOctet[i].setEnabled(i < 64);
                }
                break;
        }
    }

    public void refresh() {
        DeviceBaseQosMapTable mbean = (DeviceBaseQosMapTable) getModel();
        if (mbean == null)
            return;

        tfBaseQosMapRuleIndex.setSelectedIndex(getIndexFromValue(baseQosMapRuleIndexVList, mbean.getDeviceBaseQosMapRuleIndex()));
        //selectBaseQosMaoOctetPanel(mbean.getDeviceBaseQosMapRuleIndex()); //manually trigger 'addItemListener'
        setBaseQosMapOctet(mbean.getDeviceBaseQosMapRuleIndex(), mbean.getDeviceBaseQosMapOctet());
    }

    public void updateModel() {
        DeviceBaseQosMapTable mbean = (DeviceBaseQosMapTable) getModel();
        if (mbean == null)
            return;

        mbean.setDeviceBaseQosMapOctet(getBaseQosMapOctet(mbean.getDeviceBaseQosMapRuleIndex()));
    }

    private byte[] getBaseQosMapOctet(int rule) {
        int validLength = (rule == 1 ? 8 : rule == 2 ? 16 : 64);
        return getByteMap(tfBaseQosMapOctet, validLength);
    }

    private void setBaseQosMapOctet(int rule, byte[] queueMap) {
        int validLength = (rule == 1 ? 8 : rule == 2 ? 16 : 64);
        setByteMap(tfBaseQosMapOctet, validLength, queueMap);
    }

    private byte[] getByteMap(JComboBox[] boxes, int validLength) {
        byte[] b = new byte[validLength];
        for (int i = 0; (i < validLength) && (i <= boxes.length); i++)
            b[i] = (byte) Integer.parseInt((String) boxes[i].getSelectedItem());

        return b;
    }

    private void setByteMap(JComboBox[] boxes, int validLength, byte[] mibValue) {
        //for (int i = 0; i < boxes.length; i++)
        //    boxes[i].setSelectedItem(-1);
        for (int i = 0; (i < validLength) && (i < mibValue.length); i++)
            boxes[i].setSelectedItem(Byte.toString(mibValue[i]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}