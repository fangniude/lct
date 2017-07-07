/**
 * Created by Zhou Chao, 2010/1/13
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcCombinedFeaturesResetCard;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Onu2CtcCombinedFeaturesResetCardPanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesModuleId = new JLabel();
    //private JLabel tfUtsDot3Onu2CtcCombinedFeaturesDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId = new JLabel();

//    private IntegerTextField tfUtsDot3Onu2CtcMduResetCardCardNumber = new IntegerTextField();
    private int[] utsDot3Onu2CtcMduResetCardCardNumberVList = new int[]{1, 2, 3, 4, 5, 6, 7, 8, };
    private Integer[] utsDot3Onu2CtcMduResetCardCardNumberTList = new Integer[]{
            1, 2, 3, 4, 5, 6, 7, 8
    };
    private JComboBox tfUtsDot3Onu2CtcMduResetCardCardNumber = new JComboBox(utsDot3Onu2CtcMduResetCardCardNumberTList);

    private final String utsDot3Onu2CtcCombinedFeaturesModuleId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesModuleId") + ": ";
    //private final String utsDot3Onu2CtcCombinedFeaturesDeviceId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesDeviceId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesPortId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesLogicalPortId") + ": ";

    private final String utsDot3Onu2CtcMduResetCardCardNumber = fStringMap.getString("utsDot3Onu2CtcMduResetCardCardNumber") + ": ";

    public Onu2CtcCombinedFeaturesResetCardPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduResetCardCardNumber));
        tfUtsDot3Onu2CtcMduResetCardCardNumber.setName(fStringMap.getString("utsDot3Onu2CtcMduResetCardCardNumber"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduResetCardCardNumber);
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
        Onu2CtcCombinedFeaturesResetCard mbean = (Onu2CtcCombinedFeaturesResetCard) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcCombinedFeaturesModuleId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesModuleId().toString());
        //tfUtsDot3Onu2CtcCombinedFeaturesDeviceId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesPortId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId().toString());
//        tfUtsDot3Onu2CtcMduResetCardCardNumber.setValue(mbean.getUtsDot3Onu2CtcMduResetCardCardNumber().intValue());
    }

    public void updateModel() {
        Onu2CtcCombinedFeaturesResetCard mbean = (Onu2CtcCombinedFeaturesResetCard) getModel();
        if (mbean == null)
            return;

		mbean
				.setUtsDot3Onu2CtcMduResetCardCardNumber(utsDot3Onu2CtcMduResetCardCardNumberVList[tfUtsDot3Onu2CtcMduResetCardCardNumber
						.getSelectedIndex()]);
		mbean.setUtsDot3Onu2CtcMduResetCardReset(1); // reset(1)
    }

}