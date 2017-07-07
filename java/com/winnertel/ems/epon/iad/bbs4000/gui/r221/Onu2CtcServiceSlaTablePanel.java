package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing.ServerSlaBytesItemPanel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing.ServiceSlaWrrWeightPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcServiceSlaTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Onu2CtcServiceSlaTablePanel extends UPanel {
    private JLabel tfUtsDot3Onu2CtcServiceSlaModuleId = new JLabel();
    //private JLabel tfUtsDot3Onu2CtcServiceSlaDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcServiceSlaPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcServiceSlaLogicalPortId = new JLabel();

    private int[] utsDot3Onu2CtcServiceSlaOperationVList = new int[]{0, 1,};
    private String[] utsDot3Onu2CtcServiceSlaOperationTList = new String[]{
            fStringMap.getString("deactivate"),
            fStringMap.getString("activate"),
    };
    private JComboBox tfUtsDot3Onu2CtcServiceSlaOperation = new JComboBox(utsDot3Onu2CtcServiceSlaOperationTList);

    private int[] utsDot3Onu2CtcServiceSlaBestEffortScheduleVList = new int[]{0, 1, 2,};
    private String[] utsDot3Onu2CtcServiceSlaBestEffortScheduleTList = new String[]{
            fStringMap.getString("sp"),
            fStringMap.getString("wrr"),
            fStringMap.getString("spwrr"),
    };
    private JComboBox tfUtsDot3Onu2CtcServiceSlaBestEffortSchedule = new JComboBox(utsDot3Onu2CtcServiceSlaBestEffortScheduleTList);

    private IntegerTextField tfUtsDot3Onu2CtcServiceSlaHighPriorityValue = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcServiceSlaCycleLength = new IntegerTextField();
    //private IntegerTextField tfUtsDot3Onu2CtcServiceSlaServiceNumbers = new IntegerTextField();
    //private StringTextField tfUtsDot3Onu2CtcServiceSlaQueue = new StringTextField();

    private ServerSlaBytesItemPanel tfUtsDot3Onu2CtcServiceSlaFixPktSize = null;
    private ServerSlaBytesItemPanel tfUtsDot3Onu2CtcServiceSlaFixBw = null;
    private ServerSlaBytesItemPanel tfUtsDot3Onu2CtcServiceSlaGuaranteedBw = null;
    private ServerSlaBytesItemPanel tfUtsDot3Onu2CtcServiceSlaBestEffortBw = null;
    private ServiceSlaWrrWeightPanel tfUtsDot3Onu2CtcServiceSlaWrrWeight = null;

    private final String utsDot3Onu2CtcServiceSlaModuleId = fStringMap.getString("utsDot3Onu2CtcServiceSlaModuleId") + ": ";
    //private final String utsDot3Onu2CtcServiceSlaDeviceId = fStringMap.getString("utsDot3Onu2CtcServiceSlaDeviceId") + ": ";
    private final String utsDot3Onu2CtcServiceSlaPortId = fStringMap.getString("utsDot3Onu2CtcServiceSlaPortId") + ": ";
    private final String utsDot3Onu2CtcServiceSlaLogicalPortId = fStringMap.getString("utsDot3Onu2CtcServiceSlaLogicalPortId") + ": ";

    private final String utsDot3Onu2CtcServiceSlaOperation = fStringMap.getString("utsDot3Onu2CtcServiceSlaOperation") + ": ";
    private final String utsDot3Onu2CtcServiceSlaBestEffortSchedule = fStringMap.getString("utsDot3Onu2CtcServiceSlaBestEffortSchedule") + ": ";
    private final String utsDot3Onu2CtcServiceSlaHighPriorityValue = fStringMap.getString("utsDot3Onu2CtcServiceSlaHighPriorityValue") + ": ";
    private final String utsDot3Onu2CtcServiceSlaCycleLength = fStringMap.getString("utsDot3Onu2CtcServiceSlaCycleLength") + ": ";
    //private final String utsDot3Onu2CtcServiceSlaServiceNumbers = fStringMap.getString("utsDot3Onu2CtcServiceSlaServiceNumbers") + ": ";
    //private final String utsDot3Onu2CtcServiceSlaQueue = fStringMap.getString("utsDot3Onu2CtcServiceSlaQueue") + ": ";
    private final String utsDot3Onu2CtcServiceSlaFixPktSize = fStringMap.getString("utsDot3Onu2CtcServiceSlaFixPktSize") + ": ";
    private final String utsDot3Onu2CtcServiceSlaFixBw = fStringMap.getString("utsDot3Onu2CtcServiceSlaFixBw") + ": ";
    private final String utsDot3Onu2CtcServiceSlaGuaranteedBw = fStringMap.getString("utsDot3Onu2CtcServiceSlaGuaranteedBw") + ": ";
    private final String utsDot3Onu2CtcServiceSlaBestEffortBw = fStringMap.getString("utsDot3Onu2CtcServiceSlaBestEffortBw") + ": ";
    private final String utsDot3Onu2CtcServiceSlaWrrWeight = fStringMap.getString("utsDot3Onu2CtcServiceSlaWrrWeight") + ": ";

    public Onu2CtcServiceSlaTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(12, 3, NTLayout.LEFT, NTLayout.TOP, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaModuleId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaDeviceId));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaDeviceId);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaLogicalPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaOperation));
        tfUtsDot3Onu2CtcServiceSlaOperation.setName(fStringMap.getString("utsDot3Onu2CtcServiceSlaOperation"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaOperation);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaBestEffortSchedule));
        tfUtsDot3Onu2CtcServiceSlaBestEffortSchedule.setName(fStringMap.getString("utsDot3Onu2CtcServiceSlaBestEffortSchedule"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaBestEffortSchedule);
        baseInfoPanel.add(new HSpacer());
        
        tfUtsDot3Onu2CtcServiceSlaBestEffortSchedule.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if(tfUtsDot3Onu2CtcServiceSlaBestEffortSchedule.getSelectedIndex() == 0) {
        			tfUtsDot3Onu2CtcServiceSlaWrrWeight.setValue(new byte[8]);
        			tfUtsDot3Onu2CtcServiceSlaWrrWeight.setEnabled(0);
        		}
        		else {
        			tfUtsDot3Onu2CtcServiceSlaWrrWeight.setEnabled(9);
        		}
        	}
        });

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaHighPriorityValue));
        tfUtsDot3Onu2CtcServiceSlaHighPriorityValue.setName(fStringMap.getString("utsDot3Onu2CtcServiceSlaHighPriorityValue"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaHighPriorityValue);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaCycleLength));
        tfUtsDot3Onu2CtcServiceSlaCycleLength.setName(fStringMap.getString("utsDot3Onu2CtcServiceSlaCycleLength"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaCycleLength);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaServiceNumbers));
        //tfUtsDot3Onu2CtcServiceSlaServiceNumbers.setName(fStringMap.getString("utsDot3Onu2CtcServiceSlaServiceNumbers"));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaServiceNumbers);
        //baseInfoPanel.add(new HSpacer());
        //
        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaQueue));
        //tfUtsDot3Onu2CtcServiceSlaQueue.setName(fStringMap.getString("utsDot3Onu2CtcServiceSlaQueue"));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaQueue);
        //baseInfoPanel.add(new HSpacer());

        tfUtsDot3Onu2CtcServiceSlaFixPktSize = new ServerSlaBytesItemPanel(fApplication);
        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaFixPktSize));
        tfUtsDot3Onu2CtcServiceSlaFixPktSize.setName(fStringMap.getString("utsDot3Onu2CtcServiceSlaFixPktSize"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaFixPktSize);
        baseInfoPanel.add(new HSpacer());

        tfUtsDot3Onu2CtcServiceSlaFixBw = new ServerSlaBytesItemPanel(fApplication);
        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaFixBw));
        tfUtsDot3Onu2CtcServiceSlaFixBw.setName(fStringMap.getString("utsDot3Onu2CtcServiceSlaFixBw"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaFixBw);
        baseInfoPanel.add(new HSpacer());

        tfUtsDot3Onu2CtcServiceSlaGuaranteedBw = new ServerSlaBytesItemPanel(fApplication);
        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaGuaranteedBw));
        tfUtsDot3Onu2CtcServiceSlaGuaranteedBw.setName(fStringMap.getString("utsDot3Onu2CtcServiceSlaGuaranteedBw"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaGuaranteedBw);
        baseInfoPanel.add(new HSpacer());

        tfUtsDot3Onu2CtcServiceSlaBestEffortBw = new ServerSlaBytesItemPanel(fApplication);
        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaBestEffortBw));
        tfUtsDot3Onu2CtcServiceSlaBestEffortBw.setName(fStringMap.getString("utsDot3Onu2CtcServiceSlaBestEffortBw"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaBestEffortBw);
        baseInfoPanel.add(new HSpacer());

        tfUtsDot3Onu2CtcServiceSlaWrrWeight = new ServiceSlaWrrWeightPanel(fApplication);
        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcServiceSlaWrrWeight));
        tfUtsDot3Onu2CtcServiceSlaWrrWeight.setName(fStringMap.getString("utsDot3Onu2CtcServiceSlaWrrWeight"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcServiceSlaWrrWeight);
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
        tfUtsDot3Onu2CtcServiceSlaHighPriorityValue.setValueScope(0, 7);
        tfUtsDot3Onu2CtcServiceSlaCycleLength.setValueScope(0, 65535);
    }

    public void refresh() {
        Onu2CtcServiceSlaTable mbean = (Onu2CtcServiceSlaTable) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcServiceSlaModuleId.setText(mbean.getUtsDot3Onu2CtcServiceSlaModuleId().toString());
        tfUtsDot3Onu2CtcServiceSlaPortId.setText(mbean.getUtsDot3Onu2CtcServiceSlaPortId().toString());
        tfUtsDot3Onu2CtcServiceSlaLogicalPortId.setText(mbean.getUtsDot3Onu2CtcServiceSlaLogicalPortId().toString());
        tfUtsDot3Onu2CtcServiceSlaOperation.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcServiceSlaOperationVList, mbean.getUtsDot3Onu2CtcServiceSlaOperation().intValue()));
        tfUtsDot3Onu2CtcServiceSlaBestEffortSchedule.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcServiceSlaBestEffortScheduleVList, mbean.getUtsDot3Onu2CtcServiceSlaBestEffortSchedule().intValue()));
        tfUtsDot3Onu2CtcServiceSlaHighPriorityValue.setValue(mbean.getUtsDot3Onu2CtcServiceSlaHighPriorityValue().intValue());
        tfUtsDot3Onu2CtcServiceSlaCycleLength.setValue(mbean.getUtsDot3Onu2CtcServiceSlaCycleLength().intValue());
        //tfUtsDot3Onu2CtcServiceSlaServiceNumbers.setValue(mbean.getUtsDot3Onu2CtcServiceSlaServiceNumbers().intValue());
        //tfUtsDot3Onu2CtcServiceSlaQueue.setValue(mbean.getUtsDot3Onu2CtcServiceSlaQueue());
        tfUtsDot3Onu2CtcServiceSlaFixPktSize.setValue(mbean.getUtsDot3Onu2CtcServiceSlaFixPktSize());
        tfUtsDot3Onu2CtcServiceSlaFixBw.setValue(mbean.getUtsDot3Onu2CtcServiceSlaFixBw());
        tfUtsDot3Onu2CtcServiceSlaGuaranteedBw.setValue(mbean.getUtsDot3Onu2CtcServiceSlaGuaranteedBw());
        tfUtsDot3Onu2CtcServiceSlaBestEffortBw.setValue(mbean.getUtsDot3Onu2CtcServiceSlaBestEffortBw());
        tfUtsDot3Onu2CtcServiceSlaWrrWeight.setValue(mbean.getUtsDot3Onu2CtcServiceSlaWrrWeight());

        if(tfUtsDot3Onu2CtcServiceSlaBestEffortSchedule.getSelectedIndex() == 0) {
			tfUtsDot3Onu2CtcServiceSlaWrrWeight.setEnabled(0);
		}
		else {
			tfUtsDot3Onu2CtcServiceSlaWrrWeight.setEnabled(9);
		}
    }

    public void updateModel() {
        Onu2CtcServiceSlaTable mbean = (Onu2CtcServiceSlaTable) getModel();
        if (mbean == null)
            return;

        mbean.setUtsDot3Onu2CtcServiceSlaOperation(new Integer(utsDot3Onu2CtcServiceSlaOperationVList[tfUtsDot3Onu2CtcServiceSlaOperation.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcServiceSlaBestEffortSchedule(new Integer(utsDot3Onu2CtcServiceSlaBestEffortScheduleVList[tfUtsDot3Onu2CtcServiceSlaBestEffortSchedule.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcServiceSlaHighPriorityValue(new Integer(tfUtsDot3Onu2CtcServiceSlaHighPriorityValue.getValue()));
        mbean.setUtsDot3Onu2CtcServiceSlaCycleLength(new Integer(tfUtsDot3Onu2CtcServiceSlaCycleLength.getValue()));
        //mbean.setUtsDot3Onu2CtcServiceSlaServiceNumbers(new Integer(tfUtsDot3Onu2CtcServiceSlaServiceNumbers.getValue()));
        //mbean.setUtsDot3Onu2CtcServiceSlaQueue(tfUtsDot3Onu2CtcServiceSlaQueue.getValue());
        mbean.setUtsDot3Onu2CtcServiceSlaFixPktSize(tfUtsDot3Onu2CtcServiceSlaFixPktSize.getValue());
        mbean.setUtsDot3Onu2CtcServiceSlaFixBw(tfUtsDot3Onu2CtcServiceSlaFixBw.getValue());
        mbean.setUtsDot3Onu2CtcServiceSlaGuaranteedBw(tfUtsDot3Onu2CtcServiceSlaGuaranteedBw.getValue());
        mbean.setUtsDot3Onu2CtcServiceSlaBestEffortBw(tfUtsDot3Onu2CtcServiceSlaBestEffortBw.getValue());
        mbean.setUtsDot3Onu2CtcServiceSlaWrrWeight(tfUtsDot3Onu2CtcServiceSlaWrrWeight.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}