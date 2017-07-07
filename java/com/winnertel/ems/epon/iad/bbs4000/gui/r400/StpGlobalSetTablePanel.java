/**
 * Created by Zhou Chao, 2010/5/11
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.StpGlobalSetTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class StpGlobalSetTablePanel extends UPanel {

    private int[] stpGlobalSetVersionVList = new int[]{1, 2,};
    private String[] stpGlobalSetVersionTList = new String[]{
            fStringMap.getString("rstp"), //1
            fStringMap.getString("stp"), //2
    };
    private JComboBox tfStpGlobalSetVersion = new JComboBox(stpGlobalSetVersionTList);

    private IntegerTextField tfStpGlobalSetPriority = new IntegerTextField();
    private IntegerTextField tfStpGlobalSetBridgeMaxAge = new IntegerTextField();
    private IntegerTextField tfStpGlobalSetBridgeHelloTime = new IntegerTextField();
    private IntegerTextField tfStpGlobalSetBridgeForwardDelay = new IntegerTextField();
    private IntegerTextField tfStpGlobalSetRstpTxHoldCount = new IntegerTextField();

    private int[] stpGlobalSetEnableVList = new int[]{1, 2,};
    private String[] stpGlobalSetEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfStpGlobalSetEnable = new JComboBox(stpGlobalSetEnableTList);

    private final String stpGlobalSetVersion = fStringMap.getString("stpGlobalSetVersion") + " : ";
    private final String stpGlobalSetPriority = fStringMap.getString("stpGlobalSetPriority") + " : ";
    private final String stpGlobalSetBridgeMaxAge = fStringMap.getString("stpGlobalSetBridgeMaxAge") + " : ";
    private final String stpGlobalSetBridgeHelloTime = fStringMap.getString("stpGlobalSetBridgeHelloTime") + " : ";
    private final String stpGlobalSetBridgeForwardDelay = fStringMap.getString("stpGlobalSetBridgeForwardDelay") + " : ";
    private final String stpGlobalSetRstpTxHoldCount = fStringMap.getString("stpGlobalSetRstpTxHoldCount") + " : ";
    private final String stpGlobalSetEnable = fStringMap.getString("stpGlobalSetEnable") + " : ";

    public StpGlobalSetTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(stpGlobalSetVersion));
        tfStpGlobalSetVersion.setName(fStringMap.getString("stpGlobalSetVersion"));
        baseInfoPanel.add(tfStpGlobalSetVersion);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(stpGlobalSetPriority));
        tfStpGlobalSetPriority.setName(fStringMap.getString("stpGlobalSetPriority"));
        baseInfoPanel.add(tfStpGlobalSetPriority);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(stpGlobalSetBridgeMaxAge));
        tfStpGlobalSetBridgeMaxAge.setName(fStringMap.getString("stpGlobalSetBridgeMaxAge"));
        baseInfoPanel.add(tfStpGlobalSetBridgeMaxAge);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(stpGlobalSetBridgeHelloTime));
        tfStpGlobalSetBridgeHelloTime.setName(fStringMap.getString("stpGlobalSetBridgeHelloTime"));
        baseInfoPanel.add(tfStpGlobalSetBridgeHelloTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(stpGlobalSetBridgeForwardDelay));
        tfStpGlobalSetBridgeForwardDelay.setName(fStringMap.getString("stpGlobalSetBridgeForwardDelay"));
        baseInfoPanel.add(tfStpGlobalSetBridgeForwardDelay);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(stpGlobalSetRstpTxHoldCount));
        tfStpGlobalSetRstpTxHoldCount.setName(fStringMap.getString("stpGlobalSetRstpTxHoldCount"));
        baseInfoPanel.add(tfStpGlobalSetRstpTxHoldCount);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(stpGlobalSetEnable));
        tfStpGlobalSetEnable.setName(fStringMap.getString("stpGlobalSetEnable"));
        baseInfoPanel.add(tfStpGlobalSetEnable);
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
        tfStpGlobalSetPriority.setValueScope(0, 65535);
        tfStpGlobalSetBridgeMaxAge.setValueScope(6, 40);
        tfStpGlobalSetBridgeHelloTime.setValueScope(1, 10);
        tfStpGlobalSetBridgeForwardDelay.setValueScope(4, 30);
        tfStpGlobalSetRstpTxHoldCount.setValueScope(1, 10);
    }

    public void refresh() {
        StpGlobalSetTable mbean = (StpGlobalSetTable) getModel();
        if (mbean == null)
            return;

        tfStpGlobalSetVersion.setSelectedIndex(getIndexFromValue(stpGlobalSetVersionVList, mbean.getStpGlobalSetVersion()));
        tfStpGlobalSetPriority.setValue(mbean.getStpGlobalSetPriority());
        tfStpGlobalSetBridgeMaxAge.setValue(mbean.getStpGlobalSetBridgeMaxAge()/100);
        tfStpGlobalSetBridgeHelloTime.setValue(mbean.getStpGlobalSetBridgeHelloTime()/100);
        tfStpGlobalSetBridgeForwardDelay.setValue(mbean.getStpGlobalSetBridgeForwardDelay()/100);
        tfStpGlobalSetRstpTxHoldCount.setValue(mbean.getStpGlobalSetRstpTxHoldCount());
        tfStpGlobalSetEnable.setSelectedIndex(getIndexFromValue(stpGlobalSetEnableVList, mbean.getStpGlobalSetEnable()));
    }

    public void updateModel() {
        StpGlobalSetTable mbean = (StpGlobalSetTable) getModel();
        if (mbean == null)
            return;

        mbean.setStpGlobalSetVersion(new Integer(stpGlobalSetVersionVList[tfStpGlobalSetVersion.getSelectedIndex()]));
        mbean.setStpGlobalSetPriority(new Integer(tfStpGlobalSetPriority.getValue()));
        mbean.setStpGlobalSetBridgeMaxAge(new Integer(tfStpGlobalSetBridgeMaxAge.getValue()*100));
        mbean.setStpGlobalSetBridgeHelloTime(new Integer(tfStpGlobalSetBridgeHelloTime.getValue()*100));
        mbean.setStpGlobalSetBridgeForwardDelay(new Integer(tfStpGlobalSetBridgeForwardDelay.getValue()*100));
        mbean.setStpGlobalSetRstpTxHoldCount(new Integer(tfStpGlobalSetRstpTxHoldCount.getValue()));
        mbean.setStpGlobalSetEnable(new Integer(stpGlobalSetEnableVList[tfStpGlobalSetEnable.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}