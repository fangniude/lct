/**
 * Created by Zhou Chao, 2010/3/5
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PonBroadcastStormSuppressionTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class PonBroadcastStormSuppressionTablePanel extends UPanel {

/*
    private JLabel tfBsDeviceIndex = new JLabel();
    private JLabel tfBsCardIndex = new JLabel();
    private JLabel tfBsPortIndex = new JLabel();
*/

    private int[] unicastStormEnableVList = new int[]{1, 2,};
    private String[] unicastStormEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfUnicastStormEnable = new JComboBox(unicastStormEnableTList);

    private IntegerTextField tfUnicastStormInPacketRate = new IntegerTextField();
    private IntegerTextField tfUnicastStormOutPacketRate = new IntegerTextField();

    private int[] multicastStormEnableVList = new int[]{1, 2,};
    private String[] multicastStormEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfMulticastStormEnable = new JComboBox(multicastStormEnableTList);

    private IntegerTextField tfMulticastStormInPacketRate = new IntegerTextField();
    private IntegerTextField tfMulticastStormOutPacketRate = new IntegerTextField();

    private int[] broadcastStormEnableVList = new int[]{1, 2,};
    private String[] broadcastStormEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfBroadcastStormEnable = new JComboBox(broadcastStormEnableTList);

    private IntegerTextField tfBroadcastStormInPacketRate = new IntegerTextField();
    private IntegerTextField tfBroadcastStormOutPacketRate = new IntegerTextField();

/*
    private final String bsDeviceIndex = fStringMap.getString("bsDeviceIndex") + " : ";
    private final String bsCardIndex = fStringMap.getString("bsCardIndex") + " : ";
    private final String bsPortIndex = fStringMap.getString("bsPortIndex") + " : ";
*/
    private final String unicastStormEnable = fStringMap.getString("unicastStormEnable") + " : ";
    private final String unicastStormInPacketRate = fStringMap.getString("unicastStormInPacketRate") + " : ";
    private final String unicastStormOutPacketRate = fStringMap.getString("unicastStormOutPacketRate") + " : ";
    private final String multicastStormEnable = fStringMap.getString("multicastStormEnable") + " : ";
    private final String multicastStormInPacketRate = fStringMap.getString("multicastStormInPacketRate") + " : ";
    private final String multicastStormOutPacketRate = fStringMap.getString("multicastStormOutPacketRate") + " : ";
    private final String broadcastStormEnable = fStringMap.getString("broadcastStormEnable") + " : ";
    private final String broadcastStormInPacketRate = fStringMap.getString("broadcastStormInPacketRate") + " : ";
    private final String broadcastStormOutPacketRate = fStringMap.getString("broadcastStormOutPacketRate") + " : ";

    public PonBroadcastStormSuppressionTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

