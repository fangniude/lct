package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing.OnuQueueWeightsPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2QoSTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

public class Dot3Onu2QoSTablePanel extends UPanel {

    private JLabel tfUtsDot3OnuModuleId = new JLabel();

//  private JLabel tfUtsDot3OnuDeviceId = new JLabel();

    private JLabel tfUtsDot3OnuPortId = new JLabel();

    private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();

    private int[] utsDot3OnuQoSModeVList = new int[]{
            2, 1,};
    private String[] utsDot3OnuQoSModeTList = new String[]{
            fStringMap.getString("dot1p"),
            fStringMap.getString("dscp"),
    };
    private JComboBox tfUtsDot3OnuQoSMode = new JComboBox(utsDot3OnuQoSModeTList);
//  private int[] utsDot3OnuAclClassifiEnableVList = new int[]{
//    1, 2, };
//  private String[] utsDot3OnuAclClassifiEnableTList = new String[]{
//    fStringMap.getString("true"),
//    fStringMap.getString("false"),
//  };
//  private JComboBox tfUtsDot3OnuAclClassifiEnable = new JComboBox(utsDot3OnuAclClassifiEnableTList);
    private int[] utsDot3OnuSchedulingModeVList = new int[]{
            1, 3, 2,};
    private String[] utsDot3OnuSchedulingModeTList = new String[]{
            fStringMap.getString("sp"),
            fStringMap.getString("hierarchical"),
            fStringMap.getString("wrr"),
    };
    private JComboBox tfUtsDot3OnuSchedulingMode = new JComboBox(utsDot3OnuSchedulingModeTList);
    private IntegerTextField tfUtsDot3OltSchedulingWeightRatio = new IntegerTextField();

    private JComboBox[] tfUtsDot3OnuDot1p2QueueMap = null;

    //value: 0 - 7
    private JComboBox[] tfUtsDot3OnuDscp2QueueMap = null;

//  private IntegerTextField tfUtsDot3OnuDefault802Dot1p = new IntegerTextField();
//
//  private IntegerTextField tfUtsDot3OnuDefaultDscp = new IntegerTextField();
//
//  private IntegerTextField tfUtsDot3OnuDefaultQueue = new IntegerTextField();

	private int[] utsDot3OnuShaperActionVList = new int[] { 3, 2, 1, };
	private String[] utsDot3OnuShaperActionTList = new String[] {
			fStringMap.getString("pir"), fStringMap.getString("cir"),
			fStringMap.getString("disable"), };
	private JComboBox tfUtsDot3OnuShaperAction = new JComboBox(
			utsDot3OnuShaperActionTList);
	private int[] utsDot3OnuPolicingActionVList = new int[] { 5, 4, 1, 2, 3, 6, };
	private String[] utsDot3OnuPolicingActionTList = new String[] {
			fStringMap.getString("drop-cir"),
			fStringMap.getString("mark-cir-drop-pir"),
			fStringMap.getString("disable"), fStringMap.getString("mark-cir"),
			fStringMap.getString("mark-pir"), fStringMap.getString("drop-pir"), };
	private JComboBox tfUtsDot3OnuUpsPolicingAction = new JComboBox(
			utsDot3OnuPolicingActionTList);
	private JComboBox tfUtsDot3OnuDownsPolicingAction = new JComboBox(
			utsDot3OnuPolicingActionTList);
    OnuQueueWeightsPanel queueWeightsPanel = null;

