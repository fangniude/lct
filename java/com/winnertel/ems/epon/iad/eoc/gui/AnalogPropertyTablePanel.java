package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.AnalogPropertyTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The AnalogPropertyTablePanel class.
 * Created by DVM Creator
 */
public class AnalogPropertyTablePanel extends UPanel {


    private StringTextField cbAnalogAlarmParameterOID = new StringTextField();

    private int[] analogAlarmEnableVList = new int[]{
            0x00, 0x01, 0x02, 0x04, 0x08,};
    private String[] analogAlarmEnableTList = new String[]{
            fStringMap.getString("analogAlarmEnable_ALLCLOSE"),
            fStringMap.getString("analogAlarmEnable_LOLO"),
            fStringMap.getString("analogAlarmEnable_LO"),
            fStringMap.getString("analogAlarmEnable_HI"),
            fStringMap.getString("analogAlarmEnable_HIHI"),
    };
    private JComboBox tfAnalogAlarmEnable = new JComboBox(analogAlarmEnableTList);

    private int[] analogAlarmStateVList = new int[]{
            1, 2, 3, 4, 5,};
    private String[] analogAlarmStateTList = new String[]{
            fStringMap.getString("aasNominal"),
            fStringMap.getString("aasHIHI"),
            fStringMap.getString("aasHI"),
            fStringMap.getString("aasLO"),
            fStringMap.getString("aasLOLO"),
    };
    private JComboBox tfAnalogAlarmState = new JComboBox(analogAlarmStateTList);
    private IntegerTextField tfAnalogAlarmHIHI = new IntegerTextField();

    private IntegerTextField tfAnalogAlarmHI = new IntegerTextField();

    private IntegerTextField tfAnalogAlarmLO = new IntegerTextField();

    private IntegerTextField tfAnalogAlarmLOLO = new IntegerTextField();

    private IntegerTextField tfAnalogAlarmDeadband = new IntegerTextField();


    private final String analogAlarmParameterOID = fStringMap.getString("analogAlarmParameterOID") + " : ";
    private final String analogAlarmEnable = fStringMap.getString("analogAlarmEnable") + " : ";
    private final String analogAlarmState = fStringMap.getString("analogAlarmState") + " : ";
    private final String analogAlarmHIHI = fStringMap.getString("analogAlarmHIHI") + " : ";
    private final String analogAlarmHI = fStringMap.getString("analogAlarmHI") + " : ";
    private final String analogAlarmLO = fStringMap.getString("analogAlarmLO") + " : ";
    private final String analogAlarmLOLO = fStringMap.getString("analogAlarmLOLO") + " : ";
    private final String analogAlarmDeadband = fStringMap.getString("analogAlarmDeadband") + " : ";


    public AnalogPropertyTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(analogAlarmParameterOID));
        baseInfoPanel.add(cbAnalogAlarmParameterOID);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(analogAlarmEnable));
        tfAnalogAlarmEnable.setName(fStringMap.getString("analogAlarmEnable"));
        baseInfoPanel.add(tfAnalogAlarmEnable);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(analogAlarmState));
        baseInfoPanel.add(tfAnalogAlarmState);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(analogAlarmHIHI));
        tfAnalogAlarmHIHI.setName(fStringMap.getString("analogAlarmHIHI"));
        baseInfoPanel.add(tfAnalogAlarmHIHI);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(analogAlarmHI));
        tfAnalogAlarmHI.setName(fStringMap.getString("analogAlarmHI"));
        baseInfoPanel.add(tfAnalogAlarmHI);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(analogAlarmLO));
        tfAnalogAlarmLO.setName(fStringMap.getString("analogAlarmLO"));
        baseInfoPanel.add(tfAnalogAlarmLO);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(analogAlarmLOLO));
        tfAnalogAlarmLOLO.setName(fStringMap.getString("analogAlarmLOLO"));
        baseInfoPanel.add(tfAnalogAlarmLOLO);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(analogAlarmDeadband));
        tfAnalogAlarmDeadband.setName(fStringMap.getString("analogAlarmDeadband"));
        baseInfoPanel.add(tfAnalogAlarmDeadband);
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

        cbAnalogAlarmParameterOID.setEditable(false);
        tfAnalogAlarmState.setEnabled(false);

    }

    public void refresh() {

        AnalogPropertyTable mbean = (AnalogPropertyTable) getModel();

        cbAnalogAlarmParameterOID.setText(mbean.getAnalogAlarmParameterOID());
        byte[] baEnabled = mbean.getAnalogAlarmEnable();
        byte bEnabled = 0;
        if (baEnabled != null && baEnabled.length > 0) {
            bEnabled = baEnabled[0];
        }
        tfAnalogAlarmEnable.setSelectedIndex(getIndexFromValue(analogAlarmEnableVList, bEnabled));
        //tfAnalogAlarmState.setSelectedItem(null);
        tfAnalogAlarmState.setSelectedIndex(getIndexFromValue(analogAlarmStateVList, mbean.getAnalogAlarmState().intValue()));
        tfAnalogAlarmHIHI.setValue(mbean.getAnalogAlarmHIHI().intValue());
        tfAnalogAlarmHI.setValue(mbean.getAnalogAlarmHI().intValue());
        tfAnalogAlarmLO.setValue(mbean.getAnalogAlarmLO().intValue());
        tfAnalogAlarmLOLO.setValue(mbean.getAnalogAlarmLOLO().intValue());
        tfAnalogAlarmDeadband.setValue(mbean.getAnalogAlarmDeadband().intValue());

    }

    public boolean validateFrom() {

        int idx = tfAnalogAlarmEnable.getSelectedIndex();

        if (tfAnalogAlarmEnable.getSelectedItem() == null) {
            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_AnalogAlarmEnable"));
            return false;
        }

        return true;
    }


    public void updateModel() {

        AnalogPropertyTable mbean = (AnalogPropertyTable) getModel();

        byte[] bEnable = new byte[]{0};
        bEnable[0] = (byte) analogAlarmEnableVList[tfAnalogAlarmEnable.getSelectedIndex()];
        mbean.setAnalogAlarmEnable(bEnable);

        mbean.setAnalogAlarmHIHI(new Integer(tfAnalogAlarmHIHI.getValue()));
        mbean.setAnalogAlarmHI(new Integer(tfAnalogAlarmHI.getValue()));
        mbean.setAnalogAlarmLO(new Integer(tfAnalogAlarmLO.getValue()));
        mbean.setAnalogAlarmLOLO(new Integer(tfAnalogAlarmLOLO.getValue()));
        mbean.setAnalogAlarmDeadband(new Integer(tfAnalogAlarmDeadband.getValue()));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return -1;
    }
}
