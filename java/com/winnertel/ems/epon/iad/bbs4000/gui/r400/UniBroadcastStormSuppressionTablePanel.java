/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniBroadcastStormSuppressionTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class UniBroadcastStormSuppressionTablePanel extends UPanel {

    private int[] uniUnicastStormEnableVList = new int[]{
            1, 2,};
    private String[] uniUnicastStormEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfUniUnicastStormEnable = new JComboBox(uniUnicastStormEnableTList);

    private IntegerTextField tfUniUnicastStormInPacketRate = new IntegerTextField();
    private IntegerTextField tfUniUnicastStormOutPacketRate = new IntegerTextField();

    private int[] uniMulticastStormEnableVList = new int[]{
            1, 2,};
    private String[] uniMulticastStormEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfUniMulticastStormEnable = new JComboBox(uniMulticastStormEnableTList);

    private IntegerTextField tfUniMulticastStormInPacketRate = new IntegerTextField();
    private IntegerTextField tfUniMulticastStormOutPacketRate = new IntegerTextField();

    private int[] uniBroadcastStormEnableVList = new int[]{
            1, 2,};
    private String[] uniBroadcastStormEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfUniBroadcastStormEnable = new JComboBox(uniBroadcastStormEnableTList);
    private IntegerTextField tfUniBroadcastStormInPacketRate = new IntegerTextField();

    private IntegerTextField tfUniBroadcastStormOutPacketRate = new IntegerTextField();

    private final String uniUnicastStormEnable = fStringMap.getString("uniUnicastStormEnable") + " : ";
    private final String uniUnicastStormInPacketRate = fStringMap.getString("uniUnicastStormInPacketRate") + " : ";
    private final String uniUnicastStormOutPacketRate = fStringMap.getString("uniUnicastStormOutPacketRate") + " : ";
    private final String uniMulticastStormEnable = fStringMap.getString("uniMulticastStormEnable") + " : ";
    private final String uniMulticastStormInPacketRate = fStringMap.getString("uniMulticastStormInPacketRate") + " : ";
    private final String uniMulticastStormOutPacketRate = fStringMap.getString("uniMulticastStormOutPacketRate") + " : ";
    private final String uniBroadcastStormEnable = fStringMap.getString("uniBroadcastStormEnable") + " : ";
    private final String uniBroadcastStormInPacketRate = fStringMap.getString("uniBroadcastStormInPacketRate") + " : ";
    private final String uniBroadcastStormOutPacketRate = fStringMap.getString("uniBroadcastStormOutPacketRate") + " : ";

    public UniBroadcastStormSuppressionTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(uniUnicastStormEnable));
        tfUniUnicastStormEnable.setName(fStringMap.getString("uniUnicastStormEnable"));
        baseInfoPanel.add(tfUniUnicastStormEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniUnicastStormInPacketRate));
        tfUniUnicastStormInPacketRate.setName(fStringMap.getString("uniUnicastStormInPacketRate"));
        baseInfoPanel.add(tfUniUnicastStormInPacketRate);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniUnicastStormOutPacketRate));
        tfUniUnicastStormOutPacketRate.setName(fStringMap.getString("uniUnicastStormOutPacketRate"));
        baseInfoPanel.add(tfUniUnicastStormOutPacketRate);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniMulticastStormEnable));
        tfUniMulticastStormEnable.setName(fStringMap.getString("uniMulticastStormEnable"));
        baseInfoPanel.add(tfUniMulticastStormEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniMulticastStormInPacketRate));
        tfUniMulticastStormInPacketRate.setName(fStringMap.getString("uniMulticastStormInPacketRate"));
        baseInfoPanel.add(tfUniMulticastStormInPacketRate);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniMulticastStormOutPacketRate));
        tfUniMulticastStormOutPacketRate.setName(fStringMap.getString("uniMulticastStormOutPacketRate"));
        baseInfoPanel.add(tfUniMulticastStormOutPacketRate);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniBroadcastStormEnable));
        tfUniBroadcastStormEnable.setName(fStringMap.getString("uniBroadcastStormEnable"));
        baseInfoPanel.add(tfUniBroadcastStormEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniBroadcastStormInPacketRate));
        tfUniBroadcastStormInPacketRate.setName(fStringMap.getString("uniBroadcastStormInPacketRate"));
        baseInfoPanel.add(tfUniBroadcastStormInPacketRate);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniBroadcastStormOutPacketRate));
        tfUniBroadcastStormOutPacketRate.setName(fStringMap.getString("uniBroadcastStormOutPacketRate"));
        baseInfoPanel.add(tfUniBroadcastStormOutPacketRate);
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
        UniBroadcastStormSuppressionTable mbean = (UniBroadcastStormSuppressionTable) getModel();
        if (mbean == null)
            return;

        tfUniUnicastStormEnable.setSelectedIndex(getIndexFromValue(uniUnicastStormEnableVList, mbean.getUniUnicastStormEnable()));
        tfUniUnicastStormInPacketRate.setValue(mbean.getUniUnicastStormInPacketRate());
        tfUniUnicastStormOutPacketRate.setValue(mbean.getUniUnicastStormOutPacketRate());
        tfUniMulticastStormEnable.setSelectedIndex(getIndexFromValue(uniMulticastStormEnableVList, mbean.getUniMulticastStormEnable()));
        tfUniMulticastStormInPacketRate.setValue(mbean.getUniMulticastStormInPacketRate());
        tfUniMulticastStormOutPacketRate.setValue(mbean.getUniMulticastStormOutPacketRate());
        tfUniBroadcastStormEnable.setSelectedIndex(getIndexFromValue(uniBroadcastStormEnableVList, mbean.getUniBroadcastStormEnable()));
        tfUniBroadcastStormInPacketRate.setValue(mbean.getUniBroadcastStormInPacketRate());
        tfUniBroadcastStormOutPacketRate.setValue(mbean.getUniBroadcastStormOutPacketRate());
    }

    public void updateModel() {
        UniBroadcastStormSuppressionTable mbean = (UniBroadcastStormSuppressionTable) getModel();
        if (mbean == null)
            return;

        mbean.setUniUnicastStormEnable(new Integer(uniUnicastStormEnableVList[tfUniUnicastStormEnable.getSelectedIndex()]));
        mbean.setUniUnicastStormInPacketRate(new Integer(tfUniUnicastStormInPacketRate.getValue()));
        mbean.setUniUnicastStormOutPacketRate(new Integer(tfUniUnicastStormOutPacketRate.getValue()));
        mbean.setUniMulticastStormEnable(new Integer(uniMulticastStormEnableVList[tfUniMulticastStormEnable.getSelectedIndex()]));
        mbean.setUniMulticastStormInPacketRate(new Integer(tfUniMulticastStormInPacketRate.getValue()));
        mbean.setUniMulticastStormOutPacketRate(new Integer(tfUniMulticastStormOutPacketRate.getValue()));
        mbean.setUniBroadcastStormEnable(new Integer(uniBroadcastStormEnableVList[tfUniBroadcastStormEnable.getSelectedIndex()]));
        mbean.setUniBroadcastStormInPacketRate(new Integer(tfUniBroadcastStormInPacketRate.getValue()));
        mbean.setUniBroadcastStormOutPacketRate(new Integer(tfUniBroadcastStormOutPacketRate.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}