/**
 * Title          :   OnuRateCtrSchProfTablePanel.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuRateCtrSchProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Shen Dayong
 *         Create on 2008-9-30
 *         Modify by HZ21044
 */

public class OnuRateCtrSchProfTablePanel extends UPanel {

    private LongTextField tfSchedulerProfileIndex = new LongTextField();

    private StringTextField tfOnuRateCtrSchProfileName = new StringTextField();

    private LongTextField tfSir = new LongTextField();

    private LongTextField tfPir = new LongTextField();

    private LongTextField tfSchedulerWeight = new LongTextField();

    private final String schedulerProfileIndex =
            fStringMap.getString("schedulerProfileIndex") + " : ";
    private final String onuRateCtrSchProfileName =
            fStringMap.getString("onuRateCtrSchProfileName") + " : ";
    private final String sir = fStringMap.getString("sir") + " : ";
    private final String pir = fStringMap.getString("pir") + " : ";
    private final String schedulerWeight = fStringMap.getString("schedulerWeight") + " : ";

    public OnuRateCtrSchProfTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(schedulerProfileIndex));
        baseInfoPanel.add(tfSchedulerProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuRateCtrSchProfileName));
        tfOnuRateCtrSchProfileName.setName(fStringMap.getString("onuRateCtrSchProfileName"));
        baseInfoPanel.add(tfOnuRateCtrSchProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(sir));
        tfSir.setName(fStringMap.getString("sir"));
        baseInfoPanel.add(tfSir);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(pir));
        tfPir.setName(fStringMap.getString("pir"));
        baseInfoPanel.add(tfPir);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(schedulerWeight));
        tfSchedulerWeight.setName(fStringMap.getString("schedulerWeight"));
        baseInfoPanel.add(tfSchedulerWeight);
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
        tfSchedulerProfileIndex.setValueScope(0, 4294967295l);

        tfSir.setValueScope(0, 4294967295l);

        tfPir.setValueScope(0, 4294967295l);

        tfSchedulerWeight.setValueScope(0, 255);

    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfSchedulerProfileIndex.setEnabled(true);
            return;
        } else {
            tfSchedulerProfileIndex.setEnabled(false);
        }
        OnuRateCtrSchProfTable mbean = (OnuRateCtrSchProfTable) getModel();
        BeanService.refreshBean(fApplication, mbean);

        String sValue = "";
        long lValue = 0;

        try {
            sValue = mbean.getSchedulerProfileIndex().toString();
        } catch (Exception e) {
            sValue = "";
        }
        tfSchedulerProfileIndex.setText(sValue);

        try {
            sValue = mbean.getOnuRateCtrSchProfileName();
        } catch (Exception e) {
            sValue = "";
        }
        tfOnuRateCtrSchProfileName.setValue(sValue);

        try {
            lValue = mbean.getSir().longValue();
        } catch (Exception e) {
            lValue = 0;
        }
        tfSir.setValue(lValue);

        try {
            lValue = mbean.getPir().longValue();
        } catch (Exception e) {
            lValue = 0;
        }
        tfPir.setValue(lValue);

        try {
            lValue = mbean.getSchedulerWeight().longValue();
        } catch (Exception e) {
            lValue = 0;
        }
        tfSchedulerWeight.setValue(lValue);

    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuRateCtrSchProfTable(fApplication.getSnmpProxy()));

        OnuRateCtrSchProfTable mbean = (OnuRateCtrSchProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setSchedulerProfileIndex(tfSchedulerProfileIndex.getValue());
        }

        mbean.setOnuRateCtrSchProfileName(new String(tfOnuRateCtrSchProfileName.getValue()));
        mbean.setSir(new Long(tfSir.getValue()));
        mbean.setPir(new Long(tfPir.getValue()));
        mbean.setSchedulerWeight(new Long(tfSchedulerWeight.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}