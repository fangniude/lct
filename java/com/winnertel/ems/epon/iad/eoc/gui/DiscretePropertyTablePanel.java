package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.formatter.AlarmLogInformationFormatter;
import com.winnertel.ems.epon.iad.eoc.mib.DiscretePropertyTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The DiscretePropertyTablePanel class.
 * Created by DVM Creator
 */
public class DiscretePropertyTablePanel extends UPanel {

    private StringTextField cbDiscreteAlarmParameterOID = new StringTextField();

    private int[] discreteAlarmEnableVList = new int[]{
            3, 2, 1,};
    private String[] discreteAlarmEnableTList = new String[]{
            fStringMap.getString("enableMinor"),
            fStringMap.getString("enableMajor"),
            fStringMap.getString("disable"),
    };
    private JComboBox tfDiscreteAlarmEnable = new JComboBox(discreteAlarmEnableTList);

    private AlarmLogInformationFormatter formatter = null;
    private final String discreteAlarmParameterOID = fStringMap.getString("discreteAlarmParameterOID") + " : ";
    private final String discreteAlarmEnable = fStringMap.getString("discreteAlarmEnable") + " : ";


    public DiscretePropertyTablePanel(IApplication app) {
        super(app);
        formatter = new AlarmLogInformationFormatter(app);
        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(discreteAlarmParameterOID));
        baseInfoPanel.add(cbDiscreteAlarmParameterOID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(discreteAlarmEnable));
        tfDiscreteAlarmEnable.setName(fStringMap.getString("discreteAlarmEnable"));
        baseInfoPanel.add(tfDiscreteAlarmEnable);
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
        cbDiscreteAlarmParameterOID.setEditable(false);
    }

    public void refresh() {

        DiscretePropertyTable mbean = (DiscretePropertyTable) getModel();

        try {
            cbDiscreteAlarmParameterOID.setText("" + formatter.formatAsStr(mbean.getDiscreteAlarmParameterOID()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //tfDiscreteAlarmValue.setText(mbean.getDiscreteAlarmValue().toString());
        tfDiscreteAlarmEnable.setSelectedIndex(getIndexFromValue(discreteAlarmEnableVList, mbean.getDiscreteAlarmEnable().intValue()));
    }

    public void updateModel() {

        DiscretePropertyTable mbean = (DiscretePropertyTable) getModel();


        mbean.setDiscreteAlarmEnable(new Integer(discreteAlarmEnableVList[tfDiscreteAlarmEnable.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }
}