/*
        baseInfoPanel.add(new JLabel(bsDeviceIndex));
        baseInfoPanel.add(tfBsDeviceIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(bsCardIndex));
        baseInfoPanel.add(tfBsCardIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(bsPortIndex));
        baseInfoPanel.add(tfBsPortIndex);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(unicastStormEnable));
        tfUnicastStormEnable.setName(fStringMap.getString("unicastStormEnable"));
        baseInfoPanel.add(tfUnicastStormEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(unicastStormInPacketRate));
        tfUnicastStormInPacketRate.setName(fStringMap.getString("unicastStormInPacketRate"));
        baseInfoPanel.add(tfUnicastStormInPacketRate);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(unicastStormOutPacketRate));
        tfUnicastStormOutPacketRate.setName(fStringMap.getString("unicastStormOutPacketRate"));
        baseInfoPanel.add(tfUnicastStormOutPacketRate);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(multicastStormEnable));
        tfMulticastStormEnable.setName(fStringMap.getString("multicastStormEnable"));
        baseInfoPanel.add(tfMulticastStormEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(multicastStormInPacketRate));
        tfMulticastStormInPacketRate.setName(fStringMap.getString("multicastStormInPacketRate"));
        baseInfoPanel.add(tfMulticastStormInPacketRate);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(multicastStormOutPacketRate));
        tfMulticastStormOutPacketRate.setName(fStringMap.getString("multicastStormOutPacketRate"));
        baseInfoPanel.add(tfMulticastStormOutPacketRate);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(broadcastStormEnable));
        tfBroadcastStormEnable.setName(fStringMap.getString("broadcastStormEnable"));
        baseInfoPanel.add(tfBroadcastStormEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(broadcastStormInPacketRate));
        tfBroadcastStormInPacketRate.setName(fStringMap.getString("broadcastStormInPacketRate"));
        baseInfoPanel.add(tfBroadcastStormInPacketRate);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(broadcastStormOutPacketRate));
        tfBroadcastStormOutPacketRate.setName(fStringMap.getString("broadcastStormOutPacketRate"));
        baseInfoPanel.add(tfBroadcastStormOutPacketRate);
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
        PonBroadcastStormSuppressionTable mbean = (PonBroadcastStormSuppressionTable) getModel();
        if (mbean == null)
            return;

/*
        tfBsDeviceIndex.setText(mbean.getBsDeviceIndex() != null ? mbean.getBsDeviceIndex().toString() : "");
        tfBsCardIndex.setText(mbean.getBsCardIndex() != null ? mbean.getBsCardIndex().toString() : "");
        tfBsPortIndex.setText(mbean.getBsPortIndex() != null ? mbean.getBsPortIndex().toString() : "");
*/
        tfUnicastStormEnable.setSelectedIndex(getIndexFromValue(unicastStormEnableVList, mbean.getUnicastStormEnable()));
        tfUnicastStormInPacketRate.setValue(mbean.getUnicastStormInPacketRate());
        tfUnicastStormOutPacketRate.setValue(mbean.getUnicastStormOutPacketRate());
        tfMulticastStormEnable.setSelectedIndex(getIndexFromValue(multicastStormEnableVList, mbean.getMulticastStormEnable()));
        tfMulticastStormInPacketRate.setValue(mbean.getMulticastStormInPacketRate());
        tfMulticastStormOutPacketRate.setValue(mbean.getMulticastStormOutPacketRate());
        tfBroadcastStormEnable.setSelectedIndex(getIndexFromValue(broadcastStormEnableVList, mbean.getBroadcastStormEnable()));
        tfBroadcastStormInPacketRate.setValue(mbean.getBroadcastStormInPacketRate());
        tfBroadcastStormOutPacketRate.setValue(mbean.getBroadcastStormOutPacketRate());
    }

    public void updateModel() {
        PonBroadcastStormSuppressionTable mbean = (PonBroadcastStormSuppressionTable) getModel();
        if (mbean == null)
            return;

        mbean.setUnicastStormEnable(new Integer(unicastStormEnableVList[tfUnicastStormEnable.getSelectedIndex()]));
        mbean.setUnicastStormInPacketRate(new Integer(tfUnicastStormInPacketRate.getValue()));
        mbean.setUnicastStormOutPacketRate(new Integer(tfUnicastStormOutPacketRate.getValue()));
        mbean.setMulticastStormEnable(new Integer(multicastStormEnableVList[tfMulticastStormEnable.getSelectedIndex()]));
        mbean.setMulticastStormInPacketRate(new Integer(tfMulticastStormInPacketRate.getValue()));
        mbean.setMulticastStormOutPacketRate(new Integer(tfMulticastStormOutPacketRate.getValue()));
        mbean.setBroadcastStormEnable(new Integer(broadcastStormEnableVList[tfBroadcastStormEnable.getSelectedIndex()]));
        mbean.setBroadcastStormInPacketRate(new Integer(tfBroadcastStormInPacketRate.getValue()));
        mbean.setBroadcastStormOutPacketRate(new Integer(tfBroadcastStormOutPacketRate.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}