    private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + " : ";
//  private final String utsDot3OnuDeviceId = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
    private final String utsDot3OnuPortId5 = fStringMap.getString("utsDot3OnuPortId") + " : ";
    private final String utsDot3OnuLogicalPortId = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
    private final String utsDot3OnuQoSMode = fStringMap.getString("utsDot3OnuQoSMode") + " : ";
//  private final String utsDot3OnuAclClassifiEnable = fStringMap.getString("utsDot3OnuAclClassifiEnable") + " : ";
    private final String utsDot3OnuSchedulingMode = fStringMap.getString("utsDot3OnuSchedulingMode") + " : ";
    private final String utsDot3OltSchedulingWeightRatio = fStringMap.getString("utsDot3OltSchedulingWeightRatio") + " : ";
    private final String utsDot3OnuDot1p2QueueMap = fStringMap.getString("utsDot3OnuDot1p2QueueMap") + " : ";
    private final String utsDot3OnuDscp2QueueMap = fStringMap.getString("utsDot3OnuDscp2QueueMap") + " : ";
//  private final String utsDot3OnuDefault802Dot1p = fStringMap.getString("utsDot3OnuDefault802Dot1p") + " : ";
//  private final String utsDot3OnuDefaultDscp = fStringMap.getString("utsDot3OnuDefaultDscp") + " : ";
//  private final String utsDot3OnuDefaultQueue = fStringMap.getString("utsDot3OnuDefaultQueue") + " : ";
	private final String utsDot3OnuShaperAction = fStringMap.getString("utsDot3OnuShaperAction") + " : ";
	private final String utsDot3OnuUpsPolicingAction = fStringMap.getString("utsDot3OnuUpsPolicingAction") + " : ";
	private final String utsDot3OnuDownsPolicingAction = fStringMap.getString("utsDot3OnuDownsPolicingAction") + " : ";

    public Dot3Onu2QoSTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(10, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);

        baseInfoPanel.add(new JLabel(utsDot3OnuModuleId));
        baseInfoPanel.add(tfUtsDot3OnuModuleId);
        baseInfoPanel.add(new HSpacer());

//    baseInfoPanel.add(new JLabel(utsDot3OnuDeviceId));
//    baseInfoPanel.add(tfUtsDot3OnuDeviceId);
//    baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDot3OnuPortId5));
        baseInfoPanel.add(tfUtsDot3OnuPortId);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId));
        baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDot3OnuQoSMode));
        tfUtsDot3OnuQoSMode.setName("utsDot3OnuQoSMode");
        baseInfoPanel.add(tfUtsDot3OnuQoSMode);
        baseInfoPanel.add(new HSpacer());

//    baseInfoPanel.add(new JLabel(utsDot3OnuAclClassifiEnable));
//    tfUtsDot3OnuAclClassifiEnable.setName("utsDot3OnuAclClassifiEnable");
//    baseInfoPanel.add(tfUtsDot3OnuAclClassifiEnable);
//    baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDot3OnuSchedulingMode));
        tfUtsDot3OnuSchedulingMode.setName(fStringMap.getString("utsDot3OnuSchedulingMode"));
        baseInfoPanel.add(tfUtsDot3OnuSchedulingMode);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDot3OltSchedulingWeightRatio));
        tfUtsDot3OltSchedulingWeightRatio.setName(fStringMap.getString("utsDot3OltSchedulingWeightRatio"));
        baseInfoPanel.add(tfUtsDot3OltSchedulingWeightRatio);
        baseInfoPanel.add(new HSpacer());

//    baseInfoPanel.add(new JLabel(utsDot3OnuDefault802Dot1p));
//    tfUtsDot3OnuDefault802Dot1p.setName("utsDot3OnuDefault802Dot1p");
//    baseInfoPanel.add(tfUtsDot3OnuDefault802Dot1p);
//    baseInfoPanel.add(new HSpacer());

//    baseInfoPanel.add(new JLabel(utsDot3OnuDefaultDscp));
//    tfUtsDot3OnuDefaultDscp.setName("utsDot3OnuDefaultDscp");
//    baseInfoPanel.add(tfUtsDot3OnuDefaultDscp);
//    baseInfoPanel.add(new HSpacer());

