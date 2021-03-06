package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2DbaGlbTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Onu2TrafficProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Vector;

public class Onu2TrafficProfTablePanel extends UPanel {

    private JCheckBox cbDbaProfile = new JCheckBox();
    private ProfileChooser tfUtsDot3OnuAppliedDbaProfile = new ProfileChooser(fApplication);

    private IntegerTextField tfUtsDot3OnuUpstreamPir = new IntegerTextField();
    private IntegerTextField tfUtsDot3OnuDownstreamPir = new IntegerTextField();
    private IntegerTextField tfUtsDot3OnuUpstreamCir = new IntegerTextField();
    private IntegerTextField tfUtsDot3OnuDownstreamCir = new IntegerTextField();
    private IntegerTextField tfUtsDot3OnuUpstreamMaxBurstSize = new IntegerTextField();
    private IntegerTextField tfUtsDot3OnuDownstreamMaxBurstSize = new IntegerTextField();
    private IntegerTextField tfUtsDot3OnuUpstreamWeight = new IntegerTextField();
    private IntegerTextField tfUtsDot3OnuUpstreamFir = new IntegerTextField();
    
    private Vector dbaGlbValues = null;

    private final String utsDot3OnuAppliedDbaProfile = fStringMap.getString("utsDot3OnuAppliedDbaProfile") + ": ";

    private final String utsDot3OnuUpstreamPir = fStringMap.getString("utsDot3OnuUpstreamPir") + ": ";
    private final String utsDot3OnuDownstreamPir = fStringMap.getString("utsDot3OnuDownstreamPir") + ": ";
    private final String utsDot3OnuUpstreamCir = fStringMap.getString("utsDot3OnuUpstreamCir") + ": ";
    private final String utsDot3OnuDownstreamCir = fStringMap.getString("utsDot3OnuDownstreamCir") + ": ";
    private final String utsDot3OnuUpstreamMaxBurstSize = fStringMap.getString("utsDot3OnuUpstreamMaxBurstSize") + ": ";
    private final String utsDot3OnuDownstreamMaxBurstSize = fStringMap.getString("utsDot3OnuDownstreamMaxBurstSize") + ": ";
    private final String utsDot3OnuUpstreamWeight = fStringMap.getString("utsDot3OnuUpstreamWeight") + ": ";
    private final String utsDot3OnuUpstreamFir = fStringMap.getString("utsDot3OnuUpstreamFir") + ": ";

    public Onu2TrafficProfTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        cbDbaProfile.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuAppliedDbaProfile.setEnabled(cbDbaProfile.isSelected());

                tfUtsDot3OnuUpstreamPir.setEnabled(!cbDbaProfile.isSelected());
                tfUtsDot3OnuDownstreamPir.setEnabled(!cbDbaProfile.isSelected());
                tfUtsDot3OnuUpstreamCir.setEnabled(!cbDbaProfile.isSelected());
                tfUtsDot3OnuDownstreamCir.setEnabled(!cbDbaProfile.isSelected());
                tfUtsDot3OnuUpstreamMaxBurstSize.setEnabled(!cbDbaProfile.isSelected());
                tfUtsDot3OnuDownstreamMaxBurstSize.setEnabled(!cbDbaProfile.isSelected());
                tfUtsDot3OnuUpstreamWeight.setEnabled(!cbDbaProfile.isSelected());
                
