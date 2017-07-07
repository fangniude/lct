/**
 * Created by Zhou Chao, 2009/10/28
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r216;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r216.OnuDbaProfileTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OnuDbaProfileTablePanel extends UPanel {

    private IndexAutoGenField tfUtsDot3DbaProfileId = new IndexAutoGenField(fApplication, 1);
    private StringTextField tfUtsDot3DbaProfileName = new StringTextField();
    private IntegerTextField tfUtsDot3DbaProfileUpCir = new IntegerTextField();
    private IntegerTextField tfUtsDot3DbaProfileUpFir = new IntegerTextField();
    private IntegerTextField tfUtsDot3DbaProfileUpPir = new IntegerTextField();
    private IntegerTextField tfUtsDot3DbaProfileUpBurst = new IntegerTextField();
    private IntegerTextField tfUtsDot3DbaProfileUpPriority = new IntegerTextField();
    private IntegerTextField tfUtsDot3DbaProfileDownCir = new IntegerTextField();
    private IntegerTextField tfUtsDot3DbaProfileDownPir = new IntegerTextField();
    private IntegerTextField tfUtsDot3DbaProfileDownBurst = new IntegerTextField();

    private final String utsDot3DbaProfileId = fStringMap.getString("utsDot3DbaProfileId") + ": ";
    private final String utsDot3DbaProfileName = fStringMap.getString("utsDot3DbaProfileName") + ": ";
    private final String utsDot3DbaProfileUpCir = fStringMap.getString("utsDot3DbaProfileUpCir") + ": ";
    private final String utsDot3DbaProfileUpFir = fStringMap.getString("utsDot3DbaProfileUpFir") + ": ";
    private final String utsDot3DbaProfileUpPir = fStringMap.getString("utsDot3DbaProfileUpPir") + ": ";
    private final String utsDot3DbaProfileUpBurst = fStringMap.getString("utsDot3DbaProfileUpBurst") + ": ";
    private final String utsDot3DbaProfileUpPriority = fStringMap.getString("utsDot3DbaProfileUpPriority") + ": ";
    private final String utsDot3DbaProfileDownCir = fStringMap.getString("utsDot3DbaProfileDownCir") + ": ";
    private final String utsDot3DbaProfileDownPir = fStringMap.getString("utsDot3DbaProfileDownPir") + ": ";
    private final String utsDot3DbaProfileDownBurst = fStringMap.getString("utsDot3DbaProfileDownBurst") + ": ";

    public OnuDbaProfileTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(10, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3DbaProfileId));
        baseInfoPanel.add(tfUtsDot3DbaProfileId.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaProfileName));
        tfUtsDot3DbaProfileName.setName(fStringMap.getString("utsDot3DbaProfileName"));
        tfUtsDot3DbaProfileName.setValue("New Profile");
        baseInfoPanel.add(tfUtsDot3DbaProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaProfileUpCir));
        tfUtsDot3DbaProfileUpCir.setName(fStringMap.getString("utsDot3DbaProfileUpCir"));
        baseInfoPanel.add(tfUtsDot3DbaProfileUpCir);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaProfileUpFir));
        tfUtsDot3DbaProfileUpFir.setName(fStringMap.getString("utsDot3DbaProfileUpFir"));
        baseInfoPanel.add(tfUtsDot3DbaProfileUpFir);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaProfileUpPir));
        tfUtsDot3DbaProfileUpPir.setName(fStringMap.getString("utsDot3DbaProfileUpPir"));
        baseInfoPanel.add(tfUtsDot3DbaProfileUpPir);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaProfileUpBurst));
        tfUtsDot3DbaProfileUpBurst.setName(fStringMap.getString("utsDot3DbaProfileUpBurst"));
        baseInfoPanel.add(tfUtsDot3DbaProfileUpBurst);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaProfileUpPriority));
        tfUtsDot3DbaProfileUpPriority.setName(fStringMap.getString("utsDot3DbaProfileUpPriority"));
        baseInfoPanel.add(tfUtsDot3DbaProfileUpPriority);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaProfileDownCir));
        tfUtsDot3DbaProfileDownCir.setName(fStringMap.getString("utsDot3DbaProfileDownCir"));
        baseInfoPanel.add(tfUtsDot3DbaProfileDownCir);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaProfileDownPir));
        tfUtsDot3DbaProfileDownPir.setName(fStringMap.getString("utsDot3DbaProfileDownPir"));
        baseInfoPanel.add(tfUtsDot3DbaProfileDownPir);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3DbaProfileDownBurst));
        tfUtsDot3DbaProfileDownBurst.setName(fStringMap.getString("utsDot3DbaProfileDownBurst"));
        baseInfoPanel.add(tfUtsDot3DbaProfileDownBurst);
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
        tfUtsDot3DbaProfileId.setValueScope(0, 1, 128);

        tfUtsDot3DbaProfileUpCir.setValueScope(1, 1000000);
        tfUtsDot3DbaProfileUpCir.setValue(512);

        tfUtsDot3DbaProfileUpFir.setValueScope(0, 1000000);
        tfUtsDot3DbaProfileUpFir.setValue(0);

        tfUtsDot3DbaProfileUpPir.setValueScope(1, 1000000);
        tfUtsDot3DbaProfileUpPir.setValue(100000);

        tfUtsDot3DbaProfileUpBurst.setValueScope(1, 1000);
        tfUtsDot3DbaProfileUpBurst.setValue(100);

        tfUtsDot3DbaProfileUpPriority.setValueScope(1, 10);
        tfUtsDot3DbaProfileUpPriority.setValue(1);

        tfUtsDot3DbaProfileDownCir.setValueScope(1, 1000000);
        tfUtsDot3DbaProfileDownCir.setValue(512);

        tfUtsDot3DbaProfileDownPir.setValueScope(1, 1000000);
        tfUtsDot3DbaProfileDownPir.setValue(100000);

        tfUtsDot3DbaProfileDownBurst.setValueScope(1, 1000000);
        tfUtsDot3DbaProfileDownBurst.setValue(100);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfUtsDot3DbaProfileId.setEnabled(true);
            tfUtsDot3DbaProfileId.setTable(fTable);
            tfUtsDot3DbaProfileId.refresh();
            return;
        } else {
            tfUtsDot3DbaProfileId.setEnabled(false);
        }

        OnuDbaProfileTable mbean = (OnuDbaProfileTable) getModel();
        if (mbean == null)
            return;

        tfUtsDot3DbaProfileId.setValue(0, mbean.getUtsDot3DbaProfileId());
        tfUtsDot3DbaProfileName.setValue(mbean.getUtsDot3DbaProfileName() != null ? mbean.getUtsDot3DbaProfileName() : "");
        tfUtsDot3DbaProfileUpCir.setValue(mbean.getUtsDot3DbaProfileUpCir() != null ? mbean.getUtsDot3DbaProfileUpCir() : 512);
        tfUtsDot3DbaProfileUpFir.setValue(mbean.getUtsDot3DbaProfileUpFir() != null ? mbean.getUtsDot3DbaProfileUpFir() : 0);
        tfUtsDot3DbaProfileUpPir.setValue(mbean.getUtsDot3DbaProfileUpPir() != null ? mbean.getUtsDot3DbaProfileUpPir() : 100000);
        tfUtsDot3DbaProfileUpBurst.setValue(mbean.getUtsDot3DbaProfileUpBurst() != null ? mbean.getUtsDot3DbaProfileUpBurst() : 100);
        tfUtsDot3DbaProfileUpPriority.setValue(mbean.getUtsDot3DbaProfileUpPriority() != null ? mbean.getUtsDot3DbaProfileUpPriority() : 1);
        tfUtsDot3DbaProfileDownCir.setValue(mbean.getUtsDot3DbaProfileDownCir() != null ? mbean.getUtsDot3DbaProfileDownCir() : 512);
        tfUtsDot3DbaProfileDownPir.setValue(mbean.getUtsDot3DbaProfileDownPir() != null ? mbean.getUtsDot3DbaProfileDownPir() : 100000);
        tfUtsDot3DbaProfileDownBurst.setValue(mbean.getUtsDot3DbaProfileDownBurst() != null ? mbean.getUtsDot3DbaProfileDownBurst() : 100);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new OnuDbaProfileTable(fApplication.getSnmpProxy()));
        }

        OnuDbaProfileTable mbean = (OnuDbaProfileTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            mbean.setUtsDot3DbaProfileId((int) tfUtsDot3DbaProfileId.getValue(0));
        } else {
            if (MessageDialog.showConfirmDialog(fApplication, fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_cfm_set_dba_profile")) != JOptionPane.OK_OPTION)
                return;
        }
        mbean.setUtsDot3DbaProfileName(tfUtsDot3DbaProfileName.getValue());
        mbean.setUtsDot3DbaProfileUpCir(tfUtsDot3DbaProfileUpCir.getValue());
        mbean.setUtsDot3DbaProfileUpFir(tfUtsDot3DbaProfileUpFir.getValue());
        mbean.setUtsDot3DbaProfileUpPir(tfUtsDot3DbaProfileUpPir.getValue());
        mbean.setUtsDot3DbaProfileUpBurst(tfUtsDot3DbaProfileUpBurst.getValue());
        mbean.setUtsDot3DbaProfileUpPriority(tfUtsDot3DbaProfileUpPriority.getValue());
        mbean.setUtsDot3DbaProfileDownCir(tfUtsDot3DbaProfileDownCir.getValue());
        mbean.setUtsDot3DbaProfileDownPir(tfUtsDot3DbaProfileDownPir.getValue());
        mbean.setUtsDot3DbaProfileDownBurst(tfUtsDot3DbaProfileDownBurst.getValue());
    }

    public void afterUpdateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfUtsDot3DbaProfileId.increaseIndexValue();
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