//    baseInfoPanel.add(new JLabel(utsDot3OnuDefaultQueue));
//    tfUtsDot3OnuDefaultQueue.setName("utsDot3OnuDefaultQueue");
//    baseInfoPanel.add(tfUtsDot3OnuDefaultQueue);
//    baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuShaperAction));
		tfUtsDot3OnuShaperAction.setName(fStringMap.getString("utsDot3OnuShaperAction"));
		baseInfoPanel.add(tfUtsDot3OnuShaperAction);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpsPolicingAction));
		tfUtsDot3OnuUpsPolicingAction.setName(fStringMap.getString("utsDot3OnuUpsPolicingAction"));
		baseInfoPanel.add(tfUtsDot3OnuUpsPolicingAction);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuDownsPolicingAction));
		tfUtsDot3OnuDownsPolicingAction.setName(fStringMap.getString("utsDot3OnuDownsPolicingAction"));
		baseInfoPanel.add(tfUtsDot3OnuDownsPolicingAction);
		baseInfoPanel.add(new HSpacer());

        //802.1p2 Queue Map Panel
        JPanel dot1p2QueueMapPanel = new JPanel();
        NTLayout layout3 = new NTLayout(2, 8, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout3.setMargins(6, 10, 6, 10);
        dot1p2QueueMapPanel.setLayout(layout3);
        dot1p2QueueMapPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(utsDot3OnuDot1p2QueueMap)));

        String[] utsDot3OnuQueueMapVList = new String[8];
        for(int i = 0; i < utsDot3OnuQueueMapVList.length; i++) {
            utsDot3OnuQueueMapVList[i] = "" + i;
        }

        tfUtsDot3OnuDot1p2QueueMap = new JComboBox[8];
        for(int i = 0; i < tfUtsDot3OnuDot1p2QueueMap.length; i++) {
            tfUtsDot3OnuDot1p2QueueMap[i] = new JComboBox(utsDot3OnuQueueMapVList);

            dot1p2QueueMapPanel.add(new JLabel(fStringMap.getString("utsDot3OnuDot1p2QueueMapQueue") + i));
            dot1p2QueueMapPanel.add(tfUtsDot3OnuDot1p2QueueMap[i]);
        }

        //802.1p2 Queue Map Panel
        JPanel dscp2QueueMapPanel = new JPanel();
        NTLayout layout4 = new NTLayout(2, 8, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout4.setMargins(6, 10, 6, 10);
        dscp2QueueMapPanel.setLayout(layout4);
        dscp2QueueMapPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(utsDot3OnuDscp2QueueMap)));

        tfUtsDot3OnuDscp2QueueMap = new JComboBox[8];
        for(int i = 0; i < tfUtsDot3OnuDscp2QueueMap.length; i++) {
            tfUtsDot3OnuDscp2QueueMap[i] = new JComboBox(utsDot3OnuQueueMapVList);

            dscp2QueueMapPanel.add(new JLabel(fStringMap.getString("utsDot3OnuDscp2QueueMapQueue") + i));
            dscp2QueueMapPanel.add(tfUtsDot3OnuDscp2QueueMap[i]);
        }

        queueWeightsPanel = new OnuQueueWeightsPanel(fApplication);
        queueWeightsPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("utsDot3OnuQueueWeights")));

        JPanel allPanel = new JPanel();
        layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setBorder(BorderFactory.createEtchedBorder());
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(dot1p2QueueMapPanel);
        allPanel.add(dscp2QueueMapPanel);
        allPanel.add(queueWeightsPanel);
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfUtsDot3OltSchedulingWeightRatio.setValueScope(1, 7);
    }

    public void refresh() {

        Dot3Onu2QoSTable mbean = (Dot3Onu2QoSTable) getModel();

        tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
//    tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
        tfUtsDot3OnuPortId.setText(mbean.getUtsDot3OnuPortId().toString());
        tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
        tfUtsDot3OnuQoSMode.setSelectedIndex(getIndexFromValue(utsDot3OnuQoSModeVList, mbean.getUtsDot3OnuQoSMode().intValue()));
//    tfUtsDot3OnuAclClassifiEnable.setSelectedIndex(getIndexFromValue(utsDot3OnuAclClassifiEnableVList, mbean.getUtsDot3OnuAclClassifiEnable().intValue()));
        tfUtsDot3OnuSchedulingMode.setSelectedIndex(getIndexFromValue(utsDot3OnuSchedulingModeVList, mbean.getUtsDot3OnuSchedulingMode().intValue()));
        tfUtsDot3OltSchedulingWeightRatio.setValue(mbean.getUtsDot3OltSchedulingWeightRatio().intValue());
        setDot1p2QueueMap(mbean.getUtsDot3OnuDot1p2QueueMap());
        setDscp2QueueMap(mbean.getUtsDot3OnuDscp2QueueMap());
        queueWeightsPanel.setValue(mbean.getUtsDot3OnuQueueWeights());
//    tfUtsDot3OnuDefault802Dot1p.setValue(mbean.getUtsDot3OnuDefault802Dot1p().intValue());
//    tfUtsDot3OnuDefaultDscp.setValue(mbean.getUtsDot3OnuDefaultDscp().intValue());
//    tfUtsDot3OnuDefaultQueue.setValue(mbean.getUtsDot3OnuDefaultQueue().intValue());
        tfUtsDot3OnuShaperAction.setSelectedIndex(getIndexFromValue(utsDot3OnuShaperActionVList, mbean.getUtsDot3OnuShaperAction().intValue()));
        tfUtsDot3OnuUpsPolicingAction.setSelectedIndex(getIndexFromValue(utsDot3OnuPolicingActionVList, mbean.getUtsDot3OnuUpsPolicingAction().intValue()));
        tfUtsDot3OnuDownsPolicingAction.setSelectedIndex(getIndexFromValue(utsDot3OnuPolicingActionVList, mbean.getUtsDot3OnuDownsPolicingAction().intValue()));
    }

    public void updateModel() {
        Dot3Onu2QoSTable mbean = (Dot3Onu2QoSTable) getModel();

        mbean.setUtsDot3OnuQoSMode(new Integer(utsDot3OnuQoSModeVList[tfUtsDot3OnuQoSMode.getSelectedIndex()]));
//    mbean.setUtsDot3OnuAclClassifiEnable(new Integer(utsDot3OnuAclClassifiEnableVList[tfUtsDot3OnuAclClassifiEnable.getSelectedIndex()]));
        mbean.setUtsDot3OnuSchedulingMode(new Integer(utsDot3OnuSchedulingModeVList[tfUtsDot3OnuSchedulingMode.getSelectedIndex()]));
        mbean.setUtsDot3OltSchedulingWeightRatio(new Integer(tfUtsDot3OltSchedulingWeightRatio.getValue()));
        mbean.setUtsDot3OnuDot1p2QueueMap(getDot1p2QueueMap());
        mbean.setUtsDot3OnuDscp2QueueMap(getDscp2QueueMap());
        mbean.setUtsDot3OnuQueueWeights(queueWeightsPanel.getValue());
//    mbean.setUtsDot3OnuDefault802Dot1p(new Integer(tfUtsDot3OnuDefault802Dot1p.getValue()));
//    mbean.setUtsDot3OnuDefaultDscp(new Integer(tfUtsDot3OnuDefaultDscp.getValue()));
//    mbean.setUtsDot3OnuDefaultQueue(new Integer(tfUtsDot3OnuDefaultQueue.getValue()));
		mbean.setUtsDot3OnuShaperAction(new Integer(utsDot3OnuShaperActionVList[tfUtsDot3OnuShaperAction.getSelectedIndex()]));
		mbean.setUtsDot3OnuUpsPolicingAction(new Integer(utsDot3OnuPolicingActionVList[tfUtsDot3OnuUpsPolicingAction.getSelectedIndex()]));
		mbean.setUtsDot3OnuDownsPolicingAction(new Integer(utsDot3OnuPolicingActionVList[tfUtsDot3OnuDownsPolicingAction.getSelectedIndex()]));
    }

    private void setDot1p2QueueMap(byte[] queueMap) {
        setBitMap(tfUtsDot3OnuDot1p2QueueMap, queueMap);
    }

    private byte[] getDot1p2QueueMap() {
        return getBitMap(tfUtsDot3OnuDot1p2QueueMap);
    }

    private void setDscp2QueueMap(byte[] queueMap) {
        setBitMap(tfUtsDot3OnuDscp2QueueMap, queueMap);
    }

    private byte[] getDscp2QueueMap() {
        return getBitMap(tfUtsDot3OnuDscp2QueueMap);
    }

    private void setBitMap(JComboBox[] boxes, byte[] mibValue) {
        for(int i = 0; i < mibValue.length; i++) {
            boxes[i].setSelectedItem(Byte.toString(mibValue[i]));
        }
    }

    private byte[] getBitMap(JComboBox[] boxes) {
        byte[] b = new byte[boxes.length];
        for(int i = 0; i < boxes.length; i++) {
            b[i] = (byte) Integer.parseInt((String) boxes[i].getSelectedItem());
        }

        return b;
    }

    public int getIndexFromValue(int[] list, int v) {
        for(int i = 0; i != list.length; i++) {
            if(list[i] == v) return i;
        }
        return 0;
    }

}
