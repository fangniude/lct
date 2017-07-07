/**
 * Created by Zhou Chao, 2010/1/13
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcCombinedFeaturesHoldover;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Onu2CtcCombinedFeaturesHoldoverPanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesModuleId = new JLabel();
    //private JLabel tfUtsDot3Onu2CtcCombinedFeaturesDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId = new JLabel();

    private int[] utsDot3Onu2CtcHoldoverActionVList = new int[]{
            1, 2,};
    private String[] utsDot3Onu2CtcHoldoverActionTList = new String[]{
            fStringMap.getString("disable"), //1
            fStringMap.getString("enable"), //2
    };
    private JComboBox tfUtsDot3Onu2CtcHoldoverAction = new JComboBox(utsDot3Onu2CtcHoldoverActionTList);

    private IntegerTextField tfUtsDot3Onu2CtcHoldoverTime = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcActivePonifAdminActivePon = new IntegerTextField();
    //private IntegerTextField tfUtsDot3Onu2CtcTftpOamCommit = new IntegerTextField();

    private final String utsDot3Onu2CtcCombinedFeaturesModuleId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesModuleId") + ": ";
    //private final String utsDot3Onu2CtcCombinedFeaturesDeviceId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesDeviceId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesPortId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesLogicalPortId") + ": ";
    private final String utsDot3Onu2CtcHoldoverAction = fStringMap.getString("utsDot3Onu2CtcHoldoverAction") + ": ";
    private final String utsDot3Onu2CtcHoldoverTime = fStringMap.getString("utsDot3Onu2CtcHoldoverTime") + ": ";
    private final String utsDot3Onu2CtcActivePonifAdminActivePon = fStringMap.getString("utsDot3Onu2CtcActivePonifAdminActivePon") + ": ";
    //private final String utsDot3Onu2CtcTftpOamCommit = fStringMap.getString("utsDot3Onu2CtcTftpOamCommit") + ": ";

    public Onu2CtcCombinedFeaturesHoldoverPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesModuleId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesDeviceId));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesDeviceId);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesLogicalPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcHoldoverAction));
        tfUtsDot3Onu2CtcHoldoverAction.setName(fStringMap.getString("utsDot3Onu2CtcHoldoverAction"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcHoldoverAction);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcHoldoverTime));
        tfUtsDot3Onu2CtcHoldoverTime.setName(fStringMap.getString("utsDot3Onu2CtcHoldoverTime"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcHoldoverTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcActivePonifAdminActivePon));
        tfUtsDot3Onu2CtcActivePonifAdminActivePon.setName(fStringMap.getString("utsDot3Onu2CtcActivePonifAdminActivePon"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcActivePonifAdminActivePon);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcTftpOamCommit));
        //tfUtsDot3Onu2CtcTftpOamCommit.setName(fStringMap.getString("utsDot3Onu2CtcTftpOamCommit"));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcTftpOamCommit);
        //baseInfoPanel.add(new HSpacer());

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
        Onu2CtcCombinedFeaturesHoldover mbean = (Onu2CtcCombinedFeaturesHoldover) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcCombinedFeaturesModuleId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesModuleId().toString());
        //tfUtsDot3Onu2CtcCombinedFeaturesDeviceId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesPortId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId().toString());
        tfUtsDot3Onu2CtcHoldoverAction.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcHoldoverActionVList, mbean.getUtsDot3Onu2CtcHoldoverAction().intValue()));
        tfUtsDot3Onu2CtcHoldoverTime.setValue(mbean.getUtsDot3Onu2CtcHoldoverTime().intValue());
        tfUtsDot3Onu2CtcActivePonifAdminActivePon.setValue(mbean.getUtsDot3Onu2CtcActivePonifAdminActivePon().intValue());
        //tfUtsDot3Onu2CtcTftpOamCommit.setValue(mbean.getUtsDot3Onu2CtcTftpOamCommit().intValue());
    }

    public void updateModel() {
        Onu2CtcCombinedFeaturesHoldover mbean = (Onu2CtcCombinedFeaturesHoldover) getModel();
        if (mbean == null)
            return;

        mbean.setUtsDot3Onu2CtcHoldoverAction(new Integer(utsDot3Onu2CtcHoldoverActionVList[tfUtsDot3Onu2CtcHoldoverAction.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcHoldoverTime(new Integer(tfUtsDot3Onu2CtcHoldoverTime.getValue()));
        mbean.setUtsDot3Onu2CtcActivePonifAdminActivePon(new Integer(tfUtsDot3Onu2CtcActivePonifAdminActivePon.getValue()));
        //mbean.setUtsDot3Onu2CtcTftpOamCommit(new Integer(tfUtsDot3Onu2CtcTftpOamCommit.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}