                if(!cbDbaProfile.isSelected()) {
            		setUpstreamFirStatus();
            	}
                else {
                	tfUtsDot3OnuUpstreamFir.setEnabled(!cbDbaProfile.isSelected());
                }
            }
        });
        cbDbaProfile.setText(utsDot3OnuAppliedDbaProfile);
        tfUtsDot3OnuAppliedDbaProfile.setEnabled(false);
        baseInfoPanel.add(cbDbaProfile);
        tfUtsDot3OnuAppliedDbaProfile.setName(fStringMap.getString("utsDot3OnuAppliedDbaProfile"));
        baseInfoPanel.add(tfUtsDot3OnuAppliedDbaProfile);
        baseInfoPanel.add(new HSpacer());
        //set profile
        tfUtsDot3OnuAppliedDbaProfile.setEnabled(true);
        tfUtsDot3OnuAppliedDbaProfile.setProfile("OnuDbaProfileTable_Panel");

        baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamPir));
        tfUtsDot3OnuUpstreamPir.setName(fStringMap.getString("utsDot3OnuUpstreamPir"));
        baseInfoPanel.add(tfUtsDot3OnuUpstreamPir);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamPir));
        tfUtsDot3OnuDownstreamPir.setName(fStringMap.getString("utsDot3OnuDownstreamPir"));
        baseInfoPanel.add(tfUtsDot3OnuDownstreamPir);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamCir));
        tfUtsDot3OnuUpstreamCir.setName(fStringMap.getString("utsDot3OnuUpstreamCir"));
        baseInfoPanel.add(tfUtsDot3OnuUpstreamCir);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamCir));
        tfUtsDot3OnuDownstreamCir.setName(fStringMap.getString("utsDot3OnuDownstreamCir"));
        baseInfoPanel.add(tfUtsDot3OnuDownstreamCir);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamMaxBurstSize));
        tfUtsDot3OnuUpstreamMaxBurstSize.setName(fStringMap.getString("utsDot3OnuUpstreamMaxBurstSize"));
        baseInfoPanel.add(tfUtsDot3OnuUpstreamMaxBurstSize);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamMaxBurstSize));
        tfUtsDot3OnuDownstreamMaxBurstSize.setName(fStringMap.getString("utsDot3OnuDownstreamMaxBurstSize"));
        baseInfoPanel.add(tfUtsDot3OnuDownstreamMaxBurstSize);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamWeight));
        tfUtsDot3OnuUpstreamWeight.setName(fStringMap.getString("utsDot3OnuUpstreamWeight"));
        baseInfoPanel.add(tfUtsDot3OnuUpstreamWeight);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamFir));
        tfUtsDot3OnuUpstreamFir.setName(fStringMap.getString("utsDot3OnuUpstreamFir"));
        baseInfoPanel.add(tfUtsDot3OnuUpstreamFir);
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
        if (cbDbaProfile.isSelected())
            return true;

        if (tfUtsDot3OnuUpstreamCir.getValue() > tfUtsDot3OnuUpstreamPir.getValue()) {
            String error = fStringMap.getString("Err_Us_Cir_Greater_Than_Pir");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }

        if (tfUtsDot3OnuDownstreamCir.getValue() > tfUtsDot3OnuDownstreamPir.getValue()) {
            String error = fStringMap.getString("Err_Ds_Cir_Greater_Than_Pir");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }

        Onu2TrafficProfTable model = (Onu2TrafficProfTable) getModel();
        if (model == null)
            return false;

        int module = model.getUtsDot3OnuTProfModuleId();
        int port = model.getUtsDot3OnuTProfPortId();
        int onu = model.getUtsDot3OnuTProfLogicalPortId();

        int usTotalCommit = 0;
        int dsTotalCommit = 0;

        Onu2TrafficProfTable mbean = new Onu2TrafficProfTable(fApplication.getSnmpProxy());

        /* The port ifIndex is the previous row data. */
        mbean.setUtsDot3OnuTProfModuleId(model.getUtsDot3OnuTProfModuleId());
        mbean.setUtsDot3OnuTProfDeviceId(model.getUtsDot3OnuTProfDeviceId());
        mbean.setUtsDot3OnuTProfPortId(model.getUtsDot3OnuTProfPortId());
        mbean.setUtsDot3OnuTProfLogicalPortId(0);

        mbean.setRowsToFetch(64);
        Vector v = BeanService.refreshTableBean(fApplication, mbean);

        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                Onu2TrafficProfTable one = (Onu2TrafficProfTable) v.get(i);
                if (one.getUtsDot3OnuTProfModuleId() == module && one.getUtsDot3OnuTProfPortId() == port && one.getUtsDot3OnuTProfLogicalPortId() != onu)
                {
                    usTotalCommit += one.getUtsDot3OnuUpstreamCir();
                    dsTotalCommit += one.getUtsDot3OnuDownstreamCir();
                }
            }

            int usLeftCommit = 1000000 - usTotalCommit;
            int dsLeftCommit = 1000000 - dsTotalCommit;
            if (tfUtsDot3OnuUpstreamCir.getValue() > usLeftCommit) {
                String error = fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_1")
                        + module + "/" + port
                        + fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_2")
                        + "\r\n"
                        + fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_3")
                        + usLeftCommit
                        + fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_4");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }

            if (tfUtsDot3OnuDownstreamCir.getValue() > dsLeftCommit) {
                String error = fStringMap.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_1")
                        + module + "/" + port
                        + fStringMap.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_2")
                        + "\r\n"
                        + fStringMap.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_3")
                        + usLeftCommit
                        + fStringMap.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_4");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
        }

        return true;
    }
    
    private void setUpstreamFirStatus() {
    	Onu2TrafficProfTable mbean = (Onu2TrafficProfTable) getModel();
    	
    	for (int i = 0; dbaGlbValues!=null && i < dbaGlbValues.size(); i++) {
            Dot3Olt2DbaGlbTable dba = (Dot3Olt2DbaGlbTable) dbaGlbValues.get(i);
            if (dba.getUtsDot3OltModuleId().equals(mbean.getUtsDot3OnuTProfModuleId())) {
                if (dba.getUtsDot3OltDbaMode() != 2)
                    tfUtsDot3OnuUpstreamFir.setEnabled(false);
            }
        }
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfUtsDot3OnuAppliedDbaProfile.refresh();
            tfUtsDot3OnuAppliedDbaProfile.setSelectedProfileIndex(1);
            return;
        }

        Onu2TrafficProfTable mbean = (Onu2TrafficProfTable) getModel();
        if (mbean == null)
            return;

        if(dbaGlbValues!=null) dbaGlbValues.clear();
        
        Dot3Olt2DbaGlbTable bean = new Dot3Olt2DbaGlbTable(fApplication.getSnmpProxy());
        dbaGlbValues = BeanService.refreshTableBean(fApplication, bean);

        tfUtsDot3OnuUpstreamPir.setValue(mbean.getUtsDot3OnuUpstreamPir());
        tfUtsDot3OnuDownstreamPir.setValue(mbean.getUtsDot3OnuDownstreamPir());
        tfUtsDot3OnuUpstreamCir.setValue(mbean.getUtsDot3OnuUpstreamCir());
        tfUtsDot3OnuDownstreamCir.setValue(mbean.getUtsDot3OnuDownstreamCir());
        tfUtsDot3OnuUpstreamMaxBurstSize.setValue(mbean.getUtsDot3OnuUpstreamMaxBurstSize());
        tfUtsDot3OnuDownstreamMaxBurstSize.setValue(mbean.getUtsDot3OnuDownstreamMaxBurstSize());
        tfUtsDot3OnuUpstreamWeight.setValue(mbean.getUtsDot3OnuUpstreamWeight());
        tfUtsDot3OnuUpstreamFir.setValue(mbean.getUtsDot3OnuUpstreamFir());

        tfUtsDot3OnuAppliedDbaProfile.refresh();

        if(mbean.getUtsDot3OnuAppliedDbaProfile() != null && !mbean.getUtsDot3OnuAppliedDbaProfile().equals(0)) {
            tfUtsDot3OnuAppliedDbaProfile.setEnabled(true);
            cbDbaProfile.setSelected(true);
        } else {
            tfUtsDot3OnuAppliedDbaProfile.setEnabled(false);
            cbDbaProfile.setSelected(false);
        }
        tfUtsDot3OnuAppliedDbaProfile.setSelectedProfileIndex(mbean.getUtsDot3OnuAppliedDbaProfile());
        
    	
    	if(!cbDbaProfile.isSelected()) {
    		setUpstreamFirStatus();
    	}
        
    }

    public void updateModel() {
        Onu2TrafficProfTable mbean = (Onu2TrafficProfTable) getModel();
        if (mbean == null)
            return;

        if (cbDbaProfile.isSelected()) {
            if (tfUtsDot3OnuAppliedDbaProfile.isEnabled()) {
                mbean.setUtsDot3OnuAppliedDbaProfile(0); //clear selected profile
                try {
                    mbean.modify();
                } catch (MibBeanException e) {
                    e.printStackTrace();
                }
                mbean.setUtsDot3OnuAppliedDbaProfile(tfUtsDot3OnuAppliedDbaProfile.getSelectedProfileIndex() >= 0 ? ((int) tfUtsDot3OnuAppliedDbaProfile.getSelectedProfileIndex()) : 0);
            }
        } else {
            mbean.setUtsDot3OnuUpstreamPir(tfUtsDot3OnuUpstreamPir.getValue());
            mbean.setUtsDot3OnuDownstreamPir(tfUtsDot3OnuDownstreamPir.getValue());
            mbean.setUtsDot3OnuUpstreamCir(tfUtsDot3OnuUpstreamCir.getValue());
            mbean.setUtsDot3OnuDownstreamCir(tfUtsDot3OnuDownstreamCir.getValue());
            mbean.setUtsDot3OnuUpstreamMaxBurstSize(tfUtsDot3OnuUpstreamMaxBurstSize.getValue());
            mbean.setUtsDot3OnuDownstreamMaxBurstSize(tfUtsDot3OnuDownstreamMaxBurstSize.getValue());
            mbean.setUtsDot3OnuUpstreamWeight(tfUtsDot3OnuUpstreamWeight.getValue());
            if (tfUtsDot3OnuUpstreamFir.isEnabled() && tfUtsDot3OnuUpstreamFir.getValue() != mbean.getUtsDot3OnuUpstreamFir())
                mbean.setUtsDot3OnuUpstreamFir(tfUtsDot3OnuUpstreamFir.getValue());
            mbean.setUtsDot3OnuAppliedDbaProfile(0);
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}
