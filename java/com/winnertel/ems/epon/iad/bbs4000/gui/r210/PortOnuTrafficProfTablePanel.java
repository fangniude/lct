package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.PortOnuTrafficProfTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class PortOnuTrafficProfTablePanel extends UPanel {
	private IntegerTextField tfUtsDot3OnuUpstreamPir = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuDownstreamPir = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuUpstreamCir = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuDownstreamCir = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuUpstreamMaxBurstSize = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuDownstreamMaxBurstSize = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuUpstreamWeight = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuUpstreamFir = new IntegerTextField();

	private int[] utsDot3OnuShaperActionVList = new int[] { 3, 2, 1, };
	private String[] utsDot3OnuShaperActionTList = new String[] {
			fStringMap.getString("pir"), fStringMap.getString("cir"),
			fStringMap.getString("disable"), };
	private JComboBox tfUtsDot3OnuShaperAction = new JComboBox(
			utsDot3OnuShaperActionTList);

  private int[] utsDot3OnuPolicingActionVList = new int[]{
    5, 4, 1, 2, 3, 6, };
  private String[] utsDot3OnuPolicingActionTList = new String[]{
    fStringMap.getString("drop-cir"),
    fStringMap.getString("mark-cir-drop-pir"),
    fStringMap.getString("disable"),
    fStringMap.getString("mark-cir"),
    fStringMap.getString("mark-pir"),
    fStringMap.getString("drop-pir"),
  };
  private JComboBox tfUtsDot3OnuUpsPolicingAction = new JComboBox(utsDot3OnuPolicingActionTList);
  private JComboBox tfUtsDot3OnuDownsPolicingAction = new JComboBox(utsDot3OnuPolicingActionTList);

	private final String utsDot3OnuUpstreamPir = fStringMap
			.getString("utsDot3OnuUpstreamPir")
			+ " : ";
	private final String utsDot3OnuDownstreamPir = fStringMap
			.getString("utsDot3OnuDownstreamPir")
			+ " : ";
	private final String utsDot3OnuUpstreamCir = fStringMap
			.getString("utsDot3OnuUpstreamCir")
			+ " : ";
	private final String utsDot3OnuDownstreamCir = fStringMap
			.getString("utsDot3OnuDownstreamCir")
			+ " : ";
	private final String utsDot3OnuUpstreamMaxBurstSize = fStringMap
			.getString("utsDot3OnuUpstreamMaxBurstSize")
			+ " : ";
	private final String utsDot3OnuDownstreamMaxBurstSize = fStringMap
			.getString("utsDot3OnuDownstreamMaxBurstSize")
			+ " : ";
	private final String utsDot3OnuUpstreamWeight = fStringMap
			.getString("utsDot3OnuUpstreamWeight")
			+ " : ";
	private final String utsDot3OnuUpstreamFir = fStringMap
			.getString("utsDot3OnuUpstreamFir")
			+ " : ";
	private final String utsDot3OnuShaperAction = fStringMap
			.getString("utsDot3OnuShaperAction")
			+ " : ";

  private final String utsDot3OnuUpsPolicingAction = fStringMap.getString("utsDot3OnuUpsPolicingAction") + " : ";
  private final String utsDot3OnuDownsPolicingAction = fStringMap.getString("utsDot3OnuDownsPolicingAction") + " : ";

  private JLabel[] labelList = new JLabel[4];
  private SnmpTable fTable = null;
  private int[] usCommitLeft = new int[4];
  private int[] dsCommitLeft = new int[4];
  private int[] selectedOnu = new int[4];

	public PortOnuTrafficProfTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {
		JPanel infoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 2, NTLayout.LEFT, NTLayout.CENTER, 5, 5);
		layout.setMargins(6, 10, 6, 10);
		infoPanel.setLayout(layout);
		infoPanel.setBorder(BorderFactory.createEtchedBorder());

    for(int i = 0; i < 4; i ++) {
      labelList[i] = new JLabel();
      infoPanel.add(labelList[i]);
      infoPanel.add(new HSpacer());
    }

    JPanel baseInfoPanel = new JPanel();
    layout = new NTLayout(11, 3, NTLayout.LEFT, NTLayout.CENTER,
        5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamPir));
		tfUtsDot3OnuUpstreamPir.setName(fStringMap
				.getString("utsDot3OnuUpstreamPir"));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamPir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamPir));
		tfUtsDot3OnuDownstreamPir.setName(fStringMap
				.getString("utsDot3OnuDownstreamPir"));
		baseInfoPanel.add(tfUtsDot3OnuDownstreamPir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamCir));
		tfUtsDot3OnuUpstreamCir.setName(fStringMap
				.getString("utsDot3OnuUpstreamCir"));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamCir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamCir));
		tfUtsDot3OnuDownstreamCir.setName(fStringMap
				.getString("utsDot3OnuDownstreamCir"));
		baseInfoPanel.add(tfUtsDot3OnuDownstreamCir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamMaxBurstSize));
		tfUtsDot3OnuUpstreamMaxBurstSize.setName(fStringMap
				.getString("utsDot3OnuUpstreamMaxBurstSize"));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamMaxBurstSize);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamMaxBurstSize));
		tfUtsDot3OnuDownstreamMaxBurstSize.setName(fStringMap
				.getString("utsDot3OnuDownstreamMaxBurstSize"));
		baseInfoPanel.add(tfUtsDot3OnuDownstreamMaxBurstSize);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamWeight));
		tfUtsDot3OnuUpstreamWeight.setName(fStringMap
				.getString("utsDot3OnuUpstreamWeight"));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamWeight);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamFir));
		tfUtsDot3OnuUpstreamFir.setName(fStringMap
				.getString("utsDot3OnuUpstreamFir"));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamFir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuShaperAction));
		tfUtsDot3OnuShaperAction.setName(fStringMap
				.getString("utsDot3OnuShaperAction"));
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

		JPanel allPanel = new JPanel();
		layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
    allPanel.add(infoPanel);
    allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);
	}

	protected void initForm() {
		tfUtsDot3OnuUpstreamPir.setValueScope(1, 1000000);
		tfUtsDot3OnuDownstreamPir.setValueScope(1, 1000000);
		tfUtsDot3OnuUpstreamCir.setValueScope(1, 1000000);
		tfUtsDot3OnuDownstreamCir.setValueScope(1, 1000000);
		tfUtsDot3OnuUpstreamMaxBurstSize.setValueScope(1, 1000);
		tfUtsDot3OnuDownstreamMaxBurstSize.setValueScope(1, 1000);
		tfUtsDot3OnuUpstreamWeight.setValueScope(1, 10);
		tfUtsDot3OnuUpstreamFir.setValueScope(0, 1000000);
	}

	public boolean validateFrom() {
		if (tfUtsDot3OnuUpstreamCir.getValue() > tfUtsDot3OnuUpstreamPir
				.getValue()) {
			String error = fStringMap.getString("Err_Us_Cir_Greater_Than_Pir");
			MessageDialog.showErrorMessageDialog(fApplication, error);
			return false;
		}

		if (tfUtsDot3OnuDownstreamCir.getValue() > tfUtsDot3OnuDownstreamPir
				.getValue()) {
			String error = fStringMap.getString("Err_Ds_Cir_Greater_Than_Pir");
			MessageDialog.showErrorMessageDialog(fApplication, error);
			return false;
		}

		//
    PortOnuTrafficProfTable mbean = (PortOnuTrafficProfTable) getModel();
    StringBuffer sb = new StringBuffer();

    for(int i = 0; i < selectedOnu.length; i++) {
      if (tfUtsDot3OnuUpstreamCir.getValue() * selectedOnu[i] > usCommitLeft[i]) {
        String error = fStringMap
            .getString("Err_Total_Committed_Bandwidth_Exceed_Limit_1")
            + mbean.getUtsDot3OnuTProfModuleId()
            + "/"
            + (i+1)
            + fStringMap
                .getString("Err_Total_Committed_Bandwidth_Exceed_Limit_2")
            + "\r\n"
            + fStringMap
                .getString("Err_Total_Committed_Bandwidth_Exceed_Limit_3")
            + usCommitLeft[i]
            + fStringMap
                .getString("Err_Total_Committed_Bandwidth_Exceed_Limit_4");

        sb.append(error).append("\r\n");
      }

      if (tfUtsDot3OnuDownstreamCir.getValue() * selectedOnu[i] > dsCommitLeft[i]) {
        String error = fStringMap
            .getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_1")
            + mbean.getUtsDot3OnuTProfModuleId()
            + "/"
            + (i+1)
            + fStringMap
                .getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_2")
            + "\r\n"
            + fStringMap
                .getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_3")
            + dsCommitLeft[i]
            + fStringMap
                .getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_4");

        sb.append(error).append("\r\n");
      }

    }

    if(sb.toString().length() > 1) {
      MessageDialog.showErrorMessageDialog(fApplication, sb.toString());

      return false;
    }

    return true;
	}

	public void refresh() {

		PortOnuTrafficProfTable mbean = (PortOnuTrafficProfTable) getModel();

		tfUtsDot3OnuUpstreamPir.setValue(mbean.getUtsDot3OnuUpstreamPir()
				.intValue());
		tfUtsDot3OnuDownstreamPir.setValue(mbean.getUtsDot3OnuDownstreamPir()
				.intValue());
		tfUtsDot3OnuUpstreamCir.setValue(mbean.getUtsDot3OnuUpstreamCir()
				.intValue());
		tfUtsDot3OnuDownstreamCir.setValue(mbean.getUtsDot3OnuDownstreamCir()
				.intValue());
		tfUtsDot3OnuUpstreamMaxBurstSize.setValue(mbean
				.getUtsDot3OnuUpstreamMaxBurstSize().intValue());
		tfUtsDot3OnuDownstreamMaxBurstSize.setValue(mbean
				.getUtsDot3OnuDownstreamMaxBurstSize().intValue());
		tfUtsDot3OnuUpstreamWeight.setValue(mbean.getUtsDot3OnuUpstreamWeight()
				.intValue());
		tfUtsDot3OnuUpstreamFir.setValue(mbean.getUtsDot3OnuUpstreamFir()
				.intValue());
		tfUtsDot3OnuShaperAction.setSelectedIndex(getIndexFromValue(
				utsDot3OnuShaperActionVList, mbean.getUtsDot3OnuShaperAction()
						.intValue()));
    tfUtsDot3OnuUpsPolicingAction.setSelectedIndex(getIndexFromValue(utsDot3OnuPolicingActionVList, mbean.getUtsDot3OnuUpsPolicingAction().intValue()));
    tfUtsDot3OnuDownsPolicingAction.setSelectedIndex(getIndexFromValue(utsDot3OnuPolicingActionVList, mbean.getUtsDot3OnuDownsPolicingAction().intValue()));


    //
    int[] rows = fTable.getSelectedRows();
    int cursor = 0;
    SnmpTableModel model = (SnmpTableModel) fTable.getModel();

    //4 port.
    int ratio = new BBS4000NE(fApplication).getPonSplitRatio();
    for(int i  = 0; i < 4; i++) {
      int count = 0;

      while(cursor < rows.length){
        if(rows[cursor] < (i+1) * ratio) {
          count++;
          cursor++;
        }
        else {
          break;
        }
      }

      int usTotalCommit = 0;
      int dsTotalCommit = 0;

      int index = i * ratio;
      for(int j = 0; j < ratio; j++) {
        if(!fTable.isRowSelected(index + j)){
          PortOnuTrafficProfTable one = (PortOnuTrafficProfTable)model.getRow(index + j);

          usTotalCommit += one.getUtsDot3OnuUpstreamCir().intValue();
          dsTotalCommit += one.getUtsDot3OnuDownstreamCir().intValue();
        }
      }

      selectedOnu[i] = count;
      usCommitLeft[i] = 1000000 - usTotalCommit;
      dsCommitLeft[i] = 1000000 - dsTotalCommit;
      StringBuffer sb = new StringBuffer();
      sb.append(mbean.getUtsDot3OnuTProfModuleId()).append("/").append(i+1)
          .append(": \t").append(selectedOnu[i]).append(fStringMap.getString(" ONUs Selected, Upstream: "))
          .append(usCommitLeft[i]).append(fStringMap.getString("K Left, Downstream: ")).append(dsCommitLeft[i]).
          append(fStringMap.getString("K Left."));

      labelList[i].setText(sb.toString());
    }
  }

	public void updateModel() {
		PortOnuTrafficProfTable mbean = (PortOnuTrafficProfTable) getModel();

		mbean.setUtsDot3OnuUpstreamPir(new Integer(tfUtsDot3OnuUpstreamPir
				.getValue()));
		mbean.setUtsDot3OnuDownstreamPir(new Integer(tfUtsDot3OnuDownstreamPir
				.getValue()));
		mbean.setUtsDot3OnuUpstreamCir(new Integer(tfUtsDot3OnuUpstreamCir
				.getValue()));
		mbean.setUtsDot3OnuDownstreamCir(new Integer(tfUtsDot3OnuDownstreamCir
				.getValue()));
		mbean.setUtsDot3OnuUpstreamMaxBurstSize(new Integer(
				tfUtsDot3OnuUpstreamMaxBurstSize.getValue()));
		mbean.setUtsDot3OnuDownstreamMaxBurstSize(new Integer(
				tfUtsDot3OnuDownstreamMaxBurstSize.getValue()));
		mbean.setUtsDot3OnuUpstreamWeight(new Integer(
				tfUtsDot3OnuUpstreamWeight.getValue()));
		mbean.setUtsDot3OnuUpstreamFir(new Integer(tfUtsDot3OnuUpstreamFir
				.getValue()));
		mbean.setUtsDot3OnuShaperAction(new Integer(
				utsDot3OnuShaperActionVList[tfUtsDot3OnuShaperAction
						.getSelectedIndex()]));
    mbean.setUtsDot3OnuUpsPolicingAction(new Integer(utsDot3OnuPolicingActionVList[tfUtsDot3OnuUpsPolicingAction.getSelectedIndex()]));
    mbean.setUtsDot3OnuDownsPolicingAction(new Integer(utsDot3OnuPolicingActionVList[tfUtsDot3OnuDownsPolicingAction.getSelectedIndex()]));
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

  public void setTable(SnmpTable table) {
    fTable = table;
  }

  public SnmpTable getTable() {
    return fTable;
  }
}
