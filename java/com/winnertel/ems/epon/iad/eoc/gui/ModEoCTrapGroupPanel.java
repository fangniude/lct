package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCTrapGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCTrapGroupPanel class.
 * Created by DVM Creator
 */
public class ModEoCTrapGroupPanel extends UPanel {

    private IntegerTextField tfModEoCTrapMaxTimes = new IntegerTextField();

    private IntegerTextField tfModEoCTrapMinInterval = new IntegerTextField();

    private IntegerTextField tfModEoCTrapMaxInterval = new IntegerTextField();

    private JLabel tfModEoCTrapVertion = new JLabel();


    private final String modEoCTrapMaxTimes = fStringMap.getString("modEoCTrapMaxTimes") + " : ";
    private final String modEoCTrapMinInterval = fStringMap.getString("modEoCTrapMinInterval") + " : ";
    private final String modEoCTrapMaxInterval = fStringMap.getString("modEoCTrapMaxInterval") + " : ";
    private final String modEoCTrapVertion = fStringMap.getString("modEoCTrapVertion") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public ModEoCTrapGroupPanel(IApplication app) {
        super(app);
        setModel(new ModEoCTrapGroup(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCTrapGroup");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCTrapMaxTimes));
        tfModEoCTrapMaxTimes.setName(fStringMap.getString("modEoCTrapMaxTimes"));
        baseInfoPanel.add(tfModEoCTrapMaxTimes);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCTrapMinInterval));
        tfModEoCTrapMinInterval.setName(fStringMap.getString("modEoCTrapMinInterval"));
        baseInfoPanel.add(tfModEoCTrapMinInterval);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCTrapMaxInterval));
        tfModEoCTrapMaxInterval.setName(fStringMap.getString("modEoCTrapMaxInterval"));
        baseInfoPanel.add(tfModEoCTrapMaxInterval);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCTrapVertion));
        baseInfoPanel.add(tfModEoCTrapVertion);
        baseInfoPanel.add(new HSpacer());


        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);


    }

    protected void initForm() {
        tfModEoCTrapMaxTimes.setValueScope(1, 255);

        tfModEoCTrapMinInterval.setValueScope(0, 2147483647);

        tfModEoCTrapMaxInterval.setValueScope(0, 2147483647);


    }

    public void refresh() {

        ModEoCTrapGroup mbean = (ModEoCTrapGroup) getModel();
        BeanService.refreshBean(fApplication, mbean);

        tfModEoCTrapMaxTimes.setValue(mbean.getModEoCTrapMaxTimes().intValue());
        tfModEoCTrapMinInterval.setValue(mbean.getModEoCTrapMinInterval().intValue());
        tfModEoCTrapMaxInterval.setValue(mbean.getModEoCTrapMaxInterval().intValue());
        tfModEoCTrapVertion.setText(mbean.getModEoCTrapVertion());

    }

    public void updateModel() {

        ModEoCTrapGroup mbean = (ModEoCTrapGroup) getModel();

        mbean.setModEoCTrapMaxTimes(new Integer(tfModEoCTrapMaxTimes.getValue()));
        mbean.setModEoCTrapMinInterval(new Integer(tfModEoCTrapMinInterval.getValue()));
        mbean.setModEoCTrapMaxInterval(new Integer(tfModEoCTrapMaxInterval.getValue()));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

    //public boolean validateFrom(){
    //    return tfModEoCTrapMinInterval.isValid() && tfModEoCTrapMaxInterval.isValid() ;
    //}

}
