/**
 * Created by Zhou Chao, 2010/2/2
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcCombinedFeaturesFaxCfg;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Onu2CtcCombinedFeaturesFaxCfgPanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesModuleId = new JLabel();
    //private JLabel tfUtsDot3Onu2CtcCombinedFeaturesDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId = new JLabel();

    private int[] utsDot3Onu2CtcFaxmodemCfgT38ModeVList = new int[]{0, 1,};
    private String[] utsDot3Onu2CtcFaxmodemCfgT38ModeTList = new String[]{
            fStringMap.getString("t30"),
            fStringMap.getString("t38"),
    };
    private JComboBox tfUtsDot3Onu2CtcFaxmodemCfgT38Mode = new JComboBox(utsDot3Onu2CtcFaxmodemCfgT38ModeTList);

    private int[] utsDot3Onu2CtcFaxmodemCfgCtrlVList = new int[]{0, 1,};
    private String[] utsDot3Onu2CtcFaxmodemCfgCtrlTList = new String[]{
            fStringMap.getString("negiotation"),
            fStringMap.getString("autoVbd"),
    };
    private JComboBox tfUtsDot3Onu2CtcFaxmodemCfgCtrl = new JComboBox(utsDot3Onu2CtcFaxmodemCfgCtrlTList);

    private final String utsDot3Onu2CtcCombinedFeaturesModuleId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesModuleId") + ": ";
    //private final String utsDot3Onu2CtcCombinedFeaturesDeviceId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesDeviceId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesPortId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesLogicalPortId") + ": ";

    private final String utsDot3Onu2CtcFaxmodemCfgT38Mode = fStringMap.getString("utsDot3Onu2CtcFaxmodemCfgT38Mode") + ": ";
    private final String utsDot3Onu2CtcFaxmodemCfgCtrl = fStringMap.getString("utsDot3Onu2CtcFaxmodemCfgCtrl") + ": ";

    public Onu2CtcCombinedFeaturesFaxCfgPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcFaxmodemCfgT38Mode));
        tfUtsDot3Onu2CtcFaxmodemCfgT38Mode.setName(fStringMap.getString("utsDot3Onu2CtcFaxmodemCfgT38Mode"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcFaxmodemCfgT38Mode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcFaxmodemCfgCtrl));
        tfUtsDot3Onu2CtcFaxmodemCfgCtrl.setName(fStringMap.getString("utsDot3Onu2CtcFaxmodemCfgCtrl"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcFaxmodemCfgCtrl);
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
        Onu2CtcCombinedFeaturesFaxCfg mbean = (Onu2CtcCombinedFeaturesFaxCfg) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcCombinedFeaturesModuleId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesModuleId().toString());
        //tfUtsDot3Onu2CtcCombinedFeaturesDeviceId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesPortId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId().toString());

        tfUtsDot3Onu2CtcFaxmodemCfgT38Mode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcFaxmodemCfgT38ModeVList, mbean.getUtsDot3Onu2CtcFaxmodemCfgT38Mode().intValue()));
        tfUtsDot3Onu2CtcFaxmodemCfgCtrl.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcFaxmodemCfgCtrlVList, mbean.getUtsDot3Onu2CtcFaxmodemCfgCtrl().intValue()));
    }

    public void updateModel() {
        Onu2CtcCombinedFeaturesFaxCfg mbean = (Onu2CtcCombinedFeaturesFaxCfg) getModel();
        if (mbean == null)
            return;

        mbean.setUtsDot3Onu2CtcFaxmodemCfgT38Mode(new Integer(utsDot3Onu2CtcFaxmodemCfgT38ModeVList[tfUtsDot3Onu2CtcFaxmodemCfgT38Mode.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcFaxmodemCfgCtrl(new Integer(utsDot3Onu2CtcFaxmodemCfgCtrlVList[tfUtsDot3Onu2CtcFaxmodemCfgCtrl